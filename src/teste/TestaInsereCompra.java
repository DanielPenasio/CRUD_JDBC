package teste;

import DAO.CompraDAO;
import modelo.Cliente;
import modelo.Compra;

/**
 *
 * Daniel Penasio - dpenasio@gmail.com RA-266674
 */
public class TestaInsereCompra {
    public static void main(String[] args) {
        CompraDAO dao = new CompraDAO();
        
        Compra compra = new Compra();
                
        compra.setClienteId(5L);
        compra.setProdutoId(3L);
        compra.setQuantidade(3);
        
        dao.adiciona(compra);
        
        System.out.println("Compra gravada");
        
    }
}
