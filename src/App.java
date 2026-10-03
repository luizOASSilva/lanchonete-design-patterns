
public class App {
public static void main(String[] args) {
        Carrinho carrinho = new Carrinho();

        carrinho.setForma(new Pix());
        carrinho.finalizarCompra(100);

        carrinho.setForma(new Cartao());
        carrinho.finalizarCompra(100);
    }
}
