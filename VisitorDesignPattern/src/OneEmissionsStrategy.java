public class OneEmissionsStrategy {
    public float computeEmissionsFee(IVehicle vehicle) {
        return Math.min(vehicle.co2Emissions() - 1000, 0);
    }
}

