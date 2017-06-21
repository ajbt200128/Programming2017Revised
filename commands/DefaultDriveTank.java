package org.usfirst.frc.team1058.robot.commands;

import org.usfirst.frc.team1058.robot.EasyCommand;
import org.usfirst.frc.team1058.robot.Robot;

/**
 * Created by Austin on 6/5/2017.
 */
public class DefaultDriveTank extends EasyCommand {

    public DefaultDriveTank() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.driveBase);
    }


    /**
     * The initialize method is called just before the first time
     * this Command is run after being started.
     */
    @Override
    protected void initialize() {
        Robot.driveBase.initDriveBase(3);
    }


    /**
     * The execute method is called repeatedly when this Command is
     * scheduled to run until this Command either finishes or is canceled.
     */
    protected void execute() {
        double rspd, lspd;
        double deadBandLR = Math.abs(Robot.oi.driverGamepad.getRightStickX());
        double deadBandFB = Math.abs(Robot.oi.driverGamepad.getLeftStickY());
        lspd = deadBandFB + deadBandLR;
        rspd = deadBandFB - deadBandLR;
        if (Robot.oi.driverGamepad.getLeftBumper())
            Robot.driveBase.driveTank(0.5 * rspd, 0.5 * lspd);
        else
            Robot.driveBase.driveTank(rspd, lspd);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
