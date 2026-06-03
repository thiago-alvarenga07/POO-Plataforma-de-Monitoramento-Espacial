package projetoEspacial.main;

import projetoEspacial.model.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class SistemaMonitoramento {
    
    private static Scanner scanner = new Scanner(System.in);
    private static DadosMissao missaoAtual;
    private static boolean sistemaAtivo = true;
    
    // Sensores
    private static SensorTemperatura sensorTemperatura;
    private static SensorPressao sensorPressao;
    private static SensorOxigenio sensorOxigenio;
    private static List<Sensor> sensores;
    
    // Propulsores
    private static PropulsaoQuimica propulsaoQuimica;
    private static PropulsaoEletrica propulsaoEletrica;
    private static List<SistemaPropulsao> propulsores;

    public static void main(String[] args) {
        inicializarSistema();
        menu();
        encerrarSistema();
    }

    private static String repeat(String str, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    private static void inicializarSistema() {
        System.out.println("\n" + repeat("=", 50));
        System.out.println("SISTEMA DE MONITORAMENTO ESPACIAL");
        System.out.println(repeat("=", 50) + "\n");
        
        // Inicializar sensores
        sensorTemperatura = new SensorTemperatura(1, "Sensor T-01", "Em funcionamento", 22);
        sensorPressao = new SensorPressao(2, "Sensor P-01", "Em funcionamento", 1.0);
        sensorOxigenio = new SensorOxigenio(3, "Sensor O-01", "Em funcionamento", 21.0);
        
        sensores = new ArrayList<>();
        sensores.add(sensorTemperatura);
        sensores.add(sensorPressao);
        sensores.add(sensorOxigenio);
        
        // Inicializar propulsores
        propulsaoQuimica = new PropulsaoQuimica(1500000, "Motor de Combustão Principal", "Em funcionamento", 3500);
        propulsaoEletrica = new PropulsaoEletrica(3, "Motor Iônico Auxiliar", "Em funcionamento", 95);
        
        propulsores = new ArrayList<>();
        propulsores.add(propulsaoQuimica);
        propulsores.add(propulsaoEletrica);

        // Inicializar dados da missão padrão
        missaoAtual = new DadosMissao("Missão Orbital Alpha", "EM_ANDAMENTO", "4000,300,2456", "SECURE_2026", propulsaoQuimica, propulsaoEletrica);
        
        System.out.println("Sistema inicializado com sucesso!");
        System.out.println("Missão: " + missaoAtual.getNomeMissao());
        System.out.println("Status: " + missaoAtual.getStatusMissao());
        System.out.println("Sensores carregados: " + sensores.size());
        System.out.println("Propulsores carregados: " + propulsores.size() + "\n");
    }

    private static void menu() {
        while (sistemaAtivo) {
            exibirMenuPrincipal();
            int escolha = lerInteiro();
            processarOpcao(escolha);
        }
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n" + repeat("-", 50));
        System.out.println("MENU PRINCIPAL");
        System.out.println(repeat("-", 50));
        System.out.println("1 - Monitorar Sensores");
        System.out.println("2 - Monitorar Sistema de Propulsão");
        System.out.println("3 - Exibir Dados da Missão");
        System.out.println("4 - Informações sigilosas da missão");
        System.out.println("5 - Alterar Status da Missão");
        System.out.println("6 - Alterar Coordenadas da Missão");
        System.out.println("7 - Sair do Sistema");
        System.out.println(repeat("-", 50));
        System.out.print("Escolha uma opção: ");
    }

    private static void processarOpcao(int opcao) {
        System.out.println();
        
        switch (opcao) {
            case 1:
                monitorarSensores();
                break;
            case 2:
                monitorarPropulsores();
                break;
            case 3:
                exibirDadosMissao();
                break;
            case 4:
                informacoesSigilosas();
                break;
            case 5:
                alterarStatusMissao();
                break;
            case 6:
                alterarCoordenadasMissao();
                break;
            case 7:
                sistemaAtivo = false;
                System.out.println("Encerrando o sistema de monitoramento...");
                break;
            default:
                System.out.println("Opção inválida! Digite um número entre 1 e 7.");
        }
    }

    private static void monitorarSensores() {
        System.out.println("\n" + repeat("=", 50));
        System.out.println("MONITORAMENTO DE SENSORES");
        System.out.println(repeat("=", 50));
        System.out.println("\nSensores disponíveis:");
        System.out.println("1 - Sensor de Temperatura");
        System.out.println("2 - Sensor de Pressão");
        System.out.println("3 - Sensor de Oxigênio");
        System.out.println("4 - Todos os Sensores");
        System.out.println("5 - Verificar Alertas");
        System.out.println("6 - Voltar ao Menu Principal");
        System.out.print("\nEscolha um sensor: ");
        
        int opcao = lerInteiro();
        
        switch (opcao) {
            case 1:
                    exibirInfoSensorTemperatura();
                break;
            case 2:
                    exibirInfoSensorPressao();
                break;
            case 3:
                    exibirInfoSensorOxigenio();
                break;
            case 4:
                    exibirTodosSensores();
                    break;
            case 5:
                verificarAlertas();
                break;
            case 6:
                System.out.println("Retornando ao menu principal...");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }
        private static void exibirInfoSensorTemperatura() {
            sensorTemperatura.exibirResumo();
        }

        private static void exibirInfoSensorPressao() {
            sensorPressao.exibirResumo();
        }

        private static void exibirInfoSensorOxigenio() {
            sensorOxigenio.exibirResumo();
        }

        private static void exibirTodosSensores() {
            System.out.println("\n" + repeat("-", 50));
            System.out.println("RELATÓRIO GERAL DE SENSORES");
            System.out.println(repeat("-", 50));
            exibirInfoSensorTemperatura();
            System.out.println();
            exibirInfoSensorPressao();
            System.out.println();
            exibirInfoSensorOxigenio();
    }

    private static void verificarAlertas() {
        System.out.println("\n" + repeat("=", 50));
        System.out.println("VERIFICAÇÃO DE ALERTAS");
        System.out.println(repeat("=", 50));
        System.out.println("SENSOR DE TEMPERATURA");
        sensorTemperatura.verificarSensor();
        System.out.println("\nSENSOR DE PRESSÃO");
        sensorPressao.verificarSensor();
        System.out.println("\nSENSOR DE OXIGÊNIO");
        sensorOxigenio.verificarSensor();
    }

    private static void monitorarPropulsores() {
        System.out.println("\n" + repeat("=", 50));
        System.out.println("MONITORAMENTO DE PROPULSORES");
        System.out.println(repeat("=", 50));
        System.out.println("\nSistemas de Propulsão disponíveis:");
        System.out.println("1 - Propulsão Química");
        System.out.println("2 - Propulsão Elétrica");
        System.out.println("3 - Verificar Todos");
        System.out.println("4 - Alterar Empuxo");
        System.out.println("5 - Voltar ao Menu Principal");
        System.out.print("\nEscolha uma opção: ");
        
        int opcao = lerInteiro();
        
        switch (opcao) {
            case 1:
                    exibirInfoPropulsaoQuimica();
                break;
            case 2:
                    exibirInfoPropulsaoEletrica();
                    break;
            case 3:
                    exibirTodosPropulsores();
                break;
            case 4:
                    alterarEmpuxoPropulsor();
                    break;
                case 5:
                System.out.println("Retornando ao menu principal...");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

        private static void exibirInfoPropulsaoQuimica() {
            propulsaoQuimica.exibirResumo();
        }

        private static void exibirInfoPropulsaoEletrica() {
            propulsaoEletrica.exibirResumo();
        }

        private static void exibirTodosPropulsores() {
            System.out.println("\n" + repeat("-", 50));
            System.out.println("RELATÓRIO GERAL DE PROPULSORES");
            System.out.println(repeat("-", 50));
            exibirInfoPropulsaoQuimica();
            System.out.println();
            exibirInfoPropulsaoEletrica();
        }

        private static void informacoesSigilosas() {
            missaoAtual.informacoesSigilosas();
        }

        private static void alterarEmpuxoPropulsor() {
            System.out.println("\n" + repeat("=", 50));
            System.out.println("ALTERAR EMPUXO DOS PROPULSORES");
            System.out.println(repeat("=", 50));
            System.out.println("\nQual propulsor deseja alterar?");
            System.out.println("1 - Propulsão Química");
            System.out.println("2 - Propulsão Elétrica");
            System.out.println("3 - Cancelar");
            System.out.print("\nEscolha: ");
        
            int opcao = lerInteiro();
        
            switch (opcao) {
                case 1:
                    System.out.print("Digite novo empuxo (máx. 2.200.000 N): ");
                    int empuxo = lerInteiro();
                    propulsaoQuimica.alterarEmpuxo(empuxo);
                    System.out.println("✓ Empuxo alterado!");
                    break;
                case 2:
                    System.out.print("Digite novo empuxo (máx. 5 N): ");
                    empuxo = lerInteiro();
                    propulsaoEletrica.alterarEmpuxo(empuxo);
                    System.out.println("Empuxo alterado!");
                    break;
                case 3:
                    System.out.println("Operação cancelada.");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
    }

    private static void exibirDadosMissao() {
        missaoAtual.detalhesMissao();
    }

    private static void alterarStatusMissao() {
        System.out.println("\n" + repeat("=", 50));
        System.out.println("Digite o código de segurança para alterar o status da missão:");
        String codigo = System.console().readLine();
        System.out.println("\n" + repeat("=", 50));
        System.out.println("ALTERAR STATUS DA MISSÃO");
        System.out.println(repeat("=", 50));
        System.out.println("\nStatus disponíveis:");
        System.out.println("1 - EM_ANDAMENTO");
        System.out.println("2 - PAUSADA");
        System.out.println("3 - CONCLUÍDA");
        System.out.println("4 - ABORTO_EMERGÊNCIA");
        System.out.println("5 - Cancelar escolha");
        System.out.print("\nEscolha novo status: ");
        
        int opcao = lerInteiro();
        String novoStatus = "";
        
        switch (opcao) {
            case 1:
                novoStatus = "EM_ANDAMENTO";
                break;
            case 2:
                novoStatus = "PAUSADA";
                break;
            case 3:
                novoStatus = "CONCLUÍDA";
                break;
            case 4:
                novoStatus = "ABORTO_EMERGÊNCIA";
                break;
            case 5:
                System.out.println("Operação cancelada.");
                return;
            default:
                System.out.println("Opção inválida!");
                return;
        }
        
        missaoAtual.alterarStatusMissao(codigo, novoStatus);
        System.out.println("Status da missão atualizado com sucesso!");
    }
    
    private static void alterarCoordenadasMissao() {
        System.out.println("\n" + repeat("=", 50));
        System.out.println("ALTERAR COORDENADAS DA MISSÃO");
        System.out.println(repeat("=", 50));
        System.out.print("Digite o código de segurança: ");
        String codigo = System.console().readLine();
        System.out.print("\nDigite as novas coordenadas (formato: x,y,z): ");
        String novasCoordenadas = System.console().readLine();
        missaoAtual.atualizarCoordenadas(codigo, novasCoordenadas);
    }

    private static void encerrarSistema() {
        System.out.println("\n" + repeat("=", 50));
        System.out.println("Sistema de Monitoramento Espacial - FINALIZADO");
        System.out.println(repeat("=", 50) + "\n");
        scanner.close();
    }

    private static int lerInteiro() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine(); // Limpar entrada inválida
            return -1;
        }
    }
}
