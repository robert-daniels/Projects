// Robert Daniels, 4/20/2022

// fx that will turn on the appropriate div for the calculation requested

function calcSelector() {

    let calcChoiceAnswer = document.getElementById("calcChoice").value;
    
    // I realize this is very sloppy. Should probably just set the workArea Div to clear it's contents and then pulling the correct calc landing page into it. 
    document.getElementById("tvmDiv").style.display = "none";
    document.getElementById("mathDiv").style.display = "none";
    document.getElementById("binaryConvertDiv").style.display = "none";

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

// runs the basic arithmetic functions requested under basic math

function runMath() {
    // similar structure to seed file provided. No data sanitation / error checking for nonsensical user inputs.

    let operationChoice = document.getElementById("mathOperator").value;

    let localNum1 = +document.getElementById("num1").value;
    let localNum2 = +document.getElementById("num2").value;

    let result = '';

    // REQUIREMENT 1: evaluate user data AND REQUIREMENT 2, =, ==, ===
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

    // updates p tag at the end of mathDiv with result
    //pulls to 2 decimal points to correct for machine precision
    document.getElementById("mathAnswer").textContent = "$" + result.toFixed(2);

    
}

// calculates future value of money. REQUIREMENT 3: PEMDAS

function tvmCalc(form){
    let presentValue = form.presentValue.value;
    let interestRate = form.interestRate.value;
    let periodsPerYear = form.periodsPerYear.value;
    let years = form.years.value;

    let futureValue = presentValue * ((1 + (interestRate / periodsPerYear))**(periodsPerYear * years))
    futureValue = futureValue.toFixed(2);

    document.getElementById("tvmAnswer").textContent = "$" + futureValue;

}


// onclick assignments

// choose method to run
document.getElementById("startCalc").onclick = calcSelector;

// calculate basic math
document.getElementById("mathCalculate").onclick = runMath;

