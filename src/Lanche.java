public abstract class Lanche {
    private String nome;
    private double preco;
    private String recheio;
    private String Queijo;
    private String molho;

    protected Lanche(String nome, double preco,
            String recheio, String Queijo, String molho) {
        this.nome = nome;
        setPreco(preco);
        this.recheio = recheio;
        this.Queijo = Queijo;
        this.molho = molho;
    }

    public abstract void preparar();

    public void exibirDetalhes() {
        System.out.println("Lanche: " + nome);
        System.out.println("Preço: R$ " + preco);
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getRecheio() {
        return recheio;
    }

    public String getQueijo() {
        return Queijo;
    }

    public String getMolho() {
        return molho;
    }

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