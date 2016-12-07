donation_org -> donation -> member -> producer -> category -> sub_category -> product -> package -> package_product -> certification -> product_certification
-> purchase_state -> purchase -> purchase_order -> purchase_product -> cart -> product_comment -> commuinty -> community_comment -> qna -> information

-- donation_org ���̺�----------------------------------------------------------
drop table donation_org;
select * from donation_org;
������
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

����
insert into donation_org values(donation_org_no.nextval, '���ϼ���','031-219-1542','��⵵','���ϼ����Դϴ�',null);

-- donation ���̺�--------------------------------------------------------------
drop table donation;
select * from donation;

create table donation (
donation_date date primary key,
donation_price number(10) not null,
donation_org_no number(5) references donation_org(donation_org_no) on delete cascade
)

����
insert into donation values(sysdate, 90000000, 1);

--member ���̺�-----------------------------------------------------------------
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

insert into member values('�ڿ��', '123', '�ڿ��', '010', sysdate, 10000, null, 1);
insert into member values('����ȣ', '123', '����ȣ', '011', sysdate, 8000, null, 1);
insert into member values('�̼���', '123', '�̼���', '012', sysdate, 9000, null, 1);
insert into member values('������', '123', '������', '013', sysdate, 2000, null, 1);
insert into member values('�質��', '123', '�質��', '014', sysdate, 12000, null, 1);
insert into member values('�ӱٹ�', '123', '�ӱٹ�', '015', sysdate, 100000, null, 1);

-- producer ���̺�--------------------------------------------------------------
drop table producer;
select * from producer;
������
drop sequence producer_no;
create sequence producer_no;

create table producer (
producer_no number(5) primary key,
producer_name varchar2(15) not null,
producer_addr varchar2(50) not null,
producer_phone varchar2(15) not null,
producer_register_date date not null
)

����
insert into producer values(producer_no.nextval, '���ֳ��','����Ư����','999', sysdate);
insert into producer values(producer_no.nextval, '��õ���','��⵵ ��õ','888', sysdate);
insert into producer values(producer_no.nextval, '������','��⵵ ����','777', sysdate);
insert into producer values(producer_no.nextval, '���ֳ��','���ϵ� ����','666', sysdate);
insert into producer values(producer_no.nextval, '���ֳ��','���󳲵� ����','555', sysdate);
insert into producer values(producer_no.nextval, '��õ���','���ϵ� ��õ','444', sysdate);

-- category ���̺�--------------------------------------------------------------
drop table category;
select * from category;
������
drop sequence category_no;
create sequence category_no;

create table category (
category_no number(3) primary key,
category_name varchar2(20) not null
)

����
insert into category values(category_no.nextval, '����/�߰���');
insert into category values(category_no.nextval, 'ä�ҷ�');
insert into category values(category_no.nextval, '��/���');

-- category_subcategory ���̺�--------------------------------------------------
drop table category_subcategory;
select * from category_subcategory;
������
drop sequence category_subcategory_no;
create sequence category_subcategory_no;

create table category_subcategory (
category_subcategory_no number(5) primary key,
category_subcategory_name varchar2(50) not null,
category_no number(3) references category(category_no) on delete cascade
)

����
insert into category_subcategory values(category_subcategory_no.nextval, '���/��',1);
insert into category_subcategory values(category_subcategory_no.nextval, '����/��纣��',1);
insert into category_subcategory values(category_subcategory_no.nextval, '�ٳ���/Ű��/�丶��',1);
insert into category_subcategory values(category_subcategory_no.nextval, '��/����',1);
insert into category_subcategory values(category_subcategory_no.nextval, '����/�Ѷ��',1);
insert into category_subcategory values(category_subcategory_no.nextval, '����/��/ȣ��',1);
insert into category_subcategory values(category_subcategory_no.nextval, '������/�ڵ�/����',1);
insert into category_subcategory values(category_subcategory_no.nextval, '�ǰ�/�߰���',1);
insert into category_subcategory values(category_subcategory_no.nextval, '����/����/�Ž�',1);

