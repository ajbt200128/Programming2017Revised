package org.usfirst.frc.team1058.robot.commands;

import org.usfirst.frc.team1058.robot.EasyCommand;
import org.usfirst.frc.team1058.robot.Robot;
import org.usfirst.frc.team1058.robot.RobotMap;

/**
 * Created by Austin on 6/6/2017.
 */
public class DriveGearManipulator extends EasyCommand {
    private double rollerSpeed;
    private double setPoint;
    private double maxVoltage;
    private boolean setMaxVoltage;

    public DriveGearManipulator(double rollerSpeed, double setPoint, double maxVoltage) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.gearManipulator);
        this.rollerSpeed = rollerSpeed;
        this.setPoint = setPoint;
        this.maxVoltage = maxVoltage;
        setMaxVoltage = true;
    }

    public DriveGearManipulator(double rollerSpeed, double setPoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.gearManipulator);
        this.rollerSpeed = rollerSpeed;
        this.setPoint = setPoint;
        setMaxVoltage = false;
    }

    /**
     * The initialize method is called just before the first time
     * this Command is run after being started.
     */
    @Override
    protected void initialize() {
        done = false;
        if (setMaxVoltage)
            Robot.gearManipulator.setIntakeMaxSpeed(maxVoltage);
        Robot.gearManipulator.setIntakePosition(setPoint);
    }


    /**
     * The execute method is called repeatedly when this Command is
     * scheduled to run until this Command either finishes or is canceled.
     */
    protected void execute() {
        if (!Robot.oi.operatorGamepad.getRightAxisButton())
            Robot.gearManipulator.setRollerSpeed(rollerSpeed);
        else
            Robot.gearManipulator.setRollerSpeed(0);
    }

    @Override
    protected void end() {
        Robot.gearManipulator.setIntakePosition(RobotMap.Constants.INTAKE_PIVOT_VERTICAL_POSITION);
        Robot.gearManipulator.setRollerSpeed(0);
    }

    @Override
    protected void interrupted() {
        //CAN I DO THIS TED WILL YOU GET PISSY OR NAH?!?!?!
        end();
        done = true;
    }
}
