package org.team5507.FalconRecharged2021.robot;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import org.team5507.FalconRecharged2021.robot.utility.MathUtils;
import org.team5507.FalconRecharged2021.robot.utility.TrajectoryMaker;
import java.util.ArrayList;

//@SuppressWarnings("unused")

public class TrajectoryHelper {
    // for one cycle auto
    public static double[][] lineToTargetZone = {
            { 0, 0 },
            { 90, 0 }
    };

    public static double[][] targetZoneToLine = {
            { 90, 0 },
            { -2, 0 },
            { 0, 2 },
    };

    // for one cycle auto starting two feet to the left
    public static double[][] lineLeftToTargetZone = {
            { 0, 0 },
            { 90, 40 }
    };

    public static double[][] targetToLine = {
            { 90, 24 },
            { -2, 24 },
            { 0, 26 }
    };

    public static double[][] test2Meters = {
            { 0, 0 },
            { 78.7402, 0 }, // roughly equal to 2 meters
    };

    public static double[][] test1Meter = {
            { 0, 0 },
            { 39.3701, 0 }, // roughly equal to 2 meters
    };

    public static double[][] test2MetersAndBack = {
            { 0, 0 },
            { 78.7402, 0 }, // roughly equal to 2 meters
            { 78.7402, 78.7402 },
            { 0, 78.7402 },
            { 0, 0 }
    };

    public static double[][] test2MetersTriangle = {
            { 0, 0 },
            { 78.7402, 0 }, // roughly equal to 2 meters
            { 78.7402, 78.7402 }, // roughly equal to 2 meters
            { 0, 0 }
    };

    private static double[][] driveForward = {
            { 12, 60 },
            { 15, 60 },
    };

    public static double GLOBAL_SCALE = 0.827;

    /**
     * translateAndScale takes an array of integer coordinates in 2-d space, and
     * scales them to meters, and applies a scale in additinoos
     * Omits the first and last points
     * 
     * @param pointsArray arrray of more than two X,Y coordinates
     * @param scale       resize the entire grid
     * @return
     */
    public static ArrayList<Translation2d> translateAndScale(double[][] pointsArray, double scale) {
        ArrayList<Translation2d> points = new ArrayList<>(pointsArray.length - 1);
        // translate all the points to the initial coordinate
        double initialX = pointsArray[0][0];
        double initialY = pointsArray[0][1];

        for (int i = 1; i < pointsArray.length; i++) {
            // also; convert from inches to meters
            // translate to 0,0
            double x = pointsArray[i][0];
            double y = pointsArray[i][1];
            x = x - initialX; // translate points to be relative to starting point
            y = y - initialY;
            x = MathUtils.inchesToMeters(x); // convert to metric
            y = MathUtils.inchesToMeters(y);
            x = x * scale; // apply extra scale
            y = y * scale;
            points.add(new Translation2d(x, y));
        }
        return points;
    }

    public static TrajectoryMaker createTrajectory(double[][] inputPoints, double scale, double startOrientation,
            double endOrientation, boolean isReversed) // for bounce
    {
        ArrayList<Translation2d> points = translateAndScale(inputPoints, scale); // make .2 for Hajel's garage. Turns
                                                                                 // the 30 foot field to 6 feet
        Pose2d initialPose = new Pose2d(0, 0, new Rotation2d(startOrientation));
        Translation2d lastPoint = points.remove(points.size() - 1); // remove last point in array
        Pose2d endPose = new Pose2d(lastPoint.getX(), lastPoint.getY(), new Rotation2d(endOrientation));

        return new TrajectoryMaker(initialPose, endPose, points, isReversed);
    }

    public static TrajectoryMaker createTrajectory(double[][] inputPoints, double scale) // for slalom and barrel
    {
        ArrayList<Translation2d> points = translateAndScale(inputPoints, scale); // make .2 for Hajel's garage. Turns
                                                                                 // the 30 foot field to 6 feet
        Pose2d initialPose = new Pose2d(0, 0, new Rotation2d(0));
        Translation2d lastPoint = points.remove(points.size() - 1); // remove last point in array
        Pose2d endPose = new Pose2d(lastPoint.getX(), lastPoint.getY(), new Rotation2d(180));

        return new TrajectoryMaker(initialPose, endPose, points, false);
    }

    public static TrajectoryMaker createTrajectory(double[][] inputPoints) {
        return createTrajectory(inputPoints, GLOBAL_SCALE);
    }

    public static TrajectoryMaker createLineToTargetZone() {
        return createTrajectory(lineToTargetZone, GLOBAL_SCALE, 0, 0, false);
    }

    // public static TrajectoryMaker createTargetZoneToTrench() {
    // return createTrajectory(targetZoneToTrench, GLOBAL_SCALE, 0, 0, true);
    // }

    // public static TrajectoryMaker createTrenchRunPickUp() {
    // return createTrajectory(trenchRunPickUp, GLOBAL_SCALE, 0, 0, true);
    // }

    public static TrajectoryMaker createTargetZoneToLine() {
        return createTrajectory(targetZoneToLine, GLOBAL_SCALE, 0, Math.PI - 0.5, true);
    }

    public static TrajectoryMaker createLineLeftToTargetZone() {
        return createTrajectory(lineLeftToTargetZone, GLOBAL_SCALE, 0, 0, false);
    }

    public static TrajectoryMaker createTargetZoneToLineLeft() {
        return createTrajectory(targetToLine, GLOBAL_SCALE, 0, Math.PI - 0.5, true);
    }

    public static TrajectoryMaker createDriveForward() // test path going only 4 meters forward
    {
        return createTrajectory(driveForward, GLOBAL_SCALE, 0, 0, false);
    }

