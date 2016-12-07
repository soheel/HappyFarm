donation_org -> donation -> member -> producer -> category -> sub_category -> product -> package -> package_product -> certification -> product_certification
-> purchase_state -> purchase -> purchase_order -> purchase_product -> cart -> product_comment -> commuinty -> community_comment -> qna -> information

-- donation_org 테이블----------------------------------------------------------
drop table donation_org;
select * from donation_org;
시퀀스
drop sequence donation_org_no;
create sequence donation_org_no nocache;

create table donation_org (
donation_org_no number(5) primary key,
donation_org_name varchar2(20) not null,
donation_org_phone varchar2(15) not null,
donation_org_addr varchar2(50) not null,
donation_org_desc varchar2(100) not null,
donation_org_profile varchar2(100)
)

삽입
insert into donation_org values(donation_org_no.nextval, '유니세프','031-219-1542','경기도','유니세프입니다',null);

-- donation 테이블--------------------------------------------------------------
drop table donation;
select * from donation;

create table donation (
donation_date date primary key,
donation_price number(10) not null,
donation_org_no number(5) references donation_org(donation_org_no) on delete cascade
)

삽입
insert into donation values(sysdate, 90000000, 1);

--member 테이블-----------------------------------------------------------------
drop table member;
select * from member;

create table member (
member_email varchar2(50) primary key,
member_pwd varchar2(15) not null,
member_name varchar2(20) not null,
member_phone varchar2(15) not null,
memer_register_date date not null,
member_mileage number(8) default 0,
member_recommand varchar2(50) references member(member_email) on delete cascade,
donation_org_no number(5) references donation_org(donation_org_no) on delete cascade
)

insert into member values('박용우', '123', '박용우', '010', sysdate, 10000, null, 1);
insert into member values('김태호', '123', '김태호', '011', sysdate, 8000, null, 1);
insert into member values('이소희', '123', '이소희', '012', sysdate, 9000, null, 1);
insert into member values('박태흠', '123', '박태흠', '013', sysdate, 2000, null, 1);
insert into member values('김나리', '123', '김나리', '014', sysdate, 12000, null, 1);
insert into member values('임근묵', '123', '임근묵', '015', sysdate, 100000, null, 1);

-- producer 테이블--------------------------------------------------------------
drop table producer;
select * from producer;
시퀀스
drop sequence producer_no;
create sequence producer_no;

create table producer (
producer_no number(5) primary key,
producer_name varchar2(15) not null,
producer_addr varchar2(50) not null,
producer_phone varchar2(15) not null,
producer_register_date date not null
)

삽입
insert into producer values(producer_no.nextval, '제주농부','제주특별시','999', sysdate);
insert into producer values(producer_no.nextval, '이천농부','경기도 이천','888', sysdate);
insert into producer values(producer_no.nextval, '가평농부','경기도 가평','777', sysdate);
insert into producer values(producer_no.nextval, '영주농부','경상북도 영주','666', sysdate);
insert into producer values(producer_no.nextval, '나주농부','전라남도 나주','555', sysdate);
insert into producer values(producer_no.nextval, '예천농부','경상북도 예천','444', sysdate);

-- category 테이블--------------------------------------------------------------
drop table category;
select * from category;
시퀀스
drop sequence category_no;
create sequence category_no;

create table category (
category_no number(3) primary key,
category_name varchar2(20) not null
)

삽입
insert into category values(category_no.nextval, '과일/견과류');
insert into category values(category_no.nextval, '채소류');
insert into category values(category_no.nextval, '쌀/곡류');

-- category_subcategory 테이블--------------------------------------------------
drop table category_subcategory;
select * from category_subcategory;
시퀀스
drop sequence category_subcategory_no;
create sequence category_subcategory_no;

create table category_subcategory (
category_subcategory_no number(5) primary key,
category_subcategory_name varchar2(50) not null,
category_no number(3) references category(category_no) on delete cascade
)

