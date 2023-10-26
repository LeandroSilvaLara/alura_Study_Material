import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<ContaPontos> contas = new ArrayList<>();

        while (true) {
            System.out.println("\n1 - Criar nova conta");
            System.out.println("2 - Consultar saldo");
            System.out.println("3 - Depositar pontos");
            System.out.println("4 - Retirar pontos");
            System.out.println("5 - Transferir pontos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o número identificador da conta: ");
                    int numeroIdentificador = scanner.nextInt();
                    ContaPontos novaConta = new ContaPontos(numeroIdentificador);
                    contas.add(novaConta);
                    System.out.println("Conta criada com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite o número identificador da conta: ");
                    int idConsulta = scanner.nextInt();
                    ContaPontos contaConsulta = buscarContaPorId(contas, idConsulta);
                    if (contaConsulta != null) {
                        System.out.println("Saldo da conta " + contaConsulta.getNumeroIdentificador() + ": " + contaConsulta.getSaldo());
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 3:
                    System.out.print("Digite o número identificador da conta: ");
                    int idDeposito = scanner.nextInt();
                    ContaPontos contaDeposito = buscarContaPorId(contas, idDeposito);
                    if (contaDeposito != null) {
                        try {
                            System.out.print("Digite a quantidade de pontos a depositar: ");
                            int pontosDeposito = scanner.nextInt();
                            contaDeposito.depositarPontos(pontosDeposito);
                            System.out.println("Pontos depositados com sucesso!");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        } catch (SaldoMaximoException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o número identificador da conta: ");
                    int idRetirada = scanner.nextInt();
                    ContaPontos contaRetirada = buscarContaPorId(contas, idRetirada);
                    if (contaRetirada != null) {
                        try {
                            System.out.print("Digite a quantidade de pontos a retirar: ");
                            int pontosRetirada = scanner.nextInt();
                            contaRetirada.retirarPontos(pontosRetirada);
                            System.out.println("Pontos retirados com sucesso!");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        } catch (SaldoNegativoException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 5:
                    System.out.print("Digite o número identificador da conta de origem: ");
                    int idOrigem = scanner.nextInt();
                    ContaPontos contaOrigem = buscarContaPorId(contas, idOrigem);

                    System.out.print("Digite o número identificador da conta de destino: ");
                    int idDestino = scanner.nextInt();
                    ContaPontos contaDestino = buscarContaPorId(contas, idDestino);

                    if (contaOrigem != null && contaDestino != null) {
                        try {
                            System.out.print("Digite a quantidade de pontos a transferir: ");
                            int pontosTransferencia = scanner.nextInt();
                            contaOrigem.transferirPontos(contaDestino, pontosTransferencia);
                            System.out.println("Pontos transferidos com sucesso!");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        } catch (SaldoNegativoException | SaldoMaximoException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Conta(s) não encontrada(s).");
                    }
                    break;
                case 0:
                    System.out.println("Saindo do programa.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    public static ContaPontos buscarContaPorId(List<ContaPontos> contas, int id) {
        for (ContaPontos conta : contas) {
            if (conta.getNumeroIdentificador() == id) {
                return conta;
            }
        }
        return null;
    }
}