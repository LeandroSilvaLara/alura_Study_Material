public class RobotXY {
    private int id;
    private String dre;
    private String nome;
    private GPS gps;
    private int currentL;
    private int currentC;
    private int targetL;
    private int targetC;
    private boolean goCenter;

    public RobotXY(int id, GPS gps) {
        this.id = id;
        this.gps = gps;
        this.dre = "12345"; // Exemplo de DRE
        this.nome = "Beltrano"; // Exemplo de nome
        this.currentL = 1; // Inicialização na primeira linha
        this.currentC = 1; // Inicialização na primeira coluna
        this.targetL = (gps.getL() + 1) / 2; // Linha do centro da sala
        this.targetC = (gps.getC() + 1) / 2; // Coluna do centro da sala
        this.goCenter = true; // Começar em modo GO_CENTER
    }

    public Move move() {
        if (goCenter) {
            if (currentL < targetL) {
                currentL++;
                return Move.DOWN;
            } else if (currentL > targetL) {
                currentL--;
                return Move.UP;
            } else if (currentC < targetC) {
                currentC++;
                return Move.RIGHT;
            } else if (currentC > targetC) {
                currentC--;
                return Move.LEFT;
            } else {
                goCenter = false; // Mudar para STOP quando chegar ao centro
                return Move.STOP;
            }
        } else {
            return Move.STOP;
        }
    }


    public void print() {
        System.out.println("DRE: " + dre);
        System.out.println("Nome: " + nome);
    }
}
