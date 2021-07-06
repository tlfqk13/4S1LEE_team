package project.ui;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import admin.vo.AdminVO;
import hotel.vo.ReservationVO;
import myPage.vo.HomeUserVO;
import myPage.vo.MyPageVO;
import myPage.vo.ReviewBoardVO;
import myPage.vo.SearchHotelNameVO;
import myPage.vo.ShowRooomTypeVO;
import myPage.vo.UnBookingRoomVO;
import project.mgr.AdminManager;
import project.mgr.MyPageManager;
import project.mgr.loginManager;
import project.mgr.signUpManager;

//------------------------------------------------------------//
// 코딩 작성 전에 읽어보기 
// 유저 로그인이나 관리자 로그인 메서드 자료형이 void로 되어 있는데
// 리턴이 있게 하려고 했기 때문에 수정하여야 함.
//..

// 깃허브 자기 브랜치에서 작업하기 
// 자기 브랜치에서 작업하다가 내가 작업한거 master 브랜치로 merge 하고 싶을때는 
// 무조건 "손동규"에게 물어보고 나머지 팀원들에게 master랑 merge한다고 알리고 하기
//------------------------------------------------------------//
// 현경 다시 돌아왔다 암 컴
// 이거 바로 전 커밋 푸쉬,, 뭔가 이상함 

public class ProjectUI {
	public Scanner scannerInput = new Scanner(System.in);
	MyPageManager myPageManager = new MyPageManager();
	
	signUpManager signUpManager = new signUpManager();
	
	loginManager loginManager = new loginManager();
	
	AdminManager admingManager=new AdminManager();

	HomeUserVO user = new HomeUserVO();
	ReservationVO reservation = new ReservationVO();
	MyPageVO mypage = new MyPageVO();


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

	public void adminLogin() {
		System.out.println("관리자 로그인");
		
//		  managerNumber         
//		  managerPassword     
//		  managerID           
		String managerID,managerPassword;
		
		System.out.println(" 아이디 : ");
		managerID=scannerInput.next();
		System.out.println(" 비밀번호 : ");
		managerPassword=scannerInput.next();
		
		
		
		AdminVO adminVO=admingManager.adminLogin(managerID,managerPassword);
		if(adminVO==null) {
			System.out.println("관리자 아이디와 비밀번호를 올바르게 입력하세요 !!");
		}
		else {
			System.out.println("관리자 로그인 완료");
			amdinUi();
		}

	}
	
	private void signUp() {
		
		System.out.println("< 회원 가입> ");
		
		String userId,userPassword,userPassword2,userEmail,userName,userBirth,userPhone;
		int signUpCheck=0;
		System.out.println("1 . 사용하실 ID 를 입력해주세요:s ");
		userId=scannerInput.next();
		
		HomeUserVO homeUserVO=signUpManager.idDoubleCheck(userId);
		if(homeUserVO!=null) {
			System.out.println("이미 사용중인 아이디입니다");
			System.out.println("다른 아이디를 사용해주세요");
			signUp();
			return;
		}
		
		System.out.println("2 . 사용하실 비밀번호를 입력해주세요 : ");
		userPassword=scannerInput.next();
		System.out.println("2 . 비밀번호를 한번 더 입력해주세요 : ");
		userPassword2=scannerInput.next();
		
		System.out.println("3. 이메일을 입력해주세요 : ");
		userEmail=scannerInput.next();
		System.out.println("4. 이름을 입력해주세요 : ");
		userName=scannerInput.next();
		System.out.println("5. 생일을 입력해주세요 : ");
		userBirth=scannerInput.next();
		
		
		if(userPassword.equals(userPassword2)) {
			System.out.println("6. 본인 인증을 위해 휴대폰 번호를 입력해주세요 : ");
			userPhone=scannerInput.next();
			
			HomeUserVO homeUserVO1 = new HomeUserVO(userId,userPassword,userEmail,userPhone,userName,userBirth);
		
			signUpCheck=signUpManager.signUp(homeUserVO1);
			
			if(signUpCheck==0) {
				System.out.println("가입 실패입니다");
			}
			else {
				System.out.println("가입 완료 되었습니다");
			}
			return;
		}
		else {
			signUp();
		}	
	}
	
	private void amdinUi() {
		System.out.println("관리자 관리자 관리자 페이지");
	}

	private boolean loginCheck() {
		
		String userID, userPassword;
		System.out.println("1 . 아이디 : ");
		userID=scannerInput.next();
		
		// 로그인 확인하는 메서드
		// 디비에 가서 아이디랑 비번 비교해서 통과되면 넘김 

		HomeUserVO homeuserVO = loginManager.loginIdCheck(userID); //DB 에서 로그인 검사
		
		if(homeuserVO==null) {
			System.out.println("해당 아이디의 회원이 없습니다");
			System.out.println("아이디를 확인하고 다시 입력해 주세요");
			loginCheck=false;
			return loginCheck;
		}
		System.out.println("비밀번호 : ");
		userPassword=scannerInput.next();
		homeuserVO=loginManager.loginPasswordCheck(userPassword);
		if(homeuserVO==null) {
			System.out.println("비밀번호가 틀렸습니다");
			System.out.println("비밀번호를 확인하고 다시 입력해 주세요");
			loginCheck=false;
		}
		else {
			loginCheck=true;
			
		}
		return loginCheck;

	}



