package bo.edu.ucb.est.flujo;

import java.util.HashMap;
import bo.edu.ucb.est.Modelo.Cliente;
import bo.edu.ucb.est.Modelo.Cuenta;

public class NodoCrearNuevaCuenta extends Nodo{

    public NodoCrearNuevaCuenta(String mensaje) {
        super(mensaje);
    }
    public NodoCrearNuevaCuenta() {
        super();
    }

    @Override
    public Nodo run(HashMap parametros) {
        String telegramId = (String)parametros.get("telegramId");
        String inputMessage = (String)parametros.get("inputMessage");
        HashMap mapaClientes = (HashMap)parametros.get("mapaClientes");
        Cliente cliente = (Cliente) parametros.get("cliente");

        if ("1".equals(inputMessage)) { //Caja ahorro BS
            cliente.registrarNuevaCuenta(new Cuenta("Bolivianos","Caja Ahorro",0.0));
            return this.getNodosSiguientes().get(0);
        }
        if ("2".equals(inputMessage)) { //Caja ahorro USD
            cliente.registrarNuevaCuenta(new Cuenta("USD","Caja Ahorro",0.0));
            return this.getNodosSiguientes().get(0);
        }
        if ("3".equals(inputMessage)) { //Cuenta corriente BS
            cliente.registrarNuevaCuenta(new Cuenta("Bolivianos","Cuenta corriente",0.0));
            return this.getNodosSiguientes().get(0);
        }
        if ("4".equals(inputMessage)) { //Cuenta corriente USD
            cliente.registrarNuevaCuenta(new Cuenta("USD","Cuenta corriente",0.0));
            return this.getNodosSiguientes().get(0);
        }

        return this.getNodosSiguientes().get(0);
    }
}