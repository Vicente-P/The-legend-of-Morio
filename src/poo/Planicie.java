package poo;
public class Planicie extends Tierra{

    //constructor
    public Planicie(float probabilidad_enemigo, Monstruo monstruo, Jefe_Final jefe_final, NPC npc){
        super(probabilidad_enemigo, monstruo, jefe_final, npc);//herencia
     }
    //accion siempre sera true, es decir, no pide ningun requisito para pasar a una casilla con este tipo de tierra.
    public boolean accion(Jugador Jugador){ //metodo abstracto de Tierra
        return true;
    }
    
}


