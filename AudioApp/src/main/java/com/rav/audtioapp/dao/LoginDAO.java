package com.rav.audtioapp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDAO {

	public LoginDAO() {

		try {
			Statement stmt = DAOUtil.getConnection().createStatement();
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS \"UsersDetails\" (\"userName\" character varying(4000),  "
					+ "\"emailAddress\" character varying(4000) NOT NULL,  password character varying(4000),  "
					+ "active character varying(4000),  CONSTRAINT \"UsersDetails_pkey\" PRIMARY KEY (\"emailAddress\"))");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean userNameExists(String userName) {
		boolean result = false;
		Connection connection = DAOUtil.getConnection();
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
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean emailAddressExists(String emailAddress) {
		boolean result = false;
		Connection connection = DAOUtil.getConnection();
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
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public String getPassword(String userName) {
		String result = null;
		Connection connection = DAOUtil.getConnection();
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
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
