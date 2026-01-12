package eventi;
import java.util.Date;
import java.util.List;
public class Evento {
    private String nome;
    private Date data;
    private List<String> partecipanti;

    public Evento(String nome, Date data, List<String> partecipanti) {
        this.nome = nome;
        this.data = data;
        this.partecipanti = partecipanti;
    }

    
}
