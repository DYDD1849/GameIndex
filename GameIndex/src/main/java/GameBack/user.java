package GameBack;

public class user {
	private String name;
	private String code;
	private String isManger;
	public user() {
		super();
	}
	public user(String name, String code, String isManger) {
		super();
		this.name = name;
		this.code = code;
		this.isManger = isManger;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getIsManger() {
		return isManger;
	}
	public void setIsManger(String isManger) {
		this.isManger = isManger;
	}
	
}
