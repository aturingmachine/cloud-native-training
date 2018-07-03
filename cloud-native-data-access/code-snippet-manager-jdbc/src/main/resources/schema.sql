DROP TABLE IF EXISTS snippet;

CREATE TABLE snippet
(
    id varchar(36) NOT NULL,
    title varchar(200) NOT NULL,
    code varchar(500) DEFAULT NULL,
    created date NOT NULL,
    modified date NOT NULL,
    PRIMARY KEY (id)
);