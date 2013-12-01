package stuffstuff.helper;

public class RotationHelper
{
    public static final float PITCH_LOW = 60;
    public static final float PITCH_HIGH = -60;
	
	public static boolean pointsDown(float pitch)
	{
		return pointsDown(pitch, PITCH_LOW);
	}
	
	public static boolean pointsDown(float pitch, float cutoff)
	{
		return pitch >= cutoff;
	}
	
	public static boolean pointsUp(float pitch)
	{
		return pointsUp(pitch, PITCH_HIGH);
	}
	
	public static boolean pointsUp(float pitch, float cutoff)
	{
		return pitch <= cutoff;
	}
	
	public static boolean pointsStraight(float pitch)
	{
		return pointsStraight(pitch, PITCH_LOW, PITCH_HIGH);
	}
	
	public static boolean pointsStraight(float pitch, float low, float high)
	{
		return !(pointsUp(pitch, high) || pointsDown(pitch, low));
	}
}
