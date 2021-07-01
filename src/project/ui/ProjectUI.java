package project.ui;

import java.util.Scanner;

import myPage.vo.UserVO;

//------------------------------------------------------------//
// 코딩 작성 전에 읽어보기 
// 유저 로그인이나 관리자 로그인 메서드 자료형이 void로 되어 있는데
// 리턴이 있게 하려고 했기 때문에 수정하여야 함...

// 깃허브 자기 브랜치에서 작업하기 
// 자기 브랜치에서 작업하다가 내가 작업한거 master 브랜치로 merge 하고 싶을때는 
// 무조건 "손동규"에게 물어보고 나머지 팀원들에게 master랑 merge한다고 알리고 하기
//------------------------------------------------------------//


public class ProjectUI {
	
	private Scanner scannerInput = new Scanner(System.in);
	boolean loginCheck=true;
	
	
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

	private void adminLogin() {
		System.out.println("관리자 로그인");
		
	}

	private void signUp() {
		
		System.out.println("< 회원 가입> ");
		
		String userID,userPassword,userPassword2,userPhone;
		System.out.println("1 . 사용하실 ID 를 입력해주세요: ");
		userID=scannerInput.next();
		
//		UserVO userVO=dao.getId(userID);
//		if(userVO!=null) {
//			System.out.println("이미 사용중인 아이디입니다");
//		}
		
		System.out.println("2 . 사용하실 비밀번호를 입력해주세요 : ");
		userPassword=scannerInput.next();
		System.out.println("2 . 비밀번호를 한번 더 입력해주세요 : ");
		userPassword2=scannerInput.next();
		
		if(userPassword.equals(userPassword2)) {
			System.out.println(" 본인 인증을 위해 휴대폰 번호를 입력해주세요 : ");
			userPhone=scannerInput.next();
			System.out.println("가입 완료 되었습니다");
			return;
		}
		else {
			signUp();
		}	
		
	}
	
	private boolean loginCheck() {
	
		String userID, userPassword;
		System.out.println("1 . 아이디 : ");
		userID=scannerInput.next();
		
		// 로그인 확인하는 메서드
		// 디비에 가서 아이디랑 비번 비교해서 통과되면 넘김 
		
//		UserVO userVO = dao.checkID(userID); DB 에서 로그인 검사
//		if(userVO==null) {
//			System.out.println("해당 아이디의 회원이 없습니다");
//			System.out.println("아이디를 확인하고 다시 입력해 주세요");
//		}
//		System.out.println("비밀번호 : ");
//		userPassword=scannerInput.next();
//		userVO=dao.checkPassword(userPassword);
//		if(userVO==null) {
//			System.out.println("비밀번호가 틀렸습니다");
//			loginCheck=false;
//		}
//		else {
//			loginCheck=true;
//		}
		return loginCheck;
	}

	private void userLogin() {
		
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

	private void myPage() {
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

	private void deleteAccount() {
		// TODO Auto-generated method stub
		System.out.println("회원 탈퇴하기");
	}

	private void reservationList() {
		// TODO Auto-generated method stub
		System.out.println("내 예약 내역 출력");
	}

	private void reviewList() {
		System.out.println("후기 내역");
		
	}
	
	private void userInfoUpdate() {
		// TODO Auto-generated method stub
		System.out.println("개인정보 수정");
		
	}

	private void reservationUpadateAndDelete() {
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

	private void reservationUpdate() {
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

	private void updateDate() {
		// TODO Auto-generated method stub
		
	}

	private void updateRoomType() {
		// TODO Auto-generated method stub
		
	}

	private void reservationDelete() {
		System.out.println("예약 취소");
		System.out.println("1. 삭제할 예약번호 입력");
	}



	private void hotel() {
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

	private void searchAndReservation() {
		// TODO Auto-generated method stub
		System.out.println("검색 및 예약");
		System.out.println("1 . 날짜 (체크인/체크 아웃)");
		System.out.println("2 . 인원");
		System.out.println("3 . 지역");
	}

	private void event() {
		System.out.println("이벤트");
		
	}

	private void printMainMenu() {
		// TODO Auto-generated method stub
		System.out.println("1 . 로그인");
		System.out.println("2 . 회원가입");
		System.out.println("3 . 관리자 로그인");
	}
}
