package programmi;

public class ProgrammiComputer {
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
    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }
    public void setProduttore(String produttore) {
        this.produttore = produttore;
    }
    public void setVersione(String versione) {
        this.versione = versione;
    }
    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }
    public void setAnno(int anno) {
        this.anno = anno;
    }

    //toString
    public String toString() {
        return "ProgrammiComputer [denominazione=" + denominazione + ", produttore=" + produttore + ", versione="+ versione + ", sistemaOperativo=" + sistemaOperativo + ", anno=" + anno + "]";
    }

    //metodo di confronto basato sull'anno di rilascio
    public int compareAnno(ProgrammiComputer altroProgramma) {
        return Integer.compare(this.anno, altroProgramma.getAnno());
    }
}