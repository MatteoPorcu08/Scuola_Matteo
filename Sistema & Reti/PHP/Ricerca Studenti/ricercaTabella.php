<!DOCTYPE html>
<html lang="it">
<head>
    <title>Ricerca Studenti</title>
</head>
<body>
    <h2>Ricerca di uno studente</h2>

    <form method="GET" action="">
        Inserisci il nome da cercare:
        <input type="text" name="nome">
        <input type="submit" value="Cerca">
    </form>

    <?php
        $studenti = array ("Marco", "Luca", "Anna", "Giulia", "Paolo");

        //Riceviamo il parametro del form
        if (isset($_GET["nome"]) && $_GET["nome"] != "") {
            $nome = trim($_GET["nome"]);
        }

        // isset($_GET["nome"]) controlla che il parametro esista.
        // $_GET["nome"] != "" verifica che non sia vuoto
        // trim() elimina gli spazi all'inizo e alla fine del testo inserito

        $trovato = false;
        // ---------------------------------------------------------
        //Cerchiamo il nome dell'array
        
        echo '<table border="1">';
        $trovato = false;

        for ($i = 0; $i < count($studenti); $i++) {
            if (strcasecmp($studenti[$i], $nome) == 0) {
            echo '<p>Nome trovato!</p>';
            $trovato = true;
            echo '<tr><td>' . $i . '</td><td>Nome:</td><td>' . $studenti[$i] . '</td></tr>';
        }
    }
        echo '</table>';

        if($trovato == false){
            echo "<p>Nome non trovato!</p>";
        }
    ?>
</body>
</html>