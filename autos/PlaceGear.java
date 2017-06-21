package org.usfirst.frc.team1058.robot.autos;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1058.robot.Robot;
import org.usfirst.frc.team1058.robot.RobotMap;
import org.usfirst.frc.team1058.robot.commands.DriveGearManipulator;
import org.usfirst.frc.team1058.robot.commands.DriveGearPivot;
import org.usfirst.frc.team1058.robot.commands.DriveGearRoller;

/**
 * Created by Austin on 6/12/2017.
 */
public class PlaceGear extends CommandGroup {

    public PlaceGear() {
        addSequential(new DriveGearManipulator(-0.4, RobotMap.Constants.INTAKE_PIVOT_SPIT_POSITION,10),2);
        addSequential(new DriveGearPivot(RobotMap.Constants.INTAKE_PIVOT_SPIT_POSITION,4));
    }
}
