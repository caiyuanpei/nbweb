package cn.edu.hmu.bstc.nbweb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.hmu.bstc.nbweb.services.IService;

@Controller
public class IndexController {

	@Autowired
	private IService simpleService;
	
	@RequestMapping(
			value="index",
			method=RequestMethod.GET)
	@ResponseBody
	public String index() throws Exception {
		
		String ret = simpleService.doOnePlusOne();
		
		return ret;
	}
}
