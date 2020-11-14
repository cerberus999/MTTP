package registros;

import java.io.Serializable;

public class Cliente extends Registro implements Serializable {
    private String CI;
    private String nombre, apellidos;
    private String numeroTelf;
    private String eMail;
    
    //private Opcional opc = null;

    public Cliente(String[] args){
        setCI(args[0]);
        setNombre(args[1]);
        setApellidos(args[2]);
        setNumeroTelf(args[3]);
        seteMail(args[4]);
    }

    public Cliente(String ci,String nombre, String apellidos, String numeroTelefono,String eMail){
        setCI(ci);
        setNombre(nombre);
        setApellidos(apellidos);
        setNumeroTelf(numeroTelefono);
        seteMail(eMail);
    }

    public String getCI() {
        return CI;
    }

    public void setCI(String cI) {
        CI = cI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNumeroTelf() {
        return numeroTelf;
    }

    public void setNumeroTelf(String numeroTelf) {
        this.numeroTelf = numeroTelf;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public String toString(){
        return getCI() + "\n" + getNombre() + "\n" + getApellidos()  + 
        "\n" + getNumeroTelf()  + "\n" + geteMail() + "\n";
    }

    /**
     * CI:124046 compara con CI:124046 retorna: 0
     * CI:12404624 compara con CI:124046 retorna: +20
     * CI:124046 compara con CI:12404624 retorna: -20
     * 
     * 
     *Decenas = diferencia de tamaño entre Ci,
     *Unidades = diferencia de primera diferencia entre el primer caracter distinto (izquierda - derecha)
     */
    @Override
    public int compareTo(Registro x){
        Cliente x2 = (Cliente) x;
        int res = 0;
        int diferencia = CI.length() - x2.getCI().length();
        res = diferencia * 100;
        if(diferencia == 0)
            for(int i=0;i<CI.length();i++){
                diferencia = CI.charAt(i) - x2.getCI().charAt(i);
                if(diferencia != 0){
                    res = (diferencia * 10) + i;
                    i = CI.length();
                }
            }
        return res;
    }
    
    public String toStringList(){
        String res = "";
        res += addTab(CI,2);
        res += addTab(nombre + apellidos, 4);
        res += addTab(numeroTelf,2);
        res += eMail;
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