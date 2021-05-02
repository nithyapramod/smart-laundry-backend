drop table if exists user_types;
create table user_types(
    uuid varchar(50) not null,
	name varchar(50) NOT NULL , 
    user_type int(11)  not null, 
    status varchar(5) default 'A',
  	created_on datetime not null,
	updated_on timestamp not null default now(),
	PRIMARY KEY (uuid)
 );
 
insert into user_types (uuid,name,user_type,created_on) values ('ut_46a281d7aae44bb18a6330e947406616','Super Admin',1,now());
insert into user_types (uuid,name,user_type,created_on) values ('ut_4924261fb49240d3bd4db78f96a14511','Admin',2,now());
insert into user_types (uuid,name,user_type,created_on) values ('ut_1e18dff78cf54c2d92fad54be1e34763', 'Shop',3,now());
insert into user_types (uuid,name,user_type,created_on) values ('ut_0e18dff78cf54c2d92fad54be1e34762', 'Customer',4,now());

drop table if exists users;
create table users (
	uuid varchar(50) not null,
	parent_uuid varchar(50) default null,
	admin_uuid varchar(50) default null,
	user_name varchar(150) not null,
	first_name varchar(250) not null,
	last_name varchar(250) not null,
	shop_name varchar(150) default null,
 	email varchar(50) default null,
	phone_number varchar(10) not null ,
	password varchar(255)  not null,
	sex varchar(5) default null,
	user_type int(5) not null,
	city_name varchar(255) default null,
	state_name varchar(255) default null,
    landmark varchar(500)  default null,
	address varchar(500) default null,
	lat varchar(50) default '0.0',
	lng varchar(50) default '0.0',
    device_id varchar(50) not null,
	device_type varchar(50) default 'android' comment 'android or ios' ,
	status varchar(10) default 'A',
	fcm_key varchar(300) default null,
 	created_on datetime not null,
	updated_on timestamp not null default now(),
	primary key(uuid)
);
  
 INSERT INTO `users` (`uuid`, `user_name`, `first_name`, `last_name`, `shop_name`, `email`, `phone_number`, `password`, `sex`, `user_type`, `city_name`, `state_name`, `landmark`, `address`, `lat`, `lng`, `device_id`, `device_type`, `status`, `created_on`, `updated_on`) VALUES ('su_2ee17ce0bc7f4a5d866673f663478e45', 'gowtham.g', 'gowtham', 'g', 'supper admin', 'ggoutham2745@gmail.com', '9494005552', '827ccb0eea8a706c4c34a16891f84e7b', 'M', 1, 'HYd', 'Telangana', 'HYd', 'commnuity hall parvath nagar', '17.4574252', '78.3990049', '123444', 'android', 'A', '2020-06-11 08:30:05', '2020-06-11 08:30:05');

drop table if exists shop_verification;
create table shop_verification(
	uuid varchar(50) not null,
	admin_uuid varchar(50) not null,``
	shop_name varchar(150) not null,
	shop_uuid varchar(50) not null,
	shop_address varchar(500) not null,
	shop_phone_number varchar(10) not null,
	remarks varchar(500) default null,
	status varchar(20) default 'pending' comment '1 - verified and 2 - pending',
	created_on datetime not null,
	updated_on timestamp not null default now(),
	primary key(uuid)
);

 
drop table if exists user_logins;
create table user_logins(
	uuid varchar(50) not null,
	user_uuid varchar(50) not null,
	login_time timestamp not null default now(),
	primary key(uuid)
);
 
-- CREATE UNIQUE INDEX idx_name_phone ON users(user_name,phone_number);
-- drop index   idx_name_phone on  users; 
drop table if exists user_address;
create table user_address (
	uuid varchar(50) not null,
	user_uuid varchar(50) not null,
	house_no varchar(250) default null,
	landmark varchar(250) default null,
	address varchar(255) default null,
	address_type varchar(50) not null,
	city_name varchar(255) default null,
 	lat varchar(50) default '0.0',
	lng varchar(50) default '0.0',
	status varchar(10) default 'A',
	created_on datetime not null,
	updated_on timestamp not null default now(),
	primary key(uuid)
);

 
drop table if exists items;

CREATE TABLE items (
uuid varchar(50) not null,
shop_uuid varchar(50) default 'G',
unit_type varchar(10)default 'pc',
item_name varchar(100) NOT NULL,
status varchar(10) default 'A',
PRIMARY KEY(uuid)
);
-- alter table items add column unit_type varchar(10)default 'pc';

