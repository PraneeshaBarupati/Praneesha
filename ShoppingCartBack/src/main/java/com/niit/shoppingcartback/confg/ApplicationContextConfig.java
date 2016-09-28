package com.niit.shoppingcartback.confg;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shoppingcartback.dao.AccountDAO;
import com.niit.shoppingcartback.dao.AccountDAOImpl;
import com.niit.shoppingcartback.dao.CartDAO;
import com.niit.shoppingcartback.dao.CartDAOImpl;
import com.niit.shoppingcartback.dao.CategoryDAO;
import com.niit.shoppingcartback.dao.CategoryDAOImpl;
import com.niit.shoppingcartback.dao.ProductDAO;
import com.niit.shoppingcartback.dao.ProductDAOImpl;
import com.niit.shoppingcartback.dao.SupplierDAO;
import com.niit.shoppingcartback.dao.SupplierDAOImpl;
import com.niit.shoppingcartback.dao.UserDetailsDAO;
import com.niit.shoppingcartback.dao.UserDetailsDAOImpl;

import com.niit.shoppingcartback.model.Cart;
import com.niit.shoppingcartback.model.Category;
import com.niit.shoppingcartback.model.Product;
import com.niit.shoppingcartback.model.Supplier;
import com.niit.shoppingcartback.model.UserDetails;
import com.niit.shoppingcartback.model.UserOrder;

@Configuration
@ComponentScan("com.niit.shoppingcartback")
@EnableTransactionManagement
public class ApplicationContextConfig {

	/*
	 * @Bean(name = "dataSource1) public DataSource getDataSource() {
	 * BasicDataSource dataSource = new BasicDataSource();
	 * dataSource.setDriverClassName("org.h2.Driver");
	 * dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
	 * dataSource.setUsername("sa"); dataSource.setPassword("");
	 * 
	 * return dataSource; }
	 */

	@Bean(name = "dataSource")
	public DataSource getMySQLDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/niitdb5");
		dataSource.setUsername("root");
		dataSource.setPassword("root");

		return dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());

		sessionBuilder.addAnnotatedClasses(UserDetails.class);
		sessionBuilder.addAnnotatedClasses(Category.class);
		sessionBuilder.addAnnotatedClasses(Supplier.class);
		sessionBuilder.addAnnotatedClasses(Product.class);
		sessionBuilder.addAnnotatedClasses(Cart.class);
		sessionBuilder.addAnnotatedClasses(UserOrder.class);
		// sessionBuilder.addAnnotatedClasses(Admin.class);
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}

	@Autowired
	@Bean(name = "categoryDAO")
	public CategoryDAO getcategoryDAOImpl(SessionFactory sessionFactory) {
		// System.out.println("*******categoryDao Object Retrieved***");
		return new CategoryDAOImpl(sessionFactory);

	}

	@Autowired
	@Bean(name = "productDAO")
	public ProductDAO getproductDAOImpl(SessionFactory sessionFactory) {
		// System.out.println("*******productDao Object Retrieved***");
		return new ProductDAOImpl(sessionFactory);

	}

	@Autowired
	@Bean(name = "supplierDAO")
	public SupplierDAO getsupplierDAOImpl(SessionFactory sessionFactory) {
		// System.out.println("*******supplierDao Object Retrieved***");
		return new SupplierDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "userDetailsDAO")
	public UserDetailsDAO getuserDetailsDAOImpl(SessionFactory sessionFactory) {
		// System.out.println("*******userDetailsDao Object Retrieved***");
		return new UserDetailsDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "cartDao")
	public CartDAO getCartDao(SessionFactory sessionFactory) {
		return new CartDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "accountDAO")
	public AccountDAO getAccountDao(SessionFactory sessionFactory) {
		return new AccountDAOImpl(sessionFactory);
	}

	/*
	 * @Autowired
	 * 
	 * @Bean(name = "userDAO") public UserDAO getuserDAOImpl(SessionFactory
	 * sessionFactory) { // System.out.println(
	 * "*******UserDAO Object Retrieved***"); return new
	 * UserDAOImpl(sessionFactory); }
	 * 
	 */
}
