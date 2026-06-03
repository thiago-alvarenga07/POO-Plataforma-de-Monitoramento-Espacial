package projetoEspacial.model;

public interface Sensor {
    
    void verificarSensor();
    int TEMPERATURA_MAXIMA = 35; // Temperatura máxima suportada em °C
    int TEMPERATURA_MINIMA = 15; // Temperatura mínima suportada em °C

    double PRESSAO_MAXIMA = 1.02 ; // Pressão máxima suportada em atm
    double PRESSAO_MINIMA = 0.88; // Pressão mínima suportada em atm

    double OXIGENIO_MAXIMO = 24.0; // Nível máximo de oxigênio suportado em %
    double OXIGENIO_MINIMO = 19.5; // Nível mínimo de oxigênio suportado em %

}


