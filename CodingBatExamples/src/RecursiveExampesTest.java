import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RecursiveExampesTest {

	@Test
	public void test1() {
		RecursiveExampes re = new RecursiveExampes();
		
		int a = re.factorial(5);
		int e = 120;
		
		assertEquals(e,a);
	}
	
	@Test
	public void test2() {
		RecursiveExampes re = new RecursiveExampes();
		
		int e = 5;
		int a = re.bunnyEars2(2);
		
		assertEquals(e,a);
	}

}
