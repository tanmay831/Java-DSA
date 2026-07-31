import java.util.*;

class Teacher {
    String name;
    Teacher(String name) { this.name = name; }
}

class Department {
    String deptName;
    List<Teacher> teachers;

    Department(String deptName, List<Teacher> teachers) {
        this.deptName = deptName;
        this.teachers = teachers;
    }
}

class Engine {
    String type;
    Engine(String type) { this.type = type; }
}

class CarEngine {
    private Engine engine; // Composition

    CarEngine(String type) {
        this.engine = new Engine(type);
    }

    void start() {
        System.out.println("Engine started: " + engine.type);
    }
}

public class Relationships {
    public static void main(String[] args) {
        Teacher t = new Teacher("Sharma Sir");
        List<Teacher> list = new ArrayList<>();
        list.add(t);
        Department dept = new Department("CS", list);
        System.out.println("Dept: " + dept.deptName + ", Teacher: " + dept.teachers.get(0).name);

        CarEngine car = new CarEngine("V8");
        car.start();
    }
}
