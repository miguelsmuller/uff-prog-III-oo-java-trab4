import java.io.*;
import java.util.*;

public class APX2_POO_2021_2 {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.appBooting(args);
        sistema.RQA();
        sistema.RQB();
        sistema.RQC();
        sistema.RQD();
        sistema.appShutdown();
    }
}

class Conta {
    int num;
    int quantidade_ocorrencias;
    List<Integer> linhas = new ArrayList<Integer>();
 
    Conta(int num, int linha){
        this.num = num;
        quantidade_ocorrencias = 1;
        linhas.add((int)linha);
    }

    public String toString(){
        return num + " ";
    }
}

class ContaExtended extends Conta implements Comparable<ContaExtended>{
    ContaExtended(int num, int linha) {
        super(num, linha);
    }
    
    @Override
    public int compareTo(ContaExtended another) {
        return Integer.compare(num, another.num);
    }
    
    @Override
    public boolean equals(Object another) {
        if ((another instanceof ContaExtended) && (((ContaExtended)another).num == this.num)) {
            return true;
        }
        return false;
    }
}

class Sistema {
    public ArrayList<int[]> arryOfArryOfNumbers = new ArrayList<int[]>();
    
    public void appBooting(String[] args){
        this.readFile(args);       
    }

    public void appShutdown(){
        System.out.print("\n  _____________________________________________________________________________________________________");
        System.out.print("\n /                                                                                                     \\");
        System.out.print("\n|     Deixei um rascunho na plataforma as 23:10 pois precisava de tempo para entender a Classe Conta   |");
        System.out.print("\n|  Ainda nao conclui o entendimento da Class Conta e a madrugada nao colaborou muito o meu raciocinio! |");
        System.out.print("\n|                         A Classe Conta permanece um misterio pra mim.                                |");
        System.out.print("\n|           Nao sei se o modo que a mesma foi implementada esta de acordo com o proposito.             |");
        System.out.print("\n|                                                                                                      |");
        System.out.print("\n|    DESEJO A VOCE E SUA FAMILIA MUITA SAUDE PARA PASSAR POR ESSE PERIODO DE TRISTEZA QUE VIVEMOS      |");
        System.out.print("\n \\_____________________________________________________________________________________________________/");
    }

    public void RQA(){
        System.out.print("\nITEM <A>:\n");
        for (int i = 0; i < this.arryOfArryOfNumbers.size(); i++){
            List<ContaExtended> listaNumeros = new ArrayList<ContaExtended>();
            List<ContaExtended> listaRetorno = new ArrayList<ContaExtended>();

            // PARA CADA ARQUIVO            
            for(int valorInteiro : this.arryOfArryOfNumbers.get(i)){
                // PARA CADA INTEIRO DE UM ARQUIVO
                if(listaNumeros.contains(new ContaExtended(valorInteiro, i))){
                    int indice = listaNumeros.indexOf(new ContaExtended(valorInteiro, i));
                    ContaExtended paraAtualizar = listaNumeros.get(indice);
                    paraAtualizar.quantidade_ocorrencias++;
                    listaNumeros.set(indice, paraAtualizar);
                }else{
                    listaNumeros.add(new ContaExtended(valorInteiro, i));
                }
            }

            ContaExtended ref = listaNumeros.get(0);
            for(ContaExtended itemTipoConta : listaNumeros){
                if (itemTipoConta.quantidade_ocorrencias >= ref.quantidade_ocorrencias) {
                    ref = itemTipoConta;
                    listaRetorno.add(itemTipoConta);
                }
            }
            System.out.println(listaRetorno);          
        }
    }

    public void RQB(){
        System.out.print("\nITEM <B>:\n");
        for (int i = 0; i < this.arryOfArryOfNumbers.size(); i++){
            List<ContaExtended> listaNumeros = new ArrayList<ContaExtended>();
            List<ContaExtended> listaRetorno = new ArrayList<ContaExtended>();

            // PARA CADA ARQUIVO            
            for(int valorInteiro : this.arryOfArryOfNumbers.get(i)){
                // PARA CADA INTEIRO DE UM ARQUIVO
                if(listaNumeros.contains(new ContaExtended(valorInteiro, i))){
                    int indice = listaNumeros.indexOf(new ContaExtended(valorInteiro, i));
                    ContaExtended paraAtualizar = listaNumeros.get(indice);
                    paraAtualizar.quantidade_ocorrencias++;
                    listaNumeros.set(indice, paraAtualizar);
                }else{
                    listaNumeros.add(new ContaExtended(valorInteiro, i));
                }
            }

            ContaExtended ref = listaNumeros.get(0);
            for(ContaExtended itemTipoConta : listaNumeros){
                if (itemTipoConta.quantidade_ocorrencias >= ref.quantidade_ocorrencias) {
                    ref = itemTipoConta;
                    listaRetorno.add(itemTipoConta);
                }
            }
        }
    }

