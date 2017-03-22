package teste;

import DAO.ProdutoDAO;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import modelo.Produto;

/**
 *
 * Daniel Penasio - dpenasio@gmail.com RA-266674
 */
public class TestaAlteraProduto {
    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAO();
        Produto p1 = new Produto();
        p1.setNome("Coca-cola");
        p1.setPreco(5.50);
        p1.setTipo("Refrigerante");
        p1.setQuantidade(25);

        //data de validade a ser inserida
        String dataTexto = "10/02/2018";
        Calendar dataValidade = null;
        //Convertendo a data
        try {
            Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataTexto);
            dataValidade = Calendar.getInstance();
            dataValidade.setTime(data);

        } catch (java.text.ParseException e) {
            System.out.println("Erro data");
        }
        //setando a data
        p1.setDataValidade(dataValidade);
        p1.setId(1L);

        dao.altera(p1);
        System.out.println("Produto: " +p1.getNome()+ " alterado." );
    }
}
