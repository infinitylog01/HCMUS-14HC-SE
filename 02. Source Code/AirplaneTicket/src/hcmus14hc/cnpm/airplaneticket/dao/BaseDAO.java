package hcmus14hc.cnpm.airplaneticket.dao;

import hcmus14hc.cnpm.airplaneticket.DBConnectionPool;

import java.sql.Connection;

public abstract class BaseDAO implements DataAccessObject{
	
	protected Connection dbConn;
	
	public BaseDAO() {
		openConnection();
	}

	@Override
	public void openConnection() {
		dbConn = DBConnectionPool.openConnection();
	}
	
	@Override
	public void closeConnection() {
		DBConnectionPool.closeConnection(dbConn);
	}
}
