import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

/* YOUR TARGET METHOD IS: add(int priority, int item) 
 *
 * FINAL EXAM NON-CODING ANSWERS
 ********************************************************
 * 1. Using Git. Clone and pull the repository for your exam.
 *    Add your name and banner ID to Tests.java, commit and push.
 *    You have used Git.
 *    NOTE: To get full marks you MUST perform a commit after
 *          each question.  This way, if something goes wrong
 *          I can check each part separately and give you the
 *          marks you deserve.
 ANSWER HERE:
 * Eyafee Al Hossain
 * B00904384


 *
 * 2a. Give three (3) test cases for the TARGET method (see above)
 *     Each test case should be one line long.
 ANSWER HERE:
 * addNodes() - The test case checks if adding nodes to a TrinaryHeap data structure produces the correct ordering according to node priorities.
 * addToFilledHeap() - The test case verifies if adding a new node to a filled TrinaryHeap results in the node with lower priority being removed and the new node being added in the correct position.
 * addToBlankHeap() - The test case checks if adding a node to an empty TrinaryHeap results in the correct node being added to the top of the heap.

 * 2b. Implement the unit tests below (after all these comments).
 *
 * 3. Debug the issues causing your tests to fail.
 *    There are at least a couple bugs in the code.
 *    Add more unit tests if necessary.
 *    List bugs you found and fixed below.  Give
 *    - a brief description of each bug
 *    - method where the bug occurs
 *    - how you fixed the problem
ANSWER HERE:
* Line 89-
* In the original code, the node that is moved up during the first call to trickleUp() is the node at index
* size - 1, which is the node that was just added to the heap. In the modified code, the node that is moved
* up during the first call to trickleUp() is the node at index size, which is currently null since it is the
* next index to be filled.The argument is size - 1, while in the modified code, the argument is simply size.
*
* Line 52 - Inialized the empty heap
*


* 4a.  Identify three (3) locations in the code where assertions
*      are appropriate. Give
*      - method where assertion should be used
*      - what the assertions should assert
ANSWER HERE:
* Line 62 TrinaryHeap()
* Line 77 TrinaryHeap()
* Line 88 add()
*


* 4b. Write the assertions in the code.
*
* 5a. Suggest one (1) exception that is appropriate
*     for the TARGET method and one (1) exception somewhere
*     else in the code.
*     State the condition under which the exceptions should be
*     thrown.
ANSWER HERE: An appropriate exception that is an exception to the
* TARGET method in the code snippet is the IllegalArgumentException.
*  This exception is thrown when the priority argument is negative,
* indicating that the priority must be a non-negative integer.
*


* 5b. Implement the exceptions you suggested.
*
* 5c. Add new unit tests to test that the exceptions are thrown when
*     appropriate.
*
* 6a. Identify three (3) procedural refactorings that can be
*     done in the code.  Give
*    - a brief description of each issue
*    - the method where the issue is
*    - how to fix the issue
ANSWER HERE:


* 6b. Perform the refactorings on the code.  Be sure to do regression testing
*
* * TrinaryHeap.Java- Line 134 - Procedural Refactoring - The function checks if the current node contains the target
* item by comparing the "item" parameter to the "item" field of the node at the current index. If the target item is
* found, the function returns true. If the current index is greater than or equal to the size of the tree, the function
*  returns false because the target item was not found in the tree.
*
*
* TrinaryHeap.Java- Line 322 - Procedural Refactoring - The method works by first creating a
* StringBuilder object called "s". Then, it loops over all the nodes in the heap using a for loop
* that iterates from 0 to the "size" of the heap. During each iteration, the method appends the
* "item" field of the current node to the StringBuilder object "s", followed by a space character. After the loop completes, the method cre
*
* TrinaryHeap.Java- Line 173 - Procedural Refactoring -
*
* 7. Identify three (3) class-level refactorings that can be
*     done in the code.  Give
*    - a brief description of each issue
*    - where the issue is
*    - what SOLID principle (if any) are violated
*    - whether a class implementation or class interface refactoring
*      is needed
*    - how to fix the issue (note: do not do the refactoring!)
ANSWER HERE:

* Issue: the Constructor has arraylist and location is Trinary level constractor and its need class level refactoring. Fix interface instead of
* arraylist

* Issue: The TrinaryHeap class has a public instance variable nodes. This allows direct access to the
internal state of the class and can lead to unwanted modifications.Location: TrinaryHeap class. Violation of SOLID: Encapsulation Principle. Refactoring needed:
Class interface refactoring. Fix: Change the nodes variable to private and add accessor methods like getNodes() and getSize() to allow controlled access to the internal state of the class.

* Issue: The instance variables of TrinaryHeap (i.e., capacity, nodes, and size) are declared as public, which means they can be accessed and modified from outside the class, violating the encapsulation principle.
Location: TrinaryHeap class.Refactoring type: Class implementation refactoring Fix: Change the access modifier of the instance variables to private and provide getter and/or setter methods as necessary to access or modify them
*******************************************************
* Place written answers above this line
*******************************************************
*/

class Tests {
    /* You can clone and rename this method for all the tests that
     * you will need to do.
     *
     * All tests for all source files should be placed here.
     */
    @Test
    public void addToBlankHeap() {
        TrinaryHeap heap = new TrinaryHeap();
        heap.add(5, 10);
        assertEquals(1, heap.size);
        assertEquals(10, heap.nodes[0].item);
        assertEquals(5, heap.nodes[0].priority);
    }

    @Test
    public void addToFilledHeap() {
        TrinaryHeap heap = new TrinaryHeap();
        heap.add(5, 10);
        heap.add(3, 20);
        assertEquals(2, heap.size);
        assertEquals(20, heap.nodes[0].item);
        assertEquals(3, heap.nodes[0].priority);
        assertEquals(10, heap.nodes[1].item);
        assertEquals(5, heap.nodes[1].priority);
    }

    @Test
    public void addNode(){
        TrinaryHeap heap = new TrinaryHeap();
        heap.add(5, 10);
        heap.add(3, 20);
        heap.add(4, 30);
        heap.add(2, 40);
        heap.add(6, 50);
        assertEquals(5, heap.size);
        assertEquals(40, heap.nodes[0].item);
        assertEquals(2, heap.nodes[0].priority);
        assertEquals(10, heap.nodes[1].item);
        assertEquals(5, heap.nodes[1].priority);
        assertEquals(30, heap.nodes[2].item);
        assertEquals(4, heap.nodes[2].priority);
        assertEquals(20, heap.nodes[3].item);
        assertEquals(3, heap.nodes[3].priority);
        assertEquals(50, heap.nodes[4].item);
        assertEquals(6, heap.nodes[4].priority);
    }

    @Test
    public void addException(){
        TrinaryHeap heap = new TrinaryHeap();
        heap.size = 200;
        try{
            heap.add(5, 10);
            fail("Should have thrown Exception");
        }
        catch(IndexOutOfBoundsException e){
            // Check that the exception type is correct
            assertTrue(e instanceof IndexOutOfBoundsException);
        }
    }
}
