public class TwoEmissionsStrategy implements IEmissionsStrategy {
    @Override
    public int computeEmissionsFee(IVehicle vehicle) {
        return (int)Math.min(vehicle.co2Emissions() - 1100, 10.0);
    }
}
