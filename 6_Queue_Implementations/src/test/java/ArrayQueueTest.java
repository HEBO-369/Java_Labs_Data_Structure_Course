import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ArrayQueueTest {

    @Test
    public void testInitialState() {
        ArrayQueue queue = new ArrayQueue();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    public void testEnqueueAndDequeueSingleItem() throws Exception {
        ArrayQueue queue = new ArrayQueue();
        queue.enqueue(10);
        
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());
        
        Object item = queue.dequeue();
        assertEquals(10, item);
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    public void testEnqueueMultipleItems() throws Exception {
        ArrayQueue queue = new ArrayQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        
        assertEquals(3, queue.size());
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testDequeueMultipleItems() throws Exception {
        ArrayQueue queue = new ArrayQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        
        assertEquals(10, queue.dequeue()); 
        assertEquals(20, queue.dequeue());
        assertEquals(30, queue.dequeue());
        
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    public void testDequeueOnEmptyQueue() {
        ArrayQueue queue = new ArrayQueue();
        assertThrows(Exception.class, queue::dequeue);
    }

    @Test
    public void testToString() throws Exception {
        ArrayQueue queue = new ArrayQueue();
        assertEquals("[]", queue.to_String());
        
        queue.enqueue(10);
        assertEquals("[10]", queue.to_String());
        
        queue.enqueue(20);
        queue.enqueue(30);
        assertEquals("[30, 20, 10]", queue.to_String());
    }

    @Test
    public void testMixedOperations() throws Exception {
        ArrayQueue queue = new ArrayQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.dequeue();
        
        assertEquals(1, queue.size());
        assertEquals(20, queue.dequeue()); 
        
        queue.enqueue(30);
        queue.enqueue(40);
        
        assertEquals(2, queue.size());
        assertEquals("[40, 30]", queue.to_String());
        
        queue.dequeue();
        queue.dequeue();
        
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testQueueOrder() throws Exception {
        ArrayQueue queue = new ArrayQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        
        assertEquals(10, queue.dequeue());
        assertEquals(20, queue.dequeue());
        assertEquals(30, queue.dequeue());
    }

    @Test
    public void testLargeNumberOfItems() throws Exception {
        ArrayQueue queue = new ArrayQueue();
        for (int i = 0; i < 100; i++) {
            queue.enqueue(i);
        }
        
        assertEquals(100, queue.size());
        
        for (int i = 0; i < 100; i++) {
            assertEquals(i, queue.dequeue());
        }
        
        assertTrue(queue.isEmpty());
    }
}