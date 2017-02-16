CREATE TABLE `bigdata`.`student` (
  `classno` VARCHAR(20) NOT NULL COMMENT '班号',
  `stuid` VARCHAR(20) NOT NULL COMMENT '学号',
  `name` VARCHAR(100) NULL COMMENT '姓名',
  `birth` DATETIME NULL COMMENT '生日',
  `score` FLOAT NULL COMMENT '成绩',
  PRIMARY KEY (`classno`, `stuid`)  COMMENT '');