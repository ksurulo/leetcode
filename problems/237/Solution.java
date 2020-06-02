/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        deleteNode(node,null);
    }
    public void deleteNode(ListNode node,ListNode previous){
        
    if(node.next==null){
        previous.next=null;
        return;
    }
    
    ListNode nextNode=node.next;
    int node1Val=node.val;
    int node2Val=nextNode.val;
    node.val=node2Val;
    nextNode.val=node1Val;
    deleteNode(nextNode,node);
    }
}