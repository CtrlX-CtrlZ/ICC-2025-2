public class Carta {
    private Tamaño tamaño;
    private Color color;
    private int brazos;
    private boolean feliz;
    private boolean lentes;
    public Carta(Tamaño tamaño, Color color, int brazos, boolean feliz, boolean lentes){
        this.tamaño = tamaño;
        this.color = color;
        this.brazos = brazos;
        this.feliz = feliz;
        this.lentes = lentes;
    }
    public boolean comparar(Carta carta) {
        int iguales = 0;
        if (tamaño == carta.tamaño){
            iguales++;
        }if (color == carta.color){
            iguales++;
        }if (brazos == carta.brazos) {
            iguales++;
        }if (lentes == carta.lentes){
            iguales++;
        }if (feliz == carta.feliz){
            iguales++;
        }
        return iguales == 5 || iguales == 4;
    }
    public String toString() {
        return (color == Color.MORADO) ? "\u001B[32m" + "[" + ((tamaño == Tamaño.CHICO) ? "=(o_o)=": "=^._.^=") + ", " +
                ((brazos == 1) ? "1": "2") + ", " + ((feliz) ? "^_^": ">_<") + ", " + ((lentes) ? "-■-■-": "-●-●-") + "]" + "\u001B[0m":
                "\u001B[35m" + "[" + ((tamaño == Tamaño.CHICO) ? "=(o_o)=": "=^._.^=") + ", " + ((brazos == 1) ? "1": "2") + ", "
                        + ((feliz) ? "^_^": ">_<") + ", " + ((lentes) ? "-■-■-": "-●-●-") + "]" + "\u001B[0m";
    }

}
