```
USE godlife;

CREATE TABLE godlife.t_board (
    board_no BIGINT unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '게시판 번호',
    board_title VARCHAR(50) NOT NULL COMMENT '게시판 이름',
    ins_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '작성 시간',
    ins_user VARCHAR(50) NOT NULL COMMENT '작성자',
    upd_timestamp TIMESTAMP NULL COMMENT '수정 시간',
    upd_user VARCHAR(50) NULL COMMENT '수정자',
    del_timestamp TIMESTAMP NULL COMMENT '삭제 시간',
    del_user VARCHAR(50) NULL COMMENT '삭제자'
);

CREATE TABLE godlife.t_post (
    post_no BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '게시글 번호',
    post_title VARCHAR(50) NOT NULL COMMENT '게시글 제목',
    post_contents LONGTEXT NOT NULL COMMENT '게시글 내용',
    post_writer VARCHAR(50) NOT NULL COMMENT '작성자',
    board_no BIGINT UNSIGNED NOT NULL,
    FOREIGN KEY (board_no) REFERENCES t_board (board_no) ON UPDATE CASCADE ON DELETE RESTRICT,
    ins_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '작성 시간',
    ins_user VARCHAR(50) NOT NULL COMMENT '작성자',
    upd_timestamp TIMESTAMP NULL COMMENT '수정 시간',
    upd_user VARCHAR(50) NULL COMMENT '수정자',
    del_timestamp TIMESTAMP NULL COMMENT '삭제 시간',
    del_user VARCHAR(50) NULL COMMENT '삭제자'
);

CREATE TABLE godlife.t_reaction (
    reaction_type CHAR(1) NOT NULL PRIMARY KEY COMMENT '반응 타입',
    reaction_title VARCHAR(50) NOT NULL COMMENT '반응 이름',
    ins_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '작성 시간',
    ins_user VARCHAR(50) NOT NULL COMMENT '작성자',
    del_timestamp TIMESTAMP NULL COMMENT '삭제 시간',
    del_user VARCHAR(50) NULL COMMENT '삭제자'
);

CREATE TABLE godlife.t_reply (
    reply_no BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '댓글  번호',
    reply_contents LONGTEXT NOT NULL COMMENT '댓글  내용',
    reply_writer VARCHAR(50) NOT NULL COMMENT '댓글 작성자',
    ins_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '작성 시간',
    ins_user VARCHAR(50) NOT NULL COMMENT '작성자',
    del_timestamp TIMESTAMP NULL COMMENT '삭제 시간',
    del_user VARCHAR(50) NULL COMMENT '삭제자'
);

CREATE TABLE godlife.t_reaction_mapping (
    mapping_no BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT '리액션맵핑 번호',
    reaction_type CHAR(1) NOT NULL COMMENT '반응 타입',
    post_no BIGINT UNSIGNED NULL COMMENT '게시글 번호',
    reply_no BIGINT UNSIGNED NULL COMMENT '댓글 번호',
    ins_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '작성 시간',
    ins_user VARCHAR(50) NOT NULL COMMENT '작성자',
    del_timestamp TIMESTAMP NULL COMMENT '삭제 시간',
    del_user VARCHAR(50) NULL COMMENT '삭제자',
    FOREIGN KEY (reaction_type) REFERENCES t_reaction(reaction_type) ON UPDATE CASCADE ON DELETE RESTRICT,
    FOREIGN KEY (post_no) REFERENCES t_post(post_no) ON UPDATE CASCADE ON DELETE RESTRICT,
    FOREIGN KEY (reply_no) REFERENCES t_reply(reply_no) ON UPDATE CASCADE ON DELETE RESTRICT
);


SHOW TABLES;

DROP TABLE godlife.t_reaction_mapping;
DROP TABLE godlife.t_reaction;
DROP TABLE godlife.t_reply;
DROP TABLE godlife.t_post;
DROP TABLE godlife.t_board;


CREATE user 'godlife-api' @'localhost' IDENTIFIED BY 'apiPW';
SHOW GRANTS FOR 'godlife-api' @'localhost';

-- 기본 게시판 Insert
INSERT INTO t_board (board_title, ins_timestamp, ins_user) VALUES ('느긋하게',NOW(), 'admin');
INSERT INTO t_board (board_title, ins_timestamp, ins_user) VALUES ('조화롭게', NOW(), 'admin');
INSERT INTO t_board (board_title, ins_timestamp, ins_user) VALUES ('활기차게', NOW(), 'admin');


-- 기본 반응 종류 Insert
INSERT INTO t_reaction (reaction_title, reaction_type, ins_timestamp, ins_user) VALUES ('좋아요','L', NOW(), 'admin');
INSERT INTO t_reaction (reaction_title, reaction_type, ins_timestamp, ins_user) VALUES ('응원해요','F', NOW(), 'admin');
INSERT INTO t_reaction (reaction_title, reaction_type, ins_timestamp, ins_user) VALUES ('재밌어요','I', NOW(), 'admin');
INSERT INTO t_reaction (reaction_title, reaction_type, ins_timestamp, ins_user) VALUES ('괜찮아요','O', NOW(), 'admin');

ALTER TABLE t_reply ADD COLUMN post_no BIGINT AFTER reply_no;

----
/** 24.02.04 ERD 변경사항 **/
1. t_reaction 테이블의 PK 인 reaction_no BIGINT 를 reaction_type CHAR(1) 로 변경. 
    -> t_reaction_mapping 과 t_reaction 테이블을 삭제하고 다시 만들어 주세요.
    -> 기본 반응 종류 Inser 쿼리를 다시 실행해 주세요. 

DROP TABLE godlife.t_reaction_mapping;
DROP TABLE godlife.t_reaction;


2. t_reaction_mapping 의 PK를 mapping_no -> reaction_type, post_no, reply_no, ins_user 로 변경하고 mapping_no 는 삭제함.
    -> t_reaction_mapping 테이블을 drop 하고 다시 생성해주던가, drop 하고 싶지 않다면 아래의 쿼리 실행
ALTER TABLE t_reaction_mapping CHANGE mapping_no mapping_no BIGINT unsigned;
ALTER TABLE t_reaction_mapping DROP PRIMARY KEY;
ALTER TABLE t_reaction_mapping ADD PRIMARY KEY (reaction_type, post_no, reply_no, ins_user);
ALTER TABLE t_reaction_mapping DROP COLUMN mapping_no;



/** 24.03.09 user 관련 테이블 sql문 추가 **/
/** 24.05.04 user 관련 t_member_authentification, t_auth_password PK를 user_no로 수정 **/
/** 24.05.04 user 관련 t_auth_cidi, t_auth_social_login, t_royalty_history, t_member_board PK명을 *_no 로 통일**/


USE godlife;
SELECT default_character_set_name, DEFAULT_COLLATION_NAME FROM information_schema.SCHEMATA 
WHERE schema_name = "godlife";

/** user 관련 테이블 drop SQL **/
DROP TABLE godlife.t_member_user;
DROP TABLE godlife.t_member_authentification;
DROP TABLE godlife.t_auth_cidi;
DROP TABLE godlife.t_auth_social_login;
DROP TABLE godlife.t_auth_password;
DROP TABLE godlife.t_royalty_history;
DROP TABLE godlife.t_grade;
DROP TABLE godlife.t_royalty_mapping;
DROP TABLE godlife.t_member_board;


/** user 관련 테이블 create SQL **/
CREATE TABLE godlife.t_member_user (
    user_no BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '회원 번호',
    user_name VARCHAR(50) NOT NULL COMMENT '회원 이름',
    login_type TINYINT unsigned NOT NULL DEFAULT 0 COMMENT '접속 종류',
    ins_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '가입 시간',
    upd_timestamp TIMESTAMP NULL COMMENT '변경 시간'
);

CREATE TABLE godlife.t_member_authentification (
    user_no BIGINT UNSIGNED NOT NULL PRIMARY KEY COMMENT '회원 번호',
    gather_agree TINYINT UNSIGNED NULL DEFAULT 0 COMMENT '개인정보 수집동의',
    cell_phone VARCHAR(50) NULL UNIQUE COMMENT '핸드폰 번호',
    email VARCHAR(50) NULL UNIQUE COMMENT '이메일',
    birthday VARCHAR(50) NULL COMMENT '생년월일',
    sex TINYINT UNSIGNED NULL COMMENT '성별',
    auth_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '본인 인증 시간',
    FOREIGN KEY (user_no) REFERENCES t_member_user(user_no) ON UPDATE CASCADE ON DELETE restrict
);

CREATE TABLE godlife.t_auth_cidi (
    cidi_no BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '고유 식별값',
    user_no BIGINT UNSIGNED NOT NULL COMMENT '회원 번호',
    ci VARCHAR(88) NOT NULL UNIQUE COMMENT 'ci',
    di VARCHAR(64) NOT NULL UNIQUE COMMENT 'di',
    FOREIGN KEY (user_no) REFERENCES t_member_user(user_no) ON UPDATE CASCADE ON DELETE restrict
);

CREATE TABLE godlife.t_auth_social_login (
    social_login_no BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '고유 식별 값',
    user_no BIGINT UNSIGNED NOT NULL COMMENT '회원 번호',
    social_code TINYINT UNSIGNED NOT NULL COMMENT '소셜 연동처',
    external_id VARCHAR(64) NOT NULL COMMENT '외부 아이디',
    access_token VARCHAR(256) NOT NULL COMMENT '접속 토큰',
    upd_timestamp TIMESTAMP NOT NULL COMMENT '갱신 시간',
    FOREIGN KEY (user_no) REFERENCES t_member_user(user_no) ON UPDATE CASCADE ON DELETE restrict
);

CREATE TABLE godlife.t_auth_password (
    user_no BIGINT UNSIGNED NOT NULL PRIMARY KEY COMMENT '회원 번호',
    salt VARCHAR(256) NOT NULL COMMENT 'hash 값',
    user_password VARCHAR(128) NOT NULL COMMENT '암호화',
    upd_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '변경 시간',
    FOREIGN KEY (user_no) REFERENCES t_member_user(user_no) ON UPDATE CASCADE ON DELETE restrict
);

CREATE TABLE godlife.t_royalty_history (
    history_no BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '기록 번호',
    user_no BIGINT UNSIGNED NOT NULL COMMENT '회원 번호',
    increase_royalty BIGINT NOT NULL COMMENT '로열티 증감',
    ins_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '기록 시간',
    FOREIGN KEY (user_no) REFERENCES t_member_user(user_no) ON UPDATE CASCADE ON DELETE restrict
);

CREATE TABLE godlife.t_grade (
    grade_no TINYINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '등급 번호',
    grade_name VARCHAR(50) NOT NULL COMMENT '등급 이름'
);

CREATE TABLE godlife.t_royalty_mapping (
    mapping_no BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '매핑 번호',
    user_no BIGINT UNSIGNED NOT NULL COMMENT '회원 번호',
    royalty_total BIGINT NOT NULL DEFAULT 0 COMMENT '충성도',
    upd_timestamp TIMESTAMP COMMENT '수정 시간',
    grade_no TINYINT UNSIGNED NOT NULL COMMENT '등급 번호',
    FOREIGN KEY (user_no) REFERENCES t_member_user(user_no) ON UPDATE CASCADE ON DELETE RESTRICT,
    FOREIGN KEY (grade_no) REFERENCES t_grade(grade_no) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE godlife.t_member_board(
    choice_board_no BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '게시판 선택',
    user_no BIGINT UNSIGNED NOT NULL COMMENT '회원 번호',
    board_no BIGINT UNSIGNED NOT NULL COMMENT '게시판 번호',
    FOREIGN KEY (user_no) REFERENCES t_member_user(user_no) ON UPDATE CASCADE ON DELETE RESTRICT,
    FOREIGN KEY (board_no) REFERENCES t_board(board_no) ON UPDATE CASCADE ON DELETE RESTRICT
);

SELECT * FROM t_member_user;
SELECT * FROM t_member_authentification;
SELECT * FROM t_auth_cidi;
SELECT * FROM t_auth_password;
SELECT * FROM t_auth_social_login;
SELECT * FROM t_grade;
SELECT * FROM t_royalty_history;
SELECT * FROM t_royalty_mapping;
SELECT * FROM t_member_board;

INSERT INTO t_grade (grade_name) VALUES ('Level1');
INSERT INTO t_grade (grade_name) VALUES ('Level2');
INSERT INTO t_grade (grade_name) VALUES ('Level3');
INSERT INTO t_grade (grade_name) VALUES ('Level4');
INSERT INTO t_grade (grade_name) VALUES ('Level5');
INSERT INTO t_grade (grade_name) VALUES ('Level6');
INSERT INTO t_grade (grade_name) VALUES ('Level7');
INSERT INTO t_grade (grade_name) VALUES ('Level8');
INSERT INTO t_grade (grade_name) VALUES ('Level9');
INSERT INTO t_grade (grade_name) VALUES ('Level10');

/** 24.03.25 컬럼명 오타 수정 sql문 추가(생성 sql문도 수정함) **/
ALTER TABLE t_royalty_mapping CHANGE royaty_total royalty_total BIGINT;
```
