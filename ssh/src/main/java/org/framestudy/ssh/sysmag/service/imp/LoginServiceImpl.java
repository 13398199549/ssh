package org.framestudy.ssh.sysmag.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.framestudy.ssh.sysmag.dao.ILoginDao;
import org.framestudy.ssh.sysmag.service.ILoginService;
import org.springframework.stereotype.Service;
@Service
public class LoginServiceImpl implements ILoginService {

	@Resource
	private ILoginDao loginDaoImpl;
	
	@Override
	public List<?> listUserBeanByLoginNameAndPassword(String loginName, String password) {
		// TODO Auto-generated method stub
		return loginDaoImpl.listUserBeanByLoginNameAndPassword(loginName, password);
	}

}
