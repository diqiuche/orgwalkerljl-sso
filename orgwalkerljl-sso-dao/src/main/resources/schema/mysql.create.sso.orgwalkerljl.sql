/**
 * 用户认证信息
 */
CREATE TABLE sso_user(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '主键Id',
	user_id VARCHAR(64) NOT NULL COMMENT '用户Id',
	user_name VARCHAR(64) NOT NULL COMMENT '用户名称',
	alias VARCHAR(64) NOT NULL COMMENT '用户别名/昵称',
	email VARCHAR(64) DEFAULT NULL COMMENT '邮箱',
	mobile VARCHAR(16) DEFAULT NULL COMMENT '手机',
	password CHAR(16) NOT NULL COMMENT '密码',
	salt CHAR(8) NOT NULL COMMENT '随机盐',
	last_login_time DATETIME NOT NULL COMMENT '最近登录时间',
	last_login_ip VARCHAR(32) NOT NULL COMMENT '最近登录Ip',
	last_login_agent TINYINT(1) NOT NULL COMMENT '最近登录客户端',
	remark VARCHAR(256) DEFAULT NULL COMMENT '备注',
	status TINYINT(1) NOT NULL COMMENT '状态,1:启用,2:停用,3:删除',
	creator VARCHAR(64) NOT NULL COMMENT '创建者',
	created_time DATETIME NOT NULL COMMENT '创建时间',
	modifier VARCHAR(64) NOT NULL COMMENT '修改者',
	modified_time DATETIME NOT NULL COMMENT '修改时间'
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '用户认证信息';
/** 添加索引、约束等*/
ALTER TABLE sso_user ADD UNIQUE(user_id);
ALTER TABLE sso_user ADD UNIQUE(user_name);
ALTER TABLE sso_user ADD UNIQUE(email);
ALTER TABLE sso_user ADD UNIQUE(mobile);

/**
 * 登录信息
 */
CREATE TABLE sso_login_info(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '主键Id',
	user_id VARCHAR(64) NOT NULL COMMENT '登录账号',
	user_name VARCHAR(64) NOT NULL COMMENT '登录名',
	login_ip VARCHAR(32) NOT NULL COMMENT '登录Ip',
	login_time DATETIME NOT NULL COMMENT '登录时间',
	logout_time DATETIME NOT NULL COMMENT '登出时间',
	login_agent TINYINT(1) NOT NULL COMMENT '登录终端'
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '登录信息';