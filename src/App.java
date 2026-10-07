import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        telaLogin();
    }

    public static void telaLogin(){
        Usuario usuario = new Usuario();
        System.out.print("╔════════════════════════════════════════════════════════════╗\n"+
                         "║               SISTEMA DE PEDIDOS LANCHONETE                ║\n"+
                         "╠════════════════════════════════════════════════════════════╣\n"+
                         "║                                                            ║\n"+
                         "║  Usuário:");
        String nome = scanner.nextLine();
        usuario.setNome(nome);
        System.out.print("║  Senha:");   
        String senha = scanner.nextLine();
        // Verificação de senha necessaria
        System.out.println("║                                                            ║\n"+
                           "╚════════════════════════════════════════════════════════════╝");
        menuPrincipal(usuario);
    }

    public static void menuPrincipal(Usuario usuario){
        ControleAcessoProxy controle = new ControleAcessoProxy(usuario);
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
                    ║  0 - Sair                              ║
                    ╚════════════════════════════════════════╝
                    """);

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            switch (opcao) {

                case 1:
                    telaPedido();
                    break;
                case 2:
                    telaComanda();
                    break;
                case 3:
                    telaEditar();
                    break;
                case 4:
                    telaCancelar();
                    break;
                case 5:
                    telaFinalizar();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
            controle.visualizarPedido();
            controle.alterarPedido();
            controle.cancelarPedido();
    }

    public static void telaPedido(){

    };
          
    public static void telaComanda(){

    };
             
    public static void telaEditar(){

    };
            
    public static void telaCancelar(){

    };
       
    public static void telaFinalizar(){

    };
}