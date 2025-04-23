public class Maquina  {

    // Toma una cadena y un indice, y agrega a una nueva cadena el caracter en el indice
    // indicado para cada palabra de la cadena, si la palabra es de menor longitud que
    // el indice que se quiere acceder no se tomara ningun caracter de la palabra.
    public String descifraNulo(String original, int n){
        String cadena = "";
        int aux=0, indice;
        for(int i=0; i<original.length(); i++){
            if(original.charAt(i) == ' ' ){
                indice = (i-1) - aux;
                if (n<=indice) {
                    cadena = cadena + original.charAt(aux+n);
                }
                aux = i + 1;
            } else if (i == original.length()-1) {
                indice = i - (aux);
                if (n<=indice) {
                    cadena = cadena + original.charAt(aux+n);
                }
            }
        }
        return  cadena;
    }
    // Toma una cadena y agrega el ultimo caracter de cada palabra a una nueva cadena

    public String descifraNulo(String original){
        String cadena="";
        for(int i=0; i<original.length(); i++){
            if(original.charAt(i) == ' ' ){
                cadena = cadena + original.charAt(i-1);
            } else if (i == original.length()-1) {
                cadena = cadena + original.charAt(i);
            }
        }
        return cadena;
    }
    //Metodo que verifica si una cadena se encuentra contenida en otra cadena

    public boolean contieneNombre(String mensaje, String nombre){
        mensaje = limpiaCadena(mensaje);
        mensaje = eliminaEspacios(mensaje);
        nombre = limpiaCadena(nombre);
        return mensaje.contains(nombre);
    }
    // Metodo auxiliar que remplaza las vocales con acentos por vocales sin acentos
    // y convierte todos los caracteres en minuscula
    private String limpiaCadena(String cadena){
        cadena = cadena.toLowerCase();
        cadena = cadena.replace('á', 'a');
        cadena = cadena.replace('é', 'e');
        cadena = cadena.replace('í', 'i');
        cadena = cadena.replace('ó', 'o');
        cadena = cadena.replace('ú', 'u');
        return cadena;
    }
    // Metodo auxiliar para procesar la cadena en la que se desea buscar un nombre oculto
    private String eliminaEspacios(String cadena){
        int inicio=0;
        String nueva="";
        for(int i=0; i<cadena.length(); i++){
            if(cadena.charAt(i) == ' ' ){
                nueva = nueva + cadena.substring(inicio, i);
                inicio = i+1;
            } else if (i == cadena.length()-1) {
                nueva = nueva + cadena.substring(inicio, i+1);
            }
        }
        return nueva;
    }
    // Metodo que toma dos cadenas y agrega en una nueva cadena las palabras que son
    // diferentes en la cadena original y la otra cadena

    public String decifraPalabrasMarcadas(String m, String e){
        String cadena = "";
        int i = 0, j = 0;
        while(i < m.length() && j < e.length()){
            String palabra1 = "";
            String palabra2 = "";
            while(i<m.length() && (m.charAt(i) != ' ' )){
                palabra1 = palabra1 + m.charAt(i);
                i++;
            }
            i++;
            while(j<e.length() && e.charAt(j) != ' '){
                palabra2 = palabra2 + e.charAt(j);
                j++;
            }
            j++;
            if(!(palabra1.equals(palabra2))){
                if(cadena.isEmpty()){
                    cadena = cadena + palabra1;
                } else {
                    cadena = cadena + " " + palabra1;
                }
            }
        }
        return cadena;
    }

    // Metodo que toma dos cadenas y agrega en una nueva cadena los caracteres que son
    // diferentes en la cadena original y la otra cadena
    public String decifraLetrasMarcadas(String m, String e){
        if(m.length() != e.length()){
            System.out.println("Los mensajes no tienen correspondencia");
            return null;
        } else {
            String cadena="";
            for(int i=0; i<m.length(); i++){
                if(m.charAt(i) != e.charAt(i)){
                    cadena = cadena + m.charAt(i);
                }
            }
            return cadena;
        }
    }

}
