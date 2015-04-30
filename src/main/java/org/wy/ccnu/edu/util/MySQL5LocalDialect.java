package org.wy.ccnu.edu.util;

import org.hibernate.dialect.MySQL5InnoDBDialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.StandardBasicTypes;

public class MySQL5LocalDialect extends MySQL5InnoDBDialect {

	public MySQL5LocalDialect() {
		super();
		registerFunction("convert", new SQLFunctionTemplate(
				StandardBasicTypes.CHARACTER_ARRAY, "convert(?1 using ?2)"));
	}
}
