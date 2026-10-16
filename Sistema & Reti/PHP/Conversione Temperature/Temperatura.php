<?php

$temperatura = $_POST["temperatura"]; // Recupera la temperatura inserita dall'utente
$scala = $_POST["scala"]; // Recupera la scala selezionata dall'utente

// Conversione della temperatura in base alla scala selezionata
if ($scala == "celsius") {

    $celsius = $temperatura;
    $fahrenheit = ($temperatura * 9 / 5) + 32; // Formula per convertire Celsius in Fahrenheit
    $kelvin = $temperatura + 273.15; // Formula per convertire Celsius in Kelvin

} elseif ($scala == "fahrenheit") {

    $fahrenheit = $temperatura;
    $celsius = ($temperatura - 32) * 5 / 9; // Formula per convertire Fahrenheit in Celsius
    $kelvin = ($temperatura - 32) * 5 / 9 + 273.15; // Formula per convertire Fahrenheit in Kelvin
    $kelvin = ($temperatura - 32) * 5 / 9 + 273.15;

} else {

    $kelvin = $temperatura;
    $celsius = $temperatura - 273.15;
    $fahrenheit = ($temperatura - 273.15) * 9 / 5 + 32;

}

// Visualizzazione dei risultati
echo "<h1>Risultato conversione</h1>";

echo "Celsius: " . round($celsius, 2) . " °C<br>";
echo "Fahrenheit: " . round($fahrenheit, 2) . " °F<br>";
echo "Kelvin: " . round($kelvin, 2) . " K<br>";

echo "<br><a href='index.html'>Torna indietro</a>";

?>