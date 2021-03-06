package org.framestudy.ssh.m2mmag.dao;

import java.util.List;

import org.framestudy.ssh.m2mmag.GameBean;

public interface IGameDao {

	void saveGame(GameBean game);
	
	GameBean getGameBeanById(Long id);
	
	List<?> listGameBeanByPlayerName(String playerName);
	
}
