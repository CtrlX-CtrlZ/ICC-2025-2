import java.util.Scanner;

public class Main {
    public static  void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int opcion;
        double numero1, numero2, resultado=0;
        System.out.println("CALCULADORA");
        System.out.println("Digite una opcion");
        System.out.println("1. Suma");
        System.out.println("2. Multiplicacion");
        System.out.println("3. Division");
        opcion = scn.nextInt();
        if (opcion>0 && opcion<=3) {
            System.out.print("Digita el primer numero: ");
            numero1 = scn.nextDouble();
            System.out.print("Digita el segundo numero: ");
            numero2 = scn.nextDouble();
            switch (opcion){
                case 1: resultado = numero1 + numero2;
                    break;
                case 2: resultado = numero1 * numero2;
                    break;
                case 3: resultado = numero1 / numero2;
                    break;
            }
            System.out.println("El resultado es: " + resultado);
        } else{
            System.out.println("Se digito una opcion no valida");
        }
    }

}