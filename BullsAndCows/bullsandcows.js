// four divs
// need to know the thickness of the boxes
// each of the boxes needs an id
// we need the text box for the guessing
// when we click the button to "guess"
// it guess the text value of the input box
// the value we get from the input box will be a string
// we will convert that to an int
// then we compare that value to the value that we are 
// guessing (this number is randomly generated)
let increment = 0;
let secretNum = "";
let allGreen = false;
const random4Num = function(){
    const digits = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
    let answer = digits.splice( Math.trunc(Math.random() * (digits.length - 1) + 1 ), 1)[0];
    for( let i = 1; i < 4; i++ ){
      let randomIndex = Math.trunc(Math.random() * digits.length);
      let digit = digits.splice(randomIndex,1)[0];
      answer *= 10;
      answer += digit;
    }
    return answer;
  }
function clickedButton(){
        let text = document.getElementById("input").value;
        if (text.length < 4 || isNaN(text)) alert("THE GUESS MUST BE ALL NUMBERS AND OF LENGTH 4!");
        else {
            if (increment % 10 === 0) {
                secretNum = "" + random4Num();
                increment = 0
            }
            document.getElementById("text").textContent = "You have " +  (9 - increment) + " turns left!";
            // console.log(secretNum);
            let colors = [];
            for(let i = 0; i < secretNum.length; i++){
                if(text.charAt(i) == secretNum.charAt(i)) {
                    colors.push("green");
                }
                else if (secretNum.includes(text.charAt(i))) {
                    colors.push("yellow");
                } else {
                    colors.push("red");
                }
            }
            // console.log(colors);
            for (let i = 0; i < colors.length; i++)
                if (colors[i] !== "green") {
                    allGreen = false;
                    break;
                } else 
                    allGreen = true;
            let count = 1;
            for(let color of colors){
                document.getElementById(count).textContent = text.charAt(count - 1);
                document.getElementById(count).style.color = "black";
                document.getElementById(count).style.backgroundColor = colors[count - 1];
                count++;
            }
            increment++;
        }
        if (allGreen) {
            document.getElementById("text").textContent = "YOU WON!"
            reset();
        }
}

let reset = function() {
    increment = 0;
    secretNum = "";
    allGreen = false;
    for (let i = 0; i < 4; i++) {
        document.getElementById((i+1)).textContent = "X";
        document.getElementById((i+1)).style.color = "black";
        document.getElementById((i+1)).style.backgroundColor = "white"
    }
}

let populatePage = function() {
    const button = document.getElementById("button");
    button.addEventListener("click", clickedButton, false);
}
populatePage();

