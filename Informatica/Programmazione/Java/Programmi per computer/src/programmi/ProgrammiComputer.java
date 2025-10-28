package programmi;

public class ProgrammiComputer {
    //denominazione, produttore, versione, sistema operativo, anno
    private String denominazione;
    private String produttore;
    private String versione;
    private String sistemaOperativo;
    private int anno;

    //costruttore
    public ProgrammiComputer(String denominazione, String produttore, String versione, String sistemaOperativo, int anno) {
        this.denominazione = denominazione;
        this.produttore = produttore;
        this.versione = versione;
        this.sistemaOperativo = sistemaOperativo;
        this.anno = anno;
    }
    
    //getter
    public String getDenominazione() {
        return denominazione;
    }
    public String getProduttore() {
        return produttore;
    }
    public String getVersione() {
        return versione;
    }
    public String getSistemaOperativo() {
        return sistemaOperativo;
    }
    public int getAnno() {
        return anno;
    }

    //setter

}
