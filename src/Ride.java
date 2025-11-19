public class Ride implements RideInterface {

        private String rideName;
        private String rideType;
        private Employee operator;

        public Ride() {
        }

        public Ride(String rideName, String rideType, Employee operator) {
            this.rideName = rideName;
            this.rideType = rideType;
            this.operator = operator;
        }

        public String getRideName() {
            return rideName;
        }

        public void setRideName(String rideName) {
            this.rideName = rideName;
        }

        public String getRideType() {
            return rideType;
        }

        public void setRideType(String rideType) {
            this.rideType = rideType;
        }

        public Employee getOperator() {
            return operator;
        }

        public void setOperator(Employee operator) {
            this.operator = operator;
        }

    @Override
    public void addVisitorToQueue(Visitor visitor) {

    }

    @Override
    public void removeVisitorFromQueue() {

    }

    @Override
    public void printQueue() {

    }

    @Override
    public int numberOfVisitors() {
        return 0;
    }

    @Override
    public void printRideHistory() {

    }

    @Override
    public void runOneCycle() {

    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return false;
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {

    }
}
