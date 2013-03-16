drop table if exists t_production_cell;
create table t_production_cell (
    cell_id              int              AUTO_INCREMENT,
    cell_code            varchar(10)      default ''      comment '生产单元代码',
    cell_location        varchar(100)     default ''      comment '生产单元位置',
    cell_area            decimal(10,2)    default 0       comment '生产单元面积',
    cell_cdate           timestamp        default now()   comment '建档时间',
    primary key(cell_id)
);

drop table if exists t_farming_activity;
create table t_farming_activity (
	activity_id          int              AUTO_INCREMENT,
	activity_cellid      int              default 0,
	activity_date        timestamp        default now()   comment '活动时间',
	activity_content     varchar(255)     default ''      comment '农事活动内容',
	activity_scope		 decimal(10,2)    default 0       comment '农事活动规模(亩）',
	activity_quantity    int              default 0       comment '参与人员数量',
	activity_manager     varchar(36)      default ''      comment '负责人',
	activity_comment     varchar(255)     default ''      comment '备注',
	primary key(activity_id)
);

drop table if exists t_irrigation;
create table t_irrigation (
	irrigation_id        int              AUTO_INCREMENT,
	irrigation_cellid    int              default 0,
	irrigation_date      timestamp        default now()   comment '灌溉时间',
	irrigation_way       varchar(20)      default ''      comment '灌溉方式',
	irrigation_area      decimal(10,2)    default 0       comment '灌溉面积',
	irrigation_quantum   decimal(10,2)    default 0       comment '灌溉量',
	irrigation_manager   varchar(36)      default ''      comment '操作负责人',
	irrigation_approver  varchar(36)      default ''      comment '审核员',
	irrigation_comment   varchar(225)     default ''      comment '备注',
	primary key(irrigation_id)
);

#投入品库存
drop table if exists t_input_stock;
create table t_input_stock (

);

#投入品入库
drop table if exists t_input_instock;
create table t_input_instock (

);

#投入品出库
drop table if exists t_input_outstock;
create table t_input_outstock (

);


#投入品使用
drop table if exists t_input_usehist;
create table t_input_usehist (
);



#产品库存
drop table if exists t_product_stock;
create table t_product_stock (

);

#产品入库
drop table if exists t_product_instock;
create table t_product_instock (

);

#产品出库
drop table if exists t_product_outstock;
create table t_product_outstock (

);