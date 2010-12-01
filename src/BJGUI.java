import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.event.*;

import java.awt.Insets;

import java.util.Vector;


/**
 * Interfaz grafica del juego: Clase descendiente de JFrame.
 * 
 * @author satchrock
 *
 */
public class BJGUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static final String PATH_IMG = "./maso/", bj = "BLACK JACK   - apuesta: ";
	
	private Mesa mesa;
	
	private JPanel panelCartasCrup, panelCartasJug, panelBJ, panelJugador, panelCrupier;
	private JButton btnJugar, btnPlantar, btnPedir, btn5, btn10, btn25, btn50;
	private JLabel labelCrup, labelApuesta, labelNombreJug, labelMontoJug, labelCuentaJug;
	
	BJGUI(){
		super("Black Jack");
		setLayout(new GridBagLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		//
		String nombre = JOptionPane.showInputDialog(null,"Ingrese nombre");
		mesa = new Mesa(nombre);
		//--
		labelCrup = new JLabel("CRUPIER");
		labelApuesta = new JLabel(bj+Long.toString(mesa.getApuesta()));
		labelNombreJug = new JLabel("Nombre: "+nombre);
		labelMontoJug = new JLabel("Monto: "+Long.toString(mesa.j_getMonto()));
		labelCuentaJug = new JLabel("Cuenta: "+Integer.toOctalString(mesa.j_getCuenta()));
		//--
		btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(this);
		btnJugar.setActionCommand("jugar");
		//btnJugar.setEnabled(false);
		
		btnPlantar = new JButton("Plantarse");
		btnPlantar.addActionListener(this);
		btnPlantar.setActionCommand("plantar");
		btnPlantar.setEnabled(false);
		
		btnPedir = new JButton("Pedir Carta");
		btnPedir.addActionListener(this);
		btnPedir.setActionCommand("pedir");
		btnPedir.setEnabled(false);
		
		btn5 = new JButton("$5");
		btn5.addActionListener(this);
		btn5.setActionCommand("5");
		
		btn10 = new JButton("$10");
		btn10.addActionListener(this);
		btn10.setActionCommand("10");
		
		btn25 = new JButton("$25");
		btn25.addActionListener(this);
		btn25.setActionCommand("25");
		
		btn50 = new JButton("$50");
		btn50.addActionListener(this);
		btn50.setActionCommand("50");
		//--
		panelCartasCrup = new JPanel();
		panelCartasCrup.setLayout(new FlowLayout());
		
		
		panelCartasJug = new JPanel();
		panelCartasJug.setLayout(new FlowLayout());
		
		panelBJ = new JPanel();
		panelBJ.add(labelApuesta,BorderLayout.CENTER);
		
		panelCrupier = new JPanel();
		panelCrupier.add(labelCrup,BorderLayout.CENTER);
		
		//---
		panelJugador = new JPanel();
		panelJugador.setLayout(new GridBagLayout());
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 2;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(2,2,2,2);
		panelJugador.add(btn5,gbc);
		
		gbc.gridx = 1;
		panelJugador.add(btn10,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		panelJugador.add(btn25,gbc);
		
		gbc.gridx = 1;
		panelJugador.add(btn50,gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		panelJugador.add(btnJugar,gbc);
		
		gbc.gridy = 2;
		gbc.gridheight = 1;
		panelJugador.add(btnPedir,gbc);
		
		gbc.gridy = 3;
		panelJugador.add(btnPlantar,gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		gbc.anchor = GridBagConstraints.WEST;
		panelJugador.add(labelNombreJug);
		
		gbc.gridy = 2;
		gbc.gridheight = 1;
		panelJugador.add(labelMontoJug,gbc);
		
		gbc.gridy = 3;
		panelJugador.add(labelCuentaJug,gbc);
		
		//--
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(2,2,2,2);
		getContentPane().add(panelCrupier,gbc);
		
		gbc.gridy = 1;
		getContentPane().add(panelCartasCrup,gbc);
		
		gbc.gridy = 2;
		getContentPane().add(panelBJ,gbc);
		
		gbc.gridy = 3;
		getContentPane().add(panelCartasJug,gbc);
		
		gbc.gridy = 4;
		getContentPane().add(panelJugador,gbc);
		
		//--
		
		
		
	}
	
	private void iniciaComps(){
		btnJugar.setEnabled(true);
		btnPedir.setEnabled(false);
		btnPlantar.setEnabled(false);
		btn5.setEnabled(true);
		btn10.setEnabled(true);
		btn25.setEnabled(true);
		btn50.setEnabled(true);
	}
	
	public void iniciar(){
		pack();
		setSize(800,650);
		setResizable(false);
		setVisible(true);
		
	}
	
	private void setCartas(){
		panelCartasCrup.removeAll();
		panelCartasJug.removeAll();
		//panelCrupier.add(new JLabel(new ImageIcon("../maso/carta.gif")));
		Vector<Naipe> cj = mesa.j_getCartas(), cc = mesa.c_getCartas();
		JLabel imagenCarta;
		String pathAux = "";
		for(Naipe n : cc){
			if(!n.getVisible()){
				pathAux = PATH_IMG+"carta.gif";
				//JOptionPane.showMessageDialog(null, "esta dada vuelta");
			}else{
				pathAux = PATH_IMG+n.getNombre()+".gif";
				//JOptionPane.showMessageDialog(null, "NOO esta dada vuelta");
			}
			imagenCarta = new JLabel(new ImageIcon(pathAux));
			panelCartasCrup.add(imagenCarta);
		}
		
		for(Naipe n : cj){
			imagenCarta = new JLabel(new ImageIcon(PATH_IMG+n.getNombre()+".gif"));
			panelCartasJug.add(imagenCarta);
		}
	}
	
	private void actualizaPaneles(){
		labelApuesta.setText(bj+Long.toString(mesa.getApuesta()));
		labelMontoJug.setText("Monto: "+Long.toString(mesa.j_getMonto()));
		labelCuentaJug.setText("Cuenta: "+Integer.toString(mesa.j_getCuenta()));
		setCartas();
	}
	
	public void actionPerformed(ActionEvent e){
		String comando = e.getActionCommand();
		
		if(comando.equals("jugar")){
			if(mesa.getApuesta() == 0){
				JOptionPane.showMessageDialog(null,"Debe hacer una apuesta");
			}else{
				btnJugar.setEnabled(false);
				btn5.setEnabled(false);
				btn10.setEnabled(false);
				btn25.setEnabled(false);
				btn50.setEnabled(false);
				
				btnPedir.setEnabled(true);
				btnPlantar.setEnabled(true);
				
				mesa.c_repartir();
				mesa.revisaJuego();
				actualizaPaneles();
				
			}
			
		}
		
		if(comando.equals("pedir")){
			mesa.j_pedirCarta();
			actualizaPaneles();
		}
		
		if(comando.equals("plantar")){
			btnPedir.setEnabled(false);
			btnPlantar.setEnabled(false);
			mesa.j_plantarse();
			mesa.c_pensar();
			mesa.revisaJuego();
			actualizaPaneles();
			String[] opciones = {"Continuar","Terminar"};
			int resp = JOptionPane.showOptionDialog(null, "Ganador: "+mesa.getGanador(), "Resultado", 2, JOptionPane.OK_CANCEL_OPTION, null, opciones, opciones[0]);
			
			switch(resp){
			case 1:System.exit(0);break;
			default:{
				mesa.actualizarMesa();
				actualizaPaneles();
				iniciaComps();
			}break;
			}
			
			//mesa.actualizarMesa();
			//iniciaComps();
		}
		
		if(comando.equals("5")){
			mesa.j_apostar(5);
			actualizaPaneles();
		}
		
		if(comando.equals("10")){
			mesa.j_apostar(10);
			actualizaPaneles();
		}
		
		if(comando.equals("25")){
			mesa.j_apostar(25);
			actualizaPaneles();
		}
		
		if(comando.equals("50")){
			mesa.j_apostar(50);
			actualizaPaneles();
		}
		
	}
	
	
	
}
