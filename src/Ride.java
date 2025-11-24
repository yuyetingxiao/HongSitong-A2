import java.util.LinkedList;
import java.util.Iterator;
import java.util.Queue;
import java.util.Collections;

public class Ride implements RideInterface {

        private String rideName;
        private String rideType;
        private Employee operator;
        private Queue<Visitor> waitingQueue = new LinkedList<>();
        private LinkedList<Visitor> rideHistory = new LinkedList<>();
        public Ride() {
        }

        public Ride(String rideName, String rideType, Employee operator) {
            this.rideName = rideName;
            this.rideType = rideType;
            this.operator = operator;
        }
        public void sortRideHistory() {
          if (rideHistory.isEmpty()) {
            System.out.println("Error:[" + rideName + "]'s ride history is empty and cannot be sorted!");
            return;
        }
        Collections.sort(rideHistory, new VisitorComparator());
        System.out.println("[" + rideName + "]'s ride history has been completed (in ascending order of age → alphabetical order of names)!");
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

            if (visitor != null) {
                rideHistory.add(visitor);
                System.out.println("The visitor [" + visitor.getName() + "] has been successfully added to the ride history of[" + rideName + "]!");
            } else {
                System.out.println("Invalid tourist object! Unable to add to the history record!");
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
            int count = rideHistory.size(); // LinkedList的size()方法：获取元素个数
            System.out.println("[" + rideName + "]'s ride history record has " + count + "people！");
            return count;
    }

    @Override
    public void printRideHistory() {
            if (rideHistory.isEmpty()) {
                System.out.println("[" + rideName + "]'s ride history is empty!");
                return;
            }
            System.out.println("[" + rideName + "]'s ride history record（A total of " + rideHistory.size() + "people）：");
            Iterator<Visitor> iterator = rideHistory.iterator();
            int index = 1;
            while (iterator.hasNext()) {
                Visitor v = iterator.next();
                System.out.println(index + ". " + v);
                index++;
            }
    }

    @Override
    public void runOneCycle() {

    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
            if (visitor == null) {
                System.out.println("Error: the visitor object is invalid!");
                return false;
            }
            for (Visitor v : rideHistory) {
                if (v.getVisitorCardId().equals(visitor.getVisitorCardId())) {
                    System.out.println("Visitor[" + visitor.getName() + "]（CardID：" + visitor.getVisitorCardId() + "） is in [" + rideName + "]'s history record！");
                    return true;
                }
            }
            System.out.println("Visitor[" + visitor.getName() + "]（CardID：" + visitor.getVisitorCardId() + "） is not in [" + rideName + "]'s history record!");
            return false;
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
            if (visitor != null) {
                rideHistory.add(visitor);
                System.out.println("Tourist [" + visitor.getName() + "] has been successfully added to [" + rideName + "]'s history record！");
            } else {
                System.out.println("The visitor object is invalid and cannot be added to the history record!");
            }
        }
}

