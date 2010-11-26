
/**
 * Clase Naipe: representa un naipe de la baraja inglesa.
 * 
 * @author satchrock
 *
 */
public class Naipe {
	private int numero;
	private final String palo,nombre;
	private boolean visible;

	/**
	 * Constructor.
	 * 
	 * @param int numero de la carta.
	 * @param String palo.
	 * @param boolean visibilidad de la carta.
	 */
	Naipe(int num, String pal, boolean vis){
		palo=pal;
		visible=vis;
		switch(num){
			case 11:numero=10; nombre="J de "+pal;break;
			case 12:numero=10; nombre="Q de "+pal;break;
			case 13:numero=10; nombre="K de "+pal;break;
			case 14:numero=11; nombre="A de "+pal;break;
			default:numero=num; nombre=num+" de "+pal; break;
		}
		
	}
	
	/**
	 * 
	 * @return int numero.
	 */
	public int getNum(){
		return numero;
	}
	
	/**
	 * 
	 * @return String palo.
	 */
	public String getPalo(){
		return palo;
	}
	
	/**
	 * Metodo que determina si dos cartas son del mismo palo.
	 * 
	 * @param Naipe carta a comparar con la actual.
	 * 
	 * @return boolean
	 */
	public boolean igualPalo(Naipe n){
		if(n.getPalo()==palo)return true;
		else return false;
	}
	
	/**
	 * Metodo que determina si dos cartas tienen el mismo valor.
	 * 
	 * @param Naipe carta a comparar.
	 * @return boolean
	 */
	public boolean igualVal(Naipe n){
		if(n.getNum()==numero)return true;
		else return false;
	}
	
	/**
	 * Devuelve mayor entre carta actual y carta recibida como parametro. 
	 * 
	 * @param Naipe carta a comparar.
	 * @return Naipe mayor.
	 */
	public Naipe getMayor(Naipe n){
		if(n.getNum()>=numero)return n;
		else return this;
	}
	
	/**
	 * Cambia la visibilidad de la carta.
	 * 
	 * @param boolean visibilidad.
	 */
	public void setVisible(boolean v){
		visible=v;
	}
	
	/**
	 * Obtiene la visibilidad de la carta.
	 * 
	 * @return boolean (True si es visible)
	 */
	public boolean getVisible(){
		return visible;
	}
	
	/**
	 * Obtiene el nombre (numero + palo) de la carta.
	 * 
	 * @return String nombre.
	 */
	public String getNombre(){
		return nombre;
	}
	
	/**
	 * Cambia el valor de la carta 11 a 1.
	 * 
	 */
	public void cambiarAs(){
		if(numero==11)numero=1;
	}
	
}
