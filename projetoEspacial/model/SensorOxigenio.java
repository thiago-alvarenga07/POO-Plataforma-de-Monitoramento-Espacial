package projetoEspacial.model;

public class SensorOxigenio extends ComponenteEspacial implements Sensor {
    private double oxigenio;
    
    public SensorOxigenio(int id, String nome, String status, double oxigenio) {
        super(id, nome, status);
        this.setOxigenio(oxigenio);
    }

    private static String repeat(String str, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    public double getOxigenio() {
        return this.oxigenio;
    }

    private void setOxigenio(double oxigenio) {
        if (oxigenio >= 0) {
            this.oxigenio = oxigenio;
        } else {
            System.out.println("Erro: O nível de oxigênio deve ser um valor positivo.");
        }
    }

    @Override
    public void exibirResumo() {
        System.out.println("\n" + repeat("-", 50));
        System.out.println("SENSOR DE OXIGÊNIO");
        System.out.println("Nome: " + this.getNome());
        System.out.println("Nível de Oxigênio: " + this.getOxigenio() + " %");
        System.out.println("Status: " + this.getStatus());
        System.out.println("ID: " + this.getId());
        System.out.println("Mínimo Permitido: " + Sensor.OXIGENIO_MINIMO + " %");
        System.out.println("Máximo Permitido: " + Sensor.OXIGENIO_MAXIMO + " %");
        System.out.println(repeat("-", 50));
    }

    @Override
    public void verificarSensor() {
        if (this.oxigenio < OXIGENIO_MINIMO || this.oxigenio > OXIGENIO_MAXIMO) {
            System.out.println("Alerta: Nível de oxigênio crítico! Verifique imediatamente.");
            System.out.println("\n" + repeat("-", 50));
        } else {
            System.out.println("Nível de oxigênio dentro dos parâmetros normais.");
            System.out.println("\n" + repeat("-", 50));
        }
    }

}
