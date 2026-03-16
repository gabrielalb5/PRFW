package edu.ifsp.loja.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import edu.ifsp.loja.modelo.Produto;

@Repository
public class ProdutoRepositorioJdbc implements ProdutoRepositorio{
	private JdbcTemplate jdbc;
	
	public ProdutoRepositorioJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	@Override
	public Produto findById(int id) {
		return jdbc.queryForObject("SELECT id, descricao, preco FROM produto WHERE id = ?",this::mapRow, id);
	}

	@Override
	public Iterable<Produto> findAll() {
		return jdbc.query("SELECT id, descricao, preco FROM produto", this::mapRow);
	}
	
	private Produto mapRow(ResultSet rs, int rowNum) throws SQLException{
		Produto produto = new Produto();
		produto.setId(rs.getInt("id"));
		produto.setDescricao(rs.getString("descricao"));
		produto.setPreco(rs.getDouble("preco"));
		
		return produto;
	}

	@Override
	public Produto save(Produto produto) {
		if(produto.getId()>0) {
			update(produto);
		}else {
			insert(produto);
		}
		return produto;
	}
	
	private void update(Produto produto) {
		jdbc.update("UPDATE produto SET descricao = ?, preco = ? WHERE id = ?",produto.getDescricao(),produto.getPreco(),produto.getId());
	}
	
	private void insert(Produto produto) {
		KeyHolder holder = new GeneratedKeyHolder();
		jdbc.update(conn -> {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO produto (descricao,preco) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, produto.getDescricao());
			ps.setDouble(2, produto.getPreco());
			return ps;
		},holder);
		
		produto.setId(holder.getKey().intValue());
	}
}