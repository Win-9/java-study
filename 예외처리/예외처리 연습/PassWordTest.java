package ex14;

public class PassWordTest {
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws PassWordException{
		
		if(password==null) {
			throw new PassWordException("null");
		}
		else if(password.length()<=5) {
			throw new PassWordException("under 5length");
		}
		else if(password.matches("[a-zA-Z")) {
			throw new PassWordException("should insert ~~");
		}
		
		this.password = password;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PassWordTest test=new PassWordTest();
		String pw=null;
		try {
			test.setPassword(pw);
		} catch (PassWordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
