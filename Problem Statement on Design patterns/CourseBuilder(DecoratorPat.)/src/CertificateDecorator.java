public class CertificateDecorator extends CourseDecorator {

    public CertificateDecorator(Course decoratedCourse) {
        super(decoratedCourse);
    }

    @Override
    public double getCost() {
        return super.getCost() + 15.0; // Adding $15 for a certificate
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", includes certificate";
    }
}
