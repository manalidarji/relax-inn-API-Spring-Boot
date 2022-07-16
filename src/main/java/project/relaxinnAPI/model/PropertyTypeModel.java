package project.relaxinnAPI.model;

import org.springframework.data.annotation.Id;

public class PropertyTypeModel {
	@Id
	private String id;
	private String propType;
	
	public PropertyTypeModel() {
		super();
	}

	public PropertyTypeModel(String id, String propType) {
		super();
		this.id = id;
		this.propType = propType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPropType() {
		return propType;
	}

	public void setPropType(String propType) {
		this.propType = propType;
	}

	@Override
	public String toString() {
		return "PropertyTypeModel [id=" + id + ", propType=" + propType + "]";
	}
}
