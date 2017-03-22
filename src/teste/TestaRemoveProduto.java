package teste;

import DAO.ProdutoDAO;
import modelo.Produto;

/**
 *
 * Daniel Penasio - dpenasio@gmail.com RA-266674
 */
public class TestaRemoveProduto {
    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAO();
        Produto p1 = new Produto();
        
        p1.setId(2L);
        dao.remove(p1);
        
        System.out.println("Produto removido");
    }
}
