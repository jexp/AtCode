package at.codequality;

public class AnnotationTest {

    @Code.Smell.LongMethod(priority = Code.Priority.HIGH, rating = Code.Rating._5)
    public void longMethod() {
        // 1000 lines
    }

}