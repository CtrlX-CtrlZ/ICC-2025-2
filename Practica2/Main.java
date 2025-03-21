import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        System.out.println("SIMULACION DE UN RELOJ");
        System.out.println("Digita una opcion");
        System.out.println("1. Simulacion con ciclo for");
        System.out.println("2. Simulacion con ciclo while");
        System.out.println("3. Simulacion con ciclo do-while");
        opcion = sc.nextInt();
        switch (opcion){
            case 1: System.out.println("Simulacion con ciclo for:");
                Reloj reloj1 = new Reloj(23, 59, 50);
                System.out.println("Hora inicial: " + reloj1.mostrar());


                for (int i = 0; i < 15; i++) {
                    reloj1.incrementaSegundos(1);
                    System.out.println("Tiempo actual: " + reloj1.mostrar());
                }
            break;
            case 2: System.out.println("\nSimulacion con ciclo while:");
                Reloj reloj2 = new Reloj(23, 59, 50);
                System.out.println("Hora inicial: " + reloj2.mostrar());

                int count = 0;
                while (count < 15) {
                    reloj2.incrementaSegundos(2);
                    System.out.println("Tiempo actual: " + reloj2.mostrar());
                    count++;
                }
                break;
            case 3: System.out.println("\nSimulacion con ciclo do-while:");
                Reloj reloj3 = new Reloj(23, 59, 50);
                System.out.println("Hora inicial: " + reloj3.mostrar());

                int counter = 0;
                do {
                    reloj3.incrementaSegundos(3);
                    System.out.println("Tiempo actual: " + reloj3.mostrar());
                    counter++;
                } while (counter < 15);
                break;
            default: System.out.println("Valor no valido");
        }
    }
}