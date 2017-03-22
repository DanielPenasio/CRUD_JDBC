package teste;

import DAO.ClienteDAO;
import modelo.Cliente;

/**
 *
 * Daniel Penasio - dpenasio@gmail.com RA-266674
 */
public class TestaRemoveCliente {

    public static void main(String[] args) {

        ClienteDAO dao = new ClienteDAO();

        Cliente c1 = new Cliente();
        
        c1.setId(4L);
        
        dao.remove(c1);
        
        System.out.println("Cliente removido.");

    }
}
