import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String descricao;
    private int identificador;
    private List<Pessoa> pessoasRelacionadas;
    private int ocorrencias;

    public Evento(String descricao, int identificador) {
        this.descricao = descricao;
        this.identificador = identificador;
        this.pessoasRelacionadas = new ArrayList<>();
        this.ocorrencias = 0;
    }

    // Getters
    public String getDescricao() {
        return descricao;
    }

    public int getIdentificador() {
        return identificador;
    }

    public List<Pessoa> getPessoasRelacionadas() {
        return pessoasRelacionadas;
    }

    public int getOcorrencias() {
        return ocorrencias;
    }

    public void adicionarPessoa(Pessoa pessoa) {
        pessoasRelacionadas.add(pessoa);
    }

    public void ocorrencia() {
        ocorrencias++;
    }

    @Override
    public String toString() {
        return "Descrição: " + descricao + ", Identificador: " + identificador + ", Ocorrências: " + ocorrencias;
    }
}
