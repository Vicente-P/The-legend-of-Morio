package poo;

import java.util.ArrayList;

public class Druida extends Jugador {
    //atributos extra, usados para el caso en que suba de nivel
    private int vidaMax = 15;

    private int fuerzaMax = 5;

    private int inteligenciaMax = 5;

    private int energiaMax = 5;

    private int manaMax= 5; 

    public Druida(String nombre,ArrayList<Mision> lista_misiones){ //constructor
        super(nombre,15,0,5,5,5,5,lista_misiones); //herencia
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
    public int ataque(){ //clase abstracta de jugador 
        int ataque = 0;

        if(getEnergia() == 0){
            System.out.println("No te queda Energia"); //si no tiene energia no podra atacar, por lo que retorna 0;
            return 0;
        }else{
            if (getEnergia()/3 > getMana()/2){ //Si la energia partido en 3 es mayor a mana dividido en 2 es mayor, sera usada en la formula.
                ataque = ((getFuerza() + getInteligencia())/3) * (getEnergia()/3);
            }else { //sino se cumple la primera condicion se usa el mana divido en 2 en la formula
                ataque = ((getFuerza() + getInteligencia())/3) * (getMana()/2);
            }
            setEnergia(getEnergia()-3); //setea la energia restandole 3 a la actual
            if(getEnergia() <= 0){ //cuando detecta que la energia es menor a 0, la setea en 0 para no tener numeros negativos
                setEnergia(0);
            }
            return ataque; //retorna entero correspondiente al daño

        }    
    }
    
    @Override
    public int hechizo(){ //clase abstracta de jugador 
        int hechizo = 0;
        if(getMana() == 0){
            System.out.println("No te queda Mana"); //si no tiene mana no podra atacar, por lo que retorna 0;
            return 0;
        }else{
            if (getEnergia()/2 > getMana()/3){ //Si la energia partido en 2 es mayor a mana dividido en 3 es mayor, sera usada en la formula.
                hechizo = ((getFuerza() + getInteligencia())/3) * (getEnergia()/2); 
            }else { //sino se usa el mana divido en 3 en la formula
                hechizo = ((getFuerza() + getInteligencia())/3) * (getMana()/3);
            }

            setMana(getMana()-3);//setea el mana restandole 3 al actual 
            if(getMana() <= 0){  //cuando detecta que el mana es menor a 0, la setea en 0;
                setMana(0);
            }
            return hechizo; //retorna entero correspondiente al daño
        }
    }

    @Override
    public void subir_experiencia(int experiencia){ //clase abstracta de jugador 

        int nivelInicial = nivel();  //Variable para guardar el nivel que tiene el Druida antes de entregarle experiencia

        setXp(getXp()+experiencia); //se suma experiencia a sus stats

        if(getXp() >= 900){ //esto sirve para que no sobrepase los 900 de xp 
            setXp(900);
        }

        if(nivelInicial!= nivel()){ //si el nivel actual es diferencte al inicial, se realiza el aumento de los atributos
            vidaMax += nivel(); //se actualizan las variables extras para almacenar los maximos de cada atributo 
            fuerzaMax +=  nivel(); 
            energiaMax += nivel();
            inteligenciaMax += nivel();
            manaMax += nivel();

            //si sube de nivel recupera sus stadisticas maximas.
            setVida(vidaMax);
            setFuerza(fuerzaMax);
            setInteligencia(inteligenciaMax);
            setEnergia(energiaMax);
            setMana(manaMax);
        }
    }
    public void setVidaMax(int vidaMax){//SETTER ATRIBUTO EXTRA 
        this.vidaMax =vidaMax;
    }

    public void setInteligenciaMax(int inteligenciaMax){//SETTER ATRIBUTO EXTRA 
        this.inteligenciaMax =inteligenciaMax;
    }

    public void setManaMax(int manaMax){ //SETTER ATRIBUTO EXTRA 
        this.manaMax = manaMax;
    }

    public void setFuerzaMax(int fuerzaMax){//SETTER ATRIBUTO EXTRA 
        this.fuerzaMax = fuerzaMax;
    }

    public void setEnergiaMax(int energiaMax){//SETTER ATRIBUTO EXTRA 
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
