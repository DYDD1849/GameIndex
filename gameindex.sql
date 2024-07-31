/*
 Navicat MySQL Data Transfer

 Source Server         : hello
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : gameindex

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 31/07/2024 19:27:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for game
-- ----------------------------
DROP TABLE IF EXISTS `game`;
CREATE TABLE `game`  (
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `date` date NOT NULL,
  `intro` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`name`, `date`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of game
-- ----------------------------
INSERT INTO `game` VALUES ('bbbbbbbb ', '2024-07-13', ' aaaaaa', '屏幕截图 2023-05-05 012038.png');
INSERT INTO `game` VALUES ('dydd', '2024-06-08', 'uuuuuu', '屏幕截图 2024-06-26 211242.png');
INSERT INTO `game` VALUES ('niaho', '2024-05-30', 'ceshi', 'nihao.png');
INSERT INTO `game` VALUES ('PVZ', '2024-03-02', '塔防经营', 'library_600x900(9).jpg');
INSERT INTO `game` VALUES ('使命召唤 ', '2024-06-27', '  yyyyyy', '使命召唤.jpg');
INSERT INTO `game` VALUES ('千恋万花', '2021-07-16', '恋爱模拟', 'library_600x900(24).jpg');
INSERT INTO `game` VALUES ('幻兽帕鲁', '2024-06-18', 'a', '幻兽帕鲁.jpg');
INSERT INTO `game` VALUES ('恶魔轮盘', '2024-06-18', 'aa', '恶魔轮盘.jpg');
INSERT INTO `game` VALUES ('曼岛TT:边缘竞速', '2024-06-07', '体育竞速', 'library_600x900(12).jpg');
INSERT INTO `game` VALUES ('极品飞车21：热度', '2024-06-22', '体育竞速', 'library_600x900(4).jpg');
INSERT INTO `game` VALUES ('死亡细胞', '2024-06-18', 'aaa', '死亡细胞.jpg');
INSERT INTO `game` VALUES ('艾尔登法环', '2024-06-18', 'aa', '艾尔登法环.jpg');
INSERT INTO `game` VALUES ('荒野大镖客2', '2024-06-18', 'a', '荒野大镖客2.jpg');
INSERT INTO `game` VALUES ('赛博朋克2077', '2024-06-18', 'aa', '赛博朋克2077.jpg');

-- ----------------------------
-- Table structure for liuyan
-- ----------------------------
DROP TABLE IF EXISTS `liuyan`;
CREATE TABLE `liuyan`  (
  `liuyanRen` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `liuyantime` datetime(0) NOT NULL,
  `liuyan` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gamename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`liuyanRen`, `liuyantime`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of liuyan
-- ----------------------------
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-21 10:40:33', '千恋万花', '输入文字');
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-21 10:40:34', '千恋万花', '输入文字');
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-21 10:45:20', '使命召唤 ', '输入文字');
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-21 10:48:51', '千恋万花', '输入文字');
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-21 10:49:42', '使命召唤 ', '输入文字');
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-21 10:54:36', 'niaho', '输入文字');
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-21 10:58:54', 'niaho', '输入文字');
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-21 11:01:41', '千恋万花', '输入文字');
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-21 11:02:55', 'niaho', '输入文字');
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-21 11:03:59', 'niaho', '输入文字');
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-21 11:04:54', 'niaho', '输入文字');
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-21 11:05:49', 'niaho', '输入文字');
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-21 11:06:50', 'niaho', '输入文字');
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-21 11:37:24', 'niaho', '输入文字');
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-21 14:24:29', 'niaho', '输入文字');
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-21 14:24:31', 'niaho', '输入文字');
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-21 14:24:32', 'niaho', '输入文字');
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-21 14:24:33', 'niaho', '输入文字');
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-21 14:24:34', 'niaho', '输入文字');
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-21 14:28:31', '输入文字', 'niaho');
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-21 14:28:40', '年后', 'niaho');
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-21 14:28:50', '你好', 'niaho');
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-21 14:31:48', '12341234', 'niaho');
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-21 14:39:11', '第一', '蜘蛛侠');
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-21 14:39:24', '第一', '蜘蛛侠');
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-21 14:39:37', '沙发', '蜘蛛侠');
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-21 14:39:59', '沙发', '幻兽帕鲁');
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-21 15:12:16', '沙发', 'PVZ');
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-21 15:33:28', '你好', 'niaho');
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-21 20:47:50', '第二', '幻兽帕鲁');
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-21 20:48:12', '黄金树之影', '艾尔登法环');
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-21 20:49:05', '你好', '使命召唤 ');
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-22 10:32:39', '你好', '使命召唤 ');
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-26 23:09:31', '这是我刚刚发的消息', 'niaho');
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-27 15:16:06', 'natrue game\r\n', 'dydd');
INSERT INTO `liuyan` VALUES ('dydd1849', '2024-06-27 15:16:53', '这是一条测试消息', 'dydd');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `isManger` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('123123', '123123', 'false');
INSERT INTO `user` VALUES ('2042680341', 'nihao', 'false');
INSERT INTO `user` VALUES ('21312', '123123', 'false');
INSERT INTO `user` VALUES ('666666', 'hujian', 'false');
INSERT INTO `user` VALUES ('Daaaa', '12345678', 'true');
INSERT INTO `user` VALUES ('dydd111111', '448487468768', 'false');
INSERT INTO `user` VALUES ('dydd1849', '45646', 'true');
INSERT INTO `user` VALUES ('iiiiiiiiiiii', 'iiiiiiiiiiii', 'false');
INSERT INTO `user` VALUES ('ppppp', 'ooooo', 'false');
INSERT INTO `user` VALUES ('weangler2', '123456', 'false');
INSERT INTO `user` VALUES ('xiugai', 'fasdfasdfasfdasf', 'false');
INSERT INTO `user` VALUES ('yuezhixiang', '123456', 'false');

SET FOREIGN_KEY_CHECKS = 1;
