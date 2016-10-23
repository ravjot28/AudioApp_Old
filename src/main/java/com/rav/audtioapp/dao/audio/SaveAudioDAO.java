package com.rav.audtioapp.dao.audio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.StringTokenizer;

import com.rav.audtioapp.dao.DAOUtil;
import com.rav.audtioapp.dto.SaveAudioDTO;
import com.rav.audtioapp.util.GeoService;

public class SaveAudioDAO {

	public SaveAudioDAO() {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DAOUtil.getInstance().getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS \"AudioSubmission_Details\" "
					+ "(id numeric NOT NULL, bag text, cot text, gang text, past text, spa text, band text, "
					+ "deck text, house text, pasta text, test text, boat text, duck text, how text, pool text, "
					+ "tie text, boot text, face text, kiss text, seat text, tight text, caught text, far text, "
					+ "pack text, sharp text, too text, longitude character varying(4000), lattitude character varying(4000), "
					+ "birthyear character varying(4000), gender character varying(4000), mothertoungedata character varying(4000), "
					+ "ratefluency character varying(4000),  atwhatage character varying(4000),  emailaddress character varying(4000),  "
					+ "  bornincanada character varying(4000), ifnotmothertounge character varying(4000),\"approvedBy\" character varying(4000),"
					+ "status character varying(4000), state character varying(4000), city character varying(4000), "
					+ "CONSTRAINT \"AudioSubmission_Details_pkey\" PRIMARY KEY (id) )");
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

	private int getMaxID() {
		int result = -1;
		Connection connection = DAOUtil.getInstance().getConnection();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			String sql = "select max(id) FROM \"AudioSubmission_Details\"";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				result = rs.getInt(1);
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

	public int insertNewAudio(SaveAudioDTO dto) {
		int id = getMaxID() + 1;
		PreparedStatement statement = null;
		Connection connection = DAOUtil.getInstance().getConnection();
		try {

			statement = connection.prepareStatement(
					"INSERT INTO \"AudioSubmission_Details\" ( id, bag, cot, gang, past, spa, band, deck, house, pasta, test, "
							+ "boat, duck, how, pool, tie, boot, face, kiss, seat, tight, caught,   far, pack, sharp, "
							+ "too, longitude, lattitude, birthyear, gender,   mothertoungedata, ratefluency, atwhatage, "
							+ "emailaddress, bornincanada, ifnotmothertounge, status,state,city) "
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?,  ?, ?,?,?) ");
			int index = 1;
			statement.setInt(index++, id);
			statement.setString(index++, dto.getBag());
			statement.setString(index++, dto.getCot());
			statement.setString(index++, dto.getGang());
			statement.setString(index++, dto.getPast());
			statement.setString(index++, dto.getSpa());
			statement.setString(index++, dto.getBand());
			statement.setString(index++, dto.getDeck());
			statement.setString(index++, dto.getHouse());
			statement.setString(index++, dto.getPasta());
			statement.setString(index++, dto.getTest());
			statement.setString(index++, dto.getBoat());
			statement.setString(index++, dto.getDuck());
			statement.setString(index++, dto.getHow());
			statement.setString(index++, dto.getPool());
			statement.setString(index++, dto.getTie());
			statement.setString(index++, dto.getBoot());
			statement.setString(index++, dto.getFace());
			statement.setString(index++, dto.getKiss());
			statement.setString(index++, dto.getSeat());
			statement.setString(index++, dto.getTight());
			statement.setString(index++, dto.getCaught());
			statement.setString(index++, dto.getFar());
			statement.setString(index++, dto.getPack());
			statement.setString(index++, dto.getSharp());
			statement.setString(index++, dto.getToo());
			String location = dto.getLocation();
			StringTokenizer token = new StringTokenizer(location, " ");
			statement.setString(index++, token.nextToken());
			statement.setString(index++, token.nextToken());
			statement.setString(index++, dto.getBirthYear());
			statement.setString(index++, dto.getGender());
			statement.setString(index++, dto.getMotherTounge());
			statement.setString(index++, dto.getRateFluency());
			statement.setString(index++, dto.getAtWhatAge());
			statement.setString(index++, dto.getEmailAddress());
			statement.setString(index++, dto.getBornInCanada());
			statement.setString(index++, dto.getIfNotMotherTounge());
			statement.setString(index++, "NOTAPPROVED");
			StringTokenizer t = new StringTokenizer(location, " ");
			double longi = Double.parseDouble(t.nextToken());
			double lat = Double.parseDouble(t.nextToken());
			Map<String, String> data = GeoService.getState(lat, longi);
			statement.setString(index++, data.get("state"));
			statement.setString(index++, data.get("city"));
			statement.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();				connection = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return id;
	}
}
