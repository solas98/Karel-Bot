import stanford.karel.SuperKarel;


public class Homework extends SuperKarel {

    int countSteps = 0;
    public void run() {
        for (int j = 0; j < 1; j++) {
            firstQuarter();
            secondQuarter();
            thirdQuarter();
            fourthQuarter();
            System.out.println("Karel made " + countSteps + " steps");
        }
    }

    public void moveAndPut(){
        for (int i = 0; i <= 3; i++) {
            countSteps++;
            move();
            putBeeper();
        }
    }
    public void firstQuarter() {
        for (int i = 0; i <= 3; i++) {
//            countSteps++;
            move();
        }
        putBeeper();
        turnLeft();
        moveAndPut();
        turnLeft();
        moveAndPut();
        turnFromLeftToRight();
    }

    public void secondQuarter() {
        moveAndPut();
        turnLeft();
        moveAndPut();
        turnRight();
    }

    public void thirdQuarter() {
        move();
        countSteps++;
        putBeeper();
        turnRight();
        moveAndPut();
        turnLeft();
        moveAndPut();
        turnFromLeftToRight();
    }

    public void fourthQuarter() {
        moveAndPut();
        turnLeft();
        moveAndPut();
    }

    public void facingUpColumnRight() {
        moveAndPut();
        turnRight();
    }

    public void facingLeftRow() {
        moveAndPut();
        turnFromLeftToRight();
    }

    public void turnFromLeftToRight() {
        turnRight();
        move();
        countSteps++;
        putBeeper();
        turnLeft();
        turnAround();
    }

}
