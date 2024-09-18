import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        System.out.print("Digite um numro: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println("-------------------------");
        Integer Respost = n;
        System.out.print("O valor do numero convertido é: " + Respost);
    }
}

