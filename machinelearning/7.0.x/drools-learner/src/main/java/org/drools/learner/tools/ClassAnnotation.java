package org.drools.learner.tools;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface ClassAnnotation {
	String labelElement() default "";
}
