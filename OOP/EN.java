
class Student {
    private int marks ;

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        if(marks >=0 && marks <= 100){
        this.marks = marks;
    }else{
        System.out.println("invaild marks ");
    }

    }

    
}

public class EN {
    public static void main(String args []){
     Student obj = new Student();

     obj.setMarks(150);
    // obj.setMarks(150);
    System.out.println(obj.getMarks());

    }
}
