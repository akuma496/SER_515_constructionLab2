public class TwoEmissionsStrategy {
    public float computeEmissionsFee(IVehicle vehicle) {
        return Math.min(vehicle.co2Emissions() - 1100, 10);
    }
}
