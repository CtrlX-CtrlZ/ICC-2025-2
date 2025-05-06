public class Main {
    public static void main(String[] args) {
        //Se crea un primer triangulo usando la clase Triangulo
        Triangulo triangulo1 = new Triangulo(3, 4, 5);
        //Se crea un segundo triangulo usando la clase FiguraGeometrica
        FiguraGeometrica triangulo2 = new Triangulo(6, 8, 10);
        //Se crea un rectangulo usando su clase respectiva
        Rectangulo rectangulo = new Rectangulo(5, 10);
        //Se crea un cuadrado usando su clase respectiva
        Cuadrado cuadrado = new Cuadrado(7);

        System.out.println("Área del Triángulo 1: " + triangulo1.obtenerArea());
        System.out.println("Perímetro del Triángulo 1: " + triangulo1.obtenerPerimetro());
        System.out.println();
        // El objeto triangulo2 es un objeto de tipo Triangulo pero declarado como FiguraGeometrica
        // Aunque FiguraGeometrica es una clase abstracta y no tiene una implementación concreta del metodo obtenerArea
        // Java sabe que triangulo2 es en realidad un Triangulo gracias al polimorfismo,
        // por lo tanto ejecuta automáticamente la versión del metodo obtenerArea que esta en la clase Triangulo

        System.out.println("Área del Triángulo 2: " + triangulo2.obtenerArea());
        System.out.println("Perímetro del Triángulo 2: " + triangulo2.obtenerPerimetro());
        System.out.println();

        System.out.println("Área del Rectángulo: " + rectangulo.obtenerArea());
        System.out.println("Perímetro del Rectángulo: " + rectangulo.obtenerPerimetro());
        System.out.println();

        System.out.println("Área del Cuadrado: " + cuadrado.obtenerArea());
        System.out.println("Perímetro del Cuadrado: " + cuadrado.obtenerPerimetro());

        System.out.println(cuadrado.toString());
        System.out.println(rectangulo.toString());
        System.out.println(triangulo1.toString());
        System.out.println(triangulo2.toString());


    }
}
