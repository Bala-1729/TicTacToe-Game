package com.spring.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
	public UserDAO() {}	
	public boolean register(String firstname, String lastname, String username, String email, String password) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mariadb://svc-128a4780-a5f0-4b68-b032-973986d0df83-ddl.aws-sydney-1.svc.singlestore.com:3306/tictactoe", "admin", "A2s3d4f5!");
			PreparedStatement st = con.prepareStatement("insert into usertable values(?,?,?,?,?);");
			st.setString(1, firstname);
			st.setString(2, lastname);
			st.setString(3, username);
			st.setString(4, email);
			st.setString(5, password);
			st.executeUpdate();
			return true;
		}
		catch(Exception e) {}
		return false;
	}
}
