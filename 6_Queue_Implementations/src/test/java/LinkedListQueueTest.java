import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
public class LinkedListQueueTest {

    @Test
    public void testInitialState() {
        LinkedListQueue queue = new LinkedListQueue();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    public void testEnqueueAndDequeueSingleItem() throws Exception {
        LinkedListQueue queue = new LinkedListQueue();
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
        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        
        assertEquals(3, queue.size());
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testDequeueOnEmptyQueue() {
        LinkedListQueue queue = new LinkedListQueue();
        assertThrows(Exception.class, queue::dequeue);
    }

    @Test
    public void testFrontOnEmptyQueue() {
        LinkedListQueue queue = new LinkedListQueue();
        assertThrows(Exception.class, queue::front);
    }

    @Test
    public void testToString() throws Exception {
        LinkedListQueue queue = new LinkedListQueue();
        assertEquals("[]", queue.to_String());
        
        queue.enqueue(10);
        assertEquals("[10]", queue.to_String());
        
        queue.enqueue(20);
        queue.enqueue(30);
        assertEquals("[30, 20, 10]", queue.to_String());
    }

}