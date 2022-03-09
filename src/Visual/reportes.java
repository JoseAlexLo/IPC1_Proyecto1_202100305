
package Visual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class reportes  extends JPanel implements ActionListener  {
    DefaultTableModel model;
    JButton btn1;
    JLabel etiqueta;
    JScrollPane scrol;
    JTable tablet;
    JComboBox lista ;
     public reportes(){
    setLayout(null);
    botoness();
    tablet();
    reportan();
    lista();
    }
     public void lista(){
 String [] arr={"Usuarios registrados","Libros registrados","Préstamos realizados"};
lista = new JComboBox(arr);
lista.setBounds(150, 110, 150, 20);
add(lista);
}
       public void reportan(){
         etiqueta = new JLabel();
         etiqueta.setText("Tipo de Reporte");
etiqueta.setBounds(50, 110, 100, 20);
         add(etiqueta);
      
     }       
     public void botoness(){
     
     btn1 = new JButton();
       btn1.setText("Generar");
       btn1.setBounds(270,140 ,100, 30);
       btn1.setBackground(new java.awt.Color(255, 204, 0));
        btn1.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
      add(btn1);
         btn1.addActionListener(this);
         btn1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent en) {
             
         String tipo= lista.getSelectedItem().toString();
              String r= getTipoLibro(tipo);
            
             bienvenida object = new bienvenida();
             SimpleDateFormat fech = new SimpleDateFormat("dd/MM/YYYY");
             Date fecha = new Date();

       Object[] newr ={fech.format(fecha),object.nombre,r};//introduzco los datos ingresados al objeto array
model.addRow(newr);
         
         } });
     }
     
     public void tablet(){
    

 model = new DefaultTableModel();
model.addColumn("Fecha De Generación");
model.addColumn("Usuario");
model.addColumn("Tipo Reporte");

 


        JTable tabla = new JTable(model);
       scrol = new JScrollPane(tabla);
        tabla.setBounds(430, 40, 600, 400);
        scrol.setBounds(430, 40, 600, 400);
        add(scrol);

}
   public String getTipoLibro(String tipo){
      switch(tipo){
          case "Usuarios registrados": 
              return "Usuarios registrados";
          case "libros registrados": 
              return "libros registrados";
          case "Préstamos realizados": 
              return "Préstamos realizados";
              default: 
            return "";
      
      }  
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }     
}
