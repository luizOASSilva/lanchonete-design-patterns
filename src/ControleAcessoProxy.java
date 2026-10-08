public class ControleAcessoProxy implements ControleAcessoInterface {
    private Usuario usuario;
    private ControleAcessoService realService;

    public ControleAcessoProxy(Usuario usuario) {
        this.usuario = usuario;
        this.realService = new ControleAcessoService();
    }

    @Override 
    public void visualizarPedido(Pedido pedido) {
        if(usuario.getFuncao().equals("CLIENTE")){
            realService.visualizarPedido(pedido);
        } else if(pedido.isFechado()){
            realService.visualizarPedido(pedido);
        } else {
            System.out.println("Acesso negado, o pedido só pode ser visualizado pelo Vendedor ou Administrador após o cliente finalizar o pedido!");
        }
    }

    @Override
    public void cancelarPedido(Pedido pedido) {
        if(usuario.getFuncao().equals("ADMIN") && pedido.isFechado()){
            realService.cancelarPedido(pedido);
        } else {
            System.out.println("Acesso negado, apenas o administrador pode cancelar um pedido fechado!");
        }
    };

    @Override 
    public void alterarPedido(Pedido pedido, int indice, int novaQuantidade) {
        if(usuario.getFuncao().equals("CLIENTE") && !pedido.isFechado()){
            realService.alterarPedido(pedido, indice, novaQuantidade);
        } else if((usuario.getFuncao().equals("VENDEDOR") || usuario.getFuncao().equals("ADMIN")) && pedido.isFechado()){
            realService.alterarPedido(pedido, indice, novaQuantidade);
        } else {
            System.out.println("Acesso negado, o Cliente só pode alterar pedidos em aberto e o Vendedor ou Administrador só podem alterar pedidos fechados!");
        }
    };

    @Override
    public void removerItem(Pedido pedido, int indice) {
        if(usuario.getFuncao().equals("CLIENTE") && !pedido.isFechado()){
            realService.removerItem(pedido, indice);
        } else if((usuario.getFuncao().equals("VENDEDOR") || usuario.getFuncao().equals("ADMIN")) && pedido.isFechado()){
            realService.removerItem(pedido, indice);
        } else {
            System.out.println("Acesso negado, o Cliente só pode remover itens de pedidos em aberto e o Vendedor ou Administrador só podem remover itens de pedidos fechados!");
        }
    };

    @Override
    public boolean podeAlterarPedido(Pedido pedido) {
        if(usuario.getFuncao().equals("CLIENTE") && !pedido.isFechado()){
            return true;
        }

        if((usuario.getFuncao().equals("VENDEDOR") || usuario.getFuncao().equals("ADMIN")) && pedido.isFechado()){
            return true;
        }

        System.out.println("Acesso negado, você não pode alterar esse pedido!");
        return false;
    };
}
