public class ProjectDecorator extends CourseDecorator {

    public ProjectDecorator(Course decoratedCourse) {
        super(decoratedCourse);
    }

    @Override
    public double getCost() {
        return super.getCost() + 20.0; // Adding $20 for projects
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", includes projects";
    }
}
