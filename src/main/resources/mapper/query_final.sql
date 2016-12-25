donation_org -> donation -> member -> producer -> category -> sub_category -> product -> package -> certification -> product_certification
-> purchase_state -> purchase -> purchase_order -> purchase_product -> cart -> product_comment -> commuinty -> community_comment -> qna -> information
  
테이블 삭제 순서
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
donation_org_desc varchar2(300) not null,
donation_org_profile varchar2(100)
)

삽입
insert into donation_org values(donation_org_no.nextval, '유니세프','02-737-1004','서울시 마포구 서강로 60(창전동)',
'1946년에 창립된 유엔기구로써 유니세프는 지속가능개발목표를 달성하기 위해 보건,식수와위생,영양,어린이보호 등 7가지 중점 사업분야를 정하고 여러 보호사업을 펼치고 있는 단체입니다.',
'unicfLogo.jpg');

update donation_org set donation_org_profile = 'unicfLogo.jpg';

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

insert into member values('admin', '123', '관리자', '000', sysdate, 0, null, 1);

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
producer_register_date date not null,
producer_profile varchar2(100) not null
)

삽입
insert into producer values(producer_no.nextval, '강기식','경상북도 경주시 양북면 안동리 253-1','031-749-8569', sysdate,'farmer1.jpg');
insert into producer values(producer_no.nextval, '류승빈','경기도 이천시 창전동 85-23','010-568-5584', sysdate,'farmer2.jpg');
insert into producer values(producer_no.nextval, '이정동','경상북도 영주시 영주동 산13','010-2433-6587', sysdate,'farmer3.jpg');
insert into producer values(producer_no.nextval, '박남길','전라남도 여수시 종화동 403-1','054-528-7645', sysdate,'farmer4.jpg');
insert into producer values(producer_no.nextval, '허영남','강원도 속초시 영랑동 113-13','031-8115-5756', sysdate,'farmer5.jpg');
insert into producer values(producer_no.nextval, '김순자','강원도 정선군 정선읍 봉양리 1-67','031-7142-2128', sysdate,'farmer6.jpg');

