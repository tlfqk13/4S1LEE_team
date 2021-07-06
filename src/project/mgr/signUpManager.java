package project.mgr;

import hotel.dao.signUpDAO;
import hotel.dao.signUpMapper;
import myPage.vo.HomeUserVO;

public class signUpManager {
	
	signUpDAO signUpdao = new signUpDAO();

	public int signUp(HomeUserVO homeUserVO) {
	
		int result=signUpdao.signUp(homeUserVO);
		return result;
	}

	public HomeUserVO idDoubleCheck(String userId) {
		HomeUserVO result=signUpdao.idDoubleCheck(userId);
		return result;
	}
}
