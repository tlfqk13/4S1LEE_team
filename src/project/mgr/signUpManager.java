package project.mgr;

import java.util.ArrayList;

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

	public ArrayList<HomeUserVO> UserTable() {
		ArrayList<HomeUserVO> result=signUpdao.UserTable();
		return result;
	}
}
