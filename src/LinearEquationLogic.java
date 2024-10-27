import java.util.Scanner;

public class LinearEquationLogic {
    private Scanner myScanner ;
    private LinearEquation equation;
    private boolean continueRunning;

    public LinearEquationLogic(){
        this.equation = null;
        myScanner = new Scanner(System.in);
        continueRunning = true;
    }
    public void start() {
        System.out.println("Welcome to the linear equation calculator!");
        while (continueRunning) {
            getInfo();
            if (Double.isNaN(equation.slope())){
                System.out.print("Would you like to enter another pair of coordinates? y/n: ");
                String answer = myScanner.nextLine();
                if (answer.equals("n")) {
                    System.out.println("Thank you for using the slope calculator, goodbye!");
                    continueRunning = false;
                }
            } else {
                updateInfo();
                System.out.print("Would you like to enter another pair of coordinates? y/n: ");
                String answer = myScanner.nextLine();
                if (answer.equals("n")) {
                    System.out.println("Thank you for using the slope calculator, goodbye!");
                    continueRunning = false;
                }
            }
        }
    }


    private void getInfo(){

        System.out.print("Enter the first coordinate: "); // (6, 7)
        String c1 = myScanner.nextLine();

        System.out.print("Enter the second coordinate: ");
        String c2 = myScanner.nextLine();
        System.out.println();

        String first = c1.substring((c1.indexOf("(") + 1), (c1.indexOf(",")));
        String second = c1.substring((c1.indexOf(",") + 2), (c1.indexOf(")")));
        int oneAsInt = Integer.parseInt(first);
        int twoAsInt = Integer.parseInt(second);

        String three = c2.substring((c2.indexOf("(") + 1), (c2.indexOf(",")));
        String four = c2.substring((c2.indexOf(",") + 2), (c2.indexOf(")")));
        int threeAsInt = Integer.parseInt(three);
        int fourAsInt = Integer.parseInt(four);

        equation = new LinearEquation(oneAsInt, twoAsInt, threeAsInt, fourAsInt);
        System.out.println(equation.lineInfo());
    }

    private void updateInfo(){
        System.out.print("Enter an x-coordinate: ");
        double x = myScanner.nextDouble();
        System.out.println(equation.coordinateForX(x));
        myScanner.nextLine();
    }

}
