package bo.edu.ucb.est.flujo;

import bo.edu.ucb.est.Modelo.Cliente;
import bo.edu.ucb.est.Modelo.Cuenta;
import bo.edu.ucb.est.utilidades.Mensaje;

import java.util.HashMap;

public class NodoIngresarImporteRetiro extends Nodo{

    public NodoIngresarImporteRetiro(String mensaje) {
        super(mensaje);
    }

    @Override
    public Nodo run(HashMap parametros) {
        String telegramId = (String)parametros.get("telegramId");
        String inputMessage = (String)parametros.get("inputMessage");
        HashMap mapaClientes = (HashMap)parametros.get("mapaClientes");
        Nodo nodoAnterior =  (Nodo)parametros.get("nodoAnterior");

        Cliente cliente = (Cliente) parametros.get("cliente");
        Cuenta cuenta = (Cuenta) parametros.get("cuentaSeleccionada");


        if (cuenta == null) {
            return null; //Termina el flujo
        }

        double retiro = Double.parseDouble(inputMessage);
        Mensaje mensaje = cuenta.retirar(retiro);
        if(mensaje.getEstado().equals("OK")){
            System.out.println("MMOMOMOMEOMEOEM");
            return this.getNodosSiguientes().get(0);
        }
        else{
            return nodoAnterior;
        }
        //cuenta.setSaldo(cuenta.getSaldo()-deposito);


        //return null; // Analizar el caso para depositar y retirar
    }
}