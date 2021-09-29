package bo.edu.ucb.est.flujo;

import java.util.Date;
import bo.edu.ucb.est.Modelo.Cliente;
import bo.edu.ucb.est.Modelo.Cuenta;

public class Proceso {

    private Nodo nodoActual;
    private Date fechaHora;
    private Cliente cliente;

    private Nodo nodoAnterior;

    private Cuenta cuentaSeleccionada;

    public Cuenta getCuentaSeleccionada() {
        return cuentaSeleccionada;
    }

    public void setCuentaSeleccionada(Cuenta cuentaSeleccionada) {
        this.cuentaSeleccionada = cuentaSeleccionada;
    }

    public Nodo getNodoAnterior() {
        return nodoAnterior;
    }

    public void setNodoAnterior(Nodo nodoAnterior) {
        this.nodoAnterior = nodoAnterior;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Nodo getNodoActual() {
        return nodoActual;
    }

    public void setNodoActual(Nodo nodoActual) {
        this.nodoActual = nodoActual;
    }


    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }
}
