import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;


public class Main {
    public static void main(String[] args){
         // instanciação do scanner que sera usado em todo processo
        Scanner leitor = new Scanner(in);

        // instanciação dos demais
        ControleItem controleItem = new ControleItem();
        ControleValor controleValor = new ControleValor();
        ControlePedidos controlePedidos = new ControlePedidos();

        int opcaoMenu = -1;

        String[] item = new String[0];
        double[] valor = new double[0];
        String [][] pedidos = new String[0][];
        boolean[] pedidosCriados = new boolean[0];


        while (opcaoMenu != 0) {

            opcaoMenu = exibeMenu(leitor);

            switch (opcaoMenu) {
                case 1: item = controleItem.adicionaItem(item, leitor);

                    break;
               case 2: {
                valor = controleValor.atribuiValor(valor,item,leitor);
                break;
               }
               case 3: {
                ControleItem.listarItens(item,valor);
                break;
               }
               case 4: {
                    pedidos = Arrays.copyOf(pedidos,  pedidos.length + 1);
                    pedidos[pedidos.length-1] = new String[0];
                    pedidosCriados = Arrays.copyOf(pedidosCriados, pedidosCriados.length+1);
                    pedidosCriados[pedidosCriados.length-1] = ControlePedidos.criarNovoPedido(false);
                    break;
               }
                case 5: {
                    out.println("Escolha o numero do pedido para adicionar");
                    int escolhaPedido = leitor.nextInt();
                    pedidos = ControlePedidos.adicionarItem(pedidos, item, valor, pedidosCriados[escolhaPedido-1], leitor);
                    break;
                }
                case 6: {
                    ControlePedidos.mostrarTotalPedido(pedidos, item, valor, leitor);
                    break;
                }
            }
            
        }
    }
    
    private static int exibeMenu(Scanner leitor){
        int opcaoMenu;
        out.println("Escolha uma opção: \n" +
            "1 - Adicionar item \n" +
            "2 - Adicionar preço \n" +
            "3 - Listar os itens\n" +
            "4 - Criar novo pedido\n" +
            "5 - Adicionar item no pedido\n" +
            "6 - Mostrar valor total do pedido\n");

        opcaoMenu = leitor.nextInt();
        leitor.nextLine();

        return opcaoMenu;
        
    }
}
