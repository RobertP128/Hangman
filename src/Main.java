import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        String secretWord=new String(Base64.getDecoder().decode("R2VidXJ0c3RhZ3NrdWNoZW4=".getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
        secretWord=secretWord.toUpperCase();

        var scanner = new Scanner(System.in);

        boolean[] charVisible=new boolean[secretWord.length()];
        int retries=7;
        int missingDigits=secretWord.length();
        while (retries>0 && missingDigits>0){
            System.out.print("Geben sie einen Buchstaben ein:");
            var testChar=scanner.next().toUpperCase().charAt(0);

            // check if the char is inside and reveal the characters
            missingDigits=0;
            boolean foundOneChar=false;
            for(int x=0;x<secretWord.length();x++){
                if (secretWord.charAt(x)==testChar){
                    // Reveal the Word
                    charVisible[x]=true;
                    foundOneChar=true;
                }
                if (!charVisible[x]){
                    missingDigits++;
                    System.out.print("_");
                }
                else {
                    System.out.print(secretWord.charAt(x));
                }

            }
            System.out.println();

            if (!foundOneChar){
                retries--;
                System.out.printf("That was wrong.Remaining %d retries\n",retries);
            }



        }

        if (missingDigits>0){
            System.out.println("You have lost!!!!!!!!");
        }
        else {
            System.out.println("Congratulations! You made it!");
        }



    }
}