/*
 * File: BlankKarel.java
 * ---------------------
 * This class is a blank one that you can change at will.
 */

import stanford.karel.KarelWorld;
import stanford.karel.SuperKarel;


public class BlankKarel extends SuperKarel {

    public int countX = 0;
    public int countY = 0;
    public int returnVar = 0;
    public int resultX;
    public int resultY;

    public void run() {
        testXAxis();
        returnHome();
        testYAxis();



    }



    //Check the X Axis for the middle points.
    public void testXAxis() {
        //for small maps that divide in less than 4 sections
        if (frontIsBlocked()) {
            return;
        }
        //Count the X lines
        while (frontIsClear()) {
            move();
            countX++;
        }
        if (countX == 1 || countX == 0) return;
        else if (countX == 2) {
            turnAround();
            move();
            putBeeper();
            turnRight();
            while (frontIsClear()){move();putBeeper();}
            
            countX = 0;
            return;
        }
        this.resultX = (countX + 1) % 2;
        if (this.resultX == 0) {
            turnAround();
            for (int i = 0; i <= countX / 2; i++) {
                move();
            }
            putBeeper();
            turnAround();
            move();
            putBeeper();
            putBeepersVertical();
        } else if (this.resultX == 1) {
            turnAround();
            for (int i = 0; i <= (countX / 2) - 1; i++) {
                move();
            }
            turnRight();
            turnRight();
            putBeeper();
            putBeepersVertical();
        }
        countX = 0;

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
        else if (countY == 2) {
            turnAround();
            move();
            putBeeper();
            turnLeft();
            while (frontIsClear()){move();putBeeper();}
            countY = 0;
            return;
        }
        this.resultY = (countY + 1) % 2;
        if (this.resultY == 0) {
            turnAround();
            for (int i = 0; i <= countY / 2; i++) {
                move();
            }
            putBeeper();
            turnAround();
            move();
            putBeeper();
            putBeepersHorizontally();
        } else if (this.resultY == 1) {
            turnAround();
            for (int i = 0; i <= countY / 2 - 1; i++) {
                move();
            }
            turnRight();
            turnRight();
            putBeeper();
            putBeepersHorizontally();

        }
        countY = 0;

    }

    public void putBeepersVertical() {
        if (frontIsBlocked() || (leftIsBlocked() && rightIsBlocked())) {
            return;
        }
        turnLeft();

        while (frontIsClear()) {
            move();
            putBeeper();
        }
        turnLeft();
        if (resultX == 1) {
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
        if (this.resultY != 0) {
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

    public void returnHome() {
        if (facingSouth()) {
            turnRight();
            while ((frontIsClear())) {
                move();
            }
            turnRight();
            turnRight();
        } else if (facingWest()) {
            turnLeft();
            while (frontIsClear()) {
                move();
            }
            turnRight();
            while ((frontIsClear())) {
                move();
            }
            turnRight();
            turnRight();
        } else if (facingNorth()) {
            turnRight();
            turnRight();
            while ((frontIsClear())) {
                move();
            }
            if (facingSouth()) {
                turnRight();
                while ((frontIsClear())) {
                    move();
                }
                turnRight();
                turnRight();
        }

    }

}}





