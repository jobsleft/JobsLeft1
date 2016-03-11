package com.convene.jl.dao;

public abstract class DAOFactory {
	public static final int MYSQL = 1;
	public static final int ORACLE = 2;

	public abstract IUserDAO getUserDAO();

	public static DAOFactory getDAOFactory(int whichFactory) {

		switch (whichFactory) {

		// case ORACLE:
		// return new JobsDAOFactory();
		case MYSQL:
			return new MySqlDAOFactory();

		default:
			return null;
		}
	}
}
