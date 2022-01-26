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

/**
 * <h1>Setup user Menu</h1>
 * <p>Defines the menu that gives access to differents items depending on user type</p>
 */

@Named
@ApplicationScoped
public class Menu implements Serializable {

	private static final long serialVersionUID = 301448819974058968L;

	/**
	 * <h2>Define Items</h2>
	 * <p>Define links and names attached to it</p>
	 */

	public class Item {
		private String name;
		private String link;

		/**
		 * Constructor
		 * @param name of the link
		 * @param link to the page
		 */

		private Item( String name, String link ) {
			this.name = name;
			this.link = link;
		}


		/**
		 * Getter that gives the name of the link
		 * @returns name of type String
		 */

		public String getName() {
			return name;
		}

		/**
		 * Setter of the name of the link
		 * @param name of type String
		 */

		public void setName(String name) {
			this.name = name;
		}

		/**
		 * Getter that gives the link
		 * @returns link of type String
		 */

		public String getLink() {
			return link;
		}

		/**
		 * Setter of the link
		 * @param link of type String
		 */

		public void setLink(String link) {
			this.link = link;
		}
	}
	@Inject
	private UserSession session;
	private Collection<Item> teacherMenu = new ArrayList<>();
	private Collection<Item> studentMenu = new ArrayList<>();
	private Collection<Item> menu = null;

	/**
	 * Method that initializes menu
	 * Adds different items depending on the type of the user
	 * Adds "Account Settings", "Course List", "Last Submit", "Student list" for teachers
	 * Adds "Account Settings", "Firewall", "My Course List" for Students
	 */

	@PostConstruct
	public void initialize() {

		teacherMenu.add( new Item( "Account Settings", "change_account_settings.xhtml") );
		//teacherMenu.add( new Item( "Last Submit", "account_setting.xhtml") );
		teacherMenu.add( new Item( "Course List", "course_list.xhtml") );
		teacherMenu.add( new Item( "Student List", "student_list.xhtml") );


		studentMenu.add( new Item( "Account Settings", "change_account_settings.xhtml") );
		studentMenu.add( new Item( "Firewall", "ip_list.xhtml") );
		studentMenu.add( new Item( "My Course List", "course_list.xhtml") );
	}

	/**
	 * Getter of Collection of Items that defines the menu
	 * @return menu with all the needed items in the collection
	 */

	public Collection<Item> getMenu() {
		return menu;
	}

	/**
	 * Method used to show which menu to choose depending on the user type
	 * Menu is a collection of items
	 * @return null if not authentified, teacher menu if the user is of teacher type, student menu if user is of student type.
	 */

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
