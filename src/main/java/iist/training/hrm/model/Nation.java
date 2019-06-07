package iist.training.hrm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NATION")
public class Nation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int nationId;

	@Column(name = "nation_name")
	private int nationName;

	public int getNationId() {
		return nationId;
	}

	public void setNationId(int nationId) {
		this.nationId = nationId;
	}

	public int getNationName() {
		return nationName;
	}

	public void setNationName(int nationName) {
		this.nationName = nationName;
	}

}
