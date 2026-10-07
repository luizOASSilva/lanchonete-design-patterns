import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pagamento catalogo = new Pagamento();
        Carrinho carrinho = new Carrinho();
        
         

        System.out.println("O valor da compra foi de quanto?: ");
        double valorCompra = Double.parseDouble(scanner.nextLine());

        System.out.print("Forma de pagamento (pix, dinheiro, cartao, vr): ");
        String escolha = scanner.nextLine();

        FormaPagamento forma = catalogo.escolher(escolha);

        if (forma == null) {
            System.out.println("Forma de pagamento inválida.");
        } else {
            carrinho.setForma(forma);
            carrinho.finalizarCompra(valorCompra);
        }

        scanner.close();
    }
}