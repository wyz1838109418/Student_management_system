#添加选课
delimiter //
DROP Procedure IF EXISTS add_select_course;
Create Procedure add_select_course(IN update_sno CHAR(4), IN ccno CHAR(4), IN cscore INT)
BEGIN
	DECLARE s INT DEFAULT 0;
	DECLARE a INT;
    DECLARE b INT;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET s = 1;
	START TRANSACTION;
    SELECT count(*)
		FROM student
        WHERE sno = update_sno
        INTO a;
	 SELECT count(*)
		FROM course
        WHERE cno = ccno
        INTO b;
	IF a != 1 THEN
		SET s = 2;
	END IF;
	IF b != 1 THEN
		SET s = 3;
	END IF;
	INSERT INTO student_management.select_course (sno,cno,score) 
	VALUES 
	(update_sno,ccno,cscore);
    IF s = 0 THEN
		SELECT CONCAT('添加选课成功') AS message;
        COMMIT;
	else
		SELECT CONCAT('添加选课失败') AS message;
        ROLLBACK;
	END IF;
END //
delimiter ;

call add_select_course("S001","C002",99);


#取消课程
delimiter //
DROP Procedure IF EXISTS delete_select_course;
Create Procedure delete_select_course(IN update_sno CHAR(4), IN deletecourse CHAR(4))
BEGIN
	DECLARE s INT DEFAULT 0;
	DECLARE a INT;
    DECLARE b INT;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET s = 1;
	START TRANSACTION;
    SELECT count(*)
		FROM student
        WHERE sno = update_sno
        INTO a;
	 SELECT count(*)
		FROM course
        WHERE cno = deletecourse
        INTO b;
	IF a != 1 THEN
		SET s = 2;
	END IF;
	IF b != 1 THEN
		SET s = 3;
	END IF;
	DELETE FROM student_management.select_course
		WHERE sno = update_sno and cno = deletecourse;
    IF s = 0 THEN
		SELECT CONCAT('取消选课成功') AS message;
        COMMIT;
	else
		SELECT CONCAT('取消选课失败') AS message;
        ROLLBACK;
	END IF;
END //
delimiter ;

call delete_select_course("S001","C001");

#添加课程
delimiter //
DROP Procedure IF EXISTS add_course;
Create Procedure add_course(IN ccno CHAR(4), IN cname VARCHAR(45), IN ctime INT, IN cscore INT)
BEGIN
	DECLARE s INT DEFAULT 0;
	DECLARE a INT;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET s = 1;
	START TRANSACTION;
    SELECT count(*)
		FROM course
        WHERE cno = ccno
        INTO a;
	IF a = 1 THEN
		SET s = 2;
	END IF;
	INSERT INTO student_management.course (cno,cname,ctime,cscore) 
	VALUES 
	(ccno,cname,ctime,cscore);
    IF s = 0 THEN
		SELECT CONCAT('添加课程成功') AS message;
        COMMIT;
	else
		SELECT CONCAT('添加课程失败') AS message;
        ROLLBACK;
	END IF;
END //
delimiter ;

call add_course("C005","模式识别",30,2);

#删除课程
delimiter //
DROP Procedure IF EXISTS delete_course;
Create Procedure delete_course(IN ccno CHAR(4))
BEGIN
	DECLARE s INT DEFAULT 0;
	DECLARE a INT;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET s = 1;
	START TRANSACTION;
    SELECT count(*)
		FROM course
        WHERE cno = ccno
        INTO a;
	IF a != 1 THEN
		SET s = 2;
	END IF;
    DELETE FROM student_management.course
		WHERE cno = ccno;
    IF s = 0 THEN
		SELECT CONCAT('删除课程成功') AS message;
        COMMIT;
	else
		SELECT CONCAT('删除课程失败') AS message;
        ROLLBACK;
	END IF;
END //
delimiter ;

call delete_course("C005");