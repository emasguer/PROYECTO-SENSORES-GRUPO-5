package Notificacion;

import Sensor.Observacion;
import java.util.ArrayList;
import java.util.Date;


public class Notificacion{
    protected String fechaNotificacion;
    protected String etiqueta;     
    protected float valor;
    public static ArrayList<Observacion> observaciones = new ArrayList<>();

    public Notificacion() {
    } 
    public Notificacion(float valor, String fechaNotificacion ) {        
        this.valor = valor;
        this.fechaNotificacion = fechaNotificacion;
    }
    public String getEtiqueta() {
        return etiqueta;
    }
    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }
    public boolean validarFecha(String rangoFechas){
        String[] fechaNotificacion = this.fechaNotificacion.split("-");
        String [] fecha = fechaNotificacion[0].split("/");
        String[] rangoDates = rangoFechas.split("/");
        Date date_notificacion = new Date(Integer.parseInt(fecha[2]),Integer.parseInt(fecha[1]),Integer.parseInt(fecha[0]));
        String[] fechaPosterior = rangoDates[0].split("-");
        String[] fechaAnterior = rangoDates[1].split("-");
        Date datePosterior = new Date(Integer.parseInt(fechaPosterior[2]),Integer.parseInt(fechaPosterior[1]),Integer.parseInt(fechaPosterior[0]));
        Date dateAnterior = new Date(Integer.parseInt(fechaAnterior[2]),Integer.parseInt(fechaAnterior[1]),Integer.parseInt(fechaAnterior[0]));
        //System.out.println(dateAnterior.toString()+datePosterior.toString()+date_notificacion.toString());
        if(date_notificacion.after(dateAnterior) && date_notificacion.before(datePosterior)){
            return true;
        }
        else if(date_notificacion.equals(datePosterior) || date_notificacion.equals(dateAnterior)){
            return true;
        }
        return false;
    }
}
