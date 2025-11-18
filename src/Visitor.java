 public class Visitor extends Person {
        private String visitorCardId;
        private boolean hasFastPass;

        public Visitor() {
            super();
        }

        public Visitor(String name, int age, String phone, String visitorCardId, boolean hasFastPass) {
            super(name, age, phone);
            this.visitorCardId = visitorCardId;
            this.hasFastPass = hasFastPass;
        }

        public String getVisitorCardId() {
            return visitorCardId;
        }

        public void setVisitorCardId(String visitorCardId) {
            this.visitorCardId = visitorCardId;
        }

        public boolean isHasFastPass() {
            return hasFastPass;
        }

        public void setHasFastPass(boolean hasFastPass) {
            this.hasFastPass = hasFastPass;
        }

        @Override
        public String toString() {
            return "Visitor{" +
                    "Name='" + getName() + '\'' +
                    ", Age=" + getAge() +
                    ", Phone='" + getPhone() + '\'' +
                    ", VisitorCardID='" + visitorCardId + '\'' +
                    ", HasFastPass=" + (hasFastPass ? "Yes" : "No") +
                    '}';
        }
}
