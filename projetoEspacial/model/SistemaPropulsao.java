package projetoEspacial.model;

public abstract class SistemaPropulsao {
    private int empuxoNewton;
    private String modelo;
    private String status;

    public SistemaPropulsao(int empuxoNewton, String modelo, String status) {
        this.setEmpuxoNewton(0);
        this.modelo = modelo;
        this.setStatus(status);

    }

    public int getEmpuxoNewton() {
        return this.empuxoNewton;
    }

    public String getModelo() {
        return this.modelo;

    }

    public String getStatus() {
        return this.status;
    }

    public void atualizarStatus(String novoStatus) {
        System.out.println("Solicitando atualização de status do sistema de propulsão do: " + this.getModelo());
        this.setStatus(novoStatus);
    }

    private void setStatus(String novoStatus) {
        if (novoStatus != null && !novoStatus.trim().isEmpty()) {
            this.status = novoStatus;
        } else {
            System.out.println("Erro: O status do sistema de propulsão não pode ser vazio.");
        }
    }

    public void setEmpuxoNewton(int novoEmpuxo) {
        if (novoEmpuxo >= 0) {
            this.empuxoNewton = novoEmpuxo;
        } else {
            System.out.println("Erro: O empuxo deve ser um valor positivo.");
        }
    }

    public abstract void alterarEmpuxo(int novoEmpuxo);
    
    public abstract void exibirResumo();

}
