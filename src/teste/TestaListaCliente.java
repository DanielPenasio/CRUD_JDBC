package teste;

import DAO.ClienteDAO;
import java.util.List;
import modelo.Cliente;

/**
 *
 * Daniel Penasio - dpenasio@gmail.com RA-266674
 */
public class TestaListaCliente {
    public static void main(String[] args) {
        ClienteDAO dao = new ClienteDAO();
        
        List<Cliente> clientes = dao.getLista();
        for (Cliente cliente : clientes){
            System.out.println("ID: " + cliente.getId());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("cpf: " + cliente.getCpf());
            System.out.println("Sexo: " + cliente.getSexo());
        }
        
    }
}
