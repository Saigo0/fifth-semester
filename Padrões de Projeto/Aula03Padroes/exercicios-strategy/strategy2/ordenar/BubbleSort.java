package strategy2.ordenar;

public class BubbleSort implements Ordenador {

    @Override
    public void ordenar(int[] itens) {
        bubbleSort(itens);
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean trocou;

        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            // O último elemento i já está no lugar, então não precisamos olhar para ele
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Troca os elementos
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    trocou = true;
                }
            }
            // Se não houve troca nesta iteração, o array já está ordenado
            if (!trocou) break;
        }
    }
}
