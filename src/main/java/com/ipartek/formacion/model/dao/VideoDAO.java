package com.ipartek.formacion.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.model.ConnectionManager;
import com.ipartek.formacion.model.pojo.Video;

public class VideoDAO {

	private static VideoDAO INSTANCE = null;

	private VideoDAO() {
		super();
	}

	public static VideoDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new VideoDAO();
		}
		return INSTANCE;
	}

	public ArrayList<Video> getAll() {

		ArrayList<Video> lista = new ArrayList<Video>();
		String sql = "SELECT `id`, `nombre`, `codigo` FROM `video` ORDER BY `id` DESC LIMIT 500";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				Video v = new Video();
				v.setId(rs.getInt("id"));
				v.setNombre(rs.getString("nombre"));
				v.setCodigo(rs.getString("codigo"));
				lista.add(v);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return lista;
	}

	public Video getById(int id) {
		Video video = new Video();
		String sql = "SELECT `id`, `nombre`, `codigo` FROM `video` WHERE `id` = ?;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					video.setId(rs.getInt("id"));
					video.setNombre(rs.getString("nombre"));
					video.setCodigo(rs.getString("codigo"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return video;
	}

	public boolean crear(Video pojo) {
		boolean resultado = false;
		String sql = "INSERT INTO `video` (`nombre`, `codigo`) VALUES (?,?);";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getCodigo());

			if (pst.executeUpdate() == 1) {
				resultado = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultado;
	}

	public boolean modificar(Video pojo) {
		boolean resultado = false;

		String sql = "UPDATE `video` SET `nombre`= ?, `codigo`= ? WHERE `id`= ?;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getCodigo());
			pst.setInt(3, pojo.getId());
			pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}

	public boolean delete(int id) {
		boolean resultado = false;
		String sql = "DELETE FROM `video` WHERE `id`= ?;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setInt(1, id);

			int affetedRows = pst.executeUpdate();
			if (affetedRows == 1) {
				resultado = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultado;
	}
	/*
	 * private boolean doSave(PreparedStatement pst, Video pojo){ boolean resultado
	 * = false;
	 * 
	 * try { int affectedRows = pst.executeUpdate(); if (affectedRows == 1) { try
	 * (ResultSet generatedKeys = pst.getGeneratedKeys()) { if
	 * (generatedKeys.next()) { pojo.setId(generatedKeys.getInt(1)); } } resultado =
	 * true; } } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * return resultado; }
	 * 
	 * public ArrayList<Rol> getByName(String search) {
	 * 
	 * ArrayList<Rol> lista = new ArrayList<Rol>(); String sql =
	 * "SELECT id, nombre FROM rol WHERE nombre LIKE ? ORDER BY id DESC LIMIT 500;";
	 * 
	 * try (Connection con = ConnectionManager.getConnection(); PreparedStatement
	 * pst = con.prepareStatement(sql)) { pst.setString(1, "%" + search + "%"); try
	 * (ResultSet rs = pst.executeQuery()) { while (rs.next()) {
	 * lista.add(mapper(rs)); } } } catch (Exception e) { e.printStackTrace(); }
	 * return lista; }
	 * 
	 * public boolean save(Rol pojo) throws SQLException { boolean resultado =
	 * false;
	 * 
	 * if (pojo != null) { // Sanitize nombre
	 * pojo.setNombre(Utilidades.limpiarEspacios(pojo.getNombre()));
	 * 
	 * if (pojo.getId() == -1) { resultado = crear(pojo); } else { resultado =
	 * modificar(pojo); } }
	 * 
	 * return resultado; }
	 */
}
