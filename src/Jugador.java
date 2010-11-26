
import javax.swing.JOptionPane;

public class Jugador extends JugadorCartas {
	
	Jugador(String n, int m){
		super(n,m);
	}
	
	public int pensar(Mesa m){//solo por consola...
		//El usuario(Jugador) decide que hace: pedir carta o plantarse.
		//solo por consola ya que con la GUI lista sería de otra forma.
		String[] opciones ={"Pedir Carta","Plantarse"};
		int ent;
		ent=JOptionPane.showOptionDialog(null,"Que desea hacer?",nombre,0,3,null,opciones,0);
		
		if(ent==1)plantado=true;
		return ent;
		
	}
	
	public void pedirCarta(Naipe c){
		recibirCarta(c);
	}
	
	public void plantarse(){
		plantado=true;
	}
	
	public void apostar(long ap){
		if(monto-ap>=0){
			monto-=ap;
		}
	}
}