insert into category_subcategory values(category_subcategory_no.nextval, '�κ�/�ᳪ��',2);
insert into category_subcategory values(category_subcategory_no.nextval, '����/����/���/����',2);
insert into category_subcategory values(category_subcategory_no.nextval, '����/����/��ä��',2);
insert into category_subcategory values(category_subcategory_no.nextval, '����/����/����/��',2);
insert into category_subcategory values(category_subcategory_no.nextval, '����/��/����ä��',2);
insert into category_subcategory values(category_subcategory_no.nextval, '����/ȣ��/����',2);
insert into category_subcategory values(category_subcategory_no.nextval, '�ñ�ġ/�̳���/�ƿ�/�ǳ���',2);
insert into category_subcategory values(category_subcategory_no.nextval, '����ݸ�/�����/������/����',2);
insert into category_subcategory values(category_subcategory_no.nextval, '������/��Ÿ��/����',2);
insert into category_subcategory values(category_subcategory_no.nextval, '������ī/�Ǹ�/����',2);

insert into category_subcategory values(category_subcategory_no.nextval, '���/����/������',3);
insert into category_subcategory values(category_subcategory_no.nextval, '����/���',3);
insert into category_subcategory values(category_subcategory_no.nextval, '���/��/��',3);
insert into category_subcategory values(category_subcategory_no.nextval, '���尡��/�̼�����/�����',3);

-- product ���̺�---------------------------------------------------------------
drop table product;
select * from product;
������
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

����
insert into product values(product_no.nextval, '���ְ���', 20000, null, '�̽��ϴ�', 3.8, '����', 1, 5);
insert into product values(product_no.nextval, '�ո�����', 30000, null, '�����', 4.8, '����', 2, 14);
insert into product values(product_no.nextval, '�ſ���尡��', 10000, null, '��������', 4.0, 'kg', 2, 23);
insert into product values(product_no.nextval, '�Ǽ�����', 3000, null, '�����', 4.5, 'g', 3, 13);
insert into product values(product_no.nextval, '�Ų��ѹ�', 4000, null, '�ܴ��ϴ�', 4.5, 'kg', 5, 14);
insert into product values(product_no.nextval, '�޻���', 8000, null, '�ƻ��ϴ�', 3.6, 'kg', 6, 13);
insert into product values(product_no.nextval, '��Ű��', 8000, null, '�����ϴ�', 3.0, 'kg', 2, 20);

insert into product values(product_no.nextval, '���弼Ʈ', 45000, null, '���弼Ʈ�Դϴ�', 3.9, '��Ʈ', 2, 14);

-- package ���̺�---------------------------------------------------------------
drop table package;
select * from package;
������
drop sequence package_no;
create sequence package_no;

create table package (
package_no number(5) primary key,
package_name varchar2(20),
product_no number(5) references product(product_no) on delete cascade
)

����
insert into package values(package_no.nextval, '���弼Ʈ', 8);

-- package_product ���̺�-------------------------------------------------------
drop table package_product;
select * from package_product;
������
drop sequence package_product_no;
create sequence package_product_no;

create table package_product (
package_product_no number(5) primary key,
package_no number(5) references package(package_no) on delete cascade,
product_no number(5) references product(product_no) on delete cascade
)

����
insert into package_product values(package_product_no.nextval, 1, 2);
insert into package_product values(package_product_no.nextval, 1, 3);
insert into package_product values(package_product_no.nextval, 1, 4);
insert into package_product values(package_product_no.nextval, 1, 5);
insert into package_product values(package_product_no.nextval, 1, 6);

-- certiifcation ���̺�---------------------------------------------------------
drop table certification;
select * from certification;
������
drop sequence certification_no;
create sequence certification_no;

create table certification (
certification_no number(5) primary key,
certification_image varchar2(100),
certification_name varchar2(30),
certification_desc varchar2(200)
)

����
insert into certification values(certification_no.nextval, null, '������ũ1', '������ũ1 �Դϴ�');
insert into certification values(certification_no.nextval, null, '������ũ2', '������ũ2 �Դϴ�');
insert into certification values(certification_no.nextval, null, '������ũ3', '������ũ3 �Դϴ�');

-- product_certification ���̺�-------------------------------------------------
drop table product_certification;
select * from product_certification;
������
drop sequence product_certification_no;
create sequence product_certification_no;

create table product_certification (
product_certification_no number(5) primary key,
certification_no number(5) references certification(certification_no) on delete cascade,
product_no number(5) references product(product_no) on delete cascade
)

����
insert into product_certification values (product_certification_no.nextval, 1,1);
insert into product_certification values (product_certification_no.nextval, 1,2);
insert into product_certification values (product_certification_no.nextval, 2,3);
insert into product_certification values (product_certification_no.nextval, 2,4);
insert into product_certification values (product_certification_no.nextval, 3,5);

-- purchase_state ���̺�--------------------------------------------------------
drop table purchase_state;
select * from purchase_state;
������
drop sequence purchase_state_no;
create sequence purchase_state_no;

create table purchase_state (
purchase_state_no number(1) primary key,
purchase_state_name varchar2(18) not null
)

����
insert into purchase_state values(purchase_state_no.nextval, '�ֹ��Ϸ�');
insert into purchase_state values(purchase_state_no.nextval, '�����Ϸ�');
insert into purchase_state values(purchase_state_no.nextval, 'ȯ��');
insert into purchase_state values(purchase_state_no.nextval, '��ǰ');
insert into purchase_state values(purchase_state_no.nextval, '��ȯ');
insert into purchase_state values(purchase_state_no.nextval, '���');

-- purchase ���̺�--------------------------------------------------------------
drop table purchase;
select * from purchase;
������
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

����
insert into purchase values(purchase_no.nextval, sysdate, 50000, 'card', 0, 2, '�ڿ��');

-- purchase_order ���̺�--------------------------------------------------------
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

����
insert into purchase_order values(1, '�ڿ��', '����', '�ȴޱ�', 15152, 'naver.com', '010');

-- purchase_product ���̺�------------------------------------------------------
drop table purchase_product;
select * from purchase_product;

create table purchase_product (
purchase_no number(5) references purchase(purchase_no) on delete cascade,
product_no number(5) references product(product_no) on delete cascade,
purchase_product_num number(2) default 1,
primary key(purchase_no, product_no)
)

����
insert into purchase_product values(1, 1, 1);
insert into purchase_product values(1, 2, 1);

-- cart ���̺�------------------------------------------------------------------
drop table cart;
select * from cart;
������
drop sequence cart_no;
create sequence cart_no;

create table cart (
cart_no number(5),
product_no number(5) references product(product_no) on delete cascade,
cart_num number(2) default 1,
member_email varchar2(50) references member(member_email) on delete cascade,
primary key(cart_no, product_no)
)

����
insert into cart values(cart_no.nextval, 1, 1, '�ڿ��');
insert into cart values(cart_no.nextval, 5, 2, '�ڿ��');

-- product_comment ���̺�-------------------------------------------------------
drop table product_comment;
select * from product_comment;
������
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

����
insert into product_comment values(product_comment_no.nextval, '���� ���� ��ǰ�̳׿�', sysdate, '�ڿ��', 1,null);

-- community ���̺�-------------------------------------------------------------
drop table community;
select * from community;
������
drop sequence community_no;
create sequence community_no;

community_state�� 1�̸� ������, 2�� ����Ϸ�
create table community (
community_no number(5) primary key,
community_name varchar2(30) not null,
community_profile varchar2(100),
community_desc varchar2(100),
community_register_date date,
community_state number(1) not null
)

����
insert into community values(community_no.nextval, '��ġ��ױ����', null, '����������', sysdate, 1);

-- community_comment ���̺�-----------------------------------------------------
drop table community_comment;
select * from community_comment;
������
drop sequence community_comment_no;
create sequence community_comment_no;

create table community_comment (
community_comment_no number(5) primary key,
community_comment_register date,
community_comment_content varchar2(300),
community_no number(5) references community(community_no) on delete cascade,
member_email varchar2(50) references member(member_email) on delete cascade
)

����
insert into community_comment values(community_comment_no.nextval, sysdate, '�����ϰ�;��', 1, '�ڿ��');

-- qna ���̺�-------------------------------------------------------------------
drop table qna;
select * from qna;
������
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

����
insert into qna values(qna_no.nextval, '��۳�¥ ���ǵ帳�ϴ�~', '12�� 3�Ͽ� �ֹ��ߴµ� �������� ��� �غ����ε� ���� ��۵ǳ���', '123', sysdate, '�ڿ��', null);

-- information ���̺�-----------------------------------------------------------
drop table information;
select * from information;
������
drop sequence information_no;
create sequence information_no;

create table information (
information_no number(5) primary key,
information_name varchar2(50) not null,
information_desc varchar2(100) not null,
information_register_date date
)

����
insert into information values(information_no.nextval, '������� ������', '��', sysdate);

-- test


select purchase_product.product_no from purchase, purchase_product where purchase.purchase_no = purchase_product.purchase_no group by purchase_product.product_no order by count(purchase_product.product_no) desc;

select purchase_product.product_no from purchase, purchase_product where purchase.purchase_no = purchase_product.purchase_no and purchase.purchase_state_no = 2 and purchase.member_email = 'ȸ���̸���' order by purchase.purchase_date desc;