import java.lang.reflect.Array;
import java.util.*;

public class Kata {

    public static int[] arrayDiff(int[] a, int[] b) {

        ArrayList<Integer> result = new ArrayList<>();
        for (int i:a) {
            if (!findOccurence(i,b))result.add(i);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    public static boolean findOccurence(int a,int[] b){

        for (int i:b) {
            if (i==a)return true;
        }

        return false;
    }

    public static List<Integer> treeByLevels(Node node)
    {
        List<Integer> result = new ArrayList<>();
        if(node==null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()){
            Node next = queue.remove();
            result.add(next.value);

            if (next.left!=null)queue.add(next.left);
            if (next.right!=null)queue.add(next.right);
        }
        return result;
    }

    public static long getSumOfAllDivisors(long a){
        long sum = 0;

        for (int i=1; i<=a;i++){
            if (a%i==0) sum+= i;
        }
        return sum;
    }

    public static String buddy(long start, long limit) {

        if (getSumOfAllDivisors(start)==(limit+1)&&getSumOfAllDivisors(limit)==(start+1))return "("+getSumOfAllDivisors(start)+" "+getSumOfAllDivisors(limit)+")";
        else return "Nothing";
    }

    public boolean isInList(List<Node> nodes, Node node){
        for (Node nodeOfNodes: nodes) {
            if(node.equals(nodeOfNodes))return true;
        }
        return false;
    }

    public int getSum(List<Node> nodes, Node node){
        int length = nodes.size();
        return (length - nodes.indexOf(node))+1;
    }



    //Kata.treeByLevels(new Node(new Node(null, new Node(null, null, 4), 2), new Node(new Node(null, null, 5), new Node(null, null, 6), 3), 1)));
}
