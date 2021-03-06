import java.util.Vector;

/**
 * Clase Mesa: Contiene un jugador, Crupier y Maso de cartas.
 * 
 * 
 * @author satchrock
 *
 */
public class Mesa {
	private Jugador jugador;
	private Crupier crupier;
	private Maso maso;
	private String ganador;
	private long apuesta;//cantidad apostada por el/los jugador/es.
	
	/**
	 * Default constructor.
	 * 
	 * @param String nomJugador
	 */
	Mesa(String nomJugador){
		String nomJug = nomJugador;
		jugador = new Jugador(nomJug,300);
		crupier = new Crupier("Crupier",2000);
		ganador = "";
		apuesta = 0;
		maso = new Maso();
		maso.mezclar();
	}
	
	
	/**
	 * Si el crupier gana la mano.
	 */
	private void ganaCrupier(){
		ganador=crupier.getNombre();
		crupier.setMonto(apuesta);
	}
	
	/**
	 * Si el jugador gana la mano.
	 */
	private void ganaJugador(){
		ganador=jugador.getNombre();
		jugador.setMonto(apuesta*2);
		crupier.setMonto(-(apuesta*2));
	}
	
	
	/**
	 * Metodo revisaJuego: Verifica quien gana la mano actual.
	 * 
	 */
	public void revisaJuego(){
		int cuentaJugador,cuentaCrupier;
		
		cuentaJugador = jugador.getCuenta();
		cuentaCrupier = crupier.getCuenta();
		
		if(cuentaJugador==21 && jugador.getCantCartas()==2){
			ganaJugador();		
		}else{
			if(cuentaJugador<21 && cuentaCrupier<21){
				if(jugador.getPlantado()){
					if(cuentaJugador<cuentaCrupier){
						//Gana crupier.
						ganaCrupier();
					}else{
						if(cuentaJugador==cuentaCrupier){
							//empate
							ganaCrupier();
						}else{//gana el jugador
							ganaJugador();
						}
					}
				}
			}else{
					if((cuentaJugador!=21) && cuentaCrupier<=21){
						//=> gana crupier
						ganaCrupier();
					}else{
						if(cuentaJugador<=21 && (cuentaCrupier!=21)){
							ganaJugador();
						}else ganaCrupier();
					}		
			}
		}
	}//revisaJuego()
	
	
	/**
	 * Actualiza la mesa.
	 */
	public void actualizarMesa(){
		//Actualizacion de la mesa...
		maso=new Maso();
		maso.mezclar();
		apuesta=0;
		jugador.actualizar();
		crupier.actualizar();
	}
	
	public String getGanador(){
		return ganador;
	}
	
	public Maso getMaso(){
		return maso;
	}
	
	public long getApuesta(){
		return apuesta;
	}
	
	public void mezclarMaso(){
		maso.mezclar();
	}
	
	public Jugador getJugador(){
		return jugador;
	}
	
	public Crupier getCrupier(){
		return crupier;
	}
	
	//------------------
	//metodos de crupier.
	public int c_getCuenta(){
		return crupier.getCuenta();
	}
	public void c_repartir(){
		crupier.repartir(jugador,maso);
	}
	
	public void c_pensar(){
		crupier.pensar(maso);
	}
	
	public Naipe c_darCarta(){
		return crupier.darCarta(maso);
	}
	
	public int c_getCantCartas(){
		return crupier.getCantCartas();
	}
	
	public Vector<Naipe> c_getCartas(){
		return crupier.getCartas();
	}	
	
	public void c_darVuelta(){
		crupier.darVuelta();
	}
	//fin metodos de crupier.
	
	//------------------
	
	//metodos de jugador
	public String j_getNombre(){
		return jugador.getNombre();
	}
	
	public void j_pedirCarta(){
		jugador.recibirCarta(crupier.darCarta(maso));
	}
	
	public void j_plantarse(){
		jugador.plantarse();
	}
	
	public void j_apostar(long ap){
		if(jugador.getMonto()-ap >= 0){
			jugador.apostar(ap);
			apuesta+=ap;
		}
	}
	
	public long j_getMonto(){
		return jugador.getMonto();
	}
	
	public int j_getCuenta(){
		return jugador.getCuenta();
	}
	
	public int j_getCantCartas(){
		return jugador.getCantCartas();
	}
	
	public Vector<Naipe> j_getCartas(){
		return jugador.getCartas();
	}
	
	public void j_setMonto(long m){
		jugador.setMonto(m);
	}
	//fin metodos de jugador
	//------------------
	
}
