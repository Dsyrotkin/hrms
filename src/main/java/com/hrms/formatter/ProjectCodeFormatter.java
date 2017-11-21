package com.hrms.formatter;
import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.hrms.domain.Project;

public class ProjectCodeFormatter implements Formatter<String>{

	@Override
	public String print(String projectCode, Locale arg1) {
		// TODO Auto-generated method stub
		return projectCode;
	}

	@Override
	public String parse(String projectCode, Locale arg1) throws ParseException {
		// TODO Auto-generated method stub
		if(projectCode.length()<10) {
			String.format("%010d", Integer.parseInt(projectCode));
		}
		return projectCode;
	}

}
