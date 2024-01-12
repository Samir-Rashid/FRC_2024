/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class CANConstants {
        public static final int kSwerveRightRearRotate = 23;
        public static final int kSwerveRightRearDrive = 24;
        public static final int kSwerveRightRearCANCoder = 34;

        public static final int kSwerveRightFrontRotate = 21;
        public static final int kSwerveRightFrontDrive = 22;
        public static final int kSwerveRightFrontCANCoder = 32;

        public static final int kSwerveLeftRearRotate = 25;
        public static final int kSwerveLeftRearDrive = 26;
        public static final int kSwerveLeftRearCANCoder = 36;

        public static final int kSwerveLeftFrontRotate = 27;
        public static final int kSwerveLeftFrontDrive = 28;
        public static final int kSwerveLeftFrontCANCoder = 38;

        public static final int kPDP = 42;
        public static final int kPCM = 40;
        public static final int[] kLeftMotors = {99,98}; // This is garbage - dph 2023-12-14
        public static final int[] kRightMotors = {95,94}; // This is garbage - dph 2023-12-14
        public static final int kArmExtensionMotor = 97;
        public static final int kArmMotor = 96;
    }
    public static final class PCMConstants {
        public static final int[] kGripper = {1,0}; // dko 20220221 need to physically verify
        public static final int[] kBrake = {2,3}; // TODO could be backwards
        public static final int[] kArmExtension = {6,7}; // dko 20220221 need to physicall verify
        public static final int[] kBarHooks = {8,9}; // dko 20220221 need to physically verify
        public static final int kMinPresssure = 50; // minimum operating pressure for Arm control
    }
    public static final class OIConstants {
        public static final int kLeftJoystick = 0;
        public static final int kRightJoystick = 1;
        public static final int kControlBox = 2;
        public static final int kXboxController = 3;
        

        // Controlbox interfaces
        public static final int kControlBoxPotX = 0;
        public static final int kControlBoxPotY = 1;
        public static final int[] kControlBox3WaySwitch = {1,2}; // 3 position switch, see truth table below
        public static final int kControlBoxTottleButton = 3; // normally closed (1), pressed is open (0)
        public static final int kControlBoxSw1 = 4; // up is (0), down is (1) for all two position switches
        public static final int kControlBoxSw2 = 5;
        public static final int kControlBoxSw3 = 6;
        public static final int kControlBoxSw4 = 7;

        /* 
        kControlBox3WaySwitch implements the following states
           sw1   |   sw2   | 3-way position
        ---------+---------+---------------------
            0    |    0    | Left
            0    |    1    | Center
            1    |    0    | No such position
            1    |    1    | Right
        */

        // Xbox joystick constants
        public static final int kXboxAButton = 1;
        public static final int kXboxBButton = 2;
        public static final int kXboxXButton = 3;
        public static final int kXboxYButton = 4;
        public static final int kXboxLBumper = 5;
        public static final int kXboxRBumper = 6;
        public static final int kXboxSelect = 7;
        public static final int kXboxStart = 8;
        public static final int kXboxLTrigger = 9;
        public static final int kXboxRTrigger = 10;
    }
    public static final class AnalogIOConstants {
        public static final int kPressureTransducer = 0;
        public static final int kPressureOffset = -20;
        public static final int kPressureRange = 200;
    }

    public static final class EncoderConstants {
        public static final int[] kRightDriveEncoder = {2,3}; // Channel A,B
        public static final int[] kLeftDriveEncoder = {0,1}; // Channel A, B

        public static final double wheelDiameter = 6.0;
        public static final double ticksPerRevolution = 256;
        public static final double gearRatio = 7.91;

        public static final double kEncoderDistanceFactor = (wheelDiameter * Math.PI) / ticksPerRevolution / gearRatio;
    }

    public static final class PidConstants {
        public static final double kProportionalDriveStraight = 0.05;
     
        public static final double kArm_kP = 2.7;
        public static final double kArm_kI = 0.0;
        public static final double kArm_kD = 0.0;
        public static final double kArm_kF = 0.0;
        public static final double kArm_rampRate = 0.5;
        public static final double kArmExtension_kP = 0.3; //3.0;
        public static final double kArmExtension_kI = 0.0;
        public static final double kArmExtension_kD = 0.0;
        public static final double kArmExtension_kF = 0.0;
        public static final double kArmExtension_rampRate = 0.5;
        public static final double kPorportionalBalanceForward = 0.05;
        public static final double kProportionalBalanceBackward = 0.05;
    }

    public static final class DriveTrainConstants {
        public static final double kOpenLoopRampRate = 0.75;
	
	    public static final double kHighSpeed = 1.0;
	    public static final double kTurnHighSpeed = 1.0;

	    public static final double kMedSpeed = 0.6;
	    public static final double kTurnMedSpeed = 0.75; // Changed from 0.5 3/21/2023 - dph

	    public static final double kLowSpeed = 0.2;
	    public static final double kTurnLowSpeed = 0.4;

        public static final double kMaxSpeedWhenArmsRaised = 0.2; // This is a wild guess to protect the robot when the arms are up and it's driving.

        public static final double kSwerveAxisLength = 17.0; // inches
        public static final double kSwerveAxisWidth = 17.0; // inches
    }

    public static final class ArmConstants {
   
        public static final double kArmThreshold = 60; // Relaxed from 20 Feb 22, 2023        // 2022 constants
        public static final double kArmEncoderCountPerRevolution = 8192; // Need to verify this number - dph
        public static final double kArmDegreesPerTick = 360.0/ArmConstants.kArmEncoderCountPerRevolution;
        public static final double kArmTicksPerDegree = ArmConstants.kArmEncoderCountPerRevolution/360.0;

        // public static final double kArmScorePosition = 2100;
        // public static final double kArmTopPosition = 4020; //3550;
        // public static final double kArmPreGrabPosition = 2000; // Score position was too high - dph
        // public static final double kArmHangPosition = 2550;
        // public static final double kArmEndGamePosition = 2100;
        // public static final double kArmBallGathering = 200;
        
        // new for 2023
        public static final double kArmTuckAngle = -65;                  // Degrees
        public static final double kArmOnFloorRetractedAngle = -25;      // Degrees
        public static final double kArmHorizontalAngle = 0;              // This defines the angle coordinate system with 0 == parallel to the frame/floor.
        public static final double kArmMidConeAngle = 32.9;                // Degrees
        public static final double kArmHighConeAngle = 31.4;               // Degrees
        public static final double kArmMaxElevationAngleToGround = 35.0; // degrees
        public static final double kArmHighLimitAngle = 41;              // Degrees
        public static final double kArmReferencePosition = 0;            // 2023 broomstick ref position
        public static final double kArmAutonomousReferencePosition = 0;  // 2023 position when the arm is folded in the robot to start the game     public static final double kArmMinPosition = 900;  // Lowest you can ask for 
        // Positions are in Encode Ticks
        public static final double kArmMinPosition = (kArmOnFloorRetractedAngle - kArmTuckAngle) * kArmTicksPerDegree - kArmThreshold; // Lowest software will rotate down.
        public static final double kArmLowPosition = (kArmOnFloorRetractedAngle - kArmTuckAngle) * kArmTicksPerDegree; // Height for scoring on the bottom row
        public static final double kArmMidPosition = 2314; //(kArmMidConeAngle - kArmTuckAngle) * kArmTicksPerDegree; // Height for scoring on the middle row
        public static final double kArmHiPosition  = 2288; // (kArmHighConeAngle - kArmTuckAngle) * kArmTicksPerDegree;  // Height for scoring on the top row
        public static final double kArmMaxPosition = (kArmHighLimitAngle - kArmTuckAngle) * kArmTicksPerDegree; // Highest you can ask for
        public static final double kArmAutonomous  = kArmLowPosition;
        public static final double kArmHighCubePosition = kArmHiPosition;       // TODO May need adjustment for automomous.
        public static final double kArmHighCubeReleasePosition = 2088;  // TODO May need adjustment for automomous.
        
        
        public static final double kArmMinRotationAngle = kArmOnFloorRetractedAngle - kArmTuckAngle;  // Degrees below horizontal
        public static final double kArmHorizontalRotationPosition = (kArmHorizontalAngle - kArmTuckAngle) * kArmTicksPerDegree;
        
    }
    
    public static final class ArmExtensionConstants {
        // Distances are in meters
        // Positions are in encoder counts/ticks
        public static final double kArmExtensionReferencePosition =0;
        public static final double kArmExtensionGearToothSpacing = 0.005; // (meters)  = 5 millimeters
        public static final double kArmExtensionTeethPerRotation = 36;
        public static final double kArmExtensionEncoderCountPerRevolution = 8192; // Need to verify this number - dph
        public static final double kArmExtensionTicksPerMeter = 1.0/(kArmExtensionGearToothSpacing*kArmExtensionTeethPerRotation)*kArmExtensionEncoderCountPerRevolution;
        public static final double kArmExtensionFullyRetractedPosition = 0.0;
        public static final double kArmExtensionMinPosition = 0.0;
        public static final double kArmExtensionFullyExtendedPosition = kArmExtensionTicksPerMeter; // This needs to be calibrated - dph
        public static final double kArmExtensionHomePosition = 0;
        public static final double kArmExtensionLowPosition = 0;
        public static final double kArmExtensionMidPosition = 2185;
        public static final double kArmExtensionHiPosition = 28386;
        public static final double kArmExtensionMaxPosition = 37100;
        public static final double kArmExtensionGatheringPosition = 8000;  // clean this up
        public static final double kArmExtensionThreshold = 20;
        public static final double kArmExtensionMaxExtendedArmLength = Units.inchesToMeters(67.0);
        public static final double kArmExtensionRetractedLength =  kArmExtensionMaxExtendedArmLength - kArmExtensionMaxPosition/kArmExtensionTicksPerMeter;
        public static final double kArmExtensionMaxExtensionBeyondPerimeter = Units.inchesToMeters(42.0);
        
        public static final double kArmExtensionHorizontalExtensionPosition = ArmExtensionConstants.kArmExtensionMaxExtendedArmLength
                                                                           * Math.cos(Units.degreesToRadians(ArmConstants.kArmMaxElevationAngleToGround));
        public static final double kArmExtensionPivotToWheelsOnFloorLine = Math.sin(Units.degreesToRadians(ArmConstants.kArmMinRotationAngle))*kArmExtensionRetractedLength;
    }

    
    public static final class GripperConstants {
        public static final String kOpen    = "Open";
        public static final String kUnknown = "Unknown";
        public static final String kClosed  = "Closed";
    }

    public static final class BrakeConstants {
        public static final String kNotBraking = "NotBraking";
        public static final String kUnknown    = "Unknown";
        public static final String kBraking    = "Braking";
    }

    public static final class VisionConstants {
        public static final Transform3d robotToCam =
        new Transform3d(
                new Translation3d(0.5, 0.0, 0.0),
                new Rotation3d(
                        0, 0,
                        0)); // Cam mounted facing forward, half a meter forward of center, half a meter up
        // from center.
    }
    public static final class FieldConstants {
        public static final double length = Units.feetToMeters(54);
        public static final double width = Units.feetToMeters(27);
    }
    public static final class CameraConstants {
        public static final String kCamName="pv-812";
    }

    public static final int kBrakeLightRelay = 0;
}