delete producer where producer_no > 0

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
insert into product values(product_no.nextval, '청도반시 감말랭이', 14800, 'fruit_persimmon_drypersimmon.jpg', 'fruit_persimmon_drypersimmon_1.jpg', 3.7, '800g', 1, 4);
insert into product values(product_no.nextval, '마이스터 감귤', 11800, 'fruit_mandarinhanrabong_mandarin.jpg', 'fruit_mandarinhanrabong_mandarin_1.jpg', 4.0, '20kg', 2, 5);
insert into product values(3, '제주 노지감귤', 19000, 'fruit_mandarinhanrabong_nozimandarin.jpg', 'fruit_mandarinhanrabong_nozimandarin_1.jpg', 4.6, '20kg', 3, 5);
insert into product values(product_no.nextval, '황금향', 38000, 'fruit_mandarinhanrabong_goldmandarin.jpg', 'fruit_mandarinhanrabong_goldmandarin_1.jpg', 3.9, '20kg', 4, 5);
insert into product values(product_no.nextval, '견과믹스', 8000, 'fruit_nut_mixmut.jpg', 'fruit_nut_mixmut_1.jpg', 3.0, '1kg', 5, 8);
insert into product values(product_no.nextval, '건조블루베리', 18000, 'fruit_strawberryblueberry_blueberry.jpg', 'fruit_strawberryblueberry_blueberry_1.jpg', 3.0, '600g', 6, 2);
insert into product values(product_no.nextval, '냉동산딸기', 8800, 'fruit_strawberryblueberry_mountainstrawberry.jpg', 'fruit_strawberryblueberry_mountainstrawberry_1.jpg', 3.0, '800g', 2, 2);
insert into product values(product_no.nextval, '건대추', 9800, 'fruit_peanutpinenutwalnut_jujube.jpg', 'fruit_peanutpinenutwalnut_jujube_1.jpg', 3.0, '330g', 2, 6);
insert into product values(product_no.nextval, '우리나라 맛밤', 3300, 'fruit_peanutpinenutwalnut_chestnut.jpg', 'fruit_peanutpinenutwalnut_chestnut_1.jpg', 3.0, '80g', 2, 6);
insert into product values(product_no.nextval, '백잣', 16500, 'fruit_peanutpinenutwalnut_pinenut.jpg', 'fruit_peanutpinenutwalnut_pinenut_1.jpg', 3.5, '140g', 2, 6);
insert into product values(product_no.nextval, '생캐슈넛', 12000, 'fruit_peanutpinenutwalnut_cashewnut.jpg', 'fruit_peanutpinenutwalnut_cashewnut_1.jpg', 4.0, '150g', 2, 6);
insert into product values(product_no.nextval, '생호박씨', 8000, 'fruit_peanutpinenutwalnut_pumpkinnut.jpg', 'fruit_peanutpinenutwalnut_pumpkinnut_1.jpg', 2.8, '170g', 2, 6);
insert into product values(product_no.nextval, '통살호두', 19800, 'fruit_peanutpinenutwalnut_walnut.jpg', 'fruit_peanutpinenutwalnut_walnut_1.jpg', 4.5, '100g', 2, 6);
insert into product values(product_no.nextval, '해바라기씨', 18800, 'fruit_peanutpinenutwalnut_sunflowerseed.jpg', 'fruit_peanutpinenutwalnut_sunflowerseed_1.jpg', 3.7, '300g', 2, 6);
insert into product values(product_no.nextval, '바나나', 3900, 'fruit_bananakiwitomato_banana.jpg', 'fruit_bananakiwitomato_banana_1.jpg', 3.3, '300g', 2, 3);
insert into product values(product_no.nextval, '방울토마토', 7800, 'fruit_bananakiwitomato_minitomato.jpg', 'fruit_bananakiwitomato_minitomato_1.jpg', 3.9, '900g', 2, 3);
insert into product values(product_no.nextval, '내 사랑 토마토', 15500, 'fruit_bananakiwitomato_tomato.jpg', 'fruit_bananakiwitomato_tomato_2.jpg', 3.9, '2kg', 2, 3);
insert into product values(product_no.nextval, '껍질째 먹는 사과', 12800, 'fruit_applepear_apple.jpg', 'fruit_applepear_apple_1.jpg', 3.8, '2.3kg', 2, 1);
insert into product values(product_no.nextval, '미니사과', 5900, 'fruit_applepear_miniapple.jpg', 'fruit_applepear_miniapple_1.jpg', 2.2, '10입', 2, 1);
insert into product values(product_no.nextval, '배', 8900, 'fruit_applepear_pear.jpg', 'fruit_applepear_pear_1.jpg', 4.3, '3입', 2, 1);
insert into product values(product_no.nextval, '달콤한 초록 친구 멜론', 11800, 'fruit_melon_melon.jpg', 'fruit_melon_melon_1.jpg', 4.9, '1.6kg', 2, 9);
insert into product values(product_no.nextval, '깐들깨가루', 18500, 'rice_pepperpowdermisutpowdergrainpowder_perillapowder.jpg', 'rice_pepperpowdermisutpowdergrainpowder_perillapowder_1.jpg', 4.0, '270g', 3, 23);
insert into product values(product_no.nextval, '볶음콩가루', 16500, 'rice_pepperpowdermisutpowdergrainpowder_beanpowder.jpg', 'rice_pepperpowdermisutpowdergrainpowder_beanpowder_1.jpg', 3.8, '300g', 3, 23);
insert into product values(product_no.nextval, '볶음현미가루', 5500, 'rice_pepperpowdermisutpowdergrainpowder_mixedbrownricepowder.jpg', 'rice_pepperpowdermisutpowdergrainpowder_mixedbrownricepowder_1.jpg', 3.8, '300g', 3, 23);
insert into product values(product_no.nextval, '시골애고춧가루', 32220, 'rice_pepperpowdermisutpowdergrainpowder_pepperpowder.jpg', 'rice_pepperpowdermisutpowdergrainpowder_pepperpowder_1.jpg', 4.2, '500g', 3, 23);
insert into product values(product_no.nextval, '찹쌀가루', 4900, 'rice_pepperpowdermisutpowdergrainpowder_glutinousriceflour.jpg', 'rice_pepperpowdermisutpowdergrainpowder_glutinousriceflour_1.jpg', 4.2, '350g', 3, 23);
insert into product values(product_no.nextval, '태양초 햇고춧가루', 40000, 'rice_pepperpowdermisutpowdergrainpowder_hatpepperpowder.jpg', 'rice_pepperpowdermisutpowdergrainpowder_hatpepperpowder_1.jpg', 4.5, '2.2kg', 3, 23);
insert into product values(product_no.nextval, '현미가루', 5000, 'rice_pepperpowdermisutpowdergrainpowder_brownricepowder.jpg', 'rice_pepperpowdermisutpowdergrainpowder_brownricepowder_1.jpg', 3.7, '300g', 3, 23);
insert into product values(product_no.nextval, '밀키퀸', 40000, 'rice_whitericebrownrice_milkyqueen.jpg', 'rice_whitericebrownrice_milkyqueen_1.jpg', 4.1, '4kg', 3, 20);
insert into product values(product_no.nextval, '백미찹쌀', 15000, 'rice_whitericebrownrice_whiterice.jpg', 'rice_whitericebrownrice_whiterice_1.jpg', 4.1, '1.8kg', 3, 20);
insert into product values(product_no.nextval, '15곡 영양밥', 12000, 'rice_mixgrainsbeansesame_deluxerice.jpg', 'rice_mixgrainsbeansesame_deluxerice_1.jpg', 3.4, '1kg', 3, 22);
insert into product values(product_no.nextval, '귀리', 8000, 'rice_mixgrainsbeansesame_oats.jpg', 'rice_mixgrainsbeansesame_oats_1.jpg', 3.4, '300g', 3, 22);
insert into product values(product_no.nextval, '귀리 혼합곡', 9500, 'rice_mixgrainsbeansesame_mixoats.jpg', 'rice_mixgrainsbeansesame_mixoats_1.jpg', 3.9, '300g', 3, 22);
insert into product values(product_no.nextval, '백태', 9000, 'rice_mixgrainsbeansesame_whitecoating.jpg', 'rice_mixgrainsbeansesame_whitecoating_1.jpg', 3.8, '500g', 3, 22);
insert into product values(product_no.nextval, '보리', 12000, 'rice_mixgrainsbeansesame_barley.jpg', 'rice_mixgrainsbeansesame_barley_1.jpg', 3.5, '500g', 3, 22);
insert into product values(product_no.nextval, '블랙혼합곡', 13000, 'rice_mixgrainsbeansesame_blackmix.jpg', 'rice_mixgrainsbeansesame_blackmix_1.jpg', 3.2, '1kg', 3, 22);
insert into product values(product_no.nextval, '아마란스', 16000, 'rice_mixgrainsbeansesame_amaranth.jpg', 'rice_mixgrainsbeansesame_amaranth_1.jpg', 3.6, '300g', 3, 22);
insert into product values(product_no.nextval, '율무', 16000, 'rice_mixgrainsbeansesame_adlay.jpg', 'rice_mixgrainsbeansesame_adlay_1.jpg', 3.9, '500g', 3, 22);
insert into product values(product_no.nextval, '적두', 18000, 'rice_mixgrainsbeansesame_redbean.jpg', 'rice_mixgrainsbeansesame_redbean_1.jpg', 3.9, '800g', 3, 22);
insert into product values(product_no.nextval, '적두-팥', 16000, 'rice_mixgrainsbeansesame_redbeans.jpg', 'rice_mixgrainsbeansesame_redbeans_1.jpg', 4.3, '500g', 3, 22);
insert into product values(product_no.nextval, '차조', 13000, 'rice_mixgrainsbeansesame_millet.jpg', 'rice_mixgrainsbeansesame_millet_1.jpg', 4.1, '500g', 3, 22);
insert into product values(product_no.nextval, '찰보리', 5000, 'rice_mixgrainsbeansesame_barley.jpg', 'rice_mixgrainsbeansesame_barley_1.jpg', 4.2, '500g', 3, 22);
insert into product values(product_no.nextval, '찰수수', 13000, 'rice_mixgrainsbeansesame_millets.jpg', 'rice_mixgrainsbeansesame_millets_1.jpg', 3.7, '500g', 3, 22);
insert into product values(product_no.nextval, '백미찹쌀', 18000, null, '백미와찹쌀', 4.8, '1.8kg', 3, 21);
insert into product values(product_no.nextval, '통연근', 6000, null, '깨끗한연근', 3.2, '400g', 3, 11);
insert into product values(product_no.nextval, '통우엉', 6000, null, '찰지고 고소하다', 3.7, '300g', 3, 11);
insert into product values(product_no.nextval, '햇감자', 4500, null, '단백달콤', 4.8, '1kg', 3, 11);
insert into product values(product_no.nextval, '햇밤고구마', 7000, null, '달콤달콤', 4.3, '800g', 3, 11);
insert into product values(product_no.nextval, '햇호박고구마', 8000, null, '달콤한고구마', 4.6, '800g', 3, 11);
insert into product values(product_no.nextval, '배추', 6000, null, '잎이무성한', 3.7, '1포기', 3, 14);
insert into product values(product_no.nextval, '상추', 3000, null, '무농약상추', 3.5, '100g', 3, 14);
insert into product values(product_no.nextval, '브로콜리', 5000, null, '싱싱한', 4.8, '1송이', 3, 17);
insert into product values(product_no.nextval, '비트', 5000, null, '싱싱한비트', 4.2, '1잎', 3, 17);
insert into product values(product_no.nextval, '조각 컬리플라워', 6000, null, '싱싱한', 4.8, '300g', 3, 17);
insert into product values(product_no.nextval, '근대', 2000, null, '싱싱근대', 3.7, '150g', 3, 12);
insert into product values(product_no.nextval, '건조목이버섯', 7000, null, '영양가득한', 4.8, '40g', 3, 18);
insert into product values(product_no.nextval, '느타리버섯', 3000, null, '맛있는느타리', 3.6, '300g', 3, 18);
insert into product values(product_no.nextval, '양송이버섯', 5000, null, '송이송이', 3.5, '200g', 3, 18);
insert into product values(product_no.nextval, '팽이버섯', 3000, null, '영양가있는버섯', 3.6, '2봉', 3, 18);
insert into product values(product_no.nextval, '건취나물', 40000, null, '말린나물', 3.9, '300g', 3, 16);
insert into product values(product_no.nextval, '햇황금건고사리', 80000, null, '황금나물', 4.8, '600g', 3, 16);
insert into product values(product_no.nextval, '깐마늘', 10000, null, '까진마늘', 3.8, '500g', 3, 13);
insert into product values(product_no.nextval, '대파', 5000, null, '까진마늘',4.5, '1kg', 3, 13);
insert into product values(product_no.nextval, '양파', 5000, null, '매운양파',4.2, '1kg', 3, 13);
insert into product values(product_no.nextval, '가지', 3000, null, '보라색가지',4.6, '2입', 3, 15);
insert into product values(product_no.nextval, '보짱', 10000, null, '호박같은',3.6, '3입', 3, 15);
insert into product values(product_no.nextval, '오이', 3000, null, '녹색오이',4.8, '2입', 3, 15);
insert into product values(product_no.nextval, '태양초햇건고추', 4000, null, '태양에말린',4.8, '500g', 3, 19);
insert into product values(product_no.nextval, '파프리카', 4500, null, '붉은파프리카',4.3, '1입', 3, 19);


