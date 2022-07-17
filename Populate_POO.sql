insert into pessoa (pessoa_nome, pessoa_morada, pessoa_dtnasc, pessoa_genero, pessoa_email,pessoa_pass,pessoa_tlm) values ('admin','Rua do Presepio N5',str_to_date('1995.01.01','%Y.%m.%d'),'M','admin@admin','admin',928340843);
 insert into pessoa (pessoa_nome, pessoa_morada, pessoa_dtnasc, pessoa_genero, pessoa_email,pessoa_pass,pessoa_tlm) values ('user','Rua do ouro N29',str_to_date('1991.11.16','%Y.%m.%d'),'M','user','user@user',928483934);  
insert into pessoa (pessoa_nome, pessoa_morada, pessoa_dtnasc, pessoa_genero, pessoa_email,pessoa_pass,pessoa_tlm) values ('Joaquim Pires Lopes','Rua do Presepio N5',str_to_date('1995.01.01','%Y.%m.%d'),'M','jpl@gmail.com','ihd2hwd2',928340843);  
insert into pessoa (pessoa_nome, pessoa_morada, pessoa_dtnasc, pessoa_genero, pessoa_email,pessoa_pass,pessoa_tlm) values ('Ana Maria Fonseca','Rua dos Sete Ceus N7',str_to_date('1997.03.03','%Y.%m.%d'),'F','ana@sapo.pt','jhh2jde',918240824);  
insert into pessoa (pessoa_nome, pessoa_morada, pessoa_dtnasc, pessoa_genero, pessoa_email,pessoa_pass,pessoa_tlm) values ('Paula Antunes','Rua Vasco da Gama N35',str_to_date('1996.07.06','%Y.%m.%d'),'F','	pantunes@sapo.pt','kjhbd2jhj2de', 923289238);  
insert into pessoa (pessoa_nome, pessoa_morada, pessoa_dtnasc, pessoa_genero, pessoa_email,pessoa_pass,pessoa_tlm) values ('Joana Ramalho Silva','Rua Fernando Pessoa N53',str_to_date('1984.09.23','%Y.%m.%d'),'F','juana@mac.com','oakjkaj',928323929);  
insert into pessoa (pessoa_nome, pessoa_morada, pessoa_dtnasc, pessoa_genero, pessoa_email,pessoa_pass,pessoa_tlm) values ('Rui Manuel Silva','Rua Gago Coutinho N1',str_to_date('1994.08.15','%Y.%m.%d'),'M','rms@gmail.com','hjwpwqo',938329382);  
insert into pessoa (pessoa_nome, pessoa_morada, pessoa_dtnasc, pessoa_genero, pessoa_email,pessoa_pass,pessoa_tlm) values ('João Paulo Santos','Rua do ouro N29',str_to_date('1991.11.16','%Y.%m.%d'),'M','jps@yahoo.com','jedjdede',928483934);  
insert into pessoa (pessoa_nome, pessoa_morada, pessoa_dtnasc, pessoa_genero, pessoa_email,pessoa_pass,pessoa_tlm) values ('Cristina Fernandes Lopes','Rua Paulo Seixo N29',str_to_date('1996.01.07','%Y.%m.%d'),'F','cfl@yahoo.com','jkjd3kjd',928384929);  
insert into pessoa (pessoa_nome, pessoa_morada, pessoa_dtnasc, pessoa_genero, pessoa_email,pessoa_pass,pessoa_tlm) values ('Miguel Pinto Leite','Rua Capitao Fausto N1',str_to_date('1994.01.07','%Y.%m.%d'),'M','mpl@zmail.com','dwjwdeoed',938291829);  
insert into pessoa (pessoa_nome, pessoa_morada, pessoa_dtnasc, pessoa_genero, pessoa_email,pessoa_pass,pessoa_tlm) values ('Francisco Costa Rosa','Rua da Liberdade',str_to_date('1998.02.16','%Y.%m.%d'),'M','fcr12@gmail.com','jdwdjwhde',918383829);  
insert into pessoa (pessoa_nome, pessoa_morada, pessoa_dtnasc, pessoa_genero, pessoa_email,pessoa_pass,pessoa_tlm) values ('Elsa Fialho Pinto','Rua Pedro Regouga N1',str_to_date('1999.10.29','%Y.%m.%d'),'F','elsafi@sapo.pt','jkjekeji1',938439283);  

