public class ControleAcessoService implements ControleAcessoInterface {
    @Override 
    public void visualizarPedido() {
        System.out.println("Visualizando pedido");
    };

    @Override
    public void cancelarPedido() {
        System.out.println("Cancelando pedido");
    };

    @Override 
    public void alterarPedido() {
        System.out.println("Alterando pedido");
    };
}
