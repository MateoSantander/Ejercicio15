package entidades;

public class Guerrero extends Personajes {
	
	private int fuerza=10;
	
	public Guerrero() {
		this.tipo="guerrero";
	}
	@Override
	public int dañar() {
		int alearotio= this.dañoMax-this.dañoMin;
		this.daño=(int) (Math.random()*alearotio +1)+this.dañoMin;
		if((this.arma instanceof Espada)||(this.arma instanceof Arco)) {
			int x= (int) (Math.random()*3);
			if(x==1) {
				System.out.println(this.nombre+" ha usado su habilidad especial. +20 de daño");
				if(this.critico()) {
					System.out.println(" ataque critico. +20 de daño");
					this.daño+=50;
					return this.daño+50;
				}
				else
					this.daño+=30;
					return this.daño+30;
			}
		}
		if(this.critico()) {
			System.out.println(" ataque critico. +20 de daño");
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

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public void setArma(Arma arma) {
		this.daño=0;
		this.arma = arma;
		this.daño= arma.getDaño();
		this.dañoMin=arma.getDañoMin();
		this.dañoMax=arma.getDañoMax();
		if((this.arma instanceof Espada)||(this.arma instanceof Arco)) {
			this.daño+= fuerza ;
			this.dañoMin+=fuerza;
			this.dañoMax+=fuerza;
		}
	}
}
