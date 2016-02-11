package com.rav.audtioapp.dao.audio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rav.audtioapp.dao.DAOUtil;

public class GetAudioDAO {

	public GetAudioDAO() {

		try {
			Statement stmt = DAOUtil.getInstance().getConnection().createStatement();
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS \"AudioSubmission_Details\" "
					+ "(id numeric NOT NULL, bag text, cot text, gang text, past text, spa text, band text, "
					+ "deck text, house text, pasta text, test text, boat text, duck text, how text, pool text, "
					+ "tie text, boot text, face text, kiss text, seat text, tight text, caught text, far text, "
					+ "pack text, sharp text, too text, longitude character varying(4000), lattitude character varying(4000), "
					+ "birthyear character varying(4000), gender character varying(4000), mothertoungedata character varying(4000), "
					+ "ratefluency character varying(4000),  atwhatage character varying(4000),  emailaddress character varying(4000),  "
					+ "town character varying(4000),  bornincanada character varying(4000), ifnotmothertounge character varying(4000),\"approvedBy\" character varying(4000),"
					+ "status character varying(4000),province character varying(4000), "
					+ "CONSTRAINT \"AudioSubmission_Details_pkey\" PRIMARY KEY (id) )");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> getUnApprovedAudio() {
		List<String> result = new ArrayList<String>();
		Connection connection = DAOUtil.getInstance().getConnection();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			String sql = "select birthyear,longitude,lattitude,id,gender,ifnotmothertounge,mothertoungedata,atwhatage,bag, cot, gang, past, "
					+ "spa, band, deck, house, pasta, test,boat, duck, how, pool, tie, boot, face, kiss, seat, tight, caught,  far, pack, "
					+ "sharp, too FROM \"AudioSubmission_Details\" where status  ='NOTAPPROVED'";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				ResultSetMetaData rsmd = rs.getMetaData();
				String voices = "";
				for (int j = 9; j < rsmd.getColumnCount()+1; j++) {
					if (rs.getString(rsmd.getColumnName(j)) != null) {
						voices += rsmd.getColumnName(j) + "-";
					}
				}
				voices = voices.substring(0, voices.length() - 1);
				result.add("{" + rs.getString(1) + "}" + "{" + rs.getString(2) + "}" + "{" + rs.getString(3) + "}"
						+ "{CVMX-" + rs.getInt(4) + "}" + "{" + rs.getString(5) + "}" + "{" + rs.getString(6) + "}"
						+ "{" + rs.getString(7) + "}" + "{" + rs.getString(8) + "}" + "{" + voices + "}");

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

	public List<String> getApprovedAudio() {
		List<String> result = new ArrayList<String>();
		Connection connection = DAOUtil.getInstance().getConnection();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			String sql = "select birthyear,longitude,lattitude,id,gender,ifnotmothertounge,mothertoungedata,atwhatage,bag, cot, gang, past, "
					+ "spa, band, deck, house, pasta, test,boat, duck, how, pool, tie, boot, face, kiss, seat, tight, caught,  far, pack, "
					+ "sharp, too FROM \"AudioSubmission_Details\" where status  ='APPROVED'";
			System.out.println("select emailaddress,longitude,lattitude FROM \"AudioSubmission_Details\" where status  ='APPROVED'");
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				ResultSetMetaData rsmd = rs.getMetaData();
				String voices = "";
				for (int j = 9; j < rsmd.getColumnCount()+1; j++) {
					if (rs.getString(rsmd.getColumnName(j)) != null) {
						voices += rsmd.getColumnName(j) + "-";
					}
				}
				voices = voices.substring(0, voices.length() - 1);
				result.add("{" + rs.getString(1) + "}" + "{" + rs.getString(2) + "}" + "{" + rs.getString(3) + "}"
						+ "{CVMX-" + rs.getInt(4) + "}" + "{" + rs.getString(5) + "}" + "{" + rs.getString(6) + "}"
						+ "{" + rs.getString(7) + "}" + "{" + rs.getString(8) + "}" + "{" + voices + "}");
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

	public String getParticularAudio(String voice, int id) {
		String result = null;
		Connection connection = DAOUtil.getInstance().getConnection();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			String sql = "select " + voice + " FROM \"AudioSubmission_Details\" where id = " + id ;
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
