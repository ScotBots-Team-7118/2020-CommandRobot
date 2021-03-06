package frc.robot.gyro;

/** Methods:
 * public Gyroscope()
 * public double getOffsetHeading()
 * public void reset()
 * public double getRawHeading()
 * public double getOffset()
 * private double normalizeHeadingVal(double heading)
 */

/**
 * Framework for an object that manages input from a BNO055 Gyroscope.
 */
public class Gyroscope
{
	// Defines the variable imu from the class BNO055
	public static BNO055 imu = BNO055.getInstance(BNO055.opmode_t.OPERATION_MODE_IMUPLUS, BNO055.vector_type_t.VECTOR_EULER);

	// Defines the variable for the angle offset.
	// Leave as a class variable so that each instance can have it's own angleOffset
	private double angleOffset;

	/**
	 * Constructs a new Gyroscope object.
	 */
	public Gyroscope()
	{
		// Resets the gyro
		reset();
	}

	/**
	 * @return The heading in relation to the offset.
	 */
	public double getNormalizedHeading()
	{
		// Returns the remainder of the current angle divided by 180
		return normalizedHeadingVal(getRawHeading() - angleOffset);
	}

	/**
	 * Resets the angle offset to the current heading.
	 */
	public void reset()
	{
		// Sets angleOffset to the raw heading of the gyro
		angleOffset = getRawHeading();

		// Checks if the angle offset is 360 degrees
		if (angleOffset == 360.0) {
			// If so, set angleOffset to 0
			// This accounts for a problem seen on the field
			angleOffset = 0;
		}
	}

	/**
	 * @return The normalized heading of the gyroscope without taking the angle offset into account.
	 */
	public double getRawHeading()
	{
		return normalizedHeadingVal(imu.getVector()[0]);
	}
	
	/**
	 * @return The current angle offset of the gyroscope.
	 */
	public double getOffset()
	{
		return angleOffset;
	}

	/**
	 * Normalizes a heading value to the range of (-180, 180] degrees.
	 * @return The normalized heading.
	 */
	public static double normalizedHeadingVal(double heading)
	{
		heading = heading % 360;

		// Checks if the remainder of the given heading and 360 is greater than 180
		if (heading > 180.0) {
			// If so, set the heading to a negative value greater than -180
			heading = heading - 360;
		}

		// Otherwise, checks if the opposite case is true
		else if (heading <= -180.0) {
			// If so, set the heading to a positive number less than 180
			heading = heading + 360.0;
		}

		return heading;
	}
}

    

