package com.rav.audtioapp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {

	public LoginDAO() {

		try {
			System.out.println("In LoginDAO constructor");
			Statement stmt = DAOUtil.getInstance().getConnection().createStatement();
			System.out.println("Created Connection and statement");
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS \"UsersDetails\" (\"userName\" character varying(4000),  "
					+ "\"emailAddress\" character varying(4000) NOT NULL,  password character varying(4000),  "
					+ "active character varying(4000),  CONSTRAINT \"UsersDetails_pkey\" PRIMARY KEY (\"emailAddress\"))");
			System.out.println("Executing the create statement");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean userNameExists(String userName) {
		boolean result = false;
		Connection connection = DAOUtil.getInstance().getConnection();
		Statement statement = null;
		int count = -1;
		try {

			statement = connection.createStatement();

			String sql = "select count(1) FROM \"UsersDetails\" where \"userName\" = '" + userName
					+ "' and active ='Y'";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt(1);
			}

			if (count > 0)
				result = true;
			statement.close();

		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}

	public boolean emailAddressExists(String emailAddress) {
		boolean result = false;
		Connection connection = DAOUtil.getInstance().getConnection();
		Statement statement = null;
		int count = -1;
		try {

			statement = connection.createStatement();

			String sql = "select count(1) FROM \"UsersDetails\" where \"emailAddress\" = '" + emailAddress
					+ "' and active ='Y'";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt(1);
			}

			if (count > 0)
				result = true;
			statement.close();

		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}
	

	public String getPassword(String userName) {
		String result = null;
		Connection connection = DAOUtil.getInstance().getConnection();
		Statement statement = null;

		try {

			statement = connection.createStatement();

			String sql = "select password FROM \"UsersDetails\" where \"userName\" = '" + userName
					+ "' and active ='Y'";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				result = rs.getString(1);
			}

			statement.close();

		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}
}
