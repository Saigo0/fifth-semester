import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Logger simples usado por todos os serviços.
 */
public class Logger {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final String contexto;

    public Logger(String contexto) {
        this.contexto = contexto;
    }

    public void info(String mensagem) {
        System.out.printf("[%s] [INFO] [%s] %s%n",
                LocalDateTime.now().format(FORMATTER), contexto, mensagem);
    }

    public void error(String mensagem) {
        System.out.printf("[%s] [ERROR] [%s] %s%n",
                LocalDateTime.now().format(FORMATTER), contexto, mensagem);
    }
}