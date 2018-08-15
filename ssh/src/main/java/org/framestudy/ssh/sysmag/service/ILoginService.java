package org.framestudy.ssh.sysmag.service;

import java.util.List;

public interface ILoginService {

	List<?> listUserBeanByLoginNameAndPassword(String loginName,String password);
}
