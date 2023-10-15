public class RobotXY {
    private int id;
    private String nomeAluno;
    private GPS gps;
    private boolean isGoCenter;
    private int l;
    private int c;
    private Move currentState; // Adicionando um estado atual

    public RobotXY(int id, String nomeAluno, GPS gps, int l, int c) {
        this.id = id;
        this.nomeAluno = nomeAluno;
        this.gps = gps;
        this.isGoCenter = true;
        this.l = l;
        this.c = c;
        this.currentState = Move.STOP; // Inicializando o estado atual como STOP
    }

    public Move MOVE() {
        if (isGoCenter) {
            int lr = gps.getL(id);
            int cr = gps.getC(id);
            int centerL = (l + 1) / 2;
            int centerC = (c + 1) / 2;

            if (lr == centerL && cr == centerC) {
                isGoCenter = false;
                currentState = Move.STOP;
                return Move.STOP;
            } else {
                if (lr < centerL) {
                    return Move.DOWN;
                } else if (lr > centerL) {
                    return Move.UP;
                } else if (cr < centerC) {
                    return Move.RIGHT;
                } else {
                    return Move.LEFT;
                }
            }
        } else {
            return currentState; // Retorna o estado atual
        }
    }

    public void sweep() {
        currentState = Move.SWEEP;
        int centerL = (l + 1) / 2;
        int centerC = (c + 1) / 2;
        int lr = gps.getL(id);
        int cr = gps.getC(id);

        // Verifica se o robô está no centro da sala
        if (lr == centerL && cr == centerC) {
            int maxSteps = l * c;
            int steps = 0;

            // Movimenta o robô até passar por todas as posições da sala uma vez
            while (steps < maxSteps) {
                Move m1 = MOVE();
                if (m1 == Move.STOP)
                    break;
                gps.move(m1);
                steps++;
            }

            currentState = Move.STOP;
        }
    }

    public void go_center() {
        int centerL = (l + 1) / 2;
        int centerC = (c + 1) / 2;
        int lr = gps.getL(id);
        int cr = gps.getC(id);

        if (lr != centerL) {
            if (lr < centerL) {
                currentState = Move.DOWN;
            } else {
                currentState = Move.UP;
            }
        } else if (cr != centerC) {
            if (cr < centerC) {
                currentState = Move.RIGHT;
            } else {
                currentState = Move.LEFT;
            }
        } else {
            currentState = Move.STOP;
        }
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

    public int getId() {
        return id;
    }

    public void print() {
        System.out.println("DRE: " + id);
        System.out.println("Nome do Aluno: " + nomeAluno);
    }
}
