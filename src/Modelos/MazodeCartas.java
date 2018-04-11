package Modelos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

public class MazodeCartas extends Observable {

	public static String[] valor ={"Espada", "Basto", "Oro", "Copa"};
    private ArrayList<Cartas> cartas;

	    
	public MazodeCartas()
	{
	    this.cartas = new ArrayList<Cartas>();
	    for(String palo: valor)
	    	for(int i=1;i<=12;i++)
	    		cartas.add(new Cartas(i,palo));
	    this.barajar();
	}
	
	    
	public void barajar()
	{
	        Collections.shuffle(cartas);
	}
	    
	
	public String toString()
	{
		return cartas.toString();
	}
	    

	public Cartas sacar()
	{
	    Cartas entregada = cartas.get(0);
	    cartas.remove(0);
	    return entregada;
	    
	}
	       
	
	public ArrayList<Cartas> getMaso()
	{
		return this.cartas;
			
	}

} 

	   
	    

	  
	    
	

