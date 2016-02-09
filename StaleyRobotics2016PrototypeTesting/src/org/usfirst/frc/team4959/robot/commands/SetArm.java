package org.usfirst.frc.team4959.robot.commands;

import org.usfirst.frc.team4959.robot.Robot;
import org.usfirst.frc.team4959.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetArm extends Command {
		
	private double motorPower = 0.2;
	private double angle;
	
    public SetArm(double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.arm);
    	this.angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.arm.goToAngle(angle, motorPower);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Robot.shooter.checkForShooting();
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("end");
    	Robot.shooter.setShooting(false);
    	Robot.arm.runArm(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("is interupted");
    	Robot.arm.runArm(0);
    }
}
