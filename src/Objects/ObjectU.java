
package Objects;

public class ObjectU {
    private String username;
    private String password;
    private int idUsuario;
    private int tipo;
    private String Facultad;
    private String Escuela;
    
    public ObjectU(){
        username = "";
        password = "";
        idUsuario = -1;
        tipo = -1;
        Facultad = "";
        Escuela = "";
    }
      public ObjectU(String username, String password, int idUsuario, int tipo, String facultad, String escuela) {
        this.username = username;
        this.password = password;
        this.idUsuario = idUsuario;
        this.tipo = tipo;
        Facultad = facultad;
        Escuela = escuela;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public int getTipo() {
        return tipo;
    }
    public String getTipoInfo()
    {
        return (tipo==1)? "Administrador": "Usuario";
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    public String getFacultad() {
        return Facultad;
    }
    public void setFacultad(String facultad) {
        Facultad = facultad;
    }
    public String getEscuela() {
        return Escuela;
    } 
    public void setEscuela(String escuela) {
        Escuela = escuela;
    }
}
