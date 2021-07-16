package project.mgr;

import java.util.ArrayList;
import java.util.List;

import hotel.dao.HotelDAO;
import hotel.dao.PayDAO;
import hotel.vo.PayVO;
import hotel.vo.Reservation1VO;

public class PayManager {
	
	
	private PayDAO dao=new PayDAO();

	public List<Reservation1VO> payList(String string) {
		ArrayList<Reservation1VO> list = dao.reservation1voList(string);
		return list;
	}

	public void payInsert(PayVO vo) {
		dao.payInsert(vo);
	}

}
