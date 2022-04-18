package entidades;

public abstract class Arma {
	protected String nombre;
	protected int daño;
	protected int dañoMin;
	protected int dañoMax;
	
	protected Arma(String nombre, int daño) {
		this.nombre= nombre;
		this.daño=daño;
		this.dañoMin=daño;
		this.dañoMax=daño+20;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDaño() {
		return daño;
	}
	public void setDaño(int daño) {
		this.daño = daño;
	}
	public int getDañoMin() {
		return dañoMin;
	}
	public void setDañoMin(int dañoMin) {
		this.dañoMin = dañoMin;
	}
	public int getDañoMax() {
		return dañoMax;
	}
	public void setDañoMax(int dañoMax) {
		this.dañoMax = dañoMax;
	}
	
}
