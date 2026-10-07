public class App {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Luiz", "VENDEDOR");

        ControleAcessoInterface controle = new ControleAcessoProxy(usuario);

        controle.visualizarPedido();
        controle.alterarPedido();
        controle.cancelarPedido();
    }
}