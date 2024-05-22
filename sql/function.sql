Delimiter //
DROP FUNCTION IF EXISTS avgscore;
Create Function avgscore (sn VARCHAR(45))
RETURNS FLOAT
reads sql data
BEGIN
	DECLARE avgsc FLOAT DEFAULT 0;
	SELECT avg(score) 
		FROM select_course
		WHERE sno = sn
		INTO avgsc;
	RETURN avgsc;
END //
Delimiter ;