public class Act2VehicleService {
    //Goal is to create singleton, using private constructors and static blocks
    private static Act2VehicleService instance;
    private IVehicleInspector vehicleInspector;

    private Act2VehicleService(String viProperty) {
        if (viProperty == null) {
            throw new IllegalArgumentException("vi property cannot be null");
        }
        this.vehicleInspector = VehicleFactory.getVehicleInspector(viProperty);
    }

    static {
        String viProp = System.getProperty("vi");
        instance = new Act2VehicleService(viProp);
    }

    public static Act2VehicleService getInstance() {
        return instance;
    }

    public int calculateTotal(IVehicle[] vehicles) {
        int total = 0;
        for (IVehicle vehicle : vehicles) {
            total += vehicle.accept(vehicleInspector);
        }
        return total;
    }
}
