package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.ConnectionFactory;
import modelo.Compra;

/**
 *
 * Daniel Penasio - dpenasio@gmail.com RA-266674
 */
public class CompraDAO {

    // conexão com o banco
    private Connection connection;

    public CompraDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    // =========== Métodos do CRUD =================
    //Adiciona uma compra
    public void adiciona(Compra compra) {
        String sql = "insert into compras (clienteId, produtoId) values(?,?)";
        try {
            //usando RETURN_GENERATED_KEYS pra recuperar a PK das tabelas de referências
            PreparedStatement stmt = connection.prepareStatement(sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            stmt.setLong(1, compra.getClienteId());
            stmt.setLong(2, compra.getProdutoId());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Lista de compras
    public List<Compra> getLista() {
        try {
            List<Compra> compras = new ArrayList<>();
            String sql = "select * from compras";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Compra compra = new Compra();
                compra.setId(rs.getLong("id"));
                compra.setClienteId(rs.getLong("clienteId"));
                compra.setProdutoId(rs.getLong("produtoId"));

                compras.add(compra);
            }

            stmt.close();
            rs.close();
            return compras;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Altera compra por id
    public void altera(Compra compra) {
        String sql = "update compras set clienteId=?, produtoId=? where id=?";
        try {
            //usando RETURN_GENERATED_KEYS pra recuperar a PK das tabelas de referências
            PreparedStatement stmt = connection.prepareStatement(sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            stmt.setLong(1, compra.getClienteId());
            stmt.setLong(2, compra.getProdutoId());
            stmt.setLong(3, compra.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Remove Compra
    public void remove(Compra compra) {
        String sql = "delete from compras where id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, compra.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
