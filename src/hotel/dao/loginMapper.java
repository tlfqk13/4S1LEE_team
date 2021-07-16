package hotel.dao;

import java.util.HashMap;

import myPage.vo.HomeUserVO;

public interface loginMapper {

	HomeUserVO loginIdCheck(String userID);

	HomeUserVO loginPasswordCheck(HashMap<String, String> map);


}
