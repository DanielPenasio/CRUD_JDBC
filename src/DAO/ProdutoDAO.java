package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import jdbc.ConnectionFactory;
import modelo.Produto;

/**
 *
 * Daniel Penasio - dpenasio@gmail.com RA-266674
 */
public class ProdutoDAO {

    // conexão com o banco
    private Connection connection;

    // passando pelo construtor para que sempre que instanciar esse DAO venha 
    // com uma conexão pronta da Factory
    public ProdutoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    // =========== Métodos do CRUD =================
    // Adiciona produto
    public void adiciona(Produto produto) {
        //Adiciona no banco
        String sql = "insert into produtos (nome,preco,tipo,dataValidade,quantidade) values (?,?,?,?,?)";
        try {
            // Prepared Statement da inserção
            PreparedStatement stmt = connection.prepareStatement(sql);
            // seta os valores
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setString(3, produto.getTipo());
            stmt.setDate(4, new Date(produto.getDataValidade().getTimeInMillis()));
            stmt.setInt(5, produto.getQuantidade());
            
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Lista produtos
    public List<Produto> getLista() {
        try {
            // Cria um Array de produtos
            List<Produto> produtos = new ArrayList<>();
            // busca na tabela
            String sql = "select * from produtos";
            // prepared statement para busca
            PreparedStatement stmt = connection.prepareStatement(sql);
            // executa o PS com o retorno um ResultSet
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // instanciando
                Produto produto = new Produto();
                //setando valores
                produto.setId(rs.getLong("id"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setTipo(rs.getString("tipo"));
                // Seta a data de validade fazendo a conversão
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("dataValidade"));
                produto.setDataValidade(data);
                produto.setQuantidade(rs.getInt("quantidade"));
                
                // adiciona o produto no array de produtos
                produtos.add(produto);
            }

            stmt.close();
            rs.close();
            return produtos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Lista produtos por id
    public Produto buscaId(Long id) {
        try {
            // busca na tabela
            String sql = "select * from produtos where id=?";
            // prepared statement para busca
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            // executa o PS com o retorno um ResultSet
            ResultSet rs = stmt.executeQuery();
            // instanciando
            Produto produto = new Produto();
            while (rs.next()) {

                //setando valores
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setTipo(rs.getString("tipo"));
                // Seta a data de validade fazendo a conversão
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("dataValidade"));
                produto.setDataValidade(data);
                produto.setQuantidade(rs.getInt("quantidade"));
            }

            stmt.close();
            rs.close();
            return produto;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Altera Produto por ID
    public void altera(Produto produto) {
        //Altera no banco
        String sql = "update produtos set nome=?, preco=?, tipo=?,"
                + " dataValidade=?, quantidade=? where id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setString(3, produto.getTipo());
            stmt.setDate(4, new Date(produto.getDataValidade().getTimeInMillis()));
            stmt.setInt(5, produto.getQuantidade());
            stmt.setLong(6, produto.getId());
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Remove produto por ID
    public void remove(Produto produto) {
        try {
            // Deleta do banco
            String sql = "delete from produtos where id=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, produto.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
