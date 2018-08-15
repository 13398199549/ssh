package org.framestudy.ssh.sysmag.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.framestudy.ssh.sysmag.dao.ILoginDao;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDaoImpl implements ILoginDao {

	@Resource
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public List<?> listUserBeanByLoginNameAndPassword(String loginName, String password) {
		// TODO Auto-generated method stub
		String hql = "from UserBean as u where u.loginName = ? and u.password = ?";
		return hibernateTemplate.find(hql, new Object[] {loginName,password});
	}

}
