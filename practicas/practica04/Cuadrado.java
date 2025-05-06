public class Cuadrado extends FiguraGeometrica{
    private double lado1;
    private double lado2;
    private double lado3;
    private double lado4;
    public Cuadrado(double lado){
        super(lado, lado);
        lado1 = lado;
        lado2 = lado;
        lado3 = lado;
        lado4 = lado;
    }
    @Override
    public double obtenerArea(){
        return lado1*lado1;
    }
    @Override
    public double obtenerPerimetro(){
        return lado1*4;
    }
    @Override
    public String toString(){
        return "Cuadrado " + "[Lado 1: " + lado1 + ", Lado 2: " + lado2 + ", Lado 3: " + lado3 + ", Lado 4: " + lado4
                + "\n" + super.toString() + "]" + "\nPerimetro: " + obtenerPerimetro() + "\nArea: " + obtenerArea() +
                "\nRepresentacion: " + "\n" + imprimirCuadrado(getLado());

    }
    public int getLado(){
        return (int) lado1;
    }
    public String imprimirCuadrado(int l) {
        String s = "";
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                s = s + " * ";
            }
            s = s + "\n";
        }
        return s;
    }
}
