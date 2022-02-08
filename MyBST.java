import java.util.*;

//comparable is an interface that allows for the compareTo method which returns
//an integer type
public class MyBST<E extends Comparable<E>> {
    private TreeNode<E> root;

    //is empty method
    public boolean isEmpty() {
        return root == null;
    }

    //add/insert method
    public boolean insert(E element) {
        TreeNode<E> newTreeNode = new TreeNode<E>(element);

        if(!isEmpty()) {
            //need two runners tracking where we are
            TreeNode<E> current = root;
            TreeNode<E> parent = root; //initializes as null
            while(current != null) {
                if(element.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                }
                else if (element.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                }
                else return false; //otherwise there is a duplication
            }
            //after the while loop 2 things can happen
            //it will reach the end and either add the new node to the left
            //branch or the right branch
            if(element.compareTo(parent.element) < 0) {
                parent.left = newTreeNode;
            }
            else {
                parent.right = newTreeNode;
            }


        }
        else { //if empty, the first element in the tree
            root = newTreeNode;
        }
        return true;
    }


    //search method
    public boolean search(E key) {
        TreeNode<E> current = root;
        while(current != null) {
            if(key.compareTo(current.element) < 0) {
                current = current.left;
            }
            else if(key.compareTo(current.element) > 0) {
                current = current.right;
            }
            else
                return true; //is found
        }
        return false; //key is not found in the BS tree
    }

    //print method dfs (depth first search)
    public void print() {

        System.out.println("dfs inorder");
        dfs();
        System.out.println();
        System.out.println("dfs preorder");
        dfsPreOrder();
        System.out.println();
        System.out.println("dfs postorder");
        dfsPostOrder();
        System.out.println();
        System.out.println("bfs");
        bfs();
    }

    private void dfs() {
        //inorder recursive implementation
        dfs(root);
    }
    //helper method for dfs
    private void dfs (TreeNode<E> current) {
        //keepings going while
        if(current != null) {
            dfs(current.left);
            System.out.print(current.element + " ");
            dfs(current.right);
        }
    }

    //dfs preorder method
    private void dfsPreOrder() {
        dfsPreOrder(root);
    }
    private void dfsPreOrder(TreeNode<E> current) {
        if(current != null) {
            System.out.print(current.element + " ");
            dfs(current.left);
            dfs(current.right);
        }
    }

    //dfs postorder method
    private void dfsPostOrder() {
        dfsPostOrder(root);
    }
    private void dfsPostOrder(TreeNode<E> current) {
        if(current != null) {
            dfs(current.left);
            dfs(current.right);
            System.out.print(current.element + " ");

        }
    }

    private void bfs() {
        if(!isEmpty()) {
            Queue<TreeNode<E>> queue = new LinkedList<TreeNode<E>>();
            queue.add(root);
            while(!queue.isEmpty()) {
                TreeNode<E> tempNode = queue.poll();
                System.out.print(tempNode.element + " ");

                //enqueue left
                if(tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                //queue right
                if(tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
            System.out.println("tree is empty!");
        }
    }

    //need to implement bfs ourselves and other orders

    //delete
    public boolean delete(E element) {
        if(!isEmpty()) {
            //runners
            TreeNode<E> current = root;
            TreeNode<E> parent = root;
            while(current != null) {
                if(element.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                }
                else if(element.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                }
                else break; //break when find current
            }
            //case 1
            if(current.left == null) {
                if(current == root)
                    root = current.right;
                else {
                    if(element.compareTo(parent.element) < 0) {
                        parent.left = current.right;
                    }
                    else {
                        parent.right = current.right;
                    }
                }
            } //end of case 1
            //case 2
            else {
                TreeNode<E> parentOfRightMost = current;
                TreeNode<E> rightMost = current.left;

                //looking for right most
                while(rightMost.right != null) {
                    parentOfRightMost = rightMost;
                    rightMost = rightMost.right;
                }

                current.element = rightMost.element;
                if(rightMost.equals(current.left)) {
                    parentOfRightMost.left = rightMost.left;
                }
                else {
                    parentOfRightMost.right = rightMost.left;
                }
            }//end of case 2
            return true; //deleted
        }
        return false; //not deleted
    }

}

//generic <E>
class TreeNode<E> {
    E element;
    TreeNode<E> left;
    TreeNode<E> right;

    //constructor
    TreeNode(E element) {
        this.element = element;
    }
}
