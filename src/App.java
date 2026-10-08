import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        telaLogin();
    }

    public static void telaLogin() {

        Usuario usuario = new Usuario();

        System.out.println("""
                
                ╔════════════════════════════════════════════════════╗
                ║        SISTEMA DE PEDIDOS LANCHONETE             ║
                ╠════════════════════════════════════════════════════╣
                """);

        System.out.print("║ Usuário: ");
        String nome = scanner.nextLine();

        System.out.print("║ Senha: ");
        String senha = scanner.nextLine();

        if (nome.equals("admin") && senha.equals("1234")) {

            usuario = new Usuario(
                    "admin",
                    "ADMIN",
                    "1234"
            );

        } else if (nome.equals("vendedor") && senha.equals("1234")) {

            usuario = new Usuario(
                    "vendedor",
                    "VENDEDOR",
                    "1234"
            );

        } else if (nome.equals("cliente") && senha.equals("1234")) {

            usuario = new Usuario(
                    "cliente",
                    "CLIENTE",
                    "1234"
            );

        } else {

            System.out.println();
            System.out.println("Login ou senha incorretos.");
            scanner.close();
            return;
        }

        System.out.println();
        System.out.println("Login realizado com sucesso!");
        System.out.println("Usuário: " + usuario.getNome());
        System.out.println("Função: " + usuario.getFuncao());

        menuPrincipal(usuario);
    }

    public static void menuPrincipal(Usuario usuario) {

        Pedido pedido = new Pedido();

        ControleAcessoInterface controle =
                new ControleAcessoProxy(usuario);

        int opcao;

        do {

            System.out.println("""
                    
                    ╔════════════════════════════════════════╗
                    ║             MENU PRINCIPAL             ║
                    ╠════════════════════════════════════════╣
                    ║                                        ║
                    ║  1 - Realizar pedido                   ║
                    ║  2 - Visualizar pedido                 ║
                    ║  3 - Editar pedido                     ║
                    ║  4 - Cancelar pedido                   ║
                    ║  5 - Finalizar pedido                  ║
                    ║  6 - Trocar usuário                    ║
                    ║  0 - Sair                              ║
                    ╚════════════════════════════════════════╝
                    """);

            System.out.print("Escolha uma opção: ");

            try {

                opcao = Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("Digite uma opção válida.");
                opcao = -1;
            }

            switch (opcao) {

                case 1:
                    telaPedido(pedido);
                    break;

                case 2:
                    controle.visualizarPedido(pedido);
                    System.out.println();
                    System.out.print("Pressione ENTER para voltar ao menu...");
                    scanner.nextLine();
                    break;

                case 3:
                    telaEditar(pedido, controle);
                    break;

                case 4:

                    if (pedido.estaVazio()) {

                        System.out.println(
                                "Não existe nenhum pedido para cancelar."
                        );

                        System.out.println();
                        System.out.print("Pressione ENTER para voltar ao menu...");
                        scanner.nextLine();

                    } else {

                        telaCancelar(pedido, controle);

                        if (pedido.isCancelado()) {
                            pedido = new Pedido();
                        }
                    }

                    break;

                case 5:
                    telaFinalizar(pedido, usuario);
                    break;

                case 6:

                    Usuario novoUsuario = trocarUsuario();

                    if (novoUsuario != null) {
                        usuario = novoUsuario;
                        controle = new ControleAcessoProxy(usuario);
                    }

                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    public static Usuario trocarUsuario() {

        Usuario usuario = new Usuario();

        System.out.println("""
                
                ╔════════════════════════════════════════╗
                ║             TROCAR USUÁRIO              ║
                ╠════════════════════════════════════════╣
                """);

        System.out.print("║ Usuário: ");
        String nome = scanner.nextLine();

        System.out.print("║ Senha: ");
        String senha = scanner.nextLine();

        if (nome.equals("admin") && senha.equals("1234")) {

            usuario = new Usuario(
                    "admin",
                    "ADMIN",
                    "1234"
            );

        } else if (nome.equals("vendedor") && senha.equals("1234")) {

            usuario = new Usuario(
                    "vendedor",
                    "VENDEDOR",
                    "1234"
            );

        } else if (nome.equals("cliente") && senha.equals("1234")) {

            usuario = new Usuario(
                    "cliente",
                    "CLIENTE",
                    "1234"
            );

        } else {

            System.out.println();
            System.out.println("Login ou senha incorretos.");

            System.out.println();
            System.out.print("Pressione ENTER para voltar ao menu...");
            scanner.nextLine();

            return null;
        }

        System.out.println();
        System.out.println("Login realizado com sucesso!");
        System.out.println("Usuário: " + usuario.getNome());
        System.out.println("Função: " + usuario.getFuncao());

        return usuario;
    }

    public static void telaPedido(Pedido pedido) {

        if (pedido.isCancelado()) {

            System.out.println(
                    "Não existe nenhum pedido ativo."
            );

            System.out.println();
            System.out.print("Pressione ENTER para voltar ao menu...");
            scanner.nextLine();

            return;
        }

        if (pedido.isFechado()) {

            System.out.println(
                    "Esse pedido já está fechado e não pode receber novos itens."
            );

            System.out.println();
            System.out.print("Pressione ENTER para voltar ao menu...");
            scanner.nextLine();

            return;
        }

        System.out.println("""
                
                ╔════════════════════════════════════════╗
                ║              NOVO PEDIDO               ║
                ╠════════════════════════════════════════╣
                ║ 1 - X-Bacon                            ║
                ║ 2 - X-Salada                           ║
                ║ 3 - X-Tudo                             ║
                ║ 4 - X-Frango                           ║
                ║ 5 - Batata com cheddar                 ║
                ║ 6 - Refrigerante                       ║
                ║ 0 - Voltar                             ║
                ╚════════════════════════════════════════╝
                """);

        System.out.print("Escolha: ");

        int opcao;

        try {

            opcao = Integer.parseInt(scanner.nextLine());

        } catch (NumberFormatException e) {

            System.out.println("Opção inválida.");
            return;
        }

        if (opcao == 0) {
            return;
        }

        System.out.print("Quantidade: ");

        int quantidade;

        try {

            quantidade = Integer.parseInt(scanner.nextLine());

        } catch (NumberFormatException e) {

            System.out.println("Quantidade inválida.");
            return;
        }

        if (quantidade <= 0) {

            System.out.println(
                    "A quantidade deve ser maior que zero."
            );

            return;
        }

        switch (opcao) {

            case 1:

                LanchoneteXBacon bacon =
                        new LanchoneteXBacon();

                Lanche lancheBacon =
                        bacon.fazerPedido(quantidade);

                pedido.adicionarItem(
                        lancheBacon.getNome(),
                        lancheBacon.getPreco(),
                        quantidade
                );

                break;

            case 2:

                LanchoneteXSalada salada =
                        new LanchoneteXSalada();

                Lanche lancheSalada =
                        salada.fazerPedido(quantidade);

                pedido.adicionarItem(
                        lancheSalada.getNome(),
                        lancheSalada.getPreco(),
                        quantidade
                );

                break;

            case 3:

                LanchoneteXTudo tudo =
                        new LanchoneteXTudo();

                Lanche lancheTudo =
                        tudo.fazerPedido(quantidade);

                pedido.adicionarItem(
                        lancheTudo.getNome(),
                        lancheTudo.getPreco(),
                        quantidade
                );

                break;

            case 4:

                LanchoneteXFrango frango =
                        new LanchoneteXFrango();

                Lanche lancheFrango =
                        frango.fazerPedido(quantidade);

                pedido.adicionarItem(
                        lancheFrango.getNome(),
                        lancheFrango.getPreco(),
                        quantidade
                );

                break;

            case 5:

                CompleBatata batata =
                        new CompleBatata();

                Complementos complementoBatata =
                        batata.fazerPedido(quantidade);

                pedido.adicionarItem(
                        complementoBatata.getNome(),
                        complementoBatata.getPreco(),
                        quantidade
                );

                break;

            case 6:

                CompleRefri refri =
                        new CompleRefri();

                Complementos complementoRefri =
                        refri.fazerPedido(quantidade);

                pedido.adicionarItem(
                        complementoRefri.getNome(),
                        complementoRefri.getPreco(),
                        quantidade
                );

                break;

            default:

                System.out.println(
                        "Produto inválido."
                );

                return;
        }

        System.out.println("Item adicionado ao pedido!");
    }

    public static void telaEditar(
            Pedido pedido,
            ControleAcessoInterface controle) {

        if (pedido.isCancelado()) {

            System.out.println(
                    "Não existe nenhum pedido para editar."
            );

            System.out.println();
            System.out.print("Pressione ENTER para voltar ao menu...");
            scanner.nextLine();

            return;
        }

        if (pedido.estaVazio()) {

            System.out.println(
                    "O pedido está vazio."
            );

            System.out.println();
            System.out.print("Pressione ENTER para voltar ao menu...");
            scanner.nextLine();

            return;
        }

        if (!controle.podeAlterarPedido(pedido)) {

            System.out.println();
            System.out.print("Pressione ENTER para voltar ao menu...");
            scanner.nextLine();

            return;
        }

        System.out.println("""
                
                ╔════════════════════════════════════════╗
                ║              EDITAR PEDIDO              ║
                ╠════════════════════════════════════════╣
                ║ 1 - Alterar quantidade                  ║
                ║ 2 - Remover item                        ║
                ║ 0 - Voltar                              ║
                ╚════════════════════════════════════════╝
                """);

        System.out.print("Escolha: ");

        int opcao;

        try {

            opcao = Integer.parseInt(scanner.nextLine());

        } catch (NumberFormatException e) {

            System.out.println("Opção inválida.");
            return;
        }

        if (opcao == 0) {
            return;
        }

        if (opcao != 1 && opcao != 2) {

            System.out.println("Opção inválida.");

            System.out.println();
            System.out.print("Pressione ENTER para voltar ao menu...");
            scanner.nextLine();

            return;
        }

        pedido.visualizar();

        System.out.print(
                "Número do item: "
        );

        int item;

        try {

            item = Integer.parseInt(scanner.nextLine());

        } catch (NumberFormatException e) {

            System.out.println("Item inválido.");

            System.out.println();
            System.out.print("Pressione ENTER para voltar ao menu...");
            scanner.nextLine();

            return;
        }

        if (item <= 0 || item > pedido.quantidadeItens()) {

            System.out.println(
                    "Não existe item com o número " + item + " no pedido."
            );

            System.out.println();
            System.out.print("Pressione ENTER para voltar ao menu...");
            scanner.nextLine();

            return;
        }

        if (opcao == 1) {

            System.out.print(
                    "Nova quantidade: "
            );

            int quantidade;

            try {

                quantidade = Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("Quantidade inválida.");

                System.out.println();
                System.out.print("Pressione ENTER para voltar ao menu...");
                scanner.nextLine();

                return;
            }

            controle.alterarPedido(
                    pedido,
                    item - 1,
                    quantidade
            );

        } else if (opcao == 2) {

            controle.removerItem(
                    pedido,
                    item - 1
            );
        }
    }

    public static void telaCancelar(
            Pedido pedido,
            ControleAcessoInterface controle) {

        System.out.println("""
                
                ╔════════════════════════════════════════╗
                ║             CANCELAR PEDIDO             ║
                ╠════════════════════════════════════════╣
                ║ 1 - Confirmar cancelamento              ║
                ║ 0 - Voltar                              ║
                ╚════════════════════════════════════════╝
                """);

        System.out.print("Escolha: ");

        int opcao;

        try {

            opcao = Integer.parseInt(scanner.nextLine());

        } catch (NumberFormatException e) {

            System.out.println("Opção inválida.");
            return;
        }

        if (opcao == 0) {
            return;
        }

        if (opcao == 1) {

            controle.cancelarPedido(pedido);

            System.out.println();
            System.out.print("Pressione ENTER para voltar ao menu...");
            scanner.nextLine();

        } else {

            System.out.println("Opção inválida.");
        }
    }

    public static void telaFinalizar(
            Pedido pedido,
            Usuario usuario) {

        if (!usuario.getFuncao().equals("CLIENTE")) {

            System.out.println(
                    "Apenas o cliente pode finalizar o pedido."
            );

            System.out.println();
            System.out.print("Pressione ENTER para voltar ao menu...");
            scanner.nextLine();

            return;
        }

        if (pedido.isCancelado()) {

            System.out.println(
                    "Não existe nenhum pedido para finalizar."
            );

            System.out.println();
            System.out.print("Pressione ENTER para voltar ao menu...");
            scanner.nextLine();

            return;
        }

        if (pedido.isFechado()) {

            System.out.println(
                    "O pedido já está fechado."
            );

            System.out.println();
            System.out.print("Pressione ENTER para voltar ao menu...");
            scanner.nextLine();

            return;
        }

        if (pedido.estaVazio()) {

            System.out.println(
                    "Não existe nenhum pedido para finalizar."
            );

            System.out.println();
            System.out.print("Pressione ENTER para voltar ao menu...");
            scanner.nextLine();

            return;
        }

        pedido.visualizar();

        System.out.println("""
                
                ╔════════════════════════════════════════╗
                ║           FINALIZAR PEDIDO             ║
                ╠════════════════════════════════════════╣
                ║ 1 - PIX                                ║
                ║ 2 - Cartão                             ║
                ║ 3 - Dinheiro                           ║
                ║ 4 - VR                                 ║
                ║ 0 - Voltar                             ║
                ╚════════════════════════════════════════╝
                """);

        System.out.print("Escolha: ");

        int opcao;

        try {

            opcao = Integer.parseInt(
                    scanner.nextLine()
            );

        } catch (NumberFormatException e) {

            System.out.println(
                    "Opção inválida."
            );

            return;
        }

        if (opcao == 0) {
            return;
        }

        String escolha = "";

        switch (opcao) {

            case 1:
                escolha = "pix";
                break;

            case 2:
                escolha = "cartao";
                break;

            case 3:
                escolha = "dinheiro";
                break;

            case 4:
                escolha = "vr";
                break;

            default:
                System.out.println(
                        "Forma de pagamento inválida."
                );

                return;
        }

        Pagamento catalogo =
                new Pagamento();

        FormaPagamento forma =
                catalogo.escolher(escolha);

        if (forma == null) {

            System.out.println(
                    "Forma de pagamento inválida."
            );

            return;
        }

        Carrinho carrinho =
                new Carrinho();

        carrinho.setForma(forma);

        carrinho.finalizarCompra(
                pedido.calcularTotal()
        );

        pedido.fechar();

        System.out.println();
        System.out.println(
                "PEDIDO FECHADO!"
        );

        System.out.println();
        System.out.print("Pressione ENTER para voltar ao menu...");
        scanner.nextLine();
    }
}
