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

public class TJOption {
    
    public static byte leerByte(String msje){
    	while(true) {
    	try {	
    		return(Byte.parseByte(JOptionPane.showInputDialog(null,msje," [byte]",JOptionPane.QUESTION_MESSAGE)));
    	}catch (NumberFormatException e) {
    		imprimeError("Solo se admiten datos tipo byte");	
    	}
    	//finally {imprimePantalla("Por aqui pasa");}
    	}	
    }
    	
    	
	public static short leerShort(String msje){
		while(true) {
			try {	
				return(Short.parseShort(JOptionPane.showInputDialog(null,msje,"[short]",JOptionPane.QUESTION_MESSAGE)));
			}catch (NumberFormatException e) {
				imprimeError("Solo se admiten datos tipo short");	
			}
			//finally {imprimePantalla("Por aqui pasa");}
	    }
	 }
	
	
	
    public static int leerInt(String msje){
    	while(true) {
    		try {
    			return(Integer.parseInt(JOptionPane.showInputDialog(null,msje,"[int]",JOptionPane.QUESTION_MESSAGE)));
    		}catch (NumberFormatException e) {
    			imprimeError("Solo se admiten enteros positivos y negativos (Datos tipo int)");	
    		}
    		//finally {imprimePantalla("Por aqui pasa");}
    	}
    }
    
    
    public static long leerLong(String msje){
    	while(true) {
                try {
    			return(Long.parseLong(JOptionPane.showInputDialog(null,msje,"[long]",JOptionPane.QUESTION_MESSAGE)));
    		}catch (NumberFormatException e) {
    			imprimeError("Solo se admiten datos tipo String");	
    		}
    		//finally {imprimePantalla("Por aqui pasa");}
    	}
    }
    
    
    
    public static float leerFloat(String msje){
    	while(true) {
    		try {
    			return(Float.parseFloat(JOptionPane.showInputDialog(null,msje,"[float]",JOptionPane.QUESTION_MESSAGE)));
    		}catch (NumberFormatException e) {
    			imprimeError("Solo se admiten datos tipo float");	
    		}
    		//finally {imprimePantalla("Por aqui pasa");}
    	}
    }
    
    
    public static double leerDouble(String msje){
    	while(true) {
    		try {
    			return(Double.parseDouble(JOptionPane.showInputDialog(null,msje,"[double]",JOptionPane.QUESTION_MESSAGE)));
    		}catch (NumberFormatException e) {
    			imprimeError("Solo se admiten datos tipo double");	
    		}
    		//finally {imprimePantalla("Por aqui pasa");}
    	}
    }
    
    
    public static char leerChar(String msje){
    	while(true) {
    	    try {
    	    	return (JOptionPane.showInputDialog(null,msje,"Dato [char]",JOptionPane.INFORMATION_MESSAGE).charAt(0));
    	    }catch (NumberFormatException e) {
    	        imprimeError("Solo se admiten enteros positivos y negativos");	
    	    }
    	    //finally {imprimePantalla("Por aqui pasa");}
    	}
	}
    
    
	public static String leerString(String msje){
		while(true) {
    	    try {
    	    	return (JOptionPane.showInputDialog(null,msje,"Dato[String]",JOptionPane.INFORMATION_MESSAGE));
    	    }catch (NumberFormatException e) {
    	        imprimeError("Solo se admiten enteros positivos y negativos");	
    	    }
    	    //finally {imprimePantalla("Por aqui pasa");}
		}
	}
	
	
    public static void imprimePantalla(String msje){
        JOptionPane.showMessageDialog(null,msje, "Salida",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void imprimeError(String msje) {
		JOptionPane.showMessageDialog(null,msje,"Ërror!!!",JOptionPane.ERROR_MESSAGE);
	}
    
    public static int  seguirSino(){
            return JOptionPane.showConfirmDialog(null,"Deseas continuar","Capturando datos",  JOptionPane.YES_NO_OPTION);
	 }
    
    public static String  Carrera() {
		String valores[] = { "Ing. En Sistemas", "Ing. Informatica" };
		return ((String) JOptionPane.showInputDialog(null, "seleciona", "tu carrera",JOptionPane.QUESTION_MESSAGE, null,valores, valores[0]));
	}
    
    public static void panelScroll(String cad) {
        JTextArea areaSalida=new JTextArea(10,4);
        JScrollPane scroller=new JScrollPane(areaSalida);
        Font font = new Font("Arial", Font.ITALIC, 15);
        areaSalida.setFont(font);
        areaSalida.setForeground(Color.WHITE);
        areaSalida.setBackground(Color.DARK_GRAY);
        areaSalida.append("\n"+cad);
       JOptionPane.showMessageDialog(null,scroller,"Datos:",JOptionPane.PLAIN_MESSAGE);   
         
    }
    
    public static String despegable(String menu){
        
        String valores[]=menu.split(",");
        String res= (String)JOptionPane.showInputDialog(null,
                "M E N U ",
                "Selecciona opcion:"
                 , JOptionPane.QUESTION_MESSAGE,
                 null,valores,valores[0]);
        
        return (res);
}
    public static String boton(String menu){
    String valores[]=menu.split(",");
    int n;
    n=JOptionPane.showOptionDialog(null, "Selecciona el tipo de Torre ","Torre",JOptionPane.NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,null,valores,valores[0]);
    return (valores[n]);
    }
}