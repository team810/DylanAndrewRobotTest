package org.usfirst.frc.team810.robot;

import org.usfirst.frc.team810.robot.commands.Drive;
import org.usfirst.frc.team810.robot.commands.Fire;
import org.usfirst.frc.team810.robot.commands.PushPiston;
import org.usfirst.frc.team810.robot.commands.RetractPiston;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	public static Joystick dan;
	public static JoystickButton slowDrive_bn;
	public static JoystickButton intake_bn;
	public static JoystickButton rollersOut_bn;
	public static JoystickButton push_bn;
	
	public OI(){
		dan = new Joystick(PortNumber.DRIVE_JOYSTICK); 
		slowDrive_bn = new JoystickButton(dan, 8);
		slowDrive_bn.whileHeld(new Drive(.5));
		
		intake_bn = new JoystickButton(dan, 5);
		rollersOut_bn = new JoystickButton(dan, 7);
		push_bn = new JoystickButton(dan, 2);
		
		initDashboardButtons();
	}
	
	private void initDashboardButtons() {
		SmartDashboard.putData("Push", new PushPiston());
		SmartDashboard.putData("Retract", new RetractPiston());
		SmartDashboard.putData("Fire", new Fire());
	}
}
