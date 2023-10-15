public class Principal {
    public static void main (String args[]) {
        GPS g1 = new GPS();
        RobotXY r1 = new RobotXY( 120097832, "Leandro", g1, 11, 11);
        //r1.clockwise();
        r1.sweep(); // Ativa o estado SWEEP

        r1.go_center();

        while( true ) {
            Move m1 = r1.MOVE();
            if( m1 == Move.STOP )
                break;
            g1.move( m1 );
        }
        System.out.println("Path taken during go_center:");
        r1.go_center();

        System.out.println("Estado atual do robô: " + r1.MOVE());
        // Exibindo a localização atual do robô
        int currentL = g1.getL(r1.getId());
        int currentC = g1.getC(r1.getId());
        System.out.println("Localização atual do robô - Linha: " + currentL + ", Coluna: " + currentC);

        r1.counterCw();

        while (true) {
            Move m1 = r1.MOVE();
            if (m1 == Move.STOP)
                break;
            g1.move(m1);
        }
        System.out.println("Estado atual do robô: " + r1.MOVE());
        r1.alternating();

        while (true) {
            Move m1 = r1.MOVE();
            if (m1 == Move.STOP)
                break;
            g1.move(m1);
        }

        // Exibindo o estado atual após o movimento
        System.out.println("Estado atual do robô: " + r1.MOVE());
        // Imprimindo o DRE e o nome do aluno
        r1.print();
        System.out.print("\nFim\n");
    }
}