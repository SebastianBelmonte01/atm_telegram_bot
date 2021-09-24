package bo.edu.ucb.est.UI;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;
import java.util.List;

public class Pantalla {
    private String titulo;
    private List<String> contenidoPantalla;

    //Valores que se solicitaran al cliente
    private List<String> inputString; //Etiquetas cuando el usuario elija una opcion
    private List<String> dataType;
    private List<Object> valores;



    public Pantalla(String titulo) {
        this.titulo = titulo;
        this.contenidoPantalla = new ArrayList();
        this.inputString = new ArrayList();
        this.dataType = new ArrayList();
        this.valores = new ArrayList();
    }

    public void definirDatoEntrada(String mensaje, String tipoDato){
        this.inputString.add(mensaje);
        this.dataType.add(tipoDato);
    }
    public void setContenido(List<String> contenidoPantalla){
        this.contenidoPantalla = contenidoPantalla;

    }

    public String desplegarMenuOpciones(){
        String mensajeBot = null;
        //Muestra un menu de opciones
        for(int i = 0; i < contenidoPantalla.size(); i++){
            mensajeBot = contenidoPantalla.get(i) + "\n";
        }
        return  mensajeBot;
    }
    public String desplegarMensajesEntrada(Update mensajeUsuario){
        String mensajeBot = null;
        for(int i = 0; i < inputString.size(); i++){
            mensajeBot = inputString.get(i);
            if(dataType.get(i).equals("String")){
                valores.add(mensajeUsuario.getMessage().getText());
            }
            else if(dataType.get(i).equals("Integer")){
                valores.add(Integer.parseInt(mensajeUsuario.getMessage().getText()));
            }
            else if(dataType.get(i).equals("Double")){
                valores.add(Double.parseDouble(mensajeUsuario.getMessage().getText()));
            }
        }
        return mensajeBot;
    }


}
