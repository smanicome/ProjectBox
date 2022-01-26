package com.gui.beans.forms;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.gui.beans.session.UserSession;
import com.gui.beans.view.IpAddressList;
import com.gui.database.DatabaseFactory;
import com.gui.entities.Ip;

/**
 * <h1>Create IP Bean</h1>
 * <p>Bean that allows student to add a new IP for the fire-wall</p>
 */
@Named
@RequestScoped
public class CreateIpAddress implements Serializable {

	private static final long serialVersionUID = -5532771448591001729L;
	
	@Inject
	private DatabaseFactory db;
	
	@Inject
	private UserSession session;
	
	@Inject
	private IpAddressList ipsList;

	private String address;
	
	/***************************************************************************
	 |  Getter & Setter
	***************************************************************************/

	/**
	 * Getter of IP address in the form
	 * @return the IP address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Setter of IP address in the form
	 * @param address, String
	 */
	public void setAddress(String address) {
		System.out.println( "set add" );
		this.address = address;
	}
	
	/***************************************************************************
	 |  Action & Listener
	***************************************************************************/

	/**
	 * Add the Ip the database and refresh the list
	 */
	public String save() {
		if ( address != null ) {
			Ip newIP = new Ip( address, session.getUser() );
			db.getIpDao().create( newIP );
			ipsList.addIp( newIP );
			System.out.println( "set null" );
			address = null;
		}
		return "added";
	}
}
