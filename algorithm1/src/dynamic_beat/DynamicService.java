package dynamic_beat;

import java.util.regex.Pattern;

public class DynamicService {

	DAO dao	=DAO.getInstance();;
	IdDTO dto;
	int res=0;
	public boolean checkID(String id) {
			dto=dao.getSearchId(id);
			if(dto.getId()!=null)
				return true;
			else 
				return false;
	}
	public boolean checkPwd(String password) {
		String regexPassword = "^[\\w~!@#$%^&*()\\-=+\\[\\]{};':\",./<>?]{6,20}$";
		return Pattern.matches(regexPassword, password);
	}
	public boolean checkAge(int age) {
		String regexAge= "^[\\w~!@#$%^&*()\\-=+\\[\\]{};':\",./<>?]{6,20}$";
		String age2 = age+"";
		return Pattern.matches(regexAge, age2);
		
	}
	public boolean checkEmail(String email) {
		String regexEmail = "^\\w{2,10}@\\w+\\.[a-z]{3}$";
		return Pattern.matches(regexEmail, email);
	}
	public int setSignUp(IdDTO idDTO) {
		res=dao.setSignUp(idDTO);
		return res;
	}


}
