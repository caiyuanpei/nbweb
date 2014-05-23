package cn.edu.hmu.bstc.nbweb.services;

import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.hmu.bstc.gconvertor.IGeneConvertor;
import cn.edu.hmu.bstc.gconvertor.IGeneConvertor.EGeneType;
import cn.edu.hmu.bstc.yhxutils.rconnmgr.RConnAutoManage;
import cn.edu.hmu.bstc.yhxutils.rconnmgr.RConnManager;

@Service
public class SimpleService implements IService {
	
	@Autowired
	private IGeneConvertor geneConvertor;
	
	@Override
	@RConnAutoManage
	public String doOnePlusOne() throws Exception {
		RConnection conn = RConnManager.instance().get();
		String val = conn.eval("1+3").asString();
		
		String cvtResult = geneConvertor.convert("ENSG00000211521", EGeneType.ENSEMBLID);
		
		return val + ";" + cvtResult;
	}
}