package Project2;

final class ConveyorBelt {
    private final int conveyorId;
    private final int stationOneId;
    private final int stationTwoId;
    private int stationInUse;
    private boolean inUse;

    public ConveyorBelt (final int id, final int from, final int to) {
        conveyorId = id;
        stationOneId = from;
        stationTwoId = to;
    }

    boolean isInUse() {
        return inUse;
    }

    boolean useConveyor(int stationId) {
        if ( !inUse ) {
            stationInUse = stationId;
            return true;
        }
        return false;
    }

    void releaseConveyor() {
        inUse = false;

        if ( stationInUse == stationOneId ) {
            // signal station 2
        } else {
            // signal station 1
        }
    }

    int getConveyorId() {
        return conveyorId;
    }
}
