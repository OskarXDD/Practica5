/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Menus {
	
	
	//Menu de opcion con ciclo
	public static void menuOpCi(String msje) {
		byte op;
		
		do {
			op=TJOption.leerByte(msje);
			
			switch(op) {
			case 1: System.out.print("Hola\n");break;			
			case 2: System.out.print("Mondongo\n");break;
			case 3: op=3;break;
			
			default : System.out.println("Opcion no valida");
			}
			}while(op!=3);
		}	
			
	//desplegable modificable
	public static String desplegable(String menu) {
		
		String valores[]=menu.split(",");
		String res= (String)JOptionPane.showInputDialog(null,"M E N U"," Selecciona opcion:",JOptionPane.QUESTION_MESSAGE,null,valores,valores[0]);
		
		return(res);
		}
	
	
	//desplegable con agregar imprimir y salir
    public static String desplegable2() {
		
		String valores[]= {"Agregar","Imprimir","Salir"};
		String res= (String)JOptionPane.showInputDialog(null,"M E N U"," Selecciona opcion:",JOptionPane.QUESTION_MESSAGE,null,valores,valores[0]);
		
		return(res);
		}
	
	public static void menu2(String menu){
		
	String sel;
	
	do {
	sel=desplegable(menu);
	
	switch(sel){
	case "Agregar":;break;     
	case "Imprimir":;break;
	case "Salir":;break;
	 }
	
	}while(!sel.equalsIgnoreCase("Salir"));
	
	}
	
	//creacion de botones 

	public static String boton(String menu) {
		
		String valores[]=menu.split(",");
		int  n;
		
		n = JOptionPane.showOptionDialog(null," SELECCIONA  DANDO CLICK ", " M E N U",JOptionPane.NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,valores,valores[0]);
		
		return ( valores[n]);
		}
	
	public static void menu3(String menu){  
	
	String sel="";
	
	do {
	sel=boton(menu);
	switch(sel){
	case "Agregar":    ;break;     
	case "Imprimir":  ;break;
	case "Salir":      ; break;
	  }//switch
	  }while(!sel.equalsIgnoreCase("Salir"));
	}
	
	public static void panelScroll(String cad){
	    JTextArea areaSalida=new JTextArea(20,14);
	    JScrollPane scroller=new JScrollPane(areaSalida);
	    Font font = new Font ("Arial",Font.ITALIC,15);
	    areaSalida.setFont(font);
	    areaSalida.setForeground(Color.WHITE);
	    areaSalida.setBackground(Color.DARK_GRAY);
	    areaSalida.append("\n"+cad);
	    JOptionPane.showMessageDialog(null, scroller,"Datos:",JOptionPane.PLAIN_MESSAGE);
	    
	}

}