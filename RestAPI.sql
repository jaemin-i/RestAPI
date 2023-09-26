#userinfo 테이블 생성
CREATE TABLE userinfo (
    seq INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(30) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    address1 VARCHAR(100) NOT NULL,
    address2 VARCHAR(50) NOT NULL,
    joindate DATETIME DEFAULT NOW()
);

#login 테이블 생성
CREATE TABLE login (
    content_seq INT NOT NULL,
    user_id VARCHAR(20) NOT NULL,
    user_pwd VARCHAR(250) NOT NULL,
    FOREIGN KEY (content_seq) REFERENCES userinfo(seq)
);

#board 테이블 생성 (외래 키 활성화)
CREATE TABLE board (
    bno INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    content TEXT NOT NULL,
    writer INT NOT NULL,
    regdate DATETIME DEFAULT NOW(),
    viewcnt INT DEFAULT 0,
    content_seq INT not null,
    FOREIGN KEY (content_seq) REFERENCES userinfo(seq) ON DELETE CASCADE
);

drop table board, login, userinfo;
