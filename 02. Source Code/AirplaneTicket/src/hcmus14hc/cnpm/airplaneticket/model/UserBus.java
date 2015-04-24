package hcmus14hc.cnpm.airplaneticket.model;

import hcmus14hc.cnpm.airplaneticket.dao.UserDAO;
import hcmus14hc.cnpm.airplaneticket.pojo.UserEntity;

public class UserBus {
	
	public UserBus() {
	}
	
	/**
	 * authenticate user
	 * @param uID: user id
	 * @param pwd: user password
	 * @return null if not exist
	 */
	public UserEntity validate(String uID, String password) {
		// hash user password
		String hashPwd = hashMD5(password);
		// find in db
		UserDAO userDAO = new UserDAO();
		UserEntity userEntity = userDAO.getUser(uID, hashPwd);
		userDAO.closeConnection();
		return userEntity;
	}
	
	private String hashMD5(String str) {
		return null;
	}
}
