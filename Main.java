import java.io.*;
import java.util.Scanner;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws InterruptedException{
        Inside d =new Inside();
        Duplicate e = new Duplicate();
        d.welcome();
        e.checkpin();
    }

}
class Inside {
    public void welcome() {
        String welcome = "                                ...=>>==> Welcome To your Account <==<<-...";
        final String[] COLORS = {
                "\033[0;33m",  // Yellow
                "\033[0;31m",
                "\033[0;32m",  // Green
                "\033[0;36m",  // Cyan
                "\033[0;34m",  // Blue
                "\033[0;35m",// Purple
        };
        final String RESET = "\033[0m";
        String text = welcome;
        System.out.println(" ");
        for (int i = 0; i < text.length(); i++) {
            System.out.print(COLORS[i % COLORS.length] + text.charAt(i));
        }
        System.out.println("\n");
    }

    public String red(String r) {

        final String RESET = "\033[0m";
        final String RED = "\033[0;31m";
        System.out.println(RED + r + RESET);
        return r;
    }

    public String GREEN(String g) {
        final String RESET = "\033[0m";
        final String GREEN = "\033[0;32m";
        System.out.println(GREEN + g + RESET);
        return g;
    }

    public String yellow(String i) {
        final String RESET = "\033[0m";
        final String YELLOW = "\033[0;33m";
        System.out.print(YELLOW + i + RESET);
        return i;
    }
}


    class Duplicate extends Inside {
        int pin = 1234;

        public void checkpin() {
            String p=("Enter your pin: ");
            yellow(p);
            Scanner sc = new Scanner(System.in);
            int enteredpin = sc.nextInt();
            if (enteredpin == pin) {
                Menu();
            } else {
                String r = ("!!! INVALID PIN !!!");
                red(r);

            }
        }

        float Balance = 0;
        float add;

        public void Balance() {
            String filePath = "data.txt";

            try {
                File file = new File("data.txt");
                Scanner scanner = new Scanner(file);
                String b=("Current Balance: ");
                    if (scanner.hasNextFloat()) {
                        Balance = scanner.nextFloat();
                        yellow(b);
                        System.out.println( Balance);
                    } else {
                        scanner.next();
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + filePath);
                e.printStackTrace();
            }
            Menu();

        }


        public void AddMoney() {
            String i = ("Enter Ammount: ");
            yellow(i);
            Scanner sc = new Scanner(System.in);
            add = sc.nextFloat();
            Balance = Balance + add;
            String added = ("..Money addead Successfully !!");
            GREEN(added);
            String filePath = "data.txt";


            try {
                FileWriter writer = new FileWriter("data.txt");
                writer.write(Balance + "\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Menu();

        }

        public void WithdrawMoney() {
            String w=("Money Ammount: ");
            yellow(w);
            Scanner sc = new Scanner(System.in);
            float ammount = sc.nextFloat();
            if (Balance < ammount) {
                String Ins = ("Insufficient Balance");
                red(Ins);
            } else {
                Balance = Balance - ammount;
                String deposited = ("..Money Withdrawal Successfully !!");
                GREEN(deposited);
                String filePath = "data.txt";

                try {
                    FileWriter writer = new FileWriter("data.txt");
                    writer.write(Balance + "\n");
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            Menu();
        }

        public void Menu() {
            String CYAN = "\033[0;36m";
            final String RESET = "\033[0m";
            final String YELLOW = "\033[0;33m";
            final String PURPLE = "\033[0;35m";
            final String BLUE = "\033[0;34m";
            final String RED = "\033[0;31m";
            System.out.println("   ");
            System.out.println(PURPLE + "      < - - - - |OPTIONS| - - - - >  " + RESET);
            System.out.println(PURPLE + "             -->         <--         ");

            System.out.println(YELLOW + "1. check Balance     " + "    2. Add Money" + YELLOW);
            System.out.println(YELLOW + "          3. Withdraw Money             " + YELLOW);
            System.out.println(RED + "              ╔══ ═══ ═╗                 " + RESET);
            System.out.println(RED + "              ║ 4.EXIT ║                 " + RESET);
            System.out.println(RED + "              ╚══ ═══ ═╝                 " + RESET);

            System.out.print(YELLOW + "Enter Your Choice: " + RESET);
            Scanner c = new Scanner(System.in);
            int opt = c.nextInt();
            if (opt == 1) {
                Balance();
            }
            if (opt == 2) {
                AddMoney();
            }
            if (opt == 3) {
                WithdrawMoney();
            }
            if (opt == 4) {
                return;
            }

        }
    }
