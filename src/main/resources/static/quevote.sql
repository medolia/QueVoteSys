-- phpMyAdmin SQL Dump
-- version 4.9.3
-- https://www.phpmyadmin.net/
--
-- 主机： localhost:8889
-- 生成日期： 2020-08-12 19:08:20
-- 服务器版本： 5.7.26
-- PHP 版本： 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- 数据库： `quevote_db`
--

-- --------------------------------------------------------

--
-- 表的结构 `answer_info`
--

CREATE TABLE `answer_info`
(
    `id`             int(50)      NOT NULL,
    `question_id`    int(50)      NOT NULL,
    `option_id`      int(50)      NOT NULL,
    `user_id`        int(50)      NOT NULL DEFAULT '0',
    `answer_content` varchar(255)          DEFAULT NULL,
    `create_ip`      varchar(255) NOT NULL,
    `create_date`    timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- --------------------------------------------------------

--
-- 表的结构 `option_info`
--

CREATE TABLE `option_info`
(
    `id`             int(50)      NOT NULL,
    `question_id`    int(50)      NOT NULL,
    `option_content` varchar(255) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

--
-- 转存表中的数据 `option_info`
--

INSERT INTO `option_info` (`id`, `question_id`, `option_content`)
VALUES (0, 0, 'Touching'),
       (1, 0, 'Ordinary'),
       (2, 0, 'Just so so'),
       (3, 1, 'High'),
       (4, 1, 'Medium'),
       (5, 1, 'Low'),
       (6, 2, 'Unique'),
       (7, 2, 'Common'),
       (8, 2, 'Low level'),
       (9, 3, 'Close to Reality'),
       (10, 3, 'Enough for a Game'),
       (11, 3, 'Disappointing');

-- --------------------------------------------------------

--
-- 表的结构 `question_info`
--

CREATE TABLE `question_info`
(
    `id`                   int(50)      NOT NULL,
    `question_name`        varchar(255) NOT NULL,
    `question_description` varchar(255) DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

--
-- 转存表中的数据 `question_info`
--

INSERT INTO `question_info` (`id`, `question_name`, `question_description`)
VALUES (0, 'Story Narrative', '叙事手法'),
       (1, 'Freedom of Game', '自由度'),
       (2, 'Philosophy of Art', '艺术哲学深度'),
       (3, 'Picture Quality', '画质');

-- --------------------------------------------------------

--
-- 表的结构 `user_info`
--

CREATE TABLE `user_info`
(
    `id`          int(50)      NOT NULL,
    `username`    varchar(255) NOT NULL,
    `password`    varchar(255) NOT NULL,
    `create_date` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

--
-- 转储表的索引
--

--
-- 表的索引 `answer_info`
--
ALTER TABLE `answer_info`
    ADD PRIMARY KEY (`id`),
    ADD KEY `question_id` (`question_id`),
    ADD KEY `option_id` (`option_id`),
    ADD KEY `user_id` (`user_id`);

--
-- 表的索引 `option_info`
--
ALTER TABLE `option_info`
    ADD PRIMARY KEY (`id`),
    ADD KEY `question_id` (`question_id`);

--
-- 表的索引 `question_info`
--
ALTER TABLE `question_info`
    ADD PRIMARY KEY (`id`);

--
-- 表的索引 `user_info`
--
ALTER TABLE `user_info`
    ADD PRIMARY KEY (`id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `answer_info`
--
ALTER TABLE `answer_info`
    MODIFY `id` int(50) NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `option_info`
--
ALTER TABLE `option_info`
    MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,
    AUTO_INCREMENT = 12;

--
-- 使用表AUTO_INCREMENT `question_info`
--
ALTER TABLE `question_info`
    MODIFY `id` int(50) NOT NULL AUTO_INCREMENT,
    AUTO_INCREMENT = 4;

--
-- 使用表AUTO_INCREMENT `user_info`
--
ALTER TABLE `user_info`
    MODIFY `id` int(50) NOT NULL AUTO_INCREMENT;

--
-- 限制导出的表
--

--
-- 限制表 `answer_info`
--
ALTER TABLE `answer_info`
    ADD CONSTRAINT `answer_info_ibfk_1` FOREIGN KEY (`option_id`) REFERENCES `option_info` (`id`),
    ADD CONSTRAINT `answer_info_ibfk_2` FOREIGN KEY (`question_id`) REFERENCES `question_info` (`id`),
    ADD CONSTRAINT `answer_info_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`);

--
-- 限制表 `option_info`
--
ALTER TABLE `option_info`
    ADD CONSTRAINT `option_info_ibfk_1` FOREIGN KEY (`question_id`) REFERENCES `question_info` (`id`);
