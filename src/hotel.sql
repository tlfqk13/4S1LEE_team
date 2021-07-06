create table Event (
eventID     number  primary key
,eventTitle  varchar2(100)  not null
,eventcontent  varchar2(100) not null
,discount       number  not null
,startdate      date 
,enddate        date
);

create table Manager(
    managerNumber         number               primary key
    ,managerPassword      varchar2(20)         not null
    ,managerID            varchar2(20)         not null
);

create table HotelGrade(
    hotelGradeID            number              primary key
    ,hotelGrade             varchar2(20)        not null
);

create table UserGrade(
    userGradeID	   number	 primary key
    userGrade           varchar2(20)        not null
);

create table payType(
    payTypeID       number               primary key
    ,payType        varchar2(100)        not null
);

create table RoomType(
    roomTypeID number primary key
    ,roomTypeName varchar2(100) not null
    ,maxPeople number not null
    
    ,totalRoom number not null
);

create table UserPro(         
    userID             varchar2(20)   primary key 
    userPassword	varchar2(20)	not null
    ,userEmail          varchar2(20)    not null
    ,userPhone          varchar2(30)    not null
    ,userName           varchar2(20)    not null
    ,userBirth          date            not null
    ,userGrade          varchar2(20)    constraint userPro_userGrade_fk references userGrade(userGradeID)   
);

create table hotel(
    hotelID               number               primary key
    ,hotelName            varchar2(100)        not null
    ,hotelAddress         varchar2(100)        not null
    ,hotelGradeID         number               constraint hotel_hotelGradeID_fk references hotelGrade(hotelGradeID)
    ,hotelCity            varchar2(100)        not null
);

create table Room(
roomID          number     primary key     
,hotelID        number     constraint room_hotelID_fk references hotel(hotelID)
,roomInfo       varchar2(100)   not null
,bookingStatus  varchar2(100)   not null
,roomTypeID      number   constraint room_roomTypeID_fk references roomType(roomTypeID)
);

create table Reservation(
    reservationID number primary key
    ,roomID number constraint Reservation_roomID_fk references room(roomID)   
    ,userID varchar2(100) constraint Reservation_userID_fk references userPro(userID)
    ,checkInDate varchar2(100) not null
    ,checkOutDate varchar2(100) not null
    ,guestCount number not null
		,price varchar2(100) not null
);

create table pay(
    payID               number              primary key
    ,reservationID      number              constraint pay_reservation_fk references reservation(reservationID)
    ,payDay             varchar2(100)       not null
    ,payTypeID          number              constraint pay_payTypeID_fk references payType(payTypeID)
    ,payStatus          varchar2(100)       not null
);

create table ReviewBoard(
reviewID        number      not null
,userID         varchar2(100)   constraint ReviewBoard_userID_fk references userPro(userID)
,reservationID  number          constraint ReviewBoard_reservationID_fk references reservation(reservationID)
,starRating     number          not null
,title          varchar2(100)   not null
,contents       varchar2(100)   not null
,reviewDate     varchar2(100)   not null
);

create table MyReservation(
    myReservationID varchar2(100) primary key
    ,userID varchar2(100) constraint MyReservation_userID_fk references UserPro(userID)
    ,reservationID number constraint MyReservation_reservationID_fk references Reservation(reservationID) 
    ,payID number constraint pay_fk references Pay(payID)
    ,reveiw varchar2(100) not null
);