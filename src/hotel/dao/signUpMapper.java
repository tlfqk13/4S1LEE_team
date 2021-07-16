
package hotel.dao;

import java.util.ArrayList;

import hotel.vo.Reservation1VO;
import myPage.vo.HomeUserVO;

public interface signUpMapper {

	//로그인 중복검사 
	public HomeUserVO idDoubleCheck(String id);
	//회원 가입
	public int signUp(HomeUserVO homeUserVO);
	public ArrayList<HomeUserVO> UserTable();
	public ArrayList<Reservation1VO> getReservation();
	
	
	
}
