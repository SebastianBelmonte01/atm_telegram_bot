package bo.edu.ucb.est.flujo;

import bo.edu.ucb.est.Modelo.Cliente;
import bo.edu.ucb.est.Modelo.Cuenta;
import bo.edu.ucb.est.Modelo.Operacion;
import bo.edu.ucb.est.utilidades.Mensaje;

import java.util.HashMap;

public class NodoMensajeDinamicoMostrarOperacionesCuenta extends Nodo {
    public NodoMensajeDinamicoMostrarOperacionesCuenta(String mensaje) {
        super(mensaje);
    }

    @Override
    public Nodo run(HashMap parametros) {
        String telegramId = (String) parametros.get("telegramId");
        String inputMessage = (String) parametros.get("inputMessage");
        Nodo nodoAnterior = (Nodo) parametros.get("nodoAnterior");
        HashMap mapaClientes = (HashMap) parametros.get("mapaClientes");
        Cliente cliente = (Cliente) parametros.get("cliente");
        if (cliente == null) {
            return null; //Termina el flujo
        }
        if ("0".equals(inputMessage)) {
            System.out.println("AQUIE ESTAS TU");
            return nodoAnterior;//return this.getNodosSiguientes().get(0); // para que vuelva a NodoSeleccion
        } else {

            int i = Integer.parseInt(inputMessage); //QQQ controlar excepcion
            int indice = 0;
            Cuenta cuenta = null;
            Mensaje mensaje = cliente.buscarCuentaId("IDCC"+ (indice+i));


            if ("OK".equals(mensaje.getEstado())) {
                System.out.println("ENCONTRADA");
                cuenta = (Cuenta)mensaje.getEntidad();
                parametros.put("cuentaSeleccionada",cuenta);
                this.getNodosSiguientes().get(0).setMensaje(this.getHistorialOperaciones(cuenta));
                System.out.println(getHistorialOperaciones(cuenta));
            }
            return this.getNodosSiguientes().get(0);
        }
    }
    private String getHistorialOperaciones(Cuenta cuenta){
        StringBuffer stringBuffer = new StringBuffer();
        for(Operacion o: cuenta.getOperaciones()){
            stringBuffer.append("\n Operacion: " + o.getOperacion()+"\n");
            stringBuffer.append("Fecha: " + o.getFechaHora()+"\n");
            stringBuffer.append("Importe: " + o.getImporte());

        }
        stringBuffer.append("\n0. Ver Opciones");
        return stringBuffer.toString();
    }
}