
package registros;

import java.io.Serializable;

public class Hotel extends Servicio implements Serializable{
    private int cantEstrellas;
    private String nombreHotel;

    public Hotel(String[] args){
        super(new String[] {args[0],args[1],args[2],args[3],args[4],args[5]});
        cantEstrellas = Integer.parseInt(args[6]);
        nombreHotel = args[7];        
    }
    
public void setCantEstrellas(int cantEstrellas) {
        this.cantEstrellas = cantEstrellas;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public int getCantEstrellas() {
        return cantEstrellas;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }    
}
