package com.convene.jl.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.convene.jl.info.Password;
import com.convene.jl.info.User;
import com.convene.jl.info.UserStatus;
//import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.PreparedStatement;

public class UserDAO implements IUserDAO {

	@Override
	public UserStatus insertUser(User u, Password p) {
		int userId = 0;
		UserStatus userStatus = new UserStatus();
		userStatus.setStatus(-1);
	//	CallableStatement cs;

	//	 ResultSet rs;
		Connection con = MySqlDAOFactory.createConnection();
		System.out.println("connected " + u.getFirstName());
		try {
			System.out.println("password:" + p.getHashedpassword()+" : "+p.toString());
			String str = "INSERT INTO `jobs`.`test_users_sample`("
					+ "first_name, last_name,company,empid,password)" + "VALUES (?,?,?,?,?)";
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(str);
			pstmt.setString(1, u.getFirstName());
			pstmt.setString(2, u.getLastName());
			pstmt.setString(3, u.getCompany());
			pstmt.setString(4, u.getEmpId());
			pstmt.setString(5,  p.getHashedpassword());
			System.out.println("connected1 " + p);
			try {
			pstmt.executeUpdate();
			}catch(SQLException e){
				System.out.println("Error:" + e.getMessage()+ "code: "+e.getErrorCode());
			}
			System.out.println("connected2 " + pstmt.toString());
			userStatus.setUserId(userId);
			userStatus.setStatus(0);
			//userStatus.setCompanyId("sds");
		}catch(Exception e){
			
		}
		return userStatus;
	}

}
