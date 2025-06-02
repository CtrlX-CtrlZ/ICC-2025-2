import java.util.Random;
import java.util.Scanner;

public class Juego {
    private class Jugador{
        private int puntosJugador;
        public Jugador(){
            this.puntosJugador = 0;
        }
        public int getPuntosJugador() {
            return puntosJugador;
        }
        public void setPuntosJugador(int puntosJugador) {
            this.puntosJugador = puntosJugador;
        }

    }

    private ListaLigada baraja;
    private ListaLigada barajaCentral;
    private ListaLigada barajaJugador;
    private ListaLigada barajaComputadora;
    private Jugador jugador;
    private Jugador computadora;
    public Juego(){
        baraja = new ListaLigada();
        barajaCentral = new ListaLigada();
        barajaJugador = new ListaLigada();
        barajaComputadora = new ListaLigada();
        jugador = new Jugador();
        computadora = new Jugador();
        generarCartas();
        barajear();
    }
    private void generarCartas(){
        Tamaño[] tamaños = Tamaño.values();
        Color[] colores = Color.values();
        for(int i=0; i<2; i++){
            Tamaño tamañoActual = tamaños[i];
            for(int j=0; j<2; j++){
                Color colorActual = colores[j];
                for(int k=1; k<3; k++){
                    for(int m=0; m<3; m++){
                        baraja.insertar(new Carta(tamañoActual, colorActual, k, true, true));
                        baraja.insertar(new Carta(tamañoActual, colorActual, k, true, false));
                        baraja.insertar(new Carta(tamañoActual, colorActual, k, false, true));
                        baraja.insertar(new Carta(tamañoActual, colorActual, k, false, false));
                    }
                }
            }
        }
    }
    public void barajear(){
        Random rd = new Random();
        ListaLigada barajaRandom = new ListaLigada();
        while(baraja.getLongitud() != 0){
            barajaRandom.insertar(baraja.extraer(rd.nextInt(baraja.getLongitud())));
        }
        baraja = barajaRandom;
    }
    private void repartirCartasCentrales(){
        final int CARTAS_MESA = 30;
        for(int i=0; i<CARTAS_MESA; i++){
            barajaCentral.insertar(baraja.extraerPrimero());
        }
    }
    private boolean selecionarCartaComputadora(){
        Carta carta = comparadorComputadora();
        if(carta == null){
            System.out.println("Ronda finalizada");
            return false;
        } else {
            barajaComputadora.insertar(carta);
            return true;
        }
    }
    private Carta comparadorComputadora(){
        Carta carta = barajaComputadora.consultarUltimo();
        int i=0;
        while (i<barajaCentral.getLongitud() && !carta.comparar(barajaCentral.buscar(i))){
            i++;
        }
        if (i == barajaCentral.getLongitud()){
            return null;
        }
        return barajaCentral.extraer(i);
    }
    private void selecionarCartaJugador(int indice) {
        barajaJugador.insertar(barajaCentral.extraer(indice - 1));
    }
    private void reiniciarRonda(){
        barajaJugador.limpiar();
        barajaComputadora.limpiar();
        barajaCentral.limpiar();
    }
    private void recuentoPuntos(){
        if(comprobarBaraja()){
            jugador.setPuntosJugador(jugador.getPuntosJugador() + barajaJugador.getLongitud());
        }
        computadora.setPuntosJugador(computadora.getPuntosJugador() + barajaComputadora.getLongitud());
        System.out.println("Los puntos del jugador despues de la ronda son: " + jugador.getPuntosJugador());
        System.out.println("Los puntos de la computadora despues de la ronda son: " + computadora.getPuntosJugador());
    }
    private void recuentoPuntosOp(){
        if(comprobarBarajaJugador()){
            jugador.setPuntosJugador(jugador.getPuntosJugador() + barajaJugador.getLongitud());
        }
        computadora.setPuntosJugador(computadora.getPuntosJugador() + barajaComputadora.getLongitud());
        System.out.println("Los puntos del jugador despues de la ronda son: " + jugador.getPuntosJugador());
        System.out.println("Los puntos de la computadora despues de la ronda son: " + computadora.getPuntosJugador());
    }
    private void recuentoPuntosOp1(){
        jugador.setPuntosJugador(jugador.getPuntosJugador() + barajaJugador.getLongitud());
        computadora.setPuntosJugador(computadora.getPuntosJugador() + barajaComputadora.getLongitud());
        System.out.println("Los puntos del jugador despues de la ronda son: " + jugador.getPuntosJugador());
        System.out.println("Los puntos de la computadora despues de la ronda son: " + computadora.getPuntosJugador());
    }
    private boolean comprobarBaraja(){
        if(comprobarBarajaJugador()){
            System.out.println("El orden en las cartas elegidas por el jugador es correcto");
            Carta ultimaCarta = barajaJugador.consultarUltimo();
            int i=0;
            while(i<barajaCentral.getLongitud() && !ultimaCarta.comparar(barajaCentral.buscar(i))){
                i++;
            }
            if(i == barajaCentral.getLongitud()){
                System.out.println("Ya no habian mas opciones de cartas por elegir");
                System.out.println("El jugador SUMA puntos");
                return true;
            } else {
                System.out.println("Existian mas opciones de cartas por elegir:");
                System.out.println(barajaCentral.buscar(i).toString());
                System.out.println("El jugador NO suma puntos");
                return false;
            }
        } else {
            System.out.println("El orden en las cartas elegidas por el jugador NO es correcto");
            System.out.println("El jugador NO suma puntos");
            return false;
        }
    }
    private boolean comprobarBarajaJugador(){
        if(barajaJugador.getLongitud() == 1){
            return true;
        }
        for(int i=0; i<barajaJugador.getLongitud()-1; i++){
            if(!(barajaJugador.buscar(i).comparar(barajaJugador.buscar(i+1)))){
                System.out.println(barajaJugador.buscar(i) + " No coresponde con " + barajaJugador.buscar(i+1));
                return false;
            }
        }
        return true;
    }
    private void ganador(){
        if(computadora.getPuntosJugador()>jugador.puntosJugador){
            System.out.println("El ganador es la computadora");
        } else {
            System.out.println("El ganador es el jugador");
        }
    }
    public static void jugar(){
        Juego juego = new Juego();
        Scanner scn = new Scanner(System.in);
        System.out.println("JUEGO DE CARTAS");
        System.out.println("Instruciones: ");
        System.out.println("Hay 96 cartas, 32 cartas diferentes y 3 miembros de cada tipo de carta");
        System.out.println("Hay 5 caracteristicas distintas para cada carta de un gato, con dos opciones posibles:");
        System.out.println("Color:= Verde , Morado");
        System.out.println("Tamaño:= Chico: =^._.^= , Grande: =(o_o)=");
        System.out.println("Brazos:= Un brazo: <- , Dos brazos: <- ->");
        System.out.println("Estado:= Feliz: ^_^ , No feliz: >_<");
        System.out.println("Lentes:= Circulares: -●-●- , Cuadrados: -■-■-");
        System.out.println("Al iniciar la ronda se repartiran 30 de las 96 cartas al centro de la mesa");
        System.out.println("Se te asignara tu primera carta y la primera carta de la computadora");
        System.out.println("Tendras que elegir una carta con a lo mas una diferencia con respecto a la ultima carta escogida");
        System.out.println("Tu tarea es elegir la mayor cantidad de cartas posibles");
        System.out.println("Si ya no es posible elegir otra carta tendras que terminar la ronda");
        System.out.println("Al finalizar cada ronda se sumará un punto por cada carta de la baraja solo si se cumple:");
        System.out.println("    1. Ya no se podian elegir mas cartas del centro");
        System.out.println("    2. Las diferencias entre cada carta de la baraja del jugador sean a lo mas una");
        System.out.println("Al finalizar cada ronda se descartaran las cartas que queden en el centro y se rellenara el centro con mas cartas de la baraja principal");
        System.out.println("Gana el que junte más puntos");
        int k=1;
        while (juego.baraja.getLongitud() >= 30) {
            System.out.println("------------------Inicia la Ronda " + k +"------------------");
            System.out.println("Se reparten las cartas centrales");
            juego.repartirCartasCentrales();
            System.out.println(juego.barajaCentral.toString());
            System.out.println("Se le asigna su primera carta al jugador");
            juego.barajaJugador.insertar(juego.baraja.extraerPrimero());
            System.out.println(juego.barajaJugador.toString());
            System.out.println("Se le asigna su primera carta a la computadora");
            juego.barajaComputadora.insertar(juego.baraja.extraerPrimero());
            System.out.println(juego.barajaComputadora.toString());
            boolean aux = true;
            boolean auxMenu = true;
            while (aux) {
                System.out.println("Elige una opción: ");
                System.out.println("1. Elegir una carta");
                System.out.println("2. Terminar ronda (No hay mas cartas por selecionar)");
                int opcion = scn.nextInt();
                while (opcion <= 0 || opcion > 2) {
                    System.out.print("Digita una opcion valida: ");
                    opcion = scn.nextInt();
                }
                if (opcion == 2) {
                    System.out.println("Ronda finalizada\n");
                    auxMenu = false;
                    break;
                }
                if (juego.barajaCentral.getLongitud() == 0){
                    System.out.println("Ronda finalizada\n");
                    break;
                }
                System.out.println(juego.barajaCentral.toString());
                System.out.println("Elige una carta: ");
                int opcionCarta = scn.nextInt();
                while (opcionCarta <= 0 || opcionCarta > juego.barajaCentral.getLongitud()) {
                    System.out.print("Digita una opcion valida: ");
                    opcionCarta = scn.nextInt();
                }
                juego.selecionarCartaJugador(opcionCarta);
                System.out.println("Tu baraja es: ");
                System.out.println(juego.barajaJugador.toString());
                aux = juego.selecionarCartaComputadora();
                System.out.println("La baraja de la computadora es: ");
                System.out.println(juego.barajaComputadora.toString());
            }
            if(auxMenu){
                juego.recuentoPuntosOp(); //
            } else {
                juego.recuentoPuntos();
            }
            if(juego.barajaCentral.getLongitud() == 0){
                juego.recuentoPuntosOp1();
            }
            juego.reiniciarRonda();
            k++;
        }
        System.out.println("Fin del juego");
        juego.ganador();
    }
}