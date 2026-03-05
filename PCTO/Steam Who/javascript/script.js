/* START / GAME SCREEN */

const startBtn = document.getElementById("startBtn")
const startScreen = document.getElementById("startScreen")
const gameScreen = document.getElementById("gameScreen")

startBtn.onclick = () => {

startScreen.style.display="none"
gameScreen.style.display="block"

startGame()

}

/* GAME ENGINE */

let step=0
const totalSteps=7

const tree={

question:"È una donna?",

yes:{
question:"È italiana?",

yes:{
question:"È una fisica?",

yes:{
question:"Lavora al CERN?",
yes:{result:"Fabiola Gianotti"},
no:{result:"Margherita Hack"}
},

no:{
question:"Ha vinto il Nobel?",
yes:{result:"Rita Levi-Montalcini"},
no:{result:"Giuseppina Carniel"}
}
},

no:{
question:"È matematica?",
yes:{result:"Sofia Kovalevskaya"},
no:{
question:"È informatica?",
yes:{result:"Ada Lovelace"},
no:{result:"Marie Curie"}
}
}

},

no:{

question:"È italiano?",

yes:{
question:"Ha inventato la radio?",
yes:{result:"Guglielmo Marconi"},
no:{
question:"È matematico?",
yes:{result:"Alfio Quarteroni"},
no:{
question:"È nato prima del 1700?",
yes:{result:"Galileo Galilei"},
no:{result:"Enrico Fermi"}
}
}
},

no:{
question:"È informatico?",
yes:{result:"Alan Turing"},
no:{
question:"È nato prima del 1700?",
yes:{result:"Isaac Newton"},
no:{
question:"È fisico teorico?",
yes:{result:"Albert Einstein"},
no:{result:"Leonardo da Vinci"}
}
}
}

}

}

let current = tree

const question=document.getElementById("question")
const result=document.getElementById("result")

const yesBtn=document.getElementById("yesBtn")
const noBtn=document.getElementById("noBtn")

const restartBtn=document.getElementById("restartBtn")

const thinking=document.getElementById("thinking")

function startGame(){

current=tree
step=0

show()

}

function show(){

if(current.result){

question.innerText=""

result.innerText="Il personaggio è: "+current.result

yesBtn.style.display="none"
noBtn.style.display="none"

restartBtn.style.display="inline-block"

return

}

question.innerText=current.question

}

function move(dir){

thinking.style.opacity=1

setTimeout(()=>{

thinking.style.opacity=0

current=current[dir]

step++

updateProgress()

show()

},500)

}

yesBtn.onclick=()=>move("yes")
noBtn.onclick=()=>move("no")

function updateProgress(){

document.getElementById("progressBar").style.width=
(step/totalSteps)*100+"%"

}

restartBtn.onclick=()=>{

location.reload()

}

/* PARTICLES */

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