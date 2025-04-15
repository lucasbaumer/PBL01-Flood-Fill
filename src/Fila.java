public class Fila<Int> {
    private class No {
        Int elemento;
        No proximo;

        public No(Int elemento) {
            this.elemento = elemento;
            this.proximo = null;
        }
    }

    private No frente;
    private No tras;
    private int tamanho;

    public Fila(){
        frente = null;
        tras = null;
        tamanho = 0;
    }

    public void enfileirar(Int elemento){
        No novoNo = new No(elemento);

        if(estaVazia()) {
            frente = novoNo;
            tras = novoNo;
        } else {
            tras.proximo = novoNo;
            tras = novoNo;
        }
        tamanho++;
        }

    public Int desenfileirar(){
        if(estaVazia()){
            return null;
        }
        Int elemento = frente.elemento;
        frente = frente.proximo;

        if(frente == null){
            tras = null;
        }

        tamanho--;

        return elemento;
    }

    public boolean estaVazia(){
        return tamanho == 0;
    }

    public int getTamanho(){
        return tamanho;
    }
}
