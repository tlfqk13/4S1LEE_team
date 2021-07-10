
package admin.vo;

import java.util.HashMap;

import myPage.vo.HomeUserVO;

public interface AdminMapper {

	AdminVO adminLogin(HashMap<String, String> map);

}
