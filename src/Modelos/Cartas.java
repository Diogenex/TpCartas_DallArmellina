package Modelos;

public class Cartas {

    private int valor; //Valor de la Carta (1,2,3,4,5,etc)
    private String figura; //figura de la Carta Espada,basto, et

    //Constructor de la clase
    public Cartas( int cardValor, String cardFigura ){
        this.valor = cardValor; //Inicializa el valor de la carta
        this.figura = cardFigura; //Inicializa la figura de la carta
    }

   

	//Retorna un String del valor y figura de la carta
    public String toString(){
        return this.valor + " de " + this.figura + "\n";
    }
} //Fin de la Clase Cartas
