package org.usfirst.frc.team1058.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1058.robot.autos.CenterGear;
import org.usfirst.frc.team1058.robot.autos.PrepareGearManipulator;
import org.usfirst.frc.team1058.robot.subsystems.Climber;
import org.usfirst.frc.team1058.robot.subsystems.DriveBase;
import org.usfirst.frc.team1058.robot.subsystems.GearManipulator;
import org.usfirst.frc.team1058.robot.subsystems.SmartDashboardOutput;

/**
 * Created by Austin on 6/3/2017.
 */
public class Robot extends IterativeRobot {
    public static final DriveBase driveBase = new DriveBase();
    public static final OI oi = new OI();
    public static final Climber climber = new Climber();
    public static final GearManipulator gearManipulator = new GearManipulator();
    public static final SmartDashboardOutput smartDashboard = new SmartDashboardOutput();

    private static final SendableChooser<Command> chooser = new SendableChooser<>();
    private static SendableChooser<Command> shooterModeChooser = new SendableChooser<>();

    private Command autoCommand;

    @Override
    public void robotInit() {
        chooser.addDefault("Prepare Gear Auto", new PrepareGearManipulator());
        chooser.addObject("Center Gear", new CenterGear());
        //chooser.addObject();
        //should oi be initialized here?
        Robot.driveBase.leftDrive1.setPosition(0);
        Robot.driveBase.rightDrive1.setPosition(0);
        SmartDashboard.putData("Auto Chooser", chooser);
        CameraServer gearCamera = CameraServer.getInstance();

        UsbCamera gearUsb = gearCamera.startAutomaticCapture();
        gearUsb.setFPS(25);
        gearUsb.setResolution(256, 144);
    }


    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
        autoCommand = chooser.getSelected();
        if (autoCommand != null)
            autoCommand.start();
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        if (autoCommand != null)
            autoCommand.cancel();
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void testPeriodic() {
        LiveWindow.run();
    }
}
