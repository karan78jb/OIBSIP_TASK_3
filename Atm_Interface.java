package task_3;

import task3.user;
import java.util.*;

class user {

    int money = 0;
    ArrayList<String> history = new ArrayList<String>();

    public void transaction_history() {
        if (history.size() > 0) {
            for (int i = 0; i < history.size(); i++) {
                System.out.println(history.get(i));
            }
        } else {
            System.out.println("Not history available...");

        }
    }

    public void withdraw() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the amount for Withdraw :");
        int n = scan.nextInt();
        if (n > money) {
            System.out.println("Withdraw amount is larger then your balance");
        } else {
            money = money - n;
            System.out.println("Successfully Withdraw " + n + " amount");
            history.add("Withdraw " + n + " amount");
        }
    }

    public void deposite() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the amount for Deposit :");
        int n1 = scan.nextInt();
        money = money + n1;
        System.out.println("Successfully Deposit " + n1 + " amount");
        history.add("Deposit " + n1 + " amount");
    }

    public int[] tranfer(ArrayList<String> array) {
        Scanner scan = new Scanner(System.in);
        int a[] = new int[2], k = 0;
        System.out.println("Enter the receiver id :");
        String n3 = scan.next();
        System.out.println("Enter  transfer money :");
        int n2 = scan.nextInt();

        if (n2 > money) {
            System.out.println("Not enough balance for tranfer ");
        } else {
            money = money - n2;
            System.out.println("Successfully Tranfer " + n3 + " amount");
            history.add("Transfer " + n3 + " amount to " + n2 + " account");
            for (int i = 0; i < array.size(); i++) {
                if ((array.get(i)).equals(n3)) {
                    k = i;
                    break;
                }
            }
            a[0] = k;
            a[1] = n2;
            return a;
        }
        for (int i = 0; i < array.size(); i++) {
            if ((array.get(i)).equals(n3)) {
                k = i;
                break;
            }
        }
        a[0] = k;
        a[1] = 0;
        return a;
    }

    public void balance() {
        System.out.println("Available Balance is : " + money);
    }
}

public class Atm_Interface {

    public static void login() {

        ArrayList<String> array = new ArrayList<String>();
        array.add("karan_12");
        array.add("arjun@");
        array.add("vivek_34");
        ArrayList<String> array1 = new ArrayList<String>();
        array1.add("1254");
        array1.add("2222");
        array1.add("4521");
        user[] customer = new user[3];
        customer[0] = new user();
        customer[1] = new user();
        customer[2] = new user();
        Scanner scan = new Scanner(System.in);
        while (true) {
            lable_1:
            {
                System.out.println("********Login your self :-********");
                System.out.println("Enter user_id :-");
                String log_id = scan.next();
                System.out.println("Enter 4 digit user_pin :-");
                int log_pin = scan.nextInt();
                String s1 = String.valueOf(log_pin);
                boolean b = false;
                for (int i = 0; i < array.size(); i++) {
                    if (array.get(i).equals(log_id) && array1.get(i).equals(s1)) {
                        b = true;
                        while (true) {
                            System.out.println("\nChoose :- \n1: Transaction History\n2: Withdraw\n3: Deposit\n4: Tranfer\n5: Check balance\n6: Another Login\n7: quit");
                            int p = scan.nextInt();
                            switch (p) {
                                case 1:
                                    customer[i].transaction_history();
                                    break;
                                case 2:
                                    customer[i].withdraw();
                                    break;
                                case 3:
                                    customer[i].deposite();
                                    break;
                                case 4:
                                    int a[] = customer[i].tranfer(array);
                                    customer[a[0]].money = customer[a[0]].money + a[1];
                                    break;
                                case 5:
                                    customer[i].balance();
                                    break;
                                case 6:
                                    break lable_1;
                                case 7:
                                    return;
                                default:
                                    System.out.println("Not valid number..");
                            }
                        }
                    }
                }
                if (!b) {
                    System.out.println("Id or Password is Wrong...");
                    break lable_1;
                }
            }
        }
    }

    public static void main(String[] args) {

        login();
    }
}
