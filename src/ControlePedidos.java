import java.util.Scanner;
import static java.lang.System.*;


public class ControlePedidos {

    /*
     * metodo que adiciona os itens nas colunas do array bi dimensional, incia solicitando o nurmero do pedido
     */

    public int[][] adicionarItem(int[][] pedidos, String[] produtos, double[] valor, Scanner leitor) {


        /*
         *
         * primeira parte, trabalhando a qual pedido adicionar itens
         *
         */

        // solicitando o numero do pedido
        out.println("Escolha o numero do pedido para adicionar itens");
        int escolhaPedidos = leitor.nextInt();

        // criando novo array maior
        int[] novoPedido = new int[pedidos[escolhaPedidos - 1].length + 1];

        // copia o array existente pra o novo com mais espaço
        for (int i = 0; i < pedidos[escolhaPedidos - 1].length; i++) novoPedido[i] = pedidos[escolhaPedidos - 1][i];




        /*
         *
         * Segunda parte, trabalhando com qual produto adicionar no pedido escolhido
         *
         */

        // validação se há itens
        if (produtos.length == 0) out.println("Não há itens no menu, adicione antes de fazer um pedido");

         // printa os itens
        else {
            out.println("Itens no menu:");
            for (int i = 1; i < produtos.length; i++) {
                out.println((i) + " . " + produtos[i] + " - R$" + valor[i]);
            }

            // solicita qual item adicionar ao pedido
            out.println("Escolha o numero do item para adicionar ao pedido: ");
            int escolha = leitor.nextInt();


            // valida se o item existe
            if (escolha < 1 || escolha > produtos.length) out.println("Opção inválida");
            else {
                out.println("Item adicionado ✅");
                novoPedido[novoPedido.length-1] = escolha;
            }
        }



        /*
         *
         * Terceira parte, armazenando
         *
         */

        // atualiza pedidos
        pedidos[escolhaPedidos-1] = novoPedido;

        // retorna pedidos atualizados
        return pedidos;
    }




    /*
     * metodo que faz a criação dos pedidos, usando a primeira coluna
     */
    public int[][] criarPedido(int[][]pedidos){

        /*
         *  faz a validação e se sim, inicializa novo array bi de pedidos, comecando na posição 1
         */
        if(pedidos.length < 1){
            pedidos = new int[1][1];
            return pedidos;
        }

        /*
         * fora do if, cria o clone do array so que maior
         */
        int[][]novoPedidos = new int[pedidos.length + 1][pedidos[0].length];

        /*
         * loop usado no codigo inteiro, que copia elementos do array pra o clone maior
         */
        for (int i = 0; i < pedidos.length; i++) {
            for (int j = 0; j < pedidos[i].length; j++) {
                novoPedidos[i][j] = pedidos[i][j];
            }
        }
        return novoPedidos;
    }
    public static void mostrarTotalPedido(int[][] pedidos, String[] produtos, double[] valor, Scanner leitor){

        /*
         * Pede pro usuario escolher qual pedido sera mostrado e printa os pedidos existentes
         */

        // printa os pedidos
        out.println("Escolha o numero do pedido para mostrar o total: ");
        for (int i = 0; i < pedidos.length; i++) out.println("Pedido " + (i+1));

        //armazena os pedidos
        // cria a variavel total
        int escolha = leitor.nextInt();
        double total = 0;

        /*
         * primeiro for pega a length do pedido escolhido,
         * segundo for pega a length dos produtos que estão no pedido acima,
         * e depois faz uma validação com o if se os produtos e os preços existem, e
         * printa os produtos e seus respectivos valores, e soma os valores[j] na variavel total
         */
        for (int i = 0; i < pedidos[escolha - 1].length; i++) {
            for (int j = 0; j < produtos.length; j++) {
                if(pedidos[escolha-1][i] == j && produtos[j] != null && valor[j] != 0){
                    out.println("item: " + produtos[j] + ", valor: " + valor[j]);
                    total += valor[j];
                }
            }
        }
        out.println("O valor total de seu pedido é de: R$" + total);
    }

}
