package org.usfirst.frc.team1058.robot.commands;

import org.usfirst.frc.team1058.robot.EasyCommand;
import org.usfirst.frc.team1058.robot.Robot;

/**
 * Created by Austin on 6/6/2017.
 */
public class DriveClimber extends EasyCommand {
    private double speed;

    public DriveClimber(double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.climber);
        this.speed = speed;
    }

    protected void execute() {
        Robot.climber.setClimberOutput(speed);
    }

    @Override
    protected void end() {
        Robot.climber.setClimberOutput(0);
    }
}
