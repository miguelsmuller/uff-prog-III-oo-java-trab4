// NOTA: 4,1

//
// Q1: 2,7 PONTOS
//

import java.util.*;

interface Solicitacao{
    Double custo();
}

class APX2_POO_2021_1 {
    public static void main(String[] args) {
        Solicitacao sangue = new Exame("Exame de Sangue", 20);
        Solicitacao biopsia = new Cirurgia("Biopsia", 30);
        Tratamento analiseAlergia = new Tratamento();
        analiseAlergia.adicionaSolicitacao(Arrays.asList(sangue, biopsia));
        System.out.println(analiseAlergia);

        Solicitacao anestesia = new Medicamento("Anestesia", 1000);
        Solicitacao septo = new Cirurgia("Correção de Septo", 120);
        Tratamento correcaoSepto = new Tratamento();
        correcaoSepto.adicionaSolicitacao(anestesia);
        correcaoSepto.adicionaSolicitacao(septo);
        System.out.println(correcaoSepto);

        Solicitacao cisto = new Cirurgia("Extração de Cisto", 60);
        Tratamento extracaoCisto = new Tratamento();
        extracaoCisto.adicionaSolicitacao(Arrays.asList(analiseAlergia, anestesia, cisto));
        System.out.println(extracaoCisto);
    }
}

//-0,5 por Procedimento
//-0,5 herança incorreta
class Exame extends Tratamento{
    Exame(String prmNomeConstructor, int prmValorConstructor){
        super(prmNomeConstructor, prmValorConstructor);
        this.fatorCalculoCusto = 20.00;
    }
    public String toString() {
        return this.prmNomeConstructor + ", " + this.custo();
    }
}

//-0,5 herança incorreta
class Cirurgia extends Tratamento{
    Cirurgia(String prmNomeConstructor, int prmValorConstructor){
        super(prmNomeConstructor, prmValorConstructor);
        this.fatorCalculoCusto = 100.00;
    }
    public String toString() {
        return this.prmNomeConstructor + ", " + this.custo();
    }
}

//-0,5 herança incorreta
class Medicamento extends Tratamento{
    Medicamento(String prmNomeConstructor, int prmValorConstructor){
        super(prmNomeConstructor, prmValorConstructor);
    }
    public String toString() {
        return this.prmNomeConstructor + ", " + this.custo();
    }
}

//-0,3 por prmNomeConstructor, prmValorConstructor e fatorCalculoCusto
class Tratamento implements Solicitacao, Comparable<Tratamento>{
    private static int uid = 0;
    private int id;
    protected String prmNomeConstructor;
    protected int prmValorConstructor;
    protected Double fatorCalculoCusto = 1.0;
    private List<Solicitacao> arryOfTratamentos = new ArrayList<>();

    Tratamento(){
        this.id = uid++;
        this.prmNomeConstructor = null;
        this.prmValorConstructor = 0;
    }
    Tratamento(String prmNomeConstructor, int prmValorConstructor){
        this.prmNomeConstructor = prmNomeConstructor;
        this.prmValorConstructor = prmValorConstructor;
    }

    public int getID(){
        return this.id;
    }
    
    public void adicionaSolicitacao(List<Solicitacao> lstSolicitacoes){
        this.arryOfTratamentos = lstSolicitacoes;
    }

    public void adicionaSolicitacao(Solicitacao objSolicitacoes){
        this.arryOfTratamentos.add(objSolicitacoes);
    }

    @Override
    public Double custo() {
        if (!arryOfTratamentos.isEmpty()){
            Double somatorioInterno = 0.0;
            for(Solicitacao elm: arryOfTratamentos){
                somatorioInterno += elm.custo();
            }
            return somatorioInterno;
        }
        return this.fatorCalculoCusto * this.prmValorConstructor;
    }

    @Override
    public int compareTo(Tratamento another) {
        return Double.compare(this.custo(), another.custo());
    }

    @Override
    public String toString() {
        String strReturn = "";
        arryOfTratamentos.sort(Comparator.comparingDouble(Solicitacao::custo).reversed());
        
        strReturn += "Tratamento " + this.getID() + " {" + "\n";
        for(Solicitacao elm: arryOfTratamentos){
            strReturn += elm.toString() + "\n";
        }
        strReturn += "}";

        return strReturn;
    }
}

//
// Q2: 1,4 PONTOS (LEITURA CORRETA DE args)
//

/*
Rosseti@rosseti-Inspiron-3647:~/Área de Trabalho/2021.1/CEDERJ/APX2/Miguel Alves Da Silva Neto_VRE_24288141/Q2$ javac APX2_POO_2021_2.java 
rosseti@rosseti-Inspiron-3647:~/Área de Trabalho/2021.1/CEDERJ/APX2/Miguel Alves Da Silva Neto_VRE_24288141/Q2$ java APX2_POO_2021_2 xxx.txt yyy.txt zzz.txt 

ITEM <A>:
[1 , 2 , 3 ]
[2 , 4 ]
[1 , 2 , 3 ]

ITEM <B>:

ITEM <C>:

ITEM <D>:
  _____________________________________________________________________________________________________
 /                                                                                                     \
|     Deixei um rascunho na plataforma as 23:10 pois precisava de tempo para entender a Classe Conta   |
|  Ainda nao conclui o entendimento da Class Conta e a madrugada nao colaborou muito o meu raciocinio! |
|                         A Classe Conta permanece um misterio pra mim.                                |
|           Nao sei se o modo que a mesma foi implementada esta de acordo com o proposito.             |
|                                                                                                      |
|    DESEJO A VOCE E SUA FAMILIA MUITA SAUDE PARA PASSAR POR ESSE PERIODO DE TRISTEZA QUE VIVEMOS      |
 \_____________________________________________________________________________________________________/
 
RESPOSTA CORRETA:
rosseti@rosseti-Inspiron-3647:~/Dropbox/2021.1/CEDERJ/APX2$ java AP2_2021_1_Q2 xxx.txt yyy.txt zzz.txt 
Letra (a):
1 
2 4 7 
1 3 

Letra (b):
6 
2 4 7 
2 5 4 

Letra (c):
2 4 

Letra (d):
6 7 
*/

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
