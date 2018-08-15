package org.framestudy.ssh.sysmag.dao;

import java.util.List;

public interface ILoginDao {

	List<?> listUserBeanByLoginNameAndPassword(String loginName,String password);
}
