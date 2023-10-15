public class Pessoa {
    private String nome;
    private int identificador;

    public Pessoa(String nome, int identificador) {
        this.nome = nome;
        this.identificador = identificador;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getIdentificador() {
        return identificador;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Identificador: " + identificador;
    }
}
