package project.mgr;

import admin.vo.AdminVO;
import admin.vo.adminDAO;

public class AdminManager {

	adminDAO admindao=new adminDAO();
	
	public AdminVO adminLogin(String managerID, String managerPassword) {
		AdminVO result=admindao.adminLogin(managerID,managerPassword);
		return result;
	}

}
