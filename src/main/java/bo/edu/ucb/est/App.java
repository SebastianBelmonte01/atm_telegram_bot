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
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new AtmBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
