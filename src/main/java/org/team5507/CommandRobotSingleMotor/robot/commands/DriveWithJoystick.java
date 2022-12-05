// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.team5507.CommandRobotSingleMotor.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import org.team5507.CommandRobotSingleMotor.robot.RobotContainer;
import org.team5507.CommandRobotSingleMotor.robot.subsystems.DriveTrain;

public class DriveWithJoystick extends CommandBase {
   private final DriveTrain driveTrain;

  /** Creates a new DriveWithJoystick. */
  public DriveWithJoystick(DriveTrain dt) {
    driveTrain = dt;
    addRequirements(driveTrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  driveTrain.driveWithJoystick(RobotContainer.driverJoystick);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
