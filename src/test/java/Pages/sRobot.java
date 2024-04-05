package Pages;


import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import static Pages.ParentPage.WaitNano;

public class sRobot {
    public static Robot robot;

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public static void robots(String action, int time) {
        if (action.equals("enter")) {
            enterPresser(time);
        } else if (action.equals("tab")) {
            tabPresser(time);
        } else if (action.equals("tabReverse")) {
            tabPresserReverse(time);
        } else {
            System.out.println("Invalid Action");
        }
    }

    private static void tabPresser(int time) {
        for (int i = 0; i < time; i++) {
            WaitNano(1);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }
    }

    public static void clickBlank(String click, int x, int y) {
        if (click.equalsIgnoreCase("click")) {
            robot.mouseMove(x, y);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        } else if (click.equalsIgnoreCase("dontClick")) {
            robot.mouseMove(x, y);
        }
    }

    private static void tabPresserReverse(int time) {
        for (int i = 0; i < time; i++) {
            WaitNano(1);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_SHIFT);
        }
    }

    private static void enterPresser(int time) {
        for (int i = 0; i < time; i++) {
            WaitNano(1);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }
    }
}

