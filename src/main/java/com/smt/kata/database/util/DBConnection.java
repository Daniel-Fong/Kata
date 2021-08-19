package com.smt.kata.database.util;

// JDK 11.x
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/****************************************************************************
 * <b>Title</b>: Connection.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Connects to the database with the provided info
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jul 26, 2021
 * @updates:
 ****************************************************************************/
public class DBConnection {

	protected String user; 
	protected String pwd; 
	protected String driver; 
	protected String url;
	protected Connection conn;
	
	/**
	 * 
	 * @param host
	 * @param pwd
	 * @param driver
	 * @param url
	 */
	public DBConnection(String user, String pwd, String driver, String url) {
		super();
		this.user = user;
		this.pwd = pwd;
		this.driver = driver;
		this.url = url;
	}
	
	
	/**
	 * Connects to the database 
	 * @return
	 */
	public Connection getConnection() throws SQLException {
		this.conn = null;
	    this.conn = DriverManager.getConnection(this.url, this.user, this.pwd);
	    return this.conn;
	}
	
	/**
	 * Identifies whether there is a connection to the db
	 * @return
	 */
	public boolean isConnected() {
		if (this.conn != null) return true;
		return false;
	}
	
	/**
	 * Closes the database connection
	 * @throws SQLException 
	 *
	 */
	public void close() throws SQLException {
		try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

}
