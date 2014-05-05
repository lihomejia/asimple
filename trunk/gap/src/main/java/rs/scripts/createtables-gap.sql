create table t_company (
    id integer not null auto_increment,
    adate datetime,
    auser_id int default 0,
    cdate datetime,
    comment varchar(255),
    cuser_id int default 0,
    status int default 0,
    udate datetime,
    uuser_id int default 0,
    companyname varchar(60),
    companyno varchar(60),
    innercode varchar(60),
    indate datetime,
    type int default 0,
    primary key (id)
);

create table t_info (
    id integer not null auto_increment,
    adate datetime,
    auser_id int default 0,
    cdate datetime,
    comment varchar(255),
    cuser_id int default 0,
    status int default 0,
    udate datetime,
    uuser_id int default 0,
    content TEXT,
    keyword varchar(250),
    title varchar(250),
    type varchar(20),
    primary key (id)
);


create table t_user (
    id integer not null auto_increment,
    adate datetime,
    auser_id int default 0,
    cdate datetime,
    comment varchar(255),
    cuser_id int default 0,
    status int default 0,
    udate datetime,
    uuser_id int default 0,
    pass_word varchar(20),
    user_id varchar(20),
    user_name varchar(60),
    primary key (id)
);