package base;



/**
 * An enum is a special "class" that represents a group of constants (unchangeable variables, like final variables).
 * @param  recipient  email address of the recipient
 * @return      None
 */
public enum ApiResourcesEnum {

	subscribe("/subscribe"),
	unsubscribe("/unsubscribe"),
	move("/move"),
	clone("/clone");
	
	private String resource;
	
	ApiResourcesEnum(String resource)
	{
		this.resource =resource;
	}
	
	
	
	public String getresourcemethod()
	{
		return resource;
	}
	
	

}
