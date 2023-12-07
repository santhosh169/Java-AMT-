import java.util.*;

 // @Author SANTHOSH 
class process{
  private String pin;
  private  int amount;
    Scanner sc = new Scanner(System.in);
    process(String pin,int amount){
        this.pin=pin;
        this.amount=amount;
    }
/*Create a function to perform as withdraw*/

    void widthdrawn() {
 
/*Using Collections to store the PIN and AMOUNT for the Individual users*/
    HashMap<String,Integer>amt=new HashMap<>();
        amt.put("2345",5004);
        amt.put("1234", 234);
        amt.put("3456",3456);
       int curbal=amt.get(pin);
       int bal=curbal-amount;
       if(bal<0)
           System.out.println("Insufficient balance");
       else {
           amt.replace(pin,bal);
           System.out.println("RS:"+amount+",withdrawn Successfully");
           System.out.println("your Current Balance="+bal);
       }
    }
}
/*Main class of the program */
class atm {
    static String pin;
    static int amount;
    
/* In this method can to check the PIN in Boolean */
    public static boolean pinno() {
        Scanner sc = new Scanner(System.in);
        String pin_no[] = {"1234", "2345", "3456", "2232"};
        System.out.println("ENTER THE PIN NUMBER");
        String pin = sc.nextLine();
        if (pin.length() == 4) {
            for (int i = 0; i < 3; i++) {
                if (pin_no[i].equals(pin)) {
                    atm.pin = pin;
                    return true;
                }
            }
            System.out.println("No user found..!!");
            return false;
        }
        System.out.println("Invalid Pin");
        return false;
    }
/*Welcome to User*/
    static void Welcome() {
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO AB ATM \n Insert your card");
        int f = 0;
        for (int i = 0; i < 3; i++) {
            if (pinno()) {
                f = 1;
                break;
            }
        }
        if (f == 0) {
            System.out.println("Too many times");
            return;
        }
        
        System.out.println("ENTER THE AMOUNT TO WITHDRAW");
        int amount = sc.nextInt();
        process a = new process(atm.pin, amount);
        a.widthdrawn();
    }
/*Main method of the program call all the methods*/

    public static void main(String[] args) {
        Welcome();
        Scanner sc=new Scanner(System.in);
        System.out.println("Press 5 to Exit,IF you want to continue Press 1");
        int ex= sc.nextInt();
        if(ex==1){
            Welcome();
        }
        else
            return;
    }
}