package teste;

import DAO.ClienteDAO;
import modelo.Cliente;

/**
 *
 * Daniel Penasio - dpenasio@gmail.com RA-266674
 */
public class TestaInsereCliente {
    public static void main(String[] args) {
        ClienteDAO dao = new ClienteDAO();
        Cliente c1 = new Cliente();
        c1.setNome("Leticia");
        c1.setCpf("00000000");
        c1.setSexo('f');
        
        dao.adiciona(c1);
        
        System.out.println("Gravado");
    }
}
