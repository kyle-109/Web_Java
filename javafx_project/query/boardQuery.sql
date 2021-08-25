create table javafx.board(
	
    bno int primary key auto_increment,
    btitle varchar(1000) not null,
    bcontents varchar(10000) not null,
    bwriter varchar(100) not null,
    bdate datetime default current_timestamp not null,
    bcount int 
)