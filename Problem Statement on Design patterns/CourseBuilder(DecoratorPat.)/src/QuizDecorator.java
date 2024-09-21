public class QuizDecorator extends CourseDecorator {

    public QuizDecorator(Course decoratedCourse) {
        super(decoratedCourse);
    }

    @Override
    public double getCost() {
        return super.getCost() + 10.0; // Adding $10 for quizzes
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", includes quizzes";
    }
}
