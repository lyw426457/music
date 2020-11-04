drop table if exists userinfo;

/*==============================================================*/
/* Table: userinfo                                              */
/*==============================================================*/
create table userinfo 
(
   id                   varchar(255)                   not null,
   username             varchar(255)                   null,
   userpwd              varchar(255)                   null,
   nickname             varchar(255)                   null,
   bbirth               date                           null,
   signature            varchar(255)                   null,
   constraint PK_USERINFO primary key clustered (id)
);
