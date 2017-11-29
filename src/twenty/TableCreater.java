package twenty;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class TableCreater {
	private static String getConstraints(Constraints constraints) { 
		String cons = "";
		if (!constraints.allowNull())
			cons += "NOT NULL";
		if (constraints.primaryKey()) 
			cons += "PRIMARY KEY";
		if (constraints.unique()) 
			cons += "UNIQUE";
		return cons;
	}
	
	public static void main(String[] args) throws Exception {
		if (args.length < 1) {
			System.out.println("argements: annotated class");
			System.exit(0);
		}
		for (String arg : args) {
			Class<?> c = Class.forName(arg);
			DBTable table = c.getAnnotation(DBTable.class);
			if (table == null) {
				System.out.println("No annotation in class");
				continue;
			}
			String tableName = table.name();
			if (tableName.length() < 1) {
				tableName = c.getSimpleName().toUpperCase();
			}
			List<String> cols = new ArrayList<>();
			for (Field field : c.getDeclaredFields()) {
				String colName = null;
				Annotation[] an = field.getDeclaredAnnotations();
				if (an.length < 1) {
					continue;
				}
				if (an[0] instanceof SQLString) {
					SQLString ss = (SQLString)an[0]; // 向下转型
					if (ss.name().length() < 1) {
						colName = field.getName().toUpperCase();
					} else {
						colName = ss.name();
					}
					cols.add(colName + " VARCHAR(" + ss.value() + ") " + getConstraints(ss.constraints()));
				}
				if (an[0] instanceof SQLInt) {
					SQLInt si = (SQLInt)an[0];
					if (si.name().length() < 1) {
						colName = field.getName().toUpperCase();
					} else {
						colName = si.name();
					}
					cols.add(colName + " INT " + getConstraints(si.constraints()));
				}
			}
			StringBuilder cmd = new StringBuilder("CREATE TABLE " + tableName + "(");
			for (String col : cols) {
				cmd.append("\n    " + col + ",");
			}
			String SQlCmd = cmd.substring(0, cmd.length() - 1) + ");";
			System.out.println(SQlCmd);
		}
	}
}
