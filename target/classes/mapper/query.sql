donation_org -> donation -> member -> producer -> category -> sub_category -> product -> package -> package_product -> certification -> product_certification
-> purchase_state -> purchase -> purchase_order -> purchase_product -> cart -> product_comment -> commuinty -> community_comment -> qna -> information
select community_comment_no,community_comment_register,community_comment_content,member_email 
  from community_comment,community 
  where community.community_no=23 and community.community_no = community_comment.community_no 

  
  select community_comment_no,community_comment_register,community_comment_content,member_email from community_comment,community where community.community_no=23 and community.community_no = community_comment.community_no  
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
drop table package_product;
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
donation_org_desc varchar2(100) not null,
donation_org_profile varchar2(100)
)

donation_org_desc ������ ������ ����
ALTER TABLE donation_org
MODIFY (donation_org_desc VARCHAR2(300));


����
insert into donation_org values(donation_org_no.nextval, '���ϼ���','031-219-1542','��⵵','���ϼ����Դϴ�',null);

update donation_org set donation_org_desc='1946�⿡ â���� �����ⱸ�ν� ���ϼ����� ���Ӱ��ɰ��߸�ǥ�� �޼��ϱ� ���� ����,�ļ�������,����,��̺�ȣ �� 7���� ���� ����о߸� ���ϰ� ���� ��ȣ����� ��ġ�� �ִ� ��ü�Դϴ�.', 
donation_org_addr='����� ������ ������ 60(â����)',donation_org_phone='02-737-1004',donation_org_profile='unicfLogo.jpg' where donation_org_no=1;


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
producer_register_date date not null
)

alter table producer add producer_profile varchar2(100)


����
insert into producer values(producer_no.nextval, '���ֳ��','����Ư����','999', sysdate);
insert into producer values(producer_no.nextval, '��õ���','��⵵ ��õ','888', sysdate);
insert into producer values(producer_no.nextval, '������','��⵵ ����','777', sysdate);
insert into producer values(producer_no.nextval, '���ֳ��','���ϵ� ����','666', sysdate);
insert into producer values(producer_no.nextval, '���ֳ��','���󳲵� ����','555', sysdate);
insert into producer values(producer_no.nextval, '��õ���','���ϵ� ��õ','444', sysdate);

