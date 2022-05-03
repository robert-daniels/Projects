"use strict";

// add graphics
// prevent question duplication
// prevent further user input after determineWin() is called


// =============================Establish Variables=============================
let name = prompt("Hello! What is your name?", "John Smith"); // window.prompt(), let 
alert(`${name}, let's play!`) // window.alert() 

const winThreshold = 21; // const

let instructions = "the rules of this game are simple: Answer questions about JavaScript to push your point value as close to 21 as possible. You win if you get closer to 21 than the dealer without going over. If you go over, you lose. Think you can do it?"

let userPoints;
let dealerHand;
let currentTopic;
let randomArrayChoice = Math.floor(Math.random() * 3); // assumes three questions per category. brittle, could instead use the array.length
let gameRunning = true;


// =============================Introduce the Game=============================

// document.getElementById("something1").textContent  , show concatenate
document.getElementById("instructions").textContent = `${name}, ` + instructions;


// =============================Backend Functions=============================

`
Backend functions to run the game. Wrapped into an object literal Dealer because I wanted to practice
`
const Dealer = {

    loadGameBoard : function() {
        userPoints = 0;

        // display appropriate sections
        document.getElementById("categorySelector").className = "activatedDiv";
        document.getElementById("questionSocket").className = "deactivatedDiv";
        document.getElementById("quizzer").className = "activatedDiv";
        document.getElementById("pointCounter").className = "deactivatedDiv";

        document.getElementById("title").textContent = "Let's Play!"
        // document.getElementById("something5").classList
        document.getElementById("onboardingDiv").classList.add("deactivatedDiv");
        // document.getElementById("something4").className
        document.getElementById("gameBoardDiv").className = "activatedDiv";
        document.getElementById("answerResult").className = "deactivatedDiv";
        Dealer.setDealerHand();
        document.getElementById("pointCounter").textContent = `${name}, your current card count is ${userPoints}`;
    },

    setDealerHand : function() {
        dealerHand = 0

        while (dealerHand < 11) {  // while
        dealerHand = dealerHand + Math.floor((Math.random() * 11) + 1);
        console.log(dealerHand) // console.log() to follow and debug your code -- leave these in the js file. 
        }
    },

    determineWin : function() {
        console.log("determineWin ran");
        Dealer.clearTheBoard();

        var titleElement = document.getElementById("tryAgainDiv").value

        

        if (userPoints > dealerHand && userPoints < 22) {
            document.getElementById("title").textContent = `Your points: ${userPoints}. Dealer: ${dealerHand}...You win!`  
        }
        else if (userPoints > 21) {
            document.getElementById("title").textContent = `Your points: ${userPoints}. You've gone over 21. You lose...`
        }
        else if (userPoints < dealerHand){
            document.getElementById("title").textContent = `Your points: ${userPoints} Dealer: ${dealerHand}...Dealer wins!`
        }
        

        if (titleElement) {
            title.append(document.getElementById("tryAgainDiv"))
        }
    },

    askQuestion : function() {
        console.log("askQuestion() ran")
    
        // document.getElementById("something2").value
        var topicChoice = document.getElementById("categorySelector").value; 
        currentTopic = topicChoice;
        
        
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
                break;
            case "dataTypes":
                dataTypeQuizzer.askQuestion(randomArrayChoice);
                break;
            case "arrays":
                arrayQuizzer.askQuestion(randomArrayChoice); 
                break;
            case "comparisons":
                comparisonsQuizzer.askQuestion(randomArrayChoice);
                break;
            default:
                console.log("Something went wrong in final.js/askQuestion()");
        }
    }, 

    gradeAnswer : function() {
        console.log("gradeAnswer ran");
        var validated = false;
        document.getElementById("answerResult").className = "activatedDiv";
        var correctAnswer;
        var userQuizAnswer = document.getElementById("userAnswer").value;
    
        switch (currentTopic){
            case ("loops"):
                correctAnswer = loopQuestions[randomArrayChoice].answer;
                break;
            case ("dataTypes") :
                correctAnswer = dataTypeQuestions[randomArrayChoice].answer;
                break;
            case ("arrays") :
                correctAnswer = arrayQuestions[randomArrayChoice].answer;
                break;
            case ("comparisons") :
                correctAnswer = comparisonQuestions[randomArrayChoice].answer;
                break;
            default:
                console.log("something went wrong in final.js/gradeAnswer()");
            }
    
        if (userQuizAnswer == (correctAnswer)) {  // if ... else
            validated = true;
            Dealer.respondToAnswer(validated, correctAnswer); 
        }
        else {
            console.log("false");
            Dealer.respondToAnswer(validated, correctAnswer);
        }
    },

    respondToAnswer : function(validated, correctAnswer) {
        var answerResult = document.getElementById("answerResult")
        document.getElementById("answerSocket").className = "deactivatedDiv";

        if (validated) {
            answerResult.textContent = "Correct!"
            Dealer.addPoints();
        }
        else {
            answerResult.textContent = `Sorry, incorrect. We were looking for: ${correctAnswer}`;
        }
    },

    addPoints : function() {
        var userPointsToAdd  = Math.floor((Math.random() * 11) + 1);

        answerResult.insertAdjacentText("beforeend", ` You received a card worth ${userPointsToAdd} points.`)
        userPoints = userPoints + userPointsToAdd;

        document.getElementById("pointCounter").textContent = `${name}, your current card count is ${userPoints}`;

        if (userPoints > 21){
            gameRunning = false;
            Dealer.determineWin();
        }
    },

    clearTheBoard : function() {
        document.getElementById("categorySelector").className = "deactivatedDiv";
        document.getElementById("questionSocket").className = "deactivatedDiv";
        document.getElementById("answerResult").className = "deactivatedDiv";
        document.getElementById("quizzer").className = "deactivatedDiv";
        document.getElementById("pointCounter").className = "deactivatedDiv";
    }
}



// =============================Loop Objects and related Functions=============================



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

const dataTypesQ1 = {
    question: "Which of the following are NOT a pimitive data type in JavaScript: string, number, bigint, smallint, boolean, symbol, null, undefined",
    answer: "smallint",
}

const dataTypesQ2 = { // +   -   *   /   %   **
    question: "What will Math.floor((4.0 + 6 - (9 / 3)) ** (10 % 3)) evaluate to?",
    answer: "7",
}

const dataTypesQ3 = {
    question: "Assuming that you have num1 = 2 and num2 = 3, cast as strings, what will the result of num3 = num1 + num2 be?",
    answer: "23",
    // Differentiate the use of + to add versus concatenate.
    explanation: "Using + in this context between two strings will concatenate the two strings, not add the two numbers. To add two numbers, at least one number should be cast to a number type using the unary operator + (example: +num1 + num2)" //TODO: add in this portion
}

let dataTypeQuestions = [dataTypesQ1, dataTypesQ2, dataTypesQ3];


const dataTypeQuizzer = {
    askQuestion : function (arrayChoice){
        document.getElementById("questionSocket").className = ("activatedDiv");
        document.getElementById("questionSocket").textContent = dataTypeQuestions[arrayChoice].question;
        document.getElementById("answerSocket").className = "activatedDiv"
    }
}

// =============================Arrays and Related Functions=============================

const arrayQ1 = {
    question: "Given let arr1 = ['football', 'soccer', 'swimming', 'tennis'], how would you access the swimming element?",
    answer: "arr1[2]",
}

const arrayQ2 = { // for
    question: "Suppose you wanted to iterate through each item in array, arr1. What keyword would replace the 'x' in this code? :  x (let key in arr1){ ...code block}",
    answer: "for",
}

const arrayQ3 = {
    question: "Given array arr1 = ['I', 'like', 'JavaScript', 'tons'], what command should be run to delete both 'like' and 'JavaScript'",
    answer: "arr1.splice(1,2)",
}


let arrayQuestions = [arrayQ1, arrayQ2, arrayQ3];

const arrayQuizzer = {
    askQuestion : function (arrayChoice){
        document.getElementById("questionSocket").className = ("activatedDiv");
        document.getElementById("questionSocket").textContent = arrayQuestions[arrayChoice].question;
        document.getElementById("answerSocket").className = "activatedDiv"
    }
}

// =============================Comparisons and Related Functions=============================


// PLEASE NOTE: These are currently hard corded to get the module mock up for the final exam progress. It is intended that the user will at some level enter these numbers in themselves. This will not be submitted hard coded. 


const comparisonsQ1 = {
    question: "What will [(6 < 7) && (10 > 5) || (2 == '2')] return?", // >, <, &&, ||, == 
    answer: "true",
}

const comparisonsQ2 = { // ===, !=, >=, <=, !==
    question: "What will [(6 != '6') && ('a' === 'A') && ('a' !== 'A') || (7 >= 2) || (6 <= 8)] return?",
    answer: "true",
}

const comparisonsQ3 = { // ++, --, +=
    question: "Assume you are running a script, and the following expressions have successfully evaluated. x = 1, y = 2, y++, x--, x += y. What is the final value of x, assuming any increment / decrement operations have ran?",
    answer: 3,
}

let comparisonQuestions = [comparisonsQ1, comparisonsQ2, comparisonsQ3];

const comparisonsQuizzer = {
    askQuestion : function (arrayChoice){
        document.getElementById("questionSocket").className = ("activatedDiv");
        document.getElementById("questionSocket").textContent = comparisonQuestions[arrayChoice].question;
        document.getElementById("answerSocket").className = "activatedDiv"
    }
}

// =============================onclick Assignments=============================
// onclick assignments

// FOR FINAL PROJECT PROGRESS: I'm having a very hard time with addEventListener, fell back to onclick

document.getElementById("userAgreeToStart").onclick = Dealer.loadGameBoard;
document.getElementById("askQuestion").onclick = Dealer.askQuestion;
document.getElementById('userQuizAnswer').onclick = Dealer.gradeAnswer;
document.getElementById('endGame').onclick = Dealer.determineWin;
document.getElementById("tryAgain").onclick = Dealer.loadGameBoard;




// =============================Items Remaining to Code=============================

// document.getElementsByTagName("something3")
// document.querySelectorAll(".something6")

// document.querySelectorAll(".something6")



// use JavaScript to modify images
// Do not allow the user to divide by 0.

// at least 2 images
// 2 media queries
