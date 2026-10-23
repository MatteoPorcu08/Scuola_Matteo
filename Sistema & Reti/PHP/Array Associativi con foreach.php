<?php
$studenti = [
    "Nome" => "Antonio",
    "Cognome" => "Selis",
    "Eta" => 18,
    "Citta" => "Milano"
];

echo "<br>";

// Utilizzo corretto del foreach per array associativi
foreach ($studenti as $chiave => $valore) {
    echo "$chiave: $valore <br>";
}
?>
