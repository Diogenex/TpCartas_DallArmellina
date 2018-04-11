create database tp_cartas;
use tp_cartas;

create table partida (
	 idPartida  int not null AUTO_INCREMENT,
     id_repartidor int,
	 nombre_jugador varchar(50),
     cant_cartas int,
     primary key (idPartida)
     ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
     
select * from partida;