create table javafx.member(

	m_id varchar(100) primary key , 
    m_password varchar(100) not null,
    m_name varchar(100) not null,
    m_email varchar(100) not null,
    m_phone varchar(100) not null,
    m_point int not null
)