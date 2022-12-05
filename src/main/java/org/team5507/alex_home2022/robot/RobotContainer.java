// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.team5507.alex_home2022.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import org.team5507.alex_home2022.robot.commands.DriveForwardTimed;
import org.team5507.alex_home2022.robot.commands.DriveWithJoysticks;
import org.team5507.alex_home2022.robot.commands.ShootBall;
//import org.team5507.CommandRobotSingleMotor.robot.commands.ExampleCommand;
import org.team5507.alex_home2022.robot.subsystems.DriveTrain;
import org.team5507.alex_home2022.robot.subsystems.Shooter;
//import org.team5507.CommandRobotSingleMotor.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  //private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  // DriveTrain
  private final DriveTrain driveTrain;
  private final DriveWithJoysticks driveWithJoysticks;
  private final DriveForwardTimed driveForwardTimed;
  public static XboxController driverJoystick;

  private final Shooter shooter;
  private final ShootBall shootBall;

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    driveTrain = new DriveTrain();
    driveWithJoysticks = new DriveWithJoysticks(driveTrain);
    driveWithJoysticks.addRequirements(driveTrain);
    driveTrain.setDefaultCommand(driveWithJoysticks);
    driveForwardTimed = new DriveForwardTimed(driveTrain);
    driveForwardTimed.addRequirements(driveTrain);
    driverJoystick = new XboxController(Constants.JOYSTICK_NUMBER);

    shooter = new Shooter();
    shootBall = new ShootBall(shooter);
   shootBall.addRequirements(shooter);

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    JoystickButton shootButton = new JoystickButton(driverJoystick, XboxController.Button.kRightBumper.value);
     shootButton.whileHeld(new ShootBall(shooter));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return driveForwardTimed;
  }
}
