package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.ConnectionFactory;
import modelo.Cliente;

/**
 *
 * Daniel Penasio - dpenasio@gmail.com RA-266674
 */
public class ClienteDAO {

    // conexão com o banco
    private Connection connection;

    // passando pelo construtor para que sempre que instanciar esse DAO venha 
    // com uma conexão pronta da Factory
    public ClienteDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    // =========== Métodos do CRUD =================
    // Adiciona clinete
    public void adiciona(Cliente cliente) {
        // insere na tabela clientes do banco
        String sql = "insert into clientes (nome,cpf,sexo) values(?,?,?)";

        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, String.valueOf(cliente.getSexo()));

            // executa
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    // Lista clientes
    public List<Cliente> getLista() {
        try {
            // Cria um Array de clientes
            List<Cliente> clientes = new ArrayList<>();
            // busca na tabela
            String sql = "select * from clientes";
            // prepared statement para busca
            PreparedStatement stmt = connection.prepareStatement(sql);
            // executa o PS com o retorno um ResultSet
            ResultSet rs = stmt.executeQuery();

            // Montando o objeto cliente consultado
            while (rs.next()) {
                // instanciando
                Cliente cliente = new Cliente();
                //setando valores
                cliente.setId(rs.getLong("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                //Sexo é char, que nao funciona com getString, então 
                // atribui o sexo em uma string.
                String charSexo = rs.getString("sexo");
                //seta o sexo em uma variável Char do objeto
                cliente.setSexo(charSexo.charAt(0));
                // adiciona o cliente no array de clientes
                clientes.add(cliente);
            }

            stmt.close();
            rs.close();
            return clientes;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // busca por id
    public Cliente buscaId(Long id) {
        try {
            // Cria um Array de clientes
            //List<Cliente> clientes = new ArrayList<>();
            // busca na tabela
            String sql = "select * from clientes where id=?";
            // prepared statement para busca
            PreparedStatement stmt = connection.prepareStatement(sql);
            //seta o id
            stmt.setLong(1, id);
            // executa o PS com o retorno um ResultSet
            ResultSet rs = stmt.executeQuery();

            // Montando o objeto cliente consultado
            // instanciando
                Cliente cliente = new Cliente();
            while (rs.next()) {
                //setando valores
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                //Sexo é char, que nao funciona com getString, então 
                // atribui o sexo em uma string.
                String charSexo = rs.getString("sexo");
                //seta o sexo em uma variável Char do objeto
                cliente.setSexo(charSexo.charAt(0));
                // adiciona o cliente no array de clientes
                //clientes.add(cliente);
            }

            stmt.close();
            rs.close();
            return cliente;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Altera cliente por ID
    public void altera(Cliente cliente) {
        // altera no banco buscando pelo id
        String sql = "update clientes set nome=?, cpf=?, sexo=? where id=?";
        try {
            //Prepared statement para alteração
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, String.valueOf(cliente.getSexo()));
            stmt.setLong(4, cliente.getId());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    // Remove um cliente pelo ID
    public void remove(Cliente cliente) {
        try {
            // Deleta do banco
            String sql = "delete from clientes where id=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, cliente.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
