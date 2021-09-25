package bo.edu.ucb.est;

import bo.edu.ucb.est.Modelo.Banco;
import bo.edu.ucb.est.Modelo.Cliente;
import bo.edu.ucb.est.Modelo.Cuenta;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


public class App 
{
    public static void main( String[] args )
    {
        Banco BancoRex = new Banco("Banco Rex", "BR","18279301","Av. Jurasico");

        /*Cliente jperez = new Cliente("0000","Juan Perez", "3333");
        Cuenta cta1Jperez = new Cuenta("111122","BOB","Caja de ahorros",12000.0);
        jperez.agregarCuenta(cta1Jperez); // Se agrega una cuenta de Jperez
        Cuenta cta2Jperez = new Cuenta("112211","USD","Cuenta corriente",100.0);
        jperez.agregarCuenta(cta2Jperez);

        Cliente mariaGomez = new Cliente("1111","Maria Gomez","4444");
        Cuenta cta1Maria = new Cuenta("221122","BOB", "Caja de ahorros", 0.0);
        mariaGomez.agregarCuenta(cta1Maria);

        Cliente carlosGomez = new Cliente("2222","Carlos Gomez","4444");
        Cuenta cta1Carlos = new Cuenta("331122","BOB","Caja ahorros",100.0);
        carlosGomez.agregarCuenta(cta1Carlos);
        Cuenta cta2Carlos = new Cuenta("332211","USD","Cuenta corriente",1000.0);
        carlosGomez.agregarCuenta(cta2Carlos);
        Cuenta cta3Carlos = new Cuenta("332233","BOB","Caja ahorros",100000.0);
        carlosGomez.agregarCuenta(cta3Carlos);*/



        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new AtmBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
