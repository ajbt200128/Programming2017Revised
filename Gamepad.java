package org.usfirst.frc.team1058.robot;

/**
 * Class for using the logitech F310 gamepad in Xinput mode - ensure the triggers are reading axes, not booleans
 * written for FRC team 3467
 *
 * @author Emile Hamwey
 */
public class Gamepad extends edu.wpi.first.wpilibj.Joystick {


    public Gamepad(int port) {
        super(port);
    }

    public double getLeftStickX() {
        return getRawAxis(RobotMap.GamepadPorts.leftStick_xAxis);
    }

    public double getLeftStickY() {
        if (Math.abs(getRawAxis(RobotMap.GamepadPorts.leftStick_yAxis)) < .15)
            return 0;
        return getRawAxis(RobotMap.GamepadPorts.leftStick_yAxis);
    }

    public boolean getLeftAxisButton() {
        return getRawButton(RobotMap.GamepadPorts.leftStickPress);
    }

    public double getRightStickX() {
        if (Math.abs(getRawAxis(RobotMap.GamepadPorts.rightStick_xAxis)) < .15)
            return 0;
        return getRawAxis(RobotMap.GamepadPorts.rightStick_xAxis);
    }

    public double getRightStickY() {
        return getRawAxis(RobotMap.GamepadPorts.rightStick_yAxis);
    }

    public boolean getRightAxisButton() {
        return getRawButton(RobotMap.GamepadPorts.rightStickPress);
    }

    public boolean getLeftBumper() {
        return getRawButton(RobotMap.GamepadPorts.leftBumper);
    }

    public boolean getRightBumper() {
        return getRawButton(RobotMap.GamepadPorts.rightBumper);
    }

    public boolean getLeftTrigger() {
        boolean leftTrigger = false;
        if (getRawAxis(RobotMap.GamepadPorts.leftTrigger_Axis) > .8) {
            leftTrigger = true;
        } else {
            leftTrigger = false;
        }
        return leftTrigger;
    }

    public boolean getRightTrigger() {
        boolean rightTrigger = false;
        if (getRawAxis(RobotMap.GamepadPorts.rightTrigger_Axis) > .8) {
            rightTrigger = true;
        } else {
            rightTrigger = false;
        }
        return rightTrigger;
    }

    public boolean getXButton() {
        return getRawButton(RobotMap.GamepadPorts.xButton);
    }

    public boolean getAButton() {
        return getRawButton(RobotMap.GamepadPorts.aButton);
    }

    public boolean getBButton() {
        return getRawButton(RobotMap.GamepadPorts.bButton);
    }

    public boolean getYButton() {
        return getRawButton(RobotMap.GamepadPorts.yButton);
    }

    public boolean getStartButton() {
        return getRawButton(RobotMap.GamepadPorts.startButton);
    }

    public boolean getBackButton() {
        return getRawButton(RobotMap.GamepadPorts.backButton);
    }

    public boolean getDpadUp() {
        return (getPOV(0) == 0);
    }

    public boolean getDpadRight() {
        return (getPOV(0) <= 135) || (getPOV(0) >= 45);
    }

    public boolean getDpadDown() {
        return (getPOV(0) == 180);
    }

    public boolean getDpadLeft() {
        return (getPOV(0) <= 315) || (getPOV(0) >= 225);
    }


}