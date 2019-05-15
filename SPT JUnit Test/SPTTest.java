import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Exceptions.*;

class SPTTest {
	private SPT sptInstance;
	private int[][] edges;
	private int source;
	@BeforeEach
	public void setUp() {
		sptInstance = new SPT();
	}
	
	//CASE 1
	@Test
	void invalidSourceExceptionThrown() {
		source = -1;
		assertThrows(InvalidSourceException.class , () -> sptInstance.findSPT(edges, source));
	}
	
	//CASE 2
	@Test
	void invalidGraphExceptionThrown() {
		
	}
	
	//CASE 3
	@Test
	void loopDetectedExceptionThrown() {
		
	}
	//CASE 4
	@Test
	void noPathExceptionThrown() {
		
	}
	//CASE 5
	@Test
	void visitMethodTest() {
		
	}
	//CASE 6
	@Test
	void findSPTTest() {
		
	}
	//CASE 7
	@Test
	void checkIfEdgesAreNull() {
		
	}
	//CASE 8
	@Test
	void checkEdgesInputNormalFindSPT() {
		
	}
	//CASE 9
	@Test
	void checkSourceInputNormalFindSPT() {
		
	}
	//CASE 10
	@Test
	void checkEdgesInputNormalVisit() {
		
	}
	//CASE 11
	@Test
	void checkCurrentInputNormalVisit() {
		
	}
	//CASE 12
	@Test
	void checkVisitedInputNormalVisit() {
		
	}
	//CASE 13
	@Test
	void checkDistanceInputNormalVisit() {
		
	}
	//CASE 14
	@Test
	void checkParentInputNormalVisit() {
		
	}
}
