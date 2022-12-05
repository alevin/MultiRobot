// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.team5507.alex_home2022.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import org.team5507.alex_home2022.robot.Constants;
import org.team5507.alex_home2022.robot.RobotContainer;
import org.team5507.alex_home2022.robot.subsystems.DriveTrain;

public class DriveWithJoysticks extends CommandBase {
  /** Creates a new DriveWithJoystick. */
  private final DriveTrain driveTrain;

  public DriveWithJoysticks(DriveTrain dt) {
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
    driveTrain.driveWithJoysticks(RobotContainer.driverJoystick, Constants.DRIVETRAINSPEED);
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
