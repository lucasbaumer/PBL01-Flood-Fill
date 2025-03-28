public class Pilha<Int> {
    private Object[] pilha;
    private int topo;
    private int capacidade;

    public Pilha(int capacidade){
        this.capacidade = capacidade;
        pilha = new Object[capacidade];
        topo = -1;
    }

    public void empilhar(Int elemento){
        if(topo == capacidade - 1){
            aumentarCapacidade();
        }
        pilha[++topo] = elemento;
    }

    public Int desempilhar(){
        if (estaVazia()){
            return null;
        }
        return (Int) pilha[topo--];
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

