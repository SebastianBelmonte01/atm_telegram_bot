package bo.edu.ucb.est.Modelo;

import bo.edu.ucb.est.utilidades.Mensaje;
import org.glassfish.grizzly.http.util.TimeStamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cuenta implements InterfaceOperaciones{
    private String numero;
    private String moneda;
    private String tipo;
    private double saldo;


    private List<Operacion> operaciones;
    private static int indice = 0;



    public Cuenta(String moneda, String tipo, double importe) {
        this.numero = "IDCC"+ (++indice);
        this.moneda = moneda;
        this.tipo = tipo;
            this.saldo = importe;
        this.operaciones = new ArrayList<>();
        Operacion op = new Operacion(importe,new Date(),"AB"); //Importe inicial al crear la cuenta

    }

    public int getIndice() {
        return this.indice;//(++indice);
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<Operacion> getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(List<Operacion> operaciones) {
        this.operaciones = operaciones;
    }

    @Override
    public void depositar(double importe) {
        Operacion op = new Operacion(importe,new Date(),"AB"); //Importe inicial al crear la cuenta
        operaciones.add(op);
        this.saldo += importe;
    }

    @Override
    public Mensaje retirar(double importe) {
        Mensaje mensaje = new Mensaje();
        if(saldo >= importe){
            Operacion op = new Operacion(importe,new Date(),"DB"); //Importe inicial al crear la cuenta
            operaciones.add(op);
            this.saldo -= importe;
            mensaje.setEstado("OK");
            mensaje.setMensaje("Operación realizada con exito. ");
            return mensaje;
        }
        else{
            mensaje.setEstado("NOK");
            mensaje.setMensaje("Saldo insuficiente. ");
            return mensaje;
        }

    }

    @Override
    public double verSaldo() {
        return this.saldo;
    }

    @Override
    public List<Operacion> consultarExtracto() {
        return operaciones;
    }

  /* public static void main(String[] args){
        Cliente mariaGomez = new Cliente("SUS","Maria Gomez","4444");
        Cuenta cta1Maria = new Cuenta("BOB", "Caja de ahorros", 1000.0);
        mariaGomez.agregarCuenta(cta1Maria);
        cta1Maria.depositar(500);
        cta1Maria.depositar(200);

        Mensaje m = cta1Maria.retirar(1000);
        //System.out.println(m);
        Mensaje m1 = cta1Maria.retirar(1800);
        //System.out.println(m1);
        //System.out.println(cta1Maria.getSaldo());

        //System.out.println(mariaGomez);
        System.out.println(cta1Maria.getOperaciones());

    }*/


    @Override
    public String toString() {
        return "Cuenta{" +
                "numero='" + numero + '\'' +
                ", moneda='" + moneda + '\'' +
                ", tipo='" + tipo + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
