package hotel.dao;

import myPage.vo.HomeUserVO;

public interface loginMapper {

	HomeUserVO loginIdCheck(String userID);

	HomeUserVO loginPasswordCheck(String userPassword);


}
