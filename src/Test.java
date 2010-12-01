import junit.framework.*;



public class Test extends TestCase {
	private Mesa mesaTest;
	/*protected void setup(){
		mesaTest = new Mesa("jugador");
	}*/
	
	
	/**
	 * Prueba de instanciacion de objetos.
	 */
	public void testObjetos(){
		mesaTest = new Mesa("jugadorTest");
		assertNotNull(mesaTest);//mesa
		assertNotNull(mesaTest.getMaso());//maso
		assertNotNull(mesaTest.getJugador());//jugador
		assertNotNull(mesaTest.getCrupier());//crupier
		
	}
	
	/**
	 * Probando si el crupier reparte bien las cartas. 
	 */
	public void testc_repartir(){
		mesaTest = new Mesa("jugadorTest");
		mesaTest.c_repartir();
		assertEquals(2,mesaTest.j_getCantCartas());
		assertEquals(2,mesaTest.c_getCantCartas());
	}
	
	/**
	 * Apuestas.
	 */
	public void testApuesta(){
		mesaTest = new Mesa("jugadorTest");
		mesaTest.j_apostar(600);
		assertEquals(600,mesaTest.getApuesta());
		mesaTest.j_apostar(10);
		assertEquals(610,mesaTest.getApuesta());
	}
	
	
	public void testLogica(){
		mesaTest = new Mesa("jugadorTest");
		
		mesaTest.c_repartir();
		
	}
	
	protected void tearDown(){
		System.out.println("Test finalizado.");
	}
	
	/*public static TestSuite suite(){
		return new TestSuite(Test.class);
	}
	
	public static void main(String[] args){
		junit.textui.TestRunner(suite());
	}*/
}
