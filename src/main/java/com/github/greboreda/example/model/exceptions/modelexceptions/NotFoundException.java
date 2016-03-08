package com.github.greboreda.example.model.exceptions.modelexceptions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.github.greboreda.example.model.BusinessObject;

public class NotFoundException extends Exception {

	private static final long serialVersionUID = -6808318131963369993L;

	private Class<? extends BusinessObject> entity;
	private Map<String,Object> filters;
	
	public NotFoundException(String fieldName, Object value, Class<? extends BusinessObject> entity) {

		super(String.format("(BussinesObject = '%s', {key = '%s', value = '%s'})", entity.getClass().getSimpleName(), fieldName, value ));
		
		Map<String,Object> filters = new HashMap<String,Object>();
		filters.put(fieldName, value);
		this.filters = filters;
	}
	
	public NotFoundException(Map<String,Object> filters, Class<? extends BusinessObject> entity) {
		super(String.format("(BussinesObject = '%s', Filters = {%s})", entity.getClass().getSimpleName(), getMapAsString(filters)));
		this.filters = filters;
		this.entity = entity;
	}
	
	private static String getMapAsString(Map<String,Object> map) {
		
		StringBuilder stringBuilder = new StringBuilder();
		Iterator<Entry<String, Object>> it = map.entrySet().iterator();
		
		while(it.hasNext()) {
			Map.Entry<String,Object> entry = (Map.Entry<String,Object>)it.next();
			
			String pair = String.format("%s = '%s'", entry.getKey(), entry.getValue());			
			stringBuilder.append(pair);
			if(it.hasNext()) {
				stringBuilder.append(", ");
			}
		}
		return stringBuilder.toString();		
	}
	

	public Class<? extends BusinessObject> getEntity() {
		return entity;
	}

	public void setEntity(Class<? extends BusinessObject> entity) {
		this.entity = entity;
	}

	public Map<String, Object> getFilters() {
		return filters;
	}

	public void setFilters(Map<String, Object> filters) {
		this.filters = filters;
	}


	
	
}
