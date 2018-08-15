package org.framestudy.ssh.usermag.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.framestudy.ssh.bean.MessagerBean;
import org.framestudy.ssh.bean.PagerBean;
import org.framestudy.ssh.bean.UserBean;
import org.framestudy.ssh.usermag.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/users")
@Controller
public class UserController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private IUserService userServiceImpl;
	
	
	
	
	
	@RequestMapping(value="/form",method= {RequestMethod.DELETE})
	public String deleteUserBeanFromForm(UserBean user) {
		log.info(user);
		try {
			userServiceImpl.deleteUserBean(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("UserController----deleteUserBeanFromForm()", e);
		}
		return "index";
	}
	
	
	@RequestMapping(value="/form",method= {RequestMethod.PUT})
	public String updateUserBeanFromForm(UserBean user) {
		log.info(user);
		try {
			user.setUpdateTime(new Date());
			userServiceImpl.updateUserBean(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("UserController----updateUserBeanFromForm()", e);
		}
		return "index";
	}
	
	
	@RequestMapping(value="/page",method= {RequestMethod.GET},produces= {"application/json;charset=utf-8"})
	public @ResponseBody PagerBean listUserBeanByParams2PagerBean(String userName,int page,int rows) {
		log.info(userName);
		log.info(page);
		log.info(rows);
		
		Map params = new HashMap();
		params.put("userName", userName);
		PagerBean pager = new PagerBean(page, rows);
		try {
			pager = userServiceImpl.listUserBeanByParams2PagerBean(params, pager);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("UserController----listUserBeanByParams2PagerBean()", e);
		}
		return pager;
	}
	
	
	
	
	@RequestMapping(value="/{userName}/{loginName}",method= {RequestMethod.GET},produces= {"application/json;charset=utf-8"})
	public @ResponseBody List<UserBean> listUserBeanByObject(UserBean user){
		log.info(user);
		List<UserBean> users = null;
		try {
			users = (List<UserBean>) userServiceImpl.listUserBeanByObject(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("UserController----listUserBeanByObject()", e);
		}
		return users;
	}
	
	
	
	
	@RequestMapping(value="/{id}",method= {RequestMethod.DELETE},produces= {"application/json;charset=utf-8"})
	public @ResponseBody MessagerBean deleteUserBean(UserBean user) {
		log.info(user);
		MessagerBean msg = new MessagerBean(true, "操作成功");
		try {
			userServiceImpl.deleteUserBean(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("UserController----deleteUserBean()", e);
			msg.setStatus(false);
			msg.setInformation("系统繁忙，请稍后重试！");
		}
		return msg;
	}
	
	
	
	@RequestMapping(value="/{id}",method= {RequestMethod.PUT},produces= {"application/json;charset=utf-8"})
	public @ResponseBody MessagerBean updateUserBean(UserBean user) {
		log.info(user);
		MessagerBean msg = new MessagerBean(true, "操作成功");
		try {
			user.setUpdateTime(new Date());
			userServiceImpl.updateUserBean(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("UserController----updateUserBean()", e);
			msg.setStatus(false);
			msg.setInformation("系统繁忙，请稍后重试！");
		}
		return msg;
	}
	
	
	@RequestMapping(value="/{id}",method= {RequestMethod.GET},produces= {"application/json;charset=utf-8"})
	public @ResponseBody UserBean getUserBeanById(@PathVariable("id")Long id) {
		log.info(id);
		UserBean user = null;
		try {
			user = userServiceImpl.getUserBeanById(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("UserController----getUserBeanById()", e);
		}
		return user;
	}
	
	
	
	@RequestMapping(value="/{id}",method= {RequestMethod.POST},produces= {"application/json;charset=utf-8"})
	public @ResponseBody MessagerBean saveUserBean(UserBean user) {
		log.info(user);
		MessagerBean msg = new MessagerBean(true, "操作成功");
		try {
			user.setId(null);
			user.setCreateTime(new Date());
			userServiceImpl.saveUserBean(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("UserController----saveUserBean()", e);
			msg.setStatus(false);
			msg.setInformation("系统繁忙，请稍后重试！");
		}
		return msg;
	}
	
	
	
	
	
	
	
	
	
}
