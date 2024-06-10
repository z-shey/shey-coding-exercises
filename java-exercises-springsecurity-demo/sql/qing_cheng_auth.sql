use qing_cheng_auth;

CREATE TABLE `account`
(
    `user_id`       bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户 ID，主键，自动增长',
    `user_account`  varchar(50)     NOT NULL COMMENT '用户账号',
    `user_password` varchar(255)    NOT NULL COMMENT '加密后的用户密码',
    `create_time`   datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '账户创建时间',
    `update_time`   datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '账户更新时间',
    `deleted_flag`  tinyint         NOT NULL DEFAULT 0 COMMENT '删除标（0 未删除，1 已删除）',
    PRIMARY KEY (`user_id`)
);

