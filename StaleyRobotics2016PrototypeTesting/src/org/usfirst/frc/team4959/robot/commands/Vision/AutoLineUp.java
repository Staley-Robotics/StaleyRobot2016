package org.usfirst.frc.team4959.robot.commands.Vision;

import org.usfirst.frc.team4959.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class AutoLineUp extends Command {
	
	private double displacement;
	private double buffer = 5;
	
	private boolean fin = false;

    public AutoLineUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	displacement = NetworkTable.getTable("SmartDashboard").getNumber("DisplacementX", 0.0);
    	
    	if(Math.abs(displacement) == 160) {
    		System.out.println("No value recieved for displacement");
    	} else {
        	if(displacement > buffer) {
        		System.out.println("turning left. displacement: " + displacement);
        		Robot.drive.turn(-0.6);
        	} else if (displacement < -buffer) {
        		System.out.println("turning right. displacement: " + displacement);
        		Robot.drive.turn(0.6);
        	} else if(displacement < buffer && displacement > -buffer){
        		System.out.println("done1");
        		fin = true;
        	}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return fin;
    }

    // Called once after isFinished returns true
    protected void end() {
    	fin = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
