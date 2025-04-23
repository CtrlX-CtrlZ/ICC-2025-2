public class Reloj {
    private int segundos;
    private int minutos;
    private int horas;
    public Reloj(int horas, int minutos, int segundos){
        this.horas = horas % 24;
        this.minutos = minutos % 60;
        this.segundos = segundos % 60;
    }
    public int getSegundos() {
        return segundos;
    }
    public int getMinutos() {
        return minutos;
    }
    public int getHoras() {
        return horas;
    }
    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }
    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }
    public void setHoras(int horas) {
        this.horas = horas;
    }
    public void incrementaHora(int hora) {
        horas = (horas + hora) % 24;
    }
    public void incrementaMinutos(int minuto) {
        int aux;
        aux = (minutos + minuto) / 60;
        minutos = (minutos + minuto) % 60;
        incrementaHora(aux);
    }
    public void incrementaSegundos(int segundo) {
        int aux;
        aux = (segundos + segundo) / 60;
        segundos = (segundos + segundo) % 60;
        incrementaMinutos(aux);
    }
    public String mostrar() {
        return ((horas<10) ? "0" + horas : horas) + ":" + ((minutos<10) ? "0" + minutos : minutos) + ":" + ((segundos<10) ? "0" + segundos : segundos);
    }
}
