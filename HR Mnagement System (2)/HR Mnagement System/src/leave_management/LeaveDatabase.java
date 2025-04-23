package leave_management;
import java.util.ArrayList;

public class LeaveDatabase {
    public static ArrayList<Leave> leaveList = new ArrayList<>();

    public static void addLeave(Leave leave) {
        leaveList.add(leave);
    }

    public static ArrayList<Leave> getLeavesByEmployee(String empId) {
        ArrayList<Leave> result = new ArrayList<>();
        for (Leave leave : leaveList) {
            if (leave.employeeId.equals(empId)) {
                result.add(leave);
            }
        }
        return result;
    }
}
