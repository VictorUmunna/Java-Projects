import java.util.Scanner;

public class QuizGameProject {
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int score = 0;
        int totalQuestions = 5;


        // Define questions, options and correct answers
        String[] questions = {
            "What is the chemical symbol for water?",
            "Who wrote the novel 'To Kill a Mockingbird'?",
            "Which planet is known as the 'Red Planet'?",
            "What is the capital city of Japan?",
            "Who painted the famous artwork 'Starry Night'?"
        };

        String[][] options = {
            {"A. H2O", "B. CO2", "C. NaCl", "D. O2"},
            {"A. Ernest Hemingway", "B. Harper Lee", "C. F. Scott Fitzgerald", "D. J.D. Salinger"},
            {"A. Earth", "B. Mars", "C. Venus", "D. Jupiter"},
            {"A. Seoul", "B. Beijing", "C. Tokyo", "D. Bangkok"},
            {"A. Vincent van Gogh", "B. Pablo Picasso", "C. Leonardo da Vinci", "D. Michelangelo"}
        };

        
        String[] correctAnswer = {"A", "B", "B", "C", "A"};

        // Loop through each question
        for (int i = 0;  i < totalQuestions; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);

            // Display options using switch statement
            switch(i) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                    for (int j = 0; j < 4; j++) {
                        System.out.println(options[i][j]);
                    }
                    break;
                default:
                System.out.println("Options not available for this question.");
            }

            // Get user input (answer)
            String userAnswer;
            boolean isValidInput;

            do {

                System.out.print("Enter your answer (A, B, C or D): ");
                userAnswer = scanner.nextLine().toUpperCase();

                // Check for valid input (A, B, C or D)
                isValidInput = userAnswer.equals("A") || userAnswer.equals("B") || userAnswer.equals("C") || userAnswer.equals("D");
                if(!isValidInput) {
                    System.out.println("Invalid input. Please enter A, B, C or D.");
                }
            } while (!isValidInput); // Repeat until valid input is provided

            // Check answer
            if(userAnswer.equals(correctAnswer[i])) {
                score++;
                System.out.println("Answer is correct");
                
            } else {
                System.out.println("Incorrect! The correct answer is "+ correctAnswer[i] + ".");
            }
            System.out.println(); // Add a new line after each question
        }

        
        //Calculate and display final score
        double finalScore = (double) score / totalQuestions * 100;
        System.out.println("Your total score is: " + score + "/" + totalQuestions);
        System.out.println("Your final score percentage is " + finalScore + "%.");

        scanner.close(); // Close the Scanner resource
    }
        
}
