package entidad;

import java.sql.Date;

public class Autor {

	private int ID;
	private String nombres, apellidos, pais, grado;
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

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
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
