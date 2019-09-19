package br.com.fiap.estacionamento.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.fiap.estacionamento.model.entities.Valet;
import br.com.fiap.estacionamento.model.entities.Veiculo;
import br.com.fiap.estacionamento.model.services.ConnectionFactory;

public class ValetDAO {

	public List<Valet> consultarPatio() {
		List<Valet> valets = new ArrayList<Valet>();

		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("select * from valet where saida is null");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Long id = rs.getLong("id");
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				String placa = rs.getString("placa");
				Date entrada = rs.getDate("entrada");
				Valet v = new Valet(new Veiculo(marca, modelo, placa), entrada);
				v.setId(id);
				valets.add(v);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return valets;
	}

	public void registrarEntrada(Valet valet) {
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(
					"insert into valet(id, marca, modelo, placa, entrada) " + "values(?, ?, ?, ?, ?)");

			stmt.setLong(1, this.proximoId());
			stmt.setString(2, valet.getVeiculo().getMarca());
			stmt.setString(3, valet.getVeiculo().getModelo());
			stmt.setString(4, valet.getVeiculo().getPlaca());
			stmt.setDate(5, new java.sql.Date(valet.getEntrada().getTime()));

			stmt.execute();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	private Long proximoId() {
		Long id = 0l;

		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("select * from valet");
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
				id++;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return id + 1;
	}

	public Valet registrarSaida(Long id) {
		Valet v = null;

		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("update valet set saida = ? where id = ? ");

			stmt.setDate(1, new java.sql.Date(new Date().getTime()));
			stmt.setLong(2, id);

			stmt.executeUpdate();
			
			v = this.consultarPorId(id);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return v;
	}

	public Valet consultarPorId(Long id) {
		Valet v = null;

		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("select * from valet where id = ?");

			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				id = rs.getLong("id");
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				String placa = rs.getString("placa");
				Date entrada = rs.getDate("entrada");
				Date saida = rs.getDate("saida");
				v = new Valet(new Veiculo(marca, modelo, placa), entrada);
				v.setId(id);
				v.setSaida(saida);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return v;
	}

}
