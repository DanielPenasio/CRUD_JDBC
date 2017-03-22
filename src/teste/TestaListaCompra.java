package teste;

import DAO.ClienteDAO;
import DAO.CompraDAO;
import DAO.ProdutoDAO;
import java.util.List;
import modelo.Compra;

/**
 *
 * Daniel Penasio - dpenasio@gmail.com RA-266674
 */
public class TestaListaCompra {

    public static void main(String[] args) {
        CompraDAO dao = new CompraDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();

        List<Compra> compras = dao.getLista();
        for (Compra compra : compras){
            System.out.println("ID da compra: " + compra.getId());
            System.out.println("Cliente: " + clienteDAO.buscaId(compra.getClienteId()).getNome());
            System.out.println("Produto: " + produtoDAO.buscaId(compra.getProdutoId()).getNome() + "\n");
        }
    }
}
