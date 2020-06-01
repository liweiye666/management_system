/*
 Navicat Premium Data Transfer

 Source Server         : team
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : 120.25.144.131:3306
 Source Schema         : management_system

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 01/06/2020 17:14:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_dept
-- ----------------------------
DROP TABLE IF EXISTS `tbl_dept`;
CREATE TABLE `tbl_dept`  (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_num` int(11) NULL DEFAULT NULL,
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 107 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_dept
-- ----------------------------
INSERT INTO `tbl_dept` VALUES (101, '开发部门', 1, '0', NULL);
INSERT INTO `tbl_dept` VALUES (102, '人事部门', 2, '0', NULL);
INSERT INTO `tbl_dept` VALUES (103, '测试部门', 3, '0', NULL);
INSERT INTO `tbl_dept` VALUES (104, '财务部门', 4, '0', NULL);
INSERT INTO `tbl_dept` VALUES (105, '运维部门', 5, '0', NULL);
INSERT INTO `tbl_dept` VALUES (106, '市场部门', 6, '0', NULL);

-- ----------------------------
-- Table structure for tbl_menu
-- ----------------------------
DROP TABLE IF EXISTS `tbl_menu`;
CREATE TABLE `tbl_menu`  (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  `order_num` int(11) NULL DEFAULT NULL,
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `menu_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `visible` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `perms` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1020 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_menu
-- ----------------------------
INSERT INTO `tbl_menu` VALUES (1, '系统管理', 0, 1, '#', 'M', '0', NULL, 'layui-icon-set');
INSERT INTO `tbl_menu` VALUES (2, '系统监控', 0, 2, '#', 'M', '0', NULL, 'layui-icon-camera-fill');
INSERT INTO `tbl_menu` VALUES (100, '用户管理', 1, 1, '#', 'C', '0', '/systemUserView', '#');
INSERT INTO `tbl_menu` VALUES (101, '角色管理', 1, 2, '#', 'C', '0', '/systemRoleView', '#');
INSERT INTO `tbl_menu` VALUES (102, '菜单管理', 1, 3, '#', 'C', '0', '/systemMenuView', '#');
INSERT INTO `tbl_menu` VALUES (103, '部门管理', 1, 4, '#', 'C', '0', '/systemDeptView', '#');
INSERT INTO `tbl_menu` VALUES (109, '在线用户', 2, 1, '#', 'C', '0', NULL, '#');
INSERT INTO `tbl_menu` VALUES (111, '数据监控', 2, 3, '#', 'C', '0', NULL, '#');
INSERT INTO `tbl_menu` VALUES (112, '服务监控', 2, 3, '#', 'C', '0', NULL, '#');
INSERT INTO `tbl_menu` VALUES (1000, '用户查询', 100, 1, '#', 'F', '0', '/systemUserSelect', '#');
INSERT INTO `tbl_menu` VALUES (1001, '用户新增', 100, 2, '#', 'F', '0', '/systemUserInsert', '#');
INSERT INTO `tbl_menu` VALUES (1002, '用户修改', 100, 3, '#', 'F', '0', '/systemUserUpdate', '#');
INSERT INTO `tbl_menu` VALUES (1003, '用户删除', 100, 4, '#', 'F', '0', '/systemUserDelete', '#');
INSERT INTO `tbl_menu` VALUES (1004, '用户导出', 100, 5, '#', 'F', '0', '', '#');
INSERT INTO `tbl_menu` VALUES (1005, '重置密码', 100, 6, '#', 'F', '0', '', '#');
INSERT INTO `tbl_menu` VALUES (1006, '角色查询', 101, 1, '#', 'F', '0', '/systemRoleSelect', '#');
INSERT INTO `tbl_menu` VALUES (1007, '角色新增', 101, 2, '#', 'F', '0', '/systemRoleInsert', '#');
INSERT INTO `tbl_menu` VALUES (1008, '角色修改', 101, 3, '#', 'F', '0', '/systemRoleUpdate', '#');
INSERT INTO `tbl_menu` VALUES (1009, '角色删除', 101, 4, '#', 'F', '0', '/systemRoleDelete', '#');
INSERT INTO `tbl_menu` VALUES (1010, '角色导出', 101, 5, '#', 'F', '0', '', '#');
INSERT INTO `tbl_menu` VALUES (1011, '菜单查询', 102, 1, '#', 'F', '0', '/systemMenuSelect', '#');
INSERT INTO `tbl_menu` VALUES (1012, '菜单新增 ', 102, 2, '#', 'F', '0', '/systemMenuInsert', '#');
INSERT INTO `tbl_menu` VALUES (1013, '菜单修改', 102, 3, '#', 'F', '0', '/systemMenuUpdate', '#');
INSERT INTO `tbl_menu` VALUES (1014, '菜单删除', 102, 4, '#', 'F', '0', '/systemMenuDelete', '#');
INSERT INTO `tbl_menu` VALUES (1015, '部门查询', 103, 1, '#', 'F', '0', '/systemDeptSelect', '#');
INSERT INTO `tbl_menu` VALUES (1016, '部门新增', 103, 2, '#', 'F', '0', '/systemDeptInsert', '#');
INSERT INTO `tbl_menu` VALUES (1017, '部门修改', 103, 3, '#', 'F', '0', '/systemDeptUpdate', '#');
INSERT INTO `tbl_menu` VALUES (1018, '部门删除', 103, 4, '#', 'F', '0', '/systemDeptDelete', '#');

-- ----------------------------
-- Table structure for tbl_role
-- ----------------------------
DROP TABLE IF EXISTS `tbl_role`;
CREATE TABLE `tbl_role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_key` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_sort` int(11) NULL DEFAULT NULL,
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 62 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_role
-- ----------------------------
INSERT INTO `tbl_role` VALUES (1, '管理员', 'root', 1, '0', '0');
INSERT INTO `tbl_role` VALUES (2, '普通角色', 'common', 2, '0', '0');
INSERT INTO `tbl_role` VALUES (5, '游客', 'tourist', 101, '0', NULL);
INSERT INTO `tbl_role` VALUES (6, '划水', 'swimming', 102, '0', NULL);
INSERT INTO `tbl_role` VALUES (7, '开发人员', 'exploit', 3, '0', NULL);
INSERT INTO `tbl_role` VALUES (8, '运维人员', 'operation', NULL, '0', NULL);
INSERT INTO `tbl_role` VALUES (9, '测试人员', 'test', NULL, '0', NULL);
INSERT INTO `tbl_role` VALUES (61, '123456', '123456', NULL, '0', NULL);

-- ----------------------------
-- Table structure for tbl_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `tbl_role_menu`;
CREATE TABLE `tbl_role_menu`  (
  `role_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_role_menu
-- ----------------------------
INSERT INTO `tbl_role_menu` VALUES (1, 100);
INSERT INTO `tbl_role_menu` VALUES (1, 101);
INSERT INTO `tbl_role_menu` VALUES (1, 102);
INSERT INTO `tbl_role_menu` VALUES (1, 103);
INSERT INTO `tbl_role_menu` VALUES (1, 1000);
INSERT INTO `tbl_role_menu` VALUES (1, 1001);
INSERT INTO `tbl_role_menu` VALUES (1, 1002);
INSERT INTO `tbl_role_menu` VALUES (1, 1003);
INSERT INTO `tbl_role_menu` VALUES (1, 1006);
INSERT INTO `tbl_role_menu` VALUES (1, 1007);
INSERT INTO `tbl_role_menu` VALUES (1, 1008);
INSERT INTO `tbl_role_menu` VALUES (1, 1009);
INSERT INTO `tbl_role_menu` VALUES (1, 1011);
INSERT INTO `tbl_role_menu` VALUES (1, 1012);
INSERT INTO `tbl_role_menu` VALUES (1, 1013);
INSERT INTO `tbl_role_menu` VALUES (1, 1014);
INSERT INTO `tbl_role_menu` VALUES (1, 1015);
INSERT INTO `tbl_role_menu` VALUES (1, 1016);
INSERT INTO `tbl_role_menu` VALUES (1, 1017);
INSERT INTO `tbl_role_menu` VALUES (1, 1018);
INSERT INTO `tbl_role_menu` VALUES (2, 100);
INSERT INTO `tbl_role_menu` VALUES (2, 101);
INSERT INTO `tbl_role_menu` VALUES (2, 102);
INSERT INTO `tbl_role_menu` VALUES (2, 103);
INSERT INTO `tbl_role_menu` VALUES (2, 1000);
INSERT INTO `tbl_role_menu` VALUES (2, 1006);
INSERT INTO `tbl_role_menu` VALUES (2, 1011);
INSERT INTO `tbl_role_menu` VALUES (2, 1015);

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_id` int(11) NULL DEFAULT NULL,
  `login_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phonenumber` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatar` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `salt` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES (1, 1, 'root', '大老板', 'boss@root.com', '13838383838', '男', '', 'd41fd43518c932db35830b87065ae52d', 'root', '0', NULL);
INSERT INTO `tbl_user` VALUES (2, 1, 'admin', '老板娘', 'boss@admin.com', '13535353535', '女', '', '75bd3b5c890813b46150b93bb175fb4e', 'admin', '0', NULL);
INSERT INTO `tbl_user` VALUES (7, NULL, 'lisi', '李四', 'lisi@gmail.com', '14141414141', '男', NULL, '17da286195a02835ad10465826e48a41', 'ff3813f7-437c-4b8b-af16-86551b71bda1', '0', NULL);
INSERT INTO `tbl_user` VALUES (9, NULL, 'liweiye', '利伟业', '1320268524@qq.com', '18420013207', '男', NULL, '9deba4991dfca8cc23a2ea6424094b3c', '813db9dd-5e27-4ef7-9df9-d467e5fd74a2', '0', NULL);
INSERT INTO `tbl_user` VALUES (10, NULL, 'zby', '周博义', '1144188685@qq.com', '18575110540', '男', NULL, '5942965b0f97fa60417bfadc57adc446', '4d67246f-d989-48b4-b4e9-0e4547be4741', '0', NULL);

-- ----------------------------
-- Table structure for tbl_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user_role`;
CREATE TABLE `tbl_user_role`  (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_user_role
-- ----------------------------
INSERT INTO `tbl_user_role` VALUES (1, 1);
INSERT INTO `tbl_user_role` VALUES (2, 1);
INSERT INTO `tbl_user_role` VALUES (7, 2);
INSERT INTO `tbl_user_role` VALUES (9, 1);
INSERT INTO `tbl_user_role` VALUES (10, 1);

SET FOREIGN_KEY_CHECKS = 1;
