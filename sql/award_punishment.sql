#添加奖项
delimiter //
DROP Procedure IF EXISTS add_award;
Create Procedure add_award(IN update_sno CHAR(4), IN addaward CHAR(45))
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
		FROM award
        WHERE aname = addaward
        INTO b;
	IF a != 1 THEN
		SET s = 2;
	END IF;
	IF b != 1 THEN
		SET s = 3;
	END IF;
	INSERT INTO student_management.asituation (sno,aname) 
	VALUES 
	(update_sno,addaward);
    IF s = 0 THEN
		SELECT CONCAT('添加奖项成功') AS message;
        COMMIT;
	else
		SELECT CONCAT('用户不存在') AS message;
        ROLLBACK;
	END IF;
END //
delimiter ;

call add_award("S001","一等奖");
call add_award("S002","二等奖");
call add_award("S003","三等奖");


#去除奖项
delimiter //
DROP Procedure IF EXISTS delete_award;
Create Procedure delete_award(IN update_sno CHAR(4), IN deleteaward CHAR(45))
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
		FROM award
        WHERE aname = deleteaward
        INTO b;
	IF a != 1 THEN
		SET s = 2;
	END IF;
	IF b != 1 THEN
		SET s = 3;
	END IF;
	DELETE FROM student_management.asituation
		WHERE sno = update_sno and aname = deleteaward;
    IF s = 0 THEN
		SELECT CONCAT('取消奖项成功') AS message;
        COMMIT;
	else
		SELECT CONCAT('用户不存在') AS message;
        ROLLBACK;
	END IF;
END //
delimiter ;

call delete_award("S001","一等奖");
call delete_award("S002","二等奖");
call delete_award("S003","三等奖");


#添加惩罚
delimiter //
DROP Procedure IF EXISTS add_punishment;
Create Procedure add_punishment(IN update_sno CHAR(4), IN addpunishment CHAR(45))
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
		FROM punishment
        WHERE pname = addpunishment
        INTO b;
	IF a != 1 THEN
		SET s = 2;
	END IF;
	IF b != 1 THEN
		SET s = 3;
	END IF;
	INSERT INTO student_management.psituation (sno,pname) 
	VALUES 
	(update_sno,addpunishment);
    IF s = 0 THEN
		SELECT CONCAT('添加惩罚成功') AS message;
        COMMIT;
	else
		SELECT CONCAT('用户不存在') AS message;
        ROLLBACK;
	END IF;
END //
delimiter ;

call add_punishment("S001","一等罚");
call add_punishment("S002","二等罚");
call add_punishment("S003","三等罚");

#去除惩罚项
delimiter //
DROP Procedure IF EXISTS delete_punishment;
Create Procedure delete_punishment(IN update_sno CHAR(4), IN deletepunishment CHAR(45))
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
		FROM punishment
        WHERE pname = deletepunishment
        INTO b;
	IF a != 1 THEN
		SET s = 2;
	END IF;
	IF b != 1 THEN
		SET s = 3;
	END IF;
	DELETE FROM student_management.psituation
		WHERE sno = update_sno and pname = deletepunishment;
    IF s = 0 THEN
		SELECT CONCAT('取消惩罚项成功') AS message;
        COMMIT;
	else
		SELECT CONCAT('用户不存在') AS message;
        ROLLBACK;
	END IF;
END //
delimiter ;

call delete_punishment("S001","一等罚");
call delete_punishment("S002","二等罚");
call delete_punishment("S003","三等罚");