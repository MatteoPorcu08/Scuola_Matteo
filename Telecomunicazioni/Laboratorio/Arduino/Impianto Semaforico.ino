const int ledRosso = 10;
const int ledGiallo = 9;
const int ledVerde = 8;

const int ledRosso2 = 4;
const int ledGiallo2 = 3;
const int ledVerde2 = 2;

const int ledRosso3 = 7;
const int ledVerde3 = 6;

const int pulsante = 5;

bool richiesta = false;
unsigned long inizio = 0;
int statoSemaforo = 0;

void setup()
{
    pinMode(ledRosso, OUTPUT);
    pinMode(ledGiallo, OUTPUT);
    pinMode(ledVerde, OUTPUT);

    pinMode(ledRosso2, OUTPUT);
    pinMode(ledGiallo2, OUTPUT);
    pinMode(ledVerde2, OUTPUT);

    pinMode(ledRosso3, OUTPUT);
    pinMode(ledVerde3, OUTPUT);

    pinMode(pulsante, INPUT_PULLUP);

    digitalWrite(ledVerde, HIGH);
    digitalWrite(ledRosso2, HIGH);

    digitalWrite(ledGiallo, LOW);
    digitalWrite(ledGiallo2, LOW);
    digitalWrite(ledVerde2, LOW);

    digitalWrite(ledRosso3, HIGH);
    digitalWrite(ledVerde3, LOW);

    inizio = millis();
}

void loop()
{

    if (digitalRead(pulsante) == LOW)
    {
        richiesta = true;
    }

    unsigned long ora = millis();

    switch (statoSemaforo)
    {

    case 0: // Semaforo 1 verde
        if (ora - inizio >= 5000)
        {
            digitalWrite(ledVerde, LOW);
            digitalWrite(ledGiallo, HIGH);
            inizio = ora;
            statoSemaforo = 1;
        }
        break;

    case 1:
        if (ora - inizio >= 2000)
        {
            digitalWrite(ledGiallo, LOW);
            digitalWrite(ledRosso, HIGH);

            if (richiesta)
            {
                digitalWrite(ledRosso2, HIGH);
                digitalWrite(ledRosso3, LOW);
                digitalWrite(ledVerde3, HIGH);

                inizio = ora;
                statoSemaforo = 4;
            }
            else
            {
                digitalWrite(ledRosso2, LOW);
                digitalWrite(ledVerde2, HIGH);

                inizio = ora;
                statoSemaforo = 2;
            }
        }
        break;

    case 2:
        if (ora - inizio >= 5000)
        {
            digitalWrite(ledVerde2, LOW);
            digitalWrite(ledGiallo2, HIGH);
            inizio = ora;
            statoSemaforo = 3;
        }
        break;

    case 3:
        if (ora - inizio >= 2000)
        {
            digitalWrite(ledGiallo2, LOW);
            digitalWrite(ledRosso2, HIGH);

            if (richiesta)
            {
                digitalWrite(ledRosso, HIGH);
                digitalWrite(ledRosso3, LOW);
                digitalWrite(ledVerde3, HIGH);

                inizio = ora;
                statoSemaforo = 4;
            }
            else
            {
                digitalWrite(ledRosso, LOW);
                digitalWrite(ledVerde, HIGH);

                inizio = ora;
                statoSemaforo = 0;
            }
        }
        break;

    case 4:
        if (ora - inizio >= 5000)
        {
            digitalWrite(ledVerde3, LOW);
            digitalWrite(ledRosso3, HIGH);

            digitalWrite(ledRosso, LOW);
            digitalWrite(ledVerde, HIGH);
            digitalWrite(ledRosso2, HIGH);

            richiesta = false;
            inizio = ora;
            statoSemaforo = 0;
        }
        break;
    }
}