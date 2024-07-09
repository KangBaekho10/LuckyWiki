# ![free-icon-billiard-ball-7190685 (1)](https://github.com/KangBaekho10/LuckyWiki/assets/166815465/7512aed3-d7e4-4109-ae75-7e946fe14d38) LuckyWiki

불특정 다수가 협업을 통해 직접 내용과 구조를 수정할 수 있는 위키 백과 구축

## ![free-icon-content-2211565 (1)](https://github.com/KangBaekho10/LuckyWiki/assets/166815465/ebf2b813-d195-4c2b-8b36-715daed486e0) 목차
- [요구 사항](#요구-사항)
- [Why?](#Why?)
- [기획 및 설계](#기획-및-설계)
- [시연 영상](#시연-영상)
- [협업 노션](https://assorted-buffalo-e03.notion.site/7-502e001708f9404ca794f1f9e5a2aadf?pvs=4)

## ![free-icon-needs-10695007](https://github.com/KangBaekho10/LuckyWiki/assets/166815465/d5130b74-311c-4c99-b90c-f8e7a9d173fc) 요구 사항

**사용자**
  > - 위키 백과 사이트의 회원가입 / 로그인 / 회원 삭제를 위한 `사용자`
  > - `사용자`의 권한은 `USER`와 `ADMIN`

**게시물**
  > - 위키 백과 사이트의 `게시물` CRUD
  > - `게시물` 생성 / 조회 / 수정은 `USER`와 `ADMIN`이 가능, 삭제는 `ADMIN`만 가능
>   - `사용자`는 게시물을 `좋아요` 기능을 통한 의사 표현
>   - 제목 / 태그를 통해 검색하고, Paging 처리를 통해 페이지 단위로 조회
>   - 시간별 조회수를 통해 인기 검색어를 조회
>   - Scheduler를 통해 24시간마다 Random으로 알찬 위키 게시물을 출력
  > - S3를 통한 이미지 삽입
  > - 태그 기능을 통해 간편한 분류
  > - 게시물 생성 / 수정 내역 조회

**토론**
  > - 위키 백과 사이트의 게시물을 수정하기 위한 `토론`
>   - `댓글`을 통해 사용자끼리 수정을 할지 말지 토론을 진행하고 투표로 최종 결정
  > - `토론` 생성 / 조회는 `USER`와 `ADMIN`이 가능, 수정 / 삭제는 `ADMIN`만 가능
  > - `댓글` 생성 / 조회 / 수정은 `USER`와 `ADMIN`이 가능, 삭제는 `ADMIN`만 가능

**검색 API**
  > - release-1.0.0-api-v1
>   - Cache가 적용되지 않은 검색 API
  > - release-2.0.0-api-v2
>   - Remote Cache가 적용된 검색 API

## ![dho](https://github.com/KangBaekho10/LuckyWiki/assets/166815465/29f75cb4-d1d8-4030-8dab-fe9756e749f3) Why?

Q. 검색 API에 Cache를 적용한 이유는? <br/>
> A. 검색 API는 종종 데이터베이스나 외부 서비스에서 데이터를 가져와야 한다. <br/>
다음의 작동 방식을 가지는 Cache를 사용하게 되면 응답 시간 단축, 서버 부하 감소, 실시간성 향상의 장점을 가진 API가 된다.<br/>
><br/>
> <작동 방식> <br>
>   ① 원본 데이터를 캐시 공간에 저장<br>
>   ② 데이터 요청 시 원본 데이터의 저장 공간보다 캐시 공간을 먼저 참조<br/>
>   ③ -1 존재하는 경우 빠르게 제공 (완료)<br/>
>   ③ -2 존재하지 않는 경우 원본 공간 참조 -> 원본 공간에서 데이터를 제공하며 해당 데이터를 캐시 공간에 저장 (완료)<br/>

## ![rlghlr](https://github.com/KangBaekho10/LuckyWiki/assets/166815465/d133d561-7cf5-4f5a-a736-cb48253705c4) 기획 및 설계

- 와이어 프레임
  
###### 메인 페이지<br/>
  
![20240702_172415](https://github.com/KangBaekho10/LuckyWiki/assets/166815465/f2eaa102-d179-4f2f-b733-1b5b8a774bf7)

###### 상세 페이지<br/>

![2](https://github.com/KangBaekho10/LuckyWiki/assets/166815465/cb3306a6-b5ad-415f-aec8-8a232f943577)

###### 토론 페이지<br/>

![3](https://github.com/KangBaekho10/LuckyWiki/assets/166815465/b67094ca-29df-47cf-b01c-13091bdfe149)

###### 로그인 페이지<br/>

![1 (1)](https://github.com/KangBaekho10/LuckyWiki/assets/166815465/827c7d8c-fd36-4545-a77a-a9dfde9a8cf4)

- ERD

![Untitled](https://github.com/KangBaekho10/LuckyWiki/assets/166815465/77500e86-307f-4753-a638-e31bcae02d1e)

- API 명세서

  [API 명세서](https://assorted-buffalo-e03.notion.site/e1ee39ad75484fb68a3140f8b8b76228?v=80d2f7b7ec81480fb672dcc0ad5693e4&pvs=4)

- DDL

``` SQL
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
    search_word VARCHAR(30) NOT NULL,
    searched_at TIMESTAMP NOT NULL
);

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
```

## ![dudtkd](https://github.com/KangBaekho10/LuckyWiki/assets/166815465/41b0d7fd-2086-4ca7-8592-6f41ee5ca4e4) 시연 영상

추가 예정

## ![ghksrudtjfwjd](https://github.com/KangBaekho10/LuckyWiki/assets/166815465/debe07f2-1467-4f66-b968-73dd3a2ea14c) 환경 설정<br>
![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white) 
![Jdk17](https://img.shields.io/badge/jdk17-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white"/)
![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)
![AWS](https://img.shields.io/badge/AWS-%23FF9900.svg?style=for-the-badge&logo=amazon-aws&logoColor=white)
![Apache](https://img.shields.io/badge/apache-%23D42029.svg?style=for-the-badge&logo=apache&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)
![Redis](https://img.shields.io/badge/redis-%23DD0031.svg?style=for-the-badge&logo=redis&logoColor=white)
