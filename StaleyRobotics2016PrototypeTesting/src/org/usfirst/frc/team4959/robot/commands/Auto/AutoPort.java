package org.usfirst.frc.team4959.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoPort extends CommandGroup {
    
    public  AutoPort() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	//drives to the port
    	addSequential(new DriveFoward(-.7, 3));
    	//lowers flipper
    	addSequential(new MoveFlipperDown(.3, 3));
    	// **Runs next commands in parallel**
    	//moves flipper up slowly 
    	addParallel(new MoveFlipperUp(.3, 4));
    	//moves through port slowly 
    	addSequential(new DriveFoward(-.7, 3));
    }
}
