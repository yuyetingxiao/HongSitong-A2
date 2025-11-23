public class AssignmentTwo {
        public static void main(String[] args) {
                    partThree();
                }

                public static void partThree() {
                    System.out.println("=== Part3 Test waiting queue ===");
                    Employee emp = new Employee("张三", 30, "13800138000", "EMP001", "Roller coaster");
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
        public void partFourA() {}

        public void partFourB() {}

        public void partSix() {}

        public void partSeven() {}

        public void partFive() {}
}
