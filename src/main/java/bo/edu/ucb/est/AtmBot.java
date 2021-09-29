package bo.edu.ucb.est;

import bo.edu.ucb.est.Modelo.*;
import bo.edu.ucb.est.flujo.*;
import bo.edu.ucb.est.flujo.Proceso;
import org.checkerframework.checker.units.qual.C;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class AtmBot extends TelegramLongPollingBot {
    HashMap<String, Usuario> mapaUsarios;
    HashMap<String, Cliente> mapaClientes;
    private int estado = 0;
    private boolean flag = false;
    private  String nombre = null;
    private static Banco BancoRex = new Banco("Banco Rex", "BR","18279301","Av. Jurasico");

    private HashMap<String,List<Proceso>> mapaProcesosEjecucion = new HashMap<String,List<Proceso>>();


    private Nodo nodoInicio;

    private boolean modoPrueba= false;

    AtmBot(){

        this.iniciar();
    }

    @Override
    public String getBotUsername() {
        return "atm_sebastian_bot";
    }

    @Override
    public String getBotToken() {
        return "2020641181:AAEfkBMvD_HizATHvQEiBYA5g5XrHCR9Gw8";
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }

    @Override
    public void onUpdateReceived(Update update) {
        String telegramId = update.getMessage().getChatId().toString();
        System.out.println(telegramId + "class:"+ this + " | thread:"+ Thread.currentThread().getId()+ " | update:"+update);
        HashMap parametros = new HashMap();
        parametros.put("telegramId",telegramId);
        parametros.put("mapaClientes", this.mapaClientes);
        if (update.hasMessage() && update.getMessage().hasText()) {
            parametros.put("inputMessage", update.getMessage().getText());
            //Verifica si existe algun proceso
            Proceso proceso = this.existeProceso(telegramId);
            //Si es la primera interaccion con el bot
            if(proceso==null){
                proceso = new Proceso();
                proceso.setNodoActual(this.getNodoRaiz());
                this.mapaProcesosEjecucion.put(telegramId,new ArrayList());
                this.mapaProcesosEjecucion.get(telegramId).add(proceso);
            }
            // colocar en parametros al cliente si existe
            parametros.put("cliente",(proceso.getCliente()==null)?null:proceso.getCliente());
            parametros.put("nodoAnterior",(proceso.getNodoAnterior()==null)?null:proceso.getNodoAnterior());
            parametros.put("cuentaSeleccionada",proceso.getCuentaSeleccionada());
            Nodo nodoSiguiente = proceso.getNodoActual().run(parametros);
            if (nodoSiguiente == null) {
                this.eliminarProceso(telegramId);
            }
            Proceso nuevoProceso = new Proceso();

            nuevoProceso.setNodoActual(nodoSiguiente);
            nuevoProceso.setNodoAnterior(proceso.getNodoActual());
            nuevoProceso.setCuentaSeleccionada((Cuenta)parametros.get("cuentaSeleccionada"));

            nuevoProceso.setCliente(proceso.getNodoActual().buscarCliente(mapaClientes,telegramId));
            this.mapaProcesosEjecucion.get(telegramId).add(nuevoProceso);
            SendMessage message = new SendMessage();

            String [] arrString = new String[2];
            arrString[0]=(nuevoProceso.getCliente()==null)?"":nuevoProceso.getCliente().getName();
            arrString[1]="dos" ;
            message.setChatId(telegramId);//Define a quien se mandara el mensaje
            message.setText(nuevoProceso.getNodoActual().getMensaje(arrString)); //El mensaje es guardado

            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        }

    }
    private Nodo getNodoRaiz() {
        Nodo nodoRaiz = new NodoRaiz();

        Nodo nodoRegistrarNombre = new NodoRegistrarNombre("Bienvenido!, he notado que aún no eres cliente, ¿cuál es tu nombre completo?");

        nodoRaiz.getNodosSiguientes().put(0, nodoRegistrarNombre);

        Nodo registrarPin = new NodoRegistrarPin("Registra tu PIN.");

        nodoRegistrarNombre.getNodosSiguientes().put(0, registrarPin);

        Nodo nodoVerificarPin = new NodoVerificarPin("Bienvenido {0}. Ingresa tu PIN.");

        nodoRaiz.getNodosSiguientes().put(1, nodoVerificarPin);

        return nodoRaiz;
    }
    public void iniciar(){
        this.mapaClientes =  new HashMap<String,Cliente>();
        if (modoPrueba) {
            Cliente clientePrueba = this.crearClientePrueba();
            this.mapaClientes.put(clientePrueba.getIdCliente(), clientePrueba);
        }
    }
    public Cliente crearClientePrueba(){
        Cliente cliente =  new Cliente("928274103","Sebastian","123");
        Cuenta cuenta = new Cuenta("Bolivianos","Cuenta Corriente",5000.50);
        cliente.registrarNuevaCuenta(cuenta);
        return cliente;
    }
    private Proceso existeProceso(String telegramId){
        List<Proceso> listaProcesos = this.mapaProcesosEjecucion.get(telegramId);
        if(listaProcesos!=null){
            int tamLista = listaProcesos.size();
            if (tamLista>0) {
                return listaProcesos.get(listaProcesos.size() - 1);
            }
            else{
                return null;
            }
        }
        else{
            return null;
        }
    }
    private void eliminarProceso(String telegramId){
        List<Proceso> listaProcesos = this.mapaProcesosEjecucion.get(telegramId);
        if(listaProcesos!=null){
            this.mapaProcesosEjecucion.remove(telegramId);
        }
    }
}

