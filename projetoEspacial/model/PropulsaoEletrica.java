package projetoEspacial.model;

public class PropulsaoEletrica extends SistemaPropulsao {

    private int capacidadeBateria;

    public PropulsaoEletrica(int empuxoNewton, String modelo, String status, int capacidadeBateria) {
        super(empuxoNewton, modelo, status);
        this.setCapacidadeBateria(capacidadeBateria);
    }

    private static String repeat(String str, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    @Override
    public void alterarEmpuxo(int novoEmpuxo) {
        if (novoEmpuxo > 0 && novoEmpuxo <= 5) {
            System.out.println("Acelerando com propulsão elétrica: " + novoEmpuxo + " Newtons.");
            setEmpuxoNewton(novoEmpuxo);            
        } else if (novoEmpuxo < 0) {
            System.out.println("Erro: O empuxo deve ser um valor positivo para acelerar.");
        } else if (novoEmpuxo > 5) {
            System.out.println("Erro: O empuxo máximo para propulsão elétrica é de 5 Newtons.");
        }
    }

    @Override
    public void exibirResumo() {
        System.out.println("\n" + repeat("-", 50));
        System.out.println("SISTEMA DE PROPULSÃO ELÉTRICA");
        System.out.println(repeat("-", 50));
        System.out.println("Modelo do propulsor: " + this.getModelo());
        System.out.println("Empuxo: " + this.getEmpuxoNewton() + " Newtons");
        System.out.println("Capacidade da bateria: " + this.getCapacidadeBateria() + " kWh");
        System.out.println("Status: " + this.getStatus());
        System.out.println(repeat("-", 50));
    }

    public int getCapacidadeBateria() {
        return this.capacidadeBateria;
    }

    public void atualizarCapacidadeBateria(int novaCapacidade) {
        System.out.println("Solicitando atualização de capacidade da bateria do sistema de propulsão: " + this.getModelo());
        setCapacidadeBateria(novaCapacidade);
    }

    private void setCapacidadeBateria(int novaCapacidade) {
        if (novaCapacidade >= 0) {
            this.capacidadeBateria = novaCapacidade;
        } else {
            System.out.println("Erro: A capacidade da bateria deve ser um valor positivo.");
        }
    }
}

