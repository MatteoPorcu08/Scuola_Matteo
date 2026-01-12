package eventi;
import java.util.Date;
public class Evento {
    private String nome;
    private Date data;

    public Evento(String nome, Date data, List<String> partecipanti) {
        this.nome = nome;
        this.data = data;
    }

    
}
