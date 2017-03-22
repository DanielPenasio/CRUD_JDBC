package teste;

import DAO.CompraDAO;
import modelo.Compra;

/**
 *
 * Daniel Penasio - dpenasio@gmail.com RA-266674
 */
public class TestaRemoveCompra {
    public static void main(String[] args) {
        CompraDAO compraDAO = new CompraDAO();
        Compra compra = new Compra();
        compra.setId(2L);
        compraDAO.remove(compra);
    }
}
