const tree = {

    question:"È una donna?",
    
    yes:{
    
    question:"È italiana?",
    
    yes:{
    
    question:"È una fisica?",
    
    yes:{
    
    question:"Lavora al CERN?",
    
    yes:{result:"Fabiola Gianotti"},
    no:{
    question:"È un'astrofisica?",
    yes:{result:"Margherita Hack"},
    no:{
    question:"Lavora nei laboratori di fisica?",
    yes:{result:"Anna Grassellino"},
    no:{result:"Lucia Votano"}
    }
    }
    },
    
    no:{
    question:"Ha vinto il Nobel per la medicina?",
    yes:{result:"Rita Levi-Montalcini"},
    no:{result:"Giuseppina Carniel"}
    }
    
    },
    
    no:{
    
    question:"È una matematica?",
    
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
    
    question:"È un matematico?",
    
    yes:{result:"Alfio Quarteroni"},
    
    no:{
    
    question:"È nato prima del 1800?",
    
    yes:{
    
    question:"Ha inventato il barometro?",
    
    yes:{result:"Evangelista Torricelli"},
    no:{
    question:"Studiava l'elettricità?",
    yes:{result:"Luigi Galvani"},
    no:{result:"Galileo Galilei"}
    }
    
    },
    
    no:{result:"Enrico Fermi"}
    
    }
    
    }
    
    },
    
    no:{
    
    question:"È legato all'informatica?",
    
    yes:{result:"Alan Turing"},
    
    no:{
    
    question:"È nato prima del 1700?",
    
    yes:{result:"Isaac Newton"},
    
    no:{
    
    question:"È un fisico teorico famoso?",
    
    yes:{result:"Albert Einstein"},
    no:{result:"Leonardo da Vinci"}
    
    }
    
    }
    
    }
    
    }
    
    };
    
    let current = tree;
    
    const questionEl = document.getElementById("question");
    const resultEl = document.getElementById("result");
    
    const yesBtn = document.getElementById("yesBtn");
    const noBtn = document.getElementById("noBtn");
    const restartBtn = document.getElementById("restartBtn");
    
    function showNode(){
    
    if(current.result){
    
    questionEl.innerText="";
    resultEl.innerText="Il personaggio è: " + current.result;
    
    yesBtn.style.display="none";
    noBtn.style.display="none";
    
    restartBtn.style.display="inline-block";
    
    return;
    
    }
    
    questionEl.innerText=current.question;
    
    }
    
    yesBtn.onclick=()=>{
    current=current.yes;
    showNode();
    };
    
    noBtn.onclick=()=>{
    current=current.no;
    showNode();
    };
    
    restartBtn.onclick=()=>{
    current=tree;
    resultEl.innerText="";
    yesBtn.style.display="inline-block";
    noBtn.style.display="inline-block";
    restartBtn.style.display="none";
    showNode();
    };
    
    showNode();