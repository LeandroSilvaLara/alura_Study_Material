import java.util.ArrayList;

public class Principal {
    // Método para inicializar e preencher um ArrayList
    public static ArrayList<Integer> inicializarArrayList() {
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(10);
        al.add(15);
        al.add(20);
        return al;
    }

    // Método para imprimir os elementos de um ArrayList
    public static void imprimirArrayList(ArrayList<Integer> al) {
        for (int i : al) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int[] vetor = new int[10];
        vetor[0] = 5;

        System.out.println(vetor[0]); // 5
        System.out.println(vetor[1]); // 0

        System.out.print("\nArrayList 1\n");
        ArrayList<Integer> al1 = new ArrayList<Integer>();
        al1.add(5);
        System.out.println(al1.get(0)); // 5

        try {
            // Tentando acessar uma posição inexistente
            System.out.println(al1.get(1));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro ao acessar posição: " + e.getMessage());
        }

        ArrayList<Integer> al2 = inicializarArrayList();

        if (al2.isEmpty())
            System.out.print("\nArrayList 2 ainda não tem elementos");

        System.out.print("\nArrayList 2\n");
        imprimirArrayList(al2);
        System.out.print("Tamanho " + al2.size() + "\n");

        System.out.print("\nArrayList 2\n");
        al2.add(1, 13);
        al2.remove(3);
        imprimirArrayList(al2);

        int index = al2.indexOf(15);
        System.out.print("\nPosição do 15: " + index);
    }
}