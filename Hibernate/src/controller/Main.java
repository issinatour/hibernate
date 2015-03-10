package controller;

import java.awt.Color;
import java.awt.Font;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.ColorUIResource;

import clases.HibernateHelper;

public class Main {
	
	 public static void main(String[] args) {
		 try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); 
			UIManager.getLookAndFeelDefaults().put("Panel.background", new Color(245, 245, 245));
			UIManager.getLookAndFeelDefaults()
	        .put("defaultFont", new Font("Serif",0, 13));
			new Controller();
			
	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		 /*
       JFrame frame= new VentanaInsertar();
     frame.setVisible(true);		 
       HibernateHelper model = new HibernateHelper();
		 model.getLastQuestion();
		 System.out.println(model.getLastQuestion().getTitulo());
	 }*/
	 }
}
