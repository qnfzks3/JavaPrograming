
-- 성적 테이블

create table sungjuk(
    sjno ing auto_increment,
    name varchar(10) not null,
    kor int,
    eng int,
    mat int,
    tot int,
    avg decimal(5,1),
    grd varchar(2),
    redate date default current_timestamp,
    primary key (sjno)

);