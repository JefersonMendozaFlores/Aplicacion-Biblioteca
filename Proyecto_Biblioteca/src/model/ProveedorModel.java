package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import entidad.Proveedor;
import util.MySqlDBConexion;

public class ProveedorModel {
	
	private static Logger Log = Logger.getLogger(ProveedorModel.class.getName());
	
	//LISTA TODOS
		public List<Proveedor> listaTodos(){
				ArrayList<Proveedor> salida = new ArrayList<Proveedor>();

				Connection conn = null;
				PreparedStatement psmt = null;
				ResultSet rs = null;
				try {
					//1 Se crea la conexion
					conn = MySqlDBConexion.getConexion();

					//2 Se prepara el SQL
					String sql = "select * from proveedor";
					psmt = conn.prepareStatement(sql);
					
					Log.info(">>> " + psmt);
					
					//3 Se ejecuta el SQL en la base de datos
					rs = psmt.executeQuery();
					Proveedor obj = null;
					while(rs.next()) {
						obj = new Proveedor();
						obj.setID(rs.getInt(1));
						obj.setNombres(rs.getString(2));
						obj.setApellidos(rs.getString(3));
						obj.setDni(rs.getString(4));
						obj.setDireccion(rs.getString(5));
						obj.setTelefono(rs.getString(6));
						obj.setCorreo(rs.getString(7));
						obj.setPais(rs.getString(8));
						obj.setFec_reg(rs.getDate(9));
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
		public List<Proveedor> ConsultaPorNombreApellido(String nombre, String apellido){
					ArrayList<Proveedor> data = new ArrayList<Proveedor>();
					
					Connection conn = null;
					PreparedStatement psmt = null;
					ResultSet rs = null;					try {
						//1 Se crea la conexion
						conn = MySqlDBConexion.getConexion();
						
						//2 Se prepara el SQL
						String sql = "select * from proveedor "
								+"where (nombres like ?) "
								+"and (apellidos like ?)";
							
						psmt = conn.prepareStatement(sql);
						psmt.setString(1, "%" + nombre + "%");
						psmt.setString(2, "%" + apellido + "%");
							
						System.out.println("SQL --> " + psmt);
						
						//3 Se ejecuta el SQL en la base de datos
						rs = psmt.executeQuery();
						
						//
						Proveedor obj = null;
						while(rs.next()){
							obj = new Proveedor();
							obj.setID(rs.getInt("idProveedor"));
							obj.setNombres(rs.getString("nombres"));
							obj.setApellidos(rs.getString("apellidos"));
							obj.setDni(rs.getString("dni"));
							obj.setDireccion(rs.getString("direccion"));
							obj.setTelefono(rs.getString("telefono"));
							obj.setCorreo(rs.getString("correo"));
							obj.setPais(rs.getString("pais"));
							obj.setFec_reg(rs.getDate("fechaRegistro"));
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
		public int insertaProveedor(Proveedor obj) {
			int salida = -1;
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				conn = MySqlDBConexion.getConexion();
				
				String sql = "insert into proveedor value(null,?,?,?,?,?,?,?,curtime())";
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, obj.getNombres());
				pstm.setString(2, obj.getApellidos());
				pstm.setString(3, obj.getDni());
				pstm.setString(4, obj.getDireccion());
				pstm.setString(5, obj.getTelefono());
				pstm.setString(6, obj.getCorreo());
				pstm.setString(7, obj.getPais());
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
		public int eliminaProveedor(int ID) {
			int eliminados = -1;
			Connection con = null;
			PreparedStatement pstm = null;
			
			try {
				con = MySqlDBConexion.getConexion();
		
				String sql ="delete from proveedor where idProveedor=?";
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
		public int actualizaProveedor(Proveedor obj) {
			int actualizados = -1;
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				conn = MySqlDBConexion.getConexion();
				
				String sql = "update proveedor set nombres=?, apellidos=?, dni=?, direccion=?, telefono=?, correo=?, pais=? where idProveedor=?";
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, obj.getNombres());
				pstm.setString(2, obj.getApellidos());
				pstm.setString(3, obj.getDni());
				pstm.setString(4, obj.getDireccion());
				pstm.setString(5, obj.getTelefono());
				pstm.setString(6, obj.getCorreo());
				pstm.setString(7, obj.getPais());
				pstm.setInt(8, obj.getID());
				
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
		
		//LISTAR AUTOR POR NOMBRE O APELLIDO
				public List<Proveedor> ReportProveedor(String nombre, String apellido){
							ArrayList<Proveedor> data = new ArrayList<Proveedor>();
							
							Connection conn = null;
							PreparedStatement psmt = null;
							ResultSet rs = null;					try {
								//1 Se crea la conexion
								conn = MySqlDBConexion.getConexion();
								
								//2 Se prepara el SQL
								String sql = "select idProveedor,nombres,apellidos,dni,direccion,telefono,correo,pais from proveedor "
										+"where (nombres like ?) "
										+"and (apellidos like ?)";
									
								psmt = conn.prepareStatement(sql);
								psmt.setString(1, "%" + nombre + "%");
								psmt.setString(2, "%" + apellido + "%");
									
								System.out.println("SQL --> " + psmt);
								
								//3 Se ejecuta el SQL en la base de datos
								rs = psmt.executeQuery();
								
								//
								Proveedor obj = null;
								while(rs.next()){
									obj = new Proveedor();
									obj.setID(rs.getInt("idProveedor"));
									obj.setNombres(rs.getString("nombres"));
									obj.setApellidos(rs.getString("apellidos"));
									obj.setDni(rs.getString("dni"));
									obj.setDireccion(rs.getString("direccion"));
									obj.setTelefono(rs.getString("telefono"));
									obj.setCorreo(rs.getString("correo"));
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
}
