 class Mobile {
    String NAME ;
    int price ;
    String brand;

    public void show(){
        System.out.print(NAME +""+ price+ ""+ brand);
    }

}


public class Static{
    public static void main(String[] args) {
     Mobile mb = new Mobile();

     mb.NAME="appple";
     mb.price=1900;
     mb.brand= "smartphone" ;
        
     
     mb.show();
     
    }
}