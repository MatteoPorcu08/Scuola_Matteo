window.onload = function(){

    /* ===== AVATAR ===== */
    
    document.querySelectorAll(".character").forEach(el=>{
    
    let name = el.innerText.trim()
    let parts = name.split(" ")
    
    let initials = parts[0][0]
    if(parts.length > 1) initials += parts[1][0]
    
    el.setAttribute("data-initials", initials.toUpperCase())
    
    })
    
    /* ===== START ===== */
    
    const startBtn = document.getElementById("startBtn")
    const startScreen = document.getElementById("startScreen")
    const gameScreen = document.getElementById("gameScreen")
    
    startBtn.onclick = () => {
    
    startScreen.style.opacity = "0"
    startScreen.style.transform = "scale(0.9)"
    
    setTimeout(() => {
    
    startScreen.style.display="none"
    
    gameScreen.style.display="block"
    gameScreen.style.opacity = "0"
    gameScreen.style.transform = "scale(1.1)"
    
    setTimeout(() => {
    gameScreen.style.opacity = "1"
    gameScreen.style.transform = "scale(1)"
    },100)
    
    startGame()
    
    },400)
    
    }
    
    /* ===== DATABASE ===== */
    
    const characters = [
    
    {nome:"Albert Einstein", donna:false, italiano:false, informatico:false, fisico:true},
    {nome:"Marie Curie", donna:true, italiano:false, informatico:false, fisico:true},
    {nome:"Alan Turing", donna:false, italiano:false, informatico:true, fisico:false},
    {nome:"Ada Lovelace", donna:true, italiano:false, informatico:true, fisico:false},
    {nome:"Galileo Galilei", donna:false, italiano:true, informatico:false, fisico:true},
    {nome:"Isaac Newton", donna:false, italiano:false, informatico:false, fisico:true},
    {nome:"Enrico Fermi", donna:false, italiano:true, informatico:false, fisico:true},
    {nome:"Margherita Hack", donna:true, italiano:true, informatico:false, fisico:true},
    {nome:"Fabiola Gianotti", donna:true, italiano:true, informatico:false, fisico:true},
    {nome:"Guglielmo Marconi", donna:false, italiano:true, informatico:false, fisico:true},
    {nome:"Rita Levi-Montalcini", donna:true, italiano:true, informatico:false, fisico:false}
    
    ]
    
    const questions = [
    
    {testo:"È una donna?", key:"donna"},
    {testo:"È italiano?", key:"italiano"},
    {testo:"È legato all'informatica?", key:"informatico"},
    {testo:"È famoso per la fisica?", key:"fisico"}
    
    ]
    
    let remaining = []
    let usedQuestions = []
    let currentQuestion = null
    
    const question = document.getElementById("question")
    const result = document.getElementById("result")
    const yesBtn = document.getElementById("yesBtn")
    const noBtn = document.getElementById("noBtn")
    const restartBtn = document.getElementById("restartBtn")
    const thinking = document.getElementById("thinking")
    
    /* ===== GAME ===== */
    
    function startGame(){
    
    remaining = [...characters]
    usedQuestions = []
    result.innerText=""
    
    yesBtn.style.display="inline-block"
    noBtn.style.display="inline-block"
    restartBtn.style.display="none"
    
    nextQuestion()
    
    }
    
    /* ===== AI DINAMICA ===== */
    
    function nextQuestion(){
    
    question.style.opacity = 0
    question.style.transform = "translateY(20px)"
    
    setTimeout(()=>{
    
    if(remaining.length === 1){
    
    question.innerText=""
    
    result.innerText="🎯 È: " + remaining[0].nome
    
    result.style.opacity = 0
    result.style.transform = "scale(0.8)"
    
    setTimeout(()=>{
    result.style.opacity = 1
    result.style.transform = "scale(1)"
    },100)
    
    yesBtn.style.display="none"
    noBtn.style.display="none"
    restartBtn.style.display="inline-block"
    
    return
    }
    
    /* trova domanda migliore */
    
    let bestQuestion = null
    let bestScore = 999
    
    questions.forEach(q=>{
    
    if(usedQuestions.includes(q)) return
    
    let yes = 0
    let no = 0
    
    remaining.forEach(p=>{
    if(p[q.key]) yes++
    else no++
    })
    
    let diff = Math.abs(yes - no)
    
    if(diff < bestScore){
    bestScore = diff
    bestQuestion = q
    }
    
    })
    
    if(!bestQuestion){
    
    result.innerText="🤔 Potrebbe essere: " + remaining.map(p=>p.nome).join(", ")
    restartBtn.style.display="inline-block"
    return
    }
    
    currentQuestion = bestQuestion
    usedQuestions.push(bestQuestion)
    
    question.innerText = bestQuestion.testo
    
    question.style.opacity = 1
    question.style.transform = "translateY(0)"
    
    },200)
    
    }
    
    /* ===== RISPOSTE ===== */
    
    function move(answer){
    
    thinking.style.opacity=1
    thinking.innerText = "Sto pensando..."
    
    yesBtn.disabled = true
    noBtn.disabled = true
    
    setTimeout(()=>{
    thinking.innerText = "Analizzo..."
    },300)
    
    setTimeout(()=>{
    thinking.innerText = "Quasi trovato..."
    },700)
    
    setTimeout(()=>{
    
    thinking.style.opacity=0
    
    remaining = remaining.filter(p => p[currentQuestion.key] === answer)
    
    updateProgress()
    
    yesBtn.disabled = false
    noBtn.disabled = false
    
    nextQuestion()
    
    },1100)
    
    }
    
    yesBtn.onclick=()=>move(true)
    noBtn.onclick=()=>move(false)
    
    /* ===== PROGRESS ===== */
    
    function updateProgress(){
    
    let progress = (usedQuestions.length / questions.length) * 100
    document.getElementById("progressBar").style.width = progress + "%"
    
    }
    
    restartBtn.onclick=()=>location.reload()
    
    /* ===== PARTICLES ===== */
    
    const canvas=document.getElementById("particles")
    const ctx=canvas.getContext("2d")
    
    canvas.width=window.innerWidth
    canvas.height=window.innerHeight
    
    let particles=[]
    
    for(let i=0;i<80;i++){
    particles.push({
    x:Math.random()*canvas.width,
    y:Math.random()*canvas.height,
    r:Math.random()*2,
    dx:(Math.random()-0.5)*0.6,
    dy:(Math.random()-0.5)*0.6
    })
    }
    
    function animate(){
    
    ctx.clearRect(0,0,canvas.width,canvas.height)
    
    ctx.fillStyle="white"
    
    particles.forEach(p=>{
    ctx.beginPath()
    ctx.arc(p.x,p.y,p.r,0,Math.PI*2)
    ctx.fill()
    
    p.x+=p.dx
    p.y+=p.dy
    
    if(p.x<0||p.x>canvas.width)p.dx*=-1
    if(p.y<0||p.y>canvas.height)p.dy*=-1
    })
    
    requestAnimationFrame(animate)
    }
    
    animate()
    
    }