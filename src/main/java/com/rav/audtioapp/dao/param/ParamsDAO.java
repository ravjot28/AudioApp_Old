package com.rav.audtioapp.dao.param;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.rav.audtioapp.constants.GeneralConstants;
import com.rav.audtioapp.constants.param.ParamConstants;
import com.rav.audtioapp.dao.DAOUtil;

public class ParamsDAO {

	public ParamsDAO() {
		try {
			Connection conn = DAOUtil.getInstance().getConnection();
			Statement stmt = conn.createStatement();

			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS " + ParamConstants.PARAM_TABLE_NAME + " ("
					+ ParamConstants.PARAM_NAME + " text NOT NULL, " + ParamConstants.PARAM_VALUE + " text NOT NULL, "
					+ GeneralConstants.ACTIVE + " varchar(1) NOT NULL);");
			stmt.close();

			conn.close();

			/*
			 * initializeParameter(ParamConstants.ABOUT_US,
			 * ParamConstants.ABOUT_US_CONTENT);
			 * initializeParameter(ParamConstants.CREDITS,
			 * ParamConstants.CREDITS_CONTENT);
			 * initializeParameter(ParamConstants.ADD_AUDIO_PAGE_HEADING,
			 * ParamConstants.ADD_AUDIO_PAGE_HEADING_CONTENT);
			 * initializeParameter(ParamConstants.ADD_AUDIO_PAGE_1,
			 * ParamConstants.ADD_AUDIO_PAGE_1_CONTENT);
			 * initializeParameter(ParamConstants.
			 * ADD_AUDIO_PAGE_2_BIRTH_YEAR_TITLE,
			 * ParamConstants.ADD_AUDIO_PAGE_2_BIRTH_YEAR_TITLE_CONTENT);
			 * initializeParameter(ParamConstants.
			 * ADD_AUDIO_PAGE_2_BORN_CANADA_TITLE,
			 * ParamConstants.ADD_AUDIO_PAGE_2_BORN_CANADA_TITLE_CONTENT);
			 * initializeParameter(ParamConstants.
			 * ADD_AUDIO_PAGE_2_EMAIL_ADDRESS_TITLE,
			 * ParamConstants.ADD_AUDIO_PAGE_2_EMAIL_ADDRESS_TITLE_CONTENT);
			 * initializeParameter(ParamConstants.
			 * ADD_AUDIO_PAGE_2_FLUENCY_TITLE,
			 * ParamConstants.ADD_AUDIO_PAGE_2_FLUENCY_TITLE_CONTENT);
			 * initializeParameter(ParamConstants.ADD_AUDIO_PAGE_2_GENDER_TITLE,
			 * ParamConstants.ADD_AUDIO_PAGE_2_GENDER_TITLE_CONTENT);
			 * initializeParameter(ParamConstants.
			 * ADD_AUDIO_PAGE_2_MOTHER_TOUNGE_TITLE,
			 * ParamConstants.ADD_AUDIO_PAGE_2_MOTHER_TOUNGE_TITLE_CONTENT);
			 * initializeParameter(ParamConstants.
			 * ADD_AUDIO_PAGE_2_WHAT_AGE_MOVE_IN_TITLE,
			 * ParamConstants.ADD_AUDIO_PAGE_2_WHAT_AGE_MOVE_IN_TITLE_CONTENT);
			 * initializeParameter(ParamConstants.ADD_AUDIO_PAGE_3,
			 * ParamConstants.ADD_AUDIO_PAGE_3_CONTENT);
			 * initializeParameter(ParamConstants.ADD_AUDIO_PAGE_5,
			 * ParamConstants.ADD_AUDIO_PAGE_5_CONTENT);
			 * initializeParameter(ParamConstants.DOWNLOAD_AUDIO_HEAD,
			 * ParamConstants.DOWNLOAD_AUDIO_HEAD_CONTENT);
			 * initializeParameter(ParamConstants.DOWNLOAD_AUDIO_SELECT_GENDER,
			 * ParamConstants.DOWNLOAD_AUDIO_SELECT_GENDER_CONTENT);
			 * initializeParameter(ParamConstants.
			 * DOWNLOAD_AUDIO_SELECT_MAXIMUM_AGE,
			 * ParamConstants.DOWNLOAD_AUDIO_SELECT_MAXIMUM_AGE_CONTENT);
			 * initializeParameter(ParamConstants.
			 * DOWNLOAD_AUDIO_SELECT_MINIMUM_AGE,
			 * ParamConstants.DOWNLOAD_AUDIO_SELECT_MINIMUM_AGE_CONTENT);
			 * initializeParameter(ParamConstants.
			 * DOWNLOAD_AUDIO_SELECT_MOTHER_TOUNGE,
			 * ParamConstants.DOWNLOAD_AUDIO_SELECT_MOTHER_TOUNGE_CONTENT);
			 * initializeParameter(ParamConstants.DOWNLOAD_AUDIO_SELECT_WORD,
			 * ParamConstants.DOWNLOAD_AUDIO_SELECT_WORD_CONTENT);
			 * 
			 * initializeParameter(ParamConstants.ADD_AUDIO_PAGE_WELCOME,
			 * ParamConstants.ADD_AUDIO_PAGE_WELCOME_CONTENT);
			 * initializeParameter(ParamConstants.
			 * ADD_AUDIO_PAGE_WELCOME_NON_BROWSER,
			 * ParamConstants.ADD_AUDIO_PAGE_WELCOME_NON_BROWSER_CONTENT);
			 * 
			 * initializeParameter(ParamConstants.STRATHY_ADMIN,
			 * ParamConstants.STRATHY_ADMIN_CONTENT);
			 * initializeParameter(ParamConstants.STRATHY_WEBSITE_HEADING,
			 * ParamConstants.STRATHY_WEBSITE_HEADING_CONTENT);
			 
			initializeParameter(ParamConstants.STRATHY_ENTER_LOCATION_SEARCH_BAR, ParamConstants.STRATHY_ENTER_LOCATION_SEARCH_BAR_CONTENT);
			initializeParameter(ParamConstants.STRATHY_EMAIL_ADDRESS, ParamConstants.STRATHY_EMAIL_ADDRESS_CONTENT);
			initializeParameter(ParamConstants.STRATHY_EMAIL_SUBJECT, ParamConstants.STRATHY_EMAIL_SUBJECT_CONTENT);
			initializeParameter(ParamConstants.STRATHY_EMAIL_BODY, ParamConstants.STRATHY_EMAIL_BODY_CONTENT);
			initializeParameter(ParamConstants.STRATHY_EMAIL_SUBJECT_TO_END_USER,
					ParamConstants.STRATHY_EMAIL_SUBJECT_TO_END_USER_CONTENT);
			initializeParameter(ParamConstants.STRATHY_EMAIL_TO_END_USER,
					ParamConstants.STRATHY_EMAIL_TO_END_USER_CONTENT);*/

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initializeParameter(String param_name, String param_value) {
		boolean found = false;
		try {
			getParamValue(param_name);
			found = true;
		} catch (Exception e) {

		}

		if (!found) {
			try {
				Connection conn = DAOUtil.getInstance().getConnection();

				PreparedStatement stmt = conn.prepareStatement(ParamConstants.PARAM_INSERT);
				stmt.setString(1, param_name);
				stmt.setString(2, param_value);
				stmt.executeUpdate();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void insertParam(String param_name, String param_value) {

		try {
			Connection conn = DAOUtil.getInstance().getConnection();

			PreparedStatement stmt = conn.prepareStatement(ParamConstants.PARAM_INSERT);
			stmt.setString(1, param_name);
			stmt.setString(2, param_value);
			stmt.executeUpdate();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getParamValue(String paramName) throws Exception {
		String paramValue = null;
		PreparedStatement statement = null;
		Connection conn = DAOUtil.getInstance().getConnection();
		try {
			String sql = "select " + ParamConstants.PARAM_VALUE + " FROM " + ParamConstants.PARAM_TABLE_NAME
					+ "   where " + ParamConstants.PARAM_NAME + " = ? and " + GeneralConstants.ACTIVE + " ='Y'";

			statement = conn.prepareStatement(sql);
			int index = 1;
			statement.setString(index++, paramName);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				paramValue = rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (paramValue == null)
			throw new Exception("Param not found " + paramName);

		return paramValue;
	}

	public String getParamValues() {
		String paramValue = "";
		PreparedStatement statement = null;
		Connection conn = DAOUtil.getInstance().getConnection();
		try {
			String sql = "select distinct " + ParamConstants.PARAM_NAME + "," + ParamConstants.PARAM_VALUE + " FROM "
					+ ParamConstants.PARAM_TABLE_NAME + "   where " + GeneralConstants.ACTIVE + " ='Y' order by "
					+ ParamConstants.PARAM_NAME;

			statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				paramValue += rs.getString(1) + "---" + rs.getString(2) + "~~";
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return paramValue.substring(0, paramValue.length() - 1);
	}

	public void deactiavteParam(String paramName) {
		PreparedStatement statement = null;

		try {
			String sql = "update " + ParamConstants.PARAM_TABLE_NAME + "   set " + GeneralConstants.ACTIVE
					+ " ='N' where " + ParamConstants.PARAM_NAME + "=?";
			Connection conn = DAOUtil.getInstance().getConnection();
			statement = conn.prepareStatement(sql);
			int index = 1;
			statement.setString(index++, paramName);
			statement.executeUpdate();
			statement.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
