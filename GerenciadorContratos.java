package app;

		import java.time.LocalDate;
		import java.time.format.DateTimeFormatter;
		import java.time.format.DateTimeParseException;
		import java.util.ArrayList;
		import java.util.List;
		import java.util.Scanner;

		public class GerenciadorContratos {

		    public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);
		        List<Contrato> listaContratos = new ArrayList<>();
		        DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		        int proximoId = 1;
		        int opcao = -1;

		        do {
		            System.out.println("\n===== MENU DE GERENCIAMENTO DE CONTRATOS =====");
		            System.out.println("1. Cadastrar novo contrato");
		            System.out.println("2. Imprimir todos os contratos");
		            System.out.println("3. Buscar contrato por status");
		            System.out.println("0. Sair");
		            System.out.print("Escolha uma opção: ");

		            try {
		                opcao = Integer.parseInt(scanner.nextLine());
		            } catch (NumberFormatException e) {
		                opcao = -1;
		            }

		            switch (opcao) {
		                case 1:
		                    System.out.println("\n--- Cadastro de Novo Contrato ---");
		                    System.out.print("Descrição do contrato: ");
		                    String descricao = scanner.nextLine();
		                    System.out.print("Valor do contrato (ex: 1500.50): ");
		                    double valor = Double.parseDouble(scanner.nextLine());
		                    LocalDate data = null;
		                    while (data == null) {
		                        System.out.print("Data de assinatura (formato dd/MM/yyyy): ");
		                        try {
		                            data = LocalDate.parse(scanner.nextLine(), formatadorData);
		                        } catch (DateTimeParseException e) {
		                            System.out.println("Formato de data inválido! Tente novamente.");
		                        }
		                    }
		                    StatusContrato status = null;
		                    while (status == null) {
		                        System.out.print("Status do contrato (ATIVO, PENDENTE, FINALIZADO, CANCELADO): ");
		                        try {
		                            status = StatusContrato.valueOf(scanner.nextLine().toUpperCase());
		                        } catch (IllegalArgumentException e) {
		                            System.out.println("Status inválido! Tente novamente.");
		                        }
		                    }
		                    Contrato novoContrato = new Contrato(proximoId++, descricao, valor, data, status);
		                    listaContratos.add(novoContrato);
		                    System.out.println("Contrato cadastrado com sucesso!");
		                    break;
		                case 2:
		                    System.out.println("\n--- Lista de Todos os Contratos ---");
		                    if (listaContratos.isEmpty()) {
		                        System.out.println("Nenhum contrato cadastrado.");
		                    } else {
		                        for (Contrato contrato : listaContratos) {
		                            System.out.println(contrato);
		                        }
		                    }
		                    break;
		                case 3:
		                    System.out.println("\n--- Busca de Contrato por Status ---");
		                    if (listaContratos.isEmpty()) {
		                        System.out.println("Nenhum contrato cadastrado para buscar.");
		                        break;
		                    }
		                    System.out.print("Digite o status para buscar (ATIVO, PENDENTE, FINALIZADO, CANCELADO): ");
		                    try {
		                        StatusContrato statusBusca = StatusContrato.valueOf(scanner.nextLine().toUpperCase());
		                        boolean encontrado = false;
		                        System.out.println("\nContratos encontrados com o status '" + statusBusca + "':");
		                        for (Contrato contrato : listaContratos) {
		                            if (contrato.getStatus() == statusBusca) {
		                                System.out.println(contrato);
		                                encontrado = true;
		                            }
		                        }
		                        if (!encontrado) {
		                            System.out.println("Nenhum contrato encontrado com este status.");
		                        }
		                    } catch (IllegalArgumentException e) {
		                        System.out.println("Status inválido! A busca foi cancelada.");
		                    }
		                    break;
		                case 0:
		                    System.out.println("Encerrando o programa...");
		                    break;
		                default:
		                    System.out.println("Opção inválida! Por favor, tente novamente.");
		                    break;
		            }
		        } while (opcao != 0);

		        scanner.close();
		    }
		}


