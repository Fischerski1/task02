public class Main {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(5, 3);
        myHashMap.put(3, 4);
        System.out.println(myHashMap.toString());
        myHashMap.put(3, 6);
        System.out.println(myHashMap.toString());
        myHashMap.put(1, 8);
        System.out.println(myHashMap.toString());
        myHashMap.put(4, 4);
        System.out.println(myHashMap.toString());
        myHashMap.put(2, 4);
        myHashMap.put(null, 7);
        System.out.println(myHashMap.toString());

        System.out.println(myHashMap.get(5));
        System.out.println(myHashMap.get(3));
        System.out.println(myHashMap.get(333));
        System.out.println(myHashMap.get(null));

        System.out.println("MyHashMap size=" + myHashMap.getSize());

        System.out.println(myHashMap.containsKey(5));
        System.out.println(myHashMap.containsKey(null));

        System.out.println(myHashMap);
        System.out.println(myHashMap.remove(5));
        System.out.println(myHashMap);
        System.out.println(myHashMap.remove(null));
        System.out.println(myHashMap);
        System.out.println(myHashMap.remove(4));
        System.out.println(myHashMap);
        System.out.println(myHashMap.remove(-2));


    }
}
