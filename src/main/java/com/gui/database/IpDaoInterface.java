package com.gui.database;

import com.gui.entities.Ip;

/**
 * Interface used for the interactions with ip database and used outside packaging com.gui.database
 */
public interface IpDaoInterface {
	/**
	 * create new ip
	 * @param ip, type Ip
	 */
	void create( Ip ip );
}
