package entidades;

public abstract class Personajes {
	protected String nombre;
	protected Arma arma;
	protected int daño;
	protected int dañoMin;
	protected int dañoMax;
	protected int vida=100;
	public int getDaño() {
		return daño;
	}
	public void setDaño(int daño) {
		this.daño = daño;
	}
	
	protected String tipo;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public abstract int dañar();
	public abstract void esDañado(int x);
	public boolean critico() {
		int x=(int) (Math.random()*10 +1);
		if(x<3)
			return true;
		else
			return false;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Arma getArma() {
		return arma;
	}
	public void setArma(Arma arma) {
		this.arma = arma;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
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
