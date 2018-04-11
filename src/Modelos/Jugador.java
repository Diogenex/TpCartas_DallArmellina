package Modelos;

import java.util.ArrayList;
import java.util.Observable;

public class Jugador extends Observable implements Runnable{
	
	private String Nombre;
	private Repartidor dealer;
	private ArrayList<Cartas> cartasRecibidas;
	
	
	 public Jugador(String Nombre, Repartidor dealer)
	 {
		this.Nombre = Nombre;
		this.dealer = dealer;
		this.cartasRecibidas = new ArrayList<Cartas>();
	 }
	 
	 	 
	 public String getNombre()
	 {
		 return this.Nombre;
	 }
	 
	 public ArrayList<Cartas> getCartasRecibidas()
	 {
		 return this.cartasRecibidas;
	 }
	 
	 
	@Override
	public void run() 
	{
		while(!this.dealer.getCartasRestantes().isEmpty())
		{	
		try {
			Cartas entregada = this.dealer.tomarCarta();
			this.cartasRecibidas.add(entregada);
			setChanged();
		    //Notificamos a los observadores y le enviamos el nuevo valor
		    notifyObservers(entregada);
		    //notifyObservers(); Este metodo solo notifica que hubo cambios en el objeto	
				

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		}
		
		dealer.calcularPuntaje(this);
	}


	@Override
	public String toString() {
		return "El jugador: " + Nombre;
	}

}
