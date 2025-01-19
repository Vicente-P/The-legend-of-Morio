package poo;

import java.util.*;


public class Neutro extends NPC {
    //atributos
    private char requisito;
    private int valor;
    private int recompensa;
    private int ya_dio_mision;

    public Neutro(String nombre,char requisito,int valor,int recompensa, int ya_dio_mision){ //constructor
        super(nombre);
        this.requisito = requisito;
        this.valor = valor;
        this.recompensa = recompensa;
        this.ya_dio_mision = ya_dio_mision;
    }

    public void setValor(int valor){//setter

        this.valor = valor;
    }

    public void setRequisito(char requisito){//setter

        this.requisito = requisito;
    }

    public void setRecompensa(int recompensa){//setter

        this.recompensa = recompensa;
    }

    public void setDioMision(int ya_dio_mision){//setter

        this.ya_dio_mision = ya_dio_mision;
    }

    public int getValor(){//getter

        return valor;

    }
    public int getRecompensa(){//getter

        return recompensa;

    }
    public char getRequisito(){//getter

        return requisito;

    }
    public int getDioMision(){//getter

        return ya_dio_mision;

    }



    @Override
    public void interaccion(Jugador Jugador){ //metodo Abstracto de NPC
        Scanner entrada = new Scanner(System.in);//abro un scanner para que el jugador puede elegir si aceptar o no la mision.
        if(getDioMision() == 0){
            if(getRequisito() == 'm'){ //si el requisito es m habla con respecto a matar monstruos, sino habla sobre llegar a una casilla en especifico
                System.out.println( getName()+ ": hola, ¿quieres cumplir esta mision? Deberas matar " + getValor() + " Monstruos y recibiras "  +  getRecompensa()+" de XP");
            }else{
                System.out.println( getName()+ ": hola, ¿quieres cumplir esta mision? Deberas Llegar a la casilla " + getValor() + " del Mundo y recibiras "  + getRecompensa() +" de XP");
            }
            String decision ="";
            System.out.println("¿Deseas aceptar la mision? (si/no)"); //si aceptas la mision se agrega la mision a tu lista y ya_dio_mision cambia a 1.

            decision = entrada.nextLine();
        
            if(decision.equals("si")){ //si decide hacer la mision esta se agrega a su lista
                Mision mision = new Mision(getRequisito(),getValor(),0,getRecompensa());
                ArrayList<Mision> misiones_actuales = Jugador.getLista_misiones();
                misiones_actuales.add(mision);
                Jugador.setLista_misiones(misiones_actuales);
                setDioMision(1);
            }else{
                System.out.println("no has aceptado la mision, adios"); //sino saldra este mensaje
            }


        }else{ //si vuelves a interactuar despues de aceptar la mision te dira este mensaje
            System.out.println( getName()+ ": ya te di mision, saludos.");
        }
    }

    
    
}
