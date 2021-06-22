CREATE DATABASE spr1;
use spr1;

-- 173 page 
CREATE TABLE tbl_board(
	bno INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    content VARCHAR(2000) NOT NULL,
    writer VARCHAR(50) NOT NULL,
    regdate TIMESTAMP DEFAULT NOW(),
    updatedate TIMESTAMP DEFAULT NOW()
    
    );
    
INSERT INTO tbl_board(title, content, writer)
VALUES ('테스트 제목', '테스트 내용', 'user00');
    
SELECT * FROM tbl_board;

-- 연습용 
CREATE TABLE tbl_test1 (
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    age INT NOT NULL
);

INSERT INTO tbl_test1 (name, age) VALUES ('jinmin',22);
INSERT INTO tbl_test1 (name, age) VALUES ('susu',33);
INSERT INTO tbl_test1 (name, age) VALUES ('rm',11);

SELECT * FROM tbl_test1;
-- 
-- org.zerock.domain.Test1VO (bean)
-- org.zerock.mapper.Test1Mapper (interface)
-- org.zerock.mapper.Test1Mapper.xml (xml)
-- Test1Tests

