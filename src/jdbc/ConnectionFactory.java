package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * Daniel Penasio - dpenasio@gmail.com RA-266674
 */
// Classe responsável por abrir uma conexão. *Design Pattern*
public class ConnectionFactory {

    //Método getConnection responsável por criar conexões.
    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/SCS_PS_IND_06",
                    "root", "12345");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
