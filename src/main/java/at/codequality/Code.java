package at.codequality;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Defines the scope for code quality annotations.
 */
@Retention(RetentionPolicy.SOURCE)
public @interface Code {

	public enum Priority {
		LOW, MEDIUM, HIGH
	}

	public enum Rating {
		_0, _1, _2, _3, _4, _5
	}

	/**
	 * Defines the scope for code smell annotations.
	 */
	@Retention(RetentionPolicy.SOURCE)
	public @interface Smell {

		/**
		 * The longer the method the harder it is to see what it's doing.</b>
		 */
		@Retention(RetentionPolicy.SOURCE)
		@Target(ElementType.METHOD)
		@Documented
		@Refactoring.ExtractMethod
		@Refactoring.IntroduceParameterObject
		@Refactoring.PreserveWholeObject
		@Refactoring.ReplaceTempWithQuery
		@Refactoring.ReplaceMethodwithMethodObject
		public @interface LongMethod {

			Priority priority() default Priority.MEDIUM;

			Rating rating() default Rating._3;

			String comment() default "";

			String reporter() default "";
		}
	}

	/**
	 * Defines the scope for code refactoring annotations.
	 */
	@Retention(RetentionPolicy.SOURCE)
	public @interface Refactoring {
		
		/**
		 * <a href="http://www.refactoring.com/catalog/extractMethod.html">
		 * Extract Method</a>.
		 * <p>
		 * You have a code fragment that can be grouped together.
		 * 
		 * Turn the fragment into a method whose name explains the purpose of
		 * the method.
		 * <p>
		 */
		@Documented
		public @interface ExtractMethod {
			String comment() default "";

			String reporter() default "";
		}

		/**
		 * <a href=
		 * "http://www.refactoring.com/catalog/introduceParameterObject.html"
		 * ></a>.
		 * <p>
		 * You have a group of parameters that naturally go together.
		 * 
		 * Replace them with an object.
		 * </p>
		 */
		@Documented
		public @interface IntroduceParameterObject {
			String comment() default "";

			String reporter() default "";
		}

		/**
		 * <a href=
		 * "http://www.refactoring.com/catalog/replaceMethodWithMethodObject.html"
		 * ></a>.
		 * <p>
		 * You have a long method that uses local variables in such a way that
		 * you cannot apply Extract Method
		 * 
		 * Turn the method into its own object so that all the local variables
		 * become fields on that object. You can then decompose the method into
		 * other methods on the same object.
		 * </p>
		 */
		@Documented
		public @interface ReplaceMethodwithMethodObject {
			String comment() default "";

			String reporter() default "";
		}

		/**
		 * <a
		 * href="http://www.refactoring.com/catalog/preserveWholeObject.html">
		 * Preserve Whole Object</a>
		 * <p>
		 * You are getting several values from an object and passing these
		 * values as parameters in a method call.
		 * 
		 * Send the whole object instead.
		 * </p>
		 * 
		 * @author dirk.mahler
		 * 
		 */
		@Documented
		public @interface PreserveWholeObject {
			String comment() default "";

			String reporter() default "";
		}

		/**
		 * <a href=
		 * "http://www.refactoring.com/catalog/replaceTempWithQuery.html"
		 * >Replace Temp with Query</a>.
		 * <p>
		 * You are using a temporary variable to hold the result of an
		 * expression.
		 * 
		 * Extract the expression into a method. Replace all references to the
		 * temp with the expression. The new method can then be used in other
		 * methods. methods.
		 * </p>
		 */
		@Documented
		public @interface ReplaceTempWithQuery {
			String comment() default "";

			String reporter() default "";
		}

	}

}