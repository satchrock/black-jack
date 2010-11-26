
import java.util.Vector;

public class Maso {
	//clase Maso: El maso contiene 52 cartas.
	private final static int CANT_CARTAS=52;
	private Vector<Naipe> m =new Vector<Naipe>(CANT_CARTAS);
	
	Maso(){
		//crea Picas
		for(int i=2;i<15;i++){
			m.add(new Naipe(i,"PICA",true));
		}
		
		//crea Corazones
		for(int i=2;i<15;i++){
			m.add(new Naipe(i,"CORAZON",true));
		}
		
		//crea Diamantes
		for(int i=2;i<15;i++){
			m.add(new Naipe(i,"DIAMANTE",true));
		}
		
		//crea Treboles
		for(int i=2;i<15;i++){
			m.add(new Naipe(i,"TREBOL",true));
		}
	}//fin constructor
	
	public void mezclar(){
		//se mezclan las cartas del maso...
		int p1,p2;
		Naipe aux,aux2;
		for(int i=1;i<CANT_CARTAS;i++){
			do{
				p1=(int)(Math.random()*52);
				p2=(int)(Math.random()*52);
			}while(p1==p2);
			aux=m.elementAt(p1);
			aux2=m.elementAt(p2);
			m.set(p1, aux2);
			m.set(p2, aux);
		}
	}
	//-solo por consola...
	public void mostrarMaso(){
		for(Naipe n : m){
			System.out.println(n.getNombre());
		}
		System.out.println();
		System.out.println();
	}
	
	public Naipe sacar(){
		Naipe carta=null;
		if(!m.isEmpty()){
			carta= m.firstElement();
			m.remove(0);
		}
		return carta;
	}

}
