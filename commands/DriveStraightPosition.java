package org.usfirst.frc.team1058.robot.commands;

import org.usfirst.frc.team1058.robot.EasyCommand;
import org.usfirst.frc.team1058.robot.Robot;
import org.usfirst.frc.team1058.robot.RobotMap;

/**
 * Created by Austin on 6/21/2017.
 */
public class DriveStraightPosition extends EasyCommand {
    private double position, maxSpeed;

    public DriveStraightPosition(double position, double maxSpeed) {
        this.position = position * 1.04;
        this.maxSpeed = maxSpeed;
        requires(Robot.driveBase);
    }

    @Override
    protected void initialize() {
        super.initialize();
        Robot.driveBase.initDriveBase(RobotMap.DriveBaseModes.SPEED_CONTROL_MODE);
    }

    @Override
    protected void execute() {
        //DO WE EVEN USE THE GYROOOOOOOOOOOOOOOOOOOO
        boolean ldOnTarget = (-Robot.driveBase.leftDrive1.getPosition() < (position + RobotMap.Constants.DRIVEBASE_POSITION_TOLERANCE)
                && -Robot.driveBase.leftDrive1.getPosition() > (position - RobotMap.Constants.DRIVEBASE_POSITION_TOLERANCE));
        //This is a bit disgusting but atleast I know better sorry I'm too lazy for this stuff
        boolean rdOnTarget = (Robot.driveBase.rightDrive1.getPosition() < (position + RobotMap.Constants.DRIVEBASE_POSITION_TOLERANCE)
                && Robot.driveBase.rightDrive1.getPosition() > (position - RobotMap.Constants.DRIVEBASE_POSITION_TOLERANCE));
        done = ldOnTarget && rdOnTarget;
    }

    @Override
    protected void end() {
        Robot.driveBase.driveTank(0, 0);
    }
}