update producer set producer_name='�����',producer_addr='���ϵ� ���ֽ� ��ϸ� �ȵ��� 253-1',producer_phone='031-749-8569',producer_profile='farmer1.jpg' where producer_no=1;
update producer set producer_name='���º�',producer_addr='��⵵ ��õ�� â���� 85-23 ',producer_phone='0-568-5584',producer_profile='farmer2.jpg'  where producer_no=2;
update producer set producer_name='������',producer_addr='���ϵ� ���ֽ� ���ֵ� ��13 ',producer_phone='010-2433-6587',producer_profile='farmer3.jpg'  where producer_no=3;
update producer set producer_name='�ڳ���',producer_addr='���󳲵� ������ ��ȭ�� 403-1 ',producer_phone='054-5289-7645',producer_profile='farmer4.jpg'  where producer_no=4;
update producer set producer_name='�㿵��',producer_addr='������ ���ʽ� ������ 113-13 ',producer_phone='041-8115-5756',producer_profile='farmer5.jpg'  where producer_no=5;
update producer set producer_name='�����',producer_addr='������ ������ ������ ���縮 1-67 ',producer_phone='064-7142-212`1',producer_profile='farmer6.jpg'  where producer_no=6;



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

	select pd.product_profile, pd.product_name, pd.product_price, pc.producer_name, certi.certification_no
	from product pd, producer pc, product_certification certi
	where pd.producer_no=pc.producer_no and certi.product_no=pd.product_no
	
	
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
insert into product values(product_no.nextval, '���� ��������', 19000, 'fruit_mandarinhanrabong_nozimandarin.jpg', 'fruit_mandarinhanrabong_nozimandarin_1.jpg', 4.6, '20kg', 3, 5);
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
insert into product values(product_no.nextval, '�߾�����', 12000, 'rice_whitericebrownrice_balahyunmi.jpg', 'rice_whitericebrownrice_balahyunmi_1.jpg', 3.5, '1kg', 3, 20);
insert into product values(product_no.nextval, '�������', 15000, 'rice_whitericebrownrice_whiterice.jpg', 'rice_whitericebrownrice_whiterice_1.jpg', 4.1, '1.8kg', 3, 20);
insert into product values(product_no.nextval, '����������', 53000, 'rice_whitericebrownrice_chalhyunmi.jpg', 'rice_whitericebrownrice_chalhyunmi_1.jpg', 3.8, '8kg', 3, 20);
insert into product values(product_no.nextval, '15�� �����', 12000, 'rice_mixgrainsbeansesame_deluxerice.jpg', 'rice_mixgrainsbeansesame_deluxerice_1.jpg', 3.4, '1kg', 3, 22);
insert into product values(product_no.nextval, '�͸�', 8000, 'rice_mixgrainsbeansesame_oats.jpg', 'rice_mixgrainsbeansesame_oats_1.jpg', 3.4, '300g', 3, 22);
insert into product values(product_no.nextval, '�͸� ȥ�հ�', 9500, 'rice_mixgrainsbeansesame_mixoats.jpg', 'rice_mixgrainsbeansesame_mixoats_1.jpg', 3.9, '300g', 3, 22);
insert into product values(product_no.nextval, '����', 9000, 'rice_mixgrainsbeansesame_whitecoating.jpg', 'rice_mixgrainsbeansesame_whitecoating_1.jpg', 3.8, '500g', 3, 22);
insert into product values(product_no.nextval, '����', 12000, 'rice_mixgrainsbeansesame_barley.jpg', 'rice_mixgrainsbeansesame_barley_1.jpg', 3.5, '500g', 3, 22);
insert into product values(product_no.nextval, '��ȥ�հ�', 13000, 'rice_mixgrainsbeansesame_blackmix.jpg', 'rice_mixgrainsbeansesame_blackmix_1.jpg', 3.2, '1kg', 3, 22);
insert into product values(product_no.nextval, '�Ƹ�����', 16000, 'rice_mixgrainsbeansesame_amaranth.jpg', 'rice_mixgrainsbeansesame_amaranth_1.jpg', 3.6 '300g', 3, 22);
insert into product values(product_no.nextval, '����', 16000, 'rice_mixgrainsbeansesame_adlay.jpg', 'rice_mixgrainsbeansesame_adlay_1.jpg', 3.9, '500g', 3, 22);
insert into product values(product_no.nextval, '����', 18000, 'rice_mixgrainsbeansesame_redbean.jpg', 'rice_mixgrainsbeansesame_redbean_1.jpg', 3.9, '800g', 3, 22);
insert into product values(product_no.nextval, '����-��', 16000, 'rice_mixgrainsbeansesame_redbeans.jpg', 'rice_mixgrainsbeansesame_redbeans_1.jpg', 4.3, '500g', 3, 22);
insert into product values(product_no.nextval, '����', 13000, 'rice_mixgrainsbeansesame_millet.jpg', 'rice_mixgrainsbeansesame_millet_1.jpg', 4.1, '500g', 3, 22);
insert into product values(product_no.nextval, '������', 5000, 'rice_mixgrainsbeansesame_barley.jpg', 'rice_mixgrainsbeansesame_barley_1.jpg', 4.2, '500g', 3, 22);
insert into product values(product_no.nextval, '������', 13000, 'rice_mixgrainsbeansesame_millets.jpg', 'rice_mixgrainsbeansesame_millets_1.jpg', 3.7, '500g', 3, 22);

insert into product values(99, '��Ű����ǰ', 99999, 'hospitalset.png', 'hospitalset_1.jpg', 3.7,'�ٱ���', null, null);

-- package ���̺�---------------------------------------------------------------
drop table package;
select * from package;
������
drop sequence package_no;
create sequence package_no;

create table package (
package_pk number(5) primary key,
package_no number(5) references product(product_no) on delete cascade,
product_no number(5) references product(product_no) on delete cascade
)

alter table package drop column package_name;

����
insert into package values(package_no.nextval, 99, 1);
insert into package values(package_no.nextval, 99, 2);
insert into package values(package_no.nextval, 99, 3);

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
select product.product_name, product.product_price, producer.producer_name, product_certification.certification_no
	from product, producer, product_certification
	where product.product_no = product_certification.product_no and product.producer_no = producer.producer_no and product.product_no In (select package_product.product_no
	from package, product, package_product, producer
	where product.product_name='���Ϻ�����Ʈ' and product.product_no = package.product_no and package.package_no = package_product.package_no
	)
	
select product.product_name, product.product_price, producer.producer_name
	from product, producer
	where product.producer_no = producer.producer_no and product.product_no In (select package_product.product_no
	from package, product, package_product, producer
	where product.product_name= and product.product_no = package.product_no and package.package_no = package_product.package_no
	)	

����
insert into package_product values(package_product_no.nextval, 3, 1);
insert into package_product values(package_product_no.nextval, 3, 2);
insert into package_product values(package_product_no.nextval, 1, 2);
insert into package_product values(package_product_no.nextval, 1, 3);
insert into package_product values(package_product_no.nextval, 1, 4);
insert into package_product values(package_product_no.nextval, 1, 5);
insert into package_product values(package_product_no.nextval, 1, 6);

insert into pacakge_product values(package_product_no.nextval, 1, 1);
insert into pacakge_product values(package_product_no.nextval, 1, 2);
insert into pacakge_product values(package_product_no.nextval, 1, 3);

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

