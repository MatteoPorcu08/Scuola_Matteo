const quiz = [

    {

        question:
            "Ricevi una email della banca che richiede password e OTP. Cosa fai?",

        answers: [

            "Invio subito i dati",

            "Ignoro la mail e contatto la banca",

            "Clicco il link"

        ],

        correct: 1

    },

    {

        question:
            "Ricevi un SMS: 'Pacco bloccato, clicca qui'. Che tipo di truffa è?",

        answers: [

            "Phishing",

            "Smishing",

            "Vishing"

        ],

        correct: 1

    },

    {

        question:
            "Un falso operatore ti chiede un codice OTP al telefono. Cosa fai?",

        answers: [

            "Comunico il codice",

            "Riaggancio",

            "Invio un messaggio"

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

let answered = false;

const question =
    document.getElementById("question");

const answers =
    document.getElementById("answers");

const result =
    document.getElementById("result");

const nextBtn =
    document.getElementById("nextBtn");

const finalScore =
    document.getElementById("finalScore");

const questionNumber =
    document.getElementById("questionNumber");

function showQuestion() {

    answered = false;

    result.innerHTML = "";

    answers.innerHTML = "";

    const current = quiz[currentQuestion];

    questionNumber.innerHTML =
        `Domanda ${currentQuestion + 1} di ${quiz.length}`;

    question.innerHTML =
        current.question;

    current.answers.forEach((answer, index) => {

        const button =
            document.createElement("button");

        button.innerHTML = answer;

        button.classList.add("answer-btn");

        button.addEventListener("click", () => {

            selectAnswer(index);

        });

        answers.appendChild(button);

    });

}

function selectAnswer(index) {

    if (answered) {

        return;

    }

    answered = true;

    const current = quiz[currentQuestion];

    const buttons =
        document.querySelectorAll(".answer-btn");

    buttons.forEach((button, i) => {

        button.disabled = true;

        if (i === current.correct) {

            button.classList.add("correct");

        }

    });

    if (index === current.correct) {

        result.innerHTML =
            "✅ Risposta corretta!";

        score++;

    } else {

        buttons[index].classList.add("wrong");

        result.innerHTML =
            "❌ Risposta sbagliata!";

    }

}

nextBtn.addEventListener("click", () => {

    if (!answered) {

        result.innerHTML =
            "⚠️ Seleziona una risposta";

        return;

    }

    currentQuestion++;

    if (currentQuestion < quiz.length) {

        showQuestion();

    } else {

        showFinalResult();

    }

});

function showFinalResult() {

    document.querySelector(".quiz-box")
        .style.display = "none";

    finalScore.innerHTML =

        `
        <h2>Quiz completato!</h2>

        <p class="score">
            Hai ottenuto ${score}
            punti su ${quiz.length}
        </p>

        <button class="btn"
                onclick="location.reload()">

            Riprova

        </button>
        `;

}

showQuestion();