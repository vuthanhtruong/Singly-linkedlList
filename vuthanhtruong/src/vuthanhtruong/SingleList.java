package vuthanhtruong;

public class SingleList {
    Node pHead;

    public SingleList() {
        pHead = null;
    }

    public void Initialize() {
        pHead = null;
    }

    public Node CreateNode(int d) {
        return new Node(d);
    }

    public void PrintList() {
        Node pTmp = pHead;
        if (pTmp == null) {
            System.out.println("The list is empty!");
            return;
        }

        while (pTmp != null) {
            System.out.print(pTmp.data + " ");
            pTmp = pTmp.pNext;
        }
    }

    public int SizeOfList() {
        Node pTmp = pHead;
        int nSize = 0;

        while (pTmp != null) {
            pTmp = pTmp.pNext;
            nSize++;
        }

        return nSize;
    }

    public void InsertFirst(int d) {
        Node pNode = CreateNode(d);

        if (pHead == null) {
            pHead = pNode;
        } else {
            pNode.pNext = pHead;
            pHead = pNode;
        }
    }

    public void InsertLast(int d) {
        Node pNode = CreateNode(d);

        if (pHead == null) {
            pHead = pNode;
        } else {
            Node pTmp = pHead;
            while (pTmp.pNext != null) {
                pTmp = pTmp.pNext;
            }
            pTmp.pNext = pNode;
        }
    }

    public boolean InsertMid(int pos, int d) {
        if (pos < 0 || pos > SizeOfList()) {
            return false;
        } else {
            Node pNode = CreateNode(d);

            if (pos == 0 || pHead == null) {
                pNode.pNext = pHead;
                pHead = pNode;
                return true;
            } else {
                Node pIns = pHead;
                Node pPre = null;
                int i = 0;

                while (i < pos) {
                    pPre = pIns;
                    pIns = pIns.pNext;
                    i++;
                }

                pPre.pNext = pNode;
                pNode.pNext = pIns;
                return true;
            }
        }
    }

    public void Remove(int d) {
        Node pTmp = pHead;
        Node pPre = null;

        // If the first node contains the data to be removed
        if (pTmp != null && pTmp.data == d) {
            pHead = pTmp.pNext; // Change head
            return;
        }

        // Search for the node with the given data
        while (pTmp != null && pTmp.data != d) {
            pPre = pTmp;
            pTmp = pTmp.pNext;
        }

        // If the data was not found in the list
        if (pTmp == null) {
            return;
        }

        // Unlink the node from the linked list
        pPre.pNext = pTmp.pNext;
    }

    public void reverseOutput() {
        for (int j = 0; j < SizeOfList(); j++) {
            Node node = pHead;
            for (int i = 0; i < SizeOfList() - j; i++) {

                if (i == SizeOfList() - j - 1) {
                    System.out.println(node.data);
                }

                node = node.pNext;
            }

        }
    }

    public String Search(int d) {
        Node pTmp = pHead;
        String oknhe = "";
        int i = 0;
        int j = 0;

        while (pTmp != null) {
            if (pTmp.data == d) {
                oknhe += i + " ";

                j++;
            }
            pTmp = pTmp.pNext;
            i++;

        }
        if (j > 0) {
            return oknhe;
        } else {
            return "";
        }
    }
    
    private Node mergeSort(Node head) {
        // Base case: If the list is empty or has only one element, return the head
        if (head == null || head.pNext == null)
            return head;
        
        // Split the list into two halves
        Node middle = getMiddle(head);
        Node nextofMiddle = middle.pNext;
        middle.pNext = null;
        
        // Recursively sort the two halves
        Node left = mergeSort(head);
        Node right = mergeSort(nextofMiddle);
        
        // Merge the sorted halves
        return merge(left, right);
    }
    
    private Node getMiddle(Node head) {
        if (head == null) 
            return head;
        
        Node slow = head;
        Node fast = head;
        
        while (fast.pNext != null && fast.pNext.pNext != null) {
            slow = slow.pNext;
            fast = fast.pNext.pNext;
        }
        
        return slow;
    }


    private Node merge(Node left, Node right) {
        // Create a dummy node as the head of the merged list
        Node dummy = new Node(0);
        Node tail = dummy;
        
        // Merge the two sorted lists
        while (left != null && right != null) {
            if (left.data <= right.data)
                tail.pNext = left;
            else
                tail.pNext = right;
            
            if (left.data <= right.data)
                left = left.pNext;
            else
                right = right.pNext;
            
            tail = tail.pNext;
        }
        
        // Append the remaining nodes of left or right list
        if (left != null) {
            tail.pNext = left;
        } else {
            tail.pNext = right;
        }
        
        // Return the head of the merged list
        return dummy.pNext;
    }

    
    public void BubbleSort() {
        int n = SizeOfList();
        if (n <= 1) {
            return; // Danh sách đã được sắp xếp hoặc rỗng, không cần sắp xếp
        }

        boolean swapped;
        Node current;
        Node next = null;

        do {
            swapped = false;
            current = pHead;

            while (current.pNext != next) {
                if (current.data > current.pNext.data) {
                    // Hoán đổi giá trị
                    int temp = current.data;
                    current.data = current.pNext.data;
                    current.pNext.data = temp;
                    swapped = true;
                }
                current = current.pNext;
            }
            next = current; // current là node cuối cùng đã được sắp xếp, không cần so sánh nữa
        } while (swapped);
    }
 


}
