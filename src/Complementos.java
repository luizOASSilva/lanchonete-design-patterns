public abstract class Complementos {

    private String nome;
    private double preco;

    protected Complementos(String nome, double preco) {
        this.nome = nome;
        setPreco(preco);
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }

        this.preco = preco;
    }
}