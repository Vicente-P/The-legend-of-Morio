package poo;

import java.util.Scanner;

public class Monstruo implements Enemigo{
    //atributos
    private int vida;
    private int dano;

    public Monstruo(int vida,int dano){//constructor
        this.vida = vida;
        this.dano = dano;
    }
    
    public  int getVida(){ //getter
        return vida;
    }

    public  int getDano(){ //getter
        return dano;
    }
    public void setDano(int dano){//setter

        this.dano = dano;
    }
    public void setVida(int vida){//setter
        this.vida = vida;
    }


    public void combate(Jugador Jugador){
        Scanner entrada = new Scanner(System.in);//abro un scanner para que el jugador puede elegir si aceptar o no la mision.
        //mensajes por pantalla
        int vida_actual = getVida(); //creo una variable que tendra una referencia de la vida del monstruo
        System.out.println("Has entrado en combate contra un Monstruo");
        System.out.println("La vida del monstruo es: " + vida_actual); //muestra la vida actual del monstruo
        while(Jugador.getVida() > 0 && getVida() > 0){ //mientras la vida del monstruo y la del jugador sean mayores a 0, podran pelea.
            System.out.println("Tu vida actual es de: " + Jugador.getVida());
            System.out.println("¿Deseas hacer un ataque o hechizo? (ataque/hechizo)"); //aqui pregunto por pantalla que desea hacer para golpear al monstruo
            String ataque = entrada.nextLine();

            if(ataque.equals("ataque")){ //al seleccionar un tipo de golpe, este le resta la vida correspondiente al monstruo
                System.out.println("Realizaste un ataque");
                vida_actual = vida_actual-Jugador.ataque(); //resta vida al monstruo 
            }else{
                System.out.println("Realizaste un hechizo"); //caso si eligio hacer hechizo
                vida_actual = vida_actual-Jugador.hechizo();//resta vida al monstruo
            }
            if(vida_actual <= 0){ //si la vida del monstruo es menor o igual a 0, me aparece un mensaje y se rompe el while
                System.out.println("Has derrotado al monstruo");
                break;
            }
            
            System.out.println("La vida del monstruo es: " + vida_actual); //muestra la vida del monstruo despues de que lo atacamos

            System.out.println("El monstruo realizara un ataque, el daño es de " + getDano()); 
            //luego este nos ataca y nos resta vida segun su daño base
            Jugador.setVida(Jugador.getVida()-getDano()); //resta vida al jugador

            if(Jugador.getVida()<= 0 ){ //si la vida del jugador es menor a 0, sale un mensaje de que perdiste
                Jugador.setVida(0);
                System.out.println("Has Perdido");
            }
        }
    }
}
