
package org.usfirst.frc.team4959.robot;
import edu.wpi.first.wpilibj.CameraServer;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4959.robot.subsystems.Shooter;
import org.usfirst.frc.team4959.robot.subsystems.Vision;
import org.usfirst.frc.team4959.robot.commands.AutoWheelMoat;
import org.usfirst.frc.team4959.robot.commands.Auto.AutoLowBar;
import org.usfirst.frc.team4959.robot.commands.Auto.AutoMoat;
import org.usfirst.frc.team4959.robot.commands.Auto.AutoRoughTerrain;
import org.usfirst.frc.team4959.robot.subsystems.Arm;
import org.usfirst.frc.team4959.robot.subsystems.BackFlipper;
import org.usfirst.frc.team4959.robot.subsystems.Drive;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 * 
 * Connor is wrong.
 */
public class Robot extends IterativeRobot {

	CameraServer server;
	
	public static final Shooter shooter = new Shooter();
	public static final Arm arm = new Arm();
	public static final BackFlipper flipper = new BackFlipper();
	public static final Vision vision = new Vision();
	public static final Drive drive = new Drive();
	public static OI oi;
	
	static SendableChooser autonomousModes;

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	RobotMap.init();
    	
    	arm.resetEncoder();
    	
    	server = CameraServer.getInstance();
    	server.setQuality(50);
    	server.startAutomaticCapture("cam0");
    	
        // OI must be constructed after subsystems. If the OI creates Commands 
        //(which it very likely will), subsystems are not guaranteed to be 
        // constructed yet. Thus, their requires() statements may grab null 
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // instantiate the command used for the autonomous period
        
        autonomousModes = new SendableChooser();
        autonomousModes.addDefault("Low Bar", new AutoLowBar());
        autonomousModes.addObject("Moat/ Rock Wall", new AutoMoat());
        autonomousModes.addObject("Rough Terrain", new AutoRoughTerrain());
        autonomousModes.addObject("Wheel Low Bar", new AutoWheelMoat());

//        autonomousModes.addObject("Touch Defense", new TouchDefense());
        SmartDashboard.putData("Autonomous Modes", autonomousModes);
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
    	autonomousCommand = (Command) autonomousModes.getSelected();
//    	autonomousCommand = new AutoLowBar();
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
        // Tulip starts running. If you want the autonomous to 
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
