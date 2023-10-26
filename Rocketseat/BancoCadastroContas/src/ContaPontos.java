public class ContaPontos {
    private int numeroIdentificador;
    private int saldo;

    public ContaPontos(int numeroIdentificador) {
        this.numeroIdentificador = numeroIdentificador;
        this.saldo = 0;
    }

    public int getNumeroIdentificador() {
        return numeroIdentificador;
    }

    public int getSaldo() {
        return saldo;
    }

    public void depositarPontos(int pontos) throws SaldoMaximoException {
        if (pontos < 0) {
            throw new IllegalArgumentException("Não é permitido depositar um número negativo de pontos.");
        }

        if (saldo + pontos > 1000) {
            throw new SaldoMaximoException("O saldo máximo permitido é 1000 pontos.");
        }

        saldo += pontos;
    }

    public void retirarPontos(int pontos) {
        if (pontos < 0) {
            throw new IllegalArgumentException("Não é permitido retirar um número negativo de pontos.");
        }

        if (saldo - pontos < 0) {
            throw new SaldoNegativoException("Operação não permitida. Saldo ficaria negativo.");
        }

        saldo -= pontos;
    }

    public void transferirPontos(ContaPontos destino, int pontos) throws SaldoMaximoException {
        if (pontos < 0) {
            throw new IllegalArgumentException("Não é permitido transferir um número negativo de pontos.");
        }

        if (saldo - pontos < 0) {
            throw new SaldoNegativoException("Operação não permitida. Saldo ficaria negativo.");
        }

        destino.depositarPontos(pontos);
        retirarPontos(pontos);
    }
}
