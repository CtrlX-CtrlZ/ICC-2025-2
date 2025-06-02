public class ListaLigada {
    private Nodo cabeza;
    private int longitud;
    public ListaLigada(){
        cabeza = null;
        longitud = 0;
    }
    private class Nodo{
        private Carta elemento;
        private Nodo siguiente;
        public Nodo(Carta elemento){
            this.elemento = elemento;
        }
        public Carta getElemento() {
            return elemento;
        }
    }
    // Metodo que agrega al elemento recibido como argumento al final de la lista
    public void insertar(Carta elemento){
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
    // Metodo que elimina todos los elementos de la lista
    public void limpiar(){
        cabeza = null;
        longitud = 0;
    }
    // Metodo que elimina el elemento con el indice recibido como argumento, el metodo retorna el elemento eliminado
    public Carta extraer(int indice){
        if(cabeza == null){
            return null;
        } else {
            Nodo aux;
            if(indice>=longitud || indice<0){
                return null;
            } else if (indice == 0) {
                aux = cabeza;
                cabeza = cabeza.siguiente;
                longitud--;
                return aux.elemento;
            } else {
                aux = cabeza;
                Nodo anterior = aux;
                for(int i=0; i<indice; i++){
                    anterior = aux;
                    aux = aux.siguiente;
                }
                anterior.siguiente = anterior.siguiente.siguiente;
                longitud--;
                return aux.elemento;
            }
        }
    }
    // Metodo que elimina el primer elemento de la lista, el metodo retorna el elemento elimindado
    public Carta extraerPrimero(){
        if (cabeza == null) {
            return null;
        }
        Nodo aux = cabeza;
        cabeza = cabeza.siguiente;
        longitud--;
        return aux.elemento;
    }
    // Metodo que devuelve la referencia al ultimo elemento de la lista
    public Carta consultarUltimo() {
        if (cabeza == null) {
            return null;
        }
        Nodo aux = cabeza;
        while (aux.siguiente != null) {
            aux = aux.siguiente;
        }
        return aux.elemento;
    }
    // Metodo que devuelve la referencia de un elemento dado un indice
    public Carta buscar(int indice){
        if(cabeza == null){
            return null;
        } else {
            if(indice>=longitud || indice<0){
                return null;
            }else {
                Nodo aux = cabeza;
                for(int i=0; i<indice; i++){
                    aux = aux.siguiente;
                }
                return aux.elemento;
            }
        }
    }
    public boolean estaVacia() {
        return cabeza == null;
    }
    // Metodo que permite representar los elementos de la lista: 1. elem1 2. elem2 2. elem3, ...]
    @Override
    public String toString(){
        Nodo aux = cabeza;
        if(cabeza == null){
            return "lista vacia";
        } else {
            String cadena = "";
            int indice = 1;
            int numCartasFila = 0;
            while(aux != null){
                if (numCartasFila > 4) {
                    cadena = cadena + "\n";
                    numCartasFila = 0;
                }
                cadena = cadena + indice + ". " + aux.getElemento() + " ";
                aux = aux.siguiente;
                indice++;
                numCartasFila++;
            }
            return cadena;
        }
    }
    // Metodo que retorna la longitud de la lista
    public int getLongitud() {
        return longitud;
    }
}
