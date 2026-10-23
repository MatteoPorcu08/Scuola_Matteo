<?php
// Avvia la sessione per mantenere in memoria i dati inseriti tra i vari invii del form
session_start();

// Definizione della classe Auto
class Auto {
    public $marca;
    public $modello;
    public $anno;

    public function __construct($marca, $modello, $anno) {
        $this->marca = trim($marca);
        $this->modello = trim($modello);
        $this->anno = (int)$anno;
    }
}

// Inizializza il database nella sessione se non esiste ancora
if (!isset($_SESSION['database_auto'])) {
    $_SESSION['database_auto'] = [
        new Auto("Fiat", "Panda", 2020),
        new Auto("Ford", "Fiesta", 2018),
        new Auto("Fiat", "500", 2022),
        new Auto("Audi", "A3", 2020)
    ];
}

// Stile CSS integrato per la pagina di risposta
echo "<style>
    body { font-family: Arial, sans-serif; margin: 40px; background-color: #f4f4f9; }
    .box { max-width: 600px; background: white; padding: 20px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); }
    h3 { color: #333; border-bottom: 2px solid #28a745; padding-bottom: 5px; }
    ul { list-style-type: square; padding-left: 20px; }
    li { margin-bottom: 8px; font-size: 16px; }
    a { display: inline-block; margin-top: 20px; color: #007BFF; text-decoration: none; font-weight: bold; }
    a:hover { text-decoration: underline; }
</style>";

echo "<div class='box'>";

// Controllo del tipo di azione inviata dal form
if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['azione'])) {
    $azione = $_POST['azione'];

    // AZIONE 1: Inserimento di una nuova auto
    if ($azione === 'inserisci') {
        $marca = $_POST['marca'];
        $modello = $_POST['modello'];
        $anno = $_POST['anno'];

        // Crea l'oggetto e lo aggiunge all'array in sessione
        $nuova_auto = new Auto($marca, $modello, $anno);
        $_SESSION['database_auto'][] = $nuova_auto;

        echo "<h3>Successo!</h3>";
        echo "<p>L'auto <strong>{$nuova_auto->marca} {$nuova_auto->modello} ({$nuova_auto->anno})</strong> è stata registrata con successo.</p>";
    } 
    
    // AZIONE 2: Ricerca e visualizzazione per marca o anno
    elseif ($azione === 'cerca') {
        $chiave = trim($_POST['chiave']);
        $trovato = false;

        echo "<h3>Risultati della ricerca per: '" . htmlspecialchars($chiave) . "'</h3>";
        echo "<ul>";

        foreach ($_SESSION['database_auto'] as $auto) {
            // Se la chiave è un numero, esegue il controllo sull'anno. Altrimenti, controlla la marca (case-insensitive).
            if (is_numeric($chiave)) {
                $condizione = ($auto->anno === (int)$chiave);
            } else {
                $condizione = (strcasecmp($auto->marca, $chiave) === 0);
            }

            if ($condizione) {
                echo "<li><strong>{$auto->marca}</strong> {$auto->modello} — Anno: {$auto->anno}</li>";
                $trovato = true;
            }
        }

        echo "</ul>";

        if (!$trovato) {
            echo "<p>Nessuna vettura corrispondente ai criteri inseriti.</p>";
        }
    }
} else {
    echo "<h3>Errore</h3><p>Accesso non consentito direttamente a questa pagina.</p>";
}

// Pulsante per tornare al form principale
echo "<a href='index.html'>&larr; Torna alla pagina principale</a>";
echo "</div>";
?>