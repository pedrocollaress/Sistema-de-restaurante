import java.util.Scanner;
import static java.lang.System.*;

public class ControleItem {

    // metodo responsavel por adicionar itens no menu
    public String[] adicionaItem(String[] arrayParaAdicionar, Scanner leitor){

        String[] novoArray = new String[arrayParaAdicionar.length + 1];

        // for para copiar um array para o outro
        for (int i = 0; i < arrayParaAdicionar.length; i++) {
            novoArray[i] = arrayParaAdicionar[i];
        }

        // recebendo, armazenando e informando que o item foi adicionado
        out.println("informe o nome do item");
        novoArray[novoArray.length-1] = leitor.nextLine();
        out.println("Item adicionado!");

        return novoArray;
    }

    // metodo que lista os array
    public static void listarItens(String[]item, double[] valor){
        for (int i = 0; i < item.length; i++) {
            out.println((i+1)+" - "+item[i]+" -> R$"+ valor[i]);
        }
    }










}