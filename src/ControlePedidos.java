import java.util.Scanner;
import static java.lang.System.*;
import java.util.Arrays;


public class ControlePedidos {

        public static boolean criarNovoPedido (boolean pedidoCriado) {
            pedidoCriado = true;
            System.out.println("Novo pedido criado!");
            return pedidoCriado;
    }

    public static String[][] adicionarItem(String[][] pedidos, String[] item, double[] valor, boolean pedidoCriado, Scanner leitor){
            //solicita qual pedido tera os itens incluidos
            System.out.println("A qual pedido voce deseja adicionar itens");
            int escolhaPedidos = leitor.nextInt();

            // criando um novo array para armazear o que ja existe so que com mais um de espaço
            String[] novoPedidoItens = new String[pedidos[escolhaPedidos-1].length+1];

            // copiando o ja existente para um novo array
            for (int i = 0; i < pedidos[escolhaPedidos-1].length; i++) {
            novoPedidoItens[i] = pedidos[escolhaPedidos-1][i];
        }
            if(!pedidoCriado){
                out.println("Voce deve criar um pedido antes");
            } else if(item.length == 0){
                out.println("O menu esta vazio, adicione itens antes");
            }else{
                out.println("Itens no menu: ");
                for (int i = 0; i < item.length; i++) {
                    out.println((i+1) + " - " + item[i] + " -> R$" + valor[i]);
                }
                out.println("Escolha o numero de itens para adicionar ao pedido");
                int escolha = leitor.nextInt();
                if(escolha < 1 || escolha > item.length){
                    out.println("Opcão inválida");
                }else{
                    out.print("Item adicionado ao pedido!");
                    novoPedidoItens[novoPedidoItens.length-1] = item[escolha-1];
                    out.println(Arrays.toString(novoPedidoItens));
                }
            }
            pedidos[escolhaPedidos-1] = novoPedidoItens;
            return pedidos;

    }
    public static void mostrarTotalPedido(String[][] pedidos, String[]item, double[] valor, Scanner leitor){
        out.println("Escolha o numero do pedido");
        for (int i = 0; i < pedidos.length ; i++) {
            out.println((i+1));
        }
        int escolha = leitor.nextInt();
        double total = 0;
        for (int i = 0; i < pedidos[escolha - 1].length; i++) {
            for (int j = 0; j < item.length; j++) {
                if(pedidos[escolha-1][i] != null && pedidos[escolha-1][i].equals(item[j])){
                    out.println("Item: "+ pedidos[escolha-1][i] + ", Valor: "+ valor[j]);
                    total += valor[j];
                }
            }
        }
        out.println("O total do pedido é: R$"+ total);
    }


}
