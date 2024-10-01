import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        var MyArrayList = new ArrayList<String>();
        var MyTestList = new ArrayList<String>();

        MyTestList.add("Test1");
        MyArrayList.add("Add1");
        MyArrayList.size();

        MyArrayList.addAll(MyTestList);
        MyArrayList.size();

        System.out.println();
        MyArrayList.remove(0);
    }
}