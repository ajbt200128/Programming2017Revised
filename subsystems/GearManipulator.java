package org.usfirst.frc.team1058.robot.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1058.robot.Robot;
import org.usfirst.frc.team1058.robot.RobotMap;
import org.usfirst.frc.team1058.robot.commands.JoystickPivotPID;

/**
 * Created by Austin on 6/6/2017.
 */
public class GearManipulator extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public CANTalon gearManipulatorPivot = new CANTalon(RobotMap.TalonIDs.GEAR_MANIPULATOR_PIVOT_TALON_ID);
    public CANTalon gearManipulatorRoller = new CANTalon(RobotMap.TalonIDs.CYCLONE_TALON_ID);

    double kP = 2;
    double kI = 0;
    double kD = 0.001;

    public void initDefaultCommand() {
        // Set the default command, if any, for a subsystem here. Example:
        //    setDefaultCommand(new MySpecialCommand());
        initializePivotMotors();
        setDefaultCommand(new JoystickPivotPID(RobotMap.Constants.INTAKE_PIVOT_VERTICAL_POSITION, 10));
    }

    public void setRollerSpeed(double speed) {
        if (Robot.oi.operatorGamepad.getStartButton())
            gearManipulatorRoller.set(-speed);
        else
            gearManipulatorRoller.set(speed);
    }

    public void initializePivotMotors() {
        gearManipulatorPivot.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
        gearManipulatorPivot.changeControlMode(CANTalon.TalonControlMode.Position);
        gearManipulatorPivot.setPID(kP, kI, kD);
        gearManipulatorPivot.enableControl();
        gearManipulatorPivot.setPosition(0);
        gearManipulatorPivot.reverseOutput(false);
        gearManipulatorPivot.reverseSensor(false);
        gearManipulatorPivot.setForwardSoftLimit(0);
    }

    public void setIntakeMaxSpeed(double maxVoltage) {
        gearManipulatorPivot.configMaxOutputVoltage(maxVoltage);
    }

    public void setIntakePosition(double setpoint) {
        if (setpoint > 0 || Robot.oi.operatorGamepad.getStartButton())
            gearManipulatorPivot.setSetpoint(-setpoint);
    }

    public void drivePivotManual(double output) {
        gearManipulatorPivot.set(output);
    }
}

