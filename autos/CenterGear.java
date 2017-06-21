package org.usfirst.frc.team1058.robot.autos;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team1058.robot.RobotMap;
import org.usfirst.frc.team1058.robot.commands.DriveGearPivot;
import org.usfirst.frc.team1058.robot.commands.DriveStraightPosition;
import org.usfirst.frc.team1058.robot.commands.ZeroDrivebaseEncoders;
import org.usfirst.frc.team1058.robot.commands.ZeroGearManipulatorEncoders;

/**
 * Created by Austin on 6/12/2017.
 */
public class CenterGear extends CommandGroup {

    public CenterGear() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
        addSequential(new ZeroDrivebaseEncoders());
        addParallel(new PrepareGearManipulator());
        addSequential(new WaitCommand(3.5));
        addParallel(new DriveGearPivot(RobotMap.Constants.INTAKE_PIVOT_VERTICAL_POSITION,6),1);
        addSequential(new DriveStraightPosition(6,3.5));
        addSequential(new WaitCommand(.5));
        addSequential(new PlaceGear(),.5);
        addSequential(new DriveGearPivot(RobotMap.Constants.INTAKE_PIVOT_SPIT_POSITION,6),0.2);
        addSequential(new DriveStraightPosition(4.2,-2));
        addSequential(new DriveGearPivot(RobotMap.Constants.INTAKE_PIVOT_VERTICAL_POSITION, 6), 0.5);
        // A command group will require all of the subsystems that each member would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the arm.
    }
}
