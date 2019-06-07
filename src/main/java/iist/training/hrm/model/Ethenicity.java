package iist.training.hrm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ETHENICITY")
public class Ethenicity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ethenicityId;;
	@Column(name = "ethenicity_name")
	private String ethenicityName;

	public int getEthenicityId() {
		return ethenicityId;
	}

	public void setEthenicityId(int ethenicityId) {
		this.ethenicityId = ethenicityId;
	}

	public String getEthenicityName() {
		return ethenicityName;
	}

	public void setEthenicityName(String ethenicityName) {
		this.ethenicityName = ethenicityName;
	}

}
