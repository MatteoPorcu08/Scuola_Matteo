<?php
$array = array(); //la funzione array() crea un array vuoto
$array [] = "Franco";
$array [] = "Mario";
$array [] = "Lorenzo";

echo ("<br>");

echo $array[0];
echo ("<br>");
echo $array[1];
echo ("<br>");
echo $array[2];

//---------------------------------

$array1 = array (100, 200, 300);

print_r($array1);
echo ("<br>");
echo count($array1);
echo ("<br>");

echo ("Numer elementi array;");
echo ("<br>");

//---------------------------------
$numeri = array('3', '5', '7', '9', '11');

unset($numeri[2]); //rimuove l'elemento in posizione 2
foreach ($numeri as $valore) {
    echo $valore;
    echo ("<br>");
}

?>