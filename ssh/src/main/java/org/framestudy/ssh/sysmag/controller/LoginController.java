package org.framestudy.ssh.sysmag.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.framestudy.ssh.bean.UserBean;
import org.framestudy.ssh.sysmag.service.ILoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sysmag")
@Controller
public class LoginController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private ILoginService loginServiceImpl;
	
	@RequestMapping(value="/login")
	public String login(String loginName,String password) {
		
		log.info(loginName);
		log.info(password);
		
		try {
			List<?> users = loginServiceImpl.listUserBeanByLoginNameAndPassword(loginName, password);
			if(users != null) {
				UserBean user = (UserBean) users.get(0);
				System.out.println(user);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("LoginController----login()",e);
		}
		
		return "layout/main";
	}
	
	
	
	
	
}
