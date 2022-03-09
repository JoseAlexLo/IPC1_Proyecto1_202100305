
package Visual;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;  
import org.json.simple.JSONValue;
import Objects.ObjectU;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class bienvenida extends JFrame implements ActionListener { 
    public static String nombre = "";
    public ObjectU[] users;
    public ObjectU logged;
    int contador;
    public String n;
    JPanel panel;
    JButton btn1, btn2;
    JTextField txt1;   
    JPasswordField contraseñasss;
    
       
 public bienvenida(){
     contador = 0;
     users = new ObjectU[50];
     Windows();
     Paneles();
     Buttons();
     Textbox();
 }
 
    private void Windows(){
        this.setSize(500,500);
        setTitle("REGISTRO");
        setLocationRelativeTo(null);
        Paneles();
        setDefaultCloseOperation(EXIT_ON_CLOSE);  }

    private void Paneles(){
    panel = new JPanel();
    panel.setBackground(new java.awt.Color(0,102,153));
    panel.setLayout(null);
    this.getContentPane().add(panel);
    
    JLabel usuariolabel = new JLabel();
    usuariolabel.setText("Usuario: ");
    usuariolabel.setBounds(50, 50, 50, 100);
    usuariolabel.setForeground(new java.awt.Color(255, 255, 255));
     panel.add(usuariolabel); 
     
    JLabel passlabel = new JLabel();
    passlabel.setText("Contraseña: ");
    passlabel.setBounds(50, 150, 100, 50);
    passlabel.setForeground(new java.awt.Color(255, 255, 255));
     panel.add(passlabel);
    }
    
    
    public void Textbox(){
        
    txt1 = new JTextField();
    txt1.setBounds(100, 95, 150, 25);
    
    panel.add(txt1);
    contraseñasss = new JPasswordField(8);
    contraseñasss.setBounds(118, 165, 150, 25);
    panel.add(contraseñasss);            
    }
    
    
     public void Buttons(){
       
       btn1 = new JButton();
       btn1.setText("Iniciar sesion");
       btn1.setBounds(180,250 ,150, 30);
       btn1.setBackground(new java.awt.Color(255, 204, 0));
       btn1.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
       btn1.setForeground(new java.awt.Color(102, 102, 102));
       panel.add(btn1);
       btn1.addActionListener(this);
       btn1.addActionListener(new ActionListener() {
             
             @Override
            public void actionPerformed(ActionEvent e) {
           nombre = txt1.getText();
           reportes ventana = new reportes();
            String usuario = txt1.getText();
            String passwords = contraseñasss.getText();
               logged = new ObjectU();
               for(ObjectU user : users)
               {
                   if(user != null)
                 {
                       System.out.println(user.getUsername().trim().equals(usuario.trim()));
                       System.out.println(user.getPassword().trim().equals(passwords.trim()));
                       if(user.getUsername().trim().equals(usuario.trim()) && user.getPassword().trim().equals(passwords.trim()))
                       {
                          logged = user;
                          break;
                 }
                   }
              }
               txt1.setText("");
               contraseñasss.setText("");
               if(logged.getIdUsuario()!= -1)
               {
                   System.out.println("ID Usuario: "+logged.getIdUsuario());
                   if((logged.getTipo() == 1 )) { 
                       Principal obj2 =  new Principal();
                        obj2.setVisible(true);
                   bienvenida.this.setVisible(false); 
                   }
                   else {JOptionPane.showMessageDialog(null, "Usuario Normal - Acceso Restringido", "Su usuario no posee los permisos necesarios", JOptionPane.INFORMATION_MESSAGE);
                    }
              }else{JOptionPane.showMessageDialog(null, "No Existe un usuario con las credenciales indicadas", "Error al Iniciar Sesion", JOptionPane.ERROR_MESSAGE);
              }  
            } });
         
       btn2 = new JButton();
       btn2.setText("carga masiva");
       btn2.setBounds(320,400 ,130, 30);
       btn2.setBackground(new java.awt.Color(255, 204, 0));
       btn2.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
       btn2.setForeground(new java.awt.Color(102, 102, 102));
         panel.add(btn2);
         btn2.addActionListener(this);
         btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               JFrame masivo = new JFrame("Carga Masiva");
               masivo.setSize(300,300);
               masivo.setBackground(Color.BLUE);

               masivo.setLayout(null);
               masivo.addWindowListener(new WindowAdapter()
               {
                   public void windowClosing(WindowEvent windowEvent){
                   masivo.setVisible(false);
                   }        
                 }); 
                JTextArea JSON = new JTextArea(20,20);
                JSON.setBackground(new java.awt.Color(204,204,255));
                JSON.setEditable(true);
                JSON.setVisible(true);
                JScrollPane desplazador2 = new JScrollPane(JSON);
                desplazador2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                desplazador2.setBounds(10,10,270,200);
                desplazador2.setVisible(true);
                
                
                JButton guarda_datos = new JButton("Cargar");
                guarda_datos.setBounds(180, 220, 100, 30);
                guarda_datos.setBackground(new java.awt.Color(255, 204, 0));
                guarda_datos.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
                guarda_datos.setBorder(BorderFactory.createLineBorder(Color.blue));
                guarda_datos.setVisible(true);
                guarda_datos.addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(contador<users.length){
                            String datos_carga = JSON.getText();
                            Object JSONOBJECT = JSONValue.parse(datos_carga); 
                            JSONObject objecte = (JSONObject) JSONOBJECT; 
                            
                            Object ARRAY = objecte.get("Usuarios");
                            JSONArray arrayobyeto = (JSONArray) ARRAY;
                            for(Object obyeto_inarray: arrayobyeto)
                            {
                                if(contador==users.length)break;
                                JSONObject VALEUR = (JSONObject) obyeto_inarray;
                                ObjectU NEW = new ObjectU();

                                NEW.setUsername((String) VALEUR.get("Usuario"));
                                NEW.setPassword((String) VALEUR.get("Password"));
                                NEW.setEscuela((String) VALEUR.get("Carrera"));
                                NEW.setFacultad((String) VALEUR.get("Facultad"));
                                Long value_tipo = (Long) VALEUR.get("Tipo");
                                NEW.setTipo(value_tipo.intValue());
                                Long value_id = (Long) VALEUR.get("ID");
                                NEW.setIdUsuario(value_id.intValue());
                                System.out.println("ID: "+ (Long) VALEUR.get("ID"));
                                System.out.println("Usuario: "+ (String) VALEUR.get("Usuario"));
                                System.out.println("Password: "+ (String) VALEUR.get("Password"));
                                System.out.println("Tipo: "+ (Long) VALEUR.get("Tipo"));
                                System.out.println("Facultad: "+ (String) VALEUR.get("Facultad"));
                                System.out.println("Carrera: "+ (String) VALEUR.get("Carrera"));
                                users[contador] = NEW;
                                contador++;
                           }
                            masivo.setVisible(false);
                   }
       }
               });
               masivo.add(desplazador2);
               masivo.add(guarda_datos);
               masivo.setLocationRelativeTo(null);
               masivo.setVisible(true);
          }});
          }
    @Override
    public void actionPerformed(ActionEvent en) {
    }
}