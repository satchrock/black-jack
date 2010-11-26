
public class Crupier extends JugadorCartas {
	
	Crupier(String n, int m){
		super(n,m);
	}
	
	public int pensar(Mesa m){
		//Estrategia de crupier...
		//decide si dar vuelta y plantarse o dar vuelta y pedir carta.
		darVuelta();
		if(cuenta<17)
			do{
				recibirCarta(darCarta(m.getMaso()));
			}while(cuenta<17);	
		return 0;
	}
	
	public Naipe darCarta(Maso m){
		//saca una carta del maso.
		return m.sacar();
	}
	
	public void repartir(Jugador j, Maso m){
		//reparte: jugador, crupier(Dada vuelta), jugador , crupier.
		j.recibirCarta(darCarta(m));
		Naipe n=(Naipe)darCarta(m);
		n.setVisible(false);
		this.recibirCarta(n);
		j.recibirCarta(darCarta(m));
		this.recibirCarta(darCarta(m));
		
	}
	
	private void darVuelta(){
		//da vuelta su carta.
		for(Naipe n : misCartas){
			if(n.getVisible()==false){
				n.setVisible(true);
				cuenta+=n.getNum();
			}
		}
	}

}
