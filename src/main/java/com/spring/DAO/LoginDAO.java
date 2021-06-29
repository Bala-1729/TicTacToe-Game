package com.spring.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

@Repository
public class LoginDAO {

	public LoginDAO() {
	}

	public boolean login(String username, String password) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mariadb://svc-128a4780-a5f0-4b68-b032-973986d0df83-ddl.aws-sydney-1.svc.singlestore.com:3306/tictactoe", "admin", "A2s3d4f5!");
			PreparedStatement st = con.prepareStatement("select * from usertable where username=? and pass=?");
			st.setString(1, username);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				if(username.equals(rs.getString("username")) && password.equals(rs.getString("pass"))){
					return true;
				}
			}
			return false;
		} catch (Exception e) {}
		return false;
	}

}
