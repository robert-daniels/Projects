"use strict";

// =============================Establish global variables=============================
let name = prompt("Hello! What is your name?", "John Smith"); // window.prompt(), let 
//alert(`${name}, let's play some blackjack!`) // window.alert() //TODO: uncomment

const winThreshold = 21; // const

let instructions = "the rules of this game are simple: Answer questions about JavaScript to push your point value as close to 21 as possible. Aces will be either 1 or 10, the comptuer will decide. You win if you get closer to 21 than the dealer without going over. If you go over, you lose. Think you can do it?"

let userPoints = 0;
let dealerHand = 0;
let currentTopic;
let randomArrayChoice = Math.floor(Math.random() * 3);
let gameRunning = true;


// =============================Introduce the game=============================

// document.getElementById("something1").textContent
document.getElementById("instructions").textContent = `${name}, ` + instructions



// =============================onclick Assignments =============================
// onclick assignment

document.getElementById("userAgreeToStart").onclick = loadGameBoard;
document.getElementById("askQuestion").onclick = askQuestion;
document.getElementById('userQuizAnswer').onclick = gradeAnswer;
document.getElementById('endGame').onclick = determineWin;
document.getElementById("tryAgain").onclick = loadGameBoard;



// =============================Backend Functions=============================

`
Removes the initial instructions and loads the game board.
`

function loadGameBoard() {  // create several custom functions to process your game
    userPoints = 0

    document.getElementById("questionSocket").classList.add("deactivatedDiv");
    document.getElementById("title").textContent = "Let's Play A Game:"
    // document.getElementById("something5").classList
    document.getElementById("onboardingDiv").classList.add("deactivatedDiv");
    
    // document.getElementById("something4").className
    document.getElementById("gameBoardDiv").className = "activatedDiv";
    document.getElementById("answerResult").className = "deactivatedDiv";
  
    

    setDealerHand();

    document.getElementById("pointCounter").textContent = `${name}, your current card count is ${userPoints}`;
}

`
Quick and dirty draw a dealer's hand. Determines the initial dealer value
`

function setDealerHand() {
    dealerHand = 0

    while (dealerHand < 11) {  // while
        dealerHand = dealerHand + Math.floor((Math.random() * 11) + 1);
        console.log(dealerHand) // console.log() to follow and debug your code -- leave these in the js file. 
    }
}

function determineWin() {
    console.log("determineWin ran");

   

    if (userPoints > dealerHand && userPoints < 22) {
        document.getElementById("title").textContent = `Your points: ${userPoints}. Dealer: ${dealerHand}...You win!`
    }
    else if (userPoints > 21) {
        document.getElementById("title").textContent = `Your points: ${userPoints}. You've gone over 21. Loss recorded`
    }
    else if (userPoints < dealerHand){
        document.getElementById("title").textContent = `Your points: ${userPoints} Dealer: ${dealerHand}...Dealer wins!`
    }
    
        var titleElement = document.getElementById("tryAgainDiv").value
        
        if (titleElement) {
            title.append(document.getElementById("tryAgainDiv"))
        }
        else {
            
        }
    
}

`
Pulls a question from the relevant topic quiz bank
`

function askQuestion() {
    console.log("askQuestion() ran")
    // document.getElementById("something2").value
    let topicChoice = document.getElementById("categorySelector").value; 
     
    
    
    // clear the old responses
    document.getElementById("answerResult").textContent = "";
    document.getElementById("userAnswer").value = "";

    randomArrayChoice = Math.floor(Math.random() * 3);
    
    // activate the answer template and append to the socket
    document.getElementById("answerTemplate").className = "activatedDiv";
    answerSocket.append(document.getElementById('answerTemplate'));
    

    switch (topicChoice){  // switch

        case "loops":
            loopQuizzer.askQuestion(randomArrayChoice);
            currentTopic = topicChoice;


    }

}

`
Validates the user input to see if correct based off topic chosen. If validated, add points to user score
`

function gradeAnswer() {
    console.log("gradeAnswer ran");
    let validated = false;
    document.getElementById("answerResult").className = "activatedDiv";

    switch (currentTopic){
        case ("loops"):
            let correctAnswer = loopQuestions[randomArrayChoice].answer;
            let userQuizAnswer = document.getElementById("userAnswer").value;
            if (userQuizAnswer == (correctAnswer)) {  // if ... else
                validated = true;
                respondToAnswer(validated, correctAnswer); 
            }
            else {
                console.log("false");
                respondToAnswer(validated, correctAnswer);
            }

           
            console.log(loopQuestions);


    }
}

`
Output to user if the answer was right or wrong. Calls addPoints()
`

function respondToAnswer(validated, correctAnswer) {
    let answerResult = document.getElementById("answerResult")
    document.getElementById("answerSocket").classList.add("deactivatedDiv");

    if (validated) {
        answerResult.textContent = "Correct!"
        addPoints();
    }
    else {
        answerResult.textContent = `Sorry, incorrect. We were looking for: ${correctAnswer}`;
    }
    
}


function addPoints() {
    let userPointsToAdd  = Math.floor((Math.random() * 11) + 1);

    answerResult.insertAdjacentText("beforeend", ` You received a card worth ${userPointsToAdd} points.`)
    userPoints = userPoints + userPointsToAdd;

    document.getElementById("pointCounter").textContent = `${name}, your current card count is ${userPoints}`;

    if (userPoints > 21){
        gameRunning = false;
        determineWin();
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

let loopQuestions = [loopQ1, loopQ2, loopQ3]; // array

const loopQuizzer = {
    askQuestion : function (arrayChoice) {
        document.getElementById("questionSocket").className = ("activatedDiv");
        document.getElementById("questionSocket").textContent = loopQuestions[arrayChoice].question;
        document.getElementById("answerSocket").className = "activatedDiv"
    },

}

// =============================Data Types and Related Functions=============================


// =============================Arrays and Related Functions=============================


// =============================DOM and Related Functions=============================



// =============================Items Remaining to Code=============================

// document.getElementsByTagName("something3")
// document.querySelectorAll(".something6")

// document.querySelectorAll(".something6")
// for





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
