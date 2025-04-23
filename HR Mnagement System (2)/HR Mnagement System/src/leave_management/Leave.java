package leave_management;

class Leave {
    String employeeId;
    String leaveType;
    String fromDate;
    String toDate;
    String status; // Pending, Approved, Rejected

    public Leave(String employeeId, String leaveType, String fromDate, String toDate) {
        this.employeeId = employeeId;
        this.leaveType = leaveType;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.status = "Pending";
    }
}
