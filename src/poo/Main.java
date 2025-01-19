package poo;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el tamaño del mundo: ");  //se pide por pantalla el tamaño del mundo
        int tamaño = entrada.nextInt(); //guardo el tamaño
        entrada.nextLine(); //uso esto para que no tome el enter cuando use algun NEXTLINE()


        Tierra[] mundo = new Tierra[tamaño]; //se inicializa el mundo
        
        //inicializo algunas variables en null para el caso en que no se usen dentro de alguna casilla
        Jefe_Final jefe = null; 
        Neutro neutro = null;
        Bueno bueno = null;
        Malo malo = null;
        Monstruo monstruo =null;


        for (int i=0;i<tamaño;i++) { //recorremos las casillas del mundo
            System.out.println("Casilla "+i+" ¿Que tipo de tierra es? (planicie/bosque/montana): "); //pregunto el tipo de mundo
            String tipo = entrada.nextLine(); //almaceno el tipo de mundo

            System.out.println("¿Cual es la probabilidad de enemigo? (float de 0 a 1): "); //la probabilidad de que aparezca el enemigo
            float probabilidad= entrada.nextFloat();
            entrada.nextLine(); //uso esto para que no tome el enter cuando use algun NEXTLINE()
            if(probabilidad != 0){ // si la probabilidad es diferente de 0 pregunta el tipo de enemigo
                System.out.println("¿Tipo de enemigo? (jefe/monstruo): ");
                String enemigo = entrada.nextLine();
                if (enemigo.equals("jefe")){ //si ingresan por pantalla tipo de enemigo igual jefe, entonces te pedira sus atributos y lo crea
                    System.out.println("¿Cual es el nombre del Jefe final? ");
                    String nombre_jefe = entrada.nextLine();
                    System.out.println("¿Cual es la vida del Jefe final? ");
                    int vida = entrada.nextInt();
                    System.out.println("¿Cual es el dano del Jefe final? ");
                    int dano = entrada.nextInt();
                    entrada.nextLine();
                    jefe = new Jefe_Final(nombre_jefe, vida, dano);
            
                }else{ //si ingresa monstruo te pedira sus atributos y lo crea
                    System.out.println("¿Cual es la vida del Monstruo? ");
                    int vida_monstruo = entrada.nextInt();
                    System.out.println("¿Cual es el dano del Monstruo? ");
                    int dano_monstruo = entrada.nextInt();
                    entrada.nextLine();
                    monstruo = new Monstruo(vida_monstruo, dano_monstruo);
                }

            }
            
            System.out.println("¿Habrá NPC? (si/no): ");
            String opcion = entrada.nextLine();
                if (opcion.equals("si")){ //si eliges agregar un npc, te pedira el tipo de npc, sus atributos y lo crea.
                    System.out.println("¿Que tipo de NPC? (neutro/bueno/malo): ");
                    String tipo_NPC = entrada.nextLine();
                    if( tipo_NPC.equals("neutro")){  //si escogio neutro te pedira algunos atributos y lo crea
                        System.out.println("¿Cual es el nombre del NPC?: ");
                        String nombre = entrada.nextLine();
                        System.out.println("¿Cual es el Requisito? (v/m): ");
                        char requisito;
                        requisito = entrada.next().charAt(0); //almaceno el requisito como un char
                        System.out.println("¿Cual es el valor?: (numero de casilla / numero de monstruos) ");
                        int valor = entrada.nextInt();
                        System.out.println("¿Cual es la recompensa? (ingrese numero de XP): ");
                        int recompensa = entrada.nextInt();
                        entrada.nextLine(); //uso esto para que no tome el enter cuando use algun NEXTLINE()
                        neutro = new Neutro(nombre,requisito,valor,recompensa,0);

                        if(tipo.equals("planicie")){ //luego rellena la casilla respectiva con el tipo de tierra que elegiste, los enemigos y npc
                            mundo[i] = new Planicie(probabilidad, monstruo, jefe, neutro);
                        }else if(tipo.equals("bosque")){
                            mundo[i] = new Bosque(probabilidad, monstruo, jefe, neutro);
                        }else{
                            mundo[i] = new Montana(probabilidad, monstruo, jefe, neutro);
                        }

                    }else if ( tipo_NPC.equals("bueno")){ //si escogio bueno te pedira algunos atributos y lo crea
                        System.out.println("¿Cual es el nombre del NPC? ");
                        String nombre = entrada.nextLine();
                        System.out.println("¿Cual es el atributo que mejor? (vida/mana/energia/xp)");
                        String atributo = entrada.nextLine();
                        System.out.println("¿Cuanto mejora? (ingrese entero)");
                        int cantida = entrada.nextInt();
                        entrada.nextLine(); 
                        bueno = new Bueno(nombre, cantida, atributo);

                        if(tipo.equals("planicie")){ //rellena la casilla respectiva con el tipo de tierra que elegiste, los enemigos y npc
                            mundo[i] = new Planicie(probabilidad, monstruo, jefe, bueno);
                        }else if(tipo.equals("bosque")){
                            mundo[i] = new Bosque(probabilidad, monstruo, jefe, bueno);
                        }else{
                            mundo[i] = new Montana(probabilidad, monstruo, jefe, bueno);
                        }

                    }else{ //caso por si eligio npc malo, te pide atributos y lo crea 
                        System.out.println("¿Cual es el nombre del NPC? ");
                        String nombre = entrada.nextLine();
                        System.out.println("¿Cual la cantidad de energia que quita?");
                        int energia = entrada.nextInt();
                        System.out.println("¿Cual la cantidad de mana que quita?");
                        int mana = entrada.nextInt();
                        entrada.nextLine();
                        malo = new Malo(nombre, energia, mana);


                        if(tipo.equals("planicie")){//rellena la casilla respectiva con el tipo de tierra que elegiste, los enemigos y npc
                            mundo[i] = new Planicie(probabilidad, monstruo, jefe, malo);
                        }else if(tipo.equals("bosque")){
                            mundo[i] = new Bosque(probabilidad, monstruo, jefe, malo);
                        }else{
                            mundo[i] = new Montana(probabilidad, monstruo, jefe, malo);
                        }
                    }
                }else{ //aqui rellena la casilla pero para el caso en que el npc es nulo, es decir, el dm no puso npc
                    if(tipo.equals("planicie")){
                        mundo[i] = new Planicie(probabilidad, monstruo, jefe, null);
                    }else if(tipo.equals("bosque")){
                        mundo[i] = new Bosque(probabilidad, monstruo, jefe, null);
                    }else{
                        mundo[i] = new Montana(probabilidad, monstruo, jefe, null);
                    }
                }
            
            
            //luego reseteamos las variables a null
            jefe = null;
            neutro = null;
            bueno = null;
            malo = null;
            monstruo =null;
        }
        int posicion; //posicion del personaje
        ArrayList <Mision> misiones =new ArrayList<Mision>(); //inicializo la lista de misiones
        Jugador jugador; //creamos el jugador y pedimos sus atributos y el tipo 

        //realiza unas preguntas al jugador y crea su personaje
        System.out.println("¿Cual es la posicion del Jugador?"); 
        posicion = entrada.nextInt();
        entrada.nextLine();

        System.out.println("¿Que tipo de personaje deseas usar?(mago/druida/guerrero)");
        String tipo_person = entrada.nextLine();
        System.out.println("¿Cual es tu nombre de Jugador?");
        String name = entrada.nextLine();

        if(tipo_person.equals("mago")){ //aqui segun el tipo que escogio crea un mago, druida, guerrero, con el nombre que escogio
            jugador = new Mago(name, misiones);
        }else if(tipo_person.equals("druida")){
            jugador = new Druida(name,misiones);
        }else{
            jugador = new Guerrero(name,misiones);
        }

        boolean salir = false; //variable para salir del menu
        int opcion2; //opcion para el menu

        //menu
        while (!salir) {
 
            System.out.println("1. Mover a derecha");
            System.out.println("2. Mover a izquierda");
            System.out.println("3. Mostrar atributos");
            System.out.println("4. Salir");
 
            try {
                
                System.out.println("Escribe una de las opciones");
                opcion2 = entrada.nextInt();
                entrada.nextLine();
                int dado; //dado para que la aparicion de monstruos dependa de la probabilidad
 
                switch (opcion2) {
                    case 1:
                        posicion+=1; //aumentamos la posicion en 1 para mover a la derecha
                        if(posicion>(tamaño-1)){ //caso para hacer el mundo ciclico
                            posicion = 0;
                        }

                        if(mundo[posicion].accion(jugador)){ //si la interaccion es true puedes avanzar
                            System.out.println("Puedes avanzar");
                            dado = (int)(Math.random()*100+1); //dadod del 0 a 100
                            float probability = mundo[posicion].getProbabilidad_enemigo() * 100; //transformo probabilidad a entero para compara con el dado luego

                            if(mundo[posicion].getMonstruo()!= null || mundo[posicion].getJefe_final()!= null ){ //mientra exista algun enemigo puede haber combate
                                if(probability > dado){ //si la probabilidad es mayor al numero al azar del dado aparecera un enemigo
                                    if (mundo[posicion].getMonstruo()!= null ){
                                        mundo[posicion].getMonstruo().combate(jugador); //combate contra monstruo

                                        if(jugador.getVida() == 0){ //en caso de tener vida igual 0 pierdes y termina el juego
                                            System.out.println("Game over!, has sido derrotado");
                                            salir = true;
                                            break;
                                        }

                                        for(int i =0; i<jugador.getLista_misiones().size();i++){ //verificacion de las misiones y actualizacion de la cantidad en la mision
                                            if(jugador.getLista_misiones().get(i).getRequisito() == 'm'){
                                                jugador.getLista_misiones().get(i).setCantidad(jugador.getLista_misiones().get(i).getCantidad()+1); //si superaste el combate contra el monstruo se sumara a 1 a las misiones con requisito m
                                            }
                                            if(jugador.getLista_misiones().get(i).verificar_requisito()){ //si el requisito de la mision esta completo, te daran la recompensa
                                                int agregarxp =jugador.getLista_misiones().get(i).getRecompensa();
                                                jugador.subir_experiencia(agregarxp);
                                                System.out.println("Has recibido la recompensa de " + jugador.getLista_misiones().get(i).getRecompensa() + " de XP por cumplir Mision");
                                                jugador.getLista_misiones().remove(i);// se remueve la mision
                                            }
                                        }
                                    }else{
                                        mundo[posicion].getJefe_final().combate(jugador); //combate contra jefe
                                        if(mundo[posicion].getJefe_final().getVida() == 0){//en caso de derrotar al jefe termina el juego y ganaste
                                            System.out.println("Has ganado el Juego Felicitaciones!!");
                                            salir = true;
                                        }
                                        if(jugador.getVida() == 0){
                                            System.out.println("Game over!, has sido derrotado"); //en caso de tener vida igual 0 pierdes y termina el juego
                                            salir = true;
                                            break;
                                        }
                                    }
                                }else{
                                    System.out.println("No aparecieron Enemigos");
                                }

                            }else{
                                System.out.println("No hay Enemigos");
                            }
                            if(mundo[posicion].getNpc()!= null && jugador.getVida() > 0 && salir != true){//condiciones para interactuar con el npc
                                System.out.println("Te has encontrado con un NPC"); //interaccion con el npc
                                mundo[posicion].getNpc().interaccion(jugador);
                            
                            }else if (salir != true && jugador.getVida() > 0){
                                
                                System.out.println("No hay NPCs");
                                
                            }   
                            
                            for(int i =0; i<jugador.getLista_misiones().size();i++){ //revision de misiones y actualizacion del atributo cantidad de la mision
                                if(jugador.getLista_misiones().get(i).getRequisito() == 'v'){ 
                                    jugador.getLista_misiones().get(i).setCantidad(posicion); //se actualiza la cantidad, segun la posicion en que estes actualmente
                                }
                                if(jugador.getLista_misiones().get(i).verificar_requisito()){ //si cumple el requisito, te daran tu recompensa
                                    int agregarxp =jugador.getLista_misiones().get(i).getRecompensa();
                                    jugador.subir_experiencia(agregarxp);
                                    System.out.println("Has recibido la recompensa de " + jugador.getLista_misiones().get(i).getRecompensa() + " de XP por cumplir Mision");
                                    jugador.getLista_misiones().remove(i);// se remueve la mision
                                }
                            }

                        }else{ //caso donde no se pueda ir a la derecha
                            posicion-=1;
                            if(posicion < 0){ // caso para mundo ciclico
                                posicion = tamaño-1;
                            }
                            System.out.println("No Puedes avanzar");
                        }
                    
                        

                        break;
                    case 2:
                        posicion-=1; //restamos la posicion en 1 para mover a la derecha
                        if(posicion<0){ //caso para hacer el mundo ciclico
                            posicion = (tamaño-1);
                        }


                        if(mundo[posicion].accion(jugador)){ //si la interaccion es true puedes avanzar
                            System.out.println("Puedes avanzar");
                            dado = (int)(Math.random()*100+1); //lanzamiento de dado del 0 al 100
                            float probability = mundo[posicion].getProbabilidad_enemigo() * 100; //transformo probabilidad a entero para compara con dado
                            if(mundo[posicion].getMonstruo()!= null || mundo[posicion].getJefe_final()!= null ){
                                if(probability > dado){ //si la probabilidad es mayor al numero al azar del dado aparecera un enemigo
                                    if (mundo[posicion].getMonstruo()!= null ){
                                        mundo[posicion].getMonstruo().combate(jugador); //combate con monstruos

                                        if(jugador.getVida() == 0){ //en caso de tener vida igual 0 pierdes y termina el juego
                                            System.out.println("Game over!, has sido derrotado");
                                            salir = true;
                                            break;
                                        }


                                        for(int i =0; i<jugador.getLista_misiones().size();i++){ //verificacion de las misiones y actualizacion de la cantidad en la mision
                                            if(jugador.getLista_misiones().get(i).getRequisito() == 'm'){ 
                                                jugador.getLista_misiones().get(i).setCantidad(jugador.getLista_misiones().get(i).getCantidad()+1); //si superaste el combate se suma 1 a toda mision con requisito m
                                            }
                                            if(jugador.getLista_misiones().get(i).verificar_requisito()){ //si cumple el requisito se otorga tu recompensa
                                                int agregarxp =jugador.getLista_misiones().get(i).getRecompensa();
                                                jugador.subir_experiencia(agregarxp);
                                                System.out.println("Has recibido la recompensa de " + jugador.getLista_misiones().get(i).getRecompensa() + " de XP por cumplir Mision");
                                                jugador.getLista_misiones().remove(i); // se remueve la mision
                                            }
                                        }
                
                                    }else{
                                        mundo[posicion].getJefe_final().combate(jugador); //combate con el jefe 
                                        if(mundo[posicion].getJefe_final().getVida() == 0){ //en caso de derrotar al jefe termina el juego y ganaste
                                            System.out.println("Has ganado el Juego Felicitaciones!!");
                                            salir = true;
                                        }
                                        if(jugador.getVida() == 0){
                                            System.out.println("Game over!, has sido derrotado");
                                            salir =true;
                                        }
                                    }
                                    if(jugador.getVida() == 0){
                                        System.out.println("Game over!, has sido derrotado");  //en caso de tener vida igual 0 pierdes y termina el juego
                                        salir = true;
                                    }
                                }else{
                                    System.out.println("No aparecieron Enemigos");
                                }
                            }else{
                     
                                System.out.println("No hay Enemigos");
                            }
                            if(mundo[posicion].getNpc()!= null && jugador.getVida() > 0 && salir != true ){ //condiciones para interactuar con el npc
                                System.out.println("Te has encontrado con un NPC"); //interaccion con el npc
                                mundo[posicion].getNpc().interaccion(jugador); 
                            
                            }else if (salir != true && jugador.getVida() > 0){
                                System.out.println("No hay NPCs");
                            }

                            for(int i =0; i<jugador.getLista_misiones().size();i++){ //revision de misiones y actualizacion del atributo cantidad de la mision
                                if(jugador.getLista_misiones().get(i).getRequisito() == 'v'){
                                    jugador.getLista_misiones().get(i).setCantidad(posicion);
                                }
                                if(jugador.getLista_misiones().get(i).verificar_requisito()){
                                    int agregarxp =jugador.getLista_misiones().get(i).getRecompensa();
                                    jugador.subir_experiencia(agregarxp);
                                    System.out.println("Has recibido la recompensa de " + jugador.getLista_misiones().get(i).getRecompensa() + " de XP por cumplir Mision");
                                    jugador.getLista_misiones().remove(i);
                                }
                            }
                        }else{
                            posicion+=1;  //caso donde no puedas ir a la izquierda
                            if(posicion>(tamaño-1)){ // caso para mundo ciclico
                                posicion = 0;
                            }
                            System.out.println("No Puedes avanzar");
                        }
                        
                        break;
                    case 3: //caso para mostrar atributos 
                        System.out.println("La posicion de tu personaje es: "+ posicion);
                        System.out.println("El nombre de tu personaje es: " + jugador.getName());
                        System.out.println("La vida de tu personaje es: " + jugador.getVida());
                        System.out.println("La energia de tu personaje es: " + jugador.getEnergia());
                        System.out.println("El mana de tu personaje es: " + jugador.getMana());
                        System.out.println("La inteligencia de tu personaje es: " + jugador.getInteligencia());
                        System.out.println("La Fuerza de tu personaje es: " + jugador.getFuerza());
                        System.out.println("Tienes " + jugador.getXp() + " de XP");
                        break;
                    case 4:
                        salir = true; 
                        System.out.println("Gracias por jugar mi juego");
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                entrada.next();
            }
        }
        entrada.close();
    }
}
