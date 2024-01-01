public class GPS {
    private int lr = 5;
    private int cr = 5;
    private int l = 11;
    private int c = 11;
    public int getL ( int id ) {
        return lr;
    }
    public int getC ( int id ) {
        return cr;
    }
    public void move ( Move m1 ) {
        if( m1 == Move.UP && lr > 1)
            lr--;
        if( m1 == Move.LEFT && cr > 1)
            cr--;
        if( m1 == Move.DOWN && lr < l)
            lr++;
        if( m1 == Move.RIGHT && cr < c)
            cr++;
    }

    // Define a coordenada lr para o robô com o ID especificado
    public void setL(int id, int newValue) {
        if (id == 120097832) { // Verifica se é o ID do robô específico
            lr = newValue;
        }
    }

    // Define a coordenada cr para o robô com o ID especificado
    public void setC(int id, int newValue) {
        if (id == 120097832) { // Verifica se é o ID do robô específico
            cr = newValue;
        }
    }
}