update certification set certification_image='bpafree.png',certification_name='bpafree',certification_desc='ȯ��ȣ������ �����A�� ������� ���� ģȯ�� ��ǰ�Դϴ�.' where certification_no=1;
update certification set certification_image='gap.png',certification_name='GAP',certification_desc='��� ��깰 ������ũ�Դϴ�. ' where certification_no=2;
update certification set certification_image='joetanso.png',certification_name='��ź��',certification_desc='��ź�Ҹ� �����ϴ� ������ũ�Դϴ�.' where certification_no=3;
update certification set certification_no=4,certification_image='muhangsaengchucsanmul.png',certification_name='���׻���',certification_desc='�׻����� ÷������ ���� ��ǰ�� �����ϴ� ��ũ�Դϴ�.' where certification_no=21;

insert into certification values(certification_no.nextval, 'munongyag.png', '�����', '����� ������� �ʰ� ����� ��ǰ�� �����ϴ� ��ũ�Դϴ�.');
insert into certification values(certification_no.nextval, 'youginong.png', '������ǰ', '����� ��ǰ ������ũ�Դϴ�.');



	
	
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

update purchase set purchase_price = 45600 where purchase_no = 1;
����
insert into purchase values(purchase_no.nextval, sysdate, 45600, 'card', 0, 2, '�ڿ��');
insert into purchase values(purchase_no.nextval, sysdate, 50000, 'card', 0, 2, '������');

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
select * from community where community_state=1;
������
drop sequence community_no;
create sequence community_no;

update community set community_profile ='rice_mixgrainsbeansesame_redbeans.jpg' where community_no=1;

community_state�� 1�̸� ������, 2�� ����Ϸ�
create table community (
community_no number(5) primary key,
community_name varchar2(30) not null,
community_profile varchar2(100),
community_desc varchar2(100),
community_register_date date,
community_state number(1) not null
)
SELECT * FROM community WHERE rownum <= 6 and community_state= 0

����
insert into community values(community_no.nextval, '��ġ��ױ����', null, '����������', sysdate, 1);
insert into community values(community_no.nextval, '��α��ױ����', null, '��α�������', sysdate, 0);
insert into community values(community_no.nextval, '����ġ��ױ����', null, '����ġ����', sysdate, 1);

insert into community values(community_no.nextval, '����ü��', 'kimjang.jpg', 'kimjang1.jpg', sysdate, 1);
insert into community values(community_no.nextval, '����ĳ��', 'potato.jpg', 'potato1.jpg', sysdate, 1);
insert into community values(community_no.nextval, '����ä�����', 'nangyee.jpg', 'nangyee1.jpg', sysdate, 1);
insert into community values(community_no.nextval, '���ݱ�', 'bam.jpg', 'bam1.jpg', sysdate, 2);
insert into community values(community_no.nextval, '�������', 'apple.jpg', 'apple1.jpg', sysdate, 2);
insert into community values(community_no.nextval, '������Ȯ', 'podo.jpg', 'podo1.jpg', sysdate, 2);


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
select * from qna order by product_no desc	
create table qna (
qna_no number(5) primary key,
qna_name varchar2(100) not null,
qna_desc varchar2(1000) not null,
qna_pwd varchar2(10) not null,
qna_register_date date,
member_email varchar2(50) references member(member_email) on delete cascade,
qna_parent number(5) references qna(qna_no) on delete cascade
)

alter table qna add answer_state varchar2(6)

����
insert into qna values(qna_no.nextval, '��۳�¥ ���ǵ帳�ϴ�~', '12�� 3�Ͽ� �ֹ��ߴµ� �������� ��� �غ����ε� ���� ��۵ǳ���', '123', sysdate, '�ڿ��', 1);
insert into qna values(qna_no.nextval, '��۳�¥ ���ǵ帳�ϴ�~', '�����̾� �³���?', '123', sysdate, '�̼���',2,'Y');
insert into qna values(qna_no.nextval, '��۳�¥ ���ǵ帳�ϴ�~', '�̰Թ�����?', '123', sysdate, '������',3,'N');

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


-- test

-- 1. ��Ű�� ��ǰ ����Ʈ �ҷ����� (ProductDTO�� ��ȯ)
select distinct t.product_no, t.product_name, t.product_price, t.product_profile, t.product_eval
from product t, package k
where t.product_no = k.package_no

-- 2. ��Ű�� ��ǰ �󼼺��� ������ ��, ��Ű�� ��ǰ ���� ������ �ҷ�����
select distinct t.product_no, t.product_profile, t.product_name, t.product_price, t.product_eval, t.product_desc, t.product_unit
from product t, package k
where t.product_no = k.package_no

-- 2-1. ��Ű�� ��ǰ �����ִ� ��ǰ���� ��� �ҷ�����
select t.product_profile, t.product_name, t.product_price
from product t, package k
where t.product_no = k.product_no