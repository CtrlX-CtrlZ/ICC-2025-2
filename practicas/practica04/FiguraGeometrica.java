public abstract class FiguraGeometrica {
    protected double base;
    protected double altura;
    public FiguraGeometrica(double base, double altura){
        this.base = base;
        this.altura = altura;
    }
    public abstract double obtenerArea();
    public abstract double obtenerPerimetro();
    public String toString(){
        return "Base: " + base + ", Altura: " + altura;
    }
    public double getAltura(){
        return altura;
    }
    public double getBase(){
        return base;
    }
    public void setAltura(double altura){
        this.altura = altura;
    }
    public void setBase(double base){
        this.base = base;
    }
}