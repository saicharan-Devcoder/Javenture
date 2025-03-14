

class Main {
    
    public static void main(String[] args) {
        
        StudentDetailsImpl sImpl= new StudentDetailsImpl("sai", 20);
        
        System.out.println(sImpl.getName());
        System.out.println(sImpl.getAge());
        
        
    }
}

interface StudentDetails{
    String getStudentDetails();
    String getName();
    int getAge();
}

class StudentDetailsImpl implements StudentDetails{
    int age;
    String name;
    
    public StudentDetailsImpl(String name, int age){
        this.name=name;
        this.age=age;
    }
    
    public String getStudentDetails(){
        return "Student name:" + this.name + "and age:"+ this.age;
    }
    
    public int getAge(){
        return this.age;
    }
    
     public String getName(){
        return this.name;
    }
    
}



