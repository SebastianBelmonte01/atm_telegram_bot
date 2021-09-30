package bo.edu.ucb.est.flujo;

import bo.edu.ucb.est.Modelo.Cliente;
import bo.edu.ucb.est.Modelo.Cuenta;

import java.util.HashMap;
import java.util.Iterator;

public class NodoSeleccionarOpcion extends Nodo {
    public NodoSeleccionarOpcion(String mensaje) {
    super(mensaje);
}

    @Override
    public Nodo run(HashMap parametros) {
        String telegramId = (String)parametros.get("telegramId");
        String inputMessage = (String)parametros.get("inputMessage");
        HashMap mapaClientes = (HashMap)parametros.get("mapaClientes");
        Cliente cliente = (Cliente) parametros.get("cliente");

        if ("1".equals(inputMessage)) { // opcion ver saldo
            String msg =  this.getSaldo(cliente);
            if (msg==null) {
                return null;
            }

            this.getNodosSiguientes().get(0).setMensaje(msg);
            return this.getNodosSiguientes().get(0);
        }
        if ("2".equals(inputMessage)) { // opción retirar
            String msg = "Seleccione una cuenta \n" +this.getSaldo(cliente);
            if (msg==null) {
                return null;
            }
            this.getNodosSiguientes().get(1).setMensaje(msg);
            return this.getNodosSiguientes().get(1);
        }
        if ("3".equals(inputMessage)) { // opción depositar
            String msg = "Seleccione una cuenta \n" +this.getSaldo(cliente);
            if (msg==null) {
                return null;
            }
            this.getNodosSiguientes().get(2).setMensaje(msg);
            return this.getNodosSiguientes().get(2);
        }
        if ("4".equals(inputMessage)) { // opción crear cuenta

            return this.getNodosSiguientes().get(3);
        }


        return null;
    }

    private String getSaldo (Cliente cliente) {
        StringBuffer stringBuffer = new StringBuffer();
        if (cliente == null ) {
            return null;
        }
        HashMap cuentas = cliente.getCuentas();
        if (cuentas==null || cuentas.isEmpty()) {
            stringBuffer.append(cliente.getName()+ " no tienes cuentas, registra una cuenta.\n");
            stringBuffer.append("Presiona 0 para volver.");
        } else {
            Iterator it = cuentas.values().iterator();
            int i=1;
            while (it.hasNext()) {
                Cuenta cuenta=(Cuenta) it.next();
                stringBuffer.append(i+" Cuenta:" + cuenta.getNumero() + "\n");
                stringBuffer.append("       Moneda:" + cuenta.getMoneda()+ "\n");
                stringBuffer.append("       Tipo:" + cuenta.getTipo()+ "\n");
                stringBuffer.append("       Saldo:" + cuenta.getSaldo()+ "\n");
                i++;
            }

            stringBuffer.append("0. Volver");
        }
        return stringBuffer.toString();
    }
}
