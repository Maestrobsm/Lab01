package analyzer;

import java.lang.annotation.*;

/**
 * Annotation for indicate classes for the bootloader.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Service {

    boolean lazyLoad() default  false;
}