package poo;
public class Montana extends Tierra {

    public Montana(float probabilidad_enemigo, Monstruo monstruo, Jefe_Final jefe_final, NPC npc){
       super(probabilidad_enemigo, monstruo, jefe_final, npc);
    }

    public boolean accion(Jugador Jugador){ //metodo Abstracto de Tierra
        if(Jugador.getEnergia()>0 && Jugador.getEnergia()<3){ //si la enegia es mayor a 0 y menor a 3, se resta -3 de vida
            Jugador.setVida(Jugador.getVida()-3);
        }else if(Jugador.getEnergia()>=3){ //si la energia es mayor a 3,se resta -3 de energia
            Jugador.setEnergia(Jugador.getEnergia()-3);  
        }else if(Jugador.getEnergia()==0){//si el mana es 0 retorna falso, basicamente no podrias avanzar
            return false;
        }

        if(Jugador.getVida()==0){//retorna falso si al quitarte vida, tu vida queda en 0
            return false;
        }
        //por el contrario si te resta mana o vida pero sigues vivo retorna true
        return true;
    }
    
}
