package elenco;

/**
 * Classe di array: Serve per gestire un elenco di alunni
 * @author 4B INF
 * @version 2.0
 */
public class ElencoAlunni {
    //ATTRIBUTI
    private static final int NUM_MAX=20;
    private Persona elencoClasse[]; //elenco classe e il riferimento all'array

    /**COSTRUTTORE: Crea l'array di NUM_MAX elementi vuoti
     * @param nessuno
     */
    public ElencoAlunni() {
        elencoClasse=new Persona[NUM_MAX];//Crea l'array di NUM_MAX elementi vuoti
    }

    /** COSTRUTTORE DI COPIA
     * @param altroElenco è l'altro array da copiare
     */
    public ElencoAlunni(ElencoAlunni altroElenco) {
        elencoClasse=new Persona[NUM_MAX];
        for(int i=0;i<NUM_MAX;i++) {
            elencoClasse[i]=altroElenco.elencoClasse[i];
        }
    }
}