insert into product values(product_no.nextval, '패키지상품', 100000, 'hospitalset.png', 'hospitalset_1.jpg', 3.7,'바구니', null, null);

delete product where product_no >= 52

-- package 테이블---------------------------------------------------------------
drop table package;
select * from package;
시퀀스
drop sequence package_no;
create sequence package_no;

select * from product;
delete product where product_no > 43

create table package (
package_pk number(5) primary key,
package_no number(5) references product(product_no) on delete cascade,
product_no number(5) references product(product_no) on delete cascade
)

삽입
insert into package values(package_no.nextval, 4, 1);
insert into package values(package_no.nextval, 52, 2);
insert into package values(package_no.nextval, 52, 3);

delete package where package_pk > 0

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
insert into certification values(certification_no.nextval, 'bpafree.png', 'bpafree', '환경호르몬인 비스페놀A가 검출되지 않은 친환경 제품입니다.');
insert into certification values(certification_no.nextval, 'gap.png', 'GAP', '우수 농산물 보증마크입니다.');
insert into certification values(certification_no.nextval, 'joetanso.png', '저탄소', '저탄소를 배출하는 인증마크입니다.');
insert into certification values(certification_no.nextval, 'munongyag.png', '무농약', '농약을 사용하지 않고 재배한 제품을 인증하는 마크입니다.');
insert into certification values(certification_no.nextval, 'youginong.png', '유기농식품', '유기농 식품 인증마크입니다.');

