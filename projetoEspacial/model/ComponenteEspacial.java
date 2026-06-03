package projetoEspacial.model;

public abstract class ComponenteEspacial {

    private int id;
    private String nome;
    private String status;

    public ComponenteEspacial(int id, String nome, String status) {
        this.id = id;
        this.setNome(nome);
        this.status = status;
    }

    public int getId() {
        return this.id;

    }

    public String getNome() {
        return this.nome;

    }

    public String getStatus() {
        return this.status;
    }

    public void atualizarNome(String novoNome) {
        System.out.println("Solicitando atualização de nome do componente: " + this.getId());
        this.setNome(novoNome);
        
    }

    private void setNome(String novoNome) {
        if (novoNome != null && !novoNome.trim().isEmpty()) {
            this.nome = novoNome;
            System.out.println("Nome do componente atualizado para: " + this.getNome());
        } else {
            System.out.println("Erro: O nome do componente não pode ser vazio.");
        }
    }

    public void atualizarStatus(String novoStatus) {
        System.out.println("Solicitando atualização de status do componente: " + this.getId());
        this.setStatus(novoStatus);
    }

    private void setStatus(String novoStatus) {
        if (novoStatus != null && !novoStatus.trim().isEmpty()) {
            this.status = novoStatus;
            System.out.println("Status do componente atualizado para: " + this.getStatus());
        } else {
            System.out.println("Erro: O status do componente não pode ser vazio.");
        }
    }

    public abstract void exibirResumo();
}