삽입
insert into category_subcategory values(category_subcategory_no.nextval, '사과/배',1);
insert into category_subcategory values(category_subcategory_no.nextval, '딸기/블루베리',1);
insert into category_subcategory values(category_subcategory_no.nextval, '바나나/키위/토마토',1);
insert into category_subcategory values(category_subcategory_no.nextval, '감/곶감',1);
insert into category_subcategory values(category_subcategory_no.nextval, '감귤/한라봉',1);
insert into category_subcategory values(category_subcategory_no.nextval, '땅콩/잣/호두',1);
insert into category_subcategory values(category_subcategory_no.nextval, '복숭아/자두/포도',1);
insert into category_subcategory values(category_subcategory_no.nextval, '건과/견과류',1);
insert into category_subcategory values(category_subcategory_no.nextval, '수박/참외/매실',1);

insert into category_subcategory values(category_subcategory_no.nextval, '두부/콩나물',2);
insert into category_subcategory values(category_subcategory_no.nextval, '고구마/감자/당근/연근',2);
insert into category_subcategory values(category_subcategory_no.nextval, '상추/깻잎/쌈채소',2);
insert into category_subcategory values(category_subcategory_no.nextval, '양파/마늘/생강/파',2);
insert into category_subcategory values(category_subcategory_no.nextval, '배추/무/김장채소',2);
insert into category_subcategory values(category_subcategory_no.nextval, '오이/호박/가지',2);
insert into category_subcategory values(category_subcategory_no.nextval, '시금치/미나리/아욱/건나물',2);
insert into category_subcategory values(category_subcategory_no.nextval, '브로콜리/양배추/샐러드/녹즙',2);
insert into category_subcategory values(category_subcategory_no.nextval, '새송이/느타리/버섯',2);
insert into category_subcategory values(category_subcategory_no.nextval, '파프리카/피망/고추',2);

insert into category_subcategory values(category_subcategory_no.nextval, '백미/현미/이유식',3);
insert into category_subcategory values(category_subcategory_no.nextval, '찹쌀/흑미',3);
insert into category_subcategory values(category_subcategory_no.nextval, '잡곡/콩/깨',3);
insert into category_subcategory values(category_subcategory_no.nextval, '고춧가루/미숫가루/곡물가루',3);

-- product 테이블---------------------------------------------------------------
drop table product;
select * from product;
시퀀스
drop sequence product_no;
create sequence product_no;

create table product (
product_no number(5) primary key,
product_name varchar2(50) not null,
product_price number(10) not null,
product_profile varchar2(100),
product_desc varchar2(100) not null,
product_eval number(3,1) default 0,
product_unit varchar2(15),
producer_no number(5) references producer(producer_no) on delete cascade,
category_subcategory_no number(5) references category_subcategory(category_subcategory_no) on delete cascade
)

삽입
insert into product values(product_no.nextval, '제주감귤', 20000, null, '싱싱하다', 3.8, '상자', 1, 5);
insert into product values(product_no.nextval, '손맛배추', 30000, null, '노랗다', 4.8, '포기', 2, 14);
insert into product values(product_no.nextval, '매운고춧가루', 10000, null, '새빨갛다', 4.0, 'kg', 2, 23);
insert into product values(product_no.nextval, '의성마늘', 3000, null, '노랗다', 4.5, 'g', 3, 13);
insert into product values(product_no.nextval, '매끈한무', 4000, null, '단단하다', 4.5, 'kg', 5, 14);
insert into product values(product_no.nextval, '햇생강', 8000, null, '아삭하다', 3.6, 'kg', 6, 13);
insert into product values(product_no.nextval, '밀키퀸', 8000, null, '딱딱하다', 3.0, 'kg', 2, 20);

insert into product values(product_no.nextval, '김장세트', 45000, null, '김장세트입니다', 3.9, '세트', 2, 14);

-- package 테이블---------------------------------------------------------------
drop table package;
select * from package;
시퀀스
drop sequence package_no;
create sequence package_no;

create table package (
package_no number(5) primary key,
package_name varchar2(20),
product_no number(5) references product(product_no) on delete cascade
)

삽입
insert into package values(package_no.nextval, '김장세트', 8);