	private void userLogin() {
		
		if(loginCheck()==true) {
			
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
		System.out.println("회원 탈퇴하기");
		
		System.out.println("회원 탈퇴하기"); 
		
		boolean check = checkOneByPwd();
		if(check == false) {
			System.out.println(" 비밀번호가 틀렸습니다. ");
			checkOneByPwd();
		}
		
		scannerInput.nextLine();
		
		System.out.println(" 아이디를 입력하세요 ");
		System.out.print(" 아이디 : ");
		String userID = scannerInput.nextLine();
		System.out.println(" 비밀번호를 입력하세요 ");
		System.out.print(" 비밀번호 : ");
		String userPassword = scannerInput.nextLine();
		
		HomeUserVO deleteUser = new HomeUserVO(userID, userPassword,null,null,null,null,null);
		
		boolean checked = myPageManager.deleteAccount(deleteUser);
		
		if(checked) {
			System.out.println(" 회원 탈퇴 성공");
		}else {
			System.out.println(" 회원 탈퇴 실패");
		}
	}

	public void reservationList() {
		System.out.println("내 예약 내역 출력");
		
		String userid = user.getUserID();
		System.out.println(userid);
//		System.out.println("아이디 입력");
//		String userid = scannerInput.next();
		List<ReservationVO> list = myPageManager.reservationList(userid);
		
		for(ReservationVO r : list) {
			System.out.println(r);
		}
	}

	public void reviewList() {
		System.out.println("후기 내역");
		List<ReviewBoardVO> list1 = myPageManager.reviewList();
		
		if(list1.isEmpty()) {
			System.out.println("작성된 후기가 없습니다.");
		}else {
			for(ReviewBoardVO reviewList : list1) {
				System.out.println(reviewList);
			}
		}

	}

	public void userInfoUpdate() {
		System.out.println("개인정보 수정");
		System.out.println("개인정보 수정");
		boolean pwdCheack = checkOneByPwd();
		if(pwdCheack) {
			System.out.println(" 비밀번호가 틀렸습니다. ");
			checkOneByPwd();
		}
		
		scannerInput.nextLine();
		
		System.out.println("새로운 정보 입력");
		System.out.println("변경할 부분만 입력");
		System.out.print("비밀번호 변경 : ");
		String userPassword = scannerInput.nextLine();
		System.out.println("메일은 메일 형식을 준수하세요");
		System.out.print("메일주소 변경 :");
		String userEmail = scannerInput.nextLine();
		System.out.println("전화번호 변경 :");
		String userPhone = scannerInput.nextLine();
		
		//"" <<??
		boolean mailCheck = Pattern.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?", userEmail) || userEmail.isEmpty();
		
		HomeUserVO userInfoUpdate = new HomeUserVO();
		
		if(mailCheck) {
			userInfoUpdate = new HomeUserVO(null,userPassword, userEmail, userPhone,null,null,null);
		} else {
			System.out.println("메일은 메일 형식을 준수하세요");
			return;
		}
		
		if(myPageManager.userInfoUpdate(userInfoUpdate)) {
			System.out.println("정보 수정 완료");
		} else {
			System.out.println("정보 수정 실패");
		}

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
		
		System.out.print("예약번호를 입력해주세요 : ");
		int reservationid = scannerInput.nextInt(); 
		ReservationVO BeforeChange = myPageManager.selectOneReservation(reservationid);
		System.out.println("현재 예약 내역");
		System.out.println(BeforeChange);
		
		System.out.println("변경하실 날짜를 입력해 주세요 ");
		System.out.print("체크인 날짜 : ");
		String checkInDate= scannerInput.next(); 
		System.out.print("체크아웃 날짜 : ");
		String checkOutDate = scannerInput.next(); 
		
		ReservationVO changeDate = new ReservationVO(reservationid,0,null,checkInDate,checkOutDate,0);
		int result = myPageManager.reservationUpdateChangeDate(changeDate);
		
		if(result ==1) {
			System.out.println("예약성공");
		}else {
			System.out.println("예약 실패 ");
		}
		

	}

	public void updateRoomType() {
		System.out.println("룸타입 변경");
		System.out.println("");
		
		System.out.print("예약번호를 입력해주세요 : ");
		int reservationid = scannerInput.nextInt(); 
		ReservationVO BeforeChange = myPageManager.selectOneReservation(reservationid);
		System.out.println("현재 예약 내역");
		System.out.println(BeforeChange);
		
		//System.out.println("예약하신 호텔을 입력해주세요");
		int roomID = BeforeChange.getRoomID();
		
		//호텔 이름 추출
		SearchHotelNameVO hotelNameOne =  myPageManager.searchHotelName(roomID);
		
		String hotelName = hotelNameOne.getHotelName();
		
		//System.out.println(hotelName);
				
		List<ShowRooomTypeVO> list = myPageManager.showAvailableRoomByType(hotelName);
		
		System.out.println("예약 가능한 방 목록");
		for(ShowRooomTypeVO r : list){
			System.out.println(r);
		}
		
		System.out.println("==========================================");
		System.out.println("변경할 룸타입 입력 ");
		String changedRoomType = scannerInput.next();
		
		
		List<UnBookingRoomVO> roomlist = myPageManager.showRoom(changedRoomType);
		
		
		for(UnBookingRoomVO u : roomlist) {
			System.out.println(u);
		}
		int checked = roomlist.get(0).getRoomid();
				
		ReservationVO update = new ReservationVO(reservationid,checked,null,null,null,0);
		System.out.println(update);
		
		int result = myPageManager.reservationUpdateChangeRoomType(update);
		if (result ==1) {
			System.out.println("예약 변경성공");
		}else {
			System.out.println("변경 실패");
		}

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
