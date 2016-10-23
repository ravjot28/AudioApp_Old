package com.rav.audtioapp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {

	public LoginDAO() {
		Connection conn = null;
		Statement stmt = null;
		try {
			System.out.println("In LoginDAO constructor");
			conn = DAOUtil.getInstance().getConnection();
			stmt = conn.createStatement();
			System.out.println("Created Connection and statement");
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS \"UsersDetails\" (\"userName\" character varying(4000),  "
					+ "\"emailAddress\" character varying(4000) NOT NULL,  password character varying(4000),  "
					+ "active character varying(4000),  CONSTRAINT \"UsersDetails_pkey\" PRIMARY KEY (\"emailAddress\"))");
			System.out.println("Executing the create statement");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
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

		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				if (statement != null)
					statement.close();

				if (connection != null)
					connection.close();
				connection = null;
			} catch (SQLException e) {
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

		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				if (statement != null)
					statement.close();

				if (connection != null)
					connection.close();
				connection = null;
			} catch (SQLException e) {
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


		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				if (statement != null)
					statement.close();

				if (connection != null)
					connection.close();
				connection = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
}
