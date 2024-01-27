// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.SUB_Drivetrain;
import frc.robot.subsystems.SUB_Shooter;
import frc.robot.subsystems.SUB_Shooter;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems are defined here.
public static final SUB_Drivetrain drivetrain = new SUB_Drivetrain(null);
public static final SUB_Shooter shooter = new SUB_Shooter();
  /*The gamepad provided in the KOP shows up like an XBox controller if the mode switch is set to X mode using the
   * switch on the top.*/
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);
  private final CommandXboxController m_operatorController =
      new CommandXboxController(OperatorConstants.kOperatorControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();

     drivetrain.setDefaultCommand(new RunCommand(
      () -> 
        drivetrain.driveArcade(
          MathUtil.applyDeadband(m_driverController.getRawAxis(1), Constants.OperatorConstants.kDriveDeadband),
          MathUtil.applyDeadband(m_driverController.getRawAxis(4)*Constants.Drivetrain.kTurningScale, Constants.OperatorConstants.kDriveDeadband))
  , drivetrain)
    );

    m_driverController.a().toggleOnTrue(Commands.startEnd(()->shooter.setShooterSpeed(shooter.adjShootSpeed),()->shooter.setShooterSpeed(0),shooter));
    m_driverController.b().toggleOnTrue(Commands.startEnd(()->shooter.setFeedSpeed(shooter.adjFeedSpeed),()->shooter.setFeedSpeed(0),shooter));

    m_driverController.y().onTrue(new InstantCommand(()-> shooter.increaseFeedSpeed()));
    m_driverController.x().onTrue(new InstantCommand(()-> shooter.decreaseFeedSpeed()));
    m_driverController.rightBumper().onTrue(new InstantCommand(()-> shooter.increaseShootSpeed()));
    m_driverController.leftBumper().onTrue(new InstantCommand(()-> shooter.decreaseShootSpeed()));
  }


  /**
   * Use this method to define your trigger->command mappings. Triggers can be accessed via the
   * named factory methods in the Command* classes in edu.wpi.first.wpilibj2.command.button (shown
   * below) or via the Trigger constructor for arbitary conditions
   */
  private void configureBindings() {
    // Set the default command for the drivetrain to drive using the joysticks
  
}
  public Command getAutonomousCommand(){
    return null;

  }
}
