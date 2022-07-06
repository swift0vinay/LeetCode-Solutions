/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int n, int m, ListNode head) {
        int ans[][]= new int[n][m];
        for(int[] x:ans){
            Arrays.fill(x,-1);
        }
        ListNode temp = head;
        int row=0,col=0;
        char dir = 'R';
        int count = 0;
        while(temp != null){
            if(count == n*m)
                break;
            if(dir == 'R'){
                if(col<m && ans[row][col] == -1){
                    ans[row][col] = temp.val;
                    temp=temp.next;
                    ++count;
                    ++col;
                } else if (col == m) {
                    dir='D';
                    --col;
                    ++row;
                } else if (ans[row][col] != -1) {
                    dir='D';
                    --col;
                    ++row;
                }
            }else if(dir == 'D') {
                if(row<n && ans[row][col] == -1){
                    ans[row][col] = temp.val;
                    temp=temp.next;
                    ++count;
                    ++row;
                } else if (row == n) {
                    dir='L';
                    --row;
                    --col;
                } else if (ans[row][col] != -1) {
                    dir='L';
                    --row;
                    --col;
                }
            }else if(dir == 'L') {
                if(col>=0 && ans[row][col] == -1) {
                    ans[row][col] = temp.val;
                    temp=temp.next;
                    ++count;
                    --col;
                }else if (col == -1) {
                    dir = 'U';
                    ++col;
                    --row;
                } else if (ans[row][col] != -1) {
                    dir = 'U';
                    ++col;
                    --row;
                }
            }else{
                if(row>=0 && ans[row][col] == -1) {
                    ans[row][col] = temp.val;
                    temp=temp.next;
                    ++count;
                    --row;
                }else if (row == -1) {
                    dir = 'R';
                    ++row;
                    ++col;
                } else if (ans[row][col] != -1) {
                    dir = 'R';
                    ++row;
                    ++col;
                }
            }
        }
        return ans;
    }
}