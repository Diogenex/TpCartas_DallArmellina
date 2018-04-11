package Vista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import Modelos.Jugador;
import Modelos.MazodeCartas;
import Modelos.Repartidor;

public class Main {
	
	public static void main(String[ ] args) throws InterruptedException {
    	
    		MazodeCartas baraja = new MazodeCartas();
    		Repartidor NuevoRepartidor = new Repartidor(baraja,1);
    		Jugador j1 = new Jugador("Lea", NuevoRepartidor);
    		Jugador j2 = new Jugador("Tincho", NuevoRepartidor);
    		Jugador j3 = new Jugador("Rama", NuevoRepartidor);
    		Jugador j4= new Jugador("German", NuevoRepartidor);
    		
    		//observer
    		j1.addObserver(NuevoRepartidor);
    		j2.addObserver(NuevoRepartidor);
    		j3.addObserver(NuevoRepartidor);
    		j4.addObserver(NuevoRepartidor);
    		
    		Thread player1 = new Thread(j1);
    		Thread player2 = new Thread(j2);
    		Thread player3 = new Thread(j3);
    		Thread player4 = new Thread(j4);
    		
    		player1.start();
    		player3.start();
    		player2.start();    
    		player4.start();   
    		
    		player1.join();
    		player2.join();
    		player3.join();
    		player4.join();
    		
    		System.out.println("El ganador de la partida es "+ NuevoRepartidor.getGanador() + " con: " + NuevoRepartidor.getCantGanadora() + " cartas.");
    		
    		//Primero se obtiene el driver de conexion
            try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				//Se genera la conexion
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/tp_cartas?user=root&password=");
	            //Como hacer una query sin parametros no es conveniente
	          //con parametros
	            int idRepartidor = NuevoRepartidor.getId();
	            String nombreJugador = NuevoRepartidor.getGanador().getNombre();
	            int cantCartas = NuevoRepartidor.getCantGanadora();
	            PreparedStatement ps = conn.prepareStatement("insert into partida(id_repartidor, nombre_jugador, cant_cartas) values (?,?,?)");//mardar cosas con los parametros
	            ps.setInt(1, idRepartidor);
	            ps.setString(2, nombreJugador);
	            ps.setInt(3, cantCartas);
	            ps.execute();
	            
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            
            
    } //Fin del main
} //Fin de la clase