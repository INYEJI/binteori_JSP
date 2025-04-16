
DROP TABLE MEMBER;  --테이블 삭제

create table member(
    name varchar2(30) NOT null,
    userid varchar2(30) ,
    pwd varchar2(20) NOT null,
    email varchar2(30),
    phone char(13),  -- 010-3380-6423
    admin number(1) default 0, -- 사용자: 0, 관리자:1
    primary key(userid)
);

insert into member values('이소미', 'somi', '1234', 'gmd@naver.com','010-2362-5157', 0);
insert into member values('하상오', 'sang12', '1234', 'ha12@naver.com','010-5926-8888', 1);
insert into member values('김윤승', 'light', '1234', 'youn1004@naver.com','010-9999-8282', 0);

commit;

SELECT *
FROM MEMBER;

DESC MEMBER;

DESCRIBE member;


create table employee(
    name varchar2(20) ,
	address varchar2(100),
    ssn varchar2(15)
);


INSERT INTO EMPLOYEE values('duke', 'seoul','970224-1039234');
INSERT INTO EMPLOYEE values('pororo', 'pusan','001222-1039234');
INSERT INTO EMPLOYEE values('condy', 'daejeon','981212-1039234');

SELECT *
FROM EMPLOYEE e ;
