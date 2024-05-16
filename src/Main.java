import java.util.Scanner;
import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {

        /*
        * instanciações dos demais metodos usados no codigo
        */
        Scanner leitor = new Scanner(in);
        ControleItem controleItem = new ControleItem();
        ControleValor controleValor = new ControleValor();
        ControlePedidos controlePedidos = new ControlePedidos();

        /*
         *
         * variaveis produtos e valor instanciadas com 1, para de que seu espaço 0 sirva de espaço vazio
         *
         */
        String[] produtos = new String[1];
        double[] valor = new double[1];
        int[][] pedidos = new int[0][0];
        // pedidos instanciado em 0 pois inicia vazio, ja que nos arrays acima foram instanciados em 1 para o 0 ser o vazio



        /*
         *
         * inicializando menu em -1 por que se fosse 0 entraria em conflito com o while
         *
         */
        int opcaoMenu = -1;



        /*
         *  while que executará o menu tendo suas funções linkadas por um switch case
         */
        while (opcaoMenu != 0) {

            /*
            chamando a funcao exibe menu que mostrara ao usuario as opcoes do menu
             */
            opcaoMenu = exibeMenu(leitor);

            /*
            switch case que direciona a opcao digitada pelo usuario à funcao relacionada de seu numero
             */
            switch (opcaoMenu) {

                case 1 -> produtos = controleItem.adicionarProduto(produtos, leitor);
                /**
                 * chamada a funcao adicionar produto que perterce ao metodo controleItem, o qual irá adicionar os
                 * produtos no "menu", no qual os parametros passados são, produtos e leitor pois é a varivel na qual se
                 * armazena os produtos e o leitor possibilita o input
                 */

                case 2 -> valor = controleValor.adicionarValor(valor, produtos, leitor);
                /*
                 * chamada a funcao que adiciona o valor a um produto, a mesma tem os parametros como valor, pois é
                 * onde é armazenada o valor, produtos, pois a localização e os preços vao andar juntos, o pedido na
                 * posição [1], só tera como valor correspondente o valor [1]
                 *
                 */

                case 3 -> listaItem(produtos, valor);
                /*
                 *  chama a funcao listaItens que percorre e imprime o array de produtos e valores na mesma posição
                 */

                case 4 -> {
                    pedidos = controlePedidos.criarPedido(pedidos);
                    out.println("Pedido " + pedidos.length + " criado");
                    /*
                     *  chama a funcao criar pedido que verifica se os pedidos estão vazios, se sim, cria uma nova
                     *  matriz de espaços [1][1] e retorna a matriz pedidos, nesse caso, o 0 representa o vazio,
                     *  Se nao, faz dois loops para copiar o array bidirecional e adicionar mais um espaço, assim
                     *  criando mais infinitos pedidos e ao final printando qual pedido foi criado
                     *
                     */
                }
                case 5 -> pedidos = controlePedidos.adicionarItem(pedidos, produtos, valor, leitor);
                /*
                 * chama a funcao adicionar item no metodo controle de pedidos, que inicialmente pede para escolher
                 * qual pedido irá adicionar os itens, logo apos isso, usa um loop for pora copiar os itens do pedido
                 * para o pedido com + 1 item
                 */

                case 6 -> ControlePedidos.mostrarTotalPedido(pedidos, produtos, valor, leitor);
                /*
                 * funcao que mostra o o item e os valores do pedido solicitado, usando dois for i, e alinhando a
                 * posicao da matriz
                 */
            }

        }
    }


    private static int exibeMenu(Scanner leitor) {
        /*
        funcao que exibe o menu para o usuario, para direciona-lo a tomar alguma atitude
         */
        int opcaoMenu;
        out.println("========== Menu =========== \n" +
                "1 Adicionar item \n" +
                "2 Atribuir valor ao item \n" +
                "3 Listar os itens\n" +
                "4 Criar novo pedido\n" +
                "5 Adicionar item no pedido\n" +
                "6 Mostrar valor total do pedido\n");
        opcaoMenu = leitor.nextInt();
        leitor.nextLine();
        return opcaoMenu;
    }

    private static void listaItem(String[] produtos, double[] valor) {
        /*
        loop que imprime os itens armazenados no array produtos, usado no case 3
         */
        for (int i = 1; i < produtos.length; i++) out.println((i) + "." + produtos[i] + " - R$" + valor[i]);
    }

}