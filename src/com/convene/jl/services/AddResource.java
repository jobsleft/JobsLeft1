package com.convene.jl.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.convene.jl.dao.DAOFactory;
import com.convene.jl.dao.IUserDAO;
import com.convene.jl.info.Password;
import com.convene.jl.info.User;
import com.convene.jl.info.UserStatus;
import com.convene.jl.pass.PasswordGenerator;

@Path("users")
public class AddResource {
	@POST
	@Path("add")
	@Produces("application/json")
	@Consumes("application/json")
	public UserStatus addUser(User u) {

		Password ps = new Password();
		UserStatus st = new UserStatus();
		Logger log = Logger.getLogger(AddResource.class);
		log.info(u.getPassword());
		DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

		PasswordGenerator passgen = new PasswordGenerator();
		try {
			ps = passgen.createPassword(u.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
		IUserDAO iDAO = dao.getUserDAO();
		st = iDAO.insertUser(u, ps);
		return st;

	}

}