    public static TrajectoryMaker createTest2MetersAndBack() // test path going 2 meters forward
    {
        return createTrajectory(test2MetersAndBack, GLOBAL_SCALE, 0, 0, false);
    }

    // Need better documentation here. What are these doing? Are the units in
    // meters?
    public static TrajectoryMaker createfrontScorePath() {
        return new TrajectoryMaker(new Pose2d(0, 0, new Rotation2d(0)), new Pose2d(3, 0, new Rotation2d(0)), true);
    }

    public static TrajectoryMaker createTrenchToTargetDiagonal() {
        return new TrajectoryMaker(new Pose2d(0, 0, new Rotation2d(0)), new Pose2d(0.25, -0.25, new Rotation2d(0)),
                true);// 8,-1.6
    }

    public static TrajectoryMaker createTargetToFrontOfTrench() {
        return new TrajectoryMaker(new Pose2d(0, 0, new Rotation2d(0)), new Pose2d(-0.25, 0.25, new Rotation2d(0)),
                true);// -4.2,1.6
    }

    public static TrajectoryMaker createTrenchForward() // Assuming facing forward
    {
        return new TrajectoryMaker(new Pose2d(0, 0, new Rotation2d(0)), new Pose2d(0.25, 0, new Rotation2d(0)), true);// 2
    }

    public static TrajectoryMaker createForwardPath() // For Testing Purposes
    {
        return new TrajectoryMaker(new Pose2d(0, 0, new Rotation2d(0)), new Pose2d(.75, 0, new Rotation2d(0)), true);
    }

    public static TrajectoryMaker createZagPath() // For Testing Purposes
    {
        return new TrajectoryMaker(new Pose2d(0, 0, new Rotation2d(0)), new Pose2d(1, 0.5, new Rotation2d(0)), true);
    }

    public static TrajectoryMaker createForwardPath2() // For Testing Purposes
    {
        return new TrajectoryMaker(new Pose2d(0, 0, new Rotation2d(0)), new Pose2d(2, 0, new Rotation2d(0)), true);
    }

    public static TrajectoryMaker createToPortPath() // For Testing Purposes
    {
        return new TrajectoryMaker(new Pose2d(0, 0, new Rotation2d(0)), new Pose2d(0.25, 0, new Rotation2d(0)), true);// 3
    }

    public static TrajectoryMaker createPortToFrontofTrench() {
        ArrayList<Translation2d> points = new ArrayList<Translation2d>();
        points.add(new Translation2d(-1.5, 2.3));
        points.add(new Translation2d(-3, 2.3));
        return new TrajectoryMaker(new Pose2d(0, 0, new Rotation2d(0)), new Pose2d(-5.3, 2.3, new Rotation2d(180)),
                points);
    }

    public static TrajectoryMaker createTestMultiPath() {
        ArrayList<Translation2d> points = new ArrayList<Translation2d>();
        points.add(new Translation2d(1, -0.5));
        points.add(new Translation2d(1, 0.5));
        return new TrajectoryMaker(new Pose2d(0, 0, new Rotation2d(0)), new Pose2d(2, 0, new Rotation2d(Math.PI)),
                points);
    }

    public static TrajectoryMaker createMoveDownTrench() {
        return new TrajectoryMaker(new Pose2d(0, 0, new Rotation2d(0)), new Pose2d(3, 0, new Rotation2d(0)), true);
    }

    public static TrajectoryMaker createMoveToPort() {
        ArrayList<Translation2d> points = new ArrayList<Translation2d>();
        points.add(new Translation2d(1.524, 2.286));
        return new TrajectoryMaker(new Pose2d(0, 0, new Rotation2d(0)), new Pose2d(3.048, 4.572, new Rotation2d(0)),
                points);
    }

    public static TrajectoryMaker createAutonomousPath1() // Init Line (Start on Left) to Port Test
    {
        return new TrajectoryMaker(new Pose2d(0, 0, new Rotation2d(0)), new Pose2d(2, 0, new Rotation2d(0)), true);
    }

    public static TrajectoryMaker createAutonomousPath2() // Test 2 Electric Bugaloo
    {
        return new TrajectoryMaker(new Pose2d(0, 0, new Rotation2d(0)), new Pose2d(0, -1, new Rotation2d(0)), true);
    }

    public static TrajectoryMaker createSidePath() // Test Path
    {
        // return new TrajectoryMaker(new Pose2d(0, 0, new Rotation2d(0)), new
        // Pose2d(2.77, 0.2, new Rotation2d(0)), true);
        return new TrajectoryMaker(new Pose2d(0, 0, new Rotation2d(0)), new Pose2d(0, -2, new Rotation2d(0)), true);
    }

    public static TrajectoryMaker createDiagonalPath() // Test Path
    {
        return new TrajectoryMaker(new Pose2d(0, 0, new Rotation2d(0)), new Pose2d(1, 1, new Rotation2d(0)), true);
    }

    public static TrajectoryMaker createBackwardPath() // Test Path
    {
        return new TrajectoryMaker(new Pose2d(0, 0, new Rotation2d(0)), new Pose2d(2.77, 0, new Rotation2d(0)), true);
    }

    public static TrajectoryMaker createForwardPath3() // Test Path
    {
        return new TrajectoryMaker(new Pose2d(0, 0, new Rotation2d(0)), new Pose2d(2, 0, new Rotation2d(0)), true);
    }

    public static TrajectoryMaker createForwardPath4() // Test Path
    {
        return new TrajectoryMaker(new Pose2d(0, 0, new Rotation2d(0)), new Pose2d(-4.75, 0, new Rotation2d(0)), true);
    }

    public static TrajectoryMaker test2MetersAndBack() {
        return null;
    }
}
