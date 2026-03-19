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
    
    /* ===== DATABASE COMPLETO ===== */
    
    const characters = [
    
    {nome:"Rita Levi-Montalcini", img:"../img/RitaLeviMontalcini.png", donna:true, italiano:true, informatico:false, fisico:false, antico:false, nobel:true, matematica:false, elettricita:false, astronomia:false},
    
    {nome:"Galileo Galilei", img:"../img/GalileoGalilei.jpg", donna:false, italiano:true, informatico:false, fisico:true, antico:true, nobel:false, matematica:true, elettricita:false, astronomia:true},
    
    {nome:"Leonardo da Vinci", img:"../img/LeonardoDaVinci.jpg", donna:false, italiano:true, informatico:false, fisico:false, antico:true, nobel:false, matematica:true, elettricita:false, astronomia:false},
    
    {nome:"Enrico Fermi", img:"../img/EnricoFermi.jpg", donna:false, italiano:true, informatico:false, fisico:true, antico:false, nobel:true, matematica:true, elettricita:false, astronomia:false},
    
    {nome:"Margherita Hack", img:"../img/MargheritaHack.jpg", donna:true, italiano:true, informatico:false, fisico:true, antico:false, nobel:false, matematica:false, elettricita:false, astronomia:true},
    
    {nome:"Fabiola Gianotti", img:"../img/FabiolaGianotti.jpg", donna:true, italiano:true, informatico:false, fisico:true, antico:false, nobel:false, matematica:false, elettricita:false, astronomia:false},
    
    {nome:"Guglielmo Marconi", img:"../img/GuglielmoMarconi.jpg", donna:false, italiano:true, informatico:false, fisico:true, antico:false, nobel:true, matematica:false, elettricita:true, astronomia:false},
    
    {nome:"Evangelista Torricelli", img:"../img/EvangelistaTorricelli.jpg", donna:false, italiano:true, informatico:false, fisico:true, antico:true, nobel:false, matematica:true, elettricita:false, astronomia:false},
    
    {nome:"Luigi Galvani", img:"../img/LuigiGalvani.jpg", donna:false, italiano:true, informatico:false, fisico:true, antico:true, nobel:false, matematica:false, elettricita:true, astronomia:false},
    
    {nome:"Giuseppe Lagrange", img:"../img/GiuseppeLagrange.jpg", donna:false, italiano:true, informatico:false, fisico:false, antico:true, nobel:false, matematica:true, elettricita:false, astronomia:false},
    
    {nome:"Sofia Kovalevskaya", img:"../img/SofiaKovalevskaya.jpg", donna:true, italiano:false, informatico:false, fisico:false, antico:true, nobel:false, matematica:true, elettricita:false, astronomia:false},
    
    {nome:"Ada Lovelace", img:"../img/AdaLovelace.jpg", donna:true, italiano:false, informatico:true, fisico:false, antico:true, nobel:false, matematica:true, elettricita:false, astronomia:false},
    
    {nome:"Alan Turing", img:"../img/AlanTuring.jpg", donna:false, italiano:false, informatico:true, fisico:false, antico:false, nobel:false, matematica:true, elettricita:false, astronomia:false},
    
    {nome:"Marie Curie", img:"../img/MarieCurie.jpg", donna:true, italiano:false, informatico:false, fisico:true, antico:false, nobel:true, matematica:false, elettricita:true, astronomia:false},
    
    {nome:"Albert Einstein", img:"../img/AlbertEinstein.jpg", donna:false, italiano:false, informatico:false, fisico:true, antico:false, nobel:true, matematica:true, elettricita:false, astronomia:false},
    
    {nome:"Isaac Newton", img:"../img/IsaacNewton.jpg", donna:false, italiano:false, informatico:false, fisico:true, antico:true, nobel:false, matematica:true, elettricita:false, astronomia:true},
    
    {nome:"Lucia Votano", img:"../img/LuciaVotano.jpg", donna:true, italiano:true, informatico:false, fisico:true, antico:false, nobel:false, matematica:false, elettricita:false, astronomia:false},
    
    {nome:"Anna Grassellino", img:"../img/AnnaGrassellino.jpg", donna:true, italiano:true, informatico:false, fisico:true, antico:false, nobel:false, matematica:false, elettricita:false, astronomia:false},
    
    {nome:"Alfio Quarteroni", img:"../img/AlfioQuarteroni.jpg", donna:false, italiano:true, informatico:false, fisico:false, antico:false, nobel:false, matematica:true, elettricita:false, astronomia:false},
    
    {nome:"Giuseppina Carniel", img:"../img/GiuseppinaCarniel.jpg", donna:true, italiano:true, informatico:false, fisico:false, antico:false, nobel:false, matematica:false, elettricita:false, astronomia:false}
    
    ]
    
    /* ===== DOMANDE SUPER AMPLIATE ===== */
    
    const questions = [
    
    {testo:"È una donna?", key:"donna"},
    {testo:"È italiano?", key:"italiano"},
    {testo:"È legato all'informatica?", key:"informatico"},
    {testo:"È famoso per la fisica?", key:"fisico"},
    
    {testo:"È nato prima del 1800?", key:"antico"},
    {testo:"Ha vinto il premio Nobel?", key:"nobel"},
    {testo:"È un matematico?", key:"matematica"},
    {testo:"Ha lavorato con l'elettricità?", key:"elettricita"},
    {testo:"È legato all'astronomia?", key:"astronomia"}
    
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
    result.innerHTML=""
    
    yesBtn.style.display="inline-block"
    noBtn.style.display="inline-block"
    restartBtn.style.display="none"
    
    nextQuestion()
    
    }
    
    /* ===== AI DINAMICA POTENZIATA ===== */
    
    function nextQuestion(){
    
    question.style.opacity = 0
    question.style.transform = "translateY(20px)"
    
    setTimeout(()=>{
    
    /* 🔥 ERRORE */
    if(remaining.length === 0){
    
    result.innerText="😵 Non sono riuscito a indovinare"
    restartBtn.style.display="inline-block"
    return
    }
    
    /* 🔥 RISULTATO */
    if(remaining.length === 1){
    
    const p = remaining[0]
    
    question.innerText=""
    
    result.innerHTML = `
    <div style="text-align:center;">
    <img src="${p.img}" style="width:180px;height:180px;border-radius:15px;margin-bottom:10px;">
    <div style="font-size:24px;">🎯 È: ${p.nome}</div>
    </div>
    `
    
    yesBtn.style.display="none"
    noBtn.style.display="none"
    restartBtn.style.display="inline-block"
    
    return
    }
    
    /* 🔥 SE FINISCONO DOMANDE */
    if(usedQuestions.length === questions.length){
    
    let random = remaining[Math.floor(Math.random()*remaining.length)]
    
    result.innerHTML="🤔 Potrebbe essere: " + random.nome
    restartBtn.style.display="inline-block"
    return
    }
    
    /* 🔥 ALGORITMO INTELLIGENTE */
    
    let bestQuestions = []
    let bestScore = 999
    
    questions.forEach(q=>{
    
    if(usedQuestions.includes(q)) return
    
    let yes=0
    let no=0
    
    remaining.forEach(p=>{
    if(p[q.key]) yes++
    else no++
    })
    
    let diff = Math.abs(yes-no)
    
    if(diff < bestScore){
    bestScore = diff
    bestQuestions = [q]
    }else if(diff === bestScore){
    bestQuestions.push(q)
    }
    
    })
    
    /* scelta casuale tra le migliori */
    
    currentQuestion = bestQuestions[Math.floor(Math.random()*bestQuestions.length)]
    
    usedQuestions.push(currentQuestion)
    
    question.innerText = currentQuestion.testo
    
    question.style.opacity = 1
    question.style.transform = "translateY(0)"
    
    },200)
    
    }
    
    /* ===== RISPOSTE ===== */
    
    function move(answer){
    
    thinking.style.opacity=1
    thinking.innerText="Sto pensando..."
    
    yesBtn.disabled=true
    noBtn.disabled=true
    
    setTimeout(()=>{
    
    thinking.style.opacity=0
    
    remaining = remaining.filter(p => p[currentQuestion.key] === answer)
    
    yesBtn.disabled=false
    noBtn.disabled=false
    
    nextQuestion()
    
    },900)
    
    }
    
    yesBtn.onclick=()=>move(true)
    noBtn.onclick=()=>move(false)
    
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