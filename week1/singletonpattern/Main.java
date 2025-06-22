public class Main {
    public static void main(String[] args) {
        Logger log1 = Logger.getInstance();
        log1.log("Log message-1.");

        Logger log2 = Logger.getInstance();
        log2.log("Log message-2.");

        if(log1 == log2){
            System.out.println("Both log1 and log2 are the same instance.");
        }else{
            System.out.println("Different instances exist!");
        }
    }
}
