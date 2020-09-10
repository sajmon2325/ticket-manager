create table change_ticket (id varchar(255) not null, closed_at datetime(6), created_at datetime(6), item_status varchar(255), updated_at datetime(6), change_id varchar(255), change_type varchar(255), description varchar(500), incident_solver_id varchar(255), user_id varchar(255), primary key (id)) engine=InnoDB;
create table incident (id varchar(255) not null, closed_at datetime(6), created_at datetime(6), item_status varchar(255), updated_at datetime(6), incident_id varchar(255), incident_type varchar(255), incident_solver_id varchar(255), user_id varchar(255), primary key (id)) engine=InnoDB;
create table incident_solver (id varchar(255) not null, incident_id varchar(255), password varchar(255) not null, user_name varchar(255) not null, primary key (id)) engine=InnoDB;
create table ticket (id varchar(255) not null, closed_at datetime(6), created_at datetime(6), item_status varchar(255), updated_at datetime(6), description varchar(500), ticket_id varchar(255), ticket_type varchar(255), incident_solver_id varchar(255), user_id varchar(255), primary key (id)) engine=InnoDB;
create table user (id varchar(255) not null, password varchar(255) not null, user_id varchar(255), user_name varchar(255) not null, user_type varchar(255), primary key (id)) engine=InnoDB;
alter table incident_solver add constraint UK_4i2lwv4hq8tprgscruef6uppy unique (password);
alter table incident_solver add constraint UK_fx9rde2gtbxs2r4ol3i4ucnhs unique (user_name);
alter table user add constraint UK_kiqfjabx9puw3p1eg7kily8kg unique (password);
alter table user add constraint UK_lqjrcobrh9jc8wpcar64q1bfh unique (user_name);
alter table change_ticket add constraint FKbf2i2xs2c8l569d8ntdu9pn24 foreign key (incident_solver_id) references incident_solver (id);
alter table change_ticket add constraint FKo4ip0q2lagkutdbl2c2ni2785 foreign key (user_id) references user (id);
alter table incident add constraint FK3hak6081ybd03085b6584cl2e foreign key (incident_solver_id) references incident_solver (id);
alter table incident add constraint FK8bqewpr8w6nc8leoue11rmuew foreign key (user_id) references user (id);
alter table ticket add constraint FK7ybcn4gb99vbrwia30hsw9yru foreign key (incident_solver_id) references incident_solver (id);
alter table ticket add constraint FKdvt57mcco3ogsosi97odw563o foreign key (user_id) references user (id);
