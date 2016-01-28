package org.usfirst.frc.team4959.robot.commands;

import org.usfirst.frc.team4959.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RunIntakeButton extends Command {

	private static final Timer TIMER = new Timer();
	
	private double time = 0;

    private static final double SPEED = 0.6;
	
    public RunIntakeButton(double time) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.intake);
        
        this.time = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	TIMER.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.intake.runIntake(SPEED);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	while(TIMER.get() < time)
        {
        return false;
        }   
    	return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intake.stopIntake();
    	TIMER.stop();
    	TIMER.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.intake.stopIntake();
    }
}
