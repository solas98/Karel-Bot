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
    public int x1;
    public int y1;

    public void run() {
        testOddX();
        testOddY();
        splitMapOdd();

    }

    public void testOddX() {
        while (frontIsClear()) {
            countX++;
            move();
            System.out.println("X steps are:" + countX);
        }
        System.out.println("The total X count is:" + countX);
        this.x1 = (countX + 1) % 2;
        if (this.x1 == 0) {
            turnAround();
            for (int i = 0; i <= countX / 2; i++) {
                move();
            }
//            putBeeper();
            turnAround();
            move();
            putBeeper();
        } else if (this.x1 != 0) {
            turnAround();
            for (int i = 0; i <= countX / 2 - 1; i++) {
                move();
            }
            turnRight();
            turnRight();
            putBeeper();

        }

    }

    public void testOddY() {
        turnLeft();
        while (frontIsClear()) {
            countY++;
            move();
            System.out.println("Y steps are:" + countY);
        }
        System.out.println("The total Y count is:" + countY);
        this.y1 = (countY + 1) % 2;
        if (this.y1 == 0) {
            turnAround();
            for (int i = 0; i <= countY / 2; i++) {
                move();
            }
            turnAround();
            move();
            putBeeper();
        } else if (this.y1 != 0) {
            turnAround();
            for (int i = 0; i <= countY / 2 - 1; i++) {
                move();
            }
            turnRight();
            turnRight();
            putBeeper();

        }

    }

    public void splitMapOdd() {
        turnRight();
        if (this.x1 != 0 && this.y1 != 0) {
            return;
        }

        turnRight();
        move();
        turnRight();


    }

//    public void columnBeepers(){
//        turnLeft();
//        while(frontIsClear()){
//            move();
//            putBeeper();
//        }
//        turnLeft();
//        if(this.x1 != 0){
//            return;
//        }
//        move();
//        turnLeft();
//        putBeeper();
//        while (frontIsClear()){
//            move();
//            putBeeper();
//        }
//
//    }
//
//    public void rowBeepers(){
//        turnRight();
//        while(frontIsClear()){
//            move();
//            putBeeper();
//        }
//        turnRight();
//        if(this.y1 != 0){
//            return;
//        }
//        move();
//        turnRight();
//        putBeeper();
//        while (frontIsClear()){
//            move();
//            putBeeper();
//        }
//    }
}





