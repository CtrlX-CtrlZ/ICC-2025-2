import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Maquina maquina = new Maquina();
        int opcion;

        do {
            System.out.println("--Maquina de esteganofria--");
            System.out.println("Elige una opcion:");
            System.out.println("1. Cifrado nulo con la ultima letra de cada palabra");
            System.out.println("2. Cifrado nulo con la n-esima letra de cada palabra");
            System.out.println("3. Encontrar un nombre oculto");
            System.out.println("4. Mensaje marcando palabras");
            System.out.println("5. Mensaje marcando letras");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el mensaje original: ");
                    String mensaje1 = sc.nextLine();
                    System.out.println("Resultado: " + maquina.descifraNulo(mensaje1));
                    break;
                case 2:
                    System.out.print("Ingresa el mensaje original: ");
                    String mensaje2 = sc.nextLine();
                    System.out.print("Ingresa el indice (n): ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Resultado: " + maquina.descifraNulo(mensaje2, n));
                    break;
                case 3:
                    System.out.print("Ingresa el mensaje: ");
                    String mensaje3 = sc.nextLine();
                    System.out.print("Ingresa el nombre a buscar: ");
                    String nombre = sc.nextLine();
                    boolean contiene = maquina.contieneNombre(mensaje3, nombre);
                    System.out.println("¿Contiene el nombre oculto? " + (contiene ? "Si" : "No"));
                    break;
                case 4:
                    System.out.print("Ingresa el mensaje original: ");
                    String m4 = sc.nextLine();
                    System.out.print("Ingresa el mensaje alterado: ");
                    String e4 = sc.nextLine();
                    System.out.println("Resultado: " + maquina.decifraPalabrasMarcadas(m4, e4));
                    break;
                case 5:
                    System.out.print("Ingresa el mensaje original: ");
                    String m5 = sc.nextLine();
                    System.out.print("Ingresa el mensaje alterado: ");
                    String e5 = sc.nextLine();
                    String resultado = maquina.decifraLetrasMarcadas(m5, e5);
                    if (resultado != null) {
                        System.out.println("Resultado: " + resultado);
                    }
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opciin no valida.");
            }

        } while (opcion != 0);

    }
}