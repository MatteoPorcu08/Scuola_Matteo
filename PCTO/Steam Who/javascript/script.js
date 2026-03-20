window.onload = function() {

    /* ===== AVATAR INITIALS (Per la lista personaggi se presente) ===== */
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
    
    // Riferimento all'immagine del genio nel gioco
    const gameGenio = document.getElementById("gameGenio");

    /* ===== DATABASE PERSONAGGI ===== */
    const characters = [
        { nome: "Rita Levi-Montalcini", img: "../img/RitaLeviMontalcini.png", donna: true, italiano: true, informatico: false, fisico: false, antico: false, nobel: true, matematica: false, elettricita: false, astronomia: false, novecento: true, medicina: true, invenzione: false, chimica: false, ingegnere: false, vivo: false },
        { nome: "Galileo Galilei", img: "../img/GalileoGalilei.jpg", donna: false, italiano: true, informatico: false, fisico: true, antico: true, nobel: false, matematica: true, elettricita: false, astronomia: true, novecento: false, medicina: false, invenzione: true, chimica: false, ingegnere: false, vivo: false },
        { nome: "Leonardo da Vinci", img: "../img/LeonardoDaVinci.jpg", donna: false, italiano: true, informatico: false, fisico: false, antico: true, nobel: false, matematica: true, elettricita: false, astronomia: false, novecento: false, medicina: true, invenzione: true, chimica: false, ingegnere: true, vivo: false },
        { nome: "Enrico Fermi", img: "../img/EnricoFermi.jpg", donna: false, italiano: true, informatico: false, fisico: true, antico: false, nobel: true, matematica: true, elettricita: false, astronomia: false, novecento: true, medicina: false, invenzione: true, chimica: false, ingegnere: false, vivo: false },
        { nome: "Margherita Hack", img: "../img/MargheritaHack.jpg", donna: true, italiano: true, informatico: false, fisico: true, antico: false, nobel: false, matematica: false, elettricita: false, astronomia: true, novecento: true, medicina: false, invenzione: false, chimica: false, ingegnere: false, vivo: false },
        { nome: "Fabiola Gianotti", img: "../img/FabiolaGianotti.jpg", donna: true, italiano: true, informatico: false, fisico: true, antico: false, nobel: false, matematica: false, elettricita: false, astronomia: false, novecento: true, medicina: false, invenzione: false, chimica: false, ingegnere: false, vivo: true },
        { nome: "Guglielmo Marconi", img: "../img/GuglielmoMarconi.jpg", donna: false, italiano: true, informatico: false, fisico: true, antico: false, nobel: true, matematica: false, elettricita: true, astronomia: false, novecento: true, medicina: false, invenzione: true, chimica: false, ingegnere: true, vivo: false },
        { nome: "Evangelista Torricelli", img: "../img/EvangelistaTorricelli.jpg", donna: false, italiano: true, informatico: false, fisico: true, antico: true, nobel: false, matematica: true, elettricita: false, astronomia: false, novecento: false, medicina: false, invenzione: true, chimica: false, ingegnere: false, vivo: false },
        { nome: "Luigi Galvani", img: "../img/LuigiGalvani.jpg", donna: false, italiano: true, informatico: false, fisico: true, antico: true, nobel: false, matematica: false, elettricita: true, astronomia: false, novecento: false, medicina: true, invenzione: false, chimica: false, ingegnere: false, vivo: false },
        { nome: "Giuseppe Lagrange", img: "../img/GiuseppeLagrange.jpg", donna: false, italiano: true, informatico: false, fisico: false, antico: true, nobel: false, matematica: true, elettricita: false, astronomia: false, novecento: false, medicina: false, invenzione: false, chimica: false, ingegnere: false, vivo: false },
        { nome: "Sofia Kovalevskaya", img: "../img/SofiaKovalevskaya.jpg", donna: true, italiano: false, informatico: false, fisico: false, antico: true, nobel: false, matematica: true, elettricita: false, astronomia: false, novecento: false, medicina: false, invenzione: false, chimica: false, ingegnere: false, vivo: false },
        { nome: "Ada Lovelace", img: "../img/AdaLovelace.jpg", donna: true, italiano: false, informatico: true, fisico: false, antico: true, nobel: false, matematica: true, elettricita: false, astronomia: false, novecento: false, medicina: false, invenzione: false, chimica: false, ingegnere: false, vivo: false },
        { nome: "Alan Turing", img: "../img/AlanTuring.jpg", donna: false, italiano: false, informatico: true, fisico: false, antico: false, nobel: false, matematica: true, elettricita: false, astronomia: false, novecento: true, medicina: false, invenzione: true, chimica: false, ingegnere: false, vivo: false },
        { nome: "Marie Curie", img: "../img/MarieCurie.jpg", donna: true, italiano: false, informatico: false, fisico: true, antico: false, nobel: true, matematica: false, elettricita: true, astronomia: false, novecento: true, medicina: false, invenzione: false, chimica: true, ingegnere: false, vivo: false },
        { nome: "Albert Einstein", img: "../img/AlbertEinstein.jpg", donna: false, italiano: false, informatico: false, fisico: true, antico: false, nobel: true, matematica: true, elettricita: false, astronomia: false, novecento: true, medicina: false, invenzione: false, chimica: false, ingegnere: false, vivo: false },
        { nome: "Isaac Newton", img: "../img/IsaacNewton.jpg", donna: false, italiano: false, informatico: false, fisico: true, antico: true, nobel: false, matematica: true, elettricita: false, astronomia: true, novecento: false, medicina: false, invenzione: true, chimica: false, ingegnere: false, vivo: false },
        { nome: "Lucia Votano", img: "../img/LuciaVotano.jpg", donna: true, italiano: true, informatico: false, fisico: true, antico: false, nobel: false, matematica: false, elettricita: false, astronomia: false, novecento: true, medicina: false, invenzione: false, chimica: false, ingegnere: false, vivo: true },
        { nome: "Anna Grassellino", img: "../img/AnnaGrassellino.jpg", donna: true, italiano: true, informatico: false, fisico: true, antico: false, nobel: false, matematica: false, elettricita: false, astronomia: false, novecento: true, medicina: false, invenzione: false, chimica: false, ingegnere: true, vivo: true },
        { nome: "Alfio Quarteroni", img: "../img/AlfioQuarteroni.jpg", donna: false, italiano: true, informatico: false, fisico: false, antico: false, nobel: false, matematica: true, elettricita: false, astronomia: false, novecento: true, medicina: false, invenzione: false, chimica: false, ingegnere: false, vivo: true },
        { nome: "Giuseppina Carniel", img: "../img/GiuseppinaCarniel.jpg", donna: true, italiano: true, informatico: false, fisico: false, antico: false, nobel: false, matematica: false, elettricita: false, astronomia: false, novecento: true, medicina: false, invenzione: false, chimica: false, ingegnere: true, vivo: true }
    ];

    /* ===== DOMANDE ===== */
    const questions = [
        { testo: "È una donna?", key: "donna" },
        { testo: "È italiano/a?", key: "italiano" },
        { testo: "È legato/a all'informatica?", key: "informatico" },
        { testo: "È famoso/a per la fisica?", key: "fisico" },
        { testo: "È nato/a prima del 1800?", key: "antico" },
        { testo: "Ha vinto il Nobel?", key: "nobel" },
        { testo: "È un matematico/a?", key: "matematica" },
        { testo: "Lavora o ha lavorato con l'elettricità?", key: "elettricita" },
        { testo: "È legato/a all’astronomia o allo spazio?", key: "astronomia" },
        { testo: "Ha lavorato principalmente nel Novecento?", key: "novecento" },
        { testo: "Si è occupato/a di medicina o biologia?", key: "medicina" },
        { testo: "È famoso/a per un'invenzione specifica?", key: "invenzione" },
        { testo: "Ha fatto scoperte legate alla chimica?", key: "chimica" },
        { testo: "È un ingegnere?", key: "ingegnere" },
        { testo: "Questa persona è ancora in vita?", key: "vivo" }
    ];

    let usedQuestions = [];
    let currentQuestion = null;
    let guessedCharacters = []; 
    let questionsSinceLastGuess = 0;

    /* ===== LOGICA DI START ===== */
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
        characters.forEach(p => p.score = 0);
        usedQuestions = [];
        guessedCharacters = [];
        questionsSinceLastGuess = 0;
        result.innerHTML = "";
        yesBtn.style.display = "inline-block";
        noBtn.style.display = "inline-block";
        restartBtn.style.display = "none";
        confidenceBar.style.width = "5%";
        gameGenio.src = "../img/genio.png"; // Reset immagine genio
        nextQuestion();
    }

    function nextQuestion() {
        if (usedQuestions.length === questions.length) {
            return showGuess();
        }

        let best = null;
        let bestScore = Infinity;

        questions.forEach(q => {
            if (usedQuestions.includes(q)) return;
            let yesWeight = 0, noWeight = 0;
            characters.forEach(p => {
                if (guessedCharacters.includes(p.nome)) return;
                if (p[q.key]) yesWeight += (p.score + 10);
                else noWeight += (p.score + 10);
            });
            let diff = Math.abs(yesWeight - noWeight);
            if (diff < bestScore) {
                bestScore = diff;
                best = q;
            }
        });

        if (!best) return showGuess();

        currentQuestion = best;
        usedQuestions.push(best);
        question.innerText = best.testo;
        // Quando fa una nuova domanda, torna il genio normale
        gameGenio.src = "../img/genio.png";
    }

    function move(answer) {
        thinking.style.opacity = 1;
        // Mentre pensa rimane normale o neutro
        gameGenio.src = "../img/genio.png";

        setTimeout(() => {
            thinking.style.opacity = 0;
            characters.forEach(p => {
                if (p[currentQuestion.key] === answer) p.score += 5;
                else p.score -= 2;
            });

            updateConfidence();
            questionsSinceLastGuess++;

            let sorted = [...characters].filter(p => !guessedCharacters.includes(p.nome)).sort((a, b) => b.score - a.score);
            
            if (sorted.length > 0 && (sorted[0].score - (sorted[1]?.score || 0) > 20) && questionsSinceLastGuess >= 3) {
                showGuess();
            } else {
                nextQuestion();
            }
        }, 500);
    }

    yesBtn.onclick = () => move(true);
    noBtn.onclick = () => move(false);

    function updateConfidence() {
        let sorted = [...characters].filter(p => !guessedCharacters.includes(p.nome)).sort((a, b) => b.score - a.score);
        if (sorted.length < 2) return;
        let confidence = sorted[0].score - sorted[1].score;
        let percent = Math.min(95, Math.max(5, confidence * 4));
        confidenceBar.style.width = percent + "%";
    }

    /* ===== IL GENIO INDOVINA ===== */
    function showGuess() {
        let available = characters.filter(p => !guessedCharacters.includes(p.nome)).sort((a, b) => b.score - a.score);

        if (available.length === 0) {
            gameGenio.src = "../img/genioTriste.png";
            question.innerText = "";
            result.innerHTML = "❌ Mi arrendo! Mi hai battuto.";
            yesBtn.style.display = "none";
            noBtn.style.display = "none";
            restartBtn.style.display = "inline-block";
            return;
        }

        let best = available[0];
        
        // GENIO CONFUSO: Sta per fare il tentativo
        gameGenio.src = "../img/genioConfuso.png";

        yesBtn.style.display = "none";
        noBtn.style.display = "none";
        question.innerText = "Vediamo se ho indovinato...";

        result.innerHTML = `
            <div class="guess-box">
                <img src="${best.img}" style="width:160px;height:160px;border-radius:15px;margin-bottom:10px; border:3px solid #00f2ff;">
                <div style="font-size:22px; margin-bottom:15px;">Stai pensando a <strong>${best.nome}</strong>?</div>
                <div class="buttons">
                    <button id="correctBtn" style="background:#22c55e; color:white; padding:10px 20px; border-radius:8px; cursor:pointer; border:none;">SÌ, ESATTO!</button>
                    <button id="wrongBtn" style="background:#ef4444; color:white; padding:10px 20px; border-radius:8px; cursor:pointer; border:none;">NO, SBAGLIATO</button>
                </div>
            </div>
        `;

        // SE INDOVINA: GENIO FELICE
        document.getElementById("correctBtn").onclick = () => {
            gameGenio.src = "../img/genioFelice.png";
            result.innerHTML = `<h2>🎯 VITTORIA! <br> Sapevo che era ${best.nome}!</h2>`;
            confidenceBar.style.width = "100%";
            restartBtn.style.display = "inline-block";
        };

        // SE SBAGLIA: GENIO TRISTE
        document.getElementById("wrongBtn").onclick = () => {
            gameGenio.src = "../img/genioTriste.png";
            guessedCharacters.push(best.nome);
            result.innerHTML = "";
            yesBtn.style.display = "inline-block";
            noBtn.style.display = "inline-block";
            questionsSinceLastGuess = 0; 
            
            if (usedQuestions.length < questions.length) {
                question.innerText = "Mmm... fammi pensare meglio...";
                // Pausa per mostrare la faccia triste prima della prossima domanda
                setTimeout(nextQuestion, 1500);
            } else {
                gameGenio.src = "../img/genioTriste.png";
                question.innerText = "";
                result.innerHTML = "❌ Ho finito le domande... Mi hai battuto!";
                restartBtn.style.display = "inline-block";
            }
        };
    }

    restartBtn.onclick = () => location.reload();
};