delete certification where certification_no > 0 

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
insert into product_certification values (product_certification_no.nextval, 2,1);
insert into product_certification values (product_certification_no.nextval, 3,1);
insert into product_certification values (product_certification_no.nextval, 1,2);
insert into product_certification values (product_certification_no.nextval, 2,3);
insert into product_certification values (product_certification_no.nextval, 2,4);
insert into product_certification values (product_certification_no.nextval, 1,5);
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
insert into purchase_state values(purchase_state_no.nextval, '환불신청');
insert into purchase_state values(purchase_state_no.nextval, '반품신청');
insert into purchase_state values(purchase_state_no.nextval, '교환신청');
insert into purchase_state values(purchase_state_no.nextval, '환불완료');
insert into purchase_state values(purchase_state_no.nextval, '반품완료');
insert into purchase_state values(purchase_state_no.nextval, '교환완료');

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
-- purchase_order 테이블--------------------------------------------------------
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

삽입
insert into purchase_order values(2, '박용우', '경기도 수원시 팔달구', '1번지', 15152, 'apple@naver.com', '010-1291-3222');
insert into purchase_order values(2, '박태흠', '수원', '장안구', 15152, 'google.com', '010');

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
insert into purchase_product values(1, 3, 1);

insert into purchase_product values(2, 2, 1);
insert into purchase_product values(1, 4, 1);

