public class HashTableTest {
    public static void main(String[] args) {
        MyHashTable<TestingField, Student> table = new MyHashTable<>();

        // Insert 10,000 random elements
        for (int i = 0; i < 10000; i++) {
            TestingField key = new TestingField("Key" + (int)(Math.random() * 10000));
            Student value = new Student("Student" + i, (int)(Math.random() * 100));
            table.put(key, value);
        }

        // Print the number of elements in each bucket
        System.out.println("Distribution of elements across buckets:");
        table.printBucketCounts();
    }
}
