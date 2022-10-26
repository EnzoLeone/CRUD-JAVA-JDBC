
package br.edu.unicid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.unicid.bean.Produto;
import br.edu.unicid.util.ConnectionFactory;

public class ProdutoDAO {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Produto produto;

	public ProdutoDAO() throws Exception {

		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro; \n" + e.getMessage());
		}
	}

//Função de salvar produtos
	public void salvar(Produto produto) throws Exception {
		if (produto == null)
			throw new Exception("O produto passado nao pode ser nulo");
		try {
			String SQL = "INSERT INTO tb_produto (codigo, nome, descricao, quantidade) values (?, ?, ?, ?)";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, produto.getCodigo());
			ps.setString(2, produto.getNome());
			ps.setString(3, produto.getDescricao());
			ps.setInt(4, produto.getQuantidade());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao cadastrar produto " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}

	}

	// Função de atualizar produtos
	public void atualizar(Produto produto) throws Exception {
		if (produto == null)
			throw new Exception("O valor informado nao pode ser nulo");
		try {
			String SQL = "UPDATE tb_produto set nome=?, descricao=?, quantidade=? WHERE codigo = ? ";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(4, produto.getCodigo());
			ps.setString(1, produto.getNome());
			ps.setString(2, produto.getDescricao());
			ps.setInt(3, produto.getQuantidade());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}

	}

	// Função de excluir produtos
	public void excluir(int codigo) throws Exception {
		if (codigo == 0)
			throw new Exception("O valor informado nao pode ser nulo");
		try {
			String SQL = "DELETE FROM tb_produto WHERE codigo = ?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, codigo);
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao excluir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}

	}

	// Procurar produtos
	public Produto procurarProdutos(int codigo) throws Exception {

		try {
			String SQL = "SELECT * FROM tb_produto WHERE codigo = ?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, codigo);
			rs = ps.executeQuery();
			if (rs.next()) {
				int cod = rs.getInt(1);
				String nome = rs.getString(2);
				String descricao = rs.getString(3);
				int quantidade = rs.getInt(4);
				produto = new Produto(cod, nome, descricao, quantidade);
			}
			return produto;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}

	public List<Produto> todosProdutos() throws Exception {
		try {
			conn = this.conn;
			ps = conn.prepareStatement("SELECT * FROM tb_produto");
			rs = ps.executeQuery();
			List<Produto> listar = new ArrayList<Produto>();
			while (rs.next()) {
				int cod = rs.getInt(1);
				String nome = rs.getString(2);
				String descricao = rs.getString(3);
				int quantidade = rs.getInt(4);
				listar.add(new Produto(cod, nome, descricao, quantidade));
			}
			return listar;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
}
