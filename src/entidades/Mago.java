package entidades;

public class Mago extends Personajes {
	
	private int inteligencia=10;
	
	public Mago() {
		this.tipo="mago";
	}
	
	@Override
	public int dañar() {
		int alearotio= this.dañoMax-this.dañoMin;
		this.daño=(int) (Math.random()*alearotio +1)+this.dañoMin;
		if((this.arma instanceof Hechizos)) {
			int x= (int) (Math.random()*3);
			if(x==1) {
				System.out.println(this.nombre+" invoca habilidad especial. +10 de daño y se cura 20 de vida!!");
				this.vida+=15;
				if(this.critico()) {
					System.out.println("   ataque critico. +20 de daño");
					this.daño+=45;
					return this.daño+45;
				}
				else
					this.daño+=15;
					return this.daño+15;
			}
				
		}
		if(this.critico()) {
			System.out.println("  ataque critico. +20 de daño");
			this.daño+=20;
			return this.daño+20;
		}
		else
			return this.daño;
	}

	@Override
	public void esDañado(int x) {
		this.vida-=x;
		if(this.vida<0)
			this.vida=0;
		
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int fuerza) {
		this.inteligencia = fuerza;
	}

	public void setArma(Arma arma) {
		this.daño=0;
		this.arma = arma;
		this.daño= arma.getDaño();
		this.dañoMin=arma.getDañoMin();
		this.dañoMax=arma.getDañoMax();
		if(this.arma instanceof Hechizos) {
			this.daño+= inteligencia ;
			this.dañoMin+=inteligencia;
			this.dañoMax+=inteligencia;
		}
	}
}
