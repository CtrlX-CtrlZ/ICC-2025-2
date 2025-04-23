public class ListaLigada {
    private Nodo cabeza;
    private int longitud;
    public ListaLigada(){
        cabeza = null;
        longitud = 0;
    }
    private class Nodo{
        private int elemento;
        private Nodo siguiente;
        public Nodo(int elemento){
            this.elemento = elemento;
        }
        public void setElemento(int elemento) {
            this.elemento = elemento;
        }
        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }
        public int getElemento() {
            return elemento;
        }
        public Nodo getSiguiente() {
            return siguiente;
        }
    }
    // Metodo que permite insertar un elemento al final de una lista, si lista es vacia
    // el elemento se vuelve la cabeza.
    public void insertar(int elemento){
        Nodo aux;
        if(cabeza==null){
            cabeza = new Nodo(elemento);
        } else {
            aux = cabeza;
            while(aux.siguiente != null){
                aux = aux.siguiente ;
            }
            aux.siguiente = new Nodo(elemento);
        }
        longitud++;
    }
    // Metodo que permite eliminar un elemento determinado de una lista , si el elemento
    // que se desea eliminar no pertenece a la lista no se realizan cambios, si la
    // lista es vacia no se realizan cambios.
    public void eliminar(int elemento){
        if(pertenece(elemento)){
            Nodo actual, anterior;
            if(cabeza == null){
                System.out.println("La lista esta vacia");
                return;
            } else if (longitud == 1) {
                cabeza = null;
                longitud--;
            } else if (cabeza.getElemento() == elemento) {
                cabeza = cabeza.siguiente;
                longitud--;
            } else {
                actual = cabeza;
                anterior = null;
                while(actual.getElemento() != elemento){
                    anterior = actual;
                    actual = actual.siguiente;
                }
                anterior.siguiente = actual.siguiente;
                longitud--;
            }
        } else {
            System.out.println("El elemento no pertenece a la lista");
        }
    }
    //Metodo auxiliar para determinar si un elemento pertenece a la lista
    private boolean pertenece(int elemento){
        Nodo aux = cabeza;
        while(aux != null && aux.getElemento() != elemento){
            aux = aux.siguiente;
        }
        if(aux != null){
            return true;
        } else {
            return false;
        }
    }

    //Metodo para representar en forma de cadenas a las listas,
    @Override
    public String toString(){
        Nodo aux = cabeza;
        if(cabeza == null){
            return "[]";
        } else {
            String cadena = "";
            while(aux != null){
                cadena = cadena + "[" + aux.getElemento() + "]";
                aux = aux.siguiente;
            }
             return cadena;

        }
    }
    public int getLongitud() {
        return longitud;
    }
    public Nodo getCabeza() {
        return cabeza;
    }
}
