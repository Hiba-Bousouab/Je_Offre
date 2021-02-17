

drop table if exists Cities;

drop table if exists Images;

drop table if exists Messages;

drop table if exists Offer;

drop table if exists Ratings;

drop table if exists User;

create table Cities
(
    city_id              int not null,
    city_name            varchar(254),
    primary key (city_id)
);


create table Images
(
    imageId              bigint not null AUTO_INCREMENT,
    offerId              bigint not null,
    pathToImage          varchar(254),
    primary key (imageId)
);


create table Messages
(
    sender_id_user       varchar(254) not null,
    idUser               varchar(254) not null,
    id_message           bigint not null AUTO_INCREMENT,
    dateMessage          datetime,
    message              varchar(254),
    primary key (id_message)
);


create table Offer
(
    offerId              bigint not null AUTO_INCREMENT,
    title                varchar(254),
    description          varchar(254),
    date                 datetime,
    city                 smallint,
    primary key (offerId)
);
create table OffersArchive
(
    offerId2              bigint not null AUTO_INCREMENT,
    title2                varchar(254),
    description2          varchar(254),
    date_archive                 datetime,
    city2                 smallint,
    primary key (offerId2)
);


/*==============================================================*/
/* Table : Ratings                                              */
/*==============================================================*/
create table Ratings
(
    idUser               varchar(254) not null,
    offerId              bigint not null,
    rate                 int,
    primary key (idUser, offerId)
);

/*==============================================================*/
/* Table : User                                                 */
/*==============================================================*/
create table User
(
    idUser               varchar(254) not null,
    offerId              bigint not null,
    firstName            varchar(254),
    lastName             varchar(254),
    primary key (idUser),
    key AK_Identifiant_1 (idUser)
);

alter table Images add constraint FK_illustrate foreign key (offerId)
    references Offer (offerId) on delete restrict on update restrict;

alter table Messages add constraint FK_contact foreign key (idUser)
    references User (idUser) on delete restrict on update restrict;

alter table Messages add constraint FK_contact2 foreign key (sender_id_user)
    references User (idUser) on delete restrict on update restrict;

alter table Ratings add constraint FK_evaluating foreign key (offerId)
    references Offer (offerId) on delete restrict on update restrict;

alter table Ratings add constraint FK_evaluating2 foreign key (idUser)
    references User (idUser) on delete restrict on update restrict;

alter table User add constraint FK_offering foreign key (offerId)
    references Offer (offerId) on delete restrict on update restrict;

