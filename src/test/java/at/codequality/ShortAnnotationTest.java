package at.codequality;

import at.codequality.Code.Refactoring.ExtractMethod;
import at.codequality.Code.Smell.LongMethod;

public class ShortAnnotationTest {

	@LongMethod
	@ExtractMethod
	public void longMethod() {
		// 1000 lines
	}
}
