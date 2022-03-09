
package Visual;

import Objects.ObjectP;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import java.util.Date;

public class prestamos extends JPanel implements ActionListener {
    Date fechaingresada;
    JLabel Jl1, Jl2, Jl3, Jl4;
    JTextField txt1,txt2,txt3;
    JFrame cargamasiva;
    JTable tabla; 
    JButton btn1,btn2;
    JComboBox Lista ;
    Object[] objeto;
    JScrollPane desplazador;
    DefaultTableModel modelo;
    int i;
    
     public prestamos(){
    setLayout(null);
    objeto =new Object[100];
    i=0;
    componentespresta();
    textboxess();
    tabla();
    boton();

}
   public void componentespresta(){
       
        Jl1 = new JLabel();
        Jl2 = new JLabel();
        Jl3 = new JLabel();
        Jl4 = new JLabel();
        
        Jl1.setText("Usuario");
        Jl1.setBounds(10, 10, 50, 20);
        
        Jl2.setText("Libro");
        Jl2.setBounds(10, 70, 50, 20);
        
        Jl3.setText("Fecha ");
        Jl3.setBounds(10, 130, 90, 20);
        
        Jl4.setText("Entrega ");
        Jl4.setBounds(10, 144, 90, 20);

        add(Jl1); 
        add(Jl2);
        add(Jl3); 
        add(Jl4);
}
    public void change()
    {
        JTable tabla = new JTable(modelo);
        tabla.setFont(new java.awt.Font("Impact", 0, 14));
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        desplazador = new JScrollPane(tabla);
        desplazador.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        desplazador.setBounds(300,10,670,400);
        desplazador.setVisible(true); 
    }
   public void listapres(){
    Lista = new JComboBox();
   }
   public void tabla(){
       
modelo = new DefaultTableModel(); 
modelo.addColumn("Nombre usuario");
modelo.addColumn("Libro");
modelo.addColumn("Fecha de entrega");
modelo.addColumn("Estado");

        JTable tabla = new JTable(modelo);
       desplazador = new JScrollPane(tabla);
        tabla.setBounds(250, 40, 800, 400);
        desplazador.setBounds(250, 40, 800, 400);
     
        add(desplazador);

}
   public void boton(){
        
       btn1 = new JButton();
       btn1.setText("Prestar libro");
       btn1.setBounds(60,200 ,150, 30);
     btn1.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
     btn1.setForeground(new java.awt.Color(102, 102, 102));
     btn1.setBackground(new java.awt.Color(255, 204, 0));
       add(btn1);
       btn1.addActionListener(this);
       btn1.addActionListener(new ActionListener() {
         
         
         public void actionPerformed(ActionEvent en) {
             try{
       if(i<100){
       int idl = Integer.parseInt(txt1.getText().toString());
       int ide = Integer.parseInt(txt2.getText().toString());
       String fecha= txt3.getText().toString();
   
       SimpleDateFormat fechh = new SimpleDateFormat("dd/MM/YYYY");
             Date Time_now = new Date();
       Date DATE1 = conversordate(fecha);
                           
  if(DATE1 != null){
      
      if(Time_now.compareTo(DATE1)<= 0){
       Object[] newr ={idl,ide,stringadate(DATE1),"Prestado"};
       
       modelo.addRow(newr);
       i++;
      }else{ Object[] newr ={idl,ide,stringadate(DATE1),"Entregado"};
       modelo.addRow(newr);
       i++;
      } }else{
       JOptionPane.showMessageDialog(null, "El formato es dd/MM/yyyy"); }
    }else {
        JOptionPane.showMessageDialog(null, "No se aceptan más registros");
  }}catch(Exception ex){JOptionPane.showMessageDialog(null, "Hacen falta datos");} } });
        btn2 = new JButton();
        btn2.setText("Carga masiva");
        btn2.setBounds(60,250 ,150, 30);
        btn2.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        btn2.setForeground(new java.awt.Color(102, 102, 102));
        btn2.setBackground(new java.awt.Color(255, 204, 0));
        add(btn2);
        btn2.addActionListener(this);
        btn2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent en) {
    
  cargamasiva = new JFrame("Carga Masiva");
                cargamasiva.setSize(300,300);
                cargamasiva.setBackground(Color.white);
                cargamasiva.setLayout(null);
  cargamasiva.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent windowEvent){
                       cargamasiva.setVisible(false);
                    }        
                 }); 
                
                JTextArea masivamente = new JTextArea(30,30);
                masivamente.setBackground(new java.awt.Color(204,204,255));
                masivamente.setEditable(true);
                masivamente.setVisible(true);
                desplazador = new JScrollPane(masivamente);
                desplazador.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                desplazador.setBounds(10,10,270,200);
                desplazador.setVisible(true);
  
                JButton cargar = new JButton("Cargar");
                cargar.setBounds(180, 220, 100, 30);
                cargar.setBackground(new java.awt.Color(255, 204, 0));
                cargar.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
                cargar.setBorder(BorderFactory.createLineBorder(Color.black));
                cargar.setVisible(true);
                cargar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(i<100){
                            String datos_carga = masivamente.getText();
                    
                            Object jsonObyeto = JSONValue.parse(datos_carga);
                            JSONObject obyeto = (JSONObject) jsonObyeto;
                       
                            Object jsonarrayobyeto = obyeto.get("Prestamos");
                            JSONArray arrayobyeto = (JSONArray) jsonarrayobyeto;
                            for(Object obyeto_inarray: arrayobyeto)
                            {
                                JSONObject obyeto_value = (JSONObject) obyeto_inarray;
                                
                            ObjectP prestamo_nuevo=new ObjectP();
                            Long idLibro=(Long) obyeto_value.get("IDLibro");
                            prestamo_nuevo.idLibro =  idLibro.intValue();
                            Long id_prestamo=(Long) obyeto_value.get("IDUsuario");
                            prestamo_nuevo.idUsuario =  id_prestamo.intValue();
                            
 

                            Object[] values = {String.valueOf(prestamo_nuevo.idLibro),String.valueOf(prestamo_nuevo.idUsuario),prestamo_nuevo.Fecha };
                            modelo.addRow(values);  i++;
                            }
                            
                            cargamasiva.setVisible(false);
                            change();}else {
                            JOptionPane.showMessageDialog(null, "LIMITE DE REGISTROS");
                            
                            }}  });
                
                cargamasiva.add(desplazador);
                cargamasiva.add(cargar);
                cargamasiva.setLocationRelativeTo(null);
                cargamasiva.setVisible(true);
    }


         });        
}
   
   public void textboxess(){
       txt1=new JTextField();
       txt2=new JTextField();
       txt3=new JTextField();
       txt1.setBounds(70, 10, 150, 25);
       
       txt1.addKeyListener(new KeyListener() {
     @Override
    public void keyTyped(KeyEvent event) {
       char llave= event.getKeyChar();
          if(!Character.isDigit(llave)){ 
               event.consume();
               txt1.setBackground(Color.red);
          }else{
               txt1.setBackground(Color.white);} 
    }
    @Override
   public void keyPressed(KeyEvent e) {}
   @Override
   
   public void keyReleased(KeyEvent e) {}} );
       
       txt2.setBounds(70, 70, 150, 25);
       txt2.addKeyListener(new KeyListener() {
    @Override
    public void keyTyped(KeyEvent e) {
       char c= e.getKeyChar();
          if(!Character.isDigit(c)){ 
            e.consume();
           txt2.setBackground(Color.red);}else{
            txt2.setBackground(Color.white);} }
    @Override
   public void keyPressed(KeyEvent e) {}
   @Override
   public void keyReleased(KeyEvent e) {}} );
          txt3.setBounds(70, 140, 150, 25);
            add(txt3);
            add(txt1);
            add(txt2);
     }
   public static Date conversordate(String fecha){
       
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
          Date f =null;
      try{
        f=date.parse(fecha);
    
     }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Información inválidad");
     }     return f;
   }
   public static String stringadate(Date fecha){
        SimpleDateFormat fech = new SimpleDateFormat("dd/MM/yyyy");
       return fech.format(fecha);
   }
    @Override
    public void actionPerformed(ActionEvent ent) {
    }     
}



