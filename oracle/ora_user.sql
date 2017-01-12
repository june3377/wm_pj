drop sequence seq_1;

create SEQUENCE seq_1
increment by 1
start with 0
minvalue 0
maxvalue 100
nocycle
nocache;

insert into major values(seq_1.currval,'');
insert into major values(seq_1.nextval,'정보보안');
insert into major values(seq_1.nextval,'컴퓨터공학');
insert into major values(seq_1.nextval,'기계공학');
insert into major values(seq_1.nextval,'전기공학');
insert into major values(seq_1.nextval,'전자정보공학');
insert into major values(seq_1.nextval,'정보공학');
insert into major values(seq_1.nextval,'중어중문학');
insert into major values(seq_1.nextval,'수학');
insert into major values(seq_1.nextval,'행정학');
insert into major values(seq_1.nextval,'기계정보학');
insert into major values(seq_1.nextval,'산업공학');
insert into major values(seq_1.nextval,'경영정보학');

delete  from major;

create table major(
  code number primary key,
  name nvarchar2(20) NOT null);  
create table city(
  code number primary key,
  name nvarchar2(20) NOT NULL);
create table student(
  no number primary key,
  name nvarchar2(20) NOT NULL,
  gender char(1) NOT NULL,
  constraints check1 check(gender in('m','f')),
  major number NOT NULL,
  constraints major1 foreign key(major)
  references major(code),
  city number NOT NULL,
  constraints city1 foreign key(city)
  references city(code),
  created_at date default sysdate);
  
  
  
  
  create sequence seq_2 start with 0
                        increment by 1
                        minvalue 0
                        maxvalue 100
                        nocycle
                        nocache;
                        
  delete from city;
                        
  select seq_2.currval from dual;
  
  drop sequence seq_2;
  insert into city values(seq_2.nextval,'서울');
  insert into city values(seq_2.nextval,'부천');
  insert into city values(seq_2.nextval,'창원');
  insert into city values(seq_2.nextval,'부산');
  insert into city values(seq_2.nextval,'인천');
  insert into city values(seq_2.nextval,'수원');
  insert into city values(seq_2.nextval,'대구');
  insert into city values(seq_2.nextval,'충주');
  insert into city values(seq_2.nextval,'구미');
  insert into city values(seq_2.nextval,'광명');
  
  select * from city;
  
create sequence seq_3
increment by 1
start with 0
minvalue 0
maxvalue 100
nocycle
nocache;

delete from student;
drop sequence seq_3;

insert into student(no,name,gender,major,city) values(seq_3.currval,'','m',0,0);
insert into student(no,name,gender,major,city) values(seq_3.nextval,'강동훈','m',9,0);
insert into student(no,name,gender,major,city) values(seq_3.nextval,'곽다인','f',1,5);
insert into student(no,name,gender,major,city) values(seq_3.nextval,'김기호','m',1,0);
insert into student(no,name,gender,major,city) values(seq_3.nextval,'김동근','m',5,0);
insert into student(no,name,gender,major,city) values(seq_3.nextval,'김서준','m',1,1);
insert into student(no,name,gender,major,city) values(seq_3.nextval,'김아연','f',5,7);
insert into student(no,name,gender,major,city) values(seq_3.nextval,'김우성','m',7,0);
insert into student(no,name,gender,major,city) values(seq_3.nextval,'김지혜','f',4,9);
insert into student(no,name,gender,major,city) values(seq_3.nextval,'라건주','f',1,0);
insert into student(no,name,gender,major,city) values(seq_3.nextval,'민동연','m',1,0);
insert into student(no,name,gender,major,city) values(seq_3.nextval,'박민호','m',3,0);
insert into student(no,name,gender,major,city) values(seq_3.nextval,'박정은','f',0,0);
insert into student(no,name,gender,major,city) values(seq_3.nextval,'박중균','m',8,8);
insert into student(no,name,gender,major,city) values(seq_3.nextval,'박지용','m',10,0);
insert into student(no,name,gender,major,city) values(seq_3.nextval,'박찬준','m',1,0);
insert into student(no,name,gender,major,city) values(seq_3.nextval,'박창환','m',1,0);
insert into student(no,name,gender,major,city) values(seq_3.nextval,'박초롱','f',1,5);
insert into student(no,name,gender,major,city) values(seq_3.nextval,'박태준','m',3,0);
insert into student(no,name,gender,major,city) values(seq_3.nextval,'방가은','f',2,0);
insert into student(no,name,gender,major,city) values(seq_3.nextval,'양성준','m',5,4);
insert into student(no,name,gender,major,city) values(seq_3.nextval,'유희상','m',4,0);
insert into student(no,name,gender,major,city) values(seq_3.nextval,'윤장원','m',1,0);
insert into student(no,name,gender,major,city) values(seq_3.nextval,'이명구','m',5,4);
insert into student(no,name,gender,major,city) values(seq_3.nextval,'이명우','m',2,9);
insert into student(no,name,gender,major,city) values(seq_3.nextval,'이수진','f',6,0);
insert into student(no,name,gender,major,city) values(seq_3.nextval,'이창주','m',4,0);
insert into student(no,name,gender,major,city) values(seq_3.nextval,'이호성','m',11,3);
insert into student(no,name,gender,major,city) values(seq_3.nextval,'임연주','f',1,0);
insert into student(no,name,gender,major,city) values(seq_3.nextval,'정종찬','m',1,0);
insert into student(no,name,gender,major,city) values(seq_3.nextval,'조인환','m',1,0);
insert into student(no,name,gender,major,city) values(seq_3.nextval,'최민진','f',4,1);