package org.usfirst.frc.team4959.robot.commands.Vision;

import java.util.logging.Level;
import java.util.logging.Logger;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.TableKeyNotDefinedException;

public class GrabNetworkTables {
	public static void main(String [] args) {
		new GrabNetworkTables().run();
	}
	
	public void run() {
		NetworkTable.setTeam(4959);
//		NetworkTable.setClientMode();
//		NetworkTable.setIPAddress("10.49.59.2");
//		NetworkTable.setPort(1735);
		NetworkTable table = NetworkTable.getTable("SmartDashboard");
		
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				Logger.getLogger(GrabNetworkTables.class.getName()).log(Level.SEVERE, null, ex);
			}
			
			boolean connect =  table.isConnected();
			double imageCount = table.getNumber("IMAGE_COUNT", 0.0);
			System.out.println("Image Count: " + imageCount);
//			connect = true;
			System.out.println(connect);
		}
	}
}