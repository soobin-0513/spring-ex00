USE spr1;

CREATE TABLE tbl_member(
	userid VARCHAR(50) PRIMARY KEY,
    userpw VARCHAR(100) NOT NULL,
    username VARCHAR(100) NOT NULL,
    regdate TIMESTAMP DEFAULT NOW(),
    updateDate TIMESTAMP DEFAULT NOW(),
    enabled TINYINT(1) DEFAULT 1
);

CREATE TABLE tbl_member_auth(
	id INT PRIMARY KEY AUTO_INCREMENT,
    userid VARCHAR(50) NOT NULL,
    auth  VARCHAR(50) NOT NULL,
    FOREIGN KEY(userid) REFERENCES tbl_member(userid)
);

SELECT * FROM tbl_member;
SELECT * FROM tbl_member_auth;

SELECT
			m.userid userid,
			m.userpw userpw,
			m.username username,
			m.enabled enabled,
			m.regdate regdate,
			m.updateDate updateDate,
			a.auth auth
		FROM 
			tbl_member m LEFT JOIN tbl_member_auth a ON m.userid = a.userid
		WHERE
			m.userid = 'admin';