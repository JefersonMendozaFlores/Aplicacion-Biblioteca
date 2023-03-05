package entidad;

import java.sql.Date;

public class Sala {

	private int ID,estado;
	private String numero, recursos, sede,  piso, numAlumnos;
	private Date Fec_reg;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getRecursos() {
		return recursos;
	}
	public void setRecursos(String recursos) {
		this.recursos = recursos;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	public String getPiso() {
		return piso;
	}
	public void setPiso(String piso) {
		this.piso = piso;
	}
	public String getNumAlumnos() {
		return numAlumnos;
	}
	public void setNumAlumnos(String numAlumnos) {
		this.numAlumnos = numAlumnos;
	}
	public Date getFec_reg() {
		return Fec_reg;
	}
	public void setFec_reg(Date fec_reg) {
		Fec_reg = fec_reg;
	}
	

	

}
