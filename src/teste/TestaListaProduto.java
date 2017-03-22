package teste;

import DAO.ProdutoDAO;
import java.text.SimpleDateFormat;
import java.util.List;
import modelo.Produto;

/**
 *
 * Daniel Penasio - dpenasio@gmail.com RA-266674
 */
public class TestaListaProduto {

    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAO();
        //Cria array de produtos
        List<Produto> produtos = dao.getLista();
        // conversão da data do banco
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Produto produto : produtos) {
            System.out.println("ID: " + produto.getId());
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Preço: RS" + produto.getPreco());
            System.out.println("Tipo: " + produto.getTipo());
            System.out.println("Data de Validade: " 
                    +sdf.format(produto.getDataValidade().getTime()) +"\n");
            System.out.println("Quantidade: " + produto.getQuantidade());
        }

    }
}
