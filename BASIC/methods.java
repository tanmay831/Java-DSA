
class Computer{
    public void playMusic(){
        System.out.println("Playing the Music");
        return;
    }

    public String getmypen(int cost){
        if(cost>=10){
        return "pen";
        }else{
            return "Nothing";
        }
    }
}


public class methods{
    public static void main(String[] args) {
        Computer obj = new Computer();
        String str=obj.getmypen(1);
        System.out.println(str);
        obj.playMusic();

    }
}