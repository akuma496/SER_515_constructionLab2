public class AltVehicleInspection implements IVehicleInspector {
  @Override
  public int visit(Car car) {
      int serviceCharge = 3120;
      if(car.getColor()=="Black"){
          serviceCharge += 1200;
      }else{
          serviceCharge += 530;
      }
      System.out.println("AltService Charge for Car: " + serviceCharge);
      return serviceCharge;
  }

  @Override
  public int visit(Van van) {
      int serviceCharge = 10;
      if(van.getNumberOfDoors()>4){
          serviceCharge += 5020;
      }else{
          serviceCharge += 1100;
      }
      System.out.println("AltService Charge for Van: " + serviceCharge);
      return serviceCharge;
  }

  @Override
  public int visit(Motorbike motorbike) {
      int serviceCharge = 20;
      if(motorbike.getEngineCapacity()>=200){
          serviceCharge += 1200;
      }else{
          serviceCharge += 520;
      }
      System.out.println("AltService Charge for Motorbike: " + serviceCharge);
      return serviceCharge;
  }
}
