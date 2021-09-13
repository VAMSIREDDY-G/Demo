

// this function is used to randomlu generate the computer choice and checks the winner of the match
function code(you)
{
  var systemChoice = Math.floor(Math.random() * 4)

    if (systemChoice===1){
  	   systemChoice = "rock";
    }else if(systemChoice ===2){
  	   systemChoice = "paper";
    }else{ systemChoice = "scissors"; }


    if (you === systemChoice) {
        document.getElementById("res").innerHTML= "It's a Tie!!!";
    } else if (you === "rock"){

        if (systemChoice === "scissors") {
            document.getElementById("res").innerHTML= "You Won the match !!";
        }  else {
            document.getElementById("res").innerHTML= "You Lost the match !!";
        }
    }    else if (you === "paper") {

        if (systemChoice === "rock") {
            document.getElementById("res").innerHTML= "You Won the match !!";
        } else {
            document.getElementById("res").innerHTML= "You Lost the match !!";
        }

    } else if (you=== "scissors") {

        if (systemChoice === "rock") {
            document.getElementById("res").innerHTML= "You Lost the match !!";
        } else {
            document.getElementById("res").innerHTML= "You Won the match !!";
        }
    }

    document.getElementById("compChoice").innerHTML=systemChoice;
  }

  // this function is used to retrieve the button value
  function fun(item) {
    document.getElementById("yourChoice").innerHTML = item.value;
    code(item.value);

  }
