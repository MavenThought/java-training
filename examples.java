for (int i=0; i < array.length; i++) {
    System.out.println("Element: " + array[i]);
}

for (String element : array) {
    System.out.println("Element: " + element);
}

// Boxing
ArrayList data = new ArrayList();

data.add(new Double(4.0));

Double value = (Double) data.get(0);

// ------
ArrayList<Double> data = new ArrayList<Double>();

data.add(new Double(4.0);

Double value = data.get(0);

double otherValue = data.get(0);

// Enums
public static final int ENV_STAGING    = 0;
public static final int ENV_UAT        = 1;
public static final int ENV_PRODUCTION = 2;
public static final int ENV_TESTING    = 3;

// new enums
enum Environments { Staging, Uat, Production, Testing };
 

// ------- Varargs
Object[] arguments = {
    new Integer(7),
    new Date(),
    "a disturbance in the Force"
};

String result = MessageFormat.format(
    "At {1,time} on {1,date}, there was {2} on planet "
     + "{0,number,integer}.", arguments);
     
// ----
public static String format(String pattern, Object... arguments);
     
String result = MessageFormat.format(
    "At {1,time} on {1,date}," +
    "there was {2} on planet " +
    "{0,number,integer}.", 
    1, 7, “Disturbance”);     
    
// ---- Static import
public interface PhysicalConstants {
  // Avogadro's number (1/mol)
  static final double AVOGADROS_NUMBER = 6.02214199e23;

  // Boltzmann constant (J/K)
  static final double BOLTZMANN_CONSTANT = 1.3806503e-23;

  // Mass of the electron (kg)
  static final double ELECTRON_MASS = 9.10938188e-31;    
}

public class PhysicalConstants {
  // Prevents instantiation
  private PhysicalConstants() { }

  public static final double AVOGADROS_NUMBER = 6.02214199e23;
  public static final double BOLTZMANN_CONSTANT = 1.3806503e-23;
  public static final double ELECTRON_MASS = 9.10938188e-31;
}

import static java.lang.Math.PI;

import static java.lang.Math.*;

// ---------------------------- Generics
public interface List<E> {
  void add(E x);
  Iterator<E> iterator();
}

public interface Iterator<E> {
  E next();
  boolean hasNext();
}

public class ArrayList<E> 
  : implements List<E> {
  
}

List<String> names = new ArrayList<String>();

List<String> ls = new ArrayList<String>(); 
List<Object> lo = ls; 

// ---- Wildcards
printCollection(Collection<?> collection) {
  foreach(Object o: collection) {
    System.out.println(o);
  }
}

// ------ Bounded wildcards
public abstract class Shape {
  public abstract void draw(Canvas c);
}

public class Circle extends Shape {
  private int x, y, radius;
  public void draw(Canvas c) { ... }
}

public class Rectangle extends Shape {
  private int x, y, width, height;
  public void draw(Canvas c) { ... }
}

public class Canvas {
  public void draw(Shape s) {
    s.draw(this);
  }
}

public void drawAll(List<Shape> shapes) {
  for (Shape s: shapes) { s.draw(this); }
}

public void drawAll(List<? extends Shape> shapes) { 
  ... 
}

// ------------ Java EE 5
@Entity public class Movie { ... }

@XmlRootElement(name="employee")
@XmlType(name="EmployeeType")
public class Employee {
   public String name;
   public int salary;
}

@Stateless
@Remote
public class HelloWorldBean {
   public String sayHello() {
      return "Hello World!!!";
   }
}
@Entity
@Table( name = "MOVIES" )
public class Movie {
    ...
}

@Id
@GeneratedValue(generator="increment")
@GenericGenerator(name="increment", strategy = "increment")
public Long getId() {
    return id;
}

@Temporal(TemporalType.TIMESTAMP)
@Column(name = "EVENT_DATE")
public Date getDate() {
    return date;
}

// ------- EJB
try{
  Context ctx = new InitialContext();
  Object proxy = ctx.lookup("service");
  ServiceHome home = (ServiceHome) PortableRemoteObject.narrow(...);
  Service service = home.create();
} catch(Exception ex){ 
  /* omitted */
}


@Stateless
public class ClientBean implements Client {
  @EJB
  private Service service;

  public String getHello() {
    return this.service.getMessage();
  }
}

@MessageDriven(mappedName = "jms/Queue")
public class SampleMessageBean implements MessageListener {
   ...
}

@Stateless
public class BookServiceBean implements BookService {
  @PersistenceContext
  private EntityManager em;

  public void create(Book book) {
  this.em.persist(book);
  }
}
@WebServlet(name="Messenger", urlPatterns={"/Messenger"})
public class Messenger extends HttpServlet {    
    @EJB
    MessageSession session;
}

@Entity
@NamedQueries({
  @NamedQuery(name="findPersonAll", query="SELECT o FROM Person o"),
  @NamedQuery(name="findPersonByName", query="SELECT o FROM Person o WHERE o.name = :name")
})
public class Person implements Serializable {
  static final long serialVersionUID = 2;
  
  private String name;
  private int id;
  private List<Home> homes;
  private List<UserRole> userRoles;
  
  @ManyToMany(mappedBy="persons") 
  protected List<Home> getHomes() {
    return homes;
  }
  
  protected void setHomes(List<Home> homes) {
    this.homes = homes;
  }
  
  @OneToMany(cascade=CascadeType.ALL, mappedBy="person")
  public List<UserRole> getUserRoles() {
    return userRoles;
  }

  public void setUserRoles(List<UserRole> userRoles) {
    this.userRoles = userRoles;
  }
  
  public void addUserRole(UserRole userRole) {
    this.getUserRoles().add(userRole);
    userRole.setPerson(this);
  }

  @Id
  @GeneratedValue
  public int getId() {
    return id;
  }
	
  public void setId(int id) {
    this.id = id;
  }
	
  public String getName() {
    return name;
  }
	
  public void setName(String name) {
    this.name = name;
  }
}

// ----- Java EE 6
@Path ("items")
@Produces (MediaType.APPLICATION_XML)
Public class ItemsResource {

   @GET
   Items listItems() {
       Return Allitems();
   }

   @POST
   @Consumes (MediaType.APPLICATION_XML)
   Public Response create(Item item) throws ItemCreationException {
     ...
   }

   ...
}
   