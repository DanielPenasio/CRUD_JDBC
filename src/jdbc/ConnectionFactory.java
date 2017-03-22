package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * Daniel Penasio - dpenasio@gmail.com RA-266674
 */
// Classe responsável por abrir uma conexão. *Design Pattern*
public class ConnectionFactory {

    //Método getConnection responsável por criar conexões.
    public Connection getConnection() {

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "12345");
        properties.setProperty("useSSL", "false");
        properties.setProperty("autoReconnect", "true");

        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/SCS_PS_IND_06",
                    properties);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
