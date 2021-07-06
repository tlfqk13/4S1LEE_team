package admin.vo;

public class AdminManager {

	adminDAO admindao=new adminDAO();
	
	public AdminVO adminLogin(String managerID, String managerPassword) {
		AdminVO result=admindao.adminLogin(managerID,managerPassword);
		return result;
	}

}
