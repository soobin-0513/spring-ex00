USE spr1;

CREATE TABLE tal_tx_test1(
	name VARCHAR(5)
    
);
CREATE TABLE tbl_tx_test1(
	name VARCHAR(5)
    
);
INSERT INTO tbl_tx_test1 (name) VALUES ('abcde'); -- ok
INSERT INTO tbl_tx_test1 (name) VALUES ('abcdef'); -- fail

SELECT * FROM tbl_tx_test1; 
DELETE FROM tbl_tx_test1;


