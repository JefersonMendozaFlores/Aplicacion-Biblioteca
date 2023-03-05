package entidad;

import java.sql.Date;

public class Libro {

	private int ID,año;
	private String tituto,categoria,serie,pais,tipo;
	private Date Fec_reg;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public String getTituto() {
		return tituto;
	}

	public void setTituto(String tituto) {
		this.tituto = tituto;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getFec_reg() {
		return Fec_reg;
	}

	public void setFec_reg(Date fec_reg) {
		Fec_reg = fec_reg;
	}

}
