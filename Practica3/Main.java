public class Main {
    public static void main(String[] args) {
        ListaLigada list = new ListaLigada();
        System.out.println("Lista vacia:");
        System.out.println(list.toString());
        list.insertar(1);
        list.insertar(4);
        list.insertar(8);
        list.insertar(5);
        list.insertar(3);
        System.out.println("Lista con 5 elementos:");
        System.out.println(list.toString());
        list.eliminar(1);
        System.out.println("Lista despues de eliminar la cabeza:");
        System.out.println(list.toString());
        list.eliminar(5);
        System.out.println("Lista despues de eliminar un elemento distinto de la cabeza y la cola:");
        System.out.println(list.toString());
    }
}