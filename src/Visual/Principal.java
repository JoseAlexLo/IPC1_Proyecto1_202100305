
package Visual;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame implements ActionListener {
    
 JPanel panellibros;
 JButton boton1;
 libros libros;
 prestamos prestamos;
 reportes reportes;
 estadística graficas;
 JTabbedPane paneles;
 
    public Principal(){
     
    ventanalibros();
    Bar_Menu();

            
    } 
    private void ventanalibros(){
        this.setSize(1100,600);
        setBackground(new java.awt.Color(0, 102, 153));
        setTitle("BIBLIOTECA");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void Bar_Menu(){
         paneles = new JTabbedPane();
         libros = new libros();
         prestamos = new prestamos();
         reportes = new reportes();
         paneles.add("libros",libros);
         paneles.add("prestamos",prestamos);
         paneles.add("reportes",reportes);
         paneles.add("graficas",graficas);
         add(paneles);
     }
     private void Labels(){
    panellibros = new JPanel();
   
    panellibros.setLayout(null);
    setBackground(new java.awt.Color(0, 102, 153));
    this.getContentPane().add(panellibros);
     }
     
    public void actionPerformed(ActionEvent e) {
       
    }  
}
