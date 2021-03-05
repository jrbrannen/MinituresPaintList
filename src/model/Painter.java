/**
 * 
 */
package model;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="painters")
/**
 * @author Jeremy Brannen - jrbrannen
 *CIS175
 * Mar 3, 2021
 */
public class Painter {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PAINTER_ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="AGE")
	private int age;
	@Column(name="TECHNIQUE")
	String technique;
//	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
//	@JoinTable(name="paints", joinColumns={ @JoinColumn(name="Id", referencedColumnName="Id")}, inverseJoinColumns= {@JoinColumn(name="Id", referencedColumnName = "Id", unique = true)})
//	private List<Paint> collectionOfPaints;
	
	public Painter() {
		super();
	}

	public Painter(String name, int age, String technique) {
		super();
		this.name = name;
		this.age = age;
		this.technique = technique;
	}

	public Painter(String name) {
		super();
		this.name = name;
	}

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTechnique() {
		return technique;
	}

	public void setTechnique(String technique) {
		this.technique = technique;
	}
	
//	public List<Paint> getCollectionOfPaints() {
//		return collectionOfPaints;
//	}
//
//	public void setCollectionOfPaints(List<Paint> collectionOfPaints) {
//		this.collectionOfPaints = collectionOfPaints;
//	}

	@Override
	public String toString() {
		return "Painters [id=" + id + ", name=" + name + ", age=" + age + ", technique=" + technique + "]";
	}
	
	
	
}
