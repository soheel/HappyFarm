donation_org -> donation -> member -> producer -> category -> sub_category -> product -> package -> certification -> product_certification
-> purchase_state -> purchase -> purchase_order -> purchase_product -> cart -> product_comment -> commuinty -> community_comment -> qna -> information
  
���̺� ���� ����
drop table information;
drop table qna;
drop table community_comment;
drop table community;
drop table product_comment;
drop table cart;
drop table purchase_product;
drop table purchase_order;
drop table purchase;
drop table purchase_state;
drop table product_certification;
drop table certification;
drop table package;
drop table product;
drop table sub_category;
drop table category;
drop table producer;
drop table member;
drop table donation;
drop table donation_org;

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
donation_org_desc varchar2(300) not null,
donation_org_profile varchar2(100)
)

����
insert into donation_org values(donation_org_no.nextval, '���ϼ���','02-737-1004','����� ������ ������ 60(â����)',
'1946�⿡ â���� �����ⱸ�ν� ���ϼ����� ���Ӱ��ɰ��߸�ǥ�� �޼��ϱ� ���� ����,�ļ�������,����,��̺�ȣ �� 7���� ���� ����о߸� ���ϰ� ���� ��ȣ����� ��ġ�� �ִ� ��ü�Դϴ�.',
'unicfLogo.jpg');

update donation_org set donation_org_profile = 'unicfLogo.jpg';

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

insert into member values('admin', '123', '������', '000', sysdate, 0, null, 1);

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
producer_register_date date not null,
producer_profile varchar2(100) not null
)

����
insert into producer values(producer_no.nextval, '�����','���ϵ� ���ֽ� ��ϸ� �ȵ��� 253-1','031-749-8569', sysdate,'farmer1.jpg');
insert into producer values(producer_no.nextval, '���º�','��⵵ ��õ�� â���� 85-23','010-568-5584', sysdate,'farmer2.jpg');
insert into producer values(producer_no.nextval, '������','���ϵ� ���ֽ� ���ֵ� ��13','010-2433-6587', sysdate,'farmer3.jpg');
insert into producer values(producer_no.nextval, '�ڳ���','���󳲵� ������ ��ȭ�� 403-1','054-528-7645', sysdate,'farmer4.jpg');
insert into producer values(producer_no.nextval, '�㿵��','������ ���ʽ� ������ 113-13','031-8115-5756', sysdate,'farmer5.jpg');
insert into producer values(producer_no.nextval, '�����','������ ������ ������ ���縮 1-67','031-7142-2128', sysdate,'farmer6.jpg');

