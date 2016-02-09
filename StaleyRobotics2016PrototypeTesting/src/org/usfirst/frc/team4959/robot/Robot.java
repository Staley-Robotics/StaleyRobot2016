
package org.usfirst.frc.team4959.robot;
import edu.wpi.first.wpilibj.CameraServer;
import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;

import org.usfirst.frc.team4959.robot.commands.RunShooterButton;
import org.usfirst.frc.team4959.robot.subsystems.Shooter;
import org.usfirst.frc.team4959.robot.subsystems.Arm;
import org.usfirst.frc.team4959.robot.subsystems.BackFlipper;
import org.usfirst.frc.team4959.robot.subsystems.Drive;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	CameraServer server;
	
	public static final Shooter shooter = new Shooter();
	public static final Arm arm = new Arm();
	public static final BackFlipper flipper = new BackFlipper();
	public static Drive drive = new Drive();
	public static OI oi;

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	RobotMap.init();
    	
    	server = CameraServer.getInstance();
    	server.setQuality(50);
    	server.startAutomaticCapture("cam0");
    	

    	// instantiate the command used for the autonomous period
        autonomousCommand = new RunShooterButton(5);
        //This is where I decide between different Autos
		oi = new OI();
		
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
