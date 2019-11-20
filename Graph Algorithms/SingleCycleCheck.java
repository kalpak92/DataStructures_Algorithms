/**
 * Given a array of integers. Each integer represents a jump of its value in the array.
 * For Instance, the integer 2 represents a jumo of 2 indices forward in teh array and
 * the integer -3 represents a jump of 3 indices backward in the array.
 * 
 * If a jump spills past the array's bounds, it wraps over to the other side.
 * 
 * Write a function that returns a boolean representing whether the jump in the array
 * form a single cycle. A single cycle occurs, if starting at any index in the array
 * and following the jumps, every element is visisted exactly once before landing back on the starting index.
 * 
 */


class SingleCycleCheck {
    public static boolean hasSingleCycle(int[] array) {
      int elementVisited = 0;	// no. of element visited
          int currentId = 0;
          
          while(elementVisited < array.length)
          {
              if(elementVisited > 0 && currentId == 0)
                  return false;
              
              elementVisited += 1;
              currentId = getNextId(currentId, array);
          }
          
          return (currentId == 0) ? true : false;
    }
      
    private static int getNextId(int currentId, int[] array)
    {
        int jump = array[currentId];
        int nextId = (jump + currentId) % (array.length);
        
        return (nextId >= 0) ? nextId : nextId + array.length;
    }
  }
  