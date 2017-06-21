package org.usfirst.frc.team1058.robot.commands;

import org.usfirst.frc.team1058.robot.EasyCommand;
import org.usfirst.frc.team1058.robot.Robot;
import org.usfirst.frc.team1058.robot.RobotMap;

/**
 * Created by Austin on 6/6/2017.
 */
public class DriveGearPivot extends EasyCommand {
    private double setPoint;
    private double maxVoltage;

    public DriveGearPivot(double setPoint, double maxVoltage) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.gearManipulator);
        this.setPoint = setPoint;
        this.maxVoltage = maxVoltage;
    }


    /**
     * The initialize method is called just before the first time
     * this Command is run after being started.
     */
    @Override
    protected void initialize() {
        Robot.gearManipulator.setIntakeMaxSpeed(maxVoltage);
        done = false;
    }


    /**
     * The execute method is called repeatedly when this Command is
     * scheduled to run until this Command either finishes or is canceled.
     */
    protected void execute() {
        Robot.gearManipulator.setIntakePosition(setPoint);
        if (Robot.gearManipulator.gearManipulatorPivot.getPosition() < (setPoint + RobotMap.Constants.DRIVEBASE_POSITION_TOLERANCE)
                && Robot.gearManipulator.gearManipulatorPivot.getPosition() > (setPoint - RobotMap.Constants.DRIVEBASE_POSITION_TOLERANCE)) {
            done = true;
        }
    }
}
