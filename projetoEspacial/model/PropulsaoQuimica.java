package projetoEspacial.model;

public class PropulsaoQuimica extends SistemaPropulsao {

    private double tanqueCombustivelKg;

    public PropulsaoQuimica(int empuxoNewton, String modelo, String status, double tanqueCombustivelKg) {
        super(empuxoNewton, modelo, status);
        this.setTanqueCombustivelKg(tanqueCombustivelKg);
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
        if (novoEmpuxo > 0 && novoEmpuxo <= 2200000) {
            System.out.println("Acelerando com propulsão química: " + novoEmpuxo + " Newtons.");
            setEmpuxoNewton(novoEmpuxo);
        } else if (novoEmpuxo < 0) {
            System.out.println("Erro: O empuxo deve ser um valor positivo para acelerar.");
        } else if (novoEmpuxo > 2200000) {
            System.out.println("Erro: O empuxo máximo para propulsão química é de 2.200.000 Newtons.");
        }
    }

    @Override
    public void exibirResumo() {
        System.out.println("\n" + repeat("-", 50));
        System.out.println("SISTEMA DE PROPULSÃO QUÍMICA");
        System.out.println(repeat("-", 50));
        System.out.println("Sistema de Propulsão: " + this.getModelo());
        System.out.println("Empuxo: " + this.getEmpuxoNewton() + " Newtons");
        System.out.println("Capacidade do Tanque de Combustível: " + this.getTanqueCombustivelKg() + " kg");
        System.out.println("Status: " + this.getStatus());
        System.out.println(repeat("-", 50));
    }

    public double getTanqueCombustivelKg() {
        return this.tanqueCombustivelKg;
    }

    public void atualizarTanqueCombustivel(double novaCapacidade) {
        System.out.println("Solicitando atualização da capacidade do tanque de combustível do sistema de propulsão: " + this.getModelo());
        setTanqueCombustivelKg(novaCapacidade);
    }

    private void setTanqueCombustivelKg(double novaCapacidade) {
        if (novaCapacidade >= 0 && novaCapacidade <= 4500) {
            this.tanqueCombustivelKg = novaCapacidade;
        } else {
            System.out.println("Erro: A capacidade do tanque de combustível deve ser um valor positivo e não pode exceder 4500 kg.");
        }
    }

}
