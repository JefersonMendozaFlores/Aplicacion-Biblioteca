package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import entidad.Autor;
import util.MySqlDBConexion;

public class AutorModel {
	
	private static Logger Log = Logger.getLogger(AutorModel.class.getName());
	
	//LISTA TODOS
		public List<Autor> listaTodos(){
			ArrayList<Autor> salida = new ArrayList<Autor>();

			Connection conn = null;
			PreparedStatement psmt = null;
			ResultSet rs = null;
			try {
				//1 Se crea la conexion
				conn = MySqlDBConexion.getConexion();

				//2 Se prepara el SQL
				String sql = "select * from autor";
				psmt = conn.prepareStatement(sql);
				
				Log.info(">>> " + psmt);
				
				//3 Se ejecuta el SQL en la base de datos
				rs = psmt.executeQuery();
				Autor obj = null;
				while(rs.next()) {
					obj = new Autor();
					obj.setID(rs.getInt(1));
					obj.setNombres(rs.getString(2));
					obj.setApellidos(rs.getString(3));
					obj.setFec_nac(rs.getDate(4));
					obj.setFec_reg(rs.getDate(5));
					obj.setPais(rs.getString(6));
					obj.setGrado(rs.getString(7));
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
		public List<Autor> ConsultaPorNombreApellido(String nombre, String apellido){
				ArrayList<Autor> data = new ArrayList<Autor>();
				
				Connection conn = null;
				PreparedStatement psmt = null;
				ResultSet rs = null;					try {
					//1 Se crea la conexion
					conn = MySqlDBConexion.getConexion();
					
					//2 Se prepara el SQL
					String sql = "select * from autor "
							+"where (nombres like ?) "
							+"and (apellidos like ?)";
						
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, "%" + nombre + "%");
					psmt.setString(2, "%" + apellido + "%");
						
					System.out.println("SQL --> " + psmt);
					
					//3 Se ejecuta el SQL en la base de datos
					rs = psmt.executeQuery();
					
					//
					Autor obj = null;
					while(rs.next()){
						obj = new Autor();
						obj.setID(rs.getInt("idAutor"));
						obj.setNombres(rs.getString("nombres"));
						obj.setApellidos(rs.getString("apellidos"));
						obj.setFec_nac(rs.getDate("fechaNacimiento"));
						obj.setFec_reg(rs.getDate("fechaRegistro"));
						obj.setPais(rs.getString("pais"));
						obj.setGrado(rs.getString("grado"));
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
	
	// INSERTAR AUTOR
		public int insertaAutor(Autor obj) {
			int salida = -1;
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				conn = MySqlDBConexion.getConexion();
				
				String sql = "insert into autor value(null,?,?,?,curtime(),?,?)";
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, obj.getNombres());
				pstm.setString(2, obj.getApellidos());
				pstm.setDate(3, (Date) obj.getFec_nac());
				pstm.setString(4, obj.getPais());
				pstm.setString(5, obj.getGrado());
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
	//ELIMINAR AUTOR
		public int eliminaAutor(int ID) {
			int eliminados = -1;
			Connection con = null;
			PreparedStatement pstm = null;
			
			try {
				con = MySqlDBConexion.getConexion();
		
				String sql ="delete from autor where idAutor=?";
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
	//ACTUALIZAR AUTOR
		public int actualizaAutor(Autor obj) {
			int actualizados = -1;
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				conn = MySqlDBConexion.getConexion();
				
				String sql = "update autor set nombres=?, apellidos=?, fechaNacimiento=?, pais=?, grado=? where idAutor=?";
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, obj.getNombres());
				pstm.setString(2, obj.getApellidos());
				pstm.setDate(3, (Date) obj.getFec_nac());
				pstm.setString(4, obj.getPais());
				pstm.setString(5, obj.getGrado());
				pstm.setInt(6, obj.getID());
				
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
