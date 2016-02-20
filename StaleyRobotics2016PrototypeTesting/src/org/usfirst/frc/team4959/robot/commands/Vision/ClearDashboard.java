package org.usfirst.frc.team4959.robot.commands.Vision;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.tables.ITableListener;

/**
 * A utility to delete (clear) the SmartDashboard keys from the NetworkTable.
 * 
 * @author pkb
 */
public class ClearDashboard implements ITableListener {
	
	/**
	 * Entry point into the application.
	 * 
	 * @param args You can specify the IP address of the NetworkTable server to connect to on the command line. 
	 * 
	 * @throws InterruptedException If there is a problem accessing the SmartDashboard table.
	 */
	public static void main(String args[]) throws InterruptedException {
		ClearDashboard cd = new ClearDashboard();
		String defaultIp = "10.49.59.2";
		//String defaultIp = "127.0.0.1";
		String ipAddr = (args.length > 0) ? args[0] : defaultIp;
		
		NetworkTable.setIPAddress(ipAddr);
		NetworkTable.setClientMode();
		NetworkTable.initialize();
		NetworkTable table = NetworkTable.getTable("SmartDashboard");
		table.addTableListener(cd);
		table.addSubTableListener(cd);
		table.putBoolean("Cleared", false);
		// Give a bit of time to allow network fetch of keys to show up
		Thread.sleep(1000);
		deleteTableKeys(table, "", true);
		// Give a bit of time for network operations to flush out
		Thread.sleep(500);
		
		// Put value back (for testing)
		// table.putBoolean("Cleared", true);
	}

	/**
	 * Helper method to recursively delete NetworkTable key/value pairs.
	 * 
	 * @param table The NetworkTable to clear key/value pairs from.
	 * @param indent The leading indent (like: "  ") for printing out info.
	 * @param deleteTable Should we delete the table after clearing its children.
	 */
	private static void deleteTableKeys(ITable table, String indent, boolean deleteTable) {
		System.out.println(indent + table);
		indent += "  ";
		
		// Delete key/value pairs from table
		for (String key : table.getKeys()) {
			Object value = table.getValue(key, null);
			System.out.println(indent + key + " : " + value);
			table.delete(key);
		}
		
		// Process any sub-tables
		for (String key : table.getSubTables()) {
			ITable subTable = table.getSubTable(key);
			System.out.println(indent + key + " {");
			// Is it save to delete table entries (and if so should we delete children first?)
			deleteTableKeys(subTable, indent, true);
			System.out.println(indent + "}");
			if (deleteTable) {
			  table.delete(key);			  
			}
		}
	}

	/**
	 * Let's us know as values come in.
	 */
	@Override
	public void valueChanged(ITable table, String key, Object value, boolean flag) {
		System.out.println("table: " + table + "  key:" + key + "  value: " + value + "  flag: " + flag);
	}

}
