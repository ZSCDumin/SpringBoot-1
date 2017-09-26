# SpringBoot+EasyUI 小案例  

### 项目介绍  
你好，这是一个通过**SpringBoot+EasyUI**实现的一个对后台数据库进行增删改查的小例子。它是一个通过JPA的方式实现与数据库交互，再通过将数据库中的消息封装成**JSON**格式传递给**EasyUI**框架来实现前台与后台交互的流程。  
### 项目实现  
首先，我们需要建立一个**MySQL**数据库中的表，它的功能是存储接下来我们要实现更删改查的数据。然后，我们在**Springboot**的代码中分别建立好controller、entity、service以及view四个文件夹。它们分别用来存放负责调度数据库和显示层的代码、实体类、与数据库交互代码和渲染页面的代码。   
**实体类**  
```java
@Entity
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private Integer age;
    private String address;
    private String school;
    private Integer studentID;


}

```  
与数据库交互  
```java
public interface StudentProperies extends JpaRepository<Student,Integer> {
}
```  
在**Springboot**中通过继承```JpaRepository```接口的方式是在对数据库的访问十分简单就像这样既可以实现。  
调度数据库和显示层的代码
```java
@RestController
public class StudentController {

    @Autowired
    private StudentProperies studentProperies;

    @RequestMapping("/show")
    public List<Student> studentList(){
        return studentProperies.findAll();
    }

    @RequestMapping("/add")
    public Integer studentAdd(@RequestParam(value = "name",required=false) String name,
                              @RequestParam(value = "age",required = false) Integer age,
                              @RequestParam(value = "address",required = false) String address,
                              @RequestParam(value = "school",required = false) String school,
                              @RequestParam(value = "studentID",required = false) Integer studentID){


    }


    @RequestMapping("/update")
    public Integer studentUpdate(@RequestParam(value = "ID",required = false) Integer id,
                                 @RequestParam(value = "name",required=false) String name,
                                 @RequestParam(value = "age",required = false) Integer age,
                                 @RequestParam(value = "address",required = false) String address,
                                 @RequestParam(value = "school",required = false) String school,
                                 @RequestParam(value = "studentID",required = false) Integer studentID){

    }
    @RequestMapping("/delete")
    public Integer studentDelete(@RequestParam(value = "ID",required = false) Integer id){
        try{
            studentProperies.delete(id);
            return 1;
        }catch (Exception e){
            return 0;
        }

    }
}
```   
渲染页面  
```java
@Controller
public class StudentView {

    @RequestMapping()
    public String findAll(){

    }
}
```   
以上这些就是我实现的大致流程。  
### 结束语  
我个人认为程序设计的核心就是处理数据流的交互问题。虽然这个例子本身很简单，但是如果你能够自己完全动手做一遍，对你了解前端页面是如何与后台程序交互一定是大有用处的。
