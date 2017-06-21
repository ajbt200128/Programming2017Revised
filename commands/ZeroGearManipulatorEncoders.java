package org.usfirst.frc.team1058.robot.commands;

import org.usfirst.frc.team1058.robot.EasyCommand;
import org.usfirst.frc.team1058.robot.Robot;

/**
 * Created by Austin on 6/7/2017.
 */
public class ZeroGearManipulatorEncoders extends EasyCommand {
    public ZeroGearManipulatorEncoders() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.gearManipulator);
    }

    protected void execute() {
        Robot.gearManipulator.gearManipulatorPivot.setPosition(0);
        Robot.gearManipulator.setIntakePosition(0);
        done = Robot.gearManipulator.gearManipulatorPivot.getPosition() == 0;
    }

}
