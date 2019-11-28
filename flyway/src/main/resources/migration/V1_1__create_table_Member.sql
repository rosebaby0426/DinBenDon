DROP TABLE IF EXISTS `member`;

-- 會員
create table `member`
(
    id                  int(10)     unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    account             varchar(64)                      NOT NULL COMMENT '账号',
    password            varchar(256)                     NOT NULL COMMENT '密码',
    name                varchar(100)                     NOT NULL COMMENT '姓名',
    create_time         datetime                         NOT NULL COMMENT '建立时间',
    last_login_time     datetime                                  COMMENT '最后登入时间',
    login_failure_times int(1)    default 0                       COMMENT '登入失敗次數',
    status              varchar(20)                      NOT NULL COMMENT '會員狀態，NORMAL:可登入  LOCK:鎖定',
    UNIQUE KEY (account)
);


