package bo.edu.ucb.est.flujo;

import bo.edu.ucb.est.Modelo.Cliente;
import bo.edu.ucb.est.Modelo.Cuenta;
import bo.edu.ucb.est.utilidades.Mensaje;

import java.util.HashMap;

public class NodoMensajeDinamicoMostrarCuentas extends Nodo{

    public NodoMensajeDinamicoMostrarCuentas(String mensaje) {
        super(mensaje);
    }

    @Override
    public Nodo run(HashMap parametros) {
        String telegramId = (String)parametros.get("telegramId");
        String inputMessage = (String)parametros.get("inputMessage");
        HashMap mapaClientes = (HashMap)parametros.get("mapaClientes");
        Nodo nodoAnterior =  (Nodo)parametros.get("nodoAnterior");

        Cliente cliente = (Cliente) parametros.get("cliente");
        if (cliente == null) {
            return null; //Termina el flujo
        }
        if ("0".equals(inputMessage)) {
            return this.getNodosSiguientes().get(0); // para que vuelva a NodoSeleccion
        } else {
            int i = Integer.parseInt(inputMessage); //QQQ controlar excepcion
            int indice = 0;
            Cuenta cuenta = null;
            Mensaje mensaje = cliente.buscarCuentaId("IDCC"+ (indice+i));
            if ("OK".equals(mensaje.getEstado())) {
                cuenta = (Cuenta)mensaje.getEntidad();
                parametros.put("cuentaSeleccionada",cuenta);
            }
            return this.getNodosSiguientes().get(0);
        }
    }
}