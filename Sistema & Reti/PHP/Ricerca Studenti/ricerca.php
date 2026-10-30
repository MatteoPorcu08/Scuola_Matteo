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
        for($i = 0 ; $i < count($studenti) ; $i++){

            if(strcasecmp ($studenti[$i], $nome)== 0){
                //strcasecmp() confronta due stringhe senza distinguere tra maiuscole e minuscole
                echo "$studenti [$i]";
                echo "<p>Nome trovato!</p>";
                $trovato = true;
            }
        }

        if($trovato == false){
            echo "<p>Nome non trovato!</p>";
        }
    ?>
</body>
</html>