insert into admin (pessoa_id) values (1);

insert into semana(semana_start) values (str_to_date('2022.05.18','%Y.%m.%d'));
insert into semana(semana_start) values (str_to_date('2022.06.11','%Y.%m.%d'));

insert into monitor_insc (pessoa_id, cv) values (1 , 1);
insert into monitor_insc (pessoa_id, cv) values (2 , 0);
insert into monitor_insc (pessoa_id, cv) values (3 , 1);
insert into monitor_insc (pessoa_id, cv) values (4 , 0);

insert into campo (campo_nome, campo_disc, campo_lat, campo_long, campo_cap) values ('Serra de Sintra','A Serra de Sintra situa-se entre a planície da terra Saloia e o mar, constituída por um maciço granítico de altitude mediana, com o seu ponto mais alto sito na Cruz Alta a 520 metros de altura.' ,38.79770117227494, -9.432511769793297, 40);
insert into campo (campo_nome, campo_disc, campo_lat, campo_long, campo_cap) values ('Serra da Arrábida',' A Serra da Arrábida, está integrada no Parque Natural da Arrábida, é constituída por terrenos acidentados com fortes níveis situados na margem norte do estuário do Rio Sado, no concelho de Setúbal, em Portugal, com o ponto mais alto a 501 metros de altitude e características peculiares de clima e flora.',38.48072858275548, -9.064469774830245, 30);

insert into inscricao (campo_id ,pessoa_id, semana_id) values (1 ,1, 2);
insert into inscricao (campo_id ,pessoa_id, semana_id) values (1 ,2, 1);

insert into ativ (ativ_nome, ativ_disc) values ('passeio', 'passeio pelo palácio da pena');
insert into ativ (ativ_nome, ativ_disc) values ('visita', 'Convento de Nossa Sra. da Arrábida');
insert into ativ (ativ_nome, ativ_disc) values ('Treasure hunt', 'Tresuare hunt serra de sintra');
insert into ativ (ativ_nome, ativ_disc) values ('visita histórica', 'Situada em plena Serra da Arrábida, uma visita à 7ª bataria é um excelente programa para quem quer explorar a região de Setúbal.');

insert into ativ_campo (ativ_id, campo_id) values (1,1);
insert into ativ_campo (ativ_id, campo_id) values (2,2);
insert into ativ_campo (ativ_id, campo_id) values (3,1);
insert into ativ_campo (ativ_id, campo_id) values (4,2);

INSERT INTO centro_saude (nome,centro_tlm,centro_morada, centro_lat, centro_long) VALUES ('USF Cais do Sodré',213405550,'Tv. Ribeira Nova 1', 38.70725188152147 , -9.145017836093594);
INSERT INTO centro_saude (nome,centro_tlm,centro_morada, centro_lat, centro_long) VALUES ('USF Areeiro',218471406,'Av. Afonso Costa 41', 38.739812839502854 , -9.126703363148232);
INSERT INTO centro_saude (nome,centro_tlm,centro_morada, centro_lat, centro_long) VALUES ('USF Rio de Mouro',219178110,'Av. Infante Dom Henrique 39',38.78756034338976 , -9.326965509159997);
INSERT INTO centro_saude (nome,centro_tlm,centro_morada, centro_lat, centro_long) VALUES ('USF Reynaldo dos Santos',219540114,'Av. D. Vicente Afonso Valente r/c', 38.86236494583346 , -9.068034986138166);
INSERT INTO centro_saude (nome,centro_tlm,centro_morada, centro_lat, centro_long) VALUES ('USF Martin Moniz',218843000,'Praça Martim Moniz 43B', 38.71620952837133 , -9.13686056020565);
INSERT INTO centro_saude (nome,centro_tlm,centro_morada, centro_lat, centro_long) VALUES ('USF Arco',213947310,'Travessa do Noronha 5A', 38.717831371766316 , -9.152927897789972);
