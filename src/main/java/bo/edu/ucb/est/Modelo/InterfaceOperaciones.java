package bo.edu.ucb.est.Modelo;

import bo.edu.ucb.est.utilidades.Mensaje;

import java.util.List;

public interface InterfaceOperaciones {
    public void depositar(double importe);
    public Mensaje retirar(double importe);
    public double verSaldo();
    public List<Operacion> consultarExtracto();

}
