/**
 * 用户认证信息
 */
DROP TABLE IF EXISTS sso_user;
CREATE TABLE sso_user(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '主键Id',
	account_no VARCHAR(64) NOT NULL COMMENT '账号Id',
	account_name VARCHAR(64) NOT NULL COMMENT '账号名称',
	password CHAR(16) NOT NULL COMMENT '密码',
	salt CHAR(8) NOT NULL COMMENT '随机盐',
	last_login_date DATETIME NOT NULL COMMENT '最近登录日期',
	remark VARCHAR(256) DEFAULT NULL COMMENT '备注',
	status TINYINT(1) NOT NULL COMMENT '状态,1:启用,2:停用,3:删除',
	create_date DATETIME NOT NULL COMMENT '创建日期',
	create_user_id VARCHAR(64) NOT NULL COMMENT '创建者Id',
	create_user_name VARCHAR(64) NOT NULL COMMENT '创建者姓名',
	last_modify_date DATETIME NOT NULL COMMENT '最近更新日期',
	last_modify_user_id VARCHAR(64) NOT NULL COMMENT '最近修改者Id',
	last_modify_user_name VARCHAR(64) NOT NULL COMMENT '最近修改者姓名'
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE utf8_bin COMMENT '用户认证信息';
/** 添加索引、约束等*/
ALTER TABLE sso_user ADD INDEX sso_user_index_account_no(account_no);
ALTER TABLE sso_user ADD INDEX sso_user_index_account_name(account_name);
ALTER TABLE sso_user ADD UNIQUE(account_no);
ALTER TABLE sso_user ADD UNIQUE(account_name);
/** 初始化数据*/
INSERT INTO sso_user(account_no,account_name,password,salt,last_login_date,remark,status,create_date,create_user_id,create_user_name,last_modify_date,last_modify_user_id,last_modify_user_name)
VALUES
('jarvis','JARVIS','55a657c3846f9f46','99887745',NOW(),'',1,NOW(),'jarvis','JARVIS',NOW(),'jarivs','JARVIS')
;
