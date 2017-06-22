package com.ceeety.autotest.flight_reminder.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

public class InitData {
	/**
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void initTestData() throws ClassNotFoundException, SQLException {
		truncateTable("flight_nay");
		importData();

		setCurrentDatetime();
		setNullDatetime();
		updateSomeFlightsDatetime();

	}

	/**
	 * 清表
	 * 
	 * @param tableName
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private static void truncateTable(String tableName) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			st = conn.createStatement();
			String sql = "truncate table " + tableName;
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.free(rs, st, conn);
		}

	}

	/**
	 * 导数
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private static void importData() throws ClassNotFoundException, SQLException {
		String csvFilePath = System.getProperty("user.dir").replace('\\', '/')
				+ "/src/test/resources/initdata/initdata.csv";
		Log.getLogger().debug("--------------------------------------");
		Log.getLogger().debug(csvFilePath);
		Log.getLogger().debug("--------------------------------------");

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			st = conn.createStatement();

			String sql = "LOAD DATA LOCAL INFILE '" + csvFilePath
					+ "' IGNORE INTO TABLE flight_nay CHARACTER SET utf8 FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\n' IGNORE 1 LINES";

			st.executeUpdate(sql);

			// Log.getLogger().debug(DBHelper.executeUpdate(sql));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.free(rs, st, conn);
		}

	}

	/**
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * 
	 */
	private static void setCurrentDatetime() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			st = conn.createStatement();

