package entidad;

import java.sql.Date;

public class Usuario {

	private int ID;
	private String nombres, apellidos, dni, login, password, correo, direccion, pais;
	private Date Fec_nac, Fec_reg;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Date getFec_nac() {
		return Fec_nac;
	}

	public void setFec_nac(Date fec_nac) {
		Fec_nac = fec_nac;
	}

	public Date getFec_reg() {
		return Fec_reg;
	}

	public void setFec_reg(Date fec_reg) {
		Fec_reg = fec_reg;
	}

}
