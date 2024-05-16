import java.util.Scanner;
import static java.lang.System.*;


public class ControleValor {

    /*
     *
     * metodo capaz de relacionar valores aos produtos, criando um array maior, dps copiando os valores de um array
     * para outro, posteriormente selecionando a qual produto será relacionado o valor, fazendo as validações
     * nescessarias
     *
     */

    public double[] adicionarValor(double[] arrayParaAdicionar, String[] produto, Scanner leitor){

        /*
         * criando novo array igual o que ja existia so que com mais 1 de espaço
         */
        double[] novoArrayValores = new double[arrayParaAdicionar.length+1];


        /*
         * loop que copia os intens de um array para o outro
         */
        for (int i = 0; i < arrayParaAdicionar.length; i++) novoArrayValores[i] = arrayParaAdicionar[i];


        // validação se há itens no menu
        if(produto.length == 0) out.println("Não há itens no menu");

        // loop para printar os itens no menu
        else {
            // loop iniciado em 1 pois la no inicio foram instanciados com 1
            out.println("Itens no menu:");
            for (int i = 1; i < produto.length; i++) out.println((i) + " - " + produto[i]);


            // solicita e armazena o numero do item para atribuir o valor
            out.println("Escolha o numero do item para atribuir valor");
            int escolha = leitor.nextInt();

            // valida se a opção digitada existe
            if(escolha < 1 || escolha > produto.length) out.println("Opção invalida");


            else{
                // informando e armazeando o valor na ultima posição do array
                out.println("Informe o valor do item");
                novoArrayValores[novoArrayValores.length-1] = leitor.nextDouble();
                out.println("Valor adicionado ✅");
            }
        }
        return novoArrayValores;
    }
}