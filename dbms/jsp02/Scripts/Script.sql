SELECT sysdate FROM dual;

CREATE TABLE tbl_user(
	user_number NUMBER,
	user_id varchar2(10),
	user_pw varchar2(20),
	user_name varchar2(100),
	user_age NUMBER,
	user_gender char(1),
	CONSTRAINT pk_user PRIMARY KEY (user_number)
);

CREATE SEQUENCE seq_user;

SELECT * from tbl_user;

DROP TABLE TBL_USER ;
DROP SEQUENCE seq_member;

CREATE TABLE tbl_member(
	member_number NUMBER,
	member_id varchar2(300),
	member_password varchar2(300),
	member_name varchar2(300),
	member_age number(3),
	MEMBER_gender char(1),
	CONSTRAINT pk_number PRIMARY key(member_number)
);

SELECT * FROM tbl_member;


CREATE SEQUENCE seq_member START WITH 1 INCREMENT BY 1
nocache  --시퀀스 값을 미리 메모리에 캐싱하지 않도록 설정
nocycle; --최대갑셍 도달하면 재시작하지 않도록 설정