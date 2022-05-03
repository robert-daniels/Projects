"use strict";    // "use strict"

// Robert Daniels, 05/03/2022 Final Project JavaScript File

// =============================Establish Starting Variables===================
let name = prompt("Hello! What is your name?", "John Smith");  // window.prompt(), let
alert(`${name}, let's play!`) // window.alert()

const winThreshold = 21; // const

let instructions = "The rules of this game are simple. Answer questions about JavaScript to push your point value as close to 21 as possible. You win if you get closer to 21 than the dealer without going over. If you go over, you lose. Think you can do it?"

// =============================Introduce the Game=============================

// document.getElementById("something1").textContent
document.getElementById("instructions").textContent = `${name}: ` + instructions;


// =============================Player Class===================================

/**
 * Class representing a player of the game. 
 */
class Player {
    /**
     * Player template to track userPoints as an int
     * @param {string} name from window.prompt() 
     */

    constructor(name) {
        this.name = name;
        this.userPoints = 0;
    }

    /**
     * Get user of type Player point value
     * @returns {number} userPoints: current value of the player's hand
     */

    getPoints() {
        return this.userPoints;
    }

    /**
     * Randomly assigns a card value (1 - 11) to add to a Player hand
     */

    addPoints() {
        let userPointsToAdd  = Math.floor((Math.random() * 11) + 1);
        this.userPoints = this.userPoints + userPointsToAdd;

        // alert user the points added
        answerResult.insertAdjacentText("beforeend", ` You received a card worth ${userPointsToAdd} points.`)
        document.getElementById("pointCounter").textContent = `${name}, your current card count is ${user.getPoints()}`;
    }

    /**
     * Allows direct set of a Player hand point value
     * @param {number} pointValue as an int 
     */

    setPoints(pointValue) {
        this.userPoints = pointValue;
    }
}

let user = new Player(name);

// =============================Dealer Class===================================

/**
 * Class representing a dealer that is running the game. The main engine of the game, handles game logic * as well as grades user responses. 
 */
class Dealer {
    /**
     * Dealer template for the game engine
     */

    constructor() {
        this.dealerHand = 0;
        this.isGameRunning = true;
        this.currentAnswer = "NoName";
    }

    /**
     * Randomly draws cards and adds to a Dealer's dealerHand until the next card would push over 21
     */
    
    setDealerHand() {
        console.log("setDealerHand ran") // console.log() to follow and debug your code
        this.dealerHand = 0

        // while
        while (this.dealerHand < 11) {  
            this.dealerHand = this.dealerHand + Math.floor((Math.random() * 11) + 1);
            console.log(this.dealerHand) 
        }
    }

    /**
     * @returns {number} current value of an object of type Dealer dealerHand
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

        // should likely be selected by a querySelectorAll

        // document.getElementById("something4").className
        document.getElementById("categorySelector").className = "activatedDiv";
        document.getElementById("quizzer").className = "activatedDiv";
        document.getElementById("pointCounter").className = "activatedDiv";
        document.getElementById("questionSocket").className = "deactivatedDiv";
        document.getElementById("gameBoardDiv").className = "activatedDiv";
        document.getElementById("answerResult").className = "deactivatedDiv";

        // document.getElementById("something5").classList
        document.getElementById("onboardingDiv").classList.add("deactivatedDiv");

        document.getElementById("title").textContent = "Let's Play!"

        document.getElementById("pointCounter").textContent = `${name}, your current card count is ${user.getPoints()}`;

    }

    /**
     * Updates the current correct answer of a Dealer object based on responses from a QuizBank-like object
     * @param {string} correctAnswer as passed from a QuizBank-like object 
     */

    setCurrentAnswer(correctAnswer) {
        this.currentAnswer = correctAnswer;
    }

    /**
     * @returns {string} currentAnswer as defined in a Dealer object;
     */

    getCurrentAnswer() {
        return this.currentAnswer;
    }
    
    /**
     * Clears the game board and determine winner. Game logic: userPoints > 21, user loses. Winner is the object whose points are closest to 21
     */

    determineWin() {
        console.log("determineWin ran");
        
        // document.getElementById("something2").value
        var titleElement = document.getElementById("tryAgainDiv").value
        var userPoints = user.getPoints();
        var dealerHand = dealer.getDealerHand();

        document.getElementById("questionSocket").className = "deactivatedDiv";
        document.getElementById("answerSocket").className = "deactivatedDiv";
        document.getElementById("quizzer").className = "deactivatedDiv";
        document.getElementById("pointCounter").className = "deactivatedDiv";
        document.getElementById("answerResult").className = "deactivatedDiv";


        // if...else
        if (userPoints >= dealerHand && userPoints < 22) {
            console.log("user won ran");
            document.getElementById("title").textContent = `Your points: ${userPoints}. Dealer: ${dealerHand}...You win!` 
        }
        else if (userPoints > 21) {
            console.log("user over ran");
            document.getElementById("title").textContent = `Your points: ${userPoints}. You've gone over 21. You lose...`
        }
        else if (userPoints < dealerHand){
            console.log("dealer won ran");
            document.getElementById("title").textContent = `Your points: ${userPoints} Dealer: ${dealerHand}...Dealer wins!`
        }
        else {
            console.log("something went wrong in determineWin()");
        }
        
        if (titleElement) {
            title.append(document.getElementById("tryAgainDiv"))
        }

    }

    /**
     * Based on user selection, asks relevant QuizBank-like object for the next question / answer couple in the data set.  
     */

    askQuestion() {
        console.log("askQuestion() ran")

        var topicChoice = document.getElementById("categorySelector").value;
        var question = "NoName"; 

        // clear the old responses
        document.getElementById("answerResult").textContent = "";
        document.getElementById("userAnswer").value = "";

        // activate the answer template and append to the socket
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
        document.getElementById("answerSocket").className = "activatedDiv"
    }

    /**
     * Decision-gating based on if the user is determined to have answered the question correctly.
     * Instructs a Player object to addPoints() if and only if userAnswer matches answer provided by a QuizBank-like object. Short-circuit to determine winner if userPoints exceeds max of 21
     * 
     * @param {Boolean} validated: userAnswer provided is correct (true) or incorrect (false) as determined by Dealer.gradeAnswer(). 
     */

    respondToAnswer(validated) {
        let answerResult = document.getElementById("answerResult")
        
        document.getElementById("answerSocket").className = "deactivatedDiv";

        if (validated) {
            answerResult.textContent = "Correct!"
            user.addPoints();
        }
        else {
            answerResult.textContent = `Sorry, incorrect. We were looking for: ${this.currentAnswer}`;
        }

        if (user.getPoints() > 21){
            this.gameRunning = false;
            dealer.determineWin();
        }
    }
    
    /**
     * Compares userAnswer to answer provided by a QuizBank-like object. Tells a Dealer object how to respond to a userAnswer based on correct / incorrect response. 
     */

    gradeAnswer() {
        console.log("gradeAnswer ran");

        let validated = false;
        let userQuizAnswer = document.getElementById("userAnswer").value;
        let correctAnswer = dealer.getCurrentAnswer();

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
        console.log(this.questionArray[this.questionIndex])
        var question = this.questionArray[this.questionIndex]
        
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

        return answer
    }
}

// =============================LoopQuizBank Class=============================

/**
 * QuizBank-like object that stores questions related to loops. #refactor: add methods to add additional questions / answers. 
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
 * QuizBank-like object that stores questions related to DataTypes. #refactor: add methods to add additional questions / answers. 
 */
class DataTypesBank extends QuizBank {

    constructor() {
        super();
        this.questionIndex = 0;
        this.questionArray = [
            "Which of the following are NOT a pimitive data type in JavaScript: string, number, bigint, smallint, boolean, symbol, null, undefined",
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
 * QuizBank-like object that stores questions related to Arrays. #refactor: add methods to add additional questions / answers. 
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

//NOTE FOR INSTRUCTOR: Noted that values should not be hard-coded for the final turn in. Created to get the class set. #TODO: Add user interface to enter in values for grading

/**
 * QuizBank-like object that stores questions related to comparison operators. #refactor: add methods to add additional questions / answers. 
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



// =============================onclick Assignments=================================
// onclick assignment, was having a hard time with eventListener, fell back on alternative

document.getElementById("userAgreeToStart").onclick = dealer.loadGameBoard;
document.getElementById("askQuestion").onclick = dealer.askQuestion;
document.getElementById('userQuizAnswer').onclick = dealer.gradeAnswer;
document.getElementById('endGame').onclick = dealer.determineWin;
document.getElementById("tryAgain").onclick = dealer.loadGameBoard;



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