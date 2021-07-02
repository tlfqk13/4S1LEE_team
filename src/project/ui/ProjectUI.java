package project.ui;

import java.util.List;
import java.util.Scanner;

import hotel.vo.ReservationVO;
import myPage.vo.MyPageVO;
import myPage.vo.HomeUserVO;
import project.mgr.MyPageManager;

//------------------------------------------------------------//
// 코딩 작성 전에 읽어보기 
// 유저 로그인이나 관리자 로그인 메서드 자료형이 void로 되어 있는데
// 리턴이 있게 하려고 했기 때문에 수정하여야 함.
//..

// 깃허브 자기 브랜치에서 작업하기 
// 자기 브랜치에서 작업하다가 내가 작업한거 master 브랜치로 merge 하고 싶을때는 
// 무조건 "손동규"에게 물어보고 나머지 팀원들에게 master랑 merge한다고 알리고 하기
//------------------------------------------------------------//


public class ProjectUI {
	public Scanner scannerInput = new Scanner(System.in);
	MyPageManager myPageManager = new MyPageManager();

	HomeUserVO user = new HomeUserVO();
	ReservationVO reservation = new ReservationVO();
	MyPageVO mypage = new MyPageVO();


	public ProjectUI() {
		boolean run=true;
		while(run) {
			printMainMenu();
			int selectMenu=scannerInput.nextInt();

			switch(selectMenu) {
			case 1:
				userLogin();
				break;
			case 2:
				signUp();
				break;
			case 3: 
				adminLogin();
				break;
			case 0:
				System.out.println("");
				run=false;
				break;
			default: 
				break;
			}
		}
	}

	public void adminLogin() {
		System.out.println("관리자 로그인");

	}

	public void signUp() {
		System.out.println("1 . ID : ");
		System.out.println("2 . PW : ");
		System.out.println("3 . 2차 PW :");
		System.out.println("3 . 전화번호 (본인인증용) :");

	}

	public void userLogin() {
		System.out.println("1 . 호텔");
		System.out.println("2 . 레저");
		System.out.println("3 . 교통");
		System.out.println("4 . 마이 페이지");

		int selectMenu=scannerInput.nextInt();

		switch(selectMenu) {
		case 1:
			hotel();
			break;
			//		case 2:
			//			leisure();
			//			break;
			//		case 3: 
			//			transport();
			//			break;
		case 4:
			myPage();
			break;
		case 0:
			System.out.println("");
			break;
		default: 
			break;
		}


	}

	public void myPage() {
		// TODO Auto-generated method stub
		System.out.println("<마이 페이지>");
		System.out.println("~님의 등급은 ~입니다 ");
		System.out.println("1 . 개인정보 수정");
		System.out.println("2 . 예약 취소 및 변경");
		System.out.println("3 . 후기 내역");
		System.out.println("4 . 예약 내역");
		System.out.println("5 . 탈퇴");

		int selectMenu=scannerInput.nextInt();

		switch(selectMenu) {
		case 1:
			userInfoUpdate();
			break;
		case 2:
			reservationUpadateAndDelete();
			break;
		case 3: 
			reviewList();
			break;
		case 4:
			reservationList();
			break;
		case 5:
			deleteAccount();
			break;
		case 0:
			System.out.println("");
			break;
		default: 
			break;
		}



	}
	//정보 변경시 비밀번호 다시 한번 확인하기
	public boolean checkOneByPwd(){
		System.out.println("비밀번호로 회원 한명 검증하기");

		System.out.print("비밀번호를 입력해주세오: ");
		String userPassword = scannerInput.next();

		boolean result=false;

		if(userPassword.equals(user.getUserPassword())) {
			result = true; 
			return result;
		}else {
			return result;
		}

	}

	public void deleteAccount() {
		// TODO Auto-generated method stub
		System.out.println("회원 탈퇴하기");
	}

	public void reservationList() {
		System.out.println("내 예약 내역 출력");
		
		//String userid = user.getUserID();
		System.out.println("아이디 입력");
		String userid = scannerInput.next();
		List<ReservationVO> list = myPageManager.reservationList(userid);
		
		for(ReservationVO r : list) {
			System.out.println(r);
		}
	}

	public void reviewList() {
		System.out.println("후기 내역");

	}

	public void userInfoUpdate() {
		System.out.println("개인정보 수정");

	}

	public void reservationUpadateAndDelete() {
		System.out.println("예약 취소 및 변경");
		System.out.println("1 . 예약 취소");
		System.out.println("2 . 예약 변경");
		int selectMenu=scannerInput.nextInt();
		switch(selectMenu) {
		case 1:
			reservationDelete();
			break;
		case 2:
			reservationUpdate();
			break;
		case 0:
			System.out.println("");
			break;
		default: 
			break;
		}

	}

	public void reservationUpdate() {
		System.out.println("예약 변경");

		System.out.println("1 . 날짜 수정");
		System.out.println("2 . 룸 타입 수정");

		int selectMenu=scannerInput.nextInt();
		switch(selectMenu) {
		case 1:
			updateRoomType();
			break;
		case 2:
			updateDate();
			break;
		case 0:
			System.out.println("");
			break;
		default: 
			break;
		}

	}

	public void updateDate() {
		System.out.println("일정 날짜 변경");
		System.out.println("");
		
		System.out.print("예약번호를 입력해주세요 : ");
		int reservationid = scannerInput.nextInt(); 
		ReservationVO BeforeChange = myPageManager.selectOneReservation(reservationid);
		System.out.println("현재 예약 내역");
		System.out.println(BeforeChange);

	}

	public void updateRoomType() {
		System.out.println("룸타입 변경");
		System.out.println("");
		
		System.out.print("예약번호를 입력해주세요 : ");
		int reservationid = scannerInput.nextInt(); 
		ReservationVO BeforeChange = myPageManager.selectOneReservation(reservationid);
		System.out.println("현재 예약 내역");
		System.out.println(BeforeChange);
		
		
		
 
	}

	public void reservationDelete() {

		while(true) {
			System.out.println("예약 취소");
			System.out.println("1. 삭제할 예약번호 입력");

			System.out.print("삭제할 예약번호 입력해주세요: ");
			int reservationID = scannerInput.nextInt();

			System.out.print("자신의 비밀번호를 입력해주세요: ");
			boolean checkedResult = checkOneByPwd();

			if(checkedResult == false) {
				System.out.println("비밀번호가 잘못입력되었습니다.");
				break;
			}else{
				int deleteResult = myPageManager.reservationDelete(reservationID);
			}
		}


	}

	public void hotel() {
		// TODO Auto-generated method stub
		System.out.println("<호텔>");
		System.out.println("1 . 검색 및 예약");
		System.out.println("2 . 이벤트");
		int selectMenu=scannerInput.nextInt();
		switch(selectMenu) {
		case 1:
			searchAndReservation();
			break;
		case 2:
			event();
			break;
		case 0:
			System.out.println("");
			break;
		default: 
			break;
		}

	}

	public void searchAndReservation() {
		// TODO Auto-generated method stub
		System.out.println("검색 및 예약");
		System.out.println("1 . 날짜 (체크인/체크 아웃)");
		System.out.println("2 . 인원");
		System.out.println("3 . 지역");
	}

	public void event() {
		System.out.println("이벤트");

	}

	public void printMainMenu() {
		// TODO Auto-generated method stub
		System.out.println("1 . 로그인");
		System.out.println("2 . 회원가입");
		System.out.println("3 . 관리자 로그인");
	}
}
