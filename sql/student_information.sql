#修改年龄
delimiter //
DROP Procedure IF EXISTS update_student_age;
Create Procedure update_student_age(IN update_sno CHAR(4), IN n_age INT)
BEGIN
	DECLARE s INT DEFAULT 0;
	DECLARE a INT;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET s = 1;
	START TRANSACTION;
    SELECT count(*)
		FROM student
        WHERE sno = update_sno
        INTO a;
	IF a != 1 THEN
		SET s = 2;
	END IF;
		UPDATE student SET age = n_age WHERE sno = update_sno;
    IF s = 0 THEN
		SELECT CONCAT('修改成功') AS message;
        COMMIT;
	else
		SELECT CONCAT('用户不存在') AS message;
        ROLLBACK;
	END IF;
END //
delimiter ;


call update_student_age("S001",99);
call update_student_age("S001",21);
UPDATE student SET age = 21 WHERE sno = 'S001';


#修改性别
delimiter //
DROP Procedure IF EXISTS update_student_sex;
Create Procedure update_student_sex(IN update_sno CHAR(4), IN n_sex CHAR(45))
BEGIN
	DECLARE s INT DEFAULT 0;
	DECLARE a INT;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET s = 1;
	START TRANSACTION;
    SELECT count(*)
		FROM student
        WHERE sno = update_sno
        INTO a;
	IF a != 1 THEN
		SET s = 2;
	END IF;
	UPDATE student SET sex = n_sex WHERE sno = update_sno;
    IF s = 0 THEN
		SELECT CONCAT('修改成功') AS message;
        COMMIT;
	else
		SELECT CONCAT('用户不存在') AS message;
        ROLLBACK;
	END IF;
END //
delimiter ;

call update_student_sex("S002","男");
call update_student_sex("S002","女");


#修改种族
delimiter //
DROP Procedure IF EXISTS update_student_racial;
Create Procedure update_student_racial(IN update_sno CHAR(4), IN n_racial CHAR(45))
BEGIN
	DECLARE s INT DEFAULT 0;
	DECLARE a INT;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET s = 1;
	START TRANSACTION;
    SELECT count(*)
		FROM student
        WHERE sno = update_sno
        INTO a;
	IF a != 1 THEN
		SET s = 2;
	END IF;
	UPDATE student SET racial = n_racial WHERE sno = update_sno;
    IF s = 0 THEN
		SELECT CONCAT('修改成功') AS message;
        COMMIT;
	else
		SELECT CONCAT('用户不存在') AS message;
        ROLLBACK;
	END IF;
END //
delimiter ;

call update_student_racial("S003","汉族");
call update_student_racial("S003","满族");

#修改照片
delimiter //
DROP Procedure IF EXISTS update_student_picture;
Create Procedure update_student_picture(IN update_sno CHAR(4), IN n_picture CHAR(100))
BEGIN
	DECLARE s INT DEFAULT 0;
	DECLARE a INT;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET s = 1;
	START TRANSACTION;
    SELECT count(*)
		FROM student
        WHERE sno = update_sno
        INTO a;
	IF a != 1 THEN
		SET s = 2;
	END IF;
	UPDATE student SET picture = n_picture WHERE sno = update_sno;
    IF s = 0 THEN
		SELECT CONCAT('修改成功') AS message;
        COMMIT;
	else
		SELECT CONCAT('用户不存在') AS message;
        ROLLBACK;
	END IF;
END //
delimiter ;

call update_student_picture("S004","无");
call update_student_picture("S004","./sql/赵六.jpg");


#修改联系方式
delimiter //
DROP Procedure IF EXISTS update_student_contact;
Create Procedure update_student_contact(IN update_sno CHAR(4), IN n_contact CHAR(45))
BEGIN
	DECLARE s INT DEFAULT 0;
	DECLARE a INT;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET s = 1;
	START TRANSACTION;
    SELECT count(*)
		FROM student
        WHERE sno = update_sno
        INTO a;
	IF a != 1 THEN
		SET s = 2;
	END IF;
	UPDATE student SET contact = n_contact WHERE sno = update_sno;
    IF s = 0 THEN
		SELECT CONCAT('修改成功') AS message;
        COMMIT;
	else
		SELECT CONCAT('用户不存在') AS message;
        ROLLBACK;
	END IF;
END //
delimiter ;

call update_student_contact("S001","123456789");
call update_student_contact("S001","123456");


#修改总学分
delimiter //
DROP Procedure IF EXISTS update_student_totalcredits;
Create Procedure update_student_totalcredits(IN update_sno CHAR(4), IN n_totalcredits INT)
BEGIN
	DECLARE s INT DEFAULT 0;
	DECLARE a INT;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET s = 1;
	START TRANSACTION;
    SELECT count(*)
		FROM student
        WHERE sno = update_sno
        INTO a;
	IF a != 1 THEN
		SET s = 2;
	END IF;
	UPDATE student SET total_credits = n_totalcredits WHERE sno = update_sno;
    IF s = 0 THEN
		SELECT CONCAT('修改成功') AS message;
        COMMIT;
	else
		SELECT CONCAT('用户不存在') AS message;
        ROLLBACK;
	END IF;
END //
delimiter ;

call update_student_totalcredits("S002","120");
call update_student_totalcredits("S002","7");

#修改专业
delimiter //
DROP Procedure IF EXISTS update_student_major;
Create Procedure update_student_major(IN update_sno CHAR(4), IN n_major CHAR(100))
BEGIN
	DECLARE s INT DEFAULT 0;
	DECLARE a INT;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET s = 1;
	START TRANSACTION;
    SELECT count(*)
		FROM student
        WHERE sno = update_sno
        INTO a;
	IF a != 1 THEN
		SET s = 2;
	END IF;
	UPDATE student SET major = n_major WHERE sno = update_sno;
    IF s = 0 THEN
		SELECT CONCAT('修改成功') AS message;
        COMMIT;
	else
		SELECT CONCAT('用户不存在') AS message;
        ROLLBACK;
	END IF;
END //
delimiter ;

call update_student_major("S001","计算机学院");
call update_student_major("S002","数学学院");
call update_student_major("S003","化学学院");
call update_student_major("S004","生物学院");
call update_student_major("S005","物理学院");




