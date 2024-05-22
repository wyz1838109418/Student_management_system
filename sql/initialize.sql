INSERT INTO student_management.student (sno, sname, sex, age, racial, picture, contact) 
VALUES 
('S001', '张三', '男', 20, '汉族', './sql/张三.jpg', '123456'),
('S002', '李四', '女', 21, '回族', './sql/李四.jpg', '234567'),
('S003', '王五', '男', 22, '满族', './sql/王五.jpg', '345678'),
('S004', '赵六', '女', 23, '汉族', './sql/赵六.jpg', '456789'),
('S005', '宋七', '男', 24, '汉族', './sql/宋七.jpg', '567890');

INSERT INTO student_management.course (cno, cname, ctime, cscore) 
VALUES 
('C001', '数据库', 50, 3),
('C002', '数字图像', 40, 4),
('C003', '自然语言处理', 30, 2),
('C004', '人工智能', 45, 3);

INSERT INTO student_management.select (sno, cno, score) 
VALUES 
('S001', 'C001', 98),
('S001', 'C003', 97),
('S001', 'C004', 96),
('S002', 'C002', 81),
('S002', 'C004', 60),
('S003', 'C001', 88),
('S004', 'C002', 89),
('S004', 'C003', 87);

INSERT INTO student_management.award (aname) 
VALUES 
('一等奖'),
('二等奖'),
('三等奖'),
('四等奖');

INSERT INTO student_management.punishment (pname) 
VALUES 
('一等罚'),
('二等罚'),
('三等罚'),
('四等罚');

INSERT INTO student_management.asituation (sno,aname) 
VALUES 
('S001','一等奖'),
('S002','二等奖');

INSERT INTO student_management.psituation (sno,pname) 
VALUES 
('S002','三等罚'),
('S004','二等罚');


