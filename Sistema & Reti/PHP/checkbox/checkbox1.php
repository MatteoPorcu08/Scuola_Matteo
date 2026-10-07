<?php
    if (isset($_POST["invia"])) {

        if (isset($_POST["hobby"])) {

            $hobby = $_POST["hobby"];

            echo "Hai selezionato i seguenti hobby:<br>";

            foreach ($_POST["hobby"] as $hobby) {
                echo "- " . $hobby . "<br>";
            }

        } else {
            echo "Nessun hobby selezionato.";
        }
    }
?>
