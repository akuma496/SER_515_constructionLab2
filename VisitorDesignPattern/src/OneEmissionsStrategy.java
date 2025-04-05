public class OneEmissionsStrategy implements IEmissionsStrategy {
    @Override
    public int computeEmissionsFee(IVehicle vehicle) {
        return (int)Math.min(vehicle.co2Emissions() - 1000, 0.0); 
    }
}

