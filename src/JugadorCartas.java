import java.util.Vector;

/**
 * Clase abstracta que representa un Jugador de Cartas.
 * @author satchrock
 *
 */
public abstract class JugadorCartas {

	protected String nombre;
	protected int cuenta;
	protected long monto;
	protected boolean plantado;
	protected Vector<Naipe> misCartas = new Vector<Naipe>(); 
	
	/**
	 * Constructor.
	 * 
	 * @param String nombre del jugador.
	 * @param int monto del que dispone el jugador.
	 */
	JugadorCartas(String nom, int mont){
		nombre=nom;
		cuenta=0;
		monto=mont;
		plantado=false;
	}
	
	/**
	 * Metodo abstracto pensar.
	 * 
	 * @param Mesa instancia de la mesa en la que juega el jugador.
	 * @return int 
	 */
	public abstract int pensar(Maso m);
	
	/**
	 * El jugador recibe una carta pasada como parametro.
	 * Suma su valor al atributo cuenta.
	 * @param Naipe carta.
	 */
	public void recibirCarta(Naipe c){
		misCartas.add(c);
		if(c.getVisible())cuenta+=c.getNum();
	}
	
	/**
	 * 
	 * @return String nombre del jugador.
	 */
	public String getNombre(){
		return nombre;
	}
	
	/**
	 * 
	 * @return int cuenta (segun blackjack)
	 */
	public int getCuenta(){
		return cuenta;
	}
	
	/**
	 * 
	 * @return long monto actual del jugador.
	 */
	public long getMonto(){
		return monto;
	}
	
	/**
	 * Metodo para saber si el jugador esta plantado en el juego.
	 * 
	 * @return boolean
	 */
	public boolean getPlantado(){
		return plantado;
	}
	
	/**
	 * Actualiza el estado del jugador.
	 */
	public void actualizar(){
		misCartas.clear();
		cuenta=0;
		plantado=false;
		
	}
	
	/**
	 * Metodo para saber cuantas cartas tiene el jugador.
	 * @return int Cantidad de cartas.
	 */
	public int getCantCartas(){
		return misCartas.size();
	}
	
	/**
	 * Metodo para mostrar las cartas del jugador.
	 * Solo en modo texto.
	 */
	public void mostrarCartas(){
		for(Naipe n : misCartas){
			if(!n.getVisible())
				System.out.print("XXXXX   ");
			else
				System.out.print(n.getNombre()+"   ");
		}
	}
	
	/**
	 * Metodo para obtener las cartas del jugador.
	 * @return
	 */
	public Vector<Naipe> getCartas(){
		return misCartas;
	}
	
	/**
	 * Metodo que suma el parametro recibido al monto actual del jugador.
	 * @param long monto.
	 */
	public void setMonto(long m){
		monto+=m;
	}
}
