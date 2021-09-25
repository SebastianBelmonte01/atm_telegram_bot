package bo.edu.ucb.est.Modelo;

import bo.edu.ucb.est.UI.Pantalla;

import java.util.ArrayList;
import java.util.List;

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
    public Pantalla construirPantallaIngreso(Cliente cliente ){ //Construye la pantalla si el cliente ya a sido registrado
        Pantalla pantallaIngreso = new Pantalla("Cajero automático");
        List ingresoContenido = new ArrayList();
        if(cliente == null){ //Cliente NO registrado
            ingresoContenido.add("Bienvenido al Banco Rex");
            ingresoContenido.add("He notado que aún no eres cliente, procedamos a registrarte ");
            ingresoContenido.add("¿Cual es tu nombre completo?");
            ingresoContenido.add("Por favor, ingrese un PIN de seguridad, este sera requerido cada vez que ingreses al sistema.");
            pantallaIngreso.definirDatoEntrada("String");
            ingresoContenido.add("Te hemos registrado correctamente");
        } else{
            ingresoContenido.add("Hola de nuevo " + cliente.getName());
            ingresoContenido.add("Solo por seguridad cual es tu PIN? ");
            pantallaIngreso.definirDatoEntrada("String");
        }
        pantallaIngreso.setContenido(ingresoContenido);
        return pantallaIngreso;
    }


}
