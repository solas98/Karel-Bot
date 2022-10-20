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

    public int countSteps = 0;

    public void run() {
        testXAxis();
        returnHome();
        testYAxis();
    }

    public void countKarelSteps(){
        countSteps++;
        System.out.println("Karel made :"+countSteps+" steps");
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
            countKarelSteps();
            countX++;
        }
        if (countX == 1 || countX == 0) {
            countX = 0;
            return;
        }

        else if (countX == 2) {
            turnAround();
            move();
            countKarelSteps();
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
            turnMovePut();
            putBeepersVertical();
        } else if (this.resultX == 1) {
            turnAround();
            for (int i = 0; i <= (countX / 2) - 1; i++) {
                move();
            }
            turnAround();
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
        if (this.countY == 1 || this.countY == 0){ countY=0; return;}
        else if (countY == 2) {
            turnMovePut();
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
            turnMovePut();
            putBeepersHorizontally();
        } else if (this.resultY == 1) {
            turnAround();
            for (int i = 0; i <= countY / 2 - 1; i++) {
                move();
            }
            turnAround();
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
        moveAndPut();
        turnLeft();
        if (resultX == 1) {
            return;
        }
        move();
        turnLeft();
        putBeeper();
        moveAndPut();

    }

    public void putBeepersHorizontally() {
        if (rightIsBlocked() && leftIsBlocked()) return;
        turnRight();
        moveAndPut();
        turnRight();
        if (this.resultY != 0) {
            return;
        }
        move();
        turnRight();
        putBeeper();
        moveAndPut();
    }


    public void moveAndPut(){
        while (frontIsClear()) {
            move();
            putBeeper();
        }
    }
    
    public void turnMovePut(){
        turnAround();
        move();
        putBeeper();
    }






    public void returnHome() {
             returnFromSouth();
             returnFromWest();
             returnFromNorth();
             returnFromEast();
    }



    public void returnFromSouth(){
        if (facingSouth()) {
            turnRight();
            moveForward();
//            turnRight();
//            turnRight();
            turnAround();
        }
    }

    public void returnFromWest(){
        if (facingWest()) {
            turnLeft();
            moveForward();
            turnRight();
            moveForward();
//            turnRight();
//            turnRight();
            turnAround();
    }
    }
    public void returnFromNorth(){
        if (facingNorth()) {
//            turnRight();
//            turnRight();
            turnAround();
            moveForward();
    }
            returnFromSouth();
}
    public void returnFromEast(){
        if (facingEast()){
            turnAround();
            moveForward();
            turnAround();
        }
    }
    
    public void moveForward(){
        while (frontIsClear()){
            move();
        }
    }


}





