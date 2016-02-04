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
    	System.out.println("Angle: " + Robot.arm.getArmPos());
    	
    	if(Robot.arm.getArmPos() > angle) {
    		Robot.arm.runArm(-armPower * 1.5);
    		System.out.println("going down");
    	} else if(Robot.arm.getArmPos() < angle) {
    		Robot.arm.runArm(armPower);
    		System.out.println("going up");
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if((Robot.arm.getArmPos() >= angle - 2) && (Robot.arm.getArmPos() <= angle + 2)){
        	System.out.println("is finished");
    		return true;
    	} else 
    		return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("end");
    	Robot.arm.stopArm();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("is interupted");
    	Robot.arm.stopArm();
    }
}
