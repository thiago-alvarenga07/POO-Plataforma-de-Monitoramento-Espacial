

package projetoEspacial.model;

public class SensorTemperatura extends ComponenteEspacial implements Sensor {
    private int temperatura;

    public SensorTemperatura(int id, String nome, String status, int temperatura) {
        super(id, nome, status);
        this.setTemperaturaCelsius(temperatura);
    }

    private static String repeat(String str, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    public int getTemperaturaC() {
        return this.temperatura;
    }

    public void atualizarTemperatura(int novaTemperatura) {
        System.out.println("Solicitando atualização da temperatura do sensor: " + this.getNome());
        setTemperaturaCelsius(novaTemperatura);
    }

    private void setTemperaturaCelsius(int novaTemperatura) {
        if (novaTemperatura >= -273) {
            this.temperatura = novaTemperatura;
        } else {
            System.out.println("Erro de leitura: O sensor não consegue ler valores menores que -200°C.");
        }
    }

    @Override
    public void exibirResumo() {
        System.out.println("\n" + repeat("-", 50));
        System.out.println("SENSOR DE TEMPERATURA");
        System.out.println("Nome: " + this.getNome());
        System.out.println("Temperatura: " + this.getTemperaturaC() + " °C");
        System.out.println("Status: " + this.getStatus());
        System.out.println("ID: " + this.getId());
        System.out.println("Mínimo Permitido: " + Sensor.TEMPERATURA_MINIMA + " °C");
        System.out.println("Máximo Permitido: " + Sensor.TEMPERATURA_MAXIMA + " °C");
        System.out.println(repeat("-", 50));
    }

    @Override
    public void verificarSensor() {
        if (this.temperatura < TEMPERATURA_MINIMA || this.temperatura > TEMPERATURA_MAXIMA) {
            System.out.println("Alerta: Temperatura crítica! Verifique imediatamente.");
            System.out.println("\n" + repeat("-", 50));
        } else {
            System.out.println("Temperatura dentro dos parâmetros normais.");
            System.out.println("\n" + repeat("-", 50));
        }
    }
}
