public class Pilha<Int> {
    private class No {
        Int elemento;
        No proximo;

        public No(Int elemento) {
            this.elemento = elemento;
            this.proximo = null;
        }
    }

    private No topo;
    private int tamanho;

    public Pilha(){
        topo = null;
        tamanho = 0;
    }

    public void empilhar(Int elemento){
        No novoNo = new No(elemento);
        novoNo.proximo = topo;
        topo = novoNo;
        tamanho++;
    }

    public Int desempilhar(){
        if (estaVazia()){
            return null;
        }
        Int elemento = topo.elemento;
        topo = topo.proximo;
        tamanho--;
        return elemento;
    }

    public boolean estaVazia() {
        return topo == null;
    }

    public int getTamanho() {
        return tamanho;
    }

}


