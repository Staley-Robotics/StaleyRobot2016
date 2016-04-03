package org.usfirst.frc.team4959.robot.commands.Drive;

import org.usfirst.frc.team4959.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class JoystickDrive extends Command {
	
	private double speedModifier = 1;

    public JoystickDrive(double speedModifier) {
        requires(Robot.drive);
        
        this.speedModifier = speedModifier;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {        	
    	Robot.drive.worldOfTanksDrive(Robot.oi.getRightTrigger() * speedModifier, 
    			Robot.oi.getLeftTrigger() * speedModifier, 
    			Robot.oi.getLeftStickX() * speedModifier);
//    	Robot.drive.tankDrive(Robot.oi.getLeftStickY(), Robot.oi.getRightStickY());
//    	Robot.drive.testDrive(Robot.oi.getRightTrigger() * speedModifier, Robot.oi.getLeftTrigger() * speedModifier, Robot.oi.getLeftStickX() * speedModifier);
    	SmartDashboard.putNumber("Arm Angle ", Robot.arm.getArmPos());
    	SmartDashboard.putNumber("Displacement ", NetworkTable.getTable("SmartDashboard").getNumber("DisplacementX", 0.0));
    	SmartDashboard.putNumber("Image Count  ", NetworkTable.getTable("SmartDashboard").getNumber("IMAGE_COUNT", 0.0));

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
