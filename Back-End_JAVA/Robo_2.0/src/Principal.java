public class Principal {
    public static void main (String args[]) {
        GPS g1 = new GPS();
        RobotXY r1 = new RobotXY( 1, "SeuNome", g1, 11, 11);
        while( true ) {
            Move m1 = r1.MOVE();
            if( m1 == Move.STOP )
                break;
            g1.move( m1 );
        }
        // Exibindo a localização atual do robô
        int currentL = g1.getL(r1.getId());
        int currentC = g1.getC(r1.getId());
        System.out.println("Localização atual do robô - Linha: " + currentL + ", Coluna: " + currentC);

        // Imprimindo o DRE e o nome do aluno
        r1.print();
        System.out.print("\nFim\n");
    }
}