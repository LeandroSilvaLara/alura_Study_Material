public class Filme {
    String nome;
    int anoDeLancamento;
    boolean incluidoNoPlano;
    public int duracaoEmMinutos;
    double somaDasAvaliacoes;
    int totalDeAvaliacoes;

    void exibeFichaTecnica() {
        System.out.println("Nome do fime: " + nome);
        System.out.println("Ano de Lançamento: " + anoDeLancamento);
        System.out.println("E o tempo de Duração: " + duracaoEmMinutos);
    }

    void avalia(double nota) {
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    double pegaMedia() {
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }
}
