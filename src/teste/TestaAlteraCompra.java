package teste;

import DAO.CompraDAO;
import modelo.Compra;

/**
 *
 * Daniel Penasio - dpenasio@gmail.com RA-266674
 */
public class TestaAlteraCompra {

    public static void main(String[] args) {
        CompraDAO compraDAO = new CompraDAO();
        Compra compra = new Compra();

        compra.setClienteId(3L);
        compra.setProdutoId(3L);
        compra.setId(1L);

        compraDAO.altera(compra);

    }
}