insert into items(uuid,item_name) values ('it_2149fe4b2e58477eb6d829594763da4c','Kerchief');
insert into items(uuid,item_name) values ('it_a353a3a0fbca4e64a9adda006ebdd17f','Dupatta');
insert into items(uuid,item_name) values ('it_a4e02d3873644763a8772271a8cfd35b','Gloves');
insert into items(uuid,item_name) values ('it_133ba4d561194328b776d97aa11b4d80','Pillow cover');
insert into items(uuid,item_name) values ('it_4e370bda0fc5497ab2344f751c22df10','Socks');
insert into items(uuid,item_name) values ('it_5377957d9e5345d283cc9dbd9593b164','Baniyan');
insert into items(uuid,item_name) values ('it_8dd8cb7a5eb74251baa9b07e609be60e','Pajama');
insert into items(uuid,item_name) values ('it_e3900088d92a4a098c077181feea4c0a','Dothi');
insert into items(uuid,item_name) values ('it_45f2252181754cf7a6cfb07b507c030f','Bath towel');
insert into items(uuid,item_name) values ('it_94496e65efb04992b06d3aba2ccb7252','Skirt');
insert into items(uuid,item_name) values ('it_5800b782657a445782f19e6ecf4ea05d','Women-Top');
insert into items(uuid,item_name) values ('it_c34dce6808e74296a8b7a7ec96558a36','Trouser');
insert into items(uuid,item_name) values ('it_ba2bd4305c1b422ba5538e46fc7027a9','Salwar');
insert into items(uuid,item_name) values ('it_d16d2cae147542ee96e4701310247f2b','Jeans/Denims');
insert into items(uuid,item_name) values ('it_48ec133eaa6e43ca81a7e7c87b3fc50a','Kurta');
insert into items(uuid,item_name) values ('it_8356db94e15c4d9fa3baa892859ecae0','T-Shirt');
insert into items(uuid,item_name) values ('it_acdf79effbd34ae4ae9e3ca17292049b','Shorts');
insert into items(uuid,item_name) values ('it_74603ccb23264b5984f9454e5e7edca7','Blouse');
insert into items(uuid,item_name) values ('it_1b4710c547a547b88dca93fce5f3f19b','Scarf');
insert into items(uuid,item_name) values ('it_52d448ea7f054aada49382b6a5f5e1f1','Leggins');
insert into items(uuid,item_name) values ('it_4a6488617c55448296f2e731afa02d52','Shirt');
insert into items(uuid,item_name) values ('it_65b0c51c836849539908148ca42218c5','Ladies Gown');
insert into items(uuid,item_name) values ('it_cf064eaec35c477d854709448d8d7a81','Night Gown');
insert into items(uuid,item_name) values ('it_a55b06faedda4f5d870af9088ad004e9','Saree');
insert into items(uuid,item_name) values ('it_fdb9915dc5c04c1abaa78a0a30d28f5b','(1/2) Saree');
insert into items(uuid,item_name) values ('it_ef5daa989f564b4a8e729aee43da8989','Bed spread');
insert into items(uuid,item_name) values ('it_efec6a3c3b4d456fbfab93bc11baff6c','Shrug');
insert into items(uuid,item_name) values ('it_1aefeab59646441ab39bc4be49e33f09','Chudidaar');
insert into items(uuid,item_name) values ('it_fcd95f6a28dc44459269b0a344190e98','Burqa');
insert into items(uuid,item_name) values ('it_08a39d568fec4eb3ba70bad7554fd8df','Apron');
insert into items(uuid,item_name) values ('it_ec0942b11bbb4cd38e64e6bfeda0a5a2','Kameez');
insert into items(uuid,item_name) values ('it_5e6e42dd0d2b493fa2c4cdb52b7c59cd','Cotton saree');
insert into items(uuid,item_name) values ('it_3cbd5757be5744eab9d4fa0e45ff4e7e','Silk saree');

insert into items(uuid,item_name,unit_type) values ('it_d0990643cf9c4633aa435574b83e7e59',5,'kg');
insert into items(uuid,item_name,unit_type) values ('it_3028bfdf79954b239b236909385116de',6,'kg');
insert into items(uuid,item_name,unit_type) values ('it_b75686af457947abab1544a07d175aff',7,'kg');
insert into items(uuid,item_name,unit_type) values ('it_2738f9b8d0a545dfa0eaf5f8b5ab31c0',8,'kg');
insert into items(uuid,item_name,unit_type) values ('it_f228379bb2104a078211aeae0927d6d5',9,'kg');
insert into items(uuid,item_name,unit_type) values ('it_dc92b1e05ba343e9af817d262b32a3aa',10,'kg');

drop table if exists  item_category;
CREATE TABLE item_category (
uuid varchar(50) not null,
shop_uuid varchar(50) default 'G',
category_name varchar(50) not null ,
status varchar(5) default 'A',
image varchar(250) default null,
PRIMARY KEY(uuid)
);

insert into item_category(uuid,category_name,image) values ('ic_a53443e2617c45be995fe41280c42217','wash','wash.png');
insert into item_category(uuid,category_name,image) values ('ic_1a1dbfefc8b442ea9da6a815026f9169','iron','iron.png');
insert into item_category(uuid,category_name,image) values ('ic_be6ab3c10b8e45a3bdd4a4b6de610a0d','wash & iron','wash_iron.png');
insert into item_category(uuid,category_name,image) values ('ic_ce6ab3c10b8e44a3bdd4a4b6de610a0e','Dry cleaning','drying_clothes.png');

drop table if exists  item_pricing;
CREATE TABLE item_pricing (
uuid varchar(50) not null,
shop_uuid varchar(50) not null,
items_category_uuid varchar(50) not null,
item_id varchar(50) not null,
price int(5)not null ,
status varchar(5)default 'A' ,
created_on datetime not null,
updated_on timestamp NOT NULL DEFAULT NOW(),                                 
PRIMARY KEY(uuid)
);
 

insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_13451a2dabd442d88803e57d6727743e','G','ic_a53443e2617c45be995fe41280c42217','it_2149fe4b2e58477eb6d829594763da4c',5,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_7d8b690276ce4550a4b6fda18bb49bda','G','ic_a53443e2617c45be995fe41280c42217','it_a353a3a0fbca4e64a9adda006ebdd17f',6,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_00d1c9a8c8cb4d77bcb5aded68ebed83','G','ic_a53443e2617c45be995fe41280c42217','it_a4e02d3873644763a8772271a8cfd35b',8,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_60f91dfb28ef4935b0169629c78b4942','G','ic_a53443e2617c45be995fe41280c42217','it_133ba4d561194328b776d97aa11b4d80',8,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_6e192eb1e3dd490ca5d07bc0976e4aa6','G','ic_a53443e2617c45be995fe41280c42217','it_4e370bda0fc5497ab2344f751c22df10',8,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_d78286f8301048a5b0d82cef943c175a','G','ic_a53443e2617c45be995fe41280c42217','it_5377957d9e5345d283cc9dbd9593b164',10,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_824db9c4e6a5432eb764281a842975b2','G','ic_a53443e2617c45be995fe41280c42217','it_8dd8cb7a5eb74251baa9b07e609be60e',10,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_23c68863a9084c2cadc30f337c8f3b2e','G','ic_a53443e2617c45be995fe41280c42217','it_e3900088d92a4a098c077181feea4c0a',10,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_3fe6b85a78ed4fb19bbf915ce7a279e5','G','ic_a53443e2617c45be995fe41280c42217','it_45f2252181754cf7a6cfb07b507c030f',10,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_d0b9e6fe559546d4877e6c75b482afaa','G','ic_a53443e2617c45be995fe41280c42217','it_94496e65efb04992b06d3aba2ccb7252',10,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_493e080a37994bd99fae8313d592e634','G','ic_a53443e2617c45be995fe41280c42217','it_5800b782657a445782f19e6ecf4ea05d',10,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_f813a5fa762e4e2390ddc1df817cf8d3','G','ic_a53443e2617c45be995fe41280c42217','it_c34dce6808e74296a8b7a7ec96558a36',10,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_e928e8f107864f6f8b1b4d254a460874','G','ic_a53443e2617c45be995fe41280c42217','it_ba2bd4305c1b422ba5538e46fc7027a9',10,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_ad9b2f18ad61450fb8232924cb1621c1','G','ic_a53443e2617c45be995fe41280c42217','it_d16d2cae147542ee96e4701310247f2b',10,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_0ccb5f05c9454fd69654c1b2bb6ce0d4','G','ic_a53443e2617c45be995fe41280c42217','it_48ec133eaa6e43ca81a7e7c87b3fc50a',10,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_f0b5af22cd7d4a1891bf574e1f0f5b6a','G','ic_a53443e2617c45be995fe41280c42217','it_8356db94e15c4d9fa3baa892859ecae0',10,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_23e87eec35d44c1f9ba2418832e7104f','G','ic_a53443e2617c45be995fe41280c42217','it_acdf79effbd34ae4ae9e3ca17292049b',10,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_e274e619e6974f77806f69930445e79f','G','ic_a53443e2617c45be995fe41280c42217','it_74603ccb23264b5984f9454e5e7edca7',5,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_45ea0b6cb9b445b1b09f321f14df719d','G','ic_a53443e2617c45be995fe41280c42217','it_1b4710c547a547b88dca93fce5f3f19b',5,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_645004e265644910b9e70641c35fd812','G','ic_a53443e2617c45be995fe41280c42217','it_52d448ea7f054aada49382b6a5f5e1f1',5,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_cd7d752e783a42ea8c58f3a91b4bce52','G','ic_a53443e2617c45be995fe41280c42217','it_4a6488617c55448296f2e731afa02d52',5,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_0c35dc0449e1430ab02ea750d967b801','G','ic_a53443e2617c45be995fe41280c42217','it_65b0c51c836849539908148ca42218c5',5,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_e643c0acd37141768363997aaef8e707','G','ic_a53443e2617c45be995fe41280c42217','it_cf064eaec35c477d854709448d8d7a81',5,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_ab2aa424c313469f9db2580f9fea0df7','G','ic_a53443e2617c45be995fe41280c42217','it_a55b06faedda4f5d870af9088ad004e9',5,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_0f9f93bec36649c78c230627430a305f','G','ic_a53443e2617c45be995fe41280c42217','it_fdb9915dc5c04c1abaa78a0a30d28f5b',5,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_051bfaca560c4d0f91e8cf0c02988334','G','ic_a53443e2617c45be995fe41280c42217','it_ef5daa989f564b4a8e729aee43da8989',5,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_5e049fb386554602b077677bffdeee59','G','ic_a53443e2617c45be995fe41280c42217','it_efec6a3c3b4d456fbfab93bc11baff6c',5,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_d28e0ded7bb545ec9b3e57452669ec08','G','ic_a53443e2617c45be995fe41280c42217','it_1aefeab59646441ab39bc4be49e33f09',5,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_a53b1e358bb74d9e8aba297573f8d9b3','G','ic_a53443e2617c45be995fe41280c42217','it_fcd95f6a28dc44459269b0a344190e98',5,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_1a427b1f34c14b5c85a4a5f425ad6983','G','ic_a53443e2617c45be995fe41280c42217','it_08a39d568fec4eb3ba70bad7554fd8df',5,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_3614a52b03744e4c99a96018f03a83e0','G','ic_a53443e2617c45be995fe41280c42217','it_ec0942b11bbb4cd38e64e6bfeda0a5a2',5,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_3c6534d581dc4e10b28e09f6034aa437','G','ic_a53443e2617c45be995fe41280c42217','it_5e6e42dd0d2b493fa2c4cdb52b7c59cd',5,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_67af65094e324e49a8cbf130deb29a9a','G','ic_a53443e2617c45be995fe41280c42217','it_3cbd5757be5744eab9d4fa0e45ff4e7e',5,NOW()); 
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_e8a3f7d95cf54cda83311e14d2ebb127','G','ic_1a1dbfefc8b442ea9da6a815026f9169','it_2149fe4b2e58477eb6d829594763da4c',5,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_81a76f1d287f44609daebae1a25b6652','G','ic_1a1dbfefc8b442ea9da6a815026f9169','it_a353a3a0fbca4e64a9adda006ebdd17f',6,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_3f0724811ed1434db83ba2b750323434','G','ic_1a1dbfefc8b442ea9da6a815026f9169','it_a4e02d3873644763a8772271a8cfd35b',5,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_ede3297a3c3d4189a2f5d9d7df60fcf6','G','ic_1a1dbfefc8b442ea9da6a815026f9169','it_133ba4d561194328b776d97aa11b4d80',6,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_673cf2329f5e429fb8b7b9f66949f233','G','ic_1a1dbfefc8b442ea9da6a815026f9169','it_4e370bda0fc5497ab2344f751c22df10',0,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_b402f8110e1147f8bc30ce327fe17f05','G','ic_1a1dbfefc8b442ea9da6a815026f9169','it_5377957d9e5345d283cc9dbd9593b164',8,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_65a85c1dc3724e4e93b395462d7f3ab6','G','ic_1a1dbfefc8b442ea9da6a815026f9169','it_8dd8cb7a5eb74251baa9b07e609be60e',8,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_d6ad0cef47f84179b0dc453d07915525','G','ic_1a1dbfefc8b442ea9da6a815026f9169','it_e3900088d92a4a098c077181feea4c0a',10,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_2c868b810111409a8a368c3ea832a035','G','ic_1a1dbfefc8b442ea9da6a815026f9169','it_45f2252181754cf7a6cfb07b507c030f',10,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_3c0ff82682294938942126ab27a3662b','G','ic_1a1dbfefc8b442ea9da6a815026f9169','it_94496e65efb04992b06d3aba2ccb7252',8,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_6e1a4ec11eb840ab91d69c82ff9171a4','G','ic_1a1dbfefc8b442ea9da6a815026f9169','it_5800b782657a445782f19e6ecf4ea05d',10,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_30364891f21141248161a91b3b9873fe','G','ic_1a1dbfefc8b442ea9da6a815026f9169','it_c34dce6808e74296a8b7a7ec96558a36',10,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_464e2fbc2f7540f8bf5204db268aed09','G','ic_1a1dbfefc8b442ea9da6a815026f9169','it_ba2bd4305c1b422ba5538e46fc7027a9',8,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_7aa12a0ade48462dae555342fe55e90c','G','ic_1a1dbfefc8b442ea9da6a815026f9169','it_d16d2cae147542ee96e4701310247f2b',10,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_8cf7b9d2956e416797e4a77f0a05ad76','G','ic_1a1dbfefc8b442ea9da6a815026f9169','it_48ec133eaa6e43ca81a7e7c87b3fc50a',10,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_f0b5af22cd7d4a1891bf574e1f0f5b6b','G','ic_1a1dbfefc8b442ea9da6a815026f9169','it_8356db94e15c4d9fa3baa892859ecae0',8,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_23e87eec35d44c1f9ba2418832e7104d','G','ic_1a1dbfefc8b442ea9da6a815026f9169','it_acdf79effbd34ae4ae9e3ca17292049b',8,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_8a65d06ae4ee4c36852b69b358fc4a03','G','ic_1a1dbfefc8b442ea9da6a815026f9169','it_74603ccb23264b5984f9454e5e7edca7',5,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_0119dc63e29744ffaff05d9120c19597','G','ic_1a1dbfefc8b442ea9da6a815026f9169','it_1b4710c547a547b88dca93fce5f3f19b',5,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_99803ca3c428471a85be1a0da9e05f5e','G','ic_1a1dbfefc8b442ea9da6a815026f9169','it_52d448ea7f054aada49382b6a5f5e1f1',5,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_e86a8847fab94b4da6c7e676cffde7c2','G','ic_1a1dbfefc8b442ea9da6a815026f9169','it_4a6488617c55448296f2e731afa02d52',5,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_bbcc447ee94341bc9f6fc5b64f5c31e4','G','ic_1a1dbfefc8b442ea9da6a815026f9169','it_65b0c51c836849539908148ca42218c5',5,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_2a64ad026b8d4fddbe7f44661f99bc7c','G','ic_1a1dbfefc8b442ea9da6a815026f9169','it_cf064eaec35c477d854709448d8d7a81',5,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_48fbbe94ebbc4fd792a341df8864c2d1','G','ic_1a1dbfefc8b442ea9da6a815026f9169','it_a55b06faedda4f5d870af9088ad004e9',5,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_4055747802ad4fdaa91895a58d3beb46','G','ic_1a1dbfefc8b442ea9da6a815026f9169','it_fdb9915dc5c04c1abaa78a0a30d28f5b',5,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_ae6833088f244b759234949d4a0819f7','G','ic_1a1dbfefc8b442ea9da6a815026f9169','it_ef5daa989f564b4a8e729aee43da8989',5,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_865b8292cfe14108a26bee0085e43cd2','G','ic_1a1dbfefc8b442ea9da6a815026f9169','it_efec6a3c3b4d456fbfab93bc11baff6c',5,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_480b62d3bb95451cbf0e92692b0bbf19','G','ic_1a1dbfefc8b442ea9da6a815026f9169','it_1aefeab59646441ab39bc4be49e33f09',5,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_97f862b2f3c3473ead0f341f140bf2cf','G','ic_1a1dbfefc8b442ea9da6a815026f9169','it_fcd95f6a28dc44459269b0a344190e98',5,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_a0e383b191734042a7619765787a5ae6','G','ic_1a1dbfefc8b442ea9da6a815026f9169','it_08a39d568fec4eb3ba70bad7554fd8df',5,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_02b5f865e2eb42d2bc525c13112c9ed9','G','ic_1a1dbfefc8b442ea9da6a815026f9169','it_ec0942b11bbb4cd38e64e6bfeda0a5a2',5,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_cb96a52de2f54444a663242c65b01ce2','G','ic_1a1dbfefc8b442ea9da6a815026f9169','it_5e6e42dd0d2b493fa2c4cdb52b7c59cd',5,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_a3164ecfd3704c978d5686bba9f607d4','G','ic_1a1dbfefc8b442ea9da6a815026f9169','it_3cbd5757be5744eab9d4fa0e45ff4e7e',5,NOW());



insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_98587dc0d1124152b76c670987d8f878','G','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d','it_2149fe4b2e58477eb6d829594763da4c',8,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_5ecdd150a8ea41beb0be442415249cb5','G','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d','it_a353a3a0fbca4e64a9adda006ebdd17f',10,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_a95e8af0192f4e4d84cdfd2bf139e035','G','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d','it_a4e02d3873644763a8772271a8cfd35b',10,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_3c8fdc25ac954fd49943bdada7a22c65','G','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d','it_133ba4d561194328b776d97aa11b4d80',12,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_4b654751fbf54f1ca80c0455babdca14','G','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d','it_4e370bda0fc5497ab2344f751c22df10',8,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_7cb729426a1b4de795bb50614b1d4db1','G','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d','it_5377957d9e5345d283cc9dbd9593b164',16,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_a3e23a80a2c94c61902f825941b11f07','G','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d','it_8dd8cb7a5eb74251baa9b07e609be60e',16,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_70a26b4081d24c1ebc9b4fb731ad9ac0','G','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d','it_e3900088d92a4a098c077181feea4c0a',18,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_979ecb00aedf4dcbb39fa038f24dba6c','G','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d','it_45f2252181754cf7a6cfb07b507c030f',18,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_f1e3ea5d4cab42c088873d9097a24f05','G','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d','it_94496e65efb04992b06d3aba2ccb7252',16,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_4ad61dcfed6647e983966e477380c36c','G','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d','it_5800b782657a445782f19e6ecf4ea05d',18,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_c4cd36ca57fd4ef1885aeb3131b43003','G','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d','it_c34dce6808e74296a8b7a7ec96558a36',18,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_1ceb33f7135447ab8247a0184821c43d','G','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d','it_ba2bd4305c1b422ba5538e46fc7027a9',16,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_51462c4fde9548899076e8758edf6a5c','G','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d','it_d16d2cae147542ee96e4701310247f2b',18,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_38f8fee1f4ba41dab67c99522f1414ab','G','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d','it_48ec133eaa6e43ca81a7e7c87b3fc50a',18,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_368429cf4f7e4816988fd1857c874b30','G','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d','it_8356db94e15c4d9fa3baa892859ecae0',16,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_a7d9df465356421a9385eecd5a96e8a1','G','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d','it_acdf79effbd34ae4ae9e3ca17292049b',16,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_39135e08dccc42ba887ab745c02b8eb4','G','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d','it_74603ccb23264b5984f9454e5e7edca7',8,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_7b3e3f44a60747cf9cb6fd0ffdde618c','G','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d','it_1b4710c547a547b88dca93fce5f3f19b',8,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_e5e3b5d77093410e98af7ffadeca6a41','G','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d','it_52d448ea7f054aada49382b6a5f5e1f1',8,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_62a42b559eba43cd9642ae8e553c3e31','G','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d','it_4a6488617c55448296f2e731afa02d52',8,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_acaeb42627e24935a284dea91d7d5123','G','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d','it_65b0c51c836849539908148ca42218c5',8,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_ad7d65d9fa424655a93cfa5d11412941','G','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d','it_cf064eaec35c477d854709448d8d7a81',8,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_a2832c3f7c5e46aa8aba66febdc6b06d','G','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d','it_a55b06faedda4f5d870af9088ad004e9',8,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_0f9f93bec36649c78c230627430a307f','G','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d','it_fdb9915dc5c04c1abaa78a0a30d28f5b',8,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_9259d4213547490aa60f53e8607ffc86','G','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d','it_ef5daa989f564b4a8e729aee43da8989',8,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_2074e5717cb2404f9363e25a90c8ca9c','G','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d','it_efec6a3c3b4d456fbfab93bc11baff6c',8,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_1ce699eb3e274800a351ac568ed98927','G','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d','it_1aefeab59646441ab39bc4be49e33f09',8,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_a53b1e358bb74d9e8aba297573f8d8b3','G','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d','it_fcd95f6a28dc44459269b0a344190e98',8,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_4f6c09513b2a41ae9f79aef62f65598e','G','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d','it_08a39d568fec4eb3ba70bad7554fd8df',8,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_6a3b3497ac59483e891551e617381eff','G','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d','it_ec0942b11bbb4cd38e64e6bfeda0a5a2',8,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_78a418659db449bd8aa2d3bed529f3b0','G','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d','it_5e6e42dd0d2b493fa2c4cdb52b7c59cd',8,NOW());
insert into item_pricing (uuid,shop_uuid,items_category_uuid,item_id,price,created_on) values ('ipm_b7497f523e1a4fdd859ae52fe95566b6','G','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d','it_3cbd5757be5744eab9d4fa0e45ff4e7e',8,NOW());

