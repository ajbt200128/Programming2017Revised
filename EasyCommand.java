package org.usfirst.frc.team1058.robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Created by Austin on 6/7/2017.
 */
public abstract class EasyCommand extends Command {
    protected boolean done;

    protected void initialize() {
        done = false;
    }

    protected abstract void execute();

    protected boolean isFinished() {
        return done;
    }

    protected void end() {
    }

    protected void interrupted() {
        super.interrupted();
        end();
    }
}
