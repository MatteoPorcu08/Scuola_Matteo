window.onload = function() {

    /* ===== AVATAR INITIALS ===== */
    document.querySelectorAll(".character").forEach(el => {
        let name = el.innerText.trim();
        let parts = name.split(" ");
        let initials = parts[0][0];
        if (parts.length > 1) initials += parts[1][0];
        el.setAttribute("data-initials", initials.toUpperCase());
    });

    /* ===== DOM ELEMENTS ===== */
    const startBtn = document.getElementById("startBtn");
    const startScreen = document.getElementById("startScreen");
    const gameScreen = document.getElementById("gameScreen");
    const question = document.getElementById("question");
    const result = document.getElementById("result");
    const yesBtn = document.getElementById("yesBtn");
    const noBtn = document.getElementById("noBtn");
    const restartBtn = document.getElementById("restartBtn");
    const thinking = document.getElementById("thinking");
    const confidenceBar = document.getElementById("confidenceBar");
    const gameGenio = document.getElementById("gameGenio");

    /* ===== DATABASE PERSONAGGI CON DOMANDE BONUS ORIGINALI ===== */
    const characters = [
        { nome: "Rita Levi-Montalcini", img: "../img/RitaLeviMontalcini.png", donna:true, italiano:true, informatico:false, fisico:false, antico:false, nobel:true, matematica:false, elettricita:false, astronomia:false, novecento:true, medicina:true, invenzione:false, chimica:false, ingegnere:false, vivo:false, occhiali:true, barba_baffi:false, divulgatore:true, stati_uniti:true, francia:false, gran_bretagna:false, computer_moderni:false, insegnante:true, ostacolato:true, politica:true, radioattivita:false, ottica:false, cern:false, arte:false, codici_segreti:false, teoremi:false, giovane_morte:false, russia:false, onde_radio:false, fluidi:false, germania:false, toscana:false, biologia_cellulare:true, macchine_calcolo:false, neutrini:false,
          domanda_bonus: "Hai scoperto il fattore di crescita nervoso (NGF)?" },
        { nome: "Galileo Galilei", img: "../img/GalileoGalilei.jpg", donna:false, italiano:true, informatico:false, fisico:true, antico:true, nobel:false, matematica:true, elettricita:false, astronomia:true, novecento:false, medicina:false, invenzione:true, chimica:false, ingegnere:false, vivo:false, occhiali:false, barba_baffi:true, divulgatore:true, stati_uniti:false, francia:false, gran_bretagna:false, computer_moderni:false, insegnante:true, ostacolato:true, politica:false, radioattivita:false, ottica:true, cern:false, arte:false, codici_segreti:false, teoremi:false, giovane_morte:false, russia:false, onde_radio:false, fluidi:false, germania:false, toscana:true, biologia_cellulare:false, macchine_calcolo:false, neutrini:false,
          domanda_bonus: "Sei famoso per aver puntato il cannocchiale verso le stelle e per aver detto 'Eppur si muove'?" },
        { nome: "Leonardo da Vinci", img: "../img/LeonardoDaVinci.jpg", donna:false, italiano:true, informatico:false, fisico:false, antico:true, nobel:false, matematica:true, elettricita:false, astronomia:false, novecento:false, medicina:true, invenzione:true, chimica:false, ingegnere:true, vivo:false, occhiali:false, barba_baffi:true, divulgatore:false, stati_uniti:false, francia:true, gran_bretagna:false, computer_moderni:false, insegnante:false, ostacolato:false, politica:false, radioattivita:false, ottica:false, cern:false, arte:true, codici_segreti:false, teoremi:false, giovane_morte:false, russia:false, onde_radio:false, fluidi:true, germania:false, toscana:true, biologia_cellulare:false, macchine_calcolo:false, neutrini:false,
          domanda_bonus: "Hai dipinto la Gioconda e riempito codici di invenzioni incredibili?" },
        { nome: "Enrico Fermi", img: "../img/EnricoFermi.jpg", donna:false, italiano:true, informatico:false, fisico:true, antico:false, nobel:true, matematica:true, elettricita:false, astronomia:false, novecento:true, medicina:false, invenzione:true, chimica:false, ingegnere:false, vivo:false, occhiali:false, barba_baffi:false, divulgatore:false, stati_uniti:true, francia:false, gran_bretagna:false, computer_moderni:false, insegnante:true, ostacolato:true, politica:false, radioattivita:true, ottica:false, cern:false, arte:false, codici_segreti:false, teoremi:true, giovane_morte:false, russia:false, onde_radio:false, fluidi:false, germania:false, toscana:false, biologia_cellulare:false, macchine_calcolo:false, neutrini:false,
          domanda_bonus: "Hai creato la prima reazione nucleare a catena controllata (la pila atomica) a Chicago?" },
        { nome: "Margherita Hack", img: "../img/MargheritaHack.jpg", donna:true, italiano:true, informatico:false, fisico:true, antico:false, nobel:false, matematica:false, elettricita:false, astronomia:true, novecento:true, medicina:false, invenzione:false, chimica:false, ingegnere:false, vivo:false, occhiali:true, barba_baffi:false, divulgatore:true, stati_uniti:false, francia:false, gran_bretagna:false, computer_moderni:false, insegnante:true, ostacolato:false, politica:false, radioattivita:false, ottica:false, cern:false, arte:false, codici_segreti:false, teoremi:false, giovane_morte:false, russia:false, onde_radio:false, fluidi:false, germania:false, toscana:true, biologia_cellulare:false, macchine_calcolo:false, neutrini:false,
          domanda_bonus: "Sei conosciuta come la 'signora delle stelle' e hai diretto l'Osservatorio Astronomico di Trieste?" },
        { nome: "Fabiola Gianotti", img: "../img/FabiolaGianotti.jpg", donna:true, italiano:true, informatico:false, fisico:true, antico:false, nobel:false, matematica:false, elettricita:false, astronomia:false, novecento:true, medicina:false, invenzione:false, chimica:false, ingegnere:false, vivo:true, occhiali:false, barba_baffi:false, divulgatore:true, stati_uniti:false, francia:false, gran_bretagna:false, computer_moderni:true, insegnante:false, ostacolato:false, politica:false, radioattivita:false, ottica:false, cern:true, arte:false, codici_segreti:false, teoremi:false, giovane_morte:false, russia:false, onde_radio:false, fluidi:false, germania:false, toscana:false, biologia_cellulare:false, macchine_calcolo:false, neutrini:false,
          domanda_bonus: "Hai annunciato al mondo la scoperta del Bosone di Higgs al CERN?" },
        { nome: "Guglielmo Marconi", img: "../img/GuglielmoMarconi.jpg", donna:false, italiano:true, informatico:false, fisico:true, antico:false, nobel:true, matematica:false, elettricita:true, astronomia:false, novecento:true, medicina:false, invenzione:true, chimica:false, ingegnere:true, vivo:false, occhiali:false, barba_baffi:false, divulgatore:false, stati_uniti:false, francia:false, gran_bretagna:true, computer_moderni:false, insegnante:false, ostacolato:false, politica:true, radioattivita:false, ottica:false, cern:false, arte:false, codici_segreti:false, teoremi:false, giovane_morte:false, russia:false, onde_radio:true, fluidi:false, germania:false, toscana:false, biologia_cellulare:false, macchine_calcolo:false, neutrini:false,
          domanda_bonus: "Sei considerato l'inventore del telegrafo senza fili e della radio?" },
        { nome: "Evangelista Torricelli", img: "../img/EvangelistaTorricelli.jpg", donna:false, italiano:true, informatico:false, fisico:true, antico:true, nobel:false, matematica:true, elettricita:false, astronomia:false, novecento:false, medicina:false, invenzione:true, chimica:false, ingegnere:false, vivo:false, occhiali:false, barba_baffi:true, divulgatore:false, stati_uniti:false, francia:false, gran_bretagna:false, computer_moderni:false, insegnante:true, ostacolato:false, politica:false, radioattivita:false, ottica:false, cern:false, arte:false, codici_segreti:false, teoremi:true, giovane_morte:true, russia:false, onde_radio:false, fluidi:true, germania:false, toscana:false, biologia_cellulare:false, macchine_calcolo:false, neutrini:false,
          domanda_bonus: "Hai inventato il barometro a mercurio per misurare la pressione atmosferica?" },
        { nome: "Luigi Galvani", img: "../img/LuigiGalvani.jpg", donna:false, italiano:true, informatico:false, fisico:true, antico:true, nobel:false, matematica:false, elettricita:true, astronomia:false, novecento:false, medicina:true, invenzione:false, chimica:false, ingegnere:false, vivo:false, occhiali:false, barba_baffi:false, divulgatore:false, stati_uniti:false, francia:false, gran_bretagna:false, computer_moderni:false, insegnante:true, ostacolato:false, politica:false, radioattivita:false, ottica:false, cern:false, arte:false, codici_segreti:false, teoremi:false, giovane_morte:false, russia:false, onde_radio:false, fluidi:false, germania:false, toscana:false, biologia_cellulare:true, macchine_calcolo:false, neutrini:false,
          domanda_bonus: "Hai fatto famosi esperimenti con le rane per scoprire 'l'elettricità animale'?" },
        { nome: "Giuseppe Lagrange", img: "../img/GiuseppeLagrange.jpg", donna:false, italiano:true, informatico:false, fisico:false, antico:true, nobel:false, matematica:true, elettricita:false, astronomia:false, novecento:false, medicina:false, invenzione:false, chimica:false, ingegnere:false, vivo:false, occhiali:false, barba_baffi:false, divulgatore:false, stati_uniti:false, francia:true, gran_bretagna:false, computer_moderni:false, insegnante:true, ostacolato:false, politica:false, radioattivita:false, ottica:false, cern:false, arte:false, codici_segreti:false, teoremi:true, giovane_morte:false, russia:false, onde_radio:false, fluidi:false, germania:false, toscana:false, biologia_cellulare:false, macchine_calcolo:false, neutrini:false,
          domanda_bonus: "Sei uno dei più grandi matematici del '700 e hai formulato la meccanica analitica?" },
        { nome: "Sofia Kovalevskaya", img: "../img/SofiaKovalevskaya.jpg", donna:true, italiano:false, informatico:false, fisico:false, antico:true, nobel:false, matematica:true, elettricita:false, astronomia:false, novecento:false, medicina:false, invenzione:false, chimica:false, ingegnere:false, vivo:false, occhiali:false, barba_baffi:false, divulgatore:false, stati_uniti:false, francia:false, gran_bretagna:false, computer_moderni:false, insegnante:true, ostacolato:true, politica:false, radioattivita:false, ottica:false, cern:false, arte:false, codici_segreti:false, teoremi:true, giovane_morte:true, russia:true, onde_radio:false, fluidi:false, germania:true, toscana:false, biologia_cellulare:false, macchine_calcolo:false, neutrini:false,
          domanda_bonus: "Sei stata la prima donna in Nord Europa a ottenere una cattedra universitaria in matematica?" },
        { nome: "Ada Lovelace", img: "../img/AdaLovelace.jpg", donna:true, italiano:false, informatico:true, fisico:false, antico:true, nobel:false, matematica:true, elettricita:false, astronomia:false, novecento:false, medicina:false, invenzione:false, chimica:false, ingegnere:false, vivo:false, occhiali:false, barba_baffi:false, divulgatore:false, stati_uniti:false, francia:false, gran_bretagna:true, computer_moderni:false, insegnante:false, ostacolato:true, politica:false, radioattivita:false, ottica:false, cern:false, arte:false, codici_segreti:false, teoremi:false, giovane_morte:true, russia:false, onde_radio:false, fluidi:false, germania:false, toscana:false, biologia_cellulare:false, macchine_calcolo:true, neutrini:false,
          domanda_bonus: "Sei considerata la primissima programmatrice di computer della storia grazie al lavoro con Babbage?" },
        { nome: "Alan Turing", img: "../img/AlanTuring.jpg", donna:false, italiano:false, informatico:true, fisico:false, antico:false, nobel:false, matematica:true, elettricita:false, astronomia:false, novecento:true, medicina:false, invenzione:true, chimica:false, ingegnere:false, vivo:false, occhiali:false, barba_baffi:false, divulgatore:false, stati_uniti:true, francia:false, gran_bretagna:true, computer_moderni:true, insegnante:true, ostacolato:true, politica:false, radioattivita:false, ottica:false, cern:false, arte:false, codici_segreti:true, teoremi:true, giovane_morte:true, russia:false, onde_radio:false, fluidi:false, germania:false, toscana:false, biologia_cellulare:false, macchine_calcolo:true, neutrini:false,
          domanda_bonus: "Hai decifrato i codici della macchina Enigma durante la Seconda Guerra Mondiale?" },
        { nome: "Marie Curie", img: "../img/MarieCurie.jpg", donna:true, italiano:false, informatico:false, fisico:true, antico:false, nobel:true, matematica:false, elettricita:true, astronomia:false, novecento:true, medicina:false, invenzione:false, chimica:true, ingegnere:false, vivo:false, occhiali:false, barba_baffi:false, divulgatore:false, stati_uniti:false, francia:true, gran_bretagna:false, computer_moderni:false, insegnante:true, ostacolato:true, politica:false, radioattivita:true, ottica:false, cern:false, arte:false, codici_segreti:false, teoremi:false, giovane_morte:false, russia:false, onde_radio:false, fluidi:false, germania:false, toscana:false, biologia_cellulare:false, macchine_calcolo:false, neutrini:false,
          domanda_bonus: "Sei la scienziata che ha scoperto il Radio e il Polonio, vincendo due premi Nobel?" },
        { nome: "Albert Einstein", img: "../img/AlbertEinstein.jpg", donna:false, italiano:false, informatico:false, fisico:true, antico:false, nobel:true, matematica:true, elettricita:false, astronomia:false, novecento:true, medicina:false, invenzione:false, chimica:false, ingegnere:false, vivo:false, occhiali:false, barba_baffi:true, divulgatore:true, stati_uniti:true, francia:false, gran_bretagna:false, computer_moderni:false, insegnante:true, ostacolato:true, politica:false, radioattivita:true, ottica:true, cern:false, arte:false, codici_segreti:false, teoremi:true, giovane_morte:false, russia:false, onde_radio:false, fluidi:false, germania:true, toscana:false, biologia_cellulare:false, macchine_calcolo:false, neutrini:false,
          domanda_bonus: "Hai formulato la famosa teoria della relatività e l'equazione E=mc²?" },
        { nome: "Isaac Newton", img: "../img/IsaacNewton.jpg", donna:false, italiano:false, informatico:false, fisico:true, antico:true, nobel:false, matematica:true, elettricita:false, astronomia:true, novecento:false, medicina:false, invenzione:true, chimica:false, ingegnere:false, vivo:false, occhiali:false, barba_baffi:false, divulgatore:false, stati_uniti:false, francia:false, gran_bretagna:true, computer_moderni:false, insegnante:true, ostacolato:false, politica:false, radioattivita:false, ottica:true, cern:false, arte:false, codici_segreti:false, teoremi:true, giovane_morte:false, russia:false, onde_radio:false, fluidi:false, germania:false, toscana:false, biologia_cellulare:false, macchine_calcolo:false, neutrini:false,
          domanda_bonus: "Hai formulato la legge di gravitazione universale dopo che (forse) ti è caduta in testa una mela?" },
        { nome: "Lucia Votano", img: "../img/LuciaVotano.jpg", donna:true, italiano:true, informatico:false, fisico:true, antico:false, nobel:false, matematica:false, elettricita:false, astronomia:true, novecento:true, medicina:false, invenzione:false, chimica:false, ingegnere:false, vivo:true, occhiali:false, barba_baffi:false, divulgatore:true, stati_uniti:false, francia:false, gran_bretagna:false, computer_moderni:true, insegnante:false, ostacolato:false, politica:false, radioattivita:true, ottica:false, cern:true, arte:false, codici_segreti:false, teoremi:false, giovane_morte:false, russia:false, onde_radio:false, fluidi:false, germania:false, toscana:false, biologia_cellulare:false, macchine_calcolo:false, neutrini:true,
          domanda_bonus: "Sei stata la prima donna a dirigere i Laboratori Nazionali del Gran Sasso per studiare i neutrini?" },
        { nome: "Anna Grassellino", img: "../img/AnnaGrassellino.jpg", donna:true, italiano:true, informatico:true, fisico:true, antico:false, nobel:false, matematica:false, elettricita:false, astronomia:false, novecento:true, medicina:false, invenzione:false, chimica:false, ingegnere:true, vivo:true, occhiali:false, barba_baffi:false, divulgatore:false, stati_uniti:true, francia:false, gran_bretagna:false, computer_moderni:true, insegnante:false, ostacolato:false, politica:false, radioattivita:false, ottica:false, cern:false, arte:false, codici_segreti:false, teoremi:false, giovane_morte:false, russia:false, onde_radio:false, fluidi:false, germania:false, toscana:false, biologia_cellulare:false, macchine_calcolo:false, neutrini:false,
          domanda_bonus: "Dirigi il centro SQMS al Fermilab negli USA per costruire potentissimi computer quantistici?" },
        { nome: "Alfio Quarteroni", img: "../img/AlfioQuarteroni.jpg", donna:false, italiano:true, informatico:false, fisico:false, antico:false, nobel:false, matematica:true, elettricita:false, astronomia:false, novecento:true, medicina:false, invenzione:false, chimica:false, ingegnere:true, vivo:true, occhiali:true, barba_baffi:false, divulgatore:true, stati_uniti:false, francia:false, gran_bretagna:false, computer_moderni:true, insegnante:true, ostacolato:false, politica:false, radioattivita:false, ottica:false, cern:false, arte:false, codici_segreti:false, teoremi:true, giovane_morte:false, russia:false, onde_radio:false, fluidi:true, germania:false, toscana:false, biologia_cellulare:false, macchine_calcolo:false, neutrini:false,
          domanda_bonus: "Hai usato la matematica per simulare il cuore umano e l'aerodinamica della barca Alinghi?" },
        { nome: "Giuseppina Carniel", img: "../img/GiuseppinaCarniel.jpg", donna:true, italiano:true, informatico:true, fisico:false, antico:false, nobel:false, matematica:true, elettricita:false, astronomia:false, novecento:true, medicina:false, invenzione:false, chimica:false, ingegnere:true, vivo:true, occhiali:false, barba_baffi:false, divulgatore:false, stati_uniti:false, francia:false, gran_bretagna:false, computer_moderni:true, insegnante:true, ostacolato:false, politica:false, radioattivita:false, ottica:false, cern:false, arte:false, codici_segreti:false, teoremi:false, giovane_morte:false, russia:false, onde_radio:false, fluidi:false, germania:false, toscana:false, biologia_cellulare:false, macchine_calcolo:false, neutrini:false,
          domanda_bonus: "Sei un'ingegnera matematica italiana che unisce lo studio delle equazioni al mondo informatico?" }
    ];

    /* ===== LE 40 DOMANDE REVISIONATE ===== */
    const questions = [
        { testo: "È una donna?", key: "donna" },
        { testo: "È italiano/a?", key: "italiano" },
        { testo: "È un informatico o legato ai computer?", key: "informatico" },
        { testo: "È famoso/a principalmente per la fisica?", key: "fisico" },
        { testo: "È nato/a prima del 1800 (personaggio antico)?", key: "antico" },
        { testo: "Ha vinto il premio Nobel?", key: "nobel" },
        { testo: "È un matematico/a?", key: "matematica" },
        { testo: "Ha fatto scoperte sull'elettricità o magnetismo?", key: "elettricita" },
        { testo: "È legato/a all’astronomia o allo spazio?", key: "astronomia" },
        { testo: "Ha vissuto e lavorato nel Novecento (1900-1999)?", key: "novecento" },
        { testo: "Si è occupato/a di medicina, biologia o anatomia?", key: "medicina" },
        { testo: "È famoso/a per aver creato un'invenzione o un oggetto?", key: "invenzione" },
        { testo: "È noto/a per scoperte nella chimica?", key: "chimica" },
        { testo: "È un ingegnere?", key: "ingegnere" },
        { testo: "Questa persona è attualmente in vita?", key: "vivo" },
        { testo: "Porta o portava gli occhiali nelle sue foto famose?", key: "occhiali" },
        { testo: "Aveva barba o baffi vistosi?", key: "barba_baffi" },
        { testo: "È famoso/a per aver spiegato la scienza al pubblico (divulgatore)?", key: "divulgatore" }, 
        { testo: "Ha vissuto o lavorato a lungo negli Stati Uniti?", key: "stati_uniti" },
        { testo: "Ha origini o ha lavorato molto in Francia?", key: "francia" },
        { testo: "È di origini o ha vissuto in Gran Bretagna?", key: "gran_bretagna" },
        { testo: "Usa o ha usato moderni computer/supercomputer nel lavoro?", key: "computer_moderni" },
        { testo: "È stato un professore o insegnante universitario?", key: "insegnante" },
        { testo: "Ha subito processi, discriminazioni o ostacoli per le sue idee?", key: "ostacolato" }, 
        { testo: "Ha avuto incarichi politici o governativi (es. Senatore)?", key: "politica" },
        { testo: "Ha studiato la radioattività o l'energia nucleare?", key: "radioattivita" },
        { testo: "Ha fatto scoperte sulla luce o l'ottica?", key: "ottica" },
        { testo: "Ha lavorato al CERN di Ginevra?", key: "cern" },
        { testo: "È famoso/a anche per opere d'arte o dipinti?", key: "arte" },
        { testo: "Ha decifrato codici segreti durante la guerra?", key: "codici_segreti" },
        { testo: "C'è un teorema, una legge o un'unità di misura col suo nome?", key: "teoremi" },
        { testo: "È morto/a relativamente giovane (prima dei 50 anni)?", key: "giovane_morte" },
        { testo: "Ha origini o forti legami con la Russia?", key: "russia" },
        { testo: "Ha fatto scoperte cruciali per la radio o le telecomunicazioni?", key: "onde_radio" },
        { testo: "Ha studiato il moto dei fluidi, dei gas o la pressione?", key: "fluidi" },
        { testo: "È nato/a o vissuto in Germania?", key: "germania" },
        { testo: "È nato/a in Toscana?", key: "toscana" },
        { testo: "Ha studiato le cellule o il sistema nervoso?", key: "biologia_cellulare" },
        { testo: "Ha progettato o lavorato su antiche macchine da calcolo meccaniche?", key: "macchine_calcolo" },
        { testo: "Ha lavorato nei laboratori del Gran Sasso o ha studiato i neutrini?", key: "neutrini" }
    ];

    let usedQuestions = [];
    let currentQuestion = null;
    let guessedCharacters = [];
    let questionsSinceLastGuess = 0;
    
    const MIN_QUESTIONS_BEFORE_GUESS = 5; 
    const CONFIDENCE_THRESHOLD = 15; 

    function shannonEntropy(yesCount, noCount) {
        let total = yesCount + noCount;
        if (total === 0) return 0;
        let pYes = yesCount / total;
        let pNo = noCount / total;
        if (pYes === 0 || pNo === 0) return 0;
        return -(pYes * Math.log2(pYes) + pNo * Math.log2(pNo));
    }

    startBtn.onclick = () => {
        startScreen.style.opacity = "0";
        startScreen.style.transform = "scale(0.9)";
        setTimeout(() => {
            startScreen.style.display = "none";
            gameScreen.style.display = "block";
            gameScreen.style.opacity = "1";
            gameScreen.style.transform = "scale(1)";
            startGame();
        }, 400);
    };

    function startGame() {
        characters.forEach(p => { p.score = 0; p.bonusAsked = false; });
        usedQuestions = [];
        guessedCharacters = [];
        questionsSinceLastGuess = 0;
        result.innerHTML = "";
        yesBtn.style.display = "inline-block";
        noBtn.style.display = "inline-block";
        restartBtn.style.display = "none";
        confidenceBar.style.width = "0%";
        gameGenio.src = "../img/genio.png"; 
        nextQuestion();
    }

    /* ===== FUNZIONE ARRESA (NUOVA) ===== */
    function surrender() {
        gameGenio.src = "../img/genioTriste.png";
        question.innerText = "Mi arrendo...";
        result.innerHTML = "<h3 style='color:#ef4444;'>Sei riuscito a confondermi!</h3> Non ho abbastanza indizi per capire a chi stai pensando.";
        yesBtn.style.display = "none";
        noBtn.style.display = "none";
        restartBtn.style.display = "inline-block";
        confidenceBar.style.width = "0%";
    }

    function nextQuestion() {
        let available = characters.filter(p => !guessedCharacters.includes(p.nome)).sort((a, b) => b.score - a.score);

        // 1. Non è rimasto nessuno
        if (available.length === 0) {
            return surrender();
        }

        // 2. È rimasto solo un personaggio possibile
        if (available.length === 1) {
            return showGuess(available[0]);
        }

        let scoreDiff = available[0].score - available[1].score;
        let topChar = available[0];

        // 3. LOGICA DELLA DOMANDA BONUS (Killer Question)
        if (scoreDiff >= 8 && Math.random() > 0.5 && !topChar.bonusAsked && usedQuestions.length >= 3) {
            topChar.bonusAsked = true; 
            currentQuestion = { testo: topChar.domanda_bonus, isBonusFor: topChar.nome };
            question.innerText = currentQuestion.testo;
            gameGenio.src = "../img/genio.png"; 
            return; 
        }

        // 4. Soglia di sicurezza massima: azzarda senza altre domande
        if (usedQuestions.length >= MIN_QUESTIONS_BEFORE_GUESS && 
            scoreDiff >= CONFIDENCE_THRESHOLD && 
            questionsSinceLastGuess >= 3) {
            return showGuess(available[0]);
        }

        // 5. Ricerca della domanda migliore
        let best = null;
        let bestEntropy = -1;

        questions.forEach(q => {
            if (usedQuestions.includes(q)) return;
            let yesCount = 0, noCount = 0;
            let topCandidates = available.slice(0, 8); 
            topCandidates.forEach(p => {
                if (p[q.key]) yesCount++;
                else noCount++;
            });
            let entropy = shannonEntropy(yesCount, noCount);
            if (entropy > bestEntropy) {
                bestEntropy = entropy;
                best = q;
            }
        });

        // 6. FINE DELLE DOMANDE UTILI
        // Se non ci sono più domande o se non riescono più a dividere i candidati
        if (!best || bestEntropy === 0) {
            if (scoreDiff >= 4) { 
                // C'è un piccolo distacco: azzardiamo un tentativo!
                return showGuess(available[0]);
            } else {
                // Parità totale o troppa confusione: il genio alza le mani.
                return surrender(); 
            }
        }

        currentQuestion = best;
        usedQuestions.push(best);
        question.innerText = best.testo;
        gameGenio.src = "../img/genio.png";
    }

    function move(answer) {
        thinking.style.opacity = 1;

        setTimeout(() => {
            thinking.style.opacity = 0;
            
            // CONTROLLO SE È LA DOMANDA BONUS
            if (currentQuestion.isBonusFor) {
                if (answer === true) {
                    let winner = characters.find(c => c.nome === currentQuestion.isBonusFor);
                    showGuess(winner);
                } else {
                    guessedCharacters.push(currentQuestion.isBonusFor);
                    updateConfidence();
                    questionsSinceLastGuess = 0;
                    gameGenio.src = "../img/genio.png";
                    nextQuestion();
                }
                return;
            }

            // Assegnazione Punti Normale
            characters.forEach(p => {
                if (guessedCharacters.includes(p.nome)) return;
                
                if (p[currentQuestion.key] === answer) {
                    p.score += 6;
                } else {
                    p.score -= 4;
                }
            });

            updateConfidence();
            questionsSinceLastGuess++;
            nextQuestion();
        }, 500);
    }

    yesBtn.onclick = () => move(true);
    noBtn.onclick = () => move(false);

    function updateConfidence() {
        let sorted = [...characters].filter(p => !guessedCharacters.includes(p.nome)).sort((a, b) => b.score - a.score);
        if (sorted.length < 2) return;
        
        let confidence = sorted[0].score - sorted[1].score;
        let basePercent = (usedQuestions.length / MIN_QUESTIONS_BEFORE_GUESS) * 20;
        let scorePercent = (confidence / CONFIDENCE_THRESHOLD) * 80; 
        
        let percent = Math.min(98, Math.max(2, basePercent + scorePercent));
        confidenceBar.style.width = percent + "%";
    }

    /* ===== IL GENIO TENTA LA RISPOSTA ===== */
    function showGuess(bestGuess = null) {
        let available = characters.filter(p => !guessedCharacters.includes(p.nome)).sort((a, b) => b.score - a.score);
        if (available.length === 0) return surrender(); // Controllo di sicurezza

        let best = bestGuess || available[0];

        gameGenio.src = "../img/genioConfuso.png";
        yesBtn.style.display = "none";
        noBtn.style.display = "none";
        question.innerText = "Non ho dubbi... sono sicuro di saperlo!";

        result.innerHTML = `
            <div class="guess-box">
                <img src="${best.img}" style="width:160px;height:160px;border-radius:15px;margin-bottom:10px; border:3px solid #00f2ff;">
                <div style="font-size:22px; margin-bottom:15px;">Stai pensando a <strong>${best.nome}</strong>?</div>
                <div class="buttons">
                    <button id="correctBtn" style="background:#22c55e; color:white; padding:10px 20px; border-radius:8px; cursor:pointer; border:none; font-size:16px;">SÌ, ESATTO!</button>
                    <button id="wrongBtn" style="background:#ef4444; color:white; padding:10px 20px; border-radius:8px; cursor:pointer; border:none; font-size:16px;">NO, SBAGLIATO</button>
                </div>
            </div>
        `;

        document.getElementById("correctBtn").onclick = () => {
            gameGenio.src = "../img/genioFelice.png";
            result.innerHTML = `<h2 style="color:#22c55e;">HAI VINTO!<br> Sapevo che era ${best.nome}!</h2>`;
            confidenceBar.style.width = "100%";
            question.innerText = "Sono un vero genio! Vuoi giocare ancora?";
            restartBtn.style.display = "inline-block";
        };

        document.getElementById("wrongBtn").onclick = () => {
            guessedCharacters.push(best.nome); 
            questionsSinceLastGuess = 0; 
            
            result.innerHTML = ""; 
            yesBtn.style.display = "inline-block"; 
            noBtn.style.display = "inline-block";
            gameGenio.src = "../img/genio.png";
            
            characters.forEach(p => p.score -= 2); 
            
            updateConfidence();
            nextQuestion(); 
        };
    }

    restartBtn.onclick = () => location.reload();
};