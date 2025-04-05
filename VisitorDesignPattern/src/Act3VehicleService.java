public class Act3VehicleService {
    //Goal is to create singleton, using private constructors and static blocks
    private static Act3VehicleService instance;
    private IVehicleInspector vehicleInspector;
    private IEmissionsStrategy emissionsStrategy;

    private Act3VehicleService(IVehicleInspector inspector, IEmissionsStrategy emissionsStrategy) {
        this.vehicleInspector = inspector;
        this.emissionsStrategy = emissionsStrategy;
    }

    private static IEmissionsStrategy getEmissionsStrategy(String esType) {
        switch (esType) {
            case "one":
                return new OneEmissionsStrategy();
            case "two":
                return  new TwoEmissionsStrategy();
            default:
                return new NullEmissionsStrategy();
        }
    }

    static {
        String viProp = System.getProperty("vi");
        IVehicleInspector inspector = VehicleFactory.getVehicleInspector(viProp);
        String esType = System.getProperty("es");
        IEmissionsStrategy emissionsStrategy = getEmissionsStrategy(esType);
        instance = new Act3VehicleService(inspector, emissionsStrategy);
        
    }

    public static Act3VehicleService getInstance() {
        return instance;
    }

    public int calculateTotal(IVehicle[] vehicles) {
        int total = 0;
        for (IVehicle vehicle : vehicles) {
            total += vehicle.accept(vehicleInspector) + emissionsStrategy.computeEmissionsFee(vehicle);
        }
        return total;
    }
}
