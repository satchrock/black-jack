
public class Naipe {
	//Naipe inglés.
	private int numero;
	private final String palo,nombre;
	private boolean visible;

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
	
	public int getNum(){
		return numero;
	}
	
	public String getPalo(){
		return palo;
	}
	
	public boolean igualPalo(Naipe n){
		if(n.getPalo()==palo)return true;
		else return false;
	}
	
	public boolean igualVal(Naipe n){
		if(n.getNum()==numero)return true;
		else return false;
	}
	
	public Naipe getMayor(Naipe n){
		if(n.getNum()>=numero)return n;
		else return this;
	}
	
	public void setVisible(boolean v){
		visible=v;
	}
	
	public boolean getVisible(){
		return visible;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void cambiarAs(){
		if(numero==11)numero=1;
	}
	
}
