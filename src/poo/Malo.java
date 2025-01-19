package poo;

public class Malo extends NPC {
    //atributos
    private int cantidad_Energia;
    
    private int cantidad_Mana;

    public Malo(String nombre,int cantidad_Energia, int cantidad_Mana){ //contructor 
        super(nombre);//herencia
        this.cantidad_Energia = cantidad_Energia;
        this.cantidad_Mana = cantidad_Mana;

    }
    public void setCantidaEnergia(int energia){ //SETTER 
        cantidad_Energia = energia;
    }
    public void setCantidaMana(int mana){ //SETTER
        cantidad_Mana = mana;
    }


    public int getCantidadEnergia() { //GETTER
        return cantidad_Energia;
    }

    public int getCantidadMana() {//GETTER
        return cantidad_Mana;
    }

    @Override
    public void interaccion(Jugador Jugador){  //metodo abstracto de NPC

        int numero1 = (int)(Math.random()*10+1); //Entrega un numero entre 1 y 10 de manera aleatoria
        int numero2 = (int)(Math.random()*10+1);
        //mesaje por pantalla
        System.out.println( getName()+ ": SOY MALO TE VOY A DISMINUIR TU ENERGIA y MANA EN " + getCantidadEnergia() + " y " + getCantidadMana());
        System.out.println("*Tira un dado*");
        if (numero1 <= 6){ //SI SALE NUMERO MENOR A 6 imprime lo siguiente
            System.out.println("Salio un numero menor a 6, te quitare Energia");
            Jugador.setEnergia(Jugador.getEnergia() - getCantidadEnergia()); //setea la energia del jugador, restandole la cantida respectiva de energia
        }else{
            System.out.println("Salio un numero mayor a 6, no te quitare Energia"); //si sale mayor a 6 no le resta nada 
        }

        if (numero2 <= 6){  //Sucede lo mismo que en el caso anterior SI SALE NUMERO MENOR A 6 imprime lo siguiente
            System.out.println("Salio un numero menor a 6, te quitare Mana");
            Jugador.setMana(Jugador.getMana() - getCantidadMana());
        }else{
            System.out.println("Salio un numero mayor a 6, no te quitare Mana"); //si sale mayor a 6 no le resta nada 
        }

        if(Jugador.getMana() < 0){  //Esto funciona para que el mana no sea menor a 0 al disminuirlo
            Jugador.setMana(0);
        }

        if(Jugador.getEnergia() < 0){   //Esto funciona para que la energia no sea menor a 0 al disminuirla
            Jugador.setEnergia(0);
        }

    
    }
    
}
