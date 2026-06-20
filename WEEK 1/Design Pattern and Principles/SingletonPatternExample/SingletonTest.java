public class SingletonTest {
    public static void main(String args[]){
        Logger logger1 =Logger.getInstance();
        logger1.log("first log created");
        Logger logger2 = Logger.getInstance();
        logger2.log("next logger created");

        if(logger1 == logger2){
            System.out.println("both loggers are same");
        }
        else{
            System.out.println("both logger is different");
        }
    }
}
