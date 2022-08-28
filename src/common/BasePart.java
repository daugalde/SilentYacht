package common;

public class BasePart {
	
	private int id;
	
	private String name;
	
	private PartTypes partId; 

	public BasePart() {
	}

	public BasePart(String name, PartTypes partId, int id) {
		this.name = name;
		this.setPartId(partId);
	}
	
	public BasePart(String name, int id) {
		this.name = name;
		this.setId(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PartTypes getPartId() {
		return partId;
	}

	public void setPartId(PartTypes partId) {
		this.partId = partId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
