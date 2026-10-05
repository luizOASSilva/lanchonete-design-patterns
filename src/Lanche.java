public abstract class Lanche {
    private String nome;
    private double preco;
    private String tipoPao;
    private String recheioPrincipal;
    private boolean temQueijo;
    private String molho;

    protected Lanche(String nome, double preco, String tipoPao,
                     String recheioPrincipal, boolean temQueijo, String molho) {
        this.nome = nome;
        setPreco(preco); 
        this.tipoPao = tipoPao;
        this.recheioPrincipal = recheioPrincipal;
        this.temQueijo = temQueijo;
        this.molho = molho;
    }

    public abstract void preparar();

    public void exibirDetalhes() {
        System.out.println("Lanche: " + nome);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Pão: " + tipoPao);
        System.out.println("Recheio: " + recheioPrincipal);
        System.out.println("Queijo: " + (temQueijo ? "Sim" : "Não"));
        System.out.println("Molho: " + molho);
    }


    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public String getTipoPao() { return tipoPao; }
    public String getRecheioPrincipal() { return recheioPrincipal; }
    public boolean isTemQueijo() { return temQueijo; }
    public String getMolho() { return molho; }

    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }
        this.preco = preco;
    }

    public void setMolho(String molho) {
        this.molho = molho;
    }
}