#添加学生
delimiter //
DROP Procedure IF EXISTS add_student;
Create Procedure add_student(IN ssno CHAR(4), IN sname VARCHAR(45), IN sex VARCHAR(45), IN age INT, IN racial VARCHAR(45), IN picture VARCHAR(100), IN contact VARCHAR(45), IN total_credits INT, IN major VARCHAR(100))
BEGIN
	DECLARE s INT DEFAULT 0;
	DECLARE a INT;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET s = 1;
	START TRANSACTION;
    SELECT count(*)
		FROM student
        WHERE sno = ssno
        INTO a;
	IF a = 1 THEN
		SET s = 2;
	END IF;
	INSERT INTO student_management.student (sno,sname,sex,age,racial,picture,contact,total_credits,major) 
	VALUES 
	(ssno,sname,sex,age,racial,picture,contact,total_credits,major);
    IF s = 0 THEN
		SELECT CONCAT('添加学生成功') AS message;
        COMMIT;
	else
		SELECT CONCAT('添加学生失败') AS message;
        ROLLBACK;
	END IF;
END //
delimiter ;

call add_student("S006","柳八","男",15,"汉族","./sql/柳八.jpg","111111",0,"计算机学院");

#删除学生
delimiter //
DROP Procedure IF EXISTS delete_student;
Create Procedure delete_student(IN ssno CHAR(4))
BEGIN
	DECLARE s INT DEFAULT 0;
	DECLARE a INT;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET s = 1;
	START TRANSACTION;
    SELECT count(*)
		FROM student
        WHERE sno = ssno
        INTO a;
	IF a != 1 THEN
		SET s = 2;
	END IF;
    DELETE FROM student_management.student
		WHERE sno = ssno;
    IF s = 0 THEN
		SELECT CONCAT('删除学生成功') AS message;
        COMMIT;
	else
		SELECT CONCAT('删除学生失败') AS message;
        ROLLBACK;
	END IF;
END //
delimiter ;

call delete_student("S006");