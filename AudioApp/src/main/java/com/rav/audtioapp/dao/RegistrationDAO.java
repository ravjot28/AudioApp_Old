package com.rav.audtioapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RegistrationDAO {

	public RegistrationDAO() {
		Connection connection = DAOUtil.getConnection();
		if (!DAOUtil.isTableCreated("Users", connection)) {
			String sql = "CREATE TABLE \"Users\" (\"userName\" character varying(4000),  "
					+ "\"emailAddress\" character varying(4000) NOT NULL,  password character varying(4000),  "
					+ "active character(1),  CONSTRAINT \"Users_pkey\" PRIMARY KEY (\"emailAddress\"))";

			PreparedStatement statement = null;
			try {
				statement = connection.prepareStatement(sql);
				statement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					statement.close();
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public boolean userNameExists(String userName) {
		boolean result = false;
		Connection connection = DAOUtil.getConnection();
		Statement statement = null;
		int count = -1;
		try {

			statement = connection.createStatement();

			String sql = "select count(1) FROM \"Users\" where \"userName\" = '" + userName + "' and active ='Y'";
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

			String sql = "select count(1) FROM \"Users\" where \"emailAddress\" = '" + emailAddress
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

	public void insertNewuser(String emailAddress, String userName, String password) {
		PreparedStatement statement = null;
		Connection connection = DAOUtil.getConnection();
		try {

			statement = connection.prepareStatement(
					"INSERT INTO \"Users\" (\"userName\", \"emailAddress\", password, active) VALUES (?, ?, ?, ?, ?)");
			statement.setString(1, userName);
			statement.setString(2, emailAddress);
			statement.setString(3, password);
			statement.setString(4, "Y");
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
