package poo;

public abstract class NPC {
    
    private String nombre; 
    
    public NPC(String nombre){ //constructor
        this.nombre = nombre;
    }

    public abstract void interaccion(Jugador Jugador); //funcion abstracta
    
    public void setName(String nombre){ //setter
        this.nombre = nombre;
    }

    public String getName(){ //getter
        return nombre;
    }
        
    
}
