// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    // Port numbers for driver and operator gamepads. These correspond with the numbers on the USB
    // tab of the DriverStation
    public static final int kDriverControllerPort = 0;
    public static final int kOperatorControllerPort = 1;
    public static final double kDriveDeadband = 0.05;
    public static final double kArmManualDeadband = 0.05;
    public static final double kArmManualScale = 0.5;
    }
  
  

  public static final class Drivetrain {
    public static final int kFrontLeftCanId = 20;
    public static final int kMiddleLeftCanId = 21;
    public static final int kRearLeftCanId = 22;

    public static final int kFrontRightCanId = 23;
    public static final int kMiddleRightCanId =24;
    public static final int kRearRightCanId = 25;

    public static final boolean kFrontLeftInverted = true;
    public static final boolean kFrontRightInverted = false;
    public static final boolean kRearLeftInverted = true;
    public static final boolean kRearRightInverted = false;

    public static final int kCurrentLimit = 55;

    public static final double kTurningScale = -0.65;
  }
   public static final class Autonomous{
    public static final double kmaxVelocity = 5.0;
    public static final double kmaxAcceleration = 2.0;
    
    public static final double TRACKWIDTH = 25; // This is in inches 
    //1.399in in width per wheel
    public static final double WHEEL_RADIUS = 3; // wheel radius in inches
    public static final double GEARRATIO = 10.86; //gear ratio from output shaft of motor to wheel axle
    

}
}