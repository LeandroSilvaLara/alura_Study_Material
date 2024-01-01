import java.util.Random;

public class Robot29 {

    private boolean hasReceivedPassword = false;
    private boolean isWaitingForService = false;
    private String password = null;
    private Random random = new Random();
    private boolean hasBeenServiced = false;
    private int id;
    private String nomeAluno;
    private GPS gps;
    private boolean isGoCenter;
    private int l;
    private int c;
    private Move currentState;

    private Password passwordManager; // Adicionando a classe Password

    public String getRobotPosition() {
        return "Posição atual do robô - Linha: " + gps.getL(id) + ", Coluna: " + gps.getC(id);
    }

    public void enterRoom() {
        // Posiciona o robô no canto inferior esquerdo
        gps.setL(id, 1);
        gps.setC(id, 1);
    }

    public Robot29(int id, String nomeAluno, GPS gps, int l, int c, Password passwordManager) {
        this.id = id;
        this.nomeAluno = nomeAluno;
        this.gps = gps;
        this.isGoCenter = true;
        this.l = l;
        this.c = c;
        this.currentState = Move.STOP;
        this.passwordManager = passwordManager;
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

    public void getNewPassword() {
        if (gps.getL(id) == 1 && gps.getC(id) == 1) {
            password = passwordManager.getNewPassword(id);
            System.out.println("Nova senha gerada: " + password);
        } else {
            System.out.println("O robô precisa estar na posição inicial para obter uma nova senha.");
        }
    }

    public void callPassword(int elance) {
        if (elance > 0 && elance <= passwordManager.getQttyC()) {
            System.out.println("Senha chamada no elance: " + elance);
            moveToBottomRight(); // Adapte esta lógica conforme necessário
        } else {
            System.out.println("Elance inválido. Por favor, insira um elance válido para chamar a senha.");
        }
    }

    private void moveToBottomRight() {
        int centerL = (l + 1) / 2;
        int centerC = (c + 1) / 2;

        if (gps.getL(id) < centerL) {
            currentState = Move.DOWN;
        } else if (gps.getL(id) > centerL) {
            currentState = Move.UP;
        } else if (gps.getC(id) < centerC) {
            currentState = Move.RIGHT;
        } else {
            currentState = Move.LEFT;
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

    public void getPassword() {
        if (gps.getL(id) == l && gps.getC(id) == 1) {
            hasReceivedPassword = true;
            password = generateRandomPassword(); // Gere uma senha aleatória
        }
    }

    public void checkPassword() {
        if (hasReceivedPassword) {
            System.out.println("Senha recebida: " + password);
        } else {
            System.out.println("Senha não recebida.");
        }
    }

    public void service() {
        if (isWaitingForService) {
            hasBeenServiced = true;
        }
    }

    public void waitForService() {
        if (hasReceivedPassword && gps.getL(id) == 1 && gps.getC(id) == c) {
            isWaitingForService = true;
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



    private String generateRandomPassword() {
        // Gera um valor aleatório único para cada robô
        int randomValue = random.nextInt(10000); // Você pode ajustar o intervalo conforme necessário

        // Combina o ID do robô com o valor aleatório gerado
        password = String.format("senha_%d_%d", id, randomValue);

        return password;
    }



    public void print() {
        System.out.println("DRE: " + id);
        System.out.println("Nome do Aluno: " + nomeAluno);
    }
}