// javascript/quiz.js

const quiz = [

    {

        question:
            "Ricevi una email della banca che chiede password e OTP. Cosa fai?",

        answers: [

            "Invio subito i dati",
            "Ignoro la mail e contatto la banca",
            "Clicco il link per controllare"

        ],

        correct: 1

    },

    {

        question:
            "Uno SMS dice: 'Pacco bloccato, clicca qui'. Qual è il rischio?",

        answers: [

            "Smishing",
            "Aggiornamento normale",
            "Pubblicità"

        ],

        correct: 0

    },

    {

        question:
            "Un operatore telefonico ti chiede il codice OTP. Cosa fai?",

        answers: [

            "Comunico il codice",
            "Riaggancio subito",
            "Invio il codice via SMS"

        ],

        correct: 1

    },

    {

        question:
            "Quale password è più sicura?",

        answers: [

            "123456",
            "password",
            "T7#kL91@xP"

        ],

        correct: 2

    }

];

let currentQuestion = 0;

let score = 0;

const question = document.getElementById("question");

const answers = document.getElementById("answers");

const result = document.getElementById("result");

const nextBtn = document.getElementById("nextBtn");

function showQuestion() {

    resetState();

    const current = quiz[currentQuestion];

    question.innerHTML =
        `<h3>${currentQuestion + 1}. ${current.question}</h3>`;

    current.answers.forEach((answer, index) => {

        const button = document.createElement("button");

        button.innerText = answer;

        button.classList.add("answer-btn");

        button.addEventListener("click", () => {

            selectAnswer(index);

        });

        answers.appendChild(button);

    });

}

function resetState() {

    result.innerHTML = "";

    answers.innerHTML = "";

}

function selectAnswer(index) {

    const current = quiz[currentQuestion];

    const buttons = document.querySelectorAll(".answer-btn");

    buttons.forEach(button => {

        button.disabled = true;

    });

    if (index === current.correct) {

        result.innerHTML =
            "✅ Risposta corretta";

        result.style.color = "#4ade80";

        score++;

    } else {

        result.innerHTML =
            "❌ Risposta sbagliata";

        result.style.color = "#f87171";

    }

}

nextBtn.addEventListener("click", () => {

    currentQuestion++;

    if (currentQuestion < quiz.length) {

        showQuestion();

    } else {

        showFinalScore();

    }

});

function showFinalScore() {

    question.innerHTML =
        `<h2>Quiz completato!</h2>`;

    answers.innerHTML = "";

    result.innerHTML =
        `Hai ottenuto ${score} punti su ${quiz.length}`;

    nextBtn.innerHTML =
        "Ricomincia";

    nextBtn.addEventListener("click", () => {

        location.reload();

    });

}

showQuestion();