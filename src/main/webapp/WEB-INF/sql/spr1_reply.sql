USE spr1;

CREATE TABLE tbl_reply(
	rno INT PRIMARY KEY AUTO_INCREMENT,
    bno INT NOT NULL,
    reply VARCHAR(512) NOT NULL,
    replyer VARCHAR(50) NOT NULL,
    replyDate TIMESTAMP DEFAULT NOW(),
	updateDate TIMESTAMP DEFAULT NOW(),
    FOREIGN KEY (bno) REFERENCES tbl_board(bno)
);

SELECT * FROM tbl_board
ORDER BY bno DESC;
SELECT * FROM tbl_reply
ORDER BY rno DESC;

-- 댓글이 있는 게시물 조회 
SELECT
DISTINCT(b.bno)
FROM tbl_board b JOIN tbl_reply r ON b.bno = r.bno;


SELECT b.bno, 
b.title, 
b.content, 
b.writer, 
b.regdate, 
b.updatedate,
count(r.rno)
FROM tbl_board b LEFT JOIN tbl_reply r ON b.bno = r.bno
GROUP BY b.bno
ORDER BY b.bno DESC;
