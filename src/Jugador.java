
import javax.swing.JOptionPane;

/**
 * Clase descendiente de JugadorCartas. Representa al jugador comun.
 * @author satchrock
 *
 */
public class Jugador extends JugadorCartas {
	
	/**
	 * Constructor.
	 * 
	 * @param String nombre
	 * @param int monto
	 */
	Jugador(String n, int m){
		super(n,m);
	}
	
	/**
	 * Metodo que permite al jugador decidir alguna accion sobre el juego.
	 */
	public int pensar(Mesa m){
		String[] opciones ={"Pedir Carta","Plantarse"};
		int ent;
		ent=JOptionPane.showOptionDialog(null,"Que desea hacer?",nombre,0,3,null,opciones,0);
		
		if(ent==1)plantado=true;
		return ent;
		
	}
	
	/**
	 * Metodo invocado cuando el jugador decide pedir una carta.
	 * @param Naipe carta.
	 */
	public void pedirCarta(Naipe c){
		recibirCarta(c);
	}
	
	/**
	 * Metodo que permite plantarse en el juego.
	 */
	public void plantarse(){
		plantado=true;
	}
	
	/**
	 * Apuesta del jugador.
	 * @param ap
	 */
	public void apostar(long ap){
		if(monto-ap>=0){
			monto-=ap;
		}
	}
}
