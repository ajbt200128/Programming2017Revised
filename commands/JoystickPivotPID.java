package org.usfirst.frc.team1058.robot.commands;

import org.usfirst.frc.team1058.robot.EasyCommand;
import org.usfirst.frc.team1058.robot.Robot;

/**
 * Created by Austin on 6/6/2017.
 */
public class JoystickPivotPID extends EasyCommand {
    private double setPoint;
    private double maxVoltage;

    public JoystickPivotPID(double initialSetPoint, double maxVoltage) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.gearManipulator);
        this.setPoint = initialSetPoint;
        this.maxVoltage = maxVoltage;
    }


    /**
     * The initialize method is called just before the first time
     * this Command is run after being started.
     */
    @Override
    protected void initialize() {
        //if it is not just initialized, but isnt initialized gonna always be true at this point?
        Robot.gearManipulator.setIntakePosition(setPoint);
        Robot.gearManipulator.setIntakeMaxSpeed(maxVoltage);
    }

    protected void execute() {
        if (Robot.oi.operatorGamepad.getStartButton())
            Robot.gearManipulator.setIntakePosition(-Robot.gearManipulator.gearManipulatorPivot.getPosition() - 400 * Robot.oi.operatorGamepad.getLeftStickY());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
