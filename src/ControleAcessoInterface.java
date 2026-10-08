public interface ControleAcessoInterface {
    void visualizarPedido(Pedido pedido);

    void cancelarPedido(Pedido pedido);

    void alterarPedido(Pedido pedido, int indice, int novaQuantidade);

    void removerItem(Pedido pedido, int indice);

    boolean podeAlterarPedido(Pedido pedido);
}
