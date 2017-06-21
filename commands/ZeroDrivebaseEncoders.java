package org.usfirst.frc.team1058.robot.commands;

import org.usfirst.frc.team1058.robot.EasyCommand;
import org.usfirst.frc.team1058.robot.Robot;

/**
 * Created by Austin on 6/7/2017.
 */
public class ZeroDrivebaseEncoders extends EasyCommand {
    public ZeroDrivebaseEncoders() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.driveBase);
    }

    /**
     * The execute method is called repeatedly when this Command is
     * scheduled to run until this Command either finishes or is canceled.
     */
    protected void execute() {
        Robot.driveBase.leftDrive1.setPosition(0);
        Robot.driveBase.rightDrive1.setPosition(0);
        done = (Robot.driveBase.leftDrive1.getPosition() == 0 && Robot.driveBase.rightDrive1.getPosition() == 0);
    }
}
