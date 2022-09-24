package resources;

public enum ApiResources {
	
	AddPlaceAPi("/maps/api/place/add/json"),
	UpdateUser("/api/users/2"),
	CreateUser("/api/users");
	private String resource;
	ApiResources(String resource) {
		this.resource=resource;
	}
	public String getResource() {
		return resource;
	}
	
}