drop table if exists  otp_store;

CREATE TABLE otp_store (
phone_number varchar(10) NOT NULL,
otp int(11) NOT NULL,
status int(1) default 1,
created_date timestamp NOT NULL DEFAULT NOW(),
PRIMARY KEY(phone_number)
);


drop table if exists items_pricing_per_kg;
CREATE TABLE items_pricing_per_kg (
uuid varchar(50) NOT NULL,
item_id varchar(50) DEFAULT 'G',
shop_uuid varchar(50) DEFAULT 'G',
category_uuid varchar(50) NOT NULL,
quantity INT(11) NOT NULL,
price INT(11) NOT NULL,
status varchar(5)default 'A' ,
created_on datetime NOT NULL ,
modified_on timestamp NOT NULL DEFAULT NOW(),                                 
PRIMARY KEY(uuid)
);

insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_1ec81e28daad4b75a2bb7225ff5c4f84','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d',3,150,NOW());
insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_44cd365ef83442e89e5e1ecc063e0e75','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d',4,190,NOW());
insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_57fddc612ede4af5bc100cbb75241db6','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d',5,230,NOW());
insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_598bae7b12084065ba7090b2d901e60c','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d',6,270,NOW());
insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_a0c9178e16764d20aa04818cc29b2b68','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d',7,305,NOW());
insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_d6d957bc25b645c0a5182dd31be3c25d','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d',8,340,NOW());
insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_7cd2722931fa4d849315de087ab91192','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d',9,375,NOW());
insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_87c25192cdda41558a5c6fad717192f0','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d',10,410,NOW());
insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_7dc4c9c74e2d4c72b85bb70afb8b98a3','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d',11,440,NOW());
insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_86b5d00c41624b0d88ca3c8568ab2465','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d',12,480,NOW());
insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_0cb70668279e4f9d9de51b3396fcf7ff','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d',13,520,NOW());
insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_0bdce2b6d34741e78c39fbe5f8a6d600','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d',14,560,NOW());
insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_7ad85490e1b94efaa7f75c0fc5a2cabd','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d',15,600,NOW());
insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_5a6b47200a2a4a3db2319c464ee21530','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d',16,640,NOW());
insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_151be1df9a374de6a7223d9b38388c6c','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d',17,680,NOW());
insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_ed38922793184470bae804e664e22882','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d',18,720,NOW());
insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_841688aa8c494bebbe88076e434811e3','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d',19,760,NOW());
insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_a8fde62c29894ed993db407e57c5a89c','ic_be6ab3c10b8e45a3bdd4a4b6de610a0d',20,800,NOW());

insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_e05ce0ecd5ac44d0886089c7fea8b44a','ic_a53443e2617c45be995fe41280c42217',3,200,NOW());
insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_41be4de0ec6946eba278d46ee8750989','ic_a53443e2617c45be995fe41280c42217',4,260,NOW());
insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_13fcae5ac5c84e1a8e67f1938d8b11f6','ic_a53443e2617c45be995fe41280c42217',5,320,NOW());
insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_fbae6aa49a664aa6a5cbdad78025668d','ic_a53443e2617c45be995fe41280c42217',6,380,NOW());
insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_7777216d16ce4f029ac9ab981bd65c17','ic_a53443e2617c45be995fe41280c42217',7,430,NOW());
insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_caf2e1e4cf6b4b40a427ff76ff39556f','ic_a53443e2617c45be995fe41280c42217',8,480,NOW());
insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_457d73c4c80e4393b6ced7cfccf09bc2','ic_a53443e2617c45be995fe41280c42217',9,530,NOW());
insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_ea732e252ead4d399c83f839a9a5d413','ic_a53443e2617c45be995fe41280c42217',10,570,NOW());
insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_7177882788c8406c8eead064d19b84cd','ic_a53443e2617c45be995fe41280c42217',11,550,NOW());
insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_f2f2e556b98e4910837b97983b7d6cc3','ic_a53443e2617c45be995fe41280c42217',12,660,NOW());
insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_843ca36db8834324ab31e03f17971bd7','ic_a53443e2617c45be995fe41280c42217',13,715,NOW());
insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_5be73d46683c4cf3b571ee2dfa85cd50','ic_a53443e2617c45be995fe41280c42217',14,770,NOW());
insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_cecd79c0889c4870b64c6477256b161c','ic_a53443e2617c45be995fe41280c42217',15,825,NOW());
insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_67ff733443ec4a61946e9f22a69e4e60','ic_a53443e2617c45be995fe41280c42217',16,880,NOW());
insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_71da3c8315af4e17a8cd9eca09db2be2','ic_a53443e2617c45be995fe41280c42217',17,935,NOW());
insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_f49b662af4304a5e954e9d055cd559ea','ic_a53443e2617c45be995fe41280c42217',18,990,NOW());
insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_1c0ea6e95cb24817b87392f97e52034e','ic_a53443e2617c45be995fe41280c42217',19,1045,NOW());
insert into items_pricing_per_kg (uuid,category_uuid,quantity,price,created_on) values ('ipkg_41af4d4e9c054d408cd3e6d5aba2558c','ic_a53443e2617c45be995fe41280c42217',20,1100,NOW());



drop table if exists user_order;
create table user_order (
ord_id int(11)  not null auto_increment,
uuid varchar(50) not null comment 'uuid',
user_uuid varchar(50) not null  comment 'uuid',
user_address_uuid varchar(50) not null  comment 'user address uuid',
shop_uuid varchar(50) not null comment 'shop uuid',
slot_time varchar(50) default null comment 'slot time',
order_on datetime default null comment 'order on',
assign_on datetime default null  comment 'assign on',
pickup_on datetime default null  comment 'pickup on',
delivery_on datetime default null comment 'delivery on',
cancel_on datetime default null comment 'cancel on',
remarks varchar(250) default null,
total_weight double(8,2)  default 0.0,
bag_number varchar(30) default null,
ref_number varchar(30) default null,
`status` varchar(50) default null,
created_on datetime not null ,
updated_on timestamp not null default now(),
CONSTRAINT pk_user_order primary key (ord_id,uuid)
);

  ALTER TABLE `user_order` AUTO_INCREMENT = 1001;

drop table if exists  emp_order_history;
 create table emp_order_history (
   uuid varchar(50) not null, 
   emp_uuid varchar(50) not null  comment 'emp uuid for order assign avaliblity',
   order_uuid varchar(50) not null,
   shop_name varchar(250) not null,
   emp_name varchar(250) not null,
   phone_number varchar(25) not null,
   sub_status varchar(50)   not null comment 'pickup, delivery, return items',
   `status` varchar(30) not null comment 'ongoing,processing,completed',
   created_on datetime not null ,
   updated_on timestamp not null default now(),
   primary key (uuid)
);

