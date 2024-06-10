use moon_db;

CREATE TABLE `account`  (
  `user_id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户 ID，主键，自动增长',
  `user_account` varchar(50) NOT NULL COMMENT '用户账号',
  `user_password` varchar(255) NOT NULL COMMENT '加密后的用户密码',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '账户创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '账户更新时间',
  `deleted_flag` tinyint NOT NULL DEFAULT 0 COMMENT '是否删除，0 表示未删除，1 表示已删除',
  PRIMARY KEY (`user_id`)
);

CREATE TABLE `account_role`  (
  `user_id` bigint NULL,
  `role_id` bigint NULL
);

CREATE TABLE `post_post`  (
  `post_id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '帖子 ID，主键，自动增长',
  `user_id` bigint NOT NULL COMMENT '作者 ID,user_id',
  `post_title` varchar(255) NOT NULL COMMENT '帖子标题',
  `post_content` text NULL COMMENT '帖子内容',
  `post_time` datetime NOT NULL COMMENT '发帖时间',
  `last_edit_time` datetime NULL COMMENT '最后编辑时间，可以为空',
  `category_id` int NOT NULL COMMENT '分类 ID',
  `status` tinyint NOT NULL COMMENT '帖子状态，草稿、已发布、已删除',
  `view_count` int NULL COMMENT '查看次数',
  `like_count` int NULL COMMENT '点赞次数',
  `comment_count` int NULL COMMENT '评论数量',
  `is_sticky` tinyint NULL COMMENT '是否置顶',
  `is_deleted` tinyint NOT NULL COMMENT '是否删除',
  PRIMARY KEY (`post_id`)
);

CREATE TABLE `sys_menu`  (
  `menu_id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(64) NOT NULL DEFAULT 'NULL' COMMENT '菜单名',
  `menu_path` varchar(255) NULL COMMENT '路由地址',
  `menu_component` varchar(255) NULL COMMENT '组件地址',
  `menu_visible` tinyint NULL DEFAULT 0 COMMENT '菜单状态（0显示，1隐藏）',
  `menu_status` tinyint NULL DEFAULT 0 COMMENT '菜单状态（0正常，1停用）',
  `menu_permission` varchar(255) NULL COMMENT '权限标识',
  `menu_icon` varchar(255) NULL DEFAULT '#' COMMENT '菜单图标',
  `deleted_flag` tinyint NULL DEFAULT 0 COMMENT '是否删除（0未删除，1已删除）',
  `create_by` varchar(255) NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_by` varchar(255) NULL,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `remark` varchar(255) NULL COMMENT '备注',
  PRIMARY KEY (`menu_id`)
);

CREATE TABLE `sys_role`  (
  `role_id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL COMMENT '权限名',
  `role_key` varchar(255) NULL COMMENT '权限字符串',
  `role_status` tinyint NULL DEFAULT 0 COMMENT '角色状态（0正常，1停用）',
  `deleted_flag` tinyint NULL DEFAULT 0,
  `create_by` varchar(255) NULL,
  `create_time` datetime NULL,
  `update_by` varchar(255) NULL,
  `update_time` datetime NULL,
  `remark` varchar(255) NULL,
  PRIMARY KEY (`role_id`)
);

CREATE TABLE `sys_role_menu`  (
  `role_id` bigint NOT NULL,
  `menu_id` bigint NOT NULL
);

CREATE TABLE `user_info`  (
  `user_id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户 ID，主键，自动增长',
  `user_name` varchar(50) NOT NULL COMMENT '用户昵称',
  `user_gender` tinyint NOT NULL DEFAULT 0 COMMENT '性别，0 表示未知或未设置，1 表示男，2 表示女',
  `user_birthday` date NULL COMMENT '用户生日',
  `user_avatar` varchar(255) NOT NULL COMMENT '用户头像链接',
  `user_level` varchar(50) NOT NULL DEFAULT 0 COMMENT '用户等级',
  `user_motto` varchar(255) NULL COMMENT '用户座右铭',
  `user_tag` varchar(100) NULL COMMENT '用户标签，用户给自己的标签',
  `user_email` varchar(255) NULL COMMENT '用户邮箱',
  `user_tel` varchar(20) NULL COMMENT '用户手机号',
  `user_blog` varchar(255) NOT NULL COMMENT '用户个人博客地址',
  `create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`user_id`)
);

CREATE TABLE `user_platform`  (
  `user_id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户 ID，主键，自动增长',
  `platform_type` varchar(50) NULL COMMENT '第三方平台类型，QQ、微信、GitHub、Gitee',
  `platform_user_id` varchar(50) NULL COMMENT '第三方平台的用户 ID 或账号',
  `platform_user_data` text NULL COMMENT '第三方平台的额外绑定信息，如访问令牌等',
  `create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`user_id`)
);

ALTER TABLE `account_role` ADD CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `account` (`user_id`);
ALTER TABLE `account_role` ADD CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`);
ALTER TABLE `sys_role_menu` ADD CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`);
ALTER TABLE `sys_role_menu` ADD CONSTRAINT `menu_id` FOREIGN KEY (`menu_id`) REFERENCES `sys_menu` (`menu_id`);

