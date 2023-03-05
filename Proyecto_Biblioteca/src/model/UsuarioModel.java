package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import entidad.Usuario;
import util.MySqlDBConexion;

public class UsuarioModel {

	private static Logger Log = Logger.getLogger(UsuarioModel.class.getName());
	
	//LISTA TODOS
		public List<Usuario> listaTodos(){
				ArrayList<Usuario> salida = new ArrayList<Usuario>();

				Connection conn = null;
				PreparedStatement psmt = null;
				ResultSet rs = null;
				try {
					//1 Se crea la conexion
					conn = MySqlDBConexion.getConexion();

					//2 Se prepara el SQL
					String sql = "select * from usuario";
					psmt = conn.prepareStatement(sql);
					
					Log.info(">>> " + psmt);
					
					//3 Se ejecuta el SQL en la base de datos
					rs = psmt.executeQuery();
					Usuario obj = null;
					while(rs.next()) {
						obj = new Usuario();
						obj.setID(rs.getInt(1));
						obj.setNombres(rs.getString(2));
						obj.setApellidos(rs.getString(3));
						obj.setDni(rs.getString(4));
						obj.setLogin(rs.getString(5));
						obj.setPassword(rs.getString(6));
						obj.setCorreo(rs.getString(7));
						obj.setFec_reg(rs.getDate(8));
						obj.setFec_nac(rs.getDate(9));
						obj.setDireccion(rs.getString(10));
						obj.setPais(rs.getString(11));
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
		public List<Usuario> ConsultaPorNombreApellido(String nombre, String apellido){
					ArrayList<Usuario> data = new ArrayList<Usuario>();
					
					Connection conn = null;
					PreparedStatement psmt = null;
					ResultSet rs = null;					try {
						//1 Se crea la conexion
						conn = MySqlDBConexion.getConexion();
						
						//2 Se prepara el SQL
						String sql = "select * from usuario "
								+"where (nombre like ?) "
								+"and (apellido like ?)";
							
						psmt = conn.prepareStatement(sql);
						psmt.setString(1, "%" + nombre + "%");
						psmt.setString(2, "%" + apellido + "%");
							
						System.out.println("SQL --> " + psmt);
						
						//3 Se ejecuta el SQL en la base de datos
						rs = psmt.executeQuery();
						
						//
						Usuario obj = null;
						while(rs.next()){
							obj = new Usuario();
							obj.setID(rs.getInt("idUsuario"));
							obj.setNombres(rs.getString("nombre"));
							obj.setApellidos(rs.getString("apellido"));
							obj.setDni(rs.getString("dni"));
							obj.setLogin(rs.getString("login"));
							obj.setPassword(rs.getString("password"));
							obj.setCorreo(rs.getString("correo"));
							obj.setFec_reg(rs.getDate("fechaRegistro"));
							obj.setFec_nac(rs.getDate("fechaNacimiento"));
							obj.setDireccion(rs.getString("direccion"));
							obj.setPais(rs.getString("pais"));
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
		public int insertaUsuario(Usuario obj) {
			int salida = -1;
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				conn = MySqlDBConexion.getConexion();
				
				String sql = "insert into usuario value(null,?,?,?,?,?,?,curtime(),?,?,?)";
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, obj.getNombres());
				pstm.setString(2, obj.getApellidos());
				pstm.setString(3, obj.getDni());
				pstm.setString(4, obj.getLogin());
				pstm.setString(5, obj.getPassword());
				pstm.setString(6, obj.getCorreo());
				//
				pstm.setDate(7, (Date) obj.getFec_nac());
				pstm.setString(8, obj.getDireccion());
				pstm.setString(9, obj.getPais());
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
		public int eliminaUsuario(int ID) {
			int eliminados = -1;
			Connection con = null;
			PreparedStatement pstm = null;
			
			try {
				con = MySqlDBConexion.getConexion();
		
				String sql ="delete from usuario where idUsuario=?";
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
		public int actualizaUsuario(Usuario obj) {
			int actualizados = -1;
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				conn = MySqlDBConexion.getConexion();
				
				String sql = "update usuario set nombre=?, apellido=?, dni=?, login=?, password=?, correo=?, fechaNacimiento=?, direccion=?, pais=? where idUsuario=?";
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, obj.getNombres());
				pstm.setString(2, obj.getApellidos());
				pstm.setString(3, obj.getDni());
				pstm.setString(4, obj.getLogin());
				pstm.setString(5, obj.getPassword());
				pstm.setString(6, obj.getCorreo());
				pstm.setDate(7, (Date) obj.getFec_nac());
				pstm.setString(8, obj.getDireccion());
				pstm.setString(9, obj.getPais());
				pstm.setInt(10, obj.getID());
				
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
