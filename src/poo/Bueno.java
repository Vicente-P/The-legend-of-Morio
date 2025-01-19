package poo;

public class Bueno extends NPC {
    //atributos
    private int cantidad;
    
    private String atributo;

    public Bueno(String nombre,int cantidad, String atributo){ //constructor
        super(nombre);
        this.cantidad = cantidad;
        this.atributo = atributo;

    }

    public void setAtributo(String atributo){ //setter
        this.atributo = atributo;
    }

    public void setName(int cantidad){ //setter
        this.cantidad = cantidad;
    }

    public int getCantidad() { //getter
        return cantidad;
    }

    public String getAtributo() { //getter
        return atributo;
    }

    @Override
    public void interaccion(Jugador Jugador){
        if(getAtributo().equals("vida")){ //usamos equals para saber el atributo que mejora.
            Jugador.setVida(Jugador.getVida()+getCantidad()); //si el atributo es vida, le suma la cantidad ingresada por el usuario a la actual
        }else if(getAtributo().equals("mana")){                 //sucede lo mismo para los demas atributos
            Jugador.setMana(Jugador.getMana()+getCantidad()); 
        }else if(getAtributo().equals("xp")){
            Jugador.subir_experiencia(getCantidad());
        }else if(getAtributo().equals("energia")) {
            Jugador.setEnergia(Jugador.getEnergia()+getCantidad());

        }
        //mensaje del npc, se mostrara por consola al interactuar con el
        System.out.println( getName()+ ": Creo que necesitas un poco de ayuda te subire " + getCantidad() + " a tu " + getAtributo() + "!!!");
    }

    
}
