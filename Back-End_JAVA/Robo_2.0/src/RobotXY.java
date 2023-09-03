public class RobotXY {
    private int id; // Atributo para armazenar o ID do aluno
    private String nomeAluno; // Atributo para armazenar o nome do aluno
    private GPS gps; // Referência para o GPS
    private boolean isGoCenter; // Atributo para controlar o estado do robô
    private int l; // Dimensão l da sala
    private int c; // Dimensão c da sala

    // Construtor da classe
    public RobotXY(int id, String nomeAluno, GPS gps, int l, int c) {
        this.id = id;
        this.nomeAluno = nomeAluno;
        this.gps = gps;
        this.isGoCenter = true; // Inicialmente, o robô está no estado GO CENTER
        this.l = l;
        this.c = c;
    }

    public Move MOVE() {
        if (isGoCenter) {
            // Obtém a localização atual do robô a partir do GPS
            int lr = gps.getL(id);
            int cr = gps.getC(id);

            // Calcula a posição do centro da sala
            int centerL = (l + 1) / 2;
            int centerC = (c + 1) / 2;

            // Verifica se o robô está no centro
            if (lr == centerL && cr == centerC) {
                isGoCenter = false;
                return Move.STOP;
            } else {
                // Decide o movimento para chegar ao centro
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
            // O robô está no estado STOP
            return Move.STOP;
        }
    }

    public int getId() {
        return id;
    }
    // Método para imprimir o DRE e o nome do aluno
    public void print() {
        System.out.println("DRE: " + id);
        System.out.println("Nome do Aluno: " + nomeAluno);
    }
}
