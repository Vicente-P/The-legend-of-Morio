package poo;

import java.util.Scanner;

public class Jefe_Final implements Enemigo {
    //atributos
    private String nombre;

    private int vida;

    private int dano_base;

    public Jefe_Final(String nombre,int vida,int dano_base){ //constructor
        this.nombre = nombre;
        this.vida = vida;
        this.dano_base = dano_base;
    }
    public  int getVida(){ //getter
        return vida;
    }

    public  int getDano(){ //getter
        return dano_base;
    }
    public String getname() {//getter
        return nombre;
    }

    public void setname(String nombre) {//setter
        this.nombre = nombre;
    }

    public void setDano(int dano){//setter

        this.dano_base = dano;
    }
    public void setVida(int vida){//setter
        this.vida = vida;
    }



    public void combate(Jugador Jugador){
        Scanner entrada = new Scanner(System.in);//abro un scanner para que el jugador puede elegir si aceptar o no la mision.
        int vidaInicialJefe = getVida(); //guardo vida inicial
        //mensajes que se mostraran por pantalla
        System.out.println("Has entrado en combate contra un Jefe final"); //mensajes que apareceran en pantalla
        System.out.println("Me llamo "+ getname() + "!! y acabare contigo!!");
        System.out.println("La vida del Jefe es: " + getVida()); //retorna la vida del jefe al empezar la pelea
        while(Jugador.getVida() > 0 && getVida() > 0){  //mientras el jefe y el personaje tengan vida mayor a 0, seguiran peliando
            System.out.println("Tu vida actual es de: " + Jugador.getVida());
            int faseJefe = 2;
            if(getVida() <= vidaInicialJefe/2){ //si la vida menor o igual a la mitad de la vida inicial, baja a fase 1
                faseJefe = 1;   
            }
            System.out.println("El jefe esta en la fase: " + faseJefe);
            

            String ataque ="";
            System.out.println("¿Deseas hacer un ataque o hechizo? (ataque/hechizo)"); //aqui pregunto por pantalla que desea hacer para golpear al jefefinal
            ataque = entrada.nextLine();

            if(ataque.equals("ataque")){
                System.out.println("Realizaste un ataque"); //al seleccionar un tipo de golpe, este le resta la vida correspondiente al jefefinal
                setVida(getVida()-Jugador.ataque()); 
            }else{
                System.out.println("Realizaste un hechizo");
                setVida(getVida()-Jugador.hechizo());
            }

            if(getVida() <= 0){ //si la vida del jefe es menor o igual a 0, me aparece un mensaje y se rompe el while
                setVida(0);
                System.out.println("Has derrotado a " + getname());
                break;
            }
    
            System.out.println("La vida del Jefe es: " + getVida()); //cada vez que golpiemos al jefefinal nos dira la vida actual 

            System.out.println(getname() + " realizara un ataque, el daño es de " + (getDano() + 2 * faseJefe)); //luego el jefefinal ataca y nos resta vida segun su daño base y fase

            Jugador.setVida(Jugador.getVida()-(getDano() + 2 * faseJefe)); //se le resta la vida al jugador

            if(Jugador.getVida()<=0 ){   //si la vida del jugador es menor a 0, sale un mensaje de que perdiste
                Jugador.setVida(0); 
                System.out.println("Has Perdido");
                break;
            }

        }
    }
}
