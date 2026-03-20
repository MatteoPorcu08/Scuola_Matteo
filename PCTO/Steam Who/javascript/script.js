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
    
    // (UGUALE AL TUO - NON TOCCO)
    
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
    
    characters.forEach(p => p.score = 0)
    
    /* ===== DOMANDE ===== */
    
    const questions = [
    
    {testo:"È una donna?", key:"donna"},
    {testo:"È italiano?", key:"italiano"},
    {testo:"È legato all'informatica?", key:"informatico"},
    {testo:"È famoso per la fisica?", key:"fisico"},
    {testo:"È nato prima del 1800?", key:"antico"},
    {testo:"Ha vinto il Nobel?", key:"nobel"},
    {testo:"È matematico?", key:"matematica"},
    {testo:"Lavora con elettricità?", key:"elettricita"},
    {testo:"È legato all’astronomia?", key:"astronomia"}
    
    ]
    
    let usedQuestions = []
    let currentQuestion = null
    
    const question = document.getElementById("question")
    const result = document.getElementById("result")
    const yesBtn = document.getElementById("yesBtn")
    const noBtn = document.getElementById("noBtn")
    const restartBtn = document.getElementById("restartBtn")
    const thinking = document.getElementById("thinking")
    
    /* 🔥 NUOVO */
    const confidenceBar = document.getElementById("confidenceBar")
    
    function startGame(){
    
    characters.forEach(p => p.score = 0)
    usedQuestions = []
    result.innerHTML=""
    
    confidenceBar.style.width = "5%"
    
    nextQuestion()
    
    }
    
    function nextQuestion(){
    
    if(usedQuestions.length === questions.length){
    return showResult()
    }
    
    let best = null
    let bestScore = Infinity
    
    questions.forEach(q=>{
    
    if(usedQuestions.includes(q)) return
    
    let yesWeight = 0
    let noWeight = 0
    
    characters.forEach(p=>{
    if(p[q.key]) yesWeight += (p.score + 1)
    else noWeight += (p.score + 1)
    })
    
    let diff = Math.abs(yesWeight - noWeight)
    
    if(diff < bestScore){
    bestScore = diff
    best = q
    }
    
    })
    
    currentQuestion = best
    usedQuestions.push(best)
    
    question.innerText = best.testo
    
    }
    
    function move(answer){
    
    thinking.style.opacity=1
    
    setTimeout(()=>{
    
    thinking.style.opacity=0
    
    characters.forEach(p=>{
    
    if(p[currentQuestion.key] === answer){
    p.score += 3
    }else{
    p.score -= 1
    }
    
    })
    
    updateConfidence()
    
    nextQuestion()
    
    },700)
    
    }
    
    yesBtn.onclick=()=>move(true)
    noBtn.onclick=()=>move(false)
    
    /* ===== BARRA PROBABILITÀ ===== */
    
    function updateConfidence(){
    
    let sorted = [...characters].sort((a,b)=>b.score - a.score)
    
    let best = sorted[0]
    let second = sorted[1] || {score:0}
    
    let confidence = best.score - second.score
    
    let percent = Math.min(100, Math.max(5, confidence * 10))
    
    confidenceBar.style.width = percent + "%"
    
    }
    
    /* ===== RISULTATO ===== */
    
    function showResult(){
    
    characters.sort((a,b)=>b.score - a.score)
    
    let best = characters[0]
    
    confidenceBar.style.width = "100%"
    
    result.innerHTML = `
    <div style="text-align:center;">
    <img src="${best.img}" style="width:180px;height:180px;border-radius:15px;margin-bottom:10px;">
    <div style="font-size:24px;">🎯 È: ${best.nome}</div>
    </div>
    `
    
    yesBtn.style.display="none"
    noBtn.style.display="none"
    restartBtn.style.display="inline-block"
    
    }
    const menuBtn = document.getElementById("menuBtn")
const dropdown = document.getElementById("dropdownMenu")

if(menuBtn && dropdown){

    menuBtn.onclick = (e) => {
        e.stopPropagation()
        dropdown.classList.toggle("active")
    }

    document.addEventListener("click", () => {
        dropdown.classList.remove("active")
    })

    dropdown.addEventListener("click", (e) => {
        e.stopPropagation()
    })
}
    
    restartBtn.onclick=()=>location.reload()
    
    }