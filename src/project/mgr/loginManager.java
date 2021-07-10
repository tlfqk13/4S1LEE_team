package project.mgr;


import hotel.dao.loginDAO;
import myPage.vo.HomeUserVO;

public class loginManager {
	
	loginDAO logindao=new loginDAO();

	public HomeUserVO loginIdCheck(String userID) {
		
		// dao가는 함수 
		HomeUserVO result=logindao.loginIdCheck(userID);
		
		return result;
	}

	public HomeUserVO loginPasswordCheck(String userID, String userPassword) {
		
		HomeUserVO result=logindao.loginPasswordCheck(userID,userPassword);
		
		return result;
	}
	
}



