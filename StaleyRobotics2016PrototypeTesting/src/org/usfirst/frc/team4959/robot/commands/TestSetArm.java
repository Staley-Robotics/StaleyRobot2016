package org.usfirst.frc.team4959.robot.commands;

import org.usfirst.frc.team4959.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TestSetArm extends Command {

	private double armPower = 0.1;
	private double angle = 0;
	
    public TestSetArm(double angle) {
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
//    	Robot.arm.setAngle(angle);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("end");
    	Robot.arm.runArm(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("is interupted");
    	Robot.arm.runArm(0);
    }
}
