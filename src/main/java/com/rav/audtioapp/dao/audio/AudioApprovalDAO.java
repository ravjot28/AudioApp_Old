package com.rav.audtioapp.dao.audio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.rav.audtioapp.dao.DAOUtil;

public class AudioApprovalDAO {

	public AudioApprovalDAO() {

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

	public void updateStatus(String status, int id,String approvalId) {
		Connection connection = DAOUtil.getInstance().getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("update \"AudioSubmission_Details\" set status = ?,\"approvedBy\" =? where id = ?");
			statement.setString(1, status);
			statement.setString(2, approvalId);
			statement.setInt(3, id);
			statement.executeUpdate();

			statement.close();
		} catch (Exception e) {
			System.err.println(e);
		}finally{
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
