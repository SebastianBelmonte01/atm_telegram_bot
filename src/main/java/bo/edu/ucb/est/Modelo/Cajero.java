package bo.edu.ucb.est.Modelo;

import bo.edu.ucb.est.UI.Pantalla;

public class Cajero {
    private Pantalla pantallaError;
    private Pantalla pantallaBienvenida;
    private Pantalla pantallaRealizarDeposito;
    private Pantalla pantallaRealizarRetiro;
    private Pantalla pantallaRgistrarCuenta;
    private Banco banco;
    private Cliente cliente;

    public Cajero(Banco banco) {
        this.banco = banco;
        pantallaError = new Pantalla("Sucedio un error");
    }

}
