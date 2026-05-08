const quiz = [

    {
    question: "Una banca chiede OTP via email. È sicuro?",
    answers: ["Sì", "No"],
    correct: 1
    },
    
    {
    question: "Uno SMS con link urgente può essere una truffa?",
    answers: ["Sì", "No"],
    correct: 0
    },
    
    {
    question: "Devi condividere password al telefono?",
    answers: ["Mai", "Sempre"],
    correct: 0
    }
    
    ];
    
    let currentQuestion = 0;
    
    const question = document.getElementById("question");
    const answers = document.getElementById("answers");
    const result = document.getElementById("result");
    const nextBtn = document.getElementById("nextBtn");
    
    function showQuestion(){
    
    const q = quiz[currentQuestion];
    
    question.innerHTML = `<h3>${q.question}</h3>`;
    
    answers.innerHTML = "";
    
    q.answers.forEach((answer, index)=>{
    
    const btn = document.createElement("button");
    
    btn.innerText = answer;
    
    btn.classList.add("answer-btn");
    
    btn.onclick = ()=>checkAnswer(index);
    
    answers.appendChild(btn);
    
    });
    
    }
    
    function checkAnswer(index){
    
    if(index === quiz[currentQuestion].correct){
    
    result.innerHTML = "✅ Risposta corretta";
    
    }else{
    
    result.innerHTML = "❌ Risposta sbagliata";
    
    }
    
    }
    
    nextBtn.addEventListener("click", ()=>{
    
    currentQuestion++;
    
    if(currentQuestion >= quiz.length){
    currentQuestion = 0;
    }
    
    showQuestion();
    
    });
    
    showQuestion();