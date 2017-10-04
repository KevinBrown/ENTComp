package Project2;

final class Station extends Thread {
    private final int stationId;
    private final ConveyorBelt firstConveyor;
    private final ConveyorBelt secondConveyor;
    private int workloadRemaining = 0;

    Station (final int id, final ConveyorBelt firstConveyor, final ConveyorBelt secondConveyor) {
        stationId = id;

        this.firstConveyor = firstConveyor;
        printStationMessage( "In-Connection set to conveyor " + firstConveyor);

        this.secondConveyor = secondConveyor;
        printStationMessage("Out-Connection set to conveyor " + id);
    }

    public void run () {
        while ( workloadRemaining > 0 ) {
            try {
                reserveConveyor(firstConveyor);
                reserveConveyor(secondConveyor);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            finishPackage(firstConveyor.getConveyorId());
            finishPackage(secondConveyor.getConveyorId());

            --workloadRemaining;

            releaseConveyor(firstConveyor);
            releaseConveyor(secondConveyor);

            printStationMessage("has " + workloadRemaining + "package groups left to move.");
        }

        System.out.println( "* * " + getStationMessageHeader() + "Workload successfully completed. * *");
    }

    final void setWorkloadRemaining(final int packages ) {
        workloadRemaining = packages;
        printStationMessage("Workload set. Station " + stationId + " has " + workloadRemaining
                + " package groups to move.");
    }

    private void reserveConveyor(final ConveyorBelt belt) throws InterruptedException {
        boolean success = false;

        while ( !success ) {
            if ( belt.isInUse() ) {
                Thread.sleep(50);
                continue;
            }
            success = belt.useConveyor(stationId);
        }

        printStationMessage("granted access to conveyor " + belt.getConveyorId());
    }

    private void releaseConveyor (final ConveyorBelt belt) {
        belt.releaseConveyor();
        printStationMessage("released access to conveyor " + belt.getConveyorId());
    }

    private void finishPackage (final int conveyorId) {
        printStationMessage( "successfully moves packages on conveyor " + conveyorId + ".");
    }

    private void printStationMessage (final String msg) {
        System.out.println(getStationMessageHeader() + msg);
    }

    private String getStationMessageHeader () {
        return "Station " + stationId + ": " ;
    }

}
