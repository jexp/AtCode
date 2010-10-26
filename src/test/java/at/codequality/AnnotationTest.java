package at.codequality;

public class AnnotationTest {

	@Code.Smell.LongMethod(
			priority = Code.Priority.HIGH, 
			rating = Code.Rating._5, 
			comment = "This is too large...", 
			reporter = "dirk.mahler@buschmais.com")
	@Code.Refactoring.ExtractMethod(
			comment="It should be split in ...", 
			reporter="dirk.mahler@buschmais.com")
	public void longMethod() {
		// 1000 lines
	}

}