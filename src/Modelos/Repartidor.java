package Modelos;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Repartidor implements Observer{
	
	private int id;
	private MazodeCartas maso;
	private Boolean ocupado  = false;
	private Jugador ganador;
	private int cantGanadora = 0;

	public Repartidor(MazodeCartas baraja, int id) 
	{
		this.maso = baraja;
		this.id = id;
	}

	public synchronized Cartas tomarCarta() throws InterruptedException
	{
		
		while(ocupado){
			wait();
		}
		
		ocupado = true;
		Cartas entregada = this.maso.sacar();
		ocupado = false;
		notifyAll();
		return entregada;
	}
	
	

	public synchronized void calcularPuntaje(Jugador jugador){
		
		 int cantjugador = jugador.getCartasRecibidas().size();
		 if (this.getCantGanadora() < cantjugador){
			 this.setGanador(jugador);
			 this.setCantGnadora(cantjugador); 
		 }
		 
			 
		 System.out.println( jugador.getNombre() + " tiene" + jugador.getCartasRecibidas());
		 int tamanio = jugador.getCartasRecibidas().size();
		 System.out.println("El número de cartas tomadas es de "+tamanio);
		 
	     notifyAll();
	 }
	
	
	public ArrayList<Cartas> getCartasRestantes()
	{
		return this.maso.getMaso();
	}
	
	public int getId()
	{
		return this.id;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
		System.out.println(arg0 + " tomó la carta: " + arg1);
		
	}
	
	public Jugador getGanador(){
		return this.ganador;
	}
	
	public void setGanador(Jugador ganador){
		this.ganador = ganador;
	}
	
	public int getCantGanadora(){
		return this.cantGanadora;
	}
	
	public void setCantGnadora(int cantidad){
		this.cantGanadora = cantidad; 
	}
	}
	
		
	




	
