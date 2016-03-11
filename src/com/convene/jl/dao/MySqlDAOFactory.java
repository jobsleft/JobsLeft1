package com.convene.jl.dao;

import java.net.URL;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.log4j.Logger;


import com.mysql.jdbc.Connection;

public class MySqlDAOFactory extends DAOFactory {

	static Logger logger = Logger.getLogger(MySqlDAOFactory.class);

	public static Connection createConnection() {
		Connection con = null;
		String jdbc_url;
		String jdbc_auth_user;
		String jdbc_auth_pwd;
		try

		{
			Class.forName("com.mysql.jdbc.Driver");
			URL url = MySqlDAOFactory.class.getResource("jdbc.properties");
			Properties props = new Properties();
			props.load(url.openStream());

			jdbc_url = "jdbc:mysql://localhost:3306/mysql";
			jdbc_auth_user = "root";//props.getProperty("jdbc.username");
			jdbc_auth_pwd = "secret";//props.getProperty("jdbc.password");

			con = (Connection) DriverManager.getConnection(jdbc_url, jdbc_auth_user, jdbc_auth_pwd);

			if (con.isClosed()) {
				System.out.println("Connection to " + "MySql Unsuccessful...");
				logger.debug("Connection to " + "MySql Unsuccessful...");
			}

			if (!con.isClosed()) {
				System.out.println("Successfully connected to " + "MySql using TCP/IP...");

			}
		} catch (

		Exception e)

		{
			System.err.println("Exception: " + e.getMessage());
			logger.debug(e.getMessage());
		}
		return con;
	}
	
	public IUserDAO getUserDAO() {
		return new UserDAO();
	}
	
}