drop table if exists emp_order_grid;
 create table emp_order_grid (
  uuid varchar(50)  not null comment 'uuid',
  emp_uuid varchar(50)  default null comment 'shop id',
  total_orders int(11) default 0 comment 'total orders',
  ongoing_orders int(11) default 0 comment 'ongoing orders',
  completed_orders int(11) default 0 comment 'completed orders',
  created_on datetime not null ,
  updated_on timestamp not null default now(),
  primary key (uuid)
);

drop table if exists shop_order_grid;
 create table shop_order_grid (
  uuid varchar(50)  not null comment 'uuid',
  shop_uuid varchar(50)  default null comment 'shop id',
  total_orders int(11) default 0 comment 'total orders',
  ongoing_orders int(11) default 0 comment 'ongoing orders',
  completed_orders int(11) default 0 comment 'completed orders',
  cancel_orders int(11) default 0 comment 'cancel orders',
  total_revenue decimal(12,4) default 0.00 comment 'total revenue',
  created_on datetime not null ,
  updated_on timestamp not null default now(),
  primary key (uuid)
);

drop table if exists time_slots;
CREATE TABLE time_slots (
uuid varchar(50) NOT NULL,
shop_uuid varchar(50) NOT NULL,
slot int(5) default null,
start_at varchar(15) default null,
end_at varchar(25) default null,
status varchar(10) default null,
created_on datetime NOT NULL ,
updated_on timestamp NOT NULL DEFAULT NOW(),
PRIMARY KEY(uuid)
);


INSERT INTO `time_slots` (`uuid`, `shop_uuid`, `slot`, `start_at`, `end_at`, `status`, `created_on`) VALUES ('tsl_a26868bbb91245e3b4df088b2d9f8f3c', '1', 1, 'Any', 'Time', 'A', '2020-05-28 00:05:48');
INSERT INTO `time_slots` (`uuid`, `shop_uuid`, `slot`, `start_at`, `end_at`, `status`, `created_on`) VALUES ('tsl_c2d6faccb5734b5cbf2af2c8c9d39468', '1', 2, '09:00', '10:00', 'A', '2020-05-28 00:05:48');
INSERT INTO `time_slots` (`uuid`, `shop_uuid`, `slot`, `start_at`, `end_at`, `status`, `created_on`) VALUES ('tsl_cae916e491a845e095006486703e4931', '1', 3, '10:30', '11:00', 'A', '2020-05-28 00:05:48');
INSERT INTO `time_slots` (`uuid`, `shop_uuid`, `slot`, `start_at`, `end_at`, `status`, `created_on`) VALUES ('tsl_bd43168e541e489f874542997a7697a6', '1', 4, '12:30', '13:30', 'A', '2020-05-28 00:05:48');
INSERT INTO `time_slots` (`uuid`, `shop_uuid`, `slot`, `start_at`, `end_at`, `status`, `created_on`) VALUES ('tsl_0e830bda8998484484ba3bb5d8a4ae82', '1', 5, '14:30', '15:30', 'A', '2020-05-28 00:05:48');
INSERT INTO `time_slots` (`uuid`, `shop_uuid`, `slot`, `start_at`, `end_at`, `status`, `created_on`) VALUES ('tsl_61cda7c2357c4bb1a36a90548e1b5a97', '1', 6, '16:30', '17:30', 'A', '2020-05-28 00:05:48');
INSERT INTO `time_slots` (`uuid`, `shop_uuid`, `slot`, `start_at`, `end_at`, `status`, `created_on`) VALUES ('tsl_9e4e152a98e449ca80880b1de80d0dcf', '1', 7, '17:30', '18:30', 'A', '2020-05-28 00:05:48');




drop table if exists user_order_items;
 create table user_order_items (
   uuid varchar(50) default 0 comment 'uuid for qunique identiffication for each order item',
   order_uuid varchar(50) NOT NULL,
   pricing_uuid varchar(50) NOT NULL,
   item_category_uuid varchar(50) NOT NULL,
   item_category_name varchar(250) NOT NULL,
   item_uuid varchar(50) default null,
   item_name varchar(250) default null,
   category varchar(10) NOT NULL comment 'pc /pkg',
   item_qty int(11) default 0,
   base_price double(12,2) NOT NULL,
   price double(12,2) NOT NULL,
   created_on datetime NOT NULL ,
   updated_on timestamp NOT NULL DEFAULT NOW(),
   primary key (uuid)
);

drop table if exists  payment_methods;
CREATE TABLE payment_methods (
uuid varchar(50) not null,
name varchar(10) not null,
upi_id varchar(50) not null,
status varchar(5) not null,
created_on datetime not null,
updated_on timestamp NOT NULL DEFAULT NOW(),                                 
PRIMARY KEY(uuid)
);
INSERT INTO `payment_methods`  (`uuid`, `name`, `upi_id`,`status`, `created_on`) VALUES ('pm_c2d6faccb5734b5cbf2af2c8c9d39418','Cash','NA','A' , '2020-05-28 00:05:48');
INSERT INTO `payment_methods` (`uuid`, `name`, `upi_id`,`status`, `created_on`) VALUES ('pm_c2d6faccb5734b5cbf2af2c8c9d39428','Amazonpay','NA','IA' , '2020-05-28 00:05:48');
INSERT INTO `payment_methods` (`uuid`, `name`, `upi_id`,`status`, `created_on`) VALUES ('pm_c2d6faccb5734b5cbf2af2c8c9d39438','BHIM UPI','NA','IA' , '2020-05-28 00:05:48');
INSERT INTO `payment_methods` (`uuid`, `name`, `upi_id`,`status`, `created_on`) VALUES ('pm_c2d6faccb5734b5cbf2af2c8c9d39448','Google Pay','9494005552@ybl','A' , '2020-05-28 00:05:48');
INSERT INTO `payment_methods` (`uuid`, `name`, `upi_id`,`status`, `created_on`) VALUES ('pm_c2d6faccb5734b5cbf2af2c8c9d39458','PhonePe','9494005552@ybl','A' , '2020-05-28 00:05:48');
INSERT INTO `payment_methods` (`uuid`, `name`,`upi_id`, `status`, `created_on`) VALUES ('pm_c2d6faccb5734b5cbf2af2c8c9d39468','Paytm','NA','IA' , '2020-05-28 00:05:48');

drop table if exists  order_transaction;
CREATE TABLE order_transaction (
uuid varchar(50) not null,
order_uuid varchar(50) not null,
payment_type varchar(50) default null comment 'online/offline',
payment_method varchar(50) default null comment 'Gpay/PhonePhe..etc',
transaction_id varchar(150) default null,
transaction_status varchar(50) default null,
amount_paid double(12,2)not null,
created_on datetime not null,
updated_on timestamp NOT NULL DEFAULT NOW(),                                 
PRIMARY KEY(uuid)
);

drop table if exists  cancel_reason;
CREATE TABLE cancel_reason (
uuid varchar(50) not null,
reason_id int(5) not null,
reason_name varchar(100) not null,
reason_type int(5) not null comment '1 - for customer 2 for shop',
status varchar(5) default 'A' ,
created_on datetime not null,
updated_on timestamp NOT NULL DEFAULT NOW(),                                 
PRIMARY KEY(uuid)
);
INSERT INTO `cancel_reason` (`uuid`, `reason_id`,`reason_name`,`reason_type` ,`created_on`) VALUES ('cr_c1d6faccb5734b5cbf2af2c8c9d39468',1,'Order placed by mistake',1, '2020-05-28 00:05:48');
INSERT INTO `cancel_reason` (`uuid`, `reason_id`,`reason_name`, `reason_type` ,`created_on`) VALUES ('cr_c2d6faccb5734b5cbf2af2c8c9d39478',2,'Unauthorized order', 1,'2020-05-28 00:05:48');
INSERT INTO `cancel_reason` (`uuid`, `reason_id`,`reason_name`,`reason_type` , `created_on`) VALUES ('cr_c3d6faccb5734b5cbf2af2c8c9d39488',3,'My reason is not listed', 1,'2020-05-28 00:05:48');
INSERT INTO `cancel_reason` (`uuid`, `reason_id`,`reason_name`,`reason_type` , `created_on`) VALUES ('cr_c3d6faccb5734b5cbf2af2c8c9d39588',3,'My reason is not listed', 2,'2020-05-28 00:05:48');
INSERT INTO `cancel_reason` (`uuid`, `reason_id`,`reason_name`,`reason_type` , `created_on`) VALUES ('cr_c4d6faccb5734b5cbf2af2c8c9d37588',4,'Small order quantity', 2,'2020-05-28 00:05:48');
INSERT INTO `cancel_reason` (`uuid`, `reason_id`,`reason_name`,`reason_type` , `created_on`) VALUES ('cr_c5d6faccb5734b5cbf2af2c8c9d47588',5,'insufficient workers', 2,'2020-05-28 00:05:48');
INSERT INTO `cancel_reason` (`uuid`, `reason_id`,`reason_name`,`reason_type` , `created_on`) VALUES ('cr_c6d6faccb5734b5cbf2af2c8c9c47588',6,'higher order demand', 2,'2020-05-28 00:05:48');


truncate table users;
truncate table shop_verification;

truncate table user_order;
truncate table emp_order_grid;
truncate table emp_order_history;
truncate table shop_order_grid;
truncate table user_order_items;
truncate table otp_store;


drop table if exists  contactus;
CREATE TABLE contactus (
 id int(10) AUTO_INCREMENT NOT NULL,
 name varchar(255) NOT NULL,
 mobile_number varchar(15) NOT NULL,
 email varchar(255) NOT NULL,
 message text  NOT NULL,
 created_on datetime not null,
 PRIMARY KEY(id)
);

 INSERT INTO `users` (`uuid`, `user_name`, `first_name`, `last_name`, `shop_name`, `email`, `phone_number`, `password`, `sex`, `user_type`, `city_name`, `state_name`, `landmark`, `address`, `lat`, `lng`, `device_id`, `device_type`, `status`, `created_on`, `updated_on`) VALUES ('su_2ee17ce0bc7f4a5d866673f663478e45', 'gowtham.g', 'gowtham', 'g', 'supper admin', 'ggoutham2745@gmail.com', '9494005552', '827ccb0eea8a706c4c34a16891f84e7b', 'M', 1, 'HYd', 'Telangana', 'HYd', 'commnuity hall parvath nagar', '17.4574252', '78.3990049', '123444', 'android', 'A', '2020-06-11 08:30:05', '2020-06-11 08:30:05');
--  mysql -u root -h ddosth-id.cfgodobn3y6c.ap-south-1.rds.amazonaws.com -p
 -- INSERT INTO `shop_order_grid` (`uuid`, `shop_uuid`, `total_orders`, `ongoing_orders`, `completed_orders`, `cancel_orders`, `total_revenue`, `created_on`, `updated_on`) VALUES ('ug_a5aae092cb1c4e0683a8225a5752cdc6', 'sh_7c5b9a9564934a65bef8f5dca737ecbf', '2', '0', '2', '0', '217.0000', '2020-07-05 16:44:29', '2020-07-04 16:44:29');
