import java.util.Scanner;

interface Voter{
    void validAge();
    private void box(){
        System.out.println("hi");
    }
    default void name(){
        box();
        System.out.println("Tanmay");
    }
}

class ECIndia implements Voter {
    public void validAge() {
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        if(age < 18){
            throw new InvalidVoterException("Voter is below the valid age");
        }
    }

    public void name() {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println(name);
    }
}


class InvalidVoterException extends RuntimeException{
    public InvalidVoterException(String msg){
        super(msg);
    }
}
// interface temp{
//     void makeSound();
// }
// interface temp{
//     void makeNoise();
// }

public class Interfcaes {
    public static void main(String[] args) {
        ECIndia i = new ECIndia();
        try{
            i.validAge();
        } catch(InvalidOperationException e){
            System.out.println(e);
        }
    }
    
}