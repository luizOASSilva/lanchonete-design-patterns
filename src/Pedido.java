import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private List<ItemPedido> itens;
    private boolean cancelado;
    private boolean fechado;

    public Pedido() {
        itens = new ArrayList<>();
        cancelado = false;
        fechado = false;
    }

    public void adicionarItem(String nome, double preco, int quantidade) {

        if (cancelado) {
            System.out.println("Não é possível adicionar itens a um pedido cancelado.");
            return;
        }

        if (fechado) {
            System.out.println("Não é possível adicionar itens a um pedido fechado.");
            return;
        }

        if (quantidade <= 0) {
            System.out.println("A quantidade deve ser maior que zero.");
            return;
        }

        itens.add(new ItemPedido(nome, preco, quantidade));
    }

    public void removerItem(int indice) {

        if (indice >= 0 && indice < itens.size()) {

            itens.remove(indice);

            System.out.println(
                    "Item removido do pedido."
            );

        } else {

            System.out.println(
                    "Item inválido."
            );
        }
    }

    public void alterarQuantidade(int indice, int novaQuantidade) {

        if (indice < 0 || indice >= itens.size()) {
            System.out.println("Item inválido.");
            return;
        }

        if (novaQuantidade <= 0) {

            System.out.println(
                    "A quantidade deve ser maior que zero."
            );

            return;
        }

        itens.get(indice).setQuantidade(
                novaQuantidade
        );

        System.out.println(
                "Quantidade alterada com sucesso."
        );
    }

    public int quantidadeItens() {
        return itens.size();
    }

    public double calcularTotal() {

        double total = 0;

        for (ItemPedido item : itens) {
            total += item.getTotal();
        }

        return total;
    }

    public boolean estaVazio() {
        return itens.isEmpty();
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public boolean isFechado() {
        return fechado;
    }

    public void cancelar() {

        if (cancelado) {

            System.out.println(
                    "O pedido já está cancelado."
            );

            return;
        }

        if (fechado) {

            System.out.println(
                    "O pedido já está fechado."
            );

            return;
        }

        cancelado = true;

        System.out.println(
                "Pedido cancelado com sucesso!"
        );
    }

    public void fechar() {

        if (estaVazio()) {

            System.out.println(
                    "Não é possível fechar um pedido vazio."
            );

            return;
        }

        fechado = true;
    }

    public void visualizar() {

        System.out.println();
        System.out.println("=================================================");
        System.out.println("                    COMANDA");
        System.out.println("=================================================");

        if (cancelado) {

            System.out.println("STATUS: CANCELADO");
            System.out.println("=================================================");

            return;
        }

        if (fechado) {
            System.out.println("STATUS: FECHADO");
        }

        if (itens.isEmpty()) {

            System.out.println("Pedido vazio.");
            System.out.println("=================================================");
            System.out.printf("TOTAL: R$ %.2f%n", 0.0);
            System.out.println("=================================================");

            return;
        }

        for (int i = 0; i < itens.size(); i++) {

            ItemPedido item = itens.get(i);

            System.out.printf(
                    "%d - %dx %s - R$ %.2f%n",
                    i + 1,
                    item.getQuantidade(),
                    item.getNome(),
                    item.getTotal()
            );
        }

        System.out.println("-------------------------------------------------");

        System.out.printf(
                "TOTAL: R$ %.2f%n",
                calcularTotal()
        );

        System.out.println("=================================================");
    }
}
