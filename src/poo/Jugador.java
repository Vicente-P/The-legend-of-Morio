package poo;

import java.util.ArrayList;

public abstract class Jugador {
    //atributos

    private String nombre; 

    private int vida;

    private int xp = 0;
    
    private int fuerza;

    private int energia;

    private int inteligencia;

    private int mana; 

    private ArrayList<Mision> lista_misiones;

    //constructor
    public Jugador(String nombre, int vida, int xp, int fuerza, int energia, int inteligencia, int mana, ArrayList<Mision> lista_misiones){

        this.nombre = nombre;
        this.vida = vida;
        this.xp = xp;
        this.fuerza = fuerza;
        this.energia = energia;
        this.inteligencia = inteligencia;
        this.mana = mana;
        this.lista_misiones = lista_misiones;


    }
    //FUNCIONES ABSTRACTAS
    public abstract int ataque();

    public abstract int hechizo();

    public abstract void subir_experiencia(int experiencia);

    public String getName(){ //GETTER

        return nombre;
    }

    public int getVida(){ //GETTER

        return vida;
    }

    public int getXp(){ //GETTER

        return xp;
    }

    public int getFuerza(){ //GETTER

        return fuerza;
    }

    public int getInteligencia(){//GETTER 

        return inteligencia;
    }

    public int getMana(){//GETTER

        return mana;
    }

    public int getEnergia(){//GETTER

        return energia;
    }

    public ArrayList<Mision> getLista_misiones() {//GETTER
        return lista_misiones;
    }

    public void setnombre(String nombre){ //SETTER

        this.nombre = nombre;
    }

    public void setVida(int vida){//SETTER

        this.vida = vida;
    }

    public void setXp(int xp){//SETTER

        this.xp = xp;
    }


    public void setFuerza(int fuerza){//SETTER

        this.fuerza = fuerza;
    }

    public void setInteligencia(int inteligencia) {//SETTER
        
        this.inteligencia = inteligencia;
    }

    public void setEnergia(int energia){//SETTER
        this.energia = energia;

    }

    public void setMana(int mana){//SETTER
        this.mana = mana;

    }

    public void setLista_misiones(ArrayList<Mision> lista_misiones) {
        this.lista_misiones = lista_misiones;
    }
}