delete producer where producer_no > 0

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
insert into product values(product_no.nextval, 'û���ݽ� ��������', 14800, 'fruit_persimmon_drypersimmon.jpg', 'fruit_persimmon_drypersimmon_1.jpg', 3.7, '800g', 1, 4);
insert into product values(product_no.nextval, '���̽��� ����', 11800, 'fruit_mandarinhanrabong_mandarin.jpg', 'fruit_mandarinhanrabong_mandarin_1.jpg', 4.0, '20kg', 2, 5);
insert into product values(3, '���� ��������', 19000, 'fruit_mandarinhanrabong_nozimandarin.jpg', 'fruit_mandarinhanrabong_nozimandarin_1.jpg', 4.6, '20kg', 3, 5);
insert into product values(product_no.nextval, 'Ȳ����', 38000, 'fruit_mandarinhanrabong_goldmandarin.jpg', 'fruit_mandarinhanrabong_goldmandarin_1.jpg', 3.9, '20kg', 4, 5);
insert into product values(product_no.nextval, '�߰��ͽ�', 8000, 'fruit_nut_mixmut.jpg', 'fruit_nut_mixmut_1.jpg', 3.0, '1kg', 5, 8);
insert into product values(product_no.nextval, '������纣��', 18000, 'fruit_strawberryblueberry_blueberry.jpg', 'fruit_strawberryblueberry_blueberry_1.jpg', 3.0, '600g', 6, 2);
insert into product values(product_no.nextval, '�õ������', 8800, 'fruit_strawberryblueberry_mountainstrawberry.jpg', 'fruit_strawberryblueberry_mountainstrawberry_1.jpg', 3.0, '800g', 2, 2);
insert into product values(product_no.nextval, '�Ǵ���', 9800, 'fruit_peanutpinenutwalnut_jujube.jpg', 'fruit_peanutpinenutwalnut_jujube_1.jpg', 3.0, '330g', 2, 6);
insert into product values(product_no.nextval, '�츮���� ����', 3300, 'fruit_peanutpinenutwalnut_chestnut.jpg', 'fruit_peanutpinenutwalnut_chestnut_1.jpg', 3.0, '80g', 2, 6);
insert into product values(product_no.nextval, '����', 16500, 'fruit_peanutpinenutwalnut_pinenut.jpg', 'fruit_peanutpinenutwalnut_pinenut_1.jpg', 3.5, '140g', 2, 6);
insert into product values(product_no.nextval, '��ĳ����', 12000, 'fruit_peanutpinenutwalnut_cashewnut.jpg', 'fruit_peanutpinenutwalnut_cashewnut_1.jpg', 4.0, '150g', 2, 6);
insert into product values(product_no.nextval, '��ȣ�ھ�', 8000, 'fruit_peanutpinenutwalnut_pumpkinnut.jpg', 'fruit_peanutpinenutwalnut_pumpkinnut_1.jpg', 2.8, '170g', 2, 6);
insert into product values(product_no.nextval, '���ȣ��', 19800, 'fruit_peanutpinenutwalnut_walnut.jpg', 'fruit_peanutpinenutwalnut_walnut_1.jpg', 4.5, '100g', 2, 6);
insert into product values(product_no.nextval, '�عٶ�⾾', 18800, 'fruit_peanutpinenutwalnut_sunflowerseed.jpg', 'fruit_peanutpinenutwalnut_sunflowerseed_1.jpg', 3.7, '300g', 2, 6);
insert into product values(product_no.nextval, '�ٳ���', 3900, 'fruit_bananakiwitomato_banana.jpg', 'fruit_bananakiwitomato_banana_1.jpg', 3.3, '300g', 2, 3);
insert into product values(product_no.nextval, '����丶��', 7800, 'fruit_bananakiwitomato_minitomato.jpg', 'fruit_bananakiwitomato_minitomato_1.jpg', 3.9, '900g', 2, 3);
insert into product values(product_no.nextval, '�� ��� �丶��', 15500, 'fruit_bananakiwitomato_tomato.jpg', 'fruit_bananakiwitomato_tomato_2.jpg', 3.9, '2kg', 2, 3);
insert into product values(product_no.nextval, '����° �Դ� ���', 12800, 'fruit_applepear_apple.jpg', 'fruit_applepear_apple_1.jpg', 3.8, '2.3kg', 2, 1);
insert into product values(product_no.nextval, '�̴ϻ��', 5900, 'fruit_applepear_miniapple.jpg', 'fruit_applepear_miniapple_1.jpg', 2.2, '10��', 2, 1);
insert into product values(product_no.nextval, '��', 8900, 'fruit_applepear_pear.jpg', 'fruit_applepear_pear_1.jpg', 4.3, '3��', 2, 1);
insert into product values(product_no.nextval, '������ �ʷ� ģ�� ���', 11800, 'fruit_melon_melon.jpg', 'fruit_melon_melon_1.jpg', 4.9, '1.6kg', 2, 9);
insert into product values(product_no.nextval, '��������', 18500, 'rice_pepperpowdermisutpowdergrainpowder_perillapowder.jpg', 'rice_pepperpowdermisutpowdergrainpowder_perillapowder_1.jpg', 4.0, '270g', 3, 23);
insert into product values(product_no.nextval, '�����ᰡ��', 16500, 'rice_pepperpowdermisutpowdergrainpowder_beanpowder.jpg', 'rice_pepperpowdermisutpowdergrainpowder_beanpowder_1.jpg', 3.8, '300g', 3, 23);
insert into product values(product_no.nextval, '�������̰���', 5500, 'rice_pepperpowdermisutpowdergrainpowder_mixedbrownricepowder.jpg', 'rice_pepperpowdermisutpowdergrainpowder_mixedbrownricepowder_1.jpg', 3.8, '300g', 3, 23);
insert into product values(product_no.nextval, '�ð�ְ��尡��', 32220, 'rice_pepperpowdermisutpowdergrainpowder_pepperpowder.jpg', 'rice_pepperpowdermisutpowdergrainpowder_pepperpowder_1.jpg', 4.2, '500g', 3, 23);
insert into product values(product_no.nextval, '���Ұ���', 4900, 'rice_pepperpowdermisutpowdergrainpowder_glutinousriceflour.jpg', 'rice_pepperpowdermisutpowdergrainpowder_glutinousriceflour_1.jpg', 4.2, '350g', 3, 23);
insert into product values(product_no.nextval, '�¾��� �ް��尡��', 40000, 'rice_pepperpowdermisutpowdergrainpowder_hatpepperpowder.jpg', 'rice_pepperpowdermisutpowdergrainpowder_hatpepperpowder_1.jpg', 4.5, '2.2kg', 3, 23);
insert into product values(product_no.nextval, '���̰���', 5000, 'rice_pepperpowdermisutpowdergrainpowder_brownricepowder.jpg', 'rice_pepperpowdermisutpowdergrainpowder_brownricepowder_1.jpg', 3.7, '300g', 3, 23);
insert into product values(product_no.nextval, '��Ű��', 40000, 'rice_whitericebrownrice_milkyqueen.jpg', 'rice_whitericebrownrice_milkyqueen_1.jpg', 4.1, '4kg', 3, 20);
insert into product values(product_no.nextval, '�������', 15000, 'rice_whitericebrownrice_whiterice.jpg', 'rice_whitericebrownrice_whiterice_1.jpg', 4.1, '1.8kg', 3, 20);
insert into product values(product_no.nextval, '15�� �����', 12000, 'rice_mixgrainsbeansesame_deluxerice.jpg', 'rice_mixgrainsbeansesame_deluxerice_1.jpg', 3.4, '1kg', 3, 22);
insert into product values(product_no.nextval, '�͸�', 8000, 'rice_mixgrainsbeansesame_oats.jpg', 'rice_mixgrainsbeansesame_oats_1.jpg', 3.4, '300g', 3, 22);
insert into product values(product_no.nextval, '�͸� ȥ�հ�', 9500, 'rice_mixgrainsbeansesame_mixoats.jpg', 'rice_mixgrainsbeansesame_mixoats_1.jpg', 3.9, '300g', 3, 22);
insert into product values(product_no.nextval, '����', 9000, 'rice_mixgrainsbeansesame_whitecoating.jpg', 'rice_mixgrainsbeansesame_whitecoating_1.jpg', 3.8, '500g', 3, 22);
insert into product values(product_no.nextval, '����', 12000, 'rice_mixgrainsbeansesame_barley.jpg', 'rice_mixgrainsbeansesame_barley_1.jpg', 3.5, '500g', 3, 22);
insert into product values(product_no.nextval, '��ȥ�հ�', 13000, 'rice_mixgrainsbeansesame_blackmix.jpg', 'rice_mixgrainsbeansesame_blackmix_1.jpg', 3.2, '1kg', 3, 22);
insert into product values(product_no.nextval, '�Ƹ�����', 16000, 'rice_mixgrainsbeansesame_amaranth.jpg', 'rice_mixgrainsbeansesame_amaranth_1.jpg', 3.6, '300g', 3, 22);
insert into product values(product_no.nextval, '����', 16000, 'rice_mixgrainsbeansesame_adlay.jpg', 'rice_mixgrainsbeansesame_adlay_1.jpg', 3.9, '500g', 3, 22);
insert into product values(product_no.nextval, '����', 18000, 'rice_mixgrainsbeansesame_redbean.jpg', 'rice_mixgrainsbeansesame_redbean_1.jpg', 3.9, '800g', 3, 22);
insert into product values(product_no.nextval, '����-��', 16000, 'rice_mixgrainsbeansesame_redbeans.jpg', 'rice_mixgrainsbeansesame_redbeans_1.jpg', 4.3, '500g', 3, 22);
insert into product values(product_no.nextval, '����', 13000, 'rice_mixgrainsbeansesame_millet.jpg', 'rice_mixgrainsbeansesame_millet_1.jpg', 4.1, '500g', 3, 22);
insert into product values(product_no.nextval, '������', 5000, 'rice_mixgrainsbeansesame_barley.jpg', 'rice_mixgrainsbeansesame_barley_1.jpg', 4.2, '500g', 3, 22);
insert into product values(product_no.nextval, '������', 13000, 'rice_mixgrainsbeansesame_millets.jpg', 'rice_mixgrainsbeansesame_millets_1.jpg', 3.7, '500g', 3, 22);
insert into product values(product_no.nextval, '�������', 18000, null, '��̿�����', 4.8, '1.8kg', 3, 21);
insert into product values(product_no.nextval, '�뿬��', 6000, null, '�����ѿ���', 3.2, '400g', 3, 11);
insert into product values(product_no.nextval, '����', 6000, null, '������ ����ϴ�', 3.7, '300g', 3, 11);
insert into product values(product_no.nextval, '�ް���', 4500, null, '�ܹ����', 4.8, '1kg', 3, 11);
insert into product values(product_no.nextval, '�޹����', 7000, null, '���޴���', 4.3, '800g', 3, 11);
insert into product values(product_no.nextval, '��ȣ�ڰ���', 8000, null, '�����Ѱ���', 4.6, '800g', 3, 11);
insert into product values(product_no.nextval, '����', 6000, null, '���̹�����', 3.7, '1����', 3, 14);
insert into product values(product_no.nextval, '����', 3000, null, '��������', 3.5, '100g', 3, 14);
insert into product values(product_no.nextval, '����ݸ�', 5000, null, '�̽���', 4.8, '1����', 3, 17);
insert into product values(product_no.nextval, '��Ʈ', 5000, null, '�̽��Ѻ�Ʈ', 4.2, '1��', 3, 17);
insert into product values(product_no.nextval, '���� �ø��ö��', 6000, null, '�̽���', 4.8, '300g', 3, 17);
insert into product values(product_no.nextval, '�ٴ�', 2000, null, '�̱̽ٴ�', 3.7, '150g', 3, 12);
insert into product values(product_no.nextval, '�������̹���', 7000, null, '���簡����', 4.8, '40g', 3, 18);
insert into product values(product_no.nextval, '��Ÿ������', 3000, null, '���ִ´�Ÿ��', 3.6, '300g', 3, 18);
insert into product values(product_no.nextval, '����̹���', 5000, null, '���̼���', 3.5, '200g', 3, 18);
insert into product values(product_no.nextval, '���̹���', 3000, null, '���簡�ִ¹���', 3.6, '2��', 3, 18);
insert into product values(product_no.nextval, '���볪��', 40000, null, '��������', 3.9, '300g', 3, 16);
insert into product values(product_no.nextval, '��Ȳ�ݰǰ�縮', 80000, null, 'Ȳ�ݳ���', 4.8, '600g', 3, 16);
insert into product values(product_no.nextval, '�񸶴�', 10000, null, '��������', 3.8, '500g', 3, 13);
insert into product values(product_no.nextval, '����', 5000, null, '��������',4.5, '1kg', 3, 13);
insert into product values(product_no.nextval, '����', 5000, null, '�ſ����',4.2, '1kg', 3, 13);
insert into product values(product_no.nextval, '����', 3000, null, '���������',4.6, '2��', 3, 15);
insert into product values(product_no.nextval, '��¯', 10000, null, 'ȣ�ڰ���',3.6, '3��', 3, 15);
insert into product values(product_no.nextval, '����', 3000, null, '�������',4.8, '2��', 3, 15);
insert into product values(product_no.nextval, '�¾����ްǰ���', 4000, null, '�¾翡����',4.8, '500g', 3, 19);
insert into product values(product_no.nextval, '������ī', 4500, null, '����������ī',4.3, '1��', 3, 19);


