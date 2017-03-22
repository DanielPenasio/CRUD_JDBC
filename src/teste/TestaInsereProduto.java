package teste;

import DAO.ProdutoDAO;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import modelo.Produto;

/**
 *
 * Daniel Penasio - dpenasio@gmail.com RA-266674
 */
public class TestaInsereProduto {

    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAO();
        Produto p1 = new Produto();
        p1.setNome("vassoura");
        p1.setPreco(2.50);
        p1.setTipo("Material de Limpeza");
        p1.setQuantidade(10);

        //data de validade a ser inserida
        String dataTexto = "20/12/2022";
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

        dao.adiciona(p1);

    }
}
