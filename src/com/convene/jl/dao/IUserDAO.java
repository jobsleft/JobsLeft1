package com.convene.jl.dao;

import com.convene.jl.info.Password;
import com.convene.jl.info.User;
import com.convene.jl.info.UserStatus;

public interface IUserDAO {
	public UserStatus insertUser(User u, Password p);
}