			String sql = "UPDATE flight_nay set "
					+ "FLIGHT_DATE=IF(SUBSTRING(FLIGHT_DATE,1,10)='0000-00-00', FLIGHT_DATE, CONCAT(DATE(NOW()), ' ',SUBSTRING(FLIGHT_DATE,12,8))),"
					+ "START_PLAN=IF(SUBSTRING(START_PLAN,1,10)='0000-00-00', START_PLAN, CONCAT(DATE(NOW()), ' ',SUBSTRING(START_PLAN,12,8))),"
					+ "START_PREDICT=IF(SUBSTRING(START_PREDICT,1,10)='0000-00-00', START_PREDICT, CONCAT(DATE(NOW()), ' ',SUBSTRING(START_PREDICT,12,8))),"
					+ "START_REAL=IF(SUBSTRING(START_REAL,1,10)='0000-00-00', START_REAL, CONCAT(DATE(NOW()), ' ',SUBSTRING(START_REAL,12,8))),"
					+ "TERMINAL_PLAN=IF(SUBSTRING(TERMINAL_PLAN,1,10)='0000-00-00', TERMINAL_PLAN, CONCAT(DATE(NOW()), ' ',SUBSTRING(TERMINAL_PLAN,12,8))),"
					+ "TERMINAL_PRIDICT=IF(SUBSTRING(TERMINAL_PRIDICT,1,10)='0000-00-00', TERMINAL_PRIDICT, CONCAT(DATE(NOW()), ' ',SUBSTRING(TERMINAL_PRIDICT,12,8))),"
					+ "TERMINAL_REAL=IF(SUBSTRING(TERMINAL_REAL,1,10)='0000-00-00', TERMINAL_REAL, CONCAT(DATE(NOW()), ' ',SUBSTRING(TERMINAL_REAL,12,8))),"
					+ "COUNTER_TIME_START=IF(SUBSTRING(COUNTER_TIME_START,1,10)='0000-00-00', COUNTER_TIME_START, CONCAT(DATE(NOW()), ' ',SUBSTRING(COUNTER_TIME_START,12,8))),"
					+ "COUNTE_TIME_END=IF(SUBSTRING(COUNTE_TIME_END,1,10)='0000-00-00', COUNTE_TIME_END, CONCAT(DATE(NOW()), ' ',SUBSTRING(COUNTE_TIME_END,12,8)))";
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.free(rs, st, conn);
		}

	}

	/**
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * 
	 */
	private static void setNullDatetime() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			st = conn.createStatement();
			String sql = "UPDATE flight_nay set "
					+ "FLIGHT_DATE=IF(FLIGHT_DATE='0000-00-00 00:00:00', NULL, FLIGHT_DATE),"
					+ "START_PLAN=IF(START_PLAN='0000-00-00 00:00:00', NULL, START_PLAN),"
					+ "START_PREDICT=IF(START_PREDICT='0000-00-00 00:00:00', NULL, START_PREDICT),"
					+ "START_REAL=IF(START_REAL='0000-00-00 00:00:00', NULL, START_REAL),"
					+ "TERMINAL_PLAN=IF(TERMINAL_PLAN='0000-00-00 00:00:00', NULL, TERMINAL_PLAN),"
					+ "TERMINAL_PRIDICT=IF(TERMINAL_PRIDICT='0000-00-00 00:00:00', NULL, TERMINAL_PRIDICT),"
					+ "TERMINAL_REAL=IF(TERMINAL_REAL='0000-00-00 00:00:00', NULL, TERMINAL_REAL),"
					+ "COUNTER_TIME_START=IF(COUNTER_TIME_START='0000-00-00 00:00:00', NULL, COUNTER_TIME_START),"
					+ "COUNTE_TIME_END=IF(COUNTE_TIME_END='0000-00-00 00:00:00', NULL, COUNTE_TIME_END)";
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.free(rs, st, conn);
		}
	}

	/**
	 * 事务处理航班提醒
	 *  1.通过当前时间修改航班时间 
	 *  2.隔天航班的到达时间
	 * 
	 */
	private static void updateSomeFlightsDatetime() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String[] sqls = {
				"UPDATE flight_nay SET START_PLAN=(SELECT DATE_ADD(NOW(),INTERVAL 126	MINUTE)),TERMINAL_PLAN=(SELECT DATE_ADD(NOW(),INTERVAL 186	MINUTE)) WHERE FLIGHT_ID=5001",
				"UPDATE flight_nay SET START_PLAN=(SELECT DATE_ADD(NOW(),INTERVAL 114	MINUTE)),TERMINAL_PLAN=(SELECT DATE_ADD(NOW(),INTERVAL 174	MINUTE)) WHERE FLIGHT_ID=5002",
				"UPDATE flight_nay SET START_PLAN=(SELECT DATE_ADD(NOW(),INTERVAL -6	MINUTE)),TERMINAL_PLAN=(SELECT DATE_ADD(NOW(),INTERVAL 66	MINUTE)) WHERE FLIGHT_ID=5003",
				"UPDATE flight_nay SET TERMINAL_PLAN=(SELECT DATE_ADD(TERMINAL_PLAN,INTERVAL 1 DAY)) WHERE FLIGHT_ID=5012",
				"UPDATE flight_nay SET TERMINAL_PRIDICT=(SELECT DATE_ADD(TERMINAL_PRIDICT,INTERVAL 1 DAY)) WHERE FLIGHT_ID=5013",
				"UPDATE flight_nay SET TERMINAL_PRIDICT=(SELECT DATE_ADD(TERMINAL_PRIDICT,INTERVAL 1 DAY)) WHERE FLIGHT_ID=5029",
				"UPDATE flight_nay SET TERMINAL_PLAN=(SELECT DATE_ADD(TERMINAL_PLAN,INTERVAL 1 DAY)) WHERE FLIGHT_ID=5031",
				"UPDATE flight_nay SET TERMINAL_PRIDICT=(SELECT DATE_ADD(TERMINAL_PRIDICT,INTERVAL 1 DAY)) WHERE FLIGHT_ID=5032",
				"UPDATE flight_nay SET TERMINAL_PLAN=(SELECT DATE_ADD(TERMINAL_PLAN,INTERVAL 1 DAY)),TERMINAL_REAL=(SELECT DATE_ADD(TERMINAL_REAL,INTERVAL 1 DAY)) WHERE FLIGHT_ID=5040",
				"UPDATE flight_nay SET TERMINAL_PLAN=(SELECT DATE_ADD(TERMINAL_PLAN,INTERVAL 1 DAY)),TERMINAL_PRIDICT=(SELECT DATE_ADD(TERMINAL_PRIDICT,INTERVAL 1 DAY)) WHERE FLIGHT_ID=5042",
				"UPDATE flight_nay SET TERMINAL_PLAN=(SELECT DATE_ADD(TERMINAL_PLAN,INTERVAL 1 DAY)),TERMINAL_PRIDICT=(SELECT DATE_ADD(TERMINAL_PRIDICT,INTERVAL 1 DAY)),TERMINAL_REAL=(SELECT DATE_ADD(TERMINAL_REAL,INTERVAL 1 DAY)) WHERE FLIGHT_ID=5043",
				"UPDATE flight_nay SET TERMINAL_PRIDICT=(SELECT DATE_ADD(TERMINAL_PRIDICT,INTERVAL 1 DAY)),TERMINAL_REAL=(SELECT DATE_ADD(TERMINAL_REAL,INTERVAL 1 DAY)) WHERE FLIGHT_ID=5046" };
		try {
			
			conn=JDBCUtils.getConnection();
			conn.setAutoCommit(false);
			st=conn.createStatement();
			for(String sql:sqls){
				st.executeUpdate(sql);
			}
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			Log.getLogger().warn("批量更新失败，执行回滚");
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				Log.getLogger().error("数据回滚失败");
				e1.printStackTrace();
			}
		}finally {
			JDBCUtils.free(rs, st, conn);
		}
	}
}
