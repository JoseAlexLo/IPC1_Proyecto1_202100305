package Visual;

import Objects.ObjectL;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class libros extends JPanel implements ActionListener  {
    
    
    public static JTable tabla1;
    int contador12;
    JScrollPane Deslizador, deslizador2;
    JLabel jl1,jl2,jl3,jl4,jl5;
    JTextField txt1,txt2,txt3,txt4,txt5;
    JPanel Ventana1;
    JButton btn1,btn2;
    JComboBox lista ;
    DefaultTableModel modelo1;
    JFrame pantalla_masiva;
    Object[] OBJECT1;     
 
    public libros(){
   
       
    setLayout(null);
    OBJECT1 =new Object[100];
    contador12 = 0;
    Unidades();
    Textboxes();
    Combo();
    Btn();
    tabla();
    }
   
public void Unidades(){
    
jl1= new JLabel();
jl1.setBounds(10, 10, 50, 20);
jl2 = new JLabel();
jl2.setBounds(10, 80, 50, 20);
jl3 = new JLabel();
jl3.setBounds(10, 140, 50, 20);
jl4 = new JLabel();
jl4.setBounds(10, 205, 50, 20);
jl5 = new JLabel();
jl5.setBounds(10, 270, 50, 20);
jl1.setText("ID Libro");
jl2.setText("Libro");
jl3.setText("Autor");
jl4.setText("copias");
jl5.setText("Tipo");
add(jl1);
add(jl2);
add(jl3);
add(jl4);
add(jl5);

}
 
public void Textboxes(){
    
    
    txt1 = new JTextField();
    txt1.setBounds(60, 10, 150, 25);
    txt1.addKeyListener(new KeyListener() {
        
        @Override
        public void keyTyped(KeyEvent ei) {
        char c= ei.getKeyChar();
          if(!Character.isDigit(c)){ 
              
    ei.consume();
     txt1.setBackground(Color.red);}else{
     txt1.setBackground(Color.white);} }
     @Override
     public void keyPressed(KeyEvent ei) {}
     @Override
     public void keyReleased(KeyEvent ei) {}} );

  
    txt2 = new JTextField();
    txt2.setBounds(60, 70, 150, 25);
    txt3 = new JTextField();
    txt3.setBounds(60, 130, 150, 25);
    txt4 = new JTextField();
    txt4.setBounds(60, 190, 150, 25);
    txt4.addKeyListener(new KeyListener() {
     @Override
     public void keyTyped(KeyEvent ei) {
         char c= ei.getKeyChar();
            if(!Character.isDigit(c)){ 
     ei.consume();
            txt4.setBackground(Color.red);}
            else {
      txt4.setBackground(Color.white);} }
     @Override
     public void keyPressed(KeyEvent ei) {}
     @Override
     public void keyReleased(KeyEvent ei) {}} );
    add(txt1);
     
add(txt2);
add(txt3);
add(txt4);
}
public void Combo(){
    
String [] arr={"1","2","3"};
lista = new JComboBox(arr);
lista.setBounds(60, 250, 100, 20);
add(lista);

}
public void tabla(){

    modelo1 = new DefaultTableModel();
    modelo1.addColumn("ID Libro");
    modelo1.addColumn("Nombre Libro");
    modelo1.addColumn("Autor");
    modelo1.addColumn("Tipo");
    modelo1.addColumn("Copias");
    modelo1.addColumn("Disponibles");
    modelo1.addColumn("Ocupados");
    

    JTable tabla = new JTable(modelo1);
    deslizador2 = new JScrollPane(tabla);
    tabla.setBounds(250, 40, 800, 400);
    tabla.setFont(new java.awt.Font("Impact", 0, 14));
    deslizador2.setBounds(250, 40, 800, 400); 
    add(deslizador2);

}

public void Btn(){
    
    btn1 = new JButton();
    btn1.setText("registrar libro");
    btn1.setBounds(60,300 ,150, 30);
    btn1.setBackground(new java.awt.Color(255, 204, 0));
    btn1.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
    add(btn1);
    btn1.addActionListener(this);
    btn1.addActionListener(new ActionListener() {
        
         public void actionPerformed(ActionEvent en) {
             
             try{
                 if(contador12<100){ 
                    int id = Integer.parseInt(txt1.getText().toString());
                    String libro= txt2.getText().toString();
                    String autor= txt3.getText().toString();
                    String tString= (String) lista.getSelectedItem();
                    int tipo = Integer.parseInt(tString.toString()); 
                    String tipos= Type(tipo);
                    int copi = Integer.parseInt(txt4.getText().toString());
                    
                    Object[] newr ={id,libro,autor,tipos,copi,copi,0};
                    modelo1.addRow(newr);
                    contador12++;
                }else {   
                    JOptionPane.showMessageDialog(null, "Se ha llegado al limite de registros");  }
                    }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Hacen falta datos");
             }
         } });
    
    btn2 = new JButton();
    btn2.setText("Carga masiva");
    btn2.setBounds(60,360 ,150, 30);
    btn2.setBackground(new java.awt.Color(255, 204, 0));
    btn2.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
    add(btn2);
    btn2.addActionListener(this);
    btn2.addActionListener(new ActionListener() {
        
         
        public void actionPerformed(ActionEvent en) {
            
            pantalla_masiva = new JFrame("Carga Masiva");
            pantalla_masiva.setSize(300,300);
            pantalla_masiva.setBackground(Color.white);
            pantalla_masiva.setLayout(null);
            pantalla_masiva.addWindowListener(new WindowAdapter() {
                
                public void windowClosing(WindowEvent windowEvent){
                    
                    pantalla_masiva.setVisible(false);
                    }}); 
            
            JTextArea DATOS = new JTextArea(30,30);
            DATOS.setBackground(new java.awt.Color(204,204,255));
            DATOS.setEditable(true);
            DATOS.setVisible(true);
            Deslizador = new JScrollPane(DATOS);
            Deslizador.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            Deslizador.setBounds(10,10,270,200);
            Deslizador.setVisible(true);
  
            JButton Carga_Libros = new JButton("Cargar");
            Carga_Libros.setBounds(180, 220, 100, 30);
            Carga_Libros.setBackground(new java.awt.Color(255, 204, 0));
            Carga_Libros.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
            Carga_Libros.setBorder(BorderFactory.createLineBorder(Color.black));
            Carga_Libros.setVisible(true);
            Carga_Libros.addActionListener(new ActionListener() {
                
                    @Override
                    public void actionPerformed(ActionEvent e) { 
                        if(contador12<100){
                            String datos_carga = DATOS.getText();
                    
                            Object jsonObyeto = JSONValue.parse(datos_carga); 
                            JSONObject obyeto = (JSONObject) jsonObyeto;
                       
                            Object jsonarrayobyeto = obyeto.get("Libros");
                            JSONArray arrayobyeto = (JSONArray) jsonarrayobyeto;
                            for(Object obyeto_inarray: arrayobyeto){
                                
                                JSONObject obyeto_value = (JSONObject) obyeto_inarray;
                                ObjectL libro_nuevo=new ObjectL();
                                Long id_libro=(Long) obyeto_value.get("ID");
                                libro_nuevo.idLibro =  id_libro.intValue();
                                libro_nuevo.titulo = (String) obyeto_value.get("Titulo");
                                libro_nuevo.autor = (String) obyeto_value.get("Autor");
                                Long disponible=(Long) obyeto_value.get("Disponible");
                                libro_nuevo.disponible =  id_libro.intValue();
                                Long copias=(Long) obyeto_value.get("Copias");
                                libro_nuevo.copias =  id_libro.intValue();
                                Long ocupados=(Long) obyeto_value.get("Ocupados");
                                libro_nuevo.ocupados =  id_libro.intValue(); 
                                Long Tipo=(Long) obyeto_value.get("Tipo");
                                libro_nuevo.tipo =  id_libro.intValue();
                                String[] values = {String.valueOf(libro_nuevo.idLibro),libro_nuevo.titulo,libro_nuevo.autor,Type(libro_nuevo.tipo),String.valueOf(libro_nuevo.copias),String.valueOf(libro_nuevo.disponible),String.valueOf(libro_nuevo.ocupados)};
                                modelo1.addRow(values);
                                contador12++;
                            }
                            pantalla_masiva.setVisible(false);
                            tabla123();
                        }else { 
                            
                            JOptionPane.showMessageDialog(null, "LIMITE DE REGISTROS");
                        }
                    }
                });
            pantalla_masiva.add(Deslizador);
            pantalla_masiva.add(Carga_Libros);
            pantalla_masiva.setLocationRelativeTo(null); 
            pantalla_masiva.setVisible(true);
    }
         });     
}
public String Type(int tipo){
    
    switch(tipo){
        case 1: 
            return "Libro";
        case 2: 
            return "Revista";
        case 3: 
            return "Libros Electronicos";
        default: 
            return "";
      }  
    }
 
 public void tabla123()
    {
        JTable tabla = new JTable(modelo1);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        Deslizador = new JScrollPane(tabla);
        Deslizador.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        Deslizador.setBounds(300,10,670,400);
        Deslizador.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ent) {
        
    }
}
