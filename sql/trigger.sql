Delimiter //
DROP TRIGGER IF EXISTS total_credits;
Create Trigger total_credits After Insert ON select_course For Each Row
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

Delimiter //
DROP TRIGGER IF EXISTS total_credits2;
Create Trigger total_credits2 After delete ON select_course For Each Row
BEGIN
	DECLARE total_c INT;
    SELECT sum(cscore)
		FROM course, select_course
        WHERE sno = old.sno and course.cno = select_course.cno 
        INTO total_c;
	UPDATE student
		SET total_credits = total_c
        WHERE sno = old.sno;
END //
Delimiter ;
