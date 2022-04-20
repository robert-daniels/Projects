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

document.getElementById("startCalc").onclick = calcSelector;

