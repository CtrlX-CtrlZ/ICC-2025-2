public class Triangulo extends FiguraGeometrica{
    private double lado1;
    private double lado2;
    private double lado3;
    private boolean valido;
    public Triangulo(double lado1, double lado2, double lado3) {
        super(0, 0);
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        this.valido = esValido();
        if (valido) {
            double base;
            if (lado1 >= lado2 && lado1 >= lado3) {
                base = lado1;
            } else if (lado2 >= lado1 && lado2 >= lado3) {
                base = lado2;
            } else {
                base = lado3;
            }
            setBase(base);
            double semiperimetro = (lado1 + lado2 + lado3) / 2;
            double area = Math.sqrt(semiperimetro * (semiperimetro - lado1) * (semiperimetro - lado2) * (semiperimetro - lado3));
            double altura = (2 * area) / base;
            setAltura(altura);
        } else {
            setBase(0);
            setAltura(0);
        }
    }
    private boolean esValido(){
         return (lado1 + lado3 > lado2) && (lado2 + lado3 > lado1) && (lado2 + lado1 > lado3);
    }

    public double obtenerArea() {
        if (!valido) {
            System.out.println("No se puede calcular el área: el triángulo no es válido.");
            return 0;
        }
        double semiperimetro = obtenerPerimetro()/2;
        return Math.sqrt(semiperimetro*(semiperimetro-lado1)*(semiperimetro-lado2)*(semiperimetro-lado3));
    }

    public double obtenerPerimetro() {
        if (!valido) {
            System.out.println("No se puede calcular el perímetro: el triángulo no es válido.");
            return 0;
        }
        return lado1 + lado2 + lado3;
    }
    @Override
    public String toString(){
        return "Triangulo " + "[Lado 1: " + lado1 + ", Lado 2: " + lado2 + ", Lado 3: " + lado3
                + "\n" + super.toString() + "]" + "\nPerimetro: " + obtenerPerimetro() + "\nArea: " + obtenerArea() +
                "\nRepresentacion: " + "\n" + imprimirTriangulo((int) getBase(),(int)getAltura()) + "\n";

    }
    public String imprimirTriangulo(int base, int altura) {
        if (base <= 0 || altura <= 0) {
            return "La base o la altura deben ser mayores que cero";
        }
        String s = "";
        for (int i = 1; i <= altura; i++) {
            int cantidad = (int) Math.round((double) base * i / altura);
            for (int j = 0; j < cantidad; j++) {
                s += "*";
            }
            if (i != altura) {
                s += "\n";
            }
        }
        return s;
    }
}
