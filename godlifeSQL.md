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
	reaction_no BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '반응 번호',
	reaction_title VARCHAR(50) NOT NULL COMMENT '반응 이름',
	reaction_type CHAR(1) NOT NULL COMMENT '반응 타입',
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
	mapping_no BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '매핑 번호',
	reaction_no BIGINT UNSIGNED NOT NULL COMMENT '반응 번호',
	post_no BIGINT UNSIGNED NOT NULL COMMENT '게시글 번호',
	reply_no BIGINT UNSIGNED NOT NULL COMMENT '댓글 번호',
	reaction_writer VARCHAR(50) NOT NULL COMMENT '반응 작성자',
	ins_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '작성 시간',
	ins_user VARCHAR(50) NOT NULL COMMENT '작성자',
	del_timestamp TIMESTAMP NULL COMMENT '삭제 시간',
	del_user VARCHAR(50) NULL COMMENT '삭제자',
	FOREIGN KEY (reaction_no) REFERENCES t_reaction(reaction_no) ON UPDATE CASCADE ON DELETE RESTRICT,
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
