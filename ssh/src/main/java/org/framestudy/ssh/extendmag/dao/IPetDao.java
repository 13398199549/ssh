package org.framestudy.ssh.extendmag.dao;

import java.util.List;

import org.framestudy.ssh.extendmag.DogBean;

public interface IPetDao {

	void saveDog(DogBean dog);
	
	void updateDog(DogBean dog);
	
	void deleteDog(DogBean dog);
	
	DogBean getDogBeanById(Long id);
	
	List<?> listAllPet();
	
	List<?> listPetBeanByPetName(String petName);
	
}
