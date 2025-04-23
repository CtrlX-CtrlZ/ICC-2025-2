public class Main {
    public static void main(String[] args) {
       Recipiente r1 = new Recipiente(10, 5, 50);
       Recipiente r2 = new Recipiente(7, 4, 20);
 
       System.out.println("Estado inicial de los recipientes:");
       System.out.println("Recipiente 1:\n" + r1.muestra());
       System.out.println("Recipiente 2:\n" + r2.muestra());
       System.out.println("----------------------------------");
 
       System.out.println("Capacidad de r1: " + r1.capacidad());
       System.out.println("Capacidad restante de r1: " + r1.capacidadRestante());
       System.out.println("Capacidad de r2: " + r2.capacidad());
       System.out.println("Capacidad restante de r2: " + r2.capacidadRestante());
       System.out.println("----------------------------------");
 
       System.out.println("Rellenando r1 con 100 centimetros cubicos");
       double excedente = r1.rellena(100);
       System.out.println("Excedente al intentar rellenar r1: " + excedente);
       System.out.println("Nuevo estado de r1:\n" + r1.muestra());
       System.out.println("----------------------------------");
 
       System.out.println("Vaciando r2");
       double cantidadVaciada = r2.vacia();
       System.out.println("Cantidad vaciada de r2: " + cantidadVaciada);
       System.out.println("Nuevo estado de r2:\n" + r2.muestra());
       System.out.println("----------------------------------");
 
       System.out.println("Vertiendo líquido de r1 a r2");
       r1.vierte(r2);
       System.out.println("Nuevo estado de r1:\n" + r1.muestra());
       System.out.println("Nuevo estado de r2:\n" + r2.muestra());
       System.out.println("----------------------------------");
 
       System.out.println("r1 y r2 tienen las mismas dimensiones: " + r1.mismasDimensiones(r2));
       System.out.println("r1 y r2 tienen la misma capacidad total: " + r1.mismaCapacidad(r2));
       System.out.println("r1 contiene más líquido que r2: " + r1.contieneMas(r2));
       System.out.println("r1 tiene más capacidad restante que r2: " + r1.cabeMas(r2));
       System.out.println("----------------------------------");
 
 
       System.out.println("Creando un nuevo recipiente con capacidad justa para el contenido de r2");
       Recipiente r3 = r2.creaContenedorJusto();
       System.out.println("Nuevo recipiente r3 creado:\n" + r3.muestra());
       System.out.println("----------------------------------");
 
       System.out.println("Estado final de los recipientes:");
       System.out.println("Recipiente 1:\n" + r1.muestra());
       System.out.println("Recipiente 2:\n" + r2.muestra());
       System.out.println("Recipiente 3:\n" + r3.muestra());
    }
 }