    public void RQC(){
        System.out.print("\nITEM <C>:\n");
        for (int i = 0; i < this.arryOfArryOfNumbers.size(); i++){
            List<ContaExtended> listaNumeros = new ArrayList<ContaExtended>();
            List<ContaExtended> listaRetorno = new ArrayList<ContaExtended>();

            // PARA CADA ARQUIVO            
            for(int valorInteiro : this.arryOfArryOfNumbers.get(i)){
                // PARA CADA INTEIRO DE UM ARQUIVO
                if(listaNumeros.contains(new ContaExtended(valorInteiro, i))){
                    int indice = listaNumeros.indexOf(new ContaExtended(valorInteiro, i));
                    ContaExtended paraAtualizar = listaNumeros.get(indice);
                    paraAtualizar.quantidade_ocorrencias++;
                    listaNumeros.set(indice, paraAtualizar);
                }else{
                    listaNumeros.add(new ContaExtended(valorInteiro, i));
                }
            }

            ContaExtended ref = listaNumeros.get(0);
            for(ContaExtended itemTipoConta : listaNumeros){
                if (itemTipoConta.quantidade_ocorrencias >= ref.quantidade_ocorrencias) {
                    ref = itemTipoConta;
                    listaRetorno.add(itemTipoConta);
                }
            }
        }
    }

    public void RQD(){
        System.out.print("\nITEM <D>:\n");

        List<ContaExtended> listaNumeros = new ArrayList<ContaExtended>();
        List<ContaExtended> listaRetorno = new ArrayList<ContaExtended>();

        // PARA CADA ARQUIVO    
        for (int i = 0; i < this.arryOfArryOfNumbers.size(); i++){
            for (int j = 0; j < this.arryOfArryOfNumbers.size(); j++){
                // PARA CADA ARQUIVO DIFERENTE DO INICIAL
                if (i != j) {
                    if (this.arryOfArryOfNumbers.get(i).equals(this.arryOfArryOfNumbers.get(j))) {
                        System.out.println("existe");
                    }
                    // PARA CADA INTEIRO DE UM ARQUIVO
                    /* for(int valorInteiro : this.arryOfArryOfNumbers.get(i)){
                        if(listaNumeros.contains(new ContaExtended(valorInteiro, i))){
                            int indice = listaNumeros.indexOf(new ContaExtended(valorInteiro, i));
                            ContaExtended paraAtualizar = listaNumeros.get(indice);
                            paraAtualizar.quantidade_ocorrencias++;
                            listaNumeros.set(indice, paraAtualizar);
                        }else{
                            listaNumeros.add(new ContaExtended(valorInteiro, i));
                        }
                    } */
                }
            }    
            /* ContaExtended ref = listaNumeros.get(0);
            for(ContaExtended itemTipoConta : listaNumeros){
                if (itemTipoConta.quantidade_ocorrencias >= ref.quantidade_ocorrencias) {
                    ref = itemTipoConta;
                    listaRetorno.add(itemTipoConta);
                }
            } */
            //System.out.println(listaRetorno);          
        }
    }


    private void fillArray(String lineFromFile){
        String[] arrySplitedLineWithString = lineFromFile.split(" ");
        int[] arrySplitedLineWithNumbers = new int[arrySplitedLineWithString.length];

        try {
            for (int i = 0; i < arrySplitedLineWithString.length; i++){
                arrySplitedLineWithNumbers[i] = Integer.parseInt(arrySplitedLineWithString[i]);
            }
        } catch (Exception e) {
            System.out.println("Formato de dados no arquivo de leitura incorreto!\nEncerrando Execução!");
            System.exit(1);
        } finally {
            arryOfArryOfNumbers.add(arrySplitedLineWithNumbers);
        }
    }

    private void readFile(String[] args) {
        BufferedReader fileInMemory = null;
        try {
            if (args.length != 0) {
                for (String fileName : args) {
                    this.checkFileExist(fileName);
                    fileInMemory = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
                    this.fillArray((String)fileInMemory.readLine());
                    fileInMemory.close();
                }
            } else {
                throw new Exception("Nenhum arquivo informado!\nÉ necessário fornecer 1 ou mais arquivos como paramêtro do comando!\nEncerrando Execução!");
            }
        } catch (FileNotFoundException e ) {
            System.out.println("Arquivo não encontrado!\nEncerrando Execução!");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Arquivo não pode ser lido!\nEncerrando Execução!");
            System.exit(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    private void checkFileExist(String nameFile) throws Exception{
        File fileCheck = new File(nameFile);

        if(!fileCheck.exists()) { 
            throw new Exception("O Arquivo " + nameFile + " não foi localizado!\nEncerrando Execução!");
        }
    }
}