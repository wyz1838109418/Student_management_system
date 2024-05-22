Delimiter //
DROP TRIGGER IF EXISTS total_credits;
Create Trigger total_credits After insert ON select_course For Each Row
BEGIN
	DECLARE total_c INT;
    SELECT sum(cscore)
		FROM course, select_course
        WHERE sno = new.sno and course.cno = select_course.cno 
        INTO total_c;
	UPDATE student
		SET total_credits = total_c
        WHERE sno = new.sno;
END //
Delimiter ;

START TRANSACTION;
INSERT INTO student_management.select_course (sno, cno, score) 
VALUES 
('S005', 'C001', 45);
ROLLBACK;