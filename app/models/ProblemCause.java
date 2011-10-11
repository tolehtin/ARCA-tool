package models;

import play.db.jpa.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Eero
 * Date: 6.10.2011
 * Time: 20:24
 * To change this template use File | Settings | File Templates.
 * * QUESTION: could ProblemCause name be changed to Cause
 */
@Entity
public class ProblemCause extends Model{

	public String name;

	@ManyToMany(mappedBy = "causeOf", cascade = CascadeType.PERSIST)
	public Set<ProblemCause> causedBy;

	@ManyToMany(mappedBy = "causedBy", cascade = CascadeType.PERSIST)
	public Set<Effect> causeOf;

	public ProblemCause(String name, ProblemDefinition probDef) {
		this.name = name;
		this.causedBy = new HashSet<ProblemCause>();
		this.causeOf = new HashSet<Effect>();
		this.causeOf.add(probDef);
	}

	public boolean isCauseOf(ProblemDefinition probDef) {
		return false;  //To change body of created methods use File | Settings | File Templates.
	}

	public void addCause(ProblemCause probCause) {
		this.causedBy.add(probCause);
	}

	public void hasCause(ProblemCause probCause) {
		//To change body of created methods use File | Settings | File Templates.
	}
}
