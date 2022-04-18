package Main;

import java.util.ArrayList;

import entidades.*;
public class main {
	static ArrayList<Personajes> listaP= new ArrayList<>();
	static ArrayList<Arma> listaA= new ArrayList<>();
	static ArrayList<String> listaDa�ar= new ArrayList<>();
	static ArrayList<String> listaAccion= new ArrayList<>();
	
	
	 static void crearLista() {

		 Arma e1= new Espada("Claymore",30);
		 listaA.add(e1);
		 Arma e2= new Espada("Dagas", 25);
		 listaA.add(e2);
		 Arma e3= new Espada("Uchigatana", 40);
		 listaA.add(e3);
		 
		 Arma ar1= new Arco("Arco del Le�n", 30);
		 listaA.add(ar1);
		 Arma ar2= new Arco("Arco ligero", 15);
		 listaA.add(ar2); 
		 Arma ar3= new Arco("Arco pesado", 20);
		 listaA.add(ar3);
		 
		 Arma h1= new Hechizos("Llama Fren�tica", 20);
		 listaA.add(h1);
		 Arma h2= new Hechizos("Magia Gravitacional", 25);
		 listaA.add(h2);
		 
		 Arma r1= new Rezos("Ley Dorada", 10);
		 listaA.add(r1);
		 Arma r2= new Rezos("Singularidad", 12);
		 listaA.add(r2);
		 
		 
		Personajes p1= new Guerrero();
		p1.setNombre("Sinluz");
		
		listaP.add(p1);
		
		Personajes p2= new Mago();
		p2.setNombre("Rennala");
		listaP.add(p2);
		
		Personajes p3= new Curandero();
		p3.setNombre("D");
		listaP.add(p3);
		
		listaDa�ar.add(" ha da�ado");
		listaDa�ar.add(" ha herido");

	}
	 
	 static ArrayList<Personajes> elegirPersonaje(){
		 int x=0, y=0;
		 ArrayList<Personajes> listaP2= new ArrayList<>();
		 while(x==y) {
			 x= (int) (Math.random()*listaP.size());
			 y=(int) (Math.random()*listaP.size());
		 }
		 listaP2.add(listaP.get(x));
		 listaP2.add(listaP.get(y));
		 x=0;
		 y=0;
		 while(x==y) {
			 x= (int) (Math.random()*listaA.size());
			 y=(int) (Math.random()*listaA.size());
		 }
		 listaP2.get(0).setArma(listaA.get(x));
		 listaP2.get(1).setArma(listaA.get(y));
		 return listaP2;
	 }
	 
	 
	 
	 public static String stats(Personajes p) {
		 return p.getNombre()+"("+p.getVida()+")";
	 }
	 

	 public static void jugar(Personajes p1, Personajes p2) {
		 System.out.println("");
		 System.out.println(stats(p1)+"  VS  "+stats(p2));
		 System.out.println("");
		 int opcion=(int) (Math.random()*3+1);
		 if(opcion==1) {
			 p1.esDa�ado(p2.da�ar());
			 System.out.println(stats(p2)+listaDa�ar.get((int) (Math.random()*listaDa�ar.size()))+" (-"+p2.getDa�o()+ 
					 " puntos) a "+ stats(p1));
		 }
		 else if(opcion==2) {
			 p2.esDa�ado(p1.da�ar());
			 System.out.println(stats(p1)+listaDa�ar.get((int) (Math.random()*listaDa�ar.size()))+" (-"+p1.getDa�o()+ 
					 " puntos) a "+ stats(p2));
		 }
		 else if(opcion=3)
		 System.out.println("Fallo el ataque");
	 }
	 
	 
	 static void inicio(Personajes p1, Personajes p2) {
		 System.out.println(p1.getNombre() + " empu�ando "+p1.getArma().getNombre());
	 }
	 
	 
	 
	 
	 /*			REGLAS
	  * 
	  * El juego escogera al azar dos personajes diferentes con unas arma diferentes y lucharan hasta que uno de los dos
	  * se quede sin puntos de vida.
	  * Cada arma tiene un da�o base, un da�o minimo y un da�o maximo(+30 de da�o). Al atacar, se escogera un valor aleatorio entre
	  * el valor minimo y el maximo.
	  * Cada personaje tiene su arma favorita. Si este lucha con una de ellas, se activara una serie de mejoras;
	  * 	
	  * 	1.Guerrero-Espada/Arco: se le suma al da�o base del arma los puntos de fuerza del personaje. Ademas tendra una posibilidad
	  * 							entre 1 de activar su SUPER(+30 de da�o en su proximo ataque)
	  * 	2.Mago-Hechizos: se le suma al da�o base del arma los puntos de inteligencia del personaje. Ademas tendra una posibilidad
	  * 							entre 1 de activar su SUPER(+15 de da�o en su proximo ataque, +15 de vida y +10 en criticos).
	  * 	3.Curanderos-Rezos: se le suma al da�o base del arma los puntos de sabiduria del personaje. Ademas tendra una posibilidad
	  * 							entre 1 de activar su SUPER(+30 de vida).
	  * 
	  * Ademas, hay un un 30% de posibilidades que el ataque sea critico, sumandole +20 de da�o extra
	  * */
	 
	public static void main(String[] args) {
		
		crearLista();
		ArrayList<Personajes> personajesDuelo= elegirPersonaje();
		Personajes p1=personajesDuelo.get(0);
		Personajes p2=personajesDuelo.get(1);
		System.out.println("Duelo PVP");
		 try {
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        } catch (Exception e) {
	        }

		  System.out.println("Un "+p1.getTipo()+" llamado "+p1.getNombre()+" invadio el mundo de "
		  		+ p2.getTipo()+" con nombre "+p2.getNombre()+"." );
		  System.out.println("");
		  
		 
		  inicio(p1,p2);
		  inicio(p2,p1);
		  
		
		  while(p1.getVida()>0 && p2.getVida()>0) {
			  jugar(p1,p2);
		  }
		  if(p1.getVida()>0)
			  System.out.println("Ha ganado "+ p1.getNombre());
		  else
			  System.out.println("Ha ganado "+ p2.getNombre());
		  System.out.println("\n\n\n\n\n");
	}
	
	 
}
