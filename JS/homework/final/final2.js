"use strict";    // "use strict"

// Robert Daniels, 05/03/2022 Final Project JavaScript File


/**
 * The logic for this script: 
 * 
 * Game Rules (--very-- loosely based on blackjack logic): Player randomly gathers points 1-11 by correctly answering questions from Dealer. Game is decided when Player decides to stop, or Player hand value > 21.
 * The winner (Dealer or Player) is whichever has a point value closest to 21 without going over 21. 
 * 
 * A Dealer object manages the game by interacting with QuizBank and Player objects. 
 * The Dealer sets the webpage and interacts with QuizBank objects to quiz a Player. The Player provides feedback which is
 * captured by the Dealer. The Dealer then progresses the game forward based on that input. 
 * 
 * 
 * User Defined Classes:
 *  
 * 
 * Player: Tracks the user's point totals and information 
 *      Interacts with : Dealer
 * 
 * Dealer: Main game handler
 *      Interacts with : Player, QuizBank-like Objects
 * 
 * QuizBank superclass: Provides question / answer retrieval methods for sub-classes
 *      Interacts with : N/A
 * 
 * LoopQuizBank, DataTypesBank, ArrayQuizBank, ComparisonsQuizBank : extend QuizBank. 
 *      Maintain the question / answer test set and track the user progress
 *      Interacts with : Dealer
 * 
 */



// =============================Establish Starting Variables===================

let name = prompt("Hello! What is your name?", "John Smith");  // window.prompt(), let

if (name){
    alert(`${name}, let's play!`); // window.alert()
} else {
    name = "Challenger";
}

const winThreshold = 21; // const

let instructions = "The rules of this game are simple. Answer questions about JavaScript to push your point value as close to 21 as possible. You win if you get closer to 21 than the dealer without going over. If you go over, you lose. Think you can do it?";




// =============================Introduce the Game=============================

// document.getElementById("something1").textContent
document.getElementById("instructions").textContent = `${name}: ` + instructions; // concatenate





// =============================Player Class===================================

/**
 * Class representing a player of the game. 
 */
class Player {
    /**
     * Player template to track userPoints as an int
     * @param {String} name from window.prompt() 
     */

    constructor(name) {
        this.name = name;
        this.userPoints = 0;
    }

    /**
     * Get user of type Player current point value
     * @returns {number} userPoints: current value of the player's hand
     */

    getPoints() {
        return this.userPoints;
    }

    /**
     * Randomly assigns a card value (1 - 11) to add to a Player hand
     */

    addPoints() {
        var userPointsToAdd  = Math.floor((Math.random() * 11) + 1);
        this.userPoints = this.userPoints + userPointsToAdd;

        // alert user the points added
        answerResult.insertAdjacentText("beforeend", ` You received a card worth ${userPointsToAdd} points.`);
        document.getElementById("pointCounter").textContent = `${name}, your current card count is ${user.getPoints()}`;
    }

    /**
     * Allows direct set of a Player hand point value
     * @param {number} pointValue to set current Player hand to
     */

    setPoints(pointValue) {
        this.userPoints = pointValue;
    }
}

let user = new Player(name);





// =============================Dealer Class===================================

/**
 * Class representing a card dealer. The manager of the game, handles game logic as well as grades user responses. 
 */
class Dealer {

    constructor() {
        this.dealerHand = 0;
        this.currentAnswer = "NoName";
    }

    /**
     * Randomly draws cards and adds to a Dealer's dealerHand until the next card may push over 21. Handicapped
     */
    
    setDealerHand() {
        console.log("setDealerHand ran"); // console.log() to follow and debug your code
        this.dealerHand = 0;

        
        while (this.dealerHand < 11) {   // while
            this.dealerHand = this.dealerHand + Math.floor((Math.random() * 11) + 1); // implement handicap
            console.log(this.dealerHand); 
        }
    }

    /**
     * @returns {number} current value of dealerHand stored in onbject of type Dealer
     */

    getDealerHand() {
        return this.dealerHand;
    }

    /**
     * Sets the game board for play. Clears old progress and clears introduction modules (if any.)
     */

    loadGameBoard() {
        user.setPoints(0);
        dealer.setDealerHand();

        

        var activatedDivArray = ["categorySelector", "quizzer", "pointCounter", "gameBoardDiv"];

        // document.getElementById("something4").className
        for (let i = 0; i < activatedDivArray.length; ++i){   // for
            document.getElementById(activatedDivArray[i]).className = "activatedDiv";
        };


        document.getElementById("answerResult").className = "deactivatedDiv";
        document.getElementById("questionSocket").className = "deactivatedDiv";

        // document.getElementById("something5").classList
        document.getElementById("onboardingDiv").classList.add("deactivatedDiv");

        document.getElementById("title").textContent = "Let's Play!";

        document.getElementById("pointCounter").textContent = `${name}, your current card count is ${user.getPoints()}`;

    }

    /**
     * Updates the current correct answer of a Dealer object based on return from a QuizBank-like object
     * @param {String} correctAnswer as passed from a QuizBank-like object 
     */

    setCurrentAnswer(correctAnswer) {
        this.currentAnswer = correctAnswer;
    }

    /**
     * @returns {String} currentAnswer to the currentQuestion as stored in a Dealer object;
     */

    getCurrentAnswer() {
        return this.currentAnswer;
    }

    /**
     * Removes input divs to prevent unintended user input after game end
     */

    clearTheBoard() {
        var deactivatedDivArray = ["questionSocket", "answerSocket", "quizzer", "pointCounter", "answerResult"];

        for (let i = 0; i < deactivatedDivArray.length; ++i){
            document.getElementById(deactivatedDivArray[i]).className = "deactivatedDiv";
        }

    }
    
    /**
     * Game logic: userPoints > 21, user loses. Winner is the object whose points are closest to 21. Tie, Player wins
     */

    determineWin() {
        console.log("determineWin ran");
        
        // document.getElementById("something2").value
        var titleElement = document.getElementById("tryAgainDiv").value;
        var userPoints = user.getPoints();
        var dealerHand = dealer.getDealerHand();

        dealer.clearTheBoard();  // remove input divs

        // if...else
        if (userPoints >= dealerHand && userPoints < 22) {   //dealerHand throttled to below 21 in dealer.setDealerHand();
            document.getElementById("title").textContent = `Your points: ${userPoints}. Dealer: ${dealerHand}...You win!` ;
        }
        else if (userPoints > 21) {
            document.getElementById("title").textContent = `Your points: ${userPoints}. You've gone over 21. You lose...`;
        }
        else if (userPoints < dealerHand) {
            document.getElementById("title").textContent = `Your points: ${userPoints} Dealer: ${dealerHand}...Dealer wins!`;
        }
        else {
            console.log("something went wrong in determineWin()");
        }
        
        if (titleElement) {
            title.append(document.getElementById("tryAgainDiv"));
        }

    }

    

    /**
     * Based on user selection, asks relevant QuizBank-like object for the next question / answer couple in their data set.  
     */

    askQuestion() {
        console.log("askQuestion() ran");

        var topicChoice = document.getElementById("categorySelector").value;
        var question = "NoName"; 

        // clear the old responses
        document.getElementById("answerResult").textContent = "";
        document.getElementById("userAnswer").value = "";

        // activate the answer html template and append to the socket
        document.getElementById("answerTemplate").className = "activatedDiv";
        answerSocket.append(document.getElementById('answerTemplate'));

        // switch
        switch (topicChoice){ 
            case "loops":
                question = loopQuizzer.getQuestion();
                dealer.setCurrentAnswer(loopQuizzer.getAnswer());
                break;
            case "dataTypes":
                question = dataTypesQuizzer.getQuestion();
                dealer.setCurrentAnswer(dataTypesQuizzer.getAnswer());
                break;
            case "arrays":
                question = arrayQuizzer.getQuestion();
                dealer.setCurrentAnswer(arrayQuizzer.getAnswer());
                break;
            case "comparisons":
                question = comparisonsQuizzer.getQuestion();
                dealer.setCurrentAnswer(comparisonsQuizzer.getAnswer());
                break;
            default:
                console.log("Something went wrong in final.js/askQuestion()");
        }

        document.getElementById("questionSocket").className = ("activatedDiv");
        document.getElementById("questionSocket").textContent = question;
        document.getElementById("answerSocket").className = "activatedDiv";
    }

    /**
     * Decision-gating based on if the user is determined to have answered the question correctly.
     * Short-circuit to determine winner if userPoints exceeds max of 21
     * 
     * @param {Boolean} validated: userAnswer provided is correct (true) or incorrect (false) as determined by Dealer.gradeAnswer(). 
     */

    respondToAnswer(validated) {
        var answerResult = document.getElementById("answerResult");
        
        document.getElementById("answerSocket").className = "deactivatedDiv";

        if (validated) {
            answerResult.textContent = "Correct!"
            user.addPoints();
        }
        else {
            answerResult.textContent = `Sorry, incorrect. We were looking for: ${this.currentAnswer}`;
        }

        if (user.getPoints() > 21){
            dealer.determineWin();
        }
    }
    
    /**
     * Compares userAnswer to answer provided by a QuizBank-like object. Tells a Dealer object how to respond to a userAnswer based on correct / incorrect response. 
     */

    gradeAnswer() {
        console.log("gradeAnswer ran");

        var validated = false;
        var userQuizAnswer = document.getElementById("userAnswer").value;
        var correctAnswer = dealer.getCurrentAnswer();

        document.getElementById("answerResult").className = "activatedDiv";

        if (userQuizAnswer == correctAnswer) {
            validated = true;
            dealer.respondToAnswer(validated);
        }
        else {
            dealer.respondToAnswer(validated);
        }
    }
}

let dealer = new Dealer();





// =============================QuizBank Super Class===========================

/**
 * Provides methods to allow Dealer-type object to retreive a question / answer set 
 */
class QuizBank {

    constructor(){
        this.questionArray = [];
        this.answerArray = [];
        this.questionIndex = 0;
    }

    /**
     * Tracks what question has been asked to prevent the same question multiple times in a row. 
     * #FeatureUpdate: add some randomness, while also ensuring no question duplication
     */

     progressQuestion() {
        if (this.questionIndex < this.questionArray.length - 1){
            this.questionIndex++;
        } 
        else {
            this.questionIndex = 0;
        }
    }

    /**
     * Passes next question to a Dealer object
     * @returns {String} question to ask user 
     */

    getQuestion() {
        console.log(this.questionArray[this.questionIndex]);
        var question = this.questionArray[this.questionIndex];
        
        return question;
    }

    /**
     * Passes answer tied to the current question to a Dealer object
     * @returns {String} answer to grade user against
     */

    getAnswer() {
        var answer = this.answerArray[this.questionIndex];
        answer = answer.toString();
        this.progressQuestion();

        return answer;
    }
}





// =============================LoopQuizBank Class=============================

/**
 * QuizBank-like object that stores questions and related answers related to loops.
 */
class LoopQuizBank extends QuizBank {

    constructor() {
        super();
        this.questionIndex = 0;
        this.questionArray = [  // array
            "If you are trying to end a loop immediately, what keyword would you use?",
            "If you are trying to skip an iteration of a loop, but not exit the loop entirely, what keyword would you use?",
            "Which style of loop would be better if the number of needed iterations is unknown? if or while?",
        ];
        this.answerArray = [
            "break",
            "continue",
            "while",
        ];
    }
}

let loopQuizzer = new LoopQuizBank();





// =============================DataTypesBank Class============================

/**
 * QuizBank-like object that stores questions and related answers related to DataTypes. 
 */
class DataTypesBank extends QuizBank {

    constructor() {
        super();
        this.questionIndex = 0;
        this.questionArray = [
            "Which of the following are NOT a pimitive data type in JavaScript: string, number, bigint, smallint, Boolean, symbol, null, undefined",
            "What will Math.floor((4.0 + 6 - (9 / 3)) ** (10 % 3)) evaluate to?",
            "Assuming that you have num1 = 2 and num2 = 3, cast as strings, what will the result of num3 = num1 + num2 be?", // Differentiate the use of + to add versus concatenate.
        ];
        this.answerArray = [
            "smallint",
            "7",
            "23",
        ];
    }
}

let dataTypesQuizzer = new DataTypesBank();





// =============================ArrayQuizBank Class============================

/**
 * QuizBank-like object that stores questions and related answers related to Arrays. 
 */
class ArrayQuizBank extends QuizBank {

    constructor() {
        super();
        this.questionIndex = 0;
        this.questionArray = [
            "Given let arr1 = ['football', 'soccer', 'swimming', 'tennis'], how would you access the swimming element?",
            "Suppose you wanted to iterate through each item in array, arr1. What keyword would replace the 'x' in this code? :  x (let key in arr1){ ...code block}",
            "Given array arr1 = ['I', 'like', 'JavaScript', 'tons'], what command should be run to delete both 'like' and 'JavaScript'",
        ];
        this.answerArray = [
            "arr1[2]",
            "for",
            "arr1.splice(1,2)",
        ];
    }
}

let arrayQuizzer = new ArrayQuizBank();





// =============================ComparisonsQuizBank Class=============================

// NOTE FOR INSTRUCTOR: Noted that values should not be hard-coded for the final turn in. 
// Created to get the class set. #TODO: Add user interface to enter in values for grading. 
// These are basically placeholders until I figure out how to implement the stated specs. 

/**
 * QuizBank-like object that stores questions and related answers related to comparison operators.
 */

class ComparisonsQuizBank extends QuizBank {

    constructor() {
        super();
        this.questionIndex = 0;
        this.questionArray = [
            "What will [(6 < 7) && (10 > 5) || (2 == '2')] return?",
            "What will [(6 != '6') && ('a' === 'A') && ('a' !== 'A') || (7 >= 2) || (6 <= 8)] return?",
            "Assume you are running a script, and the following expressions have successfully evaluated. x = 1, y = 2, y++, x--, x += y. What is the final value of x, assuming any increment / decrement operations have ran?"
        ];
        this.answerArray = [
            "true",
            "true",
            "3",
        ];
    }
}

let comparisonsQuizzer = new ComparisonsQuizBank();





// =============================eventListeners=================================

document.getElementById("userAgreeToStart").addEventListener("click", dealer.loadGameBoard);
document.getElementById("askQuestion").addEventListener("click", dealer.askQuestion);
document.getElementById('userQuizAnswer').addEventListener("click", dealer.gradeAnswer);
document.getElementById('endGame').addEventListener("click", dealer.determineWin);
document.getElementById("tryAgain").addEventListener("click", dealer.loadGameBoard);





// =============================Remaining Items to code=================================

// document.getElementsByTagName("something3")
// document.querySelectorAll(".something6")
// for
// use JavaScript to modify images
// include ALL of the following operations, conditional operators, and logical operators
// +   -   *   /   %   **
// ==   +=
// ===   !=   !==
// ++    --   
// >   <   >=   <=
// &&   ||
// Do not allow the user to divide by 0.