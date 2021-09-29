package bo.edu.ucb.est.Modelo;

import org.glassfish.grizzly.http.util.TimeStamp;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Operacion {
    private String idOperacion;
    private double importe;
    private Date fechaHora; //Guarda la fecha y hora en yyyy-mm-dd hh:mm:ss
    private String operacion; //Abono = AB o debito = DB

    private static int indice = 0;

    public static String formatoFecha( Date d) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(d);
    }

    public Operacion(double importe, Date fechaHora, String operacion) {
        this.idOperacion = "IDO"+(indice++);
        this.importe = importe;
        this.fechaHora = fechaHora;
        this.operacion = operacion;
    }

    @Override
    public String toString() {
        return "Operacion{" +
                "idOperacion='" + idOperacion + '\'' +
                ", importe=" + importe +
                ", fechaHora=" + formatoFecha(fechaHora) +
                ", operacion='" + operacion + '\'' +
                '}';
    }
}
