package poo;

public abstract class Tierra {
    //atributos
    private float probabilidad_enemigo;

    private Monstruo monstruo;

    private Jefe_Final jefe_final;

    private NPC npc;

    //constuctor
    public Tierra(float probabilidad_enemigo,Monstruo monstruo, Jefe_Final jefe_final, NPC npc){
        this.probabilidad_enemigo = probabilidad_enemigo;
        this.monstruo = monstruo;
        this.jefe_final = jefe_final;
        this.npc = npc;
    }
    
    public abstract boolean accion(Jugador Jugador);

    public Jefe_Final getJefe_final() { //getter
        return jefe_final;
    }
    public Monstruo getMonstruo() {//getter
        return monstruo;
    }
    public NPC getNpc() {//getter
        return npc;
    }
    public float getProbabilidad_enemigo() {//getter
        return probabilidad_enemigo;
    }

    public void setJefe_final(Jefe_Final jefe_final) {//setter
        this.jefe_final = jefe_final;
    }
    public void setMonstruo(Monstruo monstruo) {//setter
        this.monstruo = monstruo;
    }
    public void setNpc(NPC npc) {//setter
        this.npc = npc;
    }
    public void setProbabilidad_enemigo(float probabilidad_enemigo) {//setter
        this.probabilidad_enemigo = probabilidad_enemigo;
    }
}
