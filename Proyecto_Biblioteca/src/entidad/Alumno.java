package entidad;

import java.sql.Date;

public class Alumno {

	//
	private int ID;
	private String nombres,apellidos,dni,pais,correo;
	private Date Fec_Nac,Fec_Reg;

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

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFec_Nac() {
		return Fec_Nac;
	}

	public void setFec_Nac(Date fec_Nac) {
		Fec_Nac = fec_Nac;
	}

	public Date getFec_Reg() {
		return Fec_Reg;
	}

	public void setFec_Reg(Date fec_Reg) {
		Fec_Reg = fec_Reg;
	}
}