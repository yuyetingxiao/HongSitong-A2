import java.util.LinkedList;
import java.util.Queue;

public class Ride implements RideInterface {

        private String rideName;
        private String rideType;
        private Employee operator;
        private Queue<Visitor> waitingQueue = new LinkedList<>();

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
            if (visitor != null) {
                waitingQueue.offer(visitor);
                System.out.println("Successfully added a visitor to [" + rideName + "] the waiting queue：" + visitor.getName());
            } else {
                System.out.println("Error: Invalid tourist object, cannot be added to the queue!");
            }
    }

    @Override
    public void removeVisitorFromQueue() {
            if (waitingQueue.isEmpty()) {
                System.out.println("Corrected translation: The waiting queue for [" + rideName + "] is empty. It is not possible to remove the visitor!");
            } else {
                Visitor removedVisitor = waitingQueue.poll();
                System.out.println("Successfully removed a visitor from the waiting queue at [" + rideName + "]:" + removedVisitor.getName());
            }
    }

    @Override
    public void printQueue() {
            if (waitingQueue.isEmpty()) {
                System.out.println("[" + rideName + "]'s waiting queue is empty!");
                return;
            }
            System.out.println("[" + rideName + "]'s waiting queue（A total of " + waitingQueue.size() + " people）");
            int index = 1;
            for (Visitor v : waitingQueue) {
                System.out.println(index + ". " + v);
                index++;
            }
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