insert into product values(product_no.nextval, '��Ű����ǰ', 100000, 'hospitalset.png', 'hospitalset_1.jpg', 3.7,'�ٱ���', null, null);

delete product where product_no >= 52

-- package ���̺�---------------------------------------------------------------
drop table package;
select * from package;
������
drop sequence package_no;
create sequence package_no;

select * from product;
delete product where product_no > 43

create table package (
package_pk number(5) primary key,
package_no number(5) references product(product_no) on delete cascade,
product_no number(5) references product(product_no) on delete cascade
)

����
insert into package values(package_no.nextval, 4, 1);
insert into package values(package_no.nextval, 52, 2);
insert into package values(package_no.nextval, 52, 3);

delete package where package_pk > 0

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
insert into certification values(certification_no.nextval, 'bpafree.png', 'bpafree', 'ȯ��ȣ������ �����A�� ������� ���� ģȯ�� ��ǰ�Դϴ�.');
insert into certification values(certification_no.nextval, 'gap.png', 'GAP', '��� ��깰 ������ũ�Դϴ�.');
insert into certification values(certification_no.nextval, 'joetanso.png', '��ź��', '��ź�Ҹ� �����ϴ� ������ũ�Դϴ�.');
insert into certification values(certification_no.nextval, 'munongyag.png', '�����', '����� ������� �ʰ� ����� ��ǰ�� �����ϴ� ��ũ�Դϴ�.');
insert into certification values(certification_no.nextval, 'youginong.png', '������ǰ', '����� ��ǰ ������ũ�Դϴ�.');

