package poo;

public class Bosque extends Tierra{
    //constructor
    public Bosque(float probabilidad_enemigo, Monstruo monstruo, Jefe_Final jefe_final, NPC npc){
        super(probabilidad_enemigo, monstruo, jefe_final, npc);//herencia
    }
    
    //metodo accion 
    public boolean accion(Jugador Jugador){ //metodo abstracto de tierra
        if(Jugador.getMana()>0 && Jugador.getMana()<3){ //si el mana es mayor a 0 y menor a 3, se resta -3 de vida
            Jugador.setVida(Jugador.getVida()-3);
        }else if(Jugador.getMana()>=3){     //si el mana es mayor a 3,se resta -3 de mana
            Jugador.setMana(Jugador.getMana()-3);
        }else if(Jugador.getMana()==0){ //si el mana es 0 retorna falso, basicamente no podrias avanzar 
            return false;
        }
 
        if(Jugador.getVida()==0){ //retorna falso si al quitarte vida, tu vida queda en 0
            return false;
        }
        
        //por el contrario si te resta mana o vida pero sigues vivo retorna true
        return true;
    }

}
