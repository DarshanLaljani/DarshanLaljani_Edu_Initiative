public abstract class CourseDecorator implements Course {
    protected Course decoratedCourse;

    public CourseDecorator(Course decoratedCourse) {
        this.decoratedCourse = decoratedCourse;
    }

    @Override
    public double getCost() {
        return decoratedCourse.getCost();
    }

    @Override
    public String getDescription() {
        return decoratedCourse.getDescription();
    }
}
