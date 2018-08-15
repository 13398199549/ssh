package org.framestudy.ssh.usermag.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.framestudy.ssh.bean.PagerBean;
import org.framestudy.ssh.bean.UserBean;
import org.framestudy.ssh.usermag.dao.IUserDao;
import org.framestudy.ssh.usermag.service.IUserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
/**
 * @Cacheable 主要用于缓存数据，方法在第一次调用的时候，
 * 会默认将返回结果以KV键值对结构的方式，存储在对应的缓存空间中。
 * 默认情况下，key是方法传入的参数，或者是参数的组合。但是也可以
 * 自定义， 自定义的方式采用"#参数名"或者是"#p参数下标(第一个下标是0)"来完成对
 * key的设置
 * 
 * 方法在后续调用的时候，如果根据key直接从缓存空间中，已经查找到数据了，那么
 * 将不再执行方法体内部的内容。
 * 
 * 
 * condition这个属性，可以设置缓存条件，如:"#id % 2 == 0"，这个就表示我只缓存
 * id是偶数的数据
 * 
 * 该注解通常定义在查询方法上
 */

@Cacheable(value= {"userCache"})
@Service
public class UserServiceImpl implements IUserService {

	@Resource
	private IUserDao userDaoImpl;
	/**
	 * @CachePut 相当于对缓存进行新增，或者是修改，该方法在执行时，不会
	 * 检查缓存空间，而是直接对方法体内容进行执行，但是会将执行后的结果
	 * 以KV键值对结构来进行缓存
	 * 
	 * 同样用于key、condition属性，用法同上
	 * 
	 * 该注解通常定义在新增，修改方法上
	 * 
	 */
	@CachePut(value="userCache")
	@Override
	public UserBean saveUserBean(UserBean user) {
		// TODO Auto-generated method stub
		userDaoImpl.saveUserBean(user);
		return user;
	}

	@CachePut(value="userCache")
	@Override
	public UserBean updateUserBean(UserBean user) {
		// TODO Auto-generated method stub
		userDaoImpl.updateUserBean(user);
		return user;
	}
	/**
	 * @CacheEvict 该注解的作用：主要用于清理缓存
	 * allEntries=false 是否清理所有的数据
	 * beforeInvocation=true 在方法体内容执行之前，就去清理对应的缓存
	 * 
	 * 该注解通常定义在删除方法上
	 */
	@CacheEvict(value="userCache",allEntries=false,key="#user",beforeInvocation=true)
	@Override
	public void deleteUserBean(UserBean user) {
		// TODO Auto-generated method stub
		userDaoImpl.deleteUserBean(user);
	}

	
	
	@Override
	public UserBean getUserBeanById(Long id) {
		// TODO Auto-generated method stub
		return userDaoImpl.getUserBeanById(id);
	}

	@Override
	public UserBean loadUserBeanById(Long id) {
		// TODO Auto-generated method stub
		return userDaoImpl.loadUserBeanById(id);
	}

	
	
	@Override
	public List<?> listUserBeanByUserNameAndLoginName(String userName, String loginName) {
		// TODO Auto-generated method stub
		return userDaoImpl.listUserBeanByUserNameAndLoginName(userName, loginName);
	}
	
	@Override
	public List<?> listUserBeanByObject(UserBean user) {
		// TODO Auto-generated method stub
		return userDaoImpl.listUserBeanByObject(user);
	}

	@Override
	public List<?> listUserBeanByParams(Map params) {
		// TODO Auto-generated method stub
		return userDaoImpl.listUserBeanByParams(params);
	}
	
	@Override
	public PagerBean listUserBeanByParams2PagerBean(Map params,PagerBean pager) {
		// TODO Auto-generated method stub
		return userDaoImpl.listUserBeanByParams2PagerBean(params, pager);
	}
	
	@Cacheable(value= {"userCache"})
	@Override
	public PagerBean listUserBeanByParmas2PagerBean4CriteriaDemo(Map params, PagerBean pager) {
		// TODO Auto-generated method stub
		return userDaoImpl.listUserBeanByParmas2PagerBean4CriteriaDemo(params, pager);
	}

	@Override
	public List<?> listUserBeanByIdcard(String idcard) {
		// TODO Auto-generated method stub
		return userDaoImpl.listUserBeanByIdcard(idcard);
	}

}
