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

class Exame extends Tratamento{
    Exame(String prmNomeConstructor, int prmValorConstructor){
        super(prmNomeConstructor, prmValorConstructor);
        this.fatorCalculoCusto = 20.00;
    }
    public String toString() {
        return this.prmNomeConstructor + ", " + this.custo();
    }
}

class Cirurgia extends Tratamento{
    Cirurgia(String prmNomeConstructor, int prmValorConstructor){
        super(prmNomeConstructor, prmValorConstructor);
        this.fatorCalculoCusto = 100.00;
    }
    public String toString() {
        return this.prmNomeConstructor + ", " + this.custo();
    }
}

class Medicamento extends Tratamento{
    Medicamento(String prmNomeConstructor, int prmValorConstructor){
        super(prmNomeConstructor, prmValorConstructor);
    }
    public String toString() {
        return this.prmNomeConstructor + ", " + this.custo();
    }
}

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