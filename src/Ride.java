import java.util.LinkedList;
import java.util.Iterator;
import java.util.Queue;
import java.util.Collections;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Comparator;

public class Ride implements RideInterface {

    private String rideName;
    private String rideType;
    private Employee operator;
    private Queue<Visitor> waitingQueue = new LinkedList<>();
    private LinkedList<Visitor> rideHistory = new LinkedList<>();
    private int maxRider;
    private int numOfCycles = 0;

    public Ride(String rideName, String rideType, Employee operator, int maxRider) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
        this.maxRider = maxRider;
    }

    public void exportRideHistory(String filePath) {
        if (rideHistory.isEmpty()) {
            System.out.println("Error:[" + rideName + "]'s ride history is empty, no need to export!");
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Name, age, phone number, visitor card number, do you have a fast pass");
            writer.newLine();

            for (Visitor v : rideHistory) {
                String line = v.getName() + "," +
                        v.getAge() + "," +
                        v.getPhone() + "," +
                        v.getVisitorCardId() + "," +
                        (v.isHasFastPass() ? "Yes" : "No");
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Successfully exported [" + rideName + "]'s ride history to a file:" + filePath);
        } catch (IOException e) {
            System.out.println("Error: Exporting file failed! Reason:" + e.getMessage());
        }
    }

    public void importRideHistory(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNum = 0;
            while ((line = reader.readLine()) != null) {
                lineNum++;
                if (lineNum == 1) {
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length != 5) {
                    System.out.println("Warning: The format of the " + lineNum + "th line is incorrect, skip this line!");
                    continue;
                }
                String name = parts[0];
                int age;
                try {
                    age = Integer.parseInt(parts[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Warning: The age format on the " + lineNum + "th line is incorrect, skip this line!");
                    continue;
                }
                String phone = parts[2];
                String cardId = parts[3];
                boolean hasFastPass = parts[4].equals("Yes");

                Visitor v = new Visitor(name, age, phone, cardId, hasFastPass);
                rideHistory.add(v);
            }
            System.out.println("Successfully imported the travel history of " + (lineNum - 1) + " tourist records from file [" + filePath + "] to [" + rideName + "]!");
        } catch (IOException e) {
            System.out.println("Error: Import file failed! Reason:" + e.getMessage());
        }
    }

    public Ride(String rideName, String rideType, Employee operator) {
        this(rideName, rideType, operator, 10);
    }

    public int getMaxRider() {
        return maxRider;
    }

    public void setMaxRider(int maxRider) {
        if (maxRider >= 1) {
            this.maxRider = maxRider;
        } else {
            System.out.println("Error: The maximum number per period must be at least 1. It has been set to 1 by default!");
            this.maxRider = 1;
        }
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }

    public void sortRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("Error:[" + rideName + "]'s ride history is empty and cannot be sorted!");
            return;
        }
        Collections.sort(rideHistory, new Comparator<Visitor>() {
            @Override
            public int compare(Visitor v1, Visitor v2) {
                if (v1.getAge() != v2.getAge()) {
                    return Integer.compare(v1.getAge(), v2.getAge());
                }
                return v1.getName().compareTo(v2.getName());
            }
        });
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
    }

    @Override
    public void removeVisitorFromQueue() {
        if (waitingQueue.isEmpty()) {
            System.out.println("The waiting queue for [" + rideName + "] is empty. It is not possible to remove the visitor!");
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
        int count = rideHistory.size();
        System.out.println("[" + rideName + "]'s ride history record has " + count + " people！");
        return count;
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("[" + rideName + "]'s ride history is empty!");
            return;
        }
        System.out.println("[" + rideName + "]'s ride history record（A total of " + rideHistory.size() + " people）：");
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
        if (this.operator == null) {
            System.out.println("Error：[" + rideName + "] is not assigned an operator and cannot operate!");
            return;
        }

        if (waitingQueue.isEmpty()) {
            System.out.println("Error：[" + rideName + "]'s waiting queue is empty, unable to run!");
            return;
        }

        System.out.println("\n=== [" + rideName + "] starts running for the " + (numOfCycles + 1) + " cycle（ with a maximum of " + maxRider + " people per cycle）===");
        int count = 0;
        while (count < maxRider && !waitingQueue.isEmpty()) {
            Visitor rider = waitingQueue.poll();
            rideHistory.add(rider);
            System.out.println("Visitor [" + rider.getName() + "] has taken [" + rideName + "]");
            count++;
        }
        numOfCycles++;
        System.out.println("=== The " + numOfCycles + " cycle of [" + rideName + "], with a total of " + count + " people riding ===");
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
