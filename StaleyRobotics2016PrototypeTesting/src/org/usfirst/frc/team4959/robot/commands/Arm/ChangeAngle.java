package org.usfirst.frc.team4959.robot.commands.Arm;

import org.usfirst.frc.team4959.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *	Doesn't work
 */
public class ChangeAngle extends Command {
	
	private int direction;
	private double size;
	private double angle;
	private double motorPower = 0.6;

    public ChangeAngle(int direction, double size) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.direction = direction;
    	this.size = size;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	angle = Robot.arm.getArmPos();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.arm.goToAngle(angle + (size * direction), motorPower);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.shooter.checkForShooting();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.arm.runArm(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
