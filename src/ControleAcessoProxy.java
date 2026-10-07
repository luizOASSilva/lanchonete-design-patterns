public class ControleAcessoProxy implements ControleAcessoInterface {
    private Usuario usuario;
    private ControleAcessoService realService;

    public ControleAcessoProxy(Usuario usuario) {
        this.usuario = usuario;
        this.realService = new ControleAcessoService();
    }

    @Override 
    public void visualizarPedido() {
        realService.visualizarPedido();
    }

    @Override
    public void cancelarPedido() {
        if(usuario.getFuncao().equals("ADMIN")){
            realService.cancelarPedido();
        } else {
            System.out.println("Acesso negado, apenas o administrador do sistema pode cancelar o pedido!");
        }
    };

    @Override 
    public void alterarPedido() {
        if(usuario.getFuncao().equals("ADMIN") || usuario.getFuncao().equals("VENDEDOR")){
            realService.alterarPedido();
        } else {
            System.out.println("Acesso negado, apenas o administrador ou o Vendedor do sistema pode alterar o pedido, entre em contato!");
        }
    }
}

