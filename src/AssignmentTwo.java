ublic class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo test = new AssignmentTwo();
        test.partThree();
        test.partFourA();
        test.partFourB();
        test.partFive();
        test.partSix();
    }

    public void partThree() {
        System.out.println("=== Part3 Test waiting queue ===");
        Employee emp = new Employee("Zhang San", 30, "13800138000", "EMP001", "Roller coaster");
        Ride rollerCoaster = new Ride("Roller coaster", "Stimulating type", emp);
        Visitor v1 = new Visitor("Li Si", 20, "13900139000", "VIS001", true);
        Visitor v2 = new Visitor("Wang Wu", 25, "13700137000", "VIS002", false);
        Visitor v3 = new Visitor("Zhao Liu", 18, "13600136000", "VIS003", true);
        Visitor v4 = new Visitor("Sun Qi", 30, "13500135000", "VIS004", false);
        Visitor v5 = new Visitor("Zhou Ba", 22, "13400134000", "VIS005", true);

        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.addVisitorToQueue(v3);
        rollerCoaster.addVisitorToQueue(v4);
        rollerCoaster.addVisitorToQueue(v5);
        rollerCoaster.printQueue();
        rollerCoaster.removeVisitorFromQueue();
        System.out.println("\nAfter removing a visitor:");
        rollerCoaster.printQueue();
    }

    public void partFourA() {
                    System.out.println("=== Part4A Test the ride record function ===");
    Employee emp = new Employee("Zhang San", 30, "13800138000", "EMP001", "Carousel");
    Ride merryGoRound = new Ride("Carousel", "Parent-child category", emp);

    Visitor v1 = new Visitor("Xiao Ming", 8, "13900139000", "VIS006", false);
    Visitor v2 = new Visitor("Xiao Hong", 7, "13700137000", "VIS007", false);
    Visitor v3 = new Visitor("Xiao Gang", 9, "13600136000", "VIS008", true);
    Visitor v4 = new Visitor("Xiao Ya", 6, "13500135000", "VIS009", false);
    Visitor v5 = new Visitor("Xiao Qiang", 10, "13400134000", "VIS010", true);

          merryGoRound.addVisitorToHistory(v1);
          merryGoRound.addVisitorToHistory(v2);
          merryGoRound.addVisitorToHistory(v3);
          merryGoRound.addVisitorToHistory(v4);
          merryGoRound.addVisitorToHistory(v5);
          merryGoRound.printRideHistory();
          merryGoRound.checkVisitorFromHistory(v2);
          merryGoRound.numberOfVisitors();
    }

        public void partFourB() {
                System.out.println("\n=== Part4B Sort test history records ===");
                Employee emp = new Employee("Zhang San", 30, "13800138000", "EMP001", "Bumper car");
                Ride bumperCar = new Ride("Bumper car", "Leisure category", emp);

                Visitor v1 = new Visitor("Wang Wu", 25, "13700137000", "VIS002", false);
                Visitor v2 = new Visitor("Zhang San", 20, "13900139000", "VIS001", true);
                Visitor v3 = new Visitor("Li Si", 25, "13600136000", "VIS003", true);
                Visitor v4 = new Visitor("Zhao Liu", 30, "13500135000", "VIS004", false);
                Visitor v5 = new Visitor("Sun Qi", 22, "13400134000", "VIS005", true);

                bumperCar.addVisitorToHistory(v1);
                bumperCar.addVisitorToHistory(v2);
                bumperCar.addVisitorToHistory(v3);
                bumperCar.addVisitorToHistory(v4);
                bumperCar.addVisitorToHistory(v5);

                System.out.println("Previous ride history:");
                bumperCar.printRideHistory();

                bumperCar.sortRideHistory();

                System.out.println("\nSorted passenger history:");
                bumperCar.printRideHistory();
            }
        public void partSix() {
                System.out.println("\n=== Part6 Export test history to a file ===");
                Employee emp = new Employee("Zhang San", 30, "13800138000", "EMP001", "Pirate Ship");
                Ride pirateShip = new Ride("Pirate Ship", "Stimulating category", emp, 3);

                Visitor v1 = new Visitor("A", 20, "139001", "VIS011", true);
                Visitor v2 = new Visitor("B", 21, "139002", "VIS012", false);
                Visitor v3 = new Visitor("C", 22, "139003", "VIS013", true);
                Visitor v4 = new Visitor("D", 23, "139004", "VIS014", false);
                Visitor v5 = new Visitor("E", 24, "139005", "VIS015", true);
                pirateShip.addVisitorToHistory(v1);
                pirateShip.addVisitorToHistory(v2);
                pirateShip.addVisitorToHistory(v3);
                pirateShip.addVisitorToHistory(v4);
                pirateShip.addVisitorToHistory(v5);

                String filePath = "C:\\Users\\yuyetingxiao\\Desktop\\HongSitong-A2\\ride_history.csv";
                pirateShip.exportRideHistory(filePath);

            }

        public void partSeven() {}

        public void partFive() {
            System.out.println("\n=== Part5 Test facility operating cycle ===");
            Employee emp = new Employee("Zhang San", 30, "13800138000", "EMP001", "Roller coaster");
            Ride rollerCoaster = new Ride("Super roller coaster", "Stimulating category", emp, 2);
            for (int i = 1; i <= 10; i++) {
                Visitor v = new Visitor("Visitor" + i, 18 + i, "1380000000" + i, "VIS" + (100 + i), i % 2 == 0);
                rollerCoaster.addVisitorToQueue(v);
            }
            System.out.println("Waiting queue before running：");
            rollerCoaster.printQueue();
            rollerCoaster.runOneCycle();
            System.out.println("\nWaiting queue after running:");
            rollerCoaster.printQueue();
            System.out.println("\nRiding history after operation:");
            rollerCoaster.printRideHistory();
        }
}
