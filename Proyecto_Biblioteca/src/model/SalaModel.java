package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import entidad.Sala;
import util.MySqlDBConexion;

public class SalaModel {
	
	private static Logger Log = Logger.getLogger(SalaModel.class.getName());
	
	//LISTA TODOS
		public List<Sala> listaTodos(){
				ArrayList<Sala> salida = new ArrayList<Sala>();

				Connection conn = null;
				PreparedStatement psmt = null;
				ResultSet rs = null;
				try {
					//1 Se crea la conexion
					conn = MySqlDBConexion.getConexion();

					//2 Se prepara el SQL
					String sql = "select * from sala";
					psmt = conn.prepareStatement(sql);
					
					Log.info(">>> " + psmt);
					
					//3 Se ejecuta el SQL en la base de datos
					rs = psmt.executeQuery();
					Sala obj = null;
					while(rs.next()) {
						obj = new Sala();
						obj.setID(rs.getInt(1));
						obj.setNumero(rs.getString(2));
						obj.setPiso(rs.getString(3));
						obj.setNumAlumnos(rs.getString(4));
						obj.setRecursos(rs.getString(5));
						obj.setEstado(rs.getInt(6));
						obj.setFec_reg(rs.getDate(7));
						obj.setSede(rs.getString(8));
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
		public List<Sala> ConsultaPorNumeroSede(String numero, String sede){
					ArrayList<Sala> data = new ArrayList<Sala>();
					
					Connection conn = null;
					PreparedStatement psmt = null;
					ResultSet rs = null;					try {
						//1 Se crea la conexion
						conn = MySqlDBConexion.getConexion();
						
						//2 Se prepara el SQL
						String sql = "select * from sala "
								+"where (numero like ?) "
								+"and (sede like ?)";
							
						psmt = conn.prepareStatement(sql);
						psmt.setString(1, "%" + numero + "%");
						psmt.setString(2, "%" + sede + "%");
							
						System.out.println("SQL --> " + psmt);
						
						//3 Se ejecuta el SQL en la base de datos
						rs = psmt.executeQuery();
						
						//
						Sala obj = null;
						while(rs.next()){
							obj = new Sala();
							obj.setID(rs.getInt("idSala"));
							obj.setNumero(rs.getString("numero"));
							obj.setPiso(rs.getString("piso"));
							obj.setNumAlumnos(rs.getString("numAlumnos"));
							obj.setRecursos(rs.getString("recursos"));
							obj.setEstado(rs.getInt("estado"));
							obj.setFec_reg(rs.getDate("fechaRegistro"));
							obj.setSede(rs.getString("sede"));
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

	//INSERTAR
		public int insertaSala(Sala obj) {
				int salida = -1;
				Connection conn = null;
				PreparedStatement pstm = null;
				
				try {
					conn = MySqlDBConexion.getConexion();
					
					String sql = "insert into sala value(null,?,?,?,?,?,curtime(),?)";
					pstm = conn.prepareStatement(sql);
					pstm.setString(1, obj.getNumero());
					pstm.setString(2, obj.getPiso());
					pstm.setString(3, obj.getNumAlumnos());
					pstm.setString(4, obj.getRecursos());
					pstm.setInt(5, obj.getEstado());
					pstm.setString(6, obj.getSede());
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
			
	//ELIMINAR
		public int eliminaSala(int ID) {
			int eliminados = -1;
			Connection con = null;
			PreparedStatement pstm = null;
			
			try {
				con = MySqlDBConexion.getConexion();
		
				String sql ="delete from sala where idSala=?";
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
			
	//ACTUALIZAR
		public int actualizaSala(Sala obj) {
			int actualizados = -1;
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				conn = MySqlDBConexion.getConexion();
				
				String sql = "update sala set numero=?, piso=?, numAlumnos=?, recursos=?, estado=?, sede=? where idSala=?";
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, obj.getNumero());
				pstm.setString(2, obj.getPiso());
				pstm.setString(3, obj.getNumAlumnos());
				pstm.setString(4, obj.getRecursos());
				pstm.setInt(5, obj.getEstado());
				pstm.setString(6, obj.getSede());
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
			
}
