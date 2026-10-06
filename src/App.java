import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pagamento catalogo = new Pagamento();
        Carrinho carrinho = new Carrinho();

        System.out.print("Forma de pagamento (pix, cartao, dinheiro, vr): ");
        String escolha = scanner.nextLine();

        FormaPagamento forma = catalogo.escolher(escolha);

        if (forma == null) {
            System.out.println("Forma de pagamento inválida.");
        } else {
            carrinho.setForma(forma);
            carrinho.finalizarCompra(100);
        }

        scanner.close();
    }
}
