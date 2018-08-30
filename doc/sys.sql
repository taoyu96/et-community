
--日志
create table t_syslog
(
   logid              char(36)               not null,
   uid                char(36)               null,
   uname              varchar(50)            null,
   content            varchar(2000)          null,
   operation          varchar(400)           null,
   level              int                    null,
   excutetime         bigint                 null,
   createtime         datetime               null,
   primary key (logid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志管理';

-- 用户
CREATE TABLE t_user (
  userid CHAR(36)               not null,
  account varchar(50) NOT NULL COMMENT '用户名',
  password varchar(100) COMMENT '密码',
  email  varchar(100) COMMENT '邮箱',
  mobile varchar(100) COMMENT '手机号',
  status int DEFAULT 0 COMMENT '状态  0：未激活 1：正常 2：封禁',
  createtime datetime COMMENT '创建时间',
  PRIMARY KEY (userid),
  UNIQUE INDEX (username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- 用户信息
CREATE TABLE t_userinfo (
  userid CHAR(36)               not null,
  nickname varchar(20) COMMENT '昵称',
  realname varchar(20) COMMENT '姓名',
  authinfo  varchar(50) COMMENT '认证信息',
  headpicfileid  varchar(50) COMMENT '头像资源主键',
  acouttotal int  DEFAULT 0 COMMENT '积分总额',
  city  varchar(50) COMMENT '所在城市',
  motto varchar(200) COMMENT '座右铭',
  sex int DEFAULT 0  COMMENT '性别   0：其他   1：男  2：女',
  level int DEFAULT 0 COMMENT '等级积分',
  viplevel int DEFAULT 0 COMMENT 'VIP等级积分',
  vipactive int DEFAULT 0 COMMENT 'VIP激活标志 0:未激活 1：激活',
  emailtive int DEFAULT 0 COMMENT 'email 激活标志 0:未激活 1激活',
  mobileactive int DEFAULT 0  COMMENT 'mobile 激活标志 0:未激活 1激活',
  signdays int DEFAULT 0 COMMENT '连续签到天数',
  signtime date COMMENT '签到时间',
  PRIMARY KEY (userid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户信息';

-- 菜单
CREATE TABLE t_menu (
  menuid   char(36) NOT NULL,
  parentid char(36) COMMENT '父菜单ID，一级菜单为0',
  name varchar(50) COMMENT '菜单名称',
  url  varchar(200) COMMENT '菜单URL',
  perms varchar(500) COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  type int COMMENT '类型   0：目录   1：菜单   2：按钮',
  icon varchar(50) COMMENT '菜单图标',
  ordernum int COMMENT '排序',
  remark varchar(200) COMMENT '备注',
  PRIMARY KEY (menuid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单管理';


-- 角色
CREATE TABLE t_role (
  roleid char(36) NOT NULL,
  rolename varchar(100) COMMENT '角色名称',
  remark varchar(200) COMMENT '备注',
  createtime datetime COMMENT '创建时间',
  PRIMARY KEY (roleid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';


-- 用户与角色对应关系
CREATE TABLE t_roleuser (
  id char(36) NOT NULL,
  userid char(36) NOT NULL COMMENT '用户ID',
  roleid char(36) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- 角色与菜单对应关系
CREATE TABLE t_rolemenu (
  id char(36) NOT NULL,
  roleid char(36) NOT NULL COMMENT '角色ID',
  menuid char(36) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';


CREATE TABLE t_dict (
  id char(36) NOT NULL,
  dictname varchar(100) NOT NULL COMMENT '字典名称',
  dicttype varchar(100) NOT NULL COMMENT '字典类型',
  code varchar(100) NOT NULL COMMENT '字典码',
  value varchar(1000) NOT NULL COMMENT '字典值',
  ordernum int DEFAULT 0 COMMENT '排序',
  remark varchar(255) COMMENT '备注',
  flag  int DEFAULT 0 COMMENT '删除标记  1：已删除  0：正常',
  PRIMARY KEY (id),
  UNIQUE KEY(dicttype,code)
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8 COMMENT='数据字典表';

create table t_uploadData
(
   uploadid        char(36)               not null,
   filename        varchar(100)   COMMENT '文件名',
   filepath        varchar(200)   COMMENT '文件位置',
   ext             varchar(36)   COMMENT '文件扩展名',
   createtime      datetime  COMMENT '创建时间',
   PRIMARY KEY (uploadid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='上传资源';


INSERT INTO t_user (userid, account, password, email, mobile, status, createtime)
    VALUES ('695f4b98-6f9d-11d8-aaae-080058000000', 'admin', '123456', 'root@renren.io', '13612345678', '1', '2018-06-13 14:11:41');

INSERT INTO t_user (userid, account, password, email, mobile, status, createtime)
    VALUES ('695f4b98-6f9d-11d8-aaae-080058000001', 'taoyu96@126.com', '123456', 'taoyu96@126.com', '13512345678', '1', '2018-06-13 14:11:41');

INSERT INTO t_userinfo (userid, nickname)
    VALUES ('695f4b98-6f9d-11d8-aaae-080058000000', '超级管理员');

INSERT INTO t_userinfo (userid, nickname)
    VALUES ('695f4b98-6f9d-11d8-aaae-080058000001', '封乂');


INSERT INTO t_role (roleid, rolename, remark, createtime, rolecode) VALUES ('00000000-0000-0000-0000-000000000000', '超级管理员', '超级管理员', '2018-06-13 14:11:41', 0);
INSERT INTO t_role (roleid, rolename, remark, createtime, rolecode) VALUES ('695f4b98-6f9d-11d8-aaae-080055000002', '普通用户', '普通用户', '2018-06-13 14:11:41', 99);


--绑定角色
INSERT INTO t_roleuser (id, userid, roleid)
    VALUES ('695f4b98-6f9d-11d8-aaae-090000000000', '695f4b98-6f9d-11d8-aaae-080058000000', '00000000-0000-0000-0000-000000000000');

INSERT INTO t_roleuser (id, userid, roleid)
    VALUES ('695f4b98-6f9d-11d8-aaae-090000000001', '695f4b98-6f9d-11d8-aaae-080058000001', '695f4b98-6f9d-11d8-aaae-080055000002');

--角色分配菜单
insert into t_rolemenu(id,roleid,menuid)
select uuid(),'695f4b98-6f9d-11d8-aaae-080055000002',menuid from t_menu