delete certification where certification_no > 0 

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
insert into product_certification values (product_certification_no.nextval, 2,1);
insert into product_certification values (product_certification_no.nextval, 3,1);
insert into product_certification values (product_certification_no.nextval, 1,2);
insert into product_certification values (product_certification_no.nextval, 2,3);
insert into product_certification values (product_certification_no.nextval, 2,4);
insert into product_certification values (product_certification_no.nextval, 1,5);
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
insert into purchase_state values(purchase_state_no.nextval, 'ȯ�ҽ�û');
insert into purchase_state values(purchase_state_no.nextval, '��ǰ��û');
insert into purchase_state values(purchase_state_no.nextval, '��ȯ��û');
insert into purchase_state values(purchase_state_no.nextval, 'ȯ�ҿϷ�');
insert into purchase_state values(purchase_state_no.nextval, '��ǰ�Ϸ�');
insert into purchase_state values(purchase_state_no.nextval, '��ȯ�Ϸ�');

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
insert into purchase values(purchase_no.nextval, '20160101', 15000, 'card', 0, 2, 'apple@naver.com');
insert into purchase values(purchase_no.nextval, '20160201', 20000, 'card', 0, 2, 'banana@daum.net');
insert into purchase values(purchase_no.nextval, '20160301', 5000, 'card', 0, 2, 'grape@daum.net');
insert into purchase values(purchase_no.nextval, '20160401', 30000, 'card', 0, 2, 'mango@naver.com');
insert into purchase values(purchase_no.nextval, '20160501', 9000, 'card', 0, 2, 'melon@naver.com');
insert into purchase values(purchase_no.nextval, '20160601', 80000, 'card', 0, 2, 'orange@naver.com');
insert into purchase values(purchase_no.nextval, '20160701', 50000, 'card', 0, 2, 'peach@hotmail.com');
insert into purchase values(purchase_no.nextval, '20160801', 10000, 'card', 0, 2, 'pineapple@daum.net');
insert into purchase values(purchase_no.nextval, '20160901', 120000, 'card', 0, 2, 'pineapple@daum.net');
insert into purchase values(purchase_no.nextval, '20161001', 35000, 'card', 0, 2, 'orange@naver.com');
insert into purchase values(purchase_no.nextval, '20161101', 10000, 'card', 0, 2, 'pineapple@daum.net');
insert into purchase values(purchase_no.nextval, '20160301', 70000, 'card', 0, 2, 'orange@naver.com');
insert into purchase values(purchase_no.nextval, '20160801', 20000, 'card', 0, 2, 'banana@daum.net');
insert into purchase values(purchase_no.nextval, '20160501', 8000, 'card', 0, 2, 'banana@daum.net');
insert into purchase values(purchase_no.nextval, '20161101', 10000, 'card', 0, 2, 'grape@daum.net');
insert into purchase values(purchase_no.nextval, '20160101', 20000, 'card', 0, 2, 'grape@daum.net');
insert into purchase values(purchase_no.nextval, '20160301', 20000, 'card', 0, 2, 'orange@naver.com');
insert into purchase values(purchase_no.nextval, '20160301', 100000, 'card', 0, 2, 'peach@hotmail.com');


