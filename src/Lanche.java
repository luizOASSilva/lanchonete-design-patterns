public abstract class Lanche {
    protected String nome;
    protected double preco;
    protected String tipoPao;
    protected String recheioPrincipal;
    protected boolean temQueijo;
    protected String molho;

  
    public abstract void preparar();

    public void exibirDetalhes() {
        System.out.println("Lanche: " + this.nome);
        System.out.println("Preço: R$ " + this.preco);
        System.out.println("Pão: " + this.tipoPao);
        System.out.println("Recheio: " + this.recheioPrincipal);
        System.out.println("Queijo: " + (this.temQueijo ? "Sim" : "Não"));
        System.out.println("Molho: " + this.molho);
    }
}