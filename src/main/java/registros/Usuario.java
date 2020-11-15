package registros;

import java.io.Serializable;

public class Usuario implements Serializable, Comparable<Usuario> {
    private String login;
    private String contraseña;
    private String nombreCmpl;
    private String telefonoRef;

    public Usuario(String[] args) {
        login = args[0];
        contraseña = args[1];
        nombreCmpl = args[2];
        telefonoRef  = args[3];
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

    @Override
    public int compareTo(Usuario usr) {
        return login.compareTo(usr.getLogin());
    }
    
    public String toStringList(){
        String res = "";
        res = addTab(login, 2);
        res = addTab(contraseña, 2);
        res = addTab(nombreCmpl, 4);
        res = telefonoRef;
        return res;
    }
    
    private String addTab(String string,int tabs){
        int aux = string.length();
        tabs = tabs - (aux / 8);
        while(tabs > 0){
            string = string + "\t";
            tabs--;
        }
        return string;
    }
}