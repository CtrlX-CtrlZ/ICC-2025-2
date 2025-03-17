public class Recipiente implements ServiciosRecipientes{
    private double altura;
    private double radio;
    private double cantidadLiquidoActual;
    public Recipiente(double altura, double radio, double cantidadLiquidoActual){
        this.altura = altura;
        this.radio = radio;
        setCantidadLiquidoActual(cantidadLiquidoActual);
    }
    public double getAltura() {
        return altura;
    }
    public double getRadio() {
        return radio;
    }
    public double getCantidadLiquidoActual() {
        return cantidadLiquidoActual;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public void setRadio(double radio) {
        this.radio = radio;
    }
    public void setCantidadLiquidoActual(double cantidadLiquidoActual) {
        if (cantidadLiquidoActual>capacidad()){
            System.out.println("La cantidad de liquido supera la capacidad maxima del recipiente");
            System.out.println("El recipiente se lleanara al maximo");
            this.cantidadLiquidoActual = capacidad();
        } else if (cantidadLiquidoActual<0) {
            System.out.println("Valir no permitido");
            System.out.println("El contenido del recipiente sera 0");
        } else {
            this.cantidadLiquidoActual = cantidadLiquidoActual;
        }
    }
    @Override
    public double capacidad(){
        return Math.PI*(radio*radio)*altura;
    }
    @Override
    public double capacidadRestante(){
        return this.capacidad() - cantidadLiquidoActual;
    }
    @Override
    public boolean estaVacio(){
        return cantidadLiquidoActual == 0;
    }
    @Override
    public boolean estaLleno(){
        return cantidadLiquidoActual == capacidad();
    }
    @Override
    public double rellena(double cantidad) {
        double excedente;
        if (cantidad < 0) {
            System.out.println("Valor no valido");
            return 0;
        } else {
            if (cantidad > capacidadRestante()) {
                excedente = cantidad - capacidadRestante();
                cantidadLiquidoActual = capacidad();
            } else {
                cantidadLiquidoActual = cantidadLiquidoActual + cantidad;
                excedente = 0;
            }
            return excedente;
        }
    }
    @Override
    public double vacia(){
        double contenido;
        contenido = cantidadLiquidoActual;
        cantidadLiquidoActual = 0;
        return contenido;
    }
    @Override
    public void vierte(Recipiente otro){
        if (otro == null){
            System.out.println("La referencia al recipiente es nula");
        } else {
            double cantidadTransferida = Math.min(cantidadLiquidoActual, otro.capacidadRestante());
            otro.cantidadLiquidoActual = otro.cantidadLiquidoActual + cantidadTransferida;
            cantidadLiquidoActual = cantidadLiquidoActual - cantidadTransferida;
        }
    }
    @Override
    public boolean mismasDimensiones(Recipiente otro){
        if (otro == null){
            System.out.println("La referencia al recipiente es nula");
            return false;
        } else {
            return altura == otro.altura && radio == otro.radio;
        }
    }
    @Override
    public boolean mismaCapacidad(Recipiente otro){
        if (otro == null){
            System.out.println("La referencia al recipiente es nula");
            return false;
        } else {
            return capacidad() == otro.capacidad();
        }
    }
    @Override
    public boolean contieneMas(Recipiente otro){
        if (otro == null){
            System.out.println("La referencia al recipiente es nula");
            return false;
        } else {
            return this.cantidadLiquidoActual > otro.cantidadLiquidoActual;
        }
    }
    @Override
    public boolean cabeMas(Recipiente otro){
        if (otro == null){
            System.out.println("La referencia al recipiente es nula");
            return false;
        } else {
            return capacidadRestante() > otro.capacidadRestante();
        }
    }
    @Override
    public Recipiente creaContenedorJusto(){
        return new Recipiente(cantidadLiquidoActual/(Math.PI*(radio*radio)),radio,0);
    }
    @Override
    public String muestra(){
        return "Altura: " + altura + "\nRadio: " + radio + "\nCantidad de liquido actual: " + cantidadLiquidoActual;
    }
}