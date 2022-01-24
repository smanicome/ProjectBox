package com.gui.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.gui.beans.session.UserSession;
import com.gui.entities.User;

@Named
@ApplicationScoped
public class Menu implements Serializable {

	private static final long serialVersionUID = 301448819974058968L;
	public class Item {
		private String name;
		private String link;
		
		private Item( String name, String link ) {
			this.name = name;
			this.link = link;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getLink() {
			return link;
		}
		public void setLink(String link) {
			this.link = link;
		}
	}
	@Inject
	private UserSession session;
	private Collection<Item> teacherMenu = new ArrayList<>();
	private Collection<Item> studentMenu = new ArrayList<>();
	private Collection<Item> menu = null;

	@PostConstruct
	public void initialize() {
		
		//TODO :: replace with link
		teacherMenu.add( new Item( "Account Settings", "change_account_settings.xhtml") );
		teacherMenu.add( new Item( "Last Submit", "account_setting.xhtml") );
		teacherMenu.add( new Item( "Course List", "course_list.xhtml") );
		teacherMenu.add( new Item( "Student List", "student_list.xhtml") );


		studentMenu.add( new Item( "Account Settings", "change_account_settings.xhtml") );
		studentMenu.add( new Item( "Firewall", "account_setting.xhtml") );
		studentMenu.add( new Item( "My Course List", "course_list.xhtml") );
	}

	public Collection<Item> getMenu() {
		return menu;
	}

	public boolean show() {
		boolean isAuth = this.session.isAuth();
		if ( !isAuth ) {
			menu = null;
		}
		else {
			User user = session.getUser();
			if ( user.isTeacher() ) {
				menu = teacherMenu;
			}
			else {
				menu = studentMenu;
			}
		}
		return isAuth;
	}
}
