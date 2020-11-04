drop table if exists musicinfo;

/*==============================================================*/
/* Table: musicinfo                                             */
/*==============================================================*/
create table musicinfo 
(
   mid                  bigint                         not null,
   mname                varchar(255)                   null,
   msinger              varchar(255)                   null,
   mtype                varchar(255)                   null,
   constraint PK_MUSICINFO primary key clustered (mid)
);
