package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import entidad.Libro;
import util.MySqlDBConexion;

public class LibroModel {
	
	private static Logger Log = Logger.getLogger(LibroModel.class.getName());

	//LISTA TODOS
			public List<Libro> listaTodos(){
				ArrayList<Libro> salida = new ArrayList<Libro>();

				Connection conn = null;
				PreparedStatement psmt = null;
				ResultSet rs = null;
				try {
					//1 Se crea la conexion
					conn = MySqlDBConexion.getConexion();

					//2 Se prepara el SQL
					String sql = "select * from libro";
					psmt = conn.prepareStatement(sql);
					
					Log.info(">>> " + psmt);
					
					//3 Se ejecuta el SQL en la base de datos
					rs = psmt.executeQuery();
					Libro obj = null;
					while(rs.next()) {
						obj = new Libro();
						obj.setID(rs.getInt(1));
						obj.setTituto(rs.getString(2));
						obj.setAño(rs.getInt(3));
						obj.setCategoria(rs.getString(4));
						obj.setSerie(rs.getString(5));
						obj.setFec_reg(rs.getDate(6));
						obj.setPais(rs.getString(7));
						obj.setTipo(rs.getString(8));
						salida.add(obj);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if (rs != null) rs.close();
						if (psmt != null) psmt.close();
						if (conn != null) conn.close();
					} catch (Exception e2) {}
				}
				return salida;
			}

	//LISTAR AUTOR POR NOMBRE O APELLIDO
			public List<Libro> ConsultaPorTituloCategoria(String titulo, String categoria){
					ArrayList<Libro> data = new ArrayList<Libro>();
					
					Connection conn = null;
					PreparedStatement psmt = null;
					ResultSet rs = null;					try {
						//1 Se crea la conexion
						conn = MySqlDBConexion.getConexion();
						
						//2 Se prepara el SQL
						String sql = "select * from libro "
								+"where (titulo like ?) "
								+"and (categoria like ?)";
							
						psmt = conn.prepareStatement(sql);
						psmt.setString(1, "%" + titulo + "%");
						psmt.setString(2, "%" + categoria + "%");
							
						System.out.println("SQL --> " + psmt);
						
						//3 Se ejecuta el SQL en la base de datos
						rs = psmt.executeQuery();
						
						//
						Libro obj = null;
						while(rs.next()){
							obj = new Libro();
							obj.setID(rs.getInt("idLibro"));
							obj.setTituto(rs.getString("titulo"));
							obj.setAño(rs.getInt("anio"));
							obj.setCategoria(rs.getString("categoria"));
							obj.setSerie(rs.getString("serie"));
							obj.setFec_reg(rs.getDate("fechaRegistro"));
							obj.setPais(rs.getString("pais"));
							obj.setTipo(rs.getString("tipo"));
							data.add(obj);
						}
							
					    } catch (Exception e) {
						e.printStackTrace();
					    } finally {
						try {
							if (rs != null) rs.close();
							if (psmt != null) psmt.close();
							if (conn != null) conn.close();
						    } catch (Exception e2) {}
					    }
					    return data;
				}

	// INSERTAR
			public int insertaLibro(Libro obj) {
				int salida = -1;
				Connection conn = null;
				PreparedStatement pstm = null;
				
				try {
					conn = MySqlDBConexion.getConexion();
					
					String sql = "insert into libro value(null,?,?,?,?,curtime(),?,?)";
					pstm = conn.prepareStatement(sql);
					pstm.setString(1, obj.getTituto());
					pstm.setInt(2, obj.getAño());
					pstm.setString(3, obj.getCategoria());
					pstm.setString(4, obj.getSerie());
					pstm.setString(5, obj.getPais());
					pstm.setString(6, obj.getTipo());
					Log.info(">>> "+ pstm);
					
					salida = pstm.executeUpdate();
						
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					try {
						if(pstm !=null) pstm.close();
						if(conn !=null) conn.close();
						
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}	
				return salida;
			}
	
	// ACTUALIZAR
			public int actualizaLibro(Libro obj) {
				int actualizados = -1;
				Connection conn = null;
				PreparedStatement pstm = null;
				
				try {
					conn = MySqlDBConexion.getConexion();
					
					String sql = "update libro set titulo=?, anio=?, categoria=?, serie=?, pais=?, tipo=? where idLibro=?";
					pstm = conn.prepareStatement(sql);
					pstm.setString(1, obj.getTituto());
					pstm.setInt(2, obj.getAño());
					pstm.setString(3, obj.getCategoria());
					pstm.setString(4, obj.getSerie());
					pstm.setString(5, obj.getPais());
					pstm.setString(6, obj.getTipo());
					pstm.setInt(7, obj.getID());
					
					Log.info(">>> "+ pstm);
					
					actualizados = pstm.executeUpdate();
						
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					try {
						if(pstm !=null) pstm.close();
						if(conn !=null) conn.close();
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}	
				return actualizados;
			}
	
	// ELIMINAR
			public int eliminaLibro(int ID) {
				int eliminados = -1;
				Connection con = null;
				PreparedStatement pstm = null;
				
				try {
					con = MySqlDBConexion.getConexion();
			
					String sql ="delete from libro where idLibro=?";
					pstm = con.prepareStatement(sql);
					pstm.setInt(1, ID);
					Log.info(">>> "+ pstm);
					
					eliminados = pstm.executeUpdate();
						
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					try {
						if (pstm != null)pstm.close();
						if (con != null)con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}	
				return eliminados;
			}
		
	//LISTAR AUTOR POR NOMBRE O APELLIDO
			public List<Libro> ReporteLibro(String titulo, String categoria){
					ArrayList<Libro> data = new ArrayList<Libro>();
					
					Connection conn = null;
					PreparedStatement psmt = null;
					ResultSet rs = null;					try {
						//1 Se crea la conexion
						conn = MySqlDBConexion.getConexion();
						
						//2 Se prepara el SQL
						String sql = "select idLibro,titulo,anio,categoria,serie,pais,tipo from libro "
								+"where (titulo like ?) "
								+"and (categoria like ?)";
							
						psmt = conn.prepareStatement(sql);
						psmt.setString(1, "%" + titulo + "%");
						psmt.setString(2, "%" + categoria + "%");
							
						System.out.println("SQL --> " + psmt);
						
						//3 Se ejecuta el SQL en la base de datos
						rs = psmt.executeQuery();
						
						//
						Libro obj = null;
						while(rs.next()){
							obj = new Libro();
							obj.setID(rs.getInt("idLibro"));
							obj.setTituto(rs.getString("titulo"));
							obj.setAño(rs.getInt("anio"));
							obj.setCategoria(rs.getString("categoria"));
							obj.setSerie(rs.getString("serie"));
							obj.setPais(rs.getString("pais"));
							obj.setTipo(rs.getString("tipo"));
							data.add(obj);
						}
							
					    } catch (Exception e) {
						e.printStackTrace();
					    } finally {
						try {
							if (rs != null) rs.close();
							if (psmt != null) psmt.close();
							if (conn != null) conn.close();
						    } catch (Exception e2) {}
					    }
					    return data;
				}
}
