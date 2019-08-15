import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;



class SPTTest {
	
    @BeforeAll
    static void setUp() {
       
    }
	
	private int[][] populateEdges(int size) {
		Random r = new Random();
		
        int[][] edges = new int[size][size];
        
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                edges[i][j] = r.nextInt(41);
               
                if(edges[i][j] == 0) {
                    edges[i][j] = -1;
                }
               
                if(i == j) {
                    edges[i][j] = -1;
                }
            }
        }
        return edges;
	}
	
	private int calculateMinLength(int[][] edges, int source) {
		int length = 0;
        int[] answer;
        try {
            answer = SPT.findSPT(edges, source);
            for(int i = 0; i < answer.length; i++) {
                int connectedNode = answer[i];
                if(connectedNode != -1) {
                    length += edges[connectedNode][i];
                }
            }
        } catch (InvalidSourceException | InvalidGraphException | LoopDetectedException | NoPathException e) {
            fail("Exception thrown when it shouldn't have");
        }
        return length;
	}
	
	@Test
	void testUndirectedGraph() {
		int source = 0;
		
		int[][] edgesOfNineNodes = {{-1, 4, -1, -1, -1, -1, -1, 8, -1},
                {4, -1, 8, -1, -1, -1, -1, 11, -1},
                {-1, 8, -1, 7, -1, 4, -1, -1, 2},
                {-1, -1, 7, -1, 9, 14, -1, -1, -1},
                {-1, -1, -1, 9, -1, 10, -1, -1, -1},
                {-1, -1, 4, 14, 10, -1, 2, -1, -1},
                {-1, -1, -1, -1, -1, 2, -1, 1, 6},
                {8, 11, -1, -1, -1, -1, 1, -1, 7},
                {-1, -1, 2, -1, -1, -1, 6, 7, -1}};
		try {
			int[] actualAnswer = SPT.findSPT(edgesOfNineNodes, source);
			int[] answer= {-1, 0, 1, 2, 5, 6, 7, 0, 2};
			assertArrayEquals("Method return is wrong Answer", answer, actualAnswer);
		} catch(InvalidSourceException | InvalidGraphException | LoopDetectedException | NoPathException e) {
			fail("Exception thrown when it shouldn't have");
		}
		
		int source2 = 2;
        int[][] edgesOfSixNodes =  {{-1, 7, 9, -1, -1, 14},
                {7, -1, 10, 15, -1, -1},
                {9, 10, -1, 11, -1, 2},
                {-1, 15, 11, -1, 6, -1},
                {-1, -1, -1, 6, -1, 9},
                {14, -1, 2, -1, 9, -1}};
		try {
			int[] actualAnswer = SPT.findSPT(edgesOfSixNodes, source2);
			int[] answer= {2,2,-1,2,5,2};
			assertArrayEquals("Method return is wrong Answer", answer, actualAnswer);
		} catch(InvalidSourceException | InvalidGraphException | LoopDetectedException | NoPathException e) {
			fail("Exception thrown when it shouldn't have");
		}
		
	}
	
	@Test
    void testDirectedGraphs() {
        //directed edges
        int source = 0;
        int[][] directedEdgesNineNodes = {{-1, 8, 4, 11, -1, -1, -1},
                                    {-1, -1, -1, 1, 3, -1, -1},
                                    {-1, -1, -1, 9, -1, 6, -1},
                                    {-1, -1, -1, -1, 4, 4, 17},
                                    {-1, -1, -1, -1, -1, -1, 13},
                                    {-1, -1, -1, -1, -1, -1, 15},
                                    {-1, -1, -1, -1, -1, -1, -1}};
        try {
            int[] actualAnswer = SPT.findSPT(directedEdgesNineNodes, source);
            int[] expectedAnswer = {-1, 0, 0, 1, 1, 2, 4};
            assertArrayEquals("The method doesn't give the right answer", expectedAnswer, actualAnswer);
        } catch (InvalidSourceException | InvalidGraphException | LoopDetectedException | NoPathException e) {
            fail("Exception thrown when it shouldn't have : " + e.getMessage());
        }
       
        source = 2;
        int[][] directedEdgesSixNodes = {{-1, -1, 2, -1, -1, -1},
                                   {5, -1, -1, 4, -1, -1},
                                   {-1, 8, -1, -1, 7, -1},
                                   {-1, -1, -1, -1, 6, 3},
                                   {-1, -1, -1, -1, -1, 1},
                                   {-1, -1, -1, -1, -1, -1}};
        try {
            int[] actualAnswer = SPT.findSPT(directedEdgesSixNodes, source);
            int[] expectedAnswer = {1, 2, -1, 1, 2, 4};
            assertArrayEquals("The method doesn't give the right answer", expectedAnswer, actualAnswer);
        } catch (InvalidSourceException | InvalidGraphException | LoopDetectedException | NoPathException e) {
            fail("Exception thrown when it shouldn't have : " + e.getMessage());
        }
       
    }
	@Test
	void nullSource() {
		int[][] edges = {{-1,5,4},{5,-1,3},{4,3,-1}};
		Integer source = null;
		
		assertThrows(NullPointerException.class, () -> SPT.findSPT(edges, source));
	}
	
	@Test
	void nullEdgesTest() {
		int[][] edges =  null;
		Integer source = 0;
		
		assertThrows(NullPointerException.class, () -> SPT.findSPT(edges, source));
	}
	
	@Test
	void testWrongDimensionArray() {
		java.util.Random r = new java.util.Random();
		
		int size = r.nextInt(100)+5;
		
		int[][] edges = populateEdges(size);
		int source = 0;
		
		try {
			assertEquals("SPT returns wrong number of elements", SPT.findSPT(edges, source).length,size);
		} catch(InvalidSourceException | InvalidGraphException | LoopDetectedException | NoPathException e) {
			fail("Exception thrown when it shouldn't have");
		}
	}
	
	@Test
	void testNegativevalue() {
		Random r = new Random();
		int source = 0;
		int negativeValueCheck =0;
		int size = r.nextInt(100)+5;
		int[][] edges = populateEdges(size);
		int[] returnArray;
		try {
			returnArray = SPT.findSPT(edges, source);
			for(int value : returnArray) {
				if(value ==  -1) {
					negativeValueCheck++;
				}
			}
			assertEquals("There is One Negative value in SPT",negativeValueCheck,1);
		} catch(InvalidSourceException | InvalidGraphException | LoopDetectedException | NoPathException e) {
			fail("Exception thrown when it shouldn't have");
		}
	}
	
	@Test
	void testForValueLessThanLowerBound() {
		Random r = new Random();
		int source = 0;
		int size = r.nextInt(100)+5;
		int[][] edges = populateEdges(size);
		int[] returnArray;
		
		try {
			returnArray = SPT.findSPT(edges, source);
			for(int value : returnArray) {
				if(value <  -1) {
					fail("There is a Value less than -1 in SPT");
				}
			}

		} catch(InvalidSourceException | InvalidGraphException | LoopDetectedException | NoPathException e) {
			fail("Exception thrown when it shouldn't have");
		}
	}
	
	@Test
	void testWrongSource() {
		int[][] edges = {{-1,7,9,-1,-1,14},
						{7,-1,10,15,-1,-1},
						{9,10,-1,11,-1,2},
						{-1,15,11,-1,6,-1},
						{-1,-1,-1,6,-1,9},
						{14,-1,2,-1,9,-1}};
		try {
			for(int i=0; i<edges.length; i++) {
				int source = i;
				assertEquals("source isn't -1", SPT.findSPT(edges, source)[source],-1);
			}
		} catch(InvalidSourceException | InvalidGraphException | LoopDetectedException | NoPathException e) {
			fail("Exception thrown when it shouldn't have");
		}
	}
	
	@Test
	void wrongEdgeArrayDimensionsTest() {
		int[][] edges = {{-1,1,2,-1},{1,-1,-1,3}};
		int root =0;
		assertThrows(InvalidGraphException.class, () ->SPT.findSPT(edges, root));
		
		int[][] edges2 = {{-1,1},{-1,1,4},{2,4},{-1,5,10,-1}};
		assertThrows(InvalidGraphException.class, () ->SPT.findSPT(edges2, root));
	}
	
	@Test
	void sourceBelowBoundTest() {
		int[][] edges = {{-1,7,9,-1,-1,14},
						{7,-1,10,15,-1,-1},
						{9,10,-1,11,-1,2},
						{-1,15,11,-1,6,-1},
						{-1,-1,-1,6,-1,9},
						{14,-1,2-1,9,-1}};
		Random r = new Random();
		int source = r.nextInt(9998) - 10000;
		assertThrows(InvalidSourceException.class, () -> SPT.findSPT(edges,source));
		}
	
	@Test
	void noEdgeTest() {
		int[][] edges = new int[0][0];
		int root = 0;
		assertThrows(InvalidSourceException.class, () -> SPT.findSPT(edges,root));
	}
	
	@Test 
	void sourceJustAboveBounds() {
		Random r = new Random();
		int size = r.nextInt(999)+1;
		
		int[][] edges = populateEdges(size);
		int source = size;
		
		assertThrows(InvalidSourceException.class, () -> SPT.findSPT(edges,source));
	}
	
	@Test
	void sourceAboveBound() {
		int[][]	edges = {{-1,7,9,-1,-1,14},
						{7,-1,10,15,-1,-1},
						{9,10,-1,11,-1,2},
						{-1,15,11,-1,6,-1},
						{-1,-1,-1,6,-1,9},
						{14,-1,2,-1,9,-1}};
		Random r = new Random();
		int source = r.nextInt(999) + edges.length + 1;
		
		assertThrows(InvalidSourceException.class, () -> SPT.findSPT(edges,source));
		}

	@Test
	void loopDetection() {
		int edges[][] = {{-1,9,7,-1,-1,-1,-1},
						{-1,-1,-1,4,8,-1,-1},
						{-1,-1,-1,6,-1,5,-1},
						{-1,-1,-1,-1,-1,-1,7},
						{-1,-1,-1,-1,2,-1,11},
						{-1,-1,-1,-1,-1,-1,15},
						{-1,-1,-1,-1,-1,-1,8}};
		int source  = 0;
		
		assertThrows(LoopDetectedException.class, () -> SPT.findSPT(edges, source));
		}
	
	@Test
	void unconnectedGraphTest() {
		int[][] edges = {{-1,3,-1,8,-1,-1},
					{3,-1,5,-1,-1,-1},
					{-1,5,-1,6,-1,-1},
					{8,-1,6,-1,-1,-1},
					{-1,-1,-1,-1,-1,21},
					{-1,-1,-1,-1,21,-1}};
		int source = 0;
		
		assertThrows(NoPathException.class, () -> SPT.findSPT(edges, source));
		
	int[][] edges2 = {{-1,-1,-1,-1,2},
					  {-1,-1,-1,-1,-1},
					  {-1,-1,-1,-1,-1},
					  {-1,-1,3,-1,-1},
					  
					  {7,-1,-1,-1,-1}};
		assertThrows(NoPathException.class, () -> SPT.findSPT(edges2, source));
	}
	
	@Test
	void noNodeConnected() {
		int[][] edges = {{-1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1}};
        int source = 0;
       
        assertThrows(NoPathException.class, () -> SPT.findSPT(edges, source)); 
	}
	
	@Test
	void  multipleRoutes()  {
        int[][] edges =     {{-1, 1, -1, 1},
                {-1, -1, -1, 2},
                {-1, 2, -1, -1},
                {-1, -1, 3, -1}};

        int length = calculateMinLength(edges, 0);
        assertEquals("Total weight of shortest path tree wasn't correct", 5, length);
	}
	
	@Test
	void undirectedCycle() {
		int[][] undirectedEdges = {{-1,3,-1,4},
								   {3,-1,7,-1},
								   {-1,7,-1,2},
								   {4,-1,2,-1}};
		int source =0;
		
		try {
			int[] answer = {-1,0,3,0};
			assertArrayEquals("Can't handle cycles", SPT.findSPT(undirectedEdges, source),answer);
		}  catch(InvalidSourceException | InvalidGraphException | LoopDetectedException | NoPathException e) {
			fail("Exception thrown when it shouldn't have");
		}
	}
	
	@Test
	void directedCycle() {
		int[][] directedEdges = {{-1, 1, -1, 1},
                {-1, -1, -1, 2},
                {-1, 2, -1, -1},
                {-1, -1, 3, -1}};
        int source = 0;
               
        try {
            int[] actualAnswer = {-1, 0, 3, 0};
            assertArrayEquals("Algorithm can't deal with cycles", SPT.findSPT(directedEdges, source), actualAnswer);
        } catch (InvalidSourceException | InvalidGraphException | LoopDetectedException | NoPathException e) {
            fail("Exception shouldn't have been thrown");
        }
		
	}
}
