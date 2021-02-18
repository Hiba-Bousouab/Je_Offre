/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de création :  18/02/2021 03:21:12                      */
/*==============================================================*/


drop table if exists Images;

drop table if exists Messages;

drop table if exists Offer;

drop table if exists Ratings;

drop table if exists User;

drop table if exists favoritize;

/*==============================================================*/
/* Table : Images                                               */
/*==============================================================*/
create table Images
(
   imageId              bigint not null AUTO_INCREMENT,
   offerId              bigint not null,
   pathToImage          varchar(254),
   primary key (imageId)
);

/*==============================================================*/
/* Table : Messages                                             */
/*==============================================================*/
create table Messages
(
   sender_id_user       varchar(254) not null,
   idUser               varchar(254) not null,
   id_message           bigint not null AUTO_INCREMENT,
   dateMessage          timestamp,
   message              text,
   primary key (id_message)
);

/*==============================================================*/
/* Table : Offer                                                */
/*==============================================================*/
create table Offer
(
   offerId              bigint not null AUTO_INCREMENT,
   idUser               varchar(254),
   title                varchar(254),
   description          varchar(254),
   date                 timestamp,
   city                 smallint,
   category             smallint,
   primary key (offerId)
);

/*==============================================================*/
/* Table : Ratings                                              */
/*==============================================================*/
create table Ratings
(
   idUser               varchar(254) not null,
   offerId              bigint not null,
   rate                 char(1),
   primary key (idUser, offerId)
);

/*==============================================================*/
/* Table : User                                                 */
/*==============================================================*/
create table User
(
   idUser               varchar(254) not null,
   firstName            varchar(254),
   lastName             varchar(254),
   primary key (idUser),
   key AK_Identifiant_1 (idUser)
);

/*==============================================================*/
/* Table : favoritize                                           */
/*==============================================================*/
create table favoritize
(
   offerId              bigint not null,
   idUser               varchar(254) not null,
   primary key (offerId, idUser)
);

