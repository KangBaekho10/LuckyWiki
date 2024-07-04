CREATE TABLE wiki_page (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
                           title VARCHAR(200) NOT NULL,
                           content TEXT NOT NULL,
                           image TEXT,
                           reaction INT NOT NULL,
                           created_at TIMESTAMP NOT NULL,
                           updated_at TIMESTAMP NOT NULL,
                           tag TEXT,
                           views INT NOT NULL,
                           member_id BIGINT NOT NULL
);

CREATE TABLE member (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
                        email VARCHAR(100) NOT NULL UNIQUE,
                        name VARCHAR(20) NOT NULL UNIQUE,
                        password VARCHAR(64) NOT NULL,
                        role VARCHAR(20) NOT NULL
);

CREATE TABLE comment (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
                         content TEXT NOT NULL,
                         created_at TIMESTAMP NOT NULL,
                         updated_at TIMESTAMP NOT NULL,
                         vote BOOLEAN NOT NULL ,
                         debate_id BIGINT NOT NULL,
                         member_id BIGINT NOT NULL
);

CREATE TABLE debate (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
                        title TEXT NOT NULL,
                        content TEXT NOT NULL,
                        image TEXT,
                        created_at TIMESTAMP NOT NULL,
                        updated_at TIMESTAMP NOT NULL,
                        member_id BIGINT NOT NULL,
                        wiki_id BIGINT NOT NULL
);

CREATE TABLE wiki_history (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
                              column_type VARCHAR(20) NOT NULL,
                              before_content TEXT NOT NULL,
                              after_content TEXT NOT NULL,
                              author VARCHAR(20) NOT NULL,
                              created_at TIMESTAMP NOT NULL,
                              wiki_id BIGINT NOT NULL
);

CREATE TABLE reaction(
                         member_id BIGINT NOT NULL,
                         wiki_id   BIGINT NOT NULL
);

CREATE TABLE popular_word (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
                              search_word VARCHAR(30) NOT NULL,
                              search_count INT NOT NULL,
                              searched_at TIMESTAMP NOT NULL
);

ALTER TABLE wiki_page ADD CONSTRAINT fk_wiki_page_member_id
    FOREIGN KEY (member_id)
        REFERENCES member (id);

ALTER TABLE comment ADD CONSTRAINT fk_comment_member_id
    FOREIGN KEY (member_id)
        REFERENCES member (id);

ALTER TABLE debate ADD CONSTRAINT fk_debate_member_id
    FOREIGN KEY (member_id)
        REFERENCES member (id);

ALTER TABLE reaction ADD CONSTRAINT fk_reaction_member_id
    FOREIGN KEY (member_id)
        REFERENCES member (id);

ALTER TABLE comment ADD CONSTRAINT fk_comment_debate_id
    FOREIGN KEY (debate_id)
        REFERENCES debate (id);


ALTER TABLE debate ADD CONSTRAINT fk_debate_wiki_id
    FOREIGN KEY (wiki_id)
        REFERENCES wiki_page (id);


ALTER TABLE reaction ADD CONSTRAINT fk_reaction_wiki_id
    FOREIGN KEY (wiki_id)
        REFERENCES wiki_page (id);


ALTER TABLE wiki_history ADD CONSTRAINT fk_wiki_history_wiki_id
    FOREIGN KEY (wiki_id)
        REFERENCES wiki_page (id);