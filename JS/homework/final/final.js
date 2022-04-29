"use strict";

// =============================Establish global variables=============================
let name = prompt("Hello! What is your name?", "John Smith"); // window.prompt(), let 
//alert(`${name}, let's play some blackjack!`) // window.alert() //TODO: uncomment

const winThreshold = 21; // const

let instructions = "the rules of this game are simple: Answer questions about JavaScript to push your point value as close to 21 as possible. You win if you get closer to 21 than the dealer without going over. If you go over, you lose. Think you can do it?"

let userPoints = 0;
let currentTopic;
let randomArrayChoice = Math.floor(Math.random() * 3);


// =============================Introduce the game=============================
// document.getElementById("something1").textContent
document.getElementById("instructions").textContent = `${name}, ` + instructions

// =============================onclick Assignments =============================
// onclick assignment

document.getElementById("userAgreeToStart").onclick = loadGameBoard;
document.getElementById("askQuestion").onclick = askQuestion;
document.getElementById("userQuizAnswer").onclick = gradeAnswer;

// =============================Backend Functions=============================

`
Removes the initial instructions and loads the game board. Also determines the initial dealer value
`

function loadGameBoard() {  // create several custom functions to process your game
    
    // document.getElementById("something5").classList
    document.getElementById("onboardingDiv").classList.add("deactivatedDiv");
    
    // document.getElementById("something4").className
    document.getElementById("gameBoardDiv").className = "activatedDiv"; 

    setTheGame();
}

`
Quick and dirty draw a dealer's hand 
`

function setTheGame() {
    let dealerHand = 0;

    while (dealerHand < 11) {  // while
        dealerHand = dealerHand + Math.floor(Math.random() * 12);
        console.log(dealerHand) // console.log() to follow and debug your code -- leave these in the js file. I use VS Code breakpoint debugging. Adding one in for the requirements
    }

    document.getElementById("pointCounter").textContent = `${name}, your current card count is ${userPoints}`;




}

function askQuestion() {
    console.log("askQuestion() ran")
    // document.getElementById("something2").value
    let topicChoice = document.getElementById("categorySelector").value;  
    console.log(topicChoice);
    randomArrayChoice = Math.floor(Math.random() * 3);
    

    switch (topicChoice){

        case "loops":
            loopQuizzer.askQuestion(randomArrayChoice);
            currentTopic = topicChoice;


    }

}

function gradeAnswer() {

    switch (currentTopic){
        case ("loops"):
            let userQuizAnswer = document.getElementById("userAnswer").value;
            if (userQuizAnswer == (loopQuestions[randomArrayChoice].answer)) {
                celebrate(); // TODO:
            }
            else {
                console.log("false");
                console.log(loopQuestions[randomArrayChoice].answer);
            }
    }

        

}

// =============================Loop Objects and related Functions=============================


`
Loops question set
`

const loopQ1 = {
    question: "If you are trying to end a loop immediately, what keyword would you use?",
    answer: "break",
}

const loopQ2 = {
    question: "If you are trying to skip an iteration of a loop, but not exit the loop entirely, what keyword would you use?",
    answer: "continue",
}

const loopQ3 = {
    question: "Which style of loop would be better if the number of needed iterations is unknown? if or while?",
    answer: "while"
}

let loopQuestions = [loopQ1, loopQ2, loopQ3];

const loopQuizzer = {
    askQuestion : function (arrayChoice) {
        document.getElementById("questionSocket").textContent = loopQuestions[arrayChoice].question;
        document.getElementById("answerSocket").className = "activatedDiv"
    }
}

// =============================Data Types and Related Functions=============================


// =============================Arrays and Related Functions=============================


// =============================DOM and Related Functions=============================



// =============================Items Remaining to Code=============================

// document.getElementsByTagName("something3")


// document.querySelectorAll(".something6")
// for
// if ... else

// switch
// array

// addEventListener() to trigger all functions OR you can also use individual JavaScript event properties such as .onclick and assign a function to that property
// use JavaScript to modify images

// include ALL of the following operations, conditional operators, and logical operators
// +   -   *   /   %   **
// Differentiate the use of + to add versus concatenate.
// ==   +=
// ===   !=   !==
// ++    --   
// >   <   >=   <=
// &&   ||
// Do not allow the user to divide by 0.

// at least 2 images
// 2 media queries
