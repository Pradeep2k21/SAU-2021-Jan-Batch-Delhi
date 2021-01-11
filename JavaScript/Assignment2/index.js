resetAll = () => {

    let divisionsCol = document.getElementsByName('numDivs');

    for(let i=0; i<divisionsCol.length ; i++){
        divisionsCol[i].classList.remove('evenColor');
        divisionsCol[i].classList.remove('multiple5Color');
        divisionsCol[i].classList.add('removeColor');
    }

}

highlightEven = () => {

    let divisionsCol = document.getElementsByName('numDivs');
    resetAll();
    for(let i=0; i<divisionsCol.length ; i+=2){
            divisionsCol[i].classList.add('evenColor');
    }

}

highlight5Multiple = () => {

    let divisionsCol = document.getElementsByName('numDivs');
    resetAll();
    for(let i=0; i<divisionsCol.length ; i+=5){
            divisionsCol[i].classList.add('multiple5Color');
    }

}