package org.usfirst.frc.team1058.robot.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1058.robot.RobotMap;
import org.usfirst.frc.team1058.robot.commands.DefaultDriveTank;

/**
 * Created by Austin on 6/3/2017.
 */
public class DriveBase extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public CANTalon leftDrive1 = new CANTalon(RobotMap.TalonIDs.LEFT_DRIVE_1_TALON_ID);
    public CANTalon rightDrive1 = new CANTalon(RobotMap.TalonIDs.RIGHT_DRIVE_1_TALON_ID);
    int mode;
    private CANTalon leftDrive2 = new CANTalon(RobotMap.TalonIDs.LEFT_DRIVE_2_TALON_ID);
    private CANTalon rightDrive2 = new CANTalon(RobotMap.TalonIDs.RIGHT_DRIVE_2_TALON_ID);

    public void initDefaultCommand() {
        // Set the default command, if any, for a subsystem here. Example:
        //    setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new DefaultDriveTank());
    }

    /*
     *Modes
     *
     */
    public void initDriveBase(int mode) {
        this.mode = mode;
        leftDrive1.setSafetyEnabled(false);
        leftDrive2.setSafetyEnabled(false);
        rightDrive1.setSafetyEnabled(false);
        rightDrive2.setSafetyEnabled(false);

        leftDrive1.enableBrakeMode(true);
        leftDrive2.enableBrakeMode(true);
        rightDrive1.enableBrakeMode(true);
        rightDrive2.enableBrakeMode(true);

        switch (mode) {
            case 0:
                setSpeedControlMode();
                break;
            case 1:
                setPositionMode();
                break;
            default:
                setPercentVbus();
        }
        leftDrive1.enableControl();
        rightDrive1.enableControl();

        leftDrive1.reverseSensor(true);
        rightDrive1.reverseSensor(true);

        //tell each motor how many encoder ticks are on it for each revolution of the encoder shaft
        leftDrive1.configEncoderCodesPerRev(256);
        rightDrive1.configEncoderCodesPerRev(256);

        //set the feedback device of the drivebase motors (in this case, it is an encoder)
        leftDrive1.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
        rightDrive1.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
    }

    private void setPercentVbus() {
        //initialize the drivebase in voltage control mode - percentvbus for the masters, follower for the slaves
        leftDrive1.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
        leftDrive2.changeControlMode(CANTalon.TalonControlMode.Follower);

        rightDrive1.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
        rightDrive2.changeControlMode(CANTalon.TalonControlMode.Follower);
    }

    private void setPositionMode() {
        //if the control mode is speed based
        //set the modes of each drive motor - speed (PID) for the master of each side, follower for the slave of each side
        leftDrive1.changeControlMode(CANTalon.TalonControlMode.Position);
        leftDrive2.changeControlMode(CANTalon.TalonControlMode.Follower);
        rightDrive1.changeControlMode(CANTalon.TalonControlMode.Position);
        rightDrive2.changeControlMode(CANTalon.TalonControlMode.Follower);

        //set the PID values and other parameters of each drive motor MASTER only
        leftDrive1.setPID(0.52, 0, RobotMap.Constants.DRIVEBASE_kD, 0, 0, 500, 0);
        rightDrive1.setPID(0.52, 0, RobotMap.Constants.DRIVEBASE_kD, 0, 0, 500, 0);

        leftDrive1.configMaxOutputVoltage(4);
        rightDrive1.configMaxOutputVoltage(4);
    }

    private void setSpeedControlMode() {
        leftDrive1.changeControlMode(CANTalon.TalonControlMode.Speed);
        leftDrive2.changeControlMode(CANTalon.TalonControlMode.Follower);

        rightDrive1.changeControlMode(CANTalon.TalonControlMode.Speed);
        rightDrive2.changeControlMode(CANTalon.TalonControlMode.Follower);

        //set the PID values and other parameters of each drive motor MASTER only
        leftDrive1.setPID(RobotMap.Constants.DRIVEBASE_kP, RobotMap.Constants.DRIVEBASE_kI, RobotMap.Constants.DRIVEBASE_kD, RobotMap.Constants.DRIVEBASE_kF, 0, 0, 0);
        rightDrive1.setPID(RobotMap.Constants.DRIVEBASE_kP, RobotMap.Constants.DRIVEBASE_kI, RobotMap.Constants.DRIVEBASE_kD, RobotMap.Constants.DRIVEBASE_kF, 0, 0, 0);

    }

    public void driveTank(double leftSpeed, double rightSpeed) {
        int speedMod = 1;

        if ((mode != 0) && (mode != 1)) {
            leftDrive1.set(leftSpeed);
            leftDrive2.set(leftDrive1.getDeviceID());
            rightDrive1.set(-rightSpeed);
            rightDrive2.set(rightDrive1.getDeviceID());
        }

        if (mode == 0) speedMod = 60;

        leftDrive1.setSetpoint(leftSpeed * speedMod);
        leftDrive2.set(leftDrive1.getDeviceID());
        rightDrive1.setSetpoint(-rightSpeed * speedMod);
        rightDrive2.set(rightDrive1.getDeviceID());
    }

    public void setMaxOutputVoltage(double voltage) {
        leftDrive1.configMaxOutputVoltage(voltage);
        rightDrive1.configMaxOutputVoltage(voltage);

    }
}

