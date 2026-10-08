public class ControleAcessoService implements ControleAcessoInterface {
    @Override 
    public void visualizarPedido(Pedido pedido) {
        pedido.visualizar();
    };

    @Override
    public void cancelarPedido(Pedido pedido) {
        pedido.cancelar();
    };

    @Override 
    public void alterarPedido(Pedido pedido, int indice, int novaQuantidade) {
        pedido.alterarQuantidade(indice, novaQuantidade);
    };

    @Override
    public void removerItem(Pedido pedido, int indice) {
        pedido.removerItem(indice);
    };

    @Override
    public boolean podeAlterarPedido(Pedido pedido) {
        return true;
    };
}