delete purchase
-- purchase_order ���̺�--------------------------------------------------------
drop table purchase_order;
select * from purchase_order;

create table purchase_order (
purchase_no number(5) primary key references purchase(purchase_no) on delete cascade,
purchase_order_name varchar2(15) not null,
purchase_order_addr varchar2(150) not null,
purchase_order_detail_addr varchar2(90) not null,
purchase_order_postcode varchar2(10) not null,
purchase_order_email varchar2(50),
purchase_order_phone varchar2(15) not null
)

����
insert into purchase_order values(2, '�ڿ��', '��⵵ ������ �ȴޱ�', '1����', 15152, 'apple@naver.com', '010-1291-3222');
insert into purchase_order values(2, '������', '����', '��ȱ�', 15152, 'google.com', '010');

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
insert into purchase_product values(1, 3, 1);

insert into purchase_product values(2, 2, 1);
insert into purchase_product values(1, 4, 1);

-- cart ���̺�------------------------------------------------------------------
drop table cart;
select * from cart;

create table cart (
member_email varchar2(50) references member(member_email) on delete cascade,
product_no number(5) references product(product_no) on delete cascade,
cart_num number(2) default 1,
primary key(member_email, product_no)
)

����
'�ڿ��' ȸ���� ��ٱ��Ͽ��� 1,5�� ��ǰ�� ���� 1,2���� �������
insert into cart values('�ڿ��', 1, 1 );
insert into cart values('�ڿ��', 5, 2 );

'�ӱٹ�' ȸ���� ��ٱ��Ͽ��� 1,5�� ��ǰ�� ���� 1,2���� �������
insert into cart values('�ӱٹ�', 2, 1 );
insert into cart values('�ӱٹ�', 3, 5 );

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
community_state number(1) not null,
community_producer_no number(5) references producer(producer_no) on delete cascade

)

����
insert into community values(community_no.nextval, '����ü��', 'kimjang.jpg', 'kimjang1.png', sysdate, 1,1);
insert into community values(community_no.nextval, '����ĳ��', 'potato.png', 'potato1.png', sysdate, 1,2);
insert into community values(community_no.nextval, '����ä�����', 'nangyee.jpg', 'nangyee1.png', sysdate, 1,3);
insert into community values(community_no.nextval, '���ݱ�', 'bam.png', 'bam1.png', sysdate, 2,4);
insert into community values(community_no.nextval, '�������', 'apple.png', 'apple1.png', sysdate, 2,5);
insert into community values(community_no.nextval, '������Ȯ', 'podo.jpg', 'podo1.png', sysdate, 2,6);

delete community where community_no > 16

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
member_email varchar2(50) references member(member_email) on delete cascade,
community_comment_parent number(5) references community_comment(community_comment_no) on delete cascade
)

����
insert into community_comment values(community_comment_no.nextval, sysdate, '�����ϰ�;��', 1, '�ڿ��',null);

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
qna_parent number(5) references qna(qna_no) on delete cascade,
answer_state varchar2(6)
)

alter table qna add answer_state varchar2(6)

����
insert into qna values(qna_no.nextval, '��۳�¥ ���ǵ帳�ϴ�~', '12�� 3�Ͽ� �ֹ��ߴµ� �������� ��� �غ����ε� ���� ��۵ǳ���', '123', sysdate, '�ڿ��', null, 'N');
insert into qna values(qna_no.nextval, '��۳�¥ ���ǵ帳�ϴ�~', '�����̾� �³���?', '123', sysdate, '�̼���',2,'Y');
insert into qna values(qna_no.nextval, '��۳�¥ ���ǵ帳�ϴ�~', '�̰Թ�����?', '123', sysdate, '������',3,'N');
insert into qna values(qna_no.nextval, 'admin', '�亯�Դϴ�!', 'amdin', sysdate, '������', 1, 'N');
insert into qna values(qna_no.nextval, 'admin', '�亯�Դϴ�!', 'admin', sysdate, 'admin', 1, null)
insert into qna values(qna_no.nextval, 'admin', '�亯�Դϴٴ�!', 'admin', sysdate, 'admin', 8, null)

update qna set answer_state = 'Y' where qna_no = 1
delete qna where qna_name = 'undefined'

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
information_register_date date,
information_profile varchar2(300) not null
)
	
����
insert into information values(information_no.nextval, '4���� ��ö ��ǰ �ƽ��Ķ�Ž�', 'asparagus.png', sysdate, 'asparagus_2.png');
insert into information values(information_no.nextval, 'ģȯ�� ���� ǰ�� & ����', 'buchu.png', sysdate, 'buchu_2.png');
insert into information values(information_no.nextval, '���⿡ ���� ��', 'cold.png', sysdate, 'cold_2.png');
insert into information values(information_no.nextval, '�������� ȿ��', 'goguma.png', sysdate, 'goguma_2.png');
insert into information values(information_no.nextval, '������ ���ſ��', 'manuljong.png', sysdate, 'manuljong_2.png');
insert into information values(information_no.nextval, '5���� ��ö��ǰ ����', 'odi.png', sysdate, 'odi_2.png');
insert into information values(information_no.nextval, 'ģȯ�� ������ ǰ�� & ����', 'podo.png', sysdate, 'podo_2.png');
insert into information values(information_no.nextval, '������ ����� & ȿ��', 'yangpa.png', sysdate, 'yangpa_2.png');

-- mileage ���̺�-----------------------------------------------------------
drop table mileage;
select * from mileage;
������
drop sequence mileage_no;
create sequence mileage_no;

create table mileage (
mileage_no number(5) primary key,
mileage_date date not null,
mileage_price number(10) not null,
mileage_state varchar2(20) not null,
member_email varchar2(50) references member(member_email) on delete cascade
)

-- test

select purchase_product.product_no 
from purchase, purchase_product
where purchase.purchase_no = purchase_product.purchase_no and purchase.purchase_state_no = 2 and purchase.member_email = 'grape@daum.net' order by purchase.purchase_date desc