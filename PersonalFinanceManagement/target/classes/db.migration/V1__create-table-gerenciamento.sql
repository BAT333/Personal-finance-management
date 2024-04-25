create table tbgerenciamento(
    id bigint auto_increment primary key not null,
    valor decimal(10,2) not null,
    categoria varchar (100) not null,
    data date not null,
    descricao varchar (100) not null,
    ativo tinyint not null
);