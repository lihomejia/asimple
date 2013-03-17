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
	irrigation_comment   varchar(255)     default ''      comment '备注',
	primary key(irrigation_id)
);

#投入品资源
drop table if exists t_input_resource;
create table t_input_resource (
	resource_id          int              AUTO_INCREMENT,
	resource_name        varchar(60)      default ''      comment '资源名称',
	resource_cate        int              default 0       comment '资源类别 1-肥料 2-饲料 3-农药 4-兽药 5-消毒剂 6-清洁剂',
	resource_type        int              default 0       comment '资源类型 1-品名 2-规格 3-生产批号 4-生产商 5-种类',
	primary key(resource_id)
);

#投入品库存
drop table if exists t_input_stock;
create table t_input_stock (
	stock_id             int              AUTO_INCREMENT,
	stock_nameid         int              default 0       comment '投入品名称ID',
	stock_sizeid         int              default 0       comment '投入品规格/型号ID',
	stock_batchid        int              default 0       comment '投入品生产批号ID',
	stock_producerid     int              default 0       comment '投入品生产厂商ID',
	stock_quantity       decimal(10,2)    default 0       comment '投入品库存数量',
	stock_status         int              default 0       comment '库存状态',
	primary key(stock_id)
);

#投入品入库
drop table if exists t_input_instock;
create table t_input_instock (
	instock_id           int              AUTO_INCREMENT,
	instock_stockid      int              default 0       comment '库存ID',
	instock_nameid       int              default 0       comment '投入品名称ID',
	instock_sizeid       int              default 0       comment '投入品规格/型号ID',
	instock_batchid      int              default 0       comment '投入品生产批号ID',
	instock_producerid   int              default 0       comment '投入品生产厂商ID',
	instock_quantity     decimal(10,2)    default 0       comment '投入品入库数量',
	instock_location     varchar(60)      default ''      comment '产地',
	instock_element      varchar(60)      default ''      comment '有效成分',
	instock_indate       timestamp        default now()   comment '入库时间',
	instock_kindid       int              default 0       comment '投入品所属类别ID',
	instock_expirydate   datetime         default '19000101' comment '有效期',
	instock_vendor       varchar(60)      default ''      comment '供应商',
	instock_wrap         varchar(60)      default ''      comment '包装形式',
	instock_inmanager    varchar(36)      default ''      comment '入库人',
	instock_comment      varchar(255)     default ''      comment '备注',
	primary key(instock_id)
);

#投入品出库
drop table if exists t_input_outstock;
create table t_input_outstock (
	outstock_id          int              AUTO_INCREMENT,
	outstock_stockid     int              default 0       comment '库存ID',
	outstock_cellid      int              default 0       comment '生产单元ID',
	outstock_quantity    decimal(10,2)    default 0       comment '投入品出库数量',
	outstock_outdate     timestamp        default now()   comment '出库时间',
	outstock_outmanager  varchar(36)      default ''      comment '出库人/领用人',
	outstock_comment     varchar(255)     default ''      comment '备注',
	primary key(outstock_id)
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