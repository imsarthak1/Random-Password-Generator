import java.util.Random;
import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step -1 : ask the user how many passwords they want:
        System.out.println("Enter the no of passwords you want :");
        int  passNum = sc.nextInt();
        // Step - 2 : how long the passwords should be:
        System.out.println("How long the passwords should be :");
        int length = sc.nextInt();
        
        while(passNum>0){
            char pass[] = new char[length];
            generate(pass, length);
            print(pass);
            System.out.println();
            strengthCheck(pass);
            System.out.println();
            passNum--;
        }
        sc.close();
    }
    public static char randomNum(){
        Random r = new Random();
        // random number from 33 - 126;
        // and the random number is converted into its ascii value
        char rand =(char) (r.nextInt(93)+33);   
        return rand; 
    }
    public static void generate(char pass[],int length){
        int i = 0;
        while(i<length){
            pass[i] = randomNum();
            i++;
        }
    }
    public static void print(char pass[]){
        for (int i = 0; i < pass.length; i++) {
            System.out.print(pass[i]+"");
        }
    }
    public static void strengthCheck(char pass[]){
        int isUpChar = 0;
        int isLowChar = 0;
        int isSpecial = 0;
        int isDigit = 0;
        for (int i = 0; i < pass.length; i++) {
            if(Character.isUpperCase(pass[i]))
                isUpChar = 1;
            if(Character.isLowerCase(pass[i]))
                isLowChar = 1;
            if(Character.isDigit(pass[i]))
                isDigit = 1;
            else{
                isSpecial = 1;
            }
        }
        if(isUpChar==1||isDigit==1||isLowChar==1||isSpecial==1)
            System.out.println("Very Strong Password");
        else if(isUpChar==1||isLowChar==1||isSpecial==1)
            System.out.println("Strong Password");
        else if(isUpChar==1||isLowChar==1)
            System.out.println("Weak Password");
        else{
            System.out.println("Very Weak Password");
        }
    }
}