import java.util.Scanner;
import static java.lang.System.*;


public class ControleValor {
    public static double[] atribuiValor(double[] novoMenuValores, String[] item, Scanner leitor){


       double[] novoArrayValores = new double[novoMenuValores.length +1];

        for (int i = 0; i < novoMenuValores.length; i++) {
            novoArrayValores[i] = novoMenuValores[i];
        }
       if (item.length == 0){
           out.println("não ha itens no menu");
       }else {
           out.println("Itens no menu: ");
           for (int i = 0; i < item.length; i++) {
               out.println((i+1)+" "+ item[i]) ;
           }
           out.println("escolha o numero do item para atribuir o valor");
           leitor.nextLine();

           out.println("informe o valor do item");
           novoArrayValores[novoArrayValores.length -1] = leitor.nextDouble();
           out.println("valor adicionado");
       }
        return novoArrayValores;
    }
}
