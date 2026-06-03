package projetoEspacial.model;

public class DadosMissao {
    private String nomeMissao;
    private String statusMissao;
    private String coordenadas;
    private String codigoSeguranca;

    private PropulsaoQuimica quantidadeCombustivel;
    private PropulsaoEletrica nivelBateria;

    public DadosMissao(String nomeMissao, String statusMissao, String coordenadas, String codigoSeguranca, PropulsaoQuimica quantidadeCombustivel, PropulsaoEletrica nivelBateria) {
        this.nomeMissao = nomeMissao;
        this.setStatusMissao(statusMissao);
        this.setCoordenadas(coordenadas);
        this.codigoSeguranca = codigoSeguranca;
        this.quantidadeCombustivel = quantidadeCombustivel;
        this.nivelBateria = nivelBateria;
    }

    private static String repeat(String str, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    public String getNomeMissao() {
        return nomeMissao;
    }

    public String getStatusMissao() {
        return statusMissao;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void alterarStatusMissao(String codigo, String novoStatus) {
        if (codigo.equals(this.codigoSeguranca)) {
            System.out.println("Alterando status da missão: " + this.nomeMissao);
            setStatusMissao(novoStatus);
        } else {
            System.out.println("Erro: Código de segurança inválido.");
        }
    }

    private void setStatusMissao(String novoStatus) {
        if (novoStatus != null && !novoStatus.trim().isEmpty()) {
            this.statusMissao = novoStatus;
        } else {
            System.out.println("Erro: O status da missão não pode ser vazio.");
        }
    }

    public void atualizarCoordenadas(String codigo, String novasCoordenadas) {
        if (codigo.equals(this.codigoSeguranca)) {
            System.out.println("Código de segurança verificado.");
            System.out.println("Solicitando atualização de coordenadas da missão: " + this.nomeMissao);
            setCoordenadas(novasCoordenadas);
        } else {
            System.out.println("Erro: Código de segurança inválido.");
        }
    }

    private void setCoordenadas(String novasCoordenadas) {
        if (novasCoordenadas != null && !novasCoordenadas.trim().isEmpty()) {
            this.coordenadas = novasCoordenadas;
        } else {
            System.out.println("Erro: As coordenadas da missão não podem ser vazias.");
        }
    }

    public void detalhesMissao() {
        System.out.println("\n" + repeat("=", 50));
        System.out.println("Detalhes da Missão:");
        System.out.println("Nome: " + this.nomeMissao);
        System.out.println("Status atual: " + this.statusMissao);
        System.out.println("\n" + repeat("=", 50));
    }

    public void informacoesSigilosas() {
        System.out.println("\n" + repeat("=", 50));
        System.out.println("ACESSO A INFORMAÇÕES SIGILOSAS DA MISSÃO");
        System.out.println(repeat("=", 50));
        System.out.println("Digite o código de segurança para acessar informações sigilosas da missão:");
        String codigo = System.console().readLine();
        if (codigo.equals(this.codigoSeguranca)) {
            System.out.println("Código de segurança verificado.");
            System.out.println();
            System.out.println(repeat("=", 50));
            System.out.println("Informações sigilosas da missão:");
            System.out.println("Coordenadas atuais X,Y,Z: " + this.coordenadas);
            System.out.println("Combustível Disponível: " + quantidadeCombustivel.getTanqueCombustivelKg() + " kg");
            System.out.println("Bateria do Propulsor Elétrico: " + nivelBateria.getCapacidadeBateria() + " %");
            System.out.println(repeat("=", 50));
        } else {
            System.out.println("Erro: Código de segurança inválido.");
        }
    }
}

