package org.usfirst.frc.team4959.robot.commands;

import org.usfirst.frc.team4959.robot.Robot;
import org.usfirst.frc.team4959.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RaiseFlipper extends Command {

	DigitalInput limitSwitch = RobotMap.flipperLimitSwitch;
	
	private double speed;
	
    public RaiseFlipper(double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	this.speed = speed;
    	
    	requires(Robot.flipper);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.flipper.raiseFlippers(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false || limitSwitch.get();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.flipper.raiseFlippers(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.flipper.raiseFlippers(0);
    }
}
