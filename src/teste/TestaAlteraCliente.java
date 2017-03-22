package teste;

import DAO.ClienteDAO;
import java.util.List;
import modelo.Cliente;

/**
 *
 * Daniel Penasio - dpenasio@gmail.com RA-266674
 */
public class TestaAlteraCliente {
    public static void main(String[] args) {
        ClienteDAO dao = new ClienteDAO();
        Cliente c1 = new Cliente();
        c1.setNome("Penasio");
        c1.setCpf("11111111111");
        c1.setSexo('m');
        c1.setId(1L);
        
        dao.altera(c1);
        
        System.out.println("Cliente: " + c1.getNome()+ " alterado");
    }
}
