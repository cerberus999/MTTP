package registros;

import java.io.Serializable;

public class Usuario extends Registro implements Serializable {
    private String nombre;
    private String apellido;
    private String login;
    private String contraseña;
    private String telefonoRef;
    private String puesto;

    public Usuario(String[] args) {
        nombre = args[0];
        apellido = args[1];
        login = args[2];
        contraseña = args[3];
        telefonoRef  = args[4];
        puesto = args[5];
    }
    
    public Usuario(String args){
        String[] datos = args.split(",");
        nombre = datos[0];
        apellido = datos[1];
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getTelefonoRef() {
        return telefonoRef;
    }

    public void setTelefonoRef(String telefonoRef) {
        this.telefonoRef = telefonoRef;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getPuesto() {
        return puesto;
    }
    
    public String toStringList(){
        String res = "";
        res += addTab(nombre, 3);
        res += addTab(apellido, 3);
        res += addTab(login, 2);
        res += addTab(contraseña, 3);
        res += addTab(telefonoRef,2);
        res += puesto;
        return res;
    }

    @Override
    public int compareTo(Registro r) {
        Usuario u = (Usuario) r;
        return nombre.compareTo(u.getNombre());
    }
}