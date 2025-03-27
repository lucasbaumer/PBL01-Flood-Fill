public class Fila<T> {
    private Object[] fila;
    private int capacidade;
    private int frente;
    private int tras;
    private int tamanho;

    public Fila(int capacidade){
        this.capacidade = capacidade;
        fila = new Object[capacidade];
        frente = 0;
        tras = -1;
        tamanho = 0;
    }

    public void enfileirar(T elemento){
        if(tamanho == capacidade){
            aumentarCapacidade();
        }
        tras = (tras + 1) % capacidade;
        fila[tras] = elemento;
        tamanho++;
    }

    public T desenfileirar(){
        if(estaVazia()){
            return null;
        }
        T elemento = (T) fila[frente];
        fila[frente] = null;
        frente = (frente + 1) % capacidade;
        tamanho --;
        return elemento;
    }

    public boolean estaVazia(){
        return tamanho == 0;
    }

    private void aumentarCapacidade(){
        int novaCapacidade = capacidade * 2;
        Object[] novaFila = new Object[novaCapacidade];
        for(int i = 0; i < capacidade; i++){
            novaFila[i] = fila[(frente + i) % capacidade];
        }
        fila = novaFila;
        frente = 0;
        tras = tamanho - 1;
        capacidade = novaCapacidade;

    }
}
