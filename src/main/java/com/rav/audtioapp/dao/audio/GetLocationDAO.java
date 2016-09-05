package com.rav.audtioapp.dao.audio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rav.audtioapp.dao.DAOUtil;

public class GetLocationDAO {

	public GetLocationDAO() {

		try {
			Statement stmt = DAOUtil.getInstance().getConnection().createStatement();
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
		}
	}

	public List<String> getLocation() {
		List<String> result = new ArrayList<String>();
		Connection connection = DAOUtil.getInstance().getConnection();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			String sql = "select state,city FROM \"AudioSubmission_Details\" where status  ='APPROVED'";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				result.add("<option value=\"" + rs.getString(0) + "-" + rs.getString(1) + "\">" + rs.getString(0) + "-"
						+ rs.getString(1) + "</option>");
			}
			statement.close();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

}
