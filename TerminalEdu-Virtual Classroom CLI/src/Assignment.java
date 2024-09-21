import java.util.ArrayList;
import java.util.List;

public class Assignment {
    private String details;
    private List<String> submittedBy;

    public Assignment(String details) {
        this.details = details;
        this.submittedBy = new ArrayList<>();
    }

    public String getDetails() {
        return details;
    }

    public List<String> getSubmittedBy() {
        return submittedBy;
    }

    public void addSubmission(String studentId) {
        submittedBy.add(studentId);
    }
}