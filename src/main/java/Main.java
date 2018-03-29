import analyzer.AnnotationProcessor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static final List<Long> SIZE_LIST = new ArrayList<>(Arrays.asList(10L, 100L, 1000L, 10000L, 100000L));
    public static void main(String[] args) {

        AnnotationProcessor annotationProcessor = new AnnotationProcessor();
        annotationProcessor.make(SIZE_LIST);
    }
}

