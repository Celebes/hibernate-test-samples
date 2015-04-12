package io.github.celebes.hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.ImprovedNamingStrategy;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class SchemaGenerator {
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		configuration.setNamingStrategy(new ImprovedNamingStrategy());
		SchemaExport export = new SchemaExport(configuration);
		export.setOutputFile("src/main/resources/h2schma.sql");
		export.create(true, false);
	}
}
