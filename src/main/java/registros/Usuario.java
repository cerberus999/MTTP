package registros;

import java.io.Serializable;

public class Usuario extends Registro implements Serializable {
    private String login;
    private String contraseña;
    private String nombreCmpl;
    private String telefonoRef;
    private String puesto;

    public Usuario(String[] args) {
        login = args[0];
        contraseña = args[1];
        nombreCmpl = args[2];
        telefonoRef  = args[3];
        puesto = args[4];
    }
    
    public void setNombreCmpl(String nombreCmpl) {
        this.nombreCmpl = nombreCmpl;
    }

    public String getNombreCmpl() {
        return nombreCmpl;
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
        res += addTab(login, 2);
        res += addTab(contraseña, 3);
        res += addTab(nombreCmpl, 5);
        res += addTab(telefonoRef,2);
        res += puesto;
        return res;
    }

    @Override
    public int compareTo(Registro r) {
        Usuario u = (Usuario) r;
        return login.compareTo(u.getLogin());
    }
}