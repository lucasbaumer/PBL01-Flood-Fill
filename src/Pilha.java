public class Pilha<T> {
    private Object[] pilha;
    private int topo;
    private int capacidade;

    public Pilha(int capacidade){
        this.capacidade = capacidade;
        pilha = new Object[capacidade];
        topo = -1;
    }

    public void empilhar(T elemento){
        if(topo == capacidade - 1){
            aumentarCapacidade();
        }
        pilha[++topo] = elemento;
    }

    public T desempilhar(){
        if (estaVazia()){
            return null;
        }
        return (T) pilha[topo--];
    }

    public boolean estaVazia(){
        return topo == -1;
    }

    private void aumentarCapacidade(){
        int novaCapacidade = capacidade * 2;
        Object[] novaPilha = new Object[novaCapacidade];

        for(int i = 0; i < capacidade; i++){
            novaPilha[i] = pilha[i];
        }

        pilha = novaPilha;
        capacidade = novaCapacidade;
    }
}

