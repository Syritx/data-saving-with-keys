public class Main {
    
    public static void main(String[] args) {

        DataService.saveFloat(100.001f, "keyHere");
        float data = DataService.getFloat("keyHere");

        System.out.println(data);
    }
}