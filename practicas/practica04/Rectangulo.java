public class Rectangulo extends FiguraGeometrica{
    private double lado1;
    private double lado2;
    private double lado3;
    private double lado4;
    public Rectangulo(double base, double altura){
        super(base, altura);
        lado1 = base;
        lado2 = altura;
        lado3 = base;
        lado4 = altura;
    }
    @Override
    public double obtenerArea(){
        return lado1*lado2;
    }
    @Override
    public double obtenerPerimetro(){
        return lado1*2 + lado2*2;
    }
    @Override
    public String toString(){
        return "Rectangulo " + "[Lado 1: " + lado1 + ", Lado 2: " + lado2 + ", Lado 3: " + lado3 + ", Lado 4: " + lado4
                + "\n" + super.toString() + "]" + "\nPerimetro: " + obtenerPerimetro() + "\nArea: " + obtenerArea() +
                "\nRepresentacion: " + "\n" + imprimirRectangulo(getBa(), getAl());

    }
    public int getBa(){
        return (int) lado1;
    }
    public int getAl(){
        return (int) lado2;
    }

    public String imprimirRectangulo(int base, int altura) {
        String s="";
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < base; j++) {
                s = s + " * ";
            }
            s = s + "\n";
        }
        return s;
    }

}
