package analyzer;

import java.lang.annotation.*;

/**
 * Annotation for indicate the initialization of methods.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Init {
}
