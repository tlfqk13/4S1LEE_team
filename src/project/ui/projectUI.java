package project.ui;

import java.util.Scanner;


// 코딩 작성 전에 읽어보기 
// 유저 로그인이나 관리자 로그인 메서드 자료형이 void로 되어 있는데
// 리턴이 있게 하려고 했기 때문에 수정하여야 함.




public class ProjectUI {
	private Scanner scannerInput = new Scanner(System.in);
	
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
		System.out.println("1 . ID : ");
		System.out.println("2 . PW : ");
		System.out.println("3 . 2차 PW :");
		System.out.println("3 . 전화번호 (본인인증용) :");
		
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
