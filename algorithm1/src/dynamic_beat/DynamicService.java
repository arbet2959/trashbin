package dynamic_beat;

import java.util.regex.Pattern;

public class DynamicService {

	DAO dao	=DAO.getInstance();
	IdDTO dto;
	int res=0;
	public boolean checkID(String id) {
		dto = new IdDTO();
		dto.setId(id);
		dto=dao.getSearchId(dto);
		if(dto.getId()!=null)
			return false;
		else 
			return true;
	}
	public boolean checkPwd(String password) {
		String regexPassword = "^[\\w~!@#$%^&*()\\-=+\\[\\]{};':\",./<>?]{6,20}$";
		return Pattern.matches(regexPassword, password);
	}
	public boolean checkAge(int age) {
		String regexAge= "^[\\d]{2,3}$";
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
	
	

	public int insertLogin(String id, String password) {
		
		dto = new IdDTO();
		dto.setId(id);
		dto=dao.getSearchId(dto);
		int res = 0;
		if(!id.equals(dto.getId())) {
			res = 1;
			return res;
		}else	if(!password.equals(dto.getPassword())) {
			System.out.println(dto.getPassword());
			res = 2;
			return res;
		}else {
			DynamicBeat.ID = dto.getId();
			res = 3;
			return res;
		}
				
	}
<<<<<<< HEAD
	public int setInsertScore(PlayRecordDTO prDTO) {
		int res = dao.setInsertScore(prDTO);
		return res;
	}
=======
>>>>>>> branch 'main' of https://github.com/arbet2959/trashbin.git


}
