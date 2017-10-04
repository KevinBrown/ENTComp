package Project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class WarehouseController {
    private final List<Station> stations = new ArrayList<>(10);
    private final List<ConveyorBelt> conveyors = new ArrayList<>(20);

    public static void main(final String[] args ) throws FileNotFoundException {
        WarehouseController warehouse = new WarehouseController();
        warehouse.initializeStations( new File("C:\\Users\\Kevin\\IdeaProjects\\EnterpriseComputingProject2\\src\\config.txt" ) );
        warehouse.run();
    }

    Class<? extends ConveyorBelt> getConveyor ( int id ) {
        return conveyors.get(id).getClass();
    }

    private void initializeStations(final File name) throws FileNotFoundException {
        final Scanner in = new Scanner(name);
        final int numStations = in.nextInt();

        for( int i = 0; i < numStations; ++i ) {
            final ConveyorBelt belt = new ConveyorBelt(i, i, (i + 1) % numStations );
            conveyors.add(belt);

            final int conveyorNum;

            if ( i == 0 ) {
                conveyorNum = numStations - 1;
            } else {
                conveyorNum =  i;
            }

            final Station current = new Station(i, conveyorNum , i );
            current.setWorkloadRemaining(in.nextInt());
            stations.add(current);
        }
    }

    private void run() {
        printSimulationStatusMessage( "BEGINS");

        for ( int i = 0; i < stations.size(); ++i ) {

            stations.get(i).start();

        }

        printSimulationStatusMessage("ENDS");
    }

    private void printSimulationStatusMessage ( String msg ) {
        System.out.println("* * * SIMULATION " + msg + " * * *\n");
    }
}
