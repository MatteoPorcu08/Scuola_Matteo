const totalSteps = 7
let step = 0

function updateProgress(){
step++
document.getElementById("progressBar").style.width =
(step/totalSteps)*100 + "%"
}

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
question:"È legata all'informatica?",
yes:{result:"Ada Lovelace"},
no:{result:"Marie Curie"}
}
}
},

no:{

question:"È italiano?",

yes:{
question:"È famoso per la radio?",
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

let current=tree

const question=document.getElementById("question")
const result=document.getElementById("result")

const yes=document.getElementById("yesBtn")
const no=document.getElementById("noBtn")
const restart=document.getElementById("restartBtn")

const thinking=document.getElementById("thinking")

function show(){

if(current.result){

thinking.style.opacity=0

question.innerText=""

result.innerText="Il personaggio è: "+current.result

yes.style.display="none"
no.style.display="none"

restart.style.display="inline-block"

return
}

question.innerText=current.question

}

function move(direction){

thinking.style.opacity=1

setTimeout(()=>{

thinking.style.opacity=0

current=current[direction]

updateProgress()

show()

},500)

}

yes.onclick=()=>move("yes")
no.onclick=()=>move("no")

restart.onclick=()=>{

current=tree
step=0

document.getElementById("progressBar").style.width="0%"

result.innerText=""

yes.style.display="inline-block"
no.style.display="inline-block"

restart.style.display="none"

show()

}

show()