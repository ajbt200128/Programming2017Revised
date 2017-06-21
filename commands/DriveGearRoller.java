package org.usfirst.frc.team1058.robot.commands;

import org.usfirst.frc.team1058.robot.EasyCommand;
import org.usfirst.frc.team1058.robot.Robot;

/**
 *
 */
public class DriveGearRoller extends EasyCommand {
    private double rollerVelocity;

    public DriveGearRoller(double velocity) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        rollerVelocity = velocity;

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.gearManipulator.setRollerSpeed(rollerVelocity);


    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.gearManipulator.setRollerSpeed(0);
    }
}
