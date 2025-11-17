public class Employee extends Person {

        private String employeeId;
        private String responsibleRideType;

        public Employee() {
            super();
        }

        public Employee(String name, int age, String phone, String employeeId, String responsibleRideType) {
            super(name, age, phone);
            this.employeeId = employeeId;
            this.responsibleRideType = responsibleRideType;
        }

        public String getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
        }

        public String getResponsibleRideType() {
            return responsibleRideType;
        }

        public void setResponsibleRideType(String responsibleRideType) {
            this.responsibleRideType = responsibleRideType;
        }
}
