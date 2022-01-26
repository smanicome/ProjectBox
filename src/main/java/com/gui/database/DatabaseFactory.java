package com.gui.database;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * Inerfaces declaration used to not expose database during transactions
 */

@ApplicationScoped
public class DatabaseFactory {
	@PersistenceUnit(unitName = "gui")
    private EntityManagerFactory emf = null;

	/**
	 * @return Entity Manager Factory
	 */
	EntityManagerFactory getEmf() {
		return emf;
	}

	/**
	 * Returns Interfaces for transactions with User table of database
	 * @return UserDaoInterface
	 */

	public UserDaoInterface getUserDAO() {
		return new UserDao( this );
	}

	/**
	 * Returns Interfaces for transactions with Project table of database
	 * @return ProjectDaoInterface type
	 */


	public ProjectDaoInterface getProjectDAO() {
		return new ProjectDao( this );
	}

	/**
	 * Returns Interfaces for transactions with Course table of database
	 * @return CourseDaoInterface type
	 */

	public CourseDaoInterface getCourseDAO() {
		return new CourseDao( this );
	}
	
	/**
	 * Returns Interfaces for transactions with Ip table of database
	 * @return IpDaoInterface type
	 */

	public IpDaoInterface getIpDao() {
		return new IpDao( this );
	}
}
