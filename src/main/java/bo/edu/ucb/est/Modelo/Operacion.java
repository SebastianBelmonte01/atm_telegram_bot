package bo.edu.ucb.est.Modelo;

import org.glassfish.grizzly.http.util.TimeStamp;



public class Operacion {
    private String idOperacion;
    private double importe;
    private TimeStamp fechaHora; //Guarda la fecha y hora en yyyy-mm-dd hh:mm:ss
    private String operacion; //Abono = AB o debito = DB

    private static int indice = 0;

    public Operacion(double importe, TimeStamp fechaHora, String operacion) {
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
                ", fechaHora=" + fechaHora +
                ", operacion='" + operacion + '\'' +
                '}';
    }
}
