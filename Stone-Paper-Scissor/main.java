import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); //Creating Scanner Object to get user input

        int computer,user=0,computer_score=0,user_score=0,draw=0; // Assigning Variable ( Note:- don't forget to initialize the varible before using)
        boolean error=false;// Assigning Varibale for error detection
        String random="",user_in="",result=""; // Assigning Variable ( Note:- don't forget to initialize the varible before using)
        
        System.out.println("Game Started please input your prefrence\neg:- Stone, Paper, Scissor: "); // Printing a msg to make user ready for the game and to enter the correct input as mention
        
        while(!user_in.equals("end")){ // Adding a while loop to play multiple time until use input end
        
            user_in = in.next(); // Taking input by user in String
            user_in = user_in.toLowerCase(); //Converting input into lower case for proper evaluation
            if (user_in.equals("end")){
                System.out.println("Game ended. Thanks for playing!");
                break;
            }
            // Assigning Values according to users the input with the help of Condition statement + .equals("word")
                if (user_in.equals("stone"))
                user = 0;
                else if (user_in.equals("paper"))
                    user = 1;
                else if (user_in.equals("scissor"))
                    user = 2;
                else
                    error = true; // Adding error detection logic for unknow input by users


                if (!error){ //Using Condition statement if to run only when no error detects 
                    computer = (int)(Math.random()*3); //Generating a Random value between 0-2

                    // Assigning Stone,Paper,Scissor Values with the help of Condition statement to Display Computer inputs
                    if (computer == 0)
                    random = "Stone";
                    else if (computer == 1)
                        random = "Paper";
                    else if (computer == 2)
                        random = "Scissor";
                    
                    if (computer==user){//To display draw result if both user and computer enter same input
                        result = "Draw..";
                        draw++; 
                    }

                    //Assigning the logics of Winning and incrementing user score 
                    else if(computer==0&&user==1){
                        result = "You Won!! :)";
                        user_score++; 
                    }
                    else if(computer==1&&user==2){
                        result = "You Won!! :)";
                        user_score++; 
                    }
                    else if(computer==2&&user==0){
                        result = "You Won!! :)";
                        user_score++; 
                    }
                    //Assigning the logics of Lossing and increamenting computer score
                    else if(user==0&&computer==1){
                        result = "You Loss :(";
                        computer_score++;
                    } 
                    else if(user==1&&computer==2){
                        result = "You Loss :(";
                        computer_score++;
                    } 
                    else if(user==2&&computer==0){
                        result = "You Loss :(";
                        computer_score++;
                    } 

                    //Printing the Results
                    System.out.println("Your Choice: " +user_in);
                    System.out.println("Computer Choice: " +random);
                    System.out.println("Result: "+result);
                    System.out.println("Total Score  User: "+user_score+" Computer Score: "+computer_score+" Draws: "+draw);
                    System.out.println("\n\nNew game started if you wanna play enter the correct input\nIf you want to end this game type END and press enter ");
                        }
                else //Adding else Statement when error detect print this response
                    System.out.println("You must enter the correct input, eg:-Stone, Paper, Scissor");
                    error = false;
        }
    }
}
