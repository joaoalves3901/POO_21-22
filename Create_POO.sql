create database projeto;
use projeto;

create table pessoa (pessoa_id int not null auto_increment,
					 pessoa_nome varchar(60) not null,
					 pessoa_morada varchar(60), 
					 pessoa_dtnasc date not null,
					 pessoa_genero char(1) not null,
					 pessoa_email varchar(30),
                     pessoa_pass varchar(30),	
                     pessoa_tlm int,
					 primary key (pessoa_id));
                     
create table admin (admin_id int not null auto_increment,
					pessoa_id int not null,
                    primary key (admin_id));

create table monitor_insc (monitor_id int not null auto_increment,
							pessoa_id int not null,
							cv boolean,
                            primary key (monitor_id));

create table campo (campo_id int not null auto_increment,
					campo_nome varchar(30),
                    campo_disc VARCHAR (1000),
                    campo_lat double, 
                    campo_long double,
                    campo_cap int,
                    primary key (campo_id));
                    
create table semana(semana_id int not null auto_increment,
					semana_start date,
                    primary key (semana_id));
                    
create table campo_semana(semana_id int not null,
							monitor_id int not null,
							campo_id int not null);

create table ativ (ativ_id int not null auto_increment,
					ativ_nome varchar(30),
                    ativ_disc varchar (200),
                    primary key (ativ_id));

create table ativ_campo (ativ_id int not null,
						campo_id int not null);
                    
create table inscricao (inscricao_id int not null auto_increment,
						campo_id int not null,
						pessoa_id int not null,
                        semana_id int not null,
                        primary key (inscricao_id));
                        
create table centro_saude (centro_id int not null auto_increment,
							nome varchar (50),
                            centro_tlm int,
                            centro_morada VARCHAR(100),
                            centro_lat double,
                            centro_long double,
                            primary key (centro_id));
                        
    
# Chaves estrangeiras

alter table campo_semana add constraint campo_semana_fk_monitor_insc
			foreign key (monitor_id) references monitor_insc(monitor_id)
			ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table campo_semana add constraint campo_semana_fk_semana
			foreign key (semana_id) references semana(semana_id)
			ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table campo_semana add constraint campo_semana_fk_campo
			foreign key (campo_id) references campo(campo_id)
			ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table inscricao add constraint inscricao_fk_semana
			foreign key (semana_id) references semana(semana_id)
			ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table admin add constraint admin_fk_pessoa
			foreign key (pessoa_id) references pessoa(pessoa_id)
			ON DELETE NO ACTION ON UPDATE NO ACTION;


alter table monitor_insc add constraint monitor_insc_fk_pessoa
            foreign key (pessoa_id) references pessoa(pessoa_id)
			ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table ativ_campo add constraint ativ_campo_fk_campo
            foreign key (campo_id) references campo(campo_id) 
			ON DELETE NO ACTION ON UPDATE NO ACTION;
            
alter table ativ_campo add constraint ativ_campo_fk_ativ
            foreign key (ativ_id) references ativ(ativ_id) 
			ON DELETE NO ACTION ON UPDATE NO ACTION;
            
            
alter table inscricao add constraint inscricao_fk_campo
            foreign key (campo_id) references campo(campo_id) 
			ON DELETE NO ACTION ON UPDATE NO ACTION;   
            
alter table inscricao add constraint inscricao_fk_pessoa
            foreign key (pessoa_id) references pessoa(pessoa_id) 
			ON DELETE NO ACTION ON UPDATE NO ACTION;
						

						
		

                    
                    
			