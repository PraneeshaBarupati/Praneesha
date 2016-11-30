package com.niit.collaboration.config;

import java.sql.DriverManager;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import com.niit.collaboration.dao.*;

import com.niit.collaboration.model.*;

import antlr.debug.Event;

public class ApplicationContextConfig {

	@Bean(name = "dataSource")
	public DataSource getOracleDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc..drier.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XM");
		dataSource.setUsername("system");
		dataSource.setPassword("password");

		Properties properties = new Properties();
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.setProperty("hibernate.hbm2ddl.auto", "create");
		properties.setProperty("hibernate.format_sql", "true");
		properties.setProperty("hibernate.jdbc.use_get_generated_keys", "true");
		dataSource.setConnectionProperties(properties);

		return dataSource;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);

		sessionBuilder.addAnnotatedClasses(Blog.class);
		sessionBuilder.addAnnotatedClasses(Chat.class);
		sessionBuilder.addAnnotatedClasses(Event.class);
		sessionBuilder.addAnnotatedClasses(Forum.class);
		sessionBuilder.addAnnotatedClasses(Friend.class);
		sessionBuilder.addAnnotatedClasses(User.class);
		sessionBuilder.addAnnotatedClasses(Job.class);
		sessionBuilder.addAnnotatedClasses(ChatForumComment.class);
		return sessionBuilder.buildSessionFactory();
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		properties.put("hibernate.hbm2ddl.auto", "create");

		System.out.println("*******HibernateProperties initialized****");
		return properties;
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}

	@Autowired
	@Bean(name = "blogDAO")
	public BlogDAO getblogDAOImpl(SessionFactory sessionFactory) {
		System.out.println("*******BlogDao Object Retrieved***");
		return new BlogDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "chatDAO")
	public ChatDAO getchatDAOImpl(SessionFactory sessionFactory) {
		System.out.println("*******ChatDao Object Retrieved***");
		return (ChatDAO) new ChatDAOImpl(sessionFactory);

	}
	/*
	 * @Autowired
	 * 
	 * @Bean(name = "chatforumcommentDAO") public ChatForumCommentDAO
	 * getchatforumcommentDAOImpl(SessionFactory sessionFactory) {
	 * System.out.println("*******ChatforumcommentDao Object Retrieved***");
	 * return (ChatForumCommentDAO) new ChatForumCommentDAOImpl(sessionFactory);
	 * 
	 * }
	 */

	@Autowired
	@Bean(name = "eventDAO")
	public EventDAO geteventDAOImpl(SessionFactory sessionFactory) {
		System.out.println("*******EventDao Object Retrieved***");
		return (EventDAO) new EventDAOImpl(sessionFactory);

	}

	@Autowired
	@Bean(name = "friendDAO")
	public FriendDAO getfriendDAOImpl(SessionFactory sessionFactory) {
		System.out.println("*******FriendDao Object Retrieved***");
		return (FriendDAO) new FriendDAOImpl(sessionFactory);

	}

	@Autowired
	@Bean(name = "jobDAO")
	public JobDAO getjobDAOImpl(SessionFactory sessionFactory) {
		System.out.println("*******JobDao Object Retrieved***");
		return (JobDAO) new JobDAOImpl(sessionFactory);

	}

	@Autowired
	@Bean(name = "userDAO")
	public UserDAO getuserDAOImpl(SessionFactory sessionFactory) {
		System.out.println("*******userDao Object Retrieved***");
		return new UserDAOImpl(sessionFactory);

	}
	/*
	 * 
	 * @Autowired
	 * 
	 * @Bean(name = "forumDAO") public ForumDAO getforumDAOImpl(SessionFactory
	 * sessionFactory) {
	 * System.out.println("*******forumDao Object Retrieved***"); return new
	 * ForumDAOImpl(sessionFactory);
	 * 
	 * }
	 */

}
