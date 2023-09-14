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
    private Move currentState;




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
        this.currentState = Move.STOP; // Começar no estado STOP
    }

    public Move move() {
        switch (currentState) {
            case STOP:
                // Não faz nada, permanece no estado STOP
                break;

            case CLOCKWISE:
                // Mover até a parede e caminhar no sentido horário
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
                    currentState = Move.STOP; // Quando chegar ao centro, mude para STOP
                }
                break;

            case COUNTER_CW:
                // Mover até a parede e caminhar no sentido anti-horário
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
                    currentState = Move.STOP; // Quando chegar ao centro, mude para STOP
                }
                break;

            case ALTERNATING:
                // Mover até a parede e caminhar alternando entre horário e anti-horário
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
                    if (currentState == Move.RIGHT) {
                        currentState = Move.LEFT; // Começar a caminhar no sentido anti-horário
                    } else {
                        currentState = Move.RIGHT; // Alternar para caminhar no sentido horário
                    }
                }
                break;
        }

        return currentState;
    }

    public void stop() {
        currentState = Move.STOP;
    }
    public void clockwise() {
        currentState = Move.CLOCKWISE;
    }

    public void counterCw() {
        currentState = Move.COUNTER_CW;
    }

    public void alternating() {
        currentState = Move.ALTERNATING;
    }

    public void print() {
        System.out.println("DRE: " + dre);
        System.out.println("Nome: " + nome);
    }
}
