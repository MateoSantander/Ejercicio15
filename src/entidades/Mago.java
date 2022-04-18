package entidades;

public class Mago extends Personajes {
	
	private int inteligencia=10;
	
	public Mago() {
		this.tipo="mago";
	}
	
	@Override
	public int da�ar() {
		int alearotio= this.da�oMax-this.da�oMin;
		this.da�o=(int) (Math.random()*alearotio +1)+this.da�oMin;
		if((this.arma instanceof Hechizos)) {
			int x= (int) (Math.random()*3);
			if(x==1) {
				System.out.println(this.nombre+" invoca habilidad especial. +10 de da�o y se cura 20 de vida!!");
				this.vida+=15;
				if(this.critico()) {
					System.out.println("   ataque critico. +20 de da�o");
					this.da�o+=45;
					return this.da�o+45;
				}
				else
					this.da�o+=15;
					return this.da�o+15;
			}
				
		}
		if(this.critico()) {
			System.out.println("  ataque critico. +20 de da�o");
			this.da�o+=20;
			return this.da�o+20;
		}
		else
			return this.da�o;
	}

	@Override
	public void esDa�ado(int x) {
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
		this.da�o=0;
		this.arma = arma;
		this.da�o= arma.getDa�o();
		this.da�oMin=arma.getDa�oMin();
		this.da�oMax=arma.getDa�oMax();
		if(this.arma instanceof Hechizos) {
			this.da�o+= inteligencia ;
			this.da�oMin+=inteligencia;
			this.da�oMax+=inteligencia;
		}
	}
}
