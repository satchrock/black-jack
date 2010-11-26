
import java.util.*;

public abstract class JugadorCartas {
	//Clase abstracta Jugador.
	protected String nombre;
	protected int cuenta;
	protected long monto;
	protected boolean plantado;
	protected Vector<Naipe> misCartas = new Vector<Naipe>(); 
	
	JugadorCartas(String nom, int mont){
		nombre=nom;
		cuenta=0;
		monto=mont;
		plantado=false;
	}
	
	public abstract int pensar(Mesa m);//metodo abstracto...
	
	public void recibirCarta(Naipe c){
		//recibe una carta y la guarda en misCartas sumando su valor a cuenta.
		misCartas.add(c);
		if(c.getVisible())cuenta+=c.getNum();
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public int getCuenta(){
		return cuenta;
	}
	
	public long getMonto(){
		return monto;
	}
	
	public boolean getPlantado(){
		return plantado;
	}
	
	public void actualizar(){
		//actualiza instancia de jugador.
		misCartas.clear();
		cuenta=0;
		plantado=false;
		
	}
	
	public int getCantCartas(){
		return misCartas.size();
	}
	
	public void mostrarCartas(){
		//muestra cartas que posee un jugador.Solo por consola...
		for(Naipe n : misCartas){
			if(!n.getVisible())
				System.out.print("XXXXX   ");
			else
				System.out.print(n.getNombre()+"   ");
		}
	}
	
	public Vector<Naipe> getCartas(){
		return misCartas;
	}
	
	public void setMonto(long m){
		monto+=m;
	}
}
