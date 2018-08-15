package org.framestudy.ssh.o2omag.service;

import java.util.List;
import java.util.Map;

import org.framestudy.ssh.bean.PagerBean;
import org.framestudy.ssh.o2omag.HusbandBean;

public interface IHusbandService {

	void saveHusband(HusbandBean husband); 
	
	void udpateHusband(HusbandBean husband); 
	
	void deleteHusband(HusbandBean husband); 
	
	HusbandBean getHusbandById(String id);
	
	List<?> listHusbandByWifeName(String wifeName);
	
	PagerBean listHusbandByParams2PagerBean(Map params,PagerBean pager);
	
	
	
}
