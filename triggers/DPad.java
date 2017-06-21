package org.usfirst.frc.team1058.robot.triggers;

import edu.wpi.first.wpilibj.buttons.Trigger;
import org.usfirst.frc.team1058.robot.Gamepad;


/**
 * Created by Austin on 6/6/2017.
 */
public class DPad extends Trigger {
    public static final int DPAD_UP = 0;
    public static final int DPAD_DOWN = 1;
    public static final int DPAD_LEFT = 2;
    public static final int DPAD_RIGHT = 3;
    private boolean isTrue = false;
    private int pos;
    private Gamepad joy;

    public DPad(Gamepad joy, int pos) {
        this.pos = pos;
        this.joy = joy;
    }

    public boolean get() {
        switch (pos) {
            case DPAD_UP:
                return joy.getDpadUp();
            case DPAD_DOWN:
                return joy.getDpadDown();
            case DPAD_LEFT:
                return joy.getDpadLeft();
            case DPAD_RIGHT:
                return joy.getDpadRight();
        }
        return false;
    }
}
