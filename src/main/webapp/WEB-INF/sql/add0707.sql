USE spr1;

-- https://docs.spring.io/spring-security/site/docs/current/reference/html5/#persistent-login-remember-me-schema

create table persistent_logins (
    username varchar(64) not null,
    series varchar(64) primary key,
    token varchar(64) not null,
    last_used timestamp not null
);

desc persistent_logins; 

SELECT * FROM tbl_board;
SELECT * FROM tbl_member;

UPDATE tbl_board
SET writer = 'member';

UPDATE tbl_reply
SET replyer = 'member';

ALTER TABLE tbl_board
ADD FOREIGN KEY (writer) REFERENCES tbl_member(userid);

ALTER TABLE tbl_reply
ADD FOREIGN KEY (replyer) REFERENCES tbl_member(userid);