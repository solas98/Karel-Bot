import stanford.karel.SuperKarel;


public class Homework extends SuperKarel {


    public int countX = 0;
    public int countY = 0;
    public int resultX;
    public int resultY;

    public int countSteps = 0;

    public void run() {
        testXAxis();
        returnHome();
        testYAxis();
        System.out.println("---------------");
        countSteps = 0;
    }
    //Count Steps Function
    public void countKarelSteps() {
        countSteps++;
        System.out.println("Karel made :" + countSteps + " steps");
    }

    //Check the X Axis for the middle points.
    public void testXAxis() {
        //for small maps that divide in less than 4 sections
        if (frontIsBlocked()) {
            return;
        }
        //Count  X
        while (frontIsClear()) {
            moveAndCountSteps();
            countX++;
        }
        //Check for 2 specific situations
        if (countX == 1 || countX == 0) {
            countX = 0;
            return;
        } else if (countX == 2) {
            turnAround();
            moveAndCountSteps();
            putBeeper();
            turnRight();
            moveAndPut();
            countX = 0;
            return;
        }
        //Checking Odd or Even X number and Split
        this.resultX = (countX + 1) % 2;
        if (this.resultX == 0) {
            turnAround();
            for (int i = 0; i <= countX / 2; i++) {
                moveAndCountSteps();
            }
            putBeeper();
            turnMovePut();
            putBeepersVertical();
        } else if (this.resultX == 1) {
            turnAround();
            for (int i = 0; i <= (countX / 2) - 1; i++) {
                moveAndCountSteps();
            }
            turnAround();
            putBeeper();
            putBeepersVertical();
        }
        countX = 0;

    }
    //Check the YAxis for the middle points.
    public void testYAxis() {
        //for small maps that divide in less than 4 sections
        if (leftIsBlocked() && rightIsBlocked()) return;
        turnLeft();

        while (frontIsClear()) {
            moveAndCountSteps();
            countY++;
        }
        //Check for 2 specific situations
        if (this.countY == 1 || this.countY == 0) {
            countY = 0;
            return;
        } else if (countY == 2) {
            turnMovePut();
            turnLeft();
            moveAndPut();
            countY = 0;
            return;
        }
        //Checking Odd or Even Y number and Split
        this.resultY = (countY + 1) % 2;
        if (this.resultY == 0) {
            turnAround();
            for (int i = 0; i <= countY / 2; i++) {
                moveAndCountSteps();
            }
            putBeeper();
            turnMovePut();
            putBeepersHorizontally();
        } else if (this.resultY == 1) {
            turnAround();
            for (int i = 0; i <= countY / 2 - 1; i++) {
                moveAndCountSteps();
            }
            turnAround();
            putBeeper();
            putBeepersHorizontally();

        }
        countY = 0;

    }
    //Splits the Y axis with beepers
    public void putBeepersVertical() {
        if (frontIsBlocked() || (leftIsBlocked() && rightIsBlocked())) {
            return;
        }
        turnLeft();
        moveAndPut();
        turnLeft();
        if (resultX == 1) {
            return;
        }
        move();
        countKarelSteps();
        turnLeft();
        putBeeper();
        moveAndPut();
    }

    //Splits the X axis with beepers
    public void putBeepersHorizontally() {
        if (rightIsBlocked() && leftIsBlocked()) return;
        turnRight();
        moveAndPut();
        turnRight();
        if (this.resultY != 0) {
            return;
        }
        move();
        countKarelSteps();
        turnRight();
        putBeeper();
        moveAndPut();
    }
    //Moves and counts steps
    public void moveAndCountSteps() {
        move();
        countKarelSteps();
    }
    //Moves and put beepers
    public void moveAndPut() {
        while (frontIsClear()) {
            moveAndCountSteps();
            putBeeper();
        }
    }
    public void turnMovePut() {
        turnAround();
        move();
        countKarelSteps();
        putBeeper();
    }
    //Returning to beggining position (1,1) or (0,1) or (1,0)
    public void returnHome() {
        returnFromSouth();
        returnFromWest();
        returnFromNorth();
        returnFromEast();
    }
    public void returnFromSouth() {
        if (facingSouth()) {
            turnRight();
            moveForward();
            turnAround();
        }
    }
    public void returnFromWest() {
        if (facingWest()) {
            turnLeft();
            moveForward();
            turnRight();
            moveForward();
            turnAround();
        }
    }
    public void returnFromNorth() {
        if (facingNorth()) {
            turnAround();
            moveForward();
        }
        returnFromSouth();
    }
    public void returnFromEast() {
        if (facingEast()) {
            turnAround();
            moveForward();
            turnAround();
        }
    }
    public void moveForward() {
        while (frontIsClear()) {
            moveAndCountSteps();
        }
    }
}




