/**
 * Purpose: Calculates the projectile distance based on speed and angle.
 * 
 * Author Johann Mansfield
 * Version 03/25/2025
 */

public class Catapult
 {
    // Acceleration due to gravity in m/s^2
    private static final double GRAVITY = 9.8;

    // Constructor
    public Catapult() 
    {
        // No fields to initialize for this program
    }

    // Method to calculate the distance
    public double calcDistance(int speed, int angle)
    {
        double radians = Math.toRadians(angle);
        double distance = (Math.pow(speed, 2)) * Math.sin(2 * radians) / GRAVITY;
        return distance;
    }
}