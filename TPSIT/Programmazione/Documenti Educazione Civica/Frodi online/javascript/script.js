const quiz = [
    {
      question: "Ricevi una email della banca che chiede password e OTP entro 10 minuti. Cosa fai?",
      answers: [
        "Rispondo subito con i dati richiesti",
        "Ignoro la richiesta, verifico il sito ufficiale e contatto la banca",
        "Inoltro la mail ad amici per capire se è vera"
      ],
      correct: 1,
      feedback: "Corretto: nessuna banca seria chiede OTP o password via email."
    },
    {
      question: "Ti arriva un SMS: 'Pacco bloccato, paga 1,99€ qui'. Qual è il segnale di smishing?",
      answers: [
        "Messaggio urgente con link sospetto",
        "Presenza del tuo nome nel testo",
        "Importo basso da pagare"
      ],
      correct: 0,
      feedback: "Esatto: urgenza + link sono caratteristiche tipiche delle truffe SMS."
    },
    {
      question: "Un operatore telefonico ti chiede un codice OTP per 'bloccare una frode'. Cosa fai?",
      answers: [
        "Comunico l'OTP per sicurezza",
        "Riaggancio e richiamo io il numero ufficiale",
        "Chiedo di richiamarmi più tardi"
      ],
      correct: 1,
      feedback: "Giusto: l'OTP è personale e non va mai comunicato al telefono."
    }
  ];
  
  let index = 0;
  const questionBox = document.getElementById("questionBox");
  const answersBox = document.getElementById("answers");
  const feedback = document.getElementById("feedback");
  const nextBtn = document.getElementById("nextBtn");
  
  function renderQuestion() {
    const current = quiz[index];
    questionBox.textContent = `${index + 1}. ${current.question}`;
    answersBox.innerHTML = "";
    feedback.textContent = "";
  
    current.answers.forEach((answer, i) => {
      const btn = document.createElement("button");
      btn.textContent = answer;
      btn.addEventListener("click", () => checkAnswer(i));
      answersBox.appendChild(btn);
    });
  }
  
  function checkAnswer(selected) {
    const current = quiz[index];
    if (selected === current.correct) {
      feedback.textContent = "✅ " + current.feedback;
      feedback.style.color = "#86efac";
    } else {
      feedback.textContent = "❌ Risposta non corretta. Riprova e fai attenzione ai segnali di truffa.";
      feedback.style.color = "#fca5a5";
    }
  }
  
  nextBtn.addEventListener("click", () => {
    index = (index + 1) % quiz.length;
    renderQuestion();
  });
  
  renderQuestion();