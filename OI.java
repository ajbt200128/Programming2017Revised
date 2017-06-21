package org.usfirst.frc.team1058.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team1058.robot.autos.PlaceGear;
import org.usfirst.frc.team1058.robot.commands.*;
import org.usfirst.frc.team1058.robot.triggers.DPad;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a
    //// joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    public Gamepad driverGamepad = new Gamepad(0);
    public Gamepad operatorGamepad = new Gamepad(1);


    public OI() {
        new JoystickButton(operatorGamepad, 1).whileHeld(new DriveGearRoller(-0.8));
        new JoystickButton(operatorGamepad, 3).whileHeld(new DriveClimber(-1));
        new JoystickButton(operatorGamepad, 2).whileHeld(new DriveClimber(-0.35));
        new JoystickButton(operatorGamepad, 4).whenPressed(new PlaceGear());
        new GamepadTrigger(operatorGamepad, "left").whenPressed(new DriveGearPivot(RobotMap.Constants.INTAKE_PIVOT_VERTICAL_POSITION, 8));
        new JoystickButton(operatorGamepad, 7).whenPressed(new ZeroGearManipulatorEncoders());
        new DPad(operatorGamepad, DPad.DPAD_LEFT).whileActive(new DriveGearManipulator(1, RobotMap.Constants.INTAKE_PIVOT_GEARINTAKE_POSITION));
        new DPad(operatorGamepad, DPad.DPAD_RIGHT).whileActive(new DriveGearManipulator(1, RobotMap.Constants.INTAKE_PIVOT_GEARINTAKE_POSITION));
    }


    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


}
