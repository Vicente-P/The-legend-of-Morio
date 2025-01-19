package poo;

public class Mision {

    //atributos
    private char requisito;

    private int valor;

    private int cantidad = 0;

    private int recompensa;

    public Mision(char requisito, int valor, int cantidad, int recompensa){ //constructor

        this.requisito = requisito;
        this.valor = valor;
        this.cantidad=cantidad;
        this.recompensa = recompensa;

    }

    public char getRequisito(){//getter
        return requisito;
    }

    public int getValor(){//getter
        return valor;
    }

    public int getCantidad(){//getter
        return cantidad;
    }

    public int getRecompensa(){//getter
        return recompensa;
    }

    public void setRequisito(char requisito){//setter

        this.requisito = requisito;
    }

    public void setValor(int valor){//setter

        this.valor = valor;
    }

    public void setCantidad(int cantidad){//setter 
        this.cantidad = cantidad;
    }

    public void setRecompensa(int recompensa){//setter
        this.recompensa = recompensa;
    }

    public boolean verificar_requisito(){ //metodo booleano que retorna true si complimos el requisito y false si es que no lo hicimos
        if(cantidad == valor){
            return true;
        }else{
            return false;
        }
    }

}
