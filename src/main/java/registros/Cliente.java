package registros;

import java.io.Serializable;

public class Cliente extends Registro implements Serializable {
    private String CI;
    private String nombre, apellidos;
    private String numeroTelf;
    private String eMail;
    private Opcionales opcionales;
    
    public Cliente(String[] args){
        CI = args[0];
        nombre = args[1];
        apellidos = args[2];
        numeroTelf = args[3];
        eMail = args[4];
    }

    public Cliente(String ci,String nombre, String apellidos, String numeroTelefono,String eMail){
        CI = ci;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numeroTelf = numeroTelefono;
        this.eMail = eMail;
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
    
    public void setOpcionales(Opcionales opcionales) {
        this.opcionales = opcionales;
    }

    public Opcionales getOpcionales() {
        return opcionales;
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
    public int compareTo(Registro r){
        Cliente x = (Cliente) r;
        int res = 0;
        int diferencia = CI.length() - x.getCI().length();
        res = diferencia * 100;
        if(diferencia == 0)
            for(int i=0;i<CI.length();i++){
                diferencia = CI.charAt(i) - x.getCI().charAt(i);
                if(diferencia != 0){
                    res = (diferencia * 10) + i;
                    i = CI.length();
                }
            }
        /*No funcional con letras en el carnet
        Integer aux1 = 0, aux2 = 0;
        aux1 = aux1.parseInt(CI);
        aux2 = aux2.parseInt(x.getCI());
        res = aux1.compareTo(aux2);
        */
        return res;
    }
    
    @Override
    public String toStringList(){
        String res = "";
        res += addTab(CI,2);
        res += addTab(nombre + " " + apellidos, 4);
        res += addTab(numeroTelf,2);
        res += eMail;
        return res;
    }
    
}