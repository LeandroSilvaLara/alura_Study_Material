public class Principal {
    public static void main(String[] args) {
        int l = 5;
        int c = 7;
        int id = 12345;
        GPS gps = new GPS(l, c);

        RobotXY robot = new RobotXY(id, gps);

        // Ativar os estados desejados
        robot.clockwise(); // Ou use robot.counterCw() ou robot.alternating()


        Move move;

        do {
            move = robot.move();
            System.out.println(move);
        } while (move != Move.STOP);

        robot.print();

        Move m1 = Move.UP;

       if( m1 == Move.DOWN )
           System.out.print("Mensagem igual");
       else
           System.out.print("Mensagem diferente \n");

       if( m1 == Move.UP )
           System.out.print("Mensagem igual");
        else
            System.out.print("Mensagem diferente");

   }
}
