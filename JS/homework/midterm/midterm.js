// Robert Daniels, 4/20/2022

// The specified concepts for the project may be found below:

// 1. How JavaScript evaluates user data with expressions: @see function runMath(). For modulo @see convertToBinary()
// 2. How JavaScript differentiates between =, ==. ===: @see function runMath(). Values are compared both with strict equality ===, as well as ==. = is seen as an assignment throughout
// 3. How JavaScript uses PEMDAS. @see tvmCalc(form) for a standard involved order of operations equation. 

// ==================================================

// Turns on the appropriate div for the module requested. If any tools are currently visible, set to hidden before running. 

function calcSelector() {

    let calcChoiceAnswer = document.getElementById("calcChoice").value;

    // if any modules are currently displayed, hide them. #refactor: hard to maintain. Just have the div clear itself before running. 

    document.getElementById("tvmDiv").style.display = "none";
    document.getElementById("mathDiv").style.display = "none";
    document.getElementById("binaryConvertDiv").style.display = "none";

    // "turn on the requested module"

    if (calcChoiceAnswer == "timeValue"){
        document.getElementById("tvmDiv").style.display = "inline";
    }
    else if (calcChoiceAnswer == "basicMath"){
        document.getElementById("mathDiv").style.display = "inline";
    }
    else if (calcChoiceAnswer == "binaryConvert"){
        document.getElementById("binaryConvertDiv").style.display = "inline";
    }
    else {
        alert("Something went wrong");
    }
}

// ==================================================

// Runs the basic arithmetic functions requested with basic math module

function runMath() {
    // Similar structure to seed file provided. No data sanitation / error checking for nonsensical user inputs.

    let operationChoice = document.getElementById("mathOperator").value;

    let localNum1 = +document.getElementById("num1").value;
    let localNum2 = +document.getElementById("num2").value;

    let result = '';

    if (operationChoice === "add"){
        result = localNum1 + localNum2;
    }
    else if (operationChoice === "subtract"){
        result = localNum1 - localNum2;
    }
    else if (operationChoice === "multiply"){
        result = localNum1 * localNum2;
    }
    else if (operationChoice === "divide"){
        result = localNum1 / localNum2;
    }
    else if (operationChoice === "exponent"){
        result = localNum1 ** localNum2;
    }

    // added only to show == usage. Compares a number to a string
    if (localNum1 == "2"){
        console.log("The first number is 2.");
    }

    // updates p tag at the end of mathDiv with result
    //pulls to 2 decimal points to correct for machine precision
    document.getElementById("mathAnswer").textContent = "$" + result.toFixed(2);
}

// ==================================================

// Calculates future value of money. A more involved calculator would check for the missing value and run appropriately. 
// Unpacks the form object passed to it and assigns to local variables 

function tvmCalc(form){
    let presentValue = form.presentValue.value;
    let interestRate = form.interestRate.value;
    let periodsPerYear = form.periodsPerYear.value;
    let years = form.years.value;

    let futureValue = -presentValue * ((1 + (interestRate / periodsPerYear))**(periodsPerYear * years))
    futureValue = futureValue.toFixed(2);

    document.getElementById("tvmAnswer").textContent = "$" + futureValue;

}

// ==================================================


// Prints the binary representation of a number as a continuous string

function convertToBinary(){
    let quotient = Math.round(document.getElementById("userNum").value);
    let remainder = '';
    let remainderArray = [];
    let binaryAnswer = '';

    while (quotient != 0){
        remainder = quotient % 2;
        remainderArray.push(remainder);
        quotient = Math.floor(quotient / 2);
    }

    let binaryAnswerArray = remainderArray.reverse();
    
    for (let i = 0; i < binaryAnswerArray.length; ++i){
        binaryAnswer = binaryAnswer + binaryAnswerArray[i];
    }

    document.getElementById("binaryAnswer").textContent = binaryAnswer;
   
}

// ==================================================


// onclick assignments

// choose method to run
document.getElementById("startCalc").onclick = calcSelector;

// calculate basic math
document.getElementById("mathCalculate").onclick = runMath;

// convert to binary

document.getElementById("binaryCalc").onclick = convertToBinary;
