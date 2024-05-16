import static java.lang.System.*;
import java.util.Scanner;

public class ControleItem {

    /*
     * metodo responsavel por adicionar item no menu, faz aquele velho loop de copiar um array para o outro e armazenar
     *  o novo item na ultima posição do novo array
     */

    public String[] adicionarProduto(String[] arrayParaAdicionar, Scanner leitor){

        // criando novo array igual o que ja existia so que com mais 1 de espaço
        String[] novoArray = new String[arrayParaAdicionar.length+1];

        // loop que copia os intens de um array para o outro
        for (int i = 0; i < arrayParaAdicionar.length; i++) novoArray[i] = arrayParaAdicionar[i];


        /*
         * nomeando e armazenando o novo produto adicionado na ultima posição do novo array
         */
        out.println("Informe o nome do item");
        novoArray[novoArray.length-1] = leitor.nextLine();
        out.println("Item adicionado com sucesso ✅");
        return novoArray;
    }
}