package at.codequality;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public @interface Code {
    public enum Priority {
        LOW, NORMAL, HIGH
    }

    public enum Rating {
        _0, _1, _2, _3, _4, _5
    }

    public @interface Smell {

        @Retention(RetentionPolicy.SOURCE)
        @Target(ElementType.METHOD)
        public @interface LongMethod {
            Priority priority() default Priority.NORMAL;

            Rating rating() default Rating._3;
        }
    }
}