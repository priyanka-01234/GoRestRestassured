package reqTestData;

public class ReqUtility {
	
	public static String baseURL = "https://reqres.in/api/users";
	public static String reqPayload= "{\r\n"
			+ "    \"name\": \"skillio\",\r\n"
			+ "    \"job\": \"leader\"\r\n"
			+ "}";
	public static String invalidPayload= "{\r\n"
			+ "    \"name\": \"Priyanka\",\r\n"
			+ "    \"job\": \"SDET\"\r\n"
			+ "}";
	public static String apiKeyName = "x-api-key";
	public  static String apiKeyValue = "reqres-free-v1";
	

}
