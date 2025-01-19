package poo;

import java.util.ArrayList;

public class Guerrero extends Jugador {
    //atributos extra, usados para el caso en que suba de nivel
    private int vidaMax = 20;

    private int fuerzaMax = 9;

    private int inteligenciaMax = 1;

    private int energiaMax = 10;

    private int manaMax= 2; 

    public Guerrero(String nombre,ArrayList<Mision> lista_misiones){//constructor
        super(nombre,20,0,9,10,1,2,lista_misiones);
    }
    public int nivel(){ // METODO EXTRA PARA OBTENER EL NIVEL ACTUAL DEL MAGO SEGUN SU EXPERIENCIA

        int nivel; //creo variable donde se almacenara un entero correspondiente al nivel

        if(0 <= getXp() && getXp()<10){  //si esta entre 0 y 9 el nivel es 1
            nivel = 1;
        }else if (10 <= getXp() && getXp() <25){ //si esta entre 10 y 24 el nivel es 2
            nivel = 2;
        }else if (25 <= getXp() && getXp() <50){ //si esta entre 25 y 49 el nivel es 3
            nivel = 3;
        }else if (50 <= getXp() && getXp() <100){ //si esta entre 50 y 99 el nivel es 4
            nivel = 4;
        }else if (100 <= getXp() && getXp() <200){ //si esta entre 100 y 199 el nivel es 5
            nivel = 5;
        }else if (200 <= getXp() && getXp() <350){ //si esta entre 200 y 349 el nivel es 6
            nivel = 6;
        }else if (350 <= getXp() && getXp() <600){ //si esta entre 350 y 600 el nivel es 7
            nivel = 7;
        }else{  //por el contrario si es mayor a 600 tiene que estar en nivel 8
            nivel = 8;
        }
        return nivel;
    }

    @Override
    public int ataque(){ //metodo abtracto de Jugador
        if(getEnergia() == 0){
            System.out.println("No te queda Energia"); //si no le queda energia su ataque valdra 0
            return 0;
        }else{
            int ataque = getFuerza()*2 + getEnergia(); //valor del ataque
            setEnergia(getEnergia()-5);  //setea la energia restandole 5 a la actual 
            if(getEnergia() <= 0){  //cuando detecta que la energia es menor a 0, la setea en 0;
                setEnergia(0);
            }
            return ataque;
        }
    }
    
    @Override
    public int hechizo(){ //metodo abtracto de Jugador
        if(getMana() == 0){
            System.out.println("No te queda Mana"); //si no le queda mana su hechizo valdra 0
            return 0;
        }else{
            int hechizo = getInteligencia()*(getFuerza()/4) + getMana(); //valor del hechizo
            setMana(getMana()-3); //setea el mana restandole 3 al actual
            if(getMana() <= 0){ //cuando detecta que el mana es menor a 0, la setea en 0;
                setMana(0);
            }
            return hechizo;
        }
    }

    @Override
    public void subir_experiencia(int experiencia){ //metodo abtracto de Jugador

        int nivelInicial = nivel(); //Variable para guardar el nivel que tiene el Mago antes de entregarle experiencia

        setXp(getXp()+experiencia); //se suma experiencia

        if(getXp() >= 900){ //esto sirve para que no sobrepase los 900 de xp 
            setXp(900);
        }

        if(nivelInicial!= nivel()){ //si el nivel actual es diferencte al inicial, se realiza el aumento de los atributos
            vidaMax = vidaMax + 3 * nivel(); //se actualizan las variables extras para almacenar los maximos de cada atributo
            fuerzaMax += fuerzaMax + 5* nivel(); 
            energiaMax +=energiaMax + 3 * nivel();
            inteligenciaMax =inteligenciaMax + (nivel() - nivelInicial); //estos atributos se les suma uno por cada nivel subido 
            manaMax = manaMax + (nivel() - nivelInicial);               //(nivel() - nivelInicial) esto servira en el caso de subir mas de un nivel

            //si sube de nivel recupera sus stadisticas maximas.
            setVida(vidaMax);
            setFuerza(fuerzaMax);
            setInteligencia(inteligenciaMax);
            setEnergia(energiaMax);
            setMana(manaMax);
        }
    }
    public void setVidaMax(int vidaMax){ //SETTER ATRIBUTO EXTRA 
        this.vidaMax =vidaMax;
    }

    public void setInteligenciaMax(int inteligenciaMax){ //SETTER ATRIBUTO EXTRA 
        this.inteligenciaMax =inteligenciaMax;
    }

    public void setManaMax(int manaMax){ //SETTER ATRIBUTO EXTRA
        this.manaMax = manaMax;
    }

    public void setFuerzaMax(int fuerzaMax){ //SETTER ATRIBUTO EXTRA
        this.fuerzaMax = fuerzaMax;
    }

    public void setEnergiaMax(int energiaMax){ //SETTER ATRIBUTO EXTRA 
        this.energiaMax = energiaMax;
    }

    public int getVidaMax() { //GETTER ATRIBUTO EXTRA 
        return vidaMax;
    }

    public int getEnergiaMax() { //GETTER ATRIBUTO EXTRA  
        return energiaMax;
    }

    public int getManaMax() { //GETTER ATRIBUTO EXTRA 
        return manaMax;
    }

    public int getInteligenciaMax() { //GETTER ATRIBUTO EXTRA 
        return inteligenciaMax;
    }

    public int getFuerzaMax() { //GETTER ATRIBUTO EXTRA 
        return fuerzaMax;
    }
}
