package org.usfirst.frc.team4959.robot.subsystems;

import org.usfirst.frc.team4959.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.TableKeyNotDefinedException;

/**
 *  It don't work ¯\_(ツ)_/¯
 */
public class Vision extends Subsystem {
	
	static NetworkTable table;
	
	
	public Vision() {
		table = RobotMap.networkTable;
//		table.shutdown();
		table.setServerMode();
		table.initialize();
//		table.setIPAddress("10.49.59.2");
	}
	
	public void getBlob() {
		try
		{
			System.out.println(table.getNumber("Center", 0.0));
		}
		catch (TableKeyNotDefinedException ex)
		{
		}
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
}