-- package_product 테이블-------------------------------------------------------
drop table package_product;
select * from package_product;
시퀀스
drop sequence package_product_no;
create sequence package_product_no;

create table package_product (
package_product_no number(5) primary key,
package_no number(5) references package(package_no) on delete cascade,
product_no number(5) references product(product_no) on delete cascade
)

삽입
insert into package_product values(package_product_no.nextval, 1, 2);
insert into package_product values(package_product_no.nextval, 1, 3);
insert into package_product values(package_product_no.nextval, 1, 4);
insert into package_product values(package_product_no.nextval, 1, 5);
insert into package_product values(package_product_no.nextval, 1, 6);

-- certiifcation 테이블---------------------------------------------------------
drop table certification;
select * from certification;
시퀀스
drop sequence certification_no;
create sequence certification_no;

create table certification (
certification_no number(5) primary key,
certification_image varchar2(100),
certification_name varchar2(30),
certification_desc varchar2(200)
)

삽입
insert into certification values(certification_no.nextval, null, '인증마크1', '인증마크1 입니다');
insert into certification values(certification_no.nextval, null, '인증마크2', '인증마크2 입니다');
insert into certification values(certification_no.nextval, null, '인증마크3', '인증마크3 입니다');

-- product_certification 테이블-------------------------------------------------
drop table product_certification;
select * from product_certification;
시퀀스
drop sequence product_certification_no;
create sequence product_certification_no;

create table product_certification (
product_certification_no number(5) primary key,
certification_no number(5) references certification(certification_no) on delete cascade,
product_no number(5) references product(product_no) on delete cascade
)

삽입
insert into product_certification values (product_certification_no.nextval, 1,1);
insert into product_certification values (product_certification_no.nextval, 1,2);
insert into product_certification values (product_certification_no.nextval, 2,3);
insert into product_certification values (product_certification_no.nextval, 2,4);
insert into product_certification values (product_certification_no.nextval, 3,5);

-- purchase_state 테이블--------------------------------------------------------
drop table purchase_state;
select * from purchase_state;
시퀀스
drop sequence purchase_state_no;
create sequence purchase_state_no;

create table purchase_state (
purchase_state_no number(1) primary key,
purchase_state_name varchar2(18) not null
)

삽입
insert into purchase_state values(purchase_state_no.nextval, '주문완료');
insert into purchase_state values(purchase_state_no.nextval, '결제완료');
insert into purchase_state values(purchase_state_no.nextval, '환불');
insert into purchase_state values(purchase_state_no.nextval, '반품');
insert into purchase_state values(purchase_state_no.nextval, '교환');
insert into purchase_state values(purchase_state_no.nextval, '취소');

-- purchase 테이블--------------------------------------------------------------
drop table purchase;
select * from purchase;
시퀀스
drop sequence purchase_no;
create sequence purchase_no;

create table purchase (
purchase_no number(5) primary key,
purchase_date date not null,
purchase_price number(10) not null,
purchase_method varchar2(20) not null,
purchase_discount number(7) default 0,
purchase_state_no number(1) references purchase_state(purchase_state_no) on delete cascade,
member_email varchar2(50) references member(member_email) on delete cascade
)

삽입
insert into purchase values(purchase_no.nextval, sysdate, 50000, 'card', 0, 2, '박용우');

-- purchase_order 테이블--------------------------------------------------------
drop table purchase_order;
select * from purchase_order;

create table purchase_order (
purchase_no number(5) primary key references purchase(purchase_no) on delete cascade,
purchase_order_name varchar2(15) not null,
purchase_order_addr varchar2(50) not null,
purchase_order_detail_addr varchar2(30) not null,
purchase_order_postcode varchar2(10) not null,
purchase_order_email varchar2(50),
purchase_order_phone varchar2(15) not null
)

삽입
insert into purchase_order values(1, '박용우', '수원', '팔달구', 15152, 'naver.com', '010');

-- purchase_product 테이블------------------------------------------------------
drop table purchase_product;
select * from purchase_product;

create table purchase_product (
purchase_no number(5) references purchase(purchase_no) on delete cascade,
product_no number(5) references product(product_no) on delete cascade,
purchase_product_num number(2) default 1,
primary key(purchase_no, product_no)
)

삽입
insert into purchase_product values(1, 1, 1);
insert into purchase_product values(1, 2, 1);

-- cart 테이블------------------------------------------------------------------
drop table cart;
select * from cart;
시퀀스
drop sequence cart_no;
create sequence cart_no;

create table cart (
cart_no number(5),
product_no number(5) references product(product_no) on delete cascade,
cart_num number(2) default 1,
member_email varchar2(50) references member(member_email) on delete cascade,
primary key(cart_no, product_no)
)

삽입
insert into cart values(cart_no.nextval, 1, 1, '박용우');
insert into cart values(cart_no.nextval, 5, 2, '박용우');

-- product_comment 테이블-------------------------------------------------------
drop table product_comment;
select * from product_comment;
시퀀스
drop sequence product_comment_no;
create sequence product_comment_no;

create table product_comment (
product_comment_no number(5) primary key,
product_comment_content varchar2(300),
product_comment_register_date date not null,
member_email varchar2(50) references member(member_email) on delete cascade,
product_no number(5) references product(product_no) on delete cascade,
product_comment_parent number(5) references product_comment(product_comment_no) on delete cascade
)

삽입
insert into product_comment values(product_comment_no.nextval, '정말 좋은 상품이네요', sysdate, '박용우', 1,null);

-- community 테이블-------------------------------------------------------------
drop table community;
select * from community;
시퀀스
drop sequence community_no;
create sequence community_no;

community_state가 1이면 진행중, 2면 진행완료
create table community (
community_no number(5) primary key,
community_name varchar2(30) not null,
community_profile varchar2(100),
community_desc varchar2(100),
community_register_date date,
community_state number(1) not null
)

삽입
insert into community values(community_no.nextval, '김치담그기모임', null, '김장을하자', sysdate, 1);

-- community_comment 테이블-----------------------------------------------------
drop table community_comment;
select * from community_comment;
시퀀스
drop sequence community_comment_no;
create sequence community_comment_no;

create table community_comment (
community_comment_no number(5) primary key,
community_comment_register date,
community_comment_content varchar2(300),
community_no number(5) references community(community_no) on delete cascade,
member_email varchar2(50) references member(member_email) on delete cascade
)

삽입
insert into community_comment values(community_comment_no.nextval, sysdate, '참여하고싶어요', 1, '박용우');

-- qna 테이블-------------------------------------------------------------------
drop table qna;
select * from qna;
시퀀스
drop sequence qna_no;
create sequence qna_no;

create table qna (
qna_no number(5) primary key,
qna_name varchar2(100) not null,
qna_desc varchar2(1000) not null,
qna_pwd varchar2(10) not null,
qna_register_date date,
member_email varchar2(50) references member(member_email) on delete cascade,
qna_parent number(5) references qna(qna_no) on delete cascade
)

삽입
insert into qna values(qna_no.nextval, '배송날짜 문의드립니다~', '12월 3일에 주문했는데 아직까지 배송 준비중인데 언제 배송되나요', '123', sysdate, '박용우', null);

-- information 테이블-----------------------------------------------------------
drop table information;
select * from information;
시퀀스
drop sequence information_no;
create sequence information_no;

create table information (
information_no number(5) primary key,
information_name varchar2(50) not null,
information_desc varchar2(100) not null,
information_register_date date
)

삽입
insert into information values(information_no.nextval, '국산콩과 수입콩', '비교', sysdate);

-- test


select purchase_product.product_no from purchase, purchase_product where purchase.purchase_no = purchase_product.purchase_no group by purchase_product.product_no order by count(purchase_product.product_no) desc;

select purchase_product.product_no from purchase, purchase_product where purchase.purchase_no = purchase_product.purchase_no and purchase.purchase_state_no = 2 and purchase.member_email = '회원이메일' order by purchase.purchase_date desc;