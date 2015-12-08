package com.github.greboreda.example.model.mappers;

import com.github.greboreda.example.model.person.PersonVO;
import com.github.greboreda.example.model.telephone.Telephone;
import com.github.greboreda.example.model.telephone.TelephoneVO;

public class TelephonesMapper {

	public static Telephone proccessVOBO(TelephoneVO telephoneVO) {
		
		if(telephoneVO == null) {
			return null;
		}
		
		Telephone telephone = new Telephone();
		
		telephone.setId(telephoneVO.getId());
		telephone.setNumber(telephoneVO.getNumber());
		
		return telephone;
	}
	
	public static TelephoneVO proccessBOVO(Telephone telephone, PersonVO person) {
		
		if(telephone == null) {
			return null;
		}
		
		TelephoneVO telephoneVO = new TelephoneVO();
		
		telephoneVO.setId(telephone.getId());
		telephoneVO.setNumber(telephone.getNumber());
		telephoneVO.setPerson(person);
	
		return telephoneVO;
	}
	
}
