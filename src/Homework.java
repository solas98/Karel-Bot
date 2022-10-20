import stanford.karel.SuperKarel;


public class Homework extends SuperKarel {

    public int countX = 0;
    public int countY = 0;
    public int x1;
    public int y1;
    public void run() {

        }
    public void testXAxis() {
        //for small maps that divide in less than 4 sections
        if (frontIsBlocked()) {
            return;
        }
        //Count the X lines
        while (frontIsClear()) {
            countX++;
            move();
        }
        if (countX == 1 || countX == 0) return;
        this.x1 = (countX + 1) % 2;
        if (this.x1 == 0) {
            turnAround();
            for (int i = 0; i <= countX / 2; i++) {
                move();
            }
            putBeeper();
            turnAround();
            move();
            putBeeper();
        } else if (this.x1 == 1) {
            turnAround();
            for (int i = 0; i <= (countX / 2) - 1; i++) {
                move();
            }
            turnRight();
            turnRight();
            putBeeper();

        }

    }

    public void testYAxis() {
        //for small maps that divide in less than 4 sections
        if (leftIsBlocked() && rightIsBlocked()) return;
        turnLeft();

        while (frontIsClear()) {
            move();
            countY++;
        }
        if (this.countY == 1 || this.countY == 0) return;
        this.y1 = (countY + 1) % 2;
        if (this.y1 == 0) {
            turnAround();
            for (int i = 0; i <= countY / 2; i++) {
                move();
            }
            putBeeper();
            turnAround();
            move();
            putBeeper();
        } else if (this.y1 == 1) {
            turnAround();
            for (int i = 0; i <= countY / 2 - 1; i++) {
                move();
            }
            turnRight();
            turnRight();
            putBeeper();

        }

    }

    public void columnBeepers() {
        if (frontIsBlocked()) {
            return;
        }

        turnLeft();
        while (frontIsClear()) {
            move();
            putBeeper();
        }
        turnLeft();
        if (this.x1 == 1) {
            return;
        }
        move();
        turnLeft();
        putBeeper();
        while (frontIsClear()) {
            move();
            putBeeper();
        }

    }

    public void putBeepersHorizontally() {
        if (rightIsBlocked() && leftIsBlocked()) return;
        turnRight();
        while (frontIsClear()) {
            move();
            putBeeper();
        }
        turnRight();
        if (this.y1 != 0) {
            return;
        }
        move();
        turnRight();
        putBeeper();
        while (frontIsClear()) {
            move();
            putBeeper();
        }
    }

    public void returnHomeFromY() {
        //for Odd number
        if (this.y1 == 1) {
            while (frontIsClear()) move();
            turnRight();
            while (frontIsClear()) move();
            turnRight();
            turnRight();
        }
        //for Even number
        else if (this.y1 == 0) {
            if (rightIsBlocked() && leftIsBlocked()) {
                return;
            }
            turnLeft();
            while (frontIsClear()) move();
            turnLeft();
        }
    }

}




