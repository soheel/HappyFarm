--member 테이블
drop table member;

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

-- product 테이블
drop table product;

create table product (
product_no number(5) primary key,
product_name varchar2(30) not null,
product_price number(10) not null,
product_profile varchar2(100) not null,
product_desc varchar2(100) not null,
product_eval number(3,1) default 0,
product_unit varchar2(6),
producer_no number(5) references producer(producer_no) on delete cascade,
category_subcategory_no number(5) references category_subcategory(category_subcategory_no) on delete cascade
)

-- producer 테이블
drop table producer;

create table producer (
producer_no number(5) primary key,
producer_name varchar2(15) not null,
producer_addr varchar2(50) not null,
producer_phone varchar2(15) not null,
producer_register_date date not null
)

-- category 테이블
drop table category;

create table category (
category_no number(3) primary key,
category_name varchar2(20) not null
)

-- category_subcategory 테이블
drop table category_subcategory;

create table category_subcategory (
category_subcategory_no number(5) primary key,
category_subcategory_name varchar2(20) not null,
category_no number(3) references category(category_no) on delete cascade
)

-- package 테이블
drop table package;

create table package (
package_no number(5) primary key,
package_name varchar2(20),
product_no number(5) references product(product_no) on delete cascade
)

-- package_product 테이블
drop table package_product;

create table package_product (
package_product_no number(5) primary key,
package_no number(5) references package(package_no) on delete cascade,
product_no number(5) references product(product_no) on delete cascade
)

-- certiifcation 테이블
drop table certification;

create table certification (
certification_no number(5) primary key,
certification_image varchar2(100),
certification_name varchar2(30),
certification_desc varchar2(200)
)

-- product_certification 테이블
drop table product_certification;

create table product_certification (
product_certification_no number(5) primary key,
certification_no number(5) references certification(certification_no) on delete cascade,
product_no number(5) references product(product_no) on delete cascade
)

-- purchase 테이블
drop table purchase;

create table purchase (
purchase_no number(5) primary key,
purchase_date date not null,
purchase_price number(10) not null,
purchase_method varchar2(15) not null,
purchase_discount number(7) default 0,
purchase_state_no number(1) references purchase_state(purchase_state_no) on delete cascade,
member_email varchar2(50) references member(member_email) on delete cascade
)

-- purchase_order 테이블
drop table purchase_order;

create table purchase_order (
purchase_no number(5) primary key references purchase(purchase_no) on delete cascade,
purchase_order_name varchar2(15) not null,
purchase_order_addr varchar2(50) not null,
purchase_order_detail_addr varchar2(30) not null,
purchase_order_postcode varchar2(10) not null,
purchase_order_email varchar2(50),
purchase_order_phone varchar2(15) not null
)

-- purchase_state 테이블
drop table purchase_state;

create table purchase_state (
purchase_state_no number(1) primary key,
purchase_state_name varchar2(10) not null
)

-- purchase_product 테이블
drop table purchase_product;

create table purchase_product (
purchase_no number(5) primary key references purchase(purchase_no) on delete cascade,
product_no number(5) references product(product_no) on delete cascade
)

-- cart 테이블
drop table cart;

create table cart (
cart_no number(5),
product_no number(5) references product(product_no) on delete cascade,
cart_num number(2) default 1,
member_email varchar2(50) references member(member_email) on delete cascade,
primary key(cart_no, product_no)
)

-- product_comment 테이블
drop table product_comment;

create table product_comment (
product_comment_no number(5) primary key,
product_comment_content varchar2(300),
product_comment_register_date date not null,
member_email varchar2(50) references member(member_email) on delete cascade,
product_no number(5) references product(product_no) on delete cascade
)

-- community 테이블
drop table community;

create table community (
community_no number(5) primary key,
community_name varchar2(30) not null,
community_profile varchar2(100) not null,
community_desc varchar2(100),
community_register_date date,
community_state number(1) not null
)

-- community_comment 테이블
drop table community_comment;

create table community_comment (
community_comment_no number(5) primary key,
community_comment_register date,
community_comment_content varchar2(300),
community_no number(5) references community(community_no) on delete cascade,
member_email varchar2(50) references member(member_email) on delete cascade
)

-- qna 테이블
drop table qna;

create table qna (
qna_no number(5) primary key,
qna_name varchar2(100) not null,
qna_desc varchar2(1000) not null,
qna_pwd varchar2(10) not null,
qna_register_date date,
member_email varchar2(50) references member(member_email) on delete cascade,
qna_parent number(5) references qna(qna_no) on delete cascade
)

-- donation 테이블
drop table donation;

create table donation (
donation_date date primary key,
donation_price number(10) not null,
donation_org_no number(5) references donation_org(donation_org_no) on delete cascade
)

-- information 테이블
drop table information;

create table information (
information_no number(5) primary key,
information_name varchar2(30) not null,
information_desc varchar2(100) not null,
information_register_date date
)

-- donation_org 테이블
drop table donation_org;

create table donation_org (
donation_org_no number(5) primary key,
donation_org_name varchar2(20) not null,
donation_org_phone varchar2(15) not null,
donation_org_addr varchar2(50) not null,
donation_org_desc varchar2(100) not null,
donation_org_profile varchar2(100)
)