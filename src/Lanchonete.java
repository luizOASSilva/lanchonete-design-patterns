public abstract class Lanchonete {

    protected abstract Lanche criarLanche();

    public void fazerPedido(int quantidade) {
        Lanche lanche = criarLanche();
        double total = lanche.getPreco() * quantidade;

        System.out.println("=== Novo pedido ===");
        System.out.println("Lanche: " + lanche.getNome());
        System.out.println("Valor unitário: R$ " + lanche.getPreco());
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Total: R$ " + total);
        System.out.println();
    }
}