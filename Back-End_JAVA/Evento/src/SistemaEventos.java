import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaEventos {
    private List<Pessoa> listaPessoas;
    private List<Evento> listaEventos;

    public SistemaEventos() {
        listaPessoas = new ArrayList<>();
        listaEventos = new ArrayList<>();
    }

    public void cadastrarPessoa(String nome, int identificador) {
        for (Pessoa pessoa : listaPessoas) {
            if (pessoa.getIdentificador() == identificador) {
                System.out.println("Já existe uma pessoa com esse identificador.");
                return;
            }
        }
        Pessoa novaPessoa = new Pessoa(nome, identificador);
        listaPessoas.add(novaPessoa);
    }

    public void cadastrarEvento(String descricao, int identificador) {
        for (Evento evento : listaEventos) {
            if (evento.getIdentificador() == identificador) {
                System.out.println("Já existe um evento com esse identificador.");
                return;
            }
        }
        Evento novoEvento = new Evento(descricao, identificador);
        listaEventos.add(novoEvento);
    }

    public void listarPessoasComEventos() {
        for (Pessoa pessoa : listaPessoas) {
            System.out.println("Pessoa: " + pessoa.getNome());
            for (Evento evento : listaEventos) {
                if (evento.getPessoasRelacionadas().contains(pessoa)) {
                    System.out.println("- Evento: " + evento.getDescricao());
                }
            }
        }
    }

    public void ocorrenciaEvento(int identificador) {
        Evento eventoEncontrado = null;
        for (Evento evento : listaEventos) {
            if (evento.getIdentificador() == identificador) {
                eventoEncontrado = evento;
                break;
            }
        }
        if (eventoEncontrado != null) {
            eventoEncontrado.ocorrencia();
            listaEventos.remove(eventoEncontrado);
            listaEventos.add(0, eventoEncontrado);
            System.out.println("Ocorrência registrada para o evento " + eventoEncontrado.getDescricao());
            imprimirOrdemAtual();
        } else {
            System.out.println("Evento não encontrado.");
        }
    }

    public void imprimirOrdemAtual() {
        System.out.println("Ordem atual:");
        for (Evento evento : listaEventos) {
            System.out.println(evento);
        }
    }

    public void executar() {
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("0: Sair");
            System.out.println("-1: Cadastrar pessoa");
            System.out.println("-2: Cadastrar evento");
            System.out.println("-3: Listar pessoas com eventos");
            System.out.println("Número positivo: Ocorrência de evento");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case -1:
                    System.out.print("Nome da pessoa: ");
                    String nomePessoa = scanner.nextLine();
                    System.out.print("Identificador: ");
                    int identificadorPessoa = scanner.nextInt();
                    cadastrarPessoa(nomePessoa, identificadorPessoa);
                    break;
                case -2:
                    System.out.print("Descrição do evento: ");
                    String descricaoEvento = scanner.nextLine();
                    System.out.print("Identificador: ");
                    int identificadorEvento = scanner.nextInt();
                    cadastrarEvento(descricaoEvento, identificadorEvento);
                    break;
                case -3:
                    listarPessoasComEventos();
                    break;
                default:
                    if (opcao > 0) {
                        ocorrenciaEvento(opcao);
                    }
            }

        } while (opcao != 0);
    }
}
