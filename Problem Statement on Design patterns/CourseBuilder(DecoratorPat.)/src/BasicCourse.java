public class BasicCourse implements Course {
    @Override
    public double getCost() {
        return 50.0; // Base price for a simple course
    }

    @Override
    public String getDescription() {
        return "Basic Online Course";
    }
}
