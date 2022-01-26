package com.gui.beans.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import com.gui.beans.session.UserSession;
import com.gui.database.DatabaseFactory;
import com.gui.database.UserDaoInterface;
import com.gui.entities.Ip;
import com.gui.entities.User;

/**
 * <h1>List of IP address view</h1>
 * <p>Display a List of the user IP address that are already allowed</p>
 */
@Named
@ViewScoped
public class IpAddressList implements Serializable {

	private static final long serialVersionUID = -6592093429563042655L;

	private List<Ip> ips = new ArrayList<>();
	
	@Inject
	private DatabaseFactory db;
	
	@Inject
	private UserSession session;
	
	/**
     * Initialize list of IP from ip table of the database
     */
    @PostConstruct
    public void init() {
    	User user = session.getUser();
    	UserDaoInterface dao = db.getUserDAO();
    	Optional<User> opt = dao.getUserById( user.getId() );
    	System.out.println( "size :: " + opt.get().getIps().size() );
    	opt.ifPresent( userX -> ips = userX.getIps() );
    }
	
	/***************************************************************************
	 |  Getter & Setter
	***************************************************************************/
    
    /**
     * Get the List of IPs
     * @return List of IPs
     */
	public List<Ip> getIps() {
		return ips;
	}

	/**
     * Set the ip list
     * @param ips, List of IPs
     */
	public void setIps(List<Ip> ips) {
		this.ips = ips;
	}
	
	/**
	 * Add ip to ips list and update the list
	 * @param ip, Ip type
	 */
	public void addIp(Ip ip) {
        this.ips.add(ip);
        PrimeFaces.current().ajax().update("ipList");
    }
}
