
-- 文章/帖
CREATE TABLE t_article (
  articleid char(36)  not null,
  userid varchar(36)  COMMENT '发表用户id',
  title varchar(200) COMMENT '标题',
  type  int COMMENT '类型',
  content  text COMMENT '正文',
  status int DEFAULT 0 COMMENT '状态 0：未结 1：已结',
  top  int DEFAULT 0 COMMENT '级别 0：默认 1：置顶 ',
  wonder  int DEFAULT 0 COMMENT '级别 0：默认 1：加精',
  rewardnum  int DEFAULT 0 COMMENT '悬赏数额',
  createtime datetime COMMENT '创建时间',

  agreenum int DEFAULT 0 COMMENT '赞同数',
  disagreenum int DEFAULT 0 COMMENT '踩数',
  readnum int DEFAULT 0 COMMENT '阅读数',
  collectnum int DEFAULT 0  COMMENT '收藏数',
  commentnum int DEFAULT 0 COMMENT '评论数',
  transpondnum int DEFAULT 0 COMMENT '转发数',

  PRIMARY KEY (articleid),
  INDEX (userid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帖信息';

-- 文章/帖 附件 仅支持图片
create table t_articlepic
(
   picid           char(36)               not null,
   articleid       varchar(36)   COMMENT '文章/帖外键',
   uploadid        varchar(36)   COMMENT '上传资源id',
   createtime      datetime  COMMENT '创建时间',
   PRIMARY KEY (picid),
   INDEX (articleid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章/帖附件';

--用户关注表
CREATE TABLE t_relation (
  relationid char(36)  not null,
  relationtype int DEFAULT 0 COMMENT '关系类型 0：关注 1：好友',
  userid varchar(36) COMMENT '用户id',
  byuserid varchar(36) COMMENT '被关注用户id',
  createtime datetime COMMENT '创建时间',

  PRIMARY KEY (relationid),
  INDEX (userid),
  INDEX (byuserid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='艾特信息表';

--@艾特信息表
CREATE TABLE t_atmsg (
  atmsgid char(36)  not null,
  articleid varchar(36) COMMENT '文章/帖外键',
  senduserid varchar(36) COMMENT '发起@的用户id',
  acceptuserid varchar(36) COMMENT '被@的用户id',
  createtime datetime COMMENT '创建时间',

  PRIMARY KEY (atmsgid),
  INDEX (acceptuserid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='艾特信息表';

--收藏表
CREATE TABLE t_collect  (
  collectid char(36)  not null,
  articleid varchar(36) COMMENT '文章/帖外键',
  userid varchar(36) COMMENT '收藏用户id',
  status int DEFAULT 0 COMMENT '收藏状态 0：正常 1：取消收藏',
  createtime datetime COMMENT '创建时间',

  PRIMARY KEY (collectid),
  INDEX (userid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收藏表';

--私信/消息表
CREATE TABLE t_messages (
  messageid char(36)  not null,
  content varchar(3000) COMMENT '信息内容',
  senduserid varchar(36) COMMENT '发送用户id',
  acceptuserid varchar(36) COMMENT '接收用户id',
  status int DEFAULT 0 COMMENT '收藏状态  0：未阅 1：已阅',
  createtime datetime COMMENT '创建时间',

  PRIMARY KEY (messageid),
  INDEX (senduserid),
  INDEX (acceptuserid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息表';

-- 评论表
CREATE TABLE t_comments (
  commentid char(36)  not null,
  articleid varchar(36) COMMENT '文章/帖外键',
  content text COMMENT '评论内容',
  userid varchar(36) COMMENT '用户id',
  agreenum int DEFAULT 0 COMMENT '赞同数',
  disagreenum int DEFAULT 0 COMMENT '踩数',
  status int DEFAULT 0 COMMENT '评论状态 0：正常 1：被采纳 2: 隐藏 3：删除',
  createtime datetime COMMENT '创建时间',

  PRIMARY KEY (commentid),
  INDEX (articleid),
  INDEX (userid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论表';

-------------------------
INSERT INTO t_article (articleid, title, type, content, status, level, createtime, agreenum, disagreenum, readnum, collectnum, commentnum, transpondnum, userid) VALUES ('695f4b98-6f9d-11d8-aaae-000000000001', '测试帖', 1, '更新<hr> <pre>   # v3.0 2017-11-30   * 采用 layui 2.2.3 作为 UI 支撑   * 全面同步最新的 Fly 社区风格，各种细节得到大幅优化   * 更友好的响应式适配能力  </pre>', 0, 0, '2018-06-13 14:11:41', 15, 0, 99, 0, 10, 0, '695f4b98-6f9d-11d8-aaae-080058000000');

INSERT INTO t_articlepic (picid, articleid,createtime) VALUES ('1', '695f4b98-6f9d-11d8-aaae-000000000001','2018-06-13 14:11:41');

INSERT INTO t_comments (commentid, articleid, content, userid, agreenum, disagreenum, status, createtime) VALUES ('695f4b98-6f9d-11d8-aaae-080058000001', '695f4b98-6f9d-11d8-aaae-000000000001', '<p>这是一条没被采纳的回帖</p>', '695f4b98-6f9d-11d8-aaae-080058000001', 15, 0, 0, '2018-06-13 14:11:41');

INSERT INTO t_relation (relationid, relationtype, userid, byuserid, createtime) VALUES ('695f4b98-6f9d-11d8-aaae-080058000001', 0, '695f4b98-6f9d-11d8-aaae-080058000000', '695f4b98-6f9d-11d8-aaae-080058000001', '2018-06-13 14:11:41');

INSERT INTO t_atmsg (atmsgid, articleid, senduserid, acceptuserid, createtime) VALUES ('695f4b98-6f9d-11d8-aaae-000000000001', '695f4b98-6f9d-11d8-aaae-000000000001', '695f4b98-6f9d-11d8-aaae-080058000001', '695f4b98-6f9d-11d8-aaae-080058000000', '2018-06-13 14:11:41');

INSERT INTO t_collect (collectid, articleid, userid, status, createtime) VALUES ('695f4b98-6f9d-11d8-aaae-000000000001', '695f4b98-6f9d-11d8-aaae-000000000001', '695f4b98-6f9d-11d8-aaae-080058000000', 0, '2018-06-13 14:11:41');

INSERT INTO t_messages (messageid, content, senduserid, acceptuserid, status, createtime) VALUES ('695f4b98-6f9d-11d8-aaae-080058000001', '你妈妈叫你回家吃饭了', '695f4b98-6f9d-11d8-aaae-080058000001', '695f4b98-6f9d-11d8-aaae-080058000000', 0, '2018-06-13 14:11:41');
