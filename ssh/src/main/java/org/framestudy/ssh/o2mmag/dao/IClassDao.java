package org.framestudy.ssh.o2mmag.dao;

import java.util.List;

import org.framestudy.ssh.o2mmag.ClassBean;

public interface IClassDao {

	void saveClassBean(ClassBean cls);
	
	void updateClassBean(ClassBean cls);
	
	ClassBean getClassBeanById(Long id);
	
	List<?> listClassBeanByStudentName(String studentName);
}
