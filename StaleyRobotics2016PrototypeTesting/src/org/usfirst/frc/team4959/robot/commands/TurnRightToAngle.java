package org.usfirst.frc.team4959.robot.commands;

import org.usfirst.frc.team4959.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnRightToAngle extends Command {
	
	private double desiredAngle;

    public TurnRightToAngle(double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	desiredAngle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drive.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.turnRightAngle(desiredAngle);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Math.abs(desiredAngle) < Robot.drive.getGyroAngle());
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
