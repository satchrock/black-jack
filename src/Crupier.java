/**
 * Clase descendiente de JugadorCartas. Representa al crupier.
 * @author satchrock
 *
 */
public class Crupier extends JugadorCartas {
	
	/**
	 * Constructor.
	 * 
	 * @param String nombre
	 * @param int monto
	 */
	Crupier(String n, int m){
		super(n,m);
	}
	
	/**
	 * Estrategia del crupier:
	 * Da vuelta su carta No visible.
	 * Pide (saca) una carta mientras si cuenta sea menor a 17.
	 */
	public int pensar(Maso m){
		if(cuenta<17){
			do{
				recibirCarta(darCarta(m));
			}while(cuenta<17);
		}
		return 0;
	}
	
	/**
	 * Metodo que se invoca cuando algun jugador pide un carta.
	 * @param Maso maso de cartas.
	 * @return Naipe carta.
	 */
	public Naipe darCarta(Maso m){
		return m.sacar();
	}
	
	/**
	 * Reparticion inicial: jugador, crupier(No visible), jugador , crupier.
	 * @param Jugador jugador al que le reparte.
	 * @param Maso maso de cartas.
	 */
	public void repartir(Jugador j, Maso m){
		j.recibirCarta(darCarta(m));//reparte al jugador
		Naipe n=(Naipe)darCarta(m);//se saca su carta
		n.setVisible(false);//debe estar dada vuelta
		this.recibirCarta(n);//recibe la carta sacada y dada vuelta
		j.recibirCarta(darCarta(m));//reparte al jugador nuevamente
		this.recibirCarta(darCarta(m));//se reparte a si mismo
		
	}
	
	/**
	 * Da vuelta su carta.Visibilidad True.
	 */
	public void darVuelta(){
		
		for(Naipe n : misCartas){
			if(!n.getVisible()){
				n.setVisible(true);
				cuenta+=n.getNum();
			}
		}
	}


}
