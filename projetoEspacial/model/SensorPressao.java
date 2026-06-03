package projetoEspacial.model;

public class SensorPressao extends ComponenteEspacial implements Sensor {
    
    private double pressao;

    public SensorPressao(int id, String nome, String status, double pressao) {
        super(id, nome, status);
        this.setPressao(pressao);
    }

    private static String repeat(String str, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    public double getPressao() {
        return this.pressao;
    }

    private void setPressao(double novaPressao) {
        if (novaPressao >= 0) {
            this.pressao = novaPressao;
        } else {
            System.out.println("Erro: A pressão deve ser um valor positivo.");
        }
    }

    @Override
    public void exibirResumo() {
        System.out.println("\n" + repeat("-", 50));
        System.out.println("SENSOR DE PRESSÃO");
        System.out.println("Nome: " + this.getNome());
        System.out.println("Pressão: " + this.getPressao() + " atm");
        System.out.println("Status: " + this.getStatus());
        System.out.println("ID: " + this.getId());
        System.out.println("Mínimo Permitido: " + Sensor.PRESSAO_MINIMA + " atm");
        System.out.println("Máximo Permitido: " + Sensor.PRESSAO_MAXIMA + " atm");
        System.out.println(repeat("-", 50));
    }

    @Override
    public void verificarSensor() {
        if (this.pressao < PRESSAO_MINIMA || this.pressao > PRESSAO_MAXIMA) {
            System.out.println("Alerta: Pressão crítica! Verifique imediatamente.");
            System.out.println("\n" + repeat("-", 50));
        } else {
            System.out.println("Pressão dentro dos parâmetros normais.");
            System.out.println("\n" + repeat("-", 50));
        }
    }
}
