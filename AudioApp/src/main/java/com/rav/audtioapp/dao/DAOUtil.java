package com.rav.audtioapp.dao;

import java.net.URI;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DAOUtil {

	public static Connection getConnection() {
		URI dbUri;
		try {
			dbUri = new URI(System.getenv("DATABASE_URL"));
			String username = dbUri.getUserInfo().split(":")[0];
			String password = dbUri.getUserInfo().split(":")[1];
			String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

			return DriverManager.getConnection(dbUrl, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean isTableCreated(String tableName, Connection conn) {
		boolean result = false;
		try {
			DatabaseMetaData md = conn.getMetaData();
			ResultSet rs = md.getTables(null, null, tableName, null);
			while (rs.next()) {
				System.out.println(rs.getString(3));
				result = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