-- cart 테이블------------------------------------------------------------------
drop table cart;
select * from cart;

create table cart (
member_email varchar2(50) references member(member_email) on delete cascade,
product_no number(5) references product(product_no) on delete cascade,
cart_num number(2) default 1,
primary key(member_email, product_no)
)

삽입
'박용우' 회원의 장바구니에는 1,5번 상품이 각각 1,2개씩 들어있음
insert into cart values('박용우', 1, 1 );
insert into cart values('박용우', 5, 2 );

'임근묵' 회원의 장바구니에는 1,5번 상품이 각각 1,2개씩 들어있음
insert into cart values('임근묵', 2, 1 );
insert into cart values('임근묵', 3, 5 );

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
community_state number(1) not null,
community_producer_no number(5) references producer(producer_no) on delete cascade

)

삽입
insert into community values(community_no.nextval, '김장체험', 'kimjang.jpg', 'kimjang1.png', sysdate, 1,1);
insert into community values(community_no.nextval, '감자캐기', 'potato.png', 'potato1.png', sysdate, 1,2);
insert into community values(community_no.nextval, '냉이채취행사', 'nangyee.jpg', 'nangyee1.png', sysdate, 1,3);
insert into community values(community_no.nextval, '밤줍기', 'bam.png', 'bam1.png', sysdate, 2,4);
insert into community values(community_no.nextval, '사과따기', 'apple.png', 'apple1.png', sysdate, 2,5);
insert into community values(community_no.nextval, '포도수확', 'podo.jpg', 'podo1.png', sysdate, 2,6);

delete community where community_no > 16

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
member_email varchar2(50) references member(member_email) on delete cascade,
community_comment_parent number(5) references community_comment(community_comment_no) on delete cascade
)

삽입
insert into community_comment values(community_comment_no.nextval, sysdate, '참여하고싶어요', 1, '박용우',null);

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
qna_parent number(5) references qna(qna_no) on delete cascade,
answer_state varchar2(6)
)

alter table qna add answer_state varchar2(6)

삽입
insert into qna values(qna_no.nextval, '배송날짜 문의드립니다~', '12월 3일에 주문했는데 아직까지 배송 준비중인데 언제 배송되나요', '123', sysdate, '박용우', null, 'N');
insert into qna values(qna_no.nextval, '배송날짜 문의드립니다~', '프리미엄 맞나요?', '123', sysdate, '이소희',2,'Y');
insert into qna values(qna_no.nextval, '배송날짜 문의드립니다~', '이게뭔가요?', '123', sysdate, '박태흠',3,'N');
insert into qna values(qna_no.nextval, 'admin', '답변입니다!', 'amdin', sysdate, '관리자', 1, 'N');
insert into qna values(qna_no.nextval, 'admin', '답변입니다!', 'admin', sysdate, 'admin', 1, null)
insert into qna values(qna_no.nextval, 'admin', '답변입니다다!', 'admin', sysdate, 'admin', 8, null)

update qna set answer_state = 'Y' where qna_no = 1
delete qna where qna_name = 'undefined'

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
information_register_date date,
information_profile varchar2(300) not null
)
	
삽입
insert into information values(information_no.nextval, '4월의 제철 식품 아스파라거스', 'asparagus.png', sysdate, 'asparagus_2.png');
insert into information values(information_no.nextval, '친환경 부추 품질 & 기준', 'buchu.png', sysdate, 'buchu_2.png');
insert into information values(information_no.nextval, '감기에 좋은 파', 'cold.png', sysdate, 'cold_2.png');
insert into information values(information_no.nextval, '고구마순의 효능', 'goguma.png', sysdate, 'goguma_2.png');
insert into information values(information_no.nextval, '마늘종 구매요령', 'manuljong.png', sysdate, 'manuljong_2.png');
insert into information values(information_no.nextval, '5월의 제철식품 오디', 'odi.png', sysdate, 'odi_2.png');
insert into information values(information_no.nextval, '친환경 포도의 품질 & 기준', 'podo.png', sysdate, 'podo_2.png');
insert into information values(information_no.nextval, '양파의 영양분 & 효능', 'yangpa.png', sysdate, 'yangpa_2.png');

-- mileage 테이블-----------------------------------------------------------
drop table mileage;
select * from mileage;
시퀀스
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