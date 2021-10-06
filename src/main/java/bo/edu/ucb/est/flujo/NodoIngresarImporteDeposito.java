package bo.edu.ucb.est.flujo;

import bo.edu.ucb.est.Modelo.Cliente;
import bo.edu.ucb.est.Modelo.Cuenta;
import bo.edu.ucb.est.utilidades.Mensaje;

import java.util.HashMap;

public class NodoIngresarImporteDeposito extends Nodo{

    public NodoIngresarImporteDeposito(String mensaje) {
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

        double deposito = Double.parseDouble(inputMessage);
        System.err.println("XDXD");
        System.err.println(cuenta.getSaldo() + deposito);
        Mensaje mensaje = cuenta.depositar(deposito);
        if(mensaje.getEstado().equals("OK")){
            System.out.println("MMOMOMOMEOMEOEM");
            return this.getNodosSiguientes().get(0);
        }
        else{
            return nodoAnterior;
        }




    }
}
