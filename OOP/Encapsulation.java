
class Human{
    private int num ;
    private String name;
    
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

   
}

public class Encapsulation{
    public static void main(String args []){
    
       
     Human obj = new Human();
     obj.setNum(60);
     obj.setName("tanmay");
     System.out.println(obj.getName()+" "+obj.getNum());
    }
}