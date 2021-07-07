package project.ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import admin.vo.AdminManager;
import admin.vo.AdminVO;
import hotel.dao.HotelDAO;
import hotel.vo.HotelEventVO;
import hotel.vo.HotelInfoGetVO;
import hotel.vo.HotelInfoPrintVO;
import hotel.vo.Reservation1VO;
import hotel.vo.ReservationVO;
import hotel.vo.RoomVO;
import hotel.vo.loginInfoVO;
import myPage.vo.HomeUserVO;
import myPage.vo.MyPageVO;
import hotel.vo.PayVO;
import project.mgr.HotelManager;
import project.mgr.MyPageManager;
import project.mgr.loginManager;
import project.mgr.signUpManager;



//------------------------------------------------------------//
// 코딩 작성 전에 읽어보기 
// 유저 로그인이나 관리자 로그인 메서드 자료형이 void로 되어 있는데
// 리턴이 있게 하려고 했기 때문에 수정하여야 함...


// 깃허브 자기 브랜치에서 작업하기 
// 자기 브랜치에서 작업하다가 내가 작업한거 master 브랜치로 merge 하고 싶을때는 
// 무조건 "손동규"에게 물어보고 나머지 팀원들에게 master랑 merge한다고 알리고 하기

//2021/07/05-- 유저 로그인 회원가입 관리자 로그인까지 완성
//------------------------------------------------------------//


public class ProjectUI {
	String necessaryuserID = null;
	public Scanner scannerInput = new Scanner(System.in);
	MyPageManager myPageManager = new MyPageManager();
	
	signUpManager signUpManager = new signUpManager();
	
	
	loginManager loginManager = new loginManager();
	
	AdminManager admingManager=new AdminManager();

	HomeUserVO user = new HomeUserVO();
	ReservationVO reservation = new ReservationVO();
	MyPageVO mypage = new MyPageVO();

	
	private HotelManager hotelManager = new HotelManager();
	private HotelDAO hotelDAO = new HotelDAO();

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
				System.out.println("프로그램을 종료합니다");
				return;
			default:
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

	private void amdinUi() {
		System.out.println("관리자 관리자 관리자 페이지");
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
			
			HomeUserVO homeUserVO1=new HomeUserVO(userId,userPassword,userEmail,userPhone,userName,userBirth);
		
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
			necessaryuserID = userID;
			
		}
		return loginCheck;

	}



	private void userLogin() {
		
		boolean run=true;
		
		if(loginCheck()==true) {
			
			while(true) {
				System.out.println("1 . 호텔");
				System.out.println("2 . 레저");
				System.out.println("3 . 교통");
				System.out.println("4 . 마이 페이지");
				System.out.println("5 . 로그 아웃");
		
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
				case 5:
					loginCheck=false;
					return;
				default: 
					break;
				}
	
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
		System.out.println("2 . 진행중인 이벤트");
		System.out.println("3 . 전체 이벤트");
		int selectMenu = scannerInput.nextInt();
		switch(selectMenu) {
		case 1:
			searchAndReservation();
			break;
		case 2:
			ongoingEvent();
			break;
		case 3:
			allEvent();
			break;
		case 0:
			System.out.println("");
			break;
		default:
			break;
		}

	}

	public void searchAndReservation() {
		String checkInDate,checkOutDate, hotelCity, hotelName,roomType,userID;
		int maxPeople, roomID, reservationID;
		scannerInput.nextLine();
		// TODO Auto-generated method stub
		System.out.println("검색 및 예약");


		System.out.println("1 . 지역");
		hotelCity = scannerInput.nextLine();
		System.out.println("2 . 예약 인원 수");
		maxPeople = scannerInput.nextInt();

		HotelInfoGetVO h = new HotelInfoGetVO();

		h.setHotelCity(hotelCity);
		h.setMaxPeople(maxPeople);

		ArrayList<HotelInfoPrintVO> list = hotelManager.hotelsearch(h);
		if (list.isEmpty()) {
			System.out.println("해당 검색결과가 없습니다");
		} else {
			System.out.println("룸 아이디 \t 호텔 이름 \t 호텔 평점 \t 호텔주소 \t \t룸타입 \t 최대 인원수");
			for (HotelInfoPrintVO h1 : list) {

				System.out.println(h1.getRoomID()+"\t"+h1.getHotelName() + "\t" + h1.getHotelGrade() + "\t" + h1.getHotelAddress() + "\t"
						+ h1.getRoomTypeName()+"\t"+h1.getMaxPeople());

			}
			
			scannerInput.nextLine();
			System.out.println("예약하실 룸 아이디를 입력하세요");
			System.out.print("룸 아이디 : ");
			roomID = scannerInput.nextInt();
			
			
			
			scannerInput.nextLine();
			System.out.print("체크인 : ");
			checkInDate = scannerInput.nextLine();
			System.out.print("체크아웃 : ");
			checkOutDate = scannerInput.nextLine();
		

				Reservation1VO hotel1 = new Reservation1VO();
				loginInfoVO login = new loginInfoVO();

				login.setUserID(necessaryuserID);
				
				hotel1.setRoomID(roomID);
				hotel1.setCheckInDate(checkInDate);
				hotel1.setCheckOutDate(checkOutDate);
				hotel1.setUserID(login.getUserID());
				hotel1.setGuestCount(maxPeople);
				
				int cnt = hotelDAO.insertReservation(hotel1);
				if(cnt > 0) {
			
					System.out.println("<결제 수단 선택>");
					System.out.println("1. 현장 결제");
					System.out.println("2. 선 결제");

					System.out.print("선택 > ");
					int menu = scannerInput.nextInt();
					
					
					switch (menu) {
					case 1:
						hotel1.setPayTypeID(1);
						hotel1.setPayTypeName("현장결제");
						System.out.println(hotel1);
						
						PayVO pay = new PayVO();
						pay.setReservationID(hotel1.getReservationID());
						pay.setPayDay("오늘");
						pay.setPayType("1");
						pay.setPayStatus("결제완료");

						
						break;
					case 2:
						System.out.println("<선 결제>");
						System.out.println("1. 신용카드");
						System.out.println("2. 무통장 입금");
						System.out.print("선택 > ");
						int key = scannerInput.nextInt();
						switch (key) {
						case 1:
							hotel1.setPayTypeID(2);
							hotel1.setPayTypeName("신용카드");
							System.out.println(hotel1);
							System.out.println("결제 완료되었습니다.");
							break;
						case 2:
							hotel1.setPayTypeID(3);
							hotel1.setPayTypeName("무통장입금");
							System.out.println(hotel1);
							System.out.println("해당 계좌 번호로 입금 바랍니다.");
							System.out.println("*계좌번호 : (국민은행) 032902-04-354462");
							System.out.println("*예금주 : 신하연");
							break;
						default:
							break;
						}
						break;
					default:
						break;
					}
					
				} else {
					System.out.println("예약 실패했습니다.");
				
				}
			}
		}

			
			
		
			
			
		
	public void ongoingEvent() {
		System.out.println("진행중인 이벤트");
//		LocalDate today = LocalDate.now();


//		System.out.println("날짜를 입력하세요");
		LocalDate localID = LocalDate.now();
		String today = localID.toString();
		
		ArrayList<HotelEventVO> list = hotelManager.ongoingEvent(today);

		if (list.isEmpty()) {
			System.out.println("진행중인 이벤트가 없습니다");
		} else {
			System.out.println("이벤트 제목 \t 이벤트 내용\t 이벤트 시작일\t 이벤트 종료일\t 할인 금액");
			for (HotelEventVO e : list) {
				System.out.println(e.getEventTitle() + " \t " + e.getEventContent() + "\t" + e.getStartDate() + "\t"
						+ e.getEndDate() + "\t" + e.getDiscount());
			}
		}
	}
	
	public void allEvent() {
		System.out.println("전체 이벤트");
		ArrayList<HotelEventVO> list = hotelManager.printAllEvent();
		
		if (list.isEmpty()) {
			System.out.println("진행중인 이벤트가 없습니다");
		} else {
			System.out.println("이벤트 제목 \t 이벤트 내용\t 이벤트 시작일\t 이벤트 종료일\t 할인 금액");
			for (HotelEventVO e : list) {
				System.out.println(e.getEventTitle() + " \t " + e.getEventContent() + "\t" + e.getStartDate() + "\t"
						+ e.getEndDate() + "\t" + e.getDiscount());
			}
		}
	}



	public void printMainMenu() {
		// TODO Auto-generated method stub
		System.out.println("1 . 로그인");
		System.out.println("2 . 회원가입");
		System.out.println("3 . 관리자 로그인");
	}
}