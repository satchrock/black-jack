import java.util.Vector;

/**
 * Clase Mesa: Contiene un jugador, Crupier y Maso de cartas.
 * 
 * 
 * @author satchrock
 *
 */
public class Mesa {
	//Clase mesa. Contene un jugador un crupier y un maso de cartas.
	private Jugador jugador;
	private Crupier crupier;
	private Maso maso;
	private String ganador;
	private long apuesta;//cantidad apostada por jugador.
	
	/**
	 * Default constructor.
	 * 
	 * @param String nomJugador
	 */
	Mesa(String nomJugador){
		String nomJug=nomJugador;
		jugador=new Jugador(nomJug,300);
		crupier =new Crupier("Crupier",2000);
		ganador="";
		apuesta=0;
		maso=new Maso();
	}
	
	
	/**
	 * 
	 */
	private void ganaCrupier(){
		ganador=crupier.getNombre();
		crupier.setMonto(apuesta);
	}
	
	/**
	 * 
	 */
	private void ganaJugador(){
		ganador=jugador.getNombre();
		jugador.setMonto(apuesta*2);
		crupier.setMonto(-(apuesta*2));
	}
	
	/**
	 * 
	 */
	private void empate(){
		ganador="EMPATE";
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
							empate();
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
						}else empate();
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
	
	//------------------
	//metodos de crupier.
	public int c_getCuenta(){
		return crupier.getCuenta();
	}
	public void c_repartir(){
		crupier.repartir(jugador,maso);
	}
	
	public void c_pensar(){
		crupier.pensar(this);
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
		jugador.apostar(ap);
		apuesta+=ap;
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
	//fin metodos de jugador
	//------------------
	
}
