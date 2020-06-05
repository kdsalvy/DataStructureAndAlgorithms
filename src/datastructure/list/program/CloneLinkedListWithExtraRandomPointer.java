package datastructure.list.program;

/**
 * Clone a linked list which has two pointers next and a random pointer which can point to any of the nodes
 * @author saukedia1
 *
 */
public class CloneLinkedListWithExtraRandomPointer {

    static class RandomPointerNode {
        RandomPointerNode next;
        RandomPointerNode random;
        int data;
        @Override
        public String toString() {
            return "RandomPointerNode [next=" + next + ", random=" + random.data + ", data=" + data + "]\n";
        }
        
        
    }

    public static RandomPointerNode cloneList(RandomPointerNode srcHead) {
        RandomPointerNode cloneHead = null;

        // create new node cloning old node's data
        // point new node random to old node random
        // insert it between old node and old node.next
        createNewNodeAndLinkAfterOldNode(srcHead);
        // point the random pointer of cloned nodes to the correct node
        initializeRandomPointerOfClones(srcHead);
        // fix src List to its original state and point cloned node's next
        // pointer to correct node
        cloneHead = fixCloneNSrcRandomPointer(srcHead, cloneHead);

        return cloneHead;
    }

    private static RandomPointerNode fixCloneNSrcRandomPointer(RandomPointerNode srcHead, RandomPointerNode cloneHead) {
        cloneHead = srcHead.next;
        RandomPointerNode temp = srcHead;
        RandomPointerNode temp2 = cloneHead;
        while (temp!= null && temp.next != null) {
            temp.next = temp2.next;
            temp = temp.next;
            temp2 = temp == null? temp : temp.next;
        }
        return cloneHead;
    }

    private static void initializeRandomPointerOfClones(RandomPointerNode srcHead) {
        RandomPointerNode temp = srcHead;
        while (temp!= null && temp.next != null) {
            temp.next.random = temp.random.next;
            temp = temp.next.next;
        }
    }

    private static void createNewNodeAndLinkAfterOldNode(RandomPointerNode srcHead) {
        RandomPointerNode temp = srcHead;
        while (temp != null) {
            RandomPointerNode nodeClone = new RandomPointerNode();
            nodeClone.data = temp.data;
            nodeClone.next = temp.next;
            temp.next = nodeClone;
            temp = temp.next.next;
        }
    }

    public static void main(String[] args) {
        RandomPointerNode head = new RandomPointerNode();
        head.data = 1;
        RandomPointerNode temp = head;
        
        int i = 1;
        // create list with next pointing to the next Node
        while (i < 5) {
            i++;
            temp.next = new RandomPointerNode();
            temp = temp.next;
            temp.data = i;
        }
        
        temp = head;
        temp.random = head.next.next; // 1 -> 3
        temp.next.random = head.next.next.next.next; // 2 -> 5
        temp.next.next.random = head.next.next.next; // 3 -> 4
        temp.next.next.next.random = head.next; // 4 -> 2
        temp.next.next.next.next.random = head; // 5 -> 1
        
        RandomPointerNode headClone = cloneList(head);
        
        System.out.println(head);
        System.out.println(headClone);
    }
}
