import java.util.*;
import java.io.*;

class Node{
    public int val;
    public int x;
    public int y;
    public Node left;
    public Node right;
    
    public Node(int val, int x, int y, Node left, Node right){
        this.val = val;
        this.x = x;
        this.y = y;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    int[][] res;
    int idx=0;
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer;
        Node[] nodes = new Node[nodeinfo.length];
        for(int i =0;i<nodeinfo.length;i++){
            nodes[i] = new Node(i+1,nodeinfo[i][0],nodeinfo[i][1],null,null);
        }
        
        //정렬규칙 Y는 내림차순 X는 오름차순
        Arrays.sort(nodes,new Comparator<Node>(){
            public int compare(Node a , Node b){
                if(a.y==b.y){
                    return a.x-b.x;
                }
                return b.y-a.y;
            }
        } );
        
        Node parent = nodes[0];
        for(int i=1;i<nodes.length;i++){
            makeTree(parent,nodes[i]);
        }
        res = new int[2][nodeinfo.length];
        
        preorder(parent);
        idx=0;
        postorder(parent);
        answer =res;
        
        return answer;
    }
    
    public void makeTree(Node parent, Node child){
        if(parent.x < child.x){ // child의 x값이 더 크면 오른쪽
            if(parent.right == null){
                parent.right = child;
            } else {
                makeTree(parent.right,child);
            }
        } else {
            if(parent.left == null){
                parent.left = child;
            } else {
                makeTree(parent.left,child);
            }
        }
    }
    
    public void preorder(Node root){
        if(root != null){
            res[0][idx++] = root.val;
            preorder(root.left);
            preorder(root.right);
        }
    }
    
    public void postorder(Node root){
        if(root != null){
            postorder(root.left);
            postorder(root.right);
            res[1][idx++] = root.val;
        }
    }
}