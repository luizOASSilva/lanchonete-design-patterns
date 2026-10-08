public abstract class AddComplemento {

    protected abstract Complementos criarComplemento();

    public void fazerPedido(int quantidade) {

        Complementos complemento = criarComplemento();

        double total = complemento.getPreco() * quantidade;

        System.out.println("=== Novo complemento ===");
        System.out.println("Complemento: " + complemento.getNome());
        System.out.println("Valor unitário: R$ " + complemento.getPreco());
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Total: R$ " + total);
        System.out.println();
    }
}