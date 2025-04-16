create table member(
    name varchar2(20) ,
    userid varchar2(10) ,
    pwd varchar2(10),
    email varchar2(20),
    phone char(13),  -- 010-3380-6423
    admin number(1) default 0, -- 사용자: 0, 관리자:1
    primary key(userid)
);

insert into member values('이소미', 'somi', '1234', 'gmd@naver.com','010-2362-5157', 0);
insert into member values('하상오', 'sang12', '1234', 'ha12@naver.com','010-5926-8888', 1);
insert into member values('김윤승', 'light', '1234', 'youn1004@naver.com','010-9999-8282', 0);

commit;