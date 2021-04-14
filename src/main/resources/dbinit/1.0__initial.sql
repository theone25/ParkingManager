-- apply changes
create table adresse (
  id_adresse                    integer auto_increment not null,
  ville                         varchar(255) not null,
  adresse                       varchar(255) not null,
  pays                          varchar(255) not null,
  constraint pk_adresse primary key (id_adresse)
);

create table parking (
  id_parking                    integer auto_increment not null,
  nom                           varchar(255) not null,
  tarif_horaire                 float not null,
  capacite                      integer not null,
  constraint pk_parking primary key (id_parking)
);

create table place (
  id_place                      integer auto_increment not null,
  numero                        integer not null,
  status                        integer not null,
  constraint pk_place primary key (id_place)
);

create table role (
  id_role                       integer auto_increment not null,
  role                          varchar(255) not null,
  constraint pk_role primary key (id_role)
);

create table setting (
  id_setting                    integer auto_increment not null,
  id                            integer not null,
  constraint pk_setting primary key (id_setting)
);

create table ticket (
  id_ticket                     integer auto_increment not null,
  date_entree                   datetime not null,
  date_sortie                   datetime not null,
  constraint pk_ticket primary key (id_ticket)
);

create table utilisateur (
  id                            integer auto_increment not null,
  idrole                        integer,
  nom                           varchar(255) not null,
  prenom                        varchar(255) not null,
  email                         varchar(255) not null,
  password                      varchar(255) not null,
  image                         varchar(255),
  constraint pk_utilisateur primary key (id)
);

create table voiture (
  id_voiture                    integer auto_increment not null,
  matricule                     varchar(255) not null,
  ticket_payed                  tinyint(1) default 0 not null,
  constraint pk_voiture primary key (id_voiture)
);

create index ix_utilisateur_idrole on utilisateur (idrole);
alter table utilisateur add constraint fk_utilisateur_idrole foreign key (idrole) references role (id_role) on delete restrict on update restrict;

