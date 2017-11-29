package twelve;

class DynamicFieldException extends Exception {
}

class DynamicField {
	private Object[][] field;

	public DynamicField(int initialSize) {
		field = new Object[initialSize][2];
		for (int i = 0; i < initialSize; ++i) {
			field[i] = new Object[] { null, null };
		}
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		for (Object[] obj : field) {
			result.append(obj[0]);
			result.append(": ");
			result.append(obj[1]);
			result.append("\n");
		}
		return result.toString();
	}

	private int hasField(String id) {
		for (int i = 0; i < field.length; ++i) {
			if (id.equals(field[i][0]))
				return i;
		}
		return -1;
	}

	private int getFieldNumber(String id) throws NoSuchFieldException {
		int fieldNum = hasField(id);
		if (fieldNum == -1)
			throw new NoSuchFieldException();
		return fieldNum;
	}
	
	private int makeField(String id) {
		for (int i = 0; i < field.length; ++i) {
			if (field[i][0] == null) {
				field[i][0] = id;
				return i;
			}
		}
		//No empty field
		Object[][] tmp = new Object[field.length+1][2];
		for (int i = 0; i < field.length; ++i) {
			tmp[i] = field[i];
		}
		for (int i = field.length; i < tmp.length; ++i) {
			tmp[i] = new Object[] {null, null};
		}
		field = tmp;
		return makeField(id);
	}
	
	public Object getField(String id) throws NoSuchFieldException {
		return field[getFieldNumber(id)][1];
	}
	
	public Object setField(String id, Object value) throws DynamicFieldException {
		if (value == null) {
			DynamicFieldException dfe = new DynamicFieldException();
			dfe.initCause(new NullPointerException());
			throw dfe;
		}
		int fieldNum = hasField(id);
		if (fieldNum == -1)
			fieldNum = makeField(id);
		Object result = null;
		try {
			result = getField(id);
		} catch (NoSuchFieldException e) {
			throw new RuntimeException();
		}
		field[fieldNum][1] = value;
		return result;
	}
}

public class ExceptionChain {
	public static void main(String[] args) {
		DynamicField df = new DynamicField(3);
		System.out.println(df);
		try {
			df.setField("yjh", "handsome");
			df.setField("qsh", "cute");
			df.setField("yjb", "zz");
			System.out.println(df);
			
			df.setField("yjh", "sb");
			System.out.println(df);
			
			System.out.println(df.getField("yjb"));
			
			//Exception
			System.out.println(df.getField("jk"));
			
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (DynamicFieldException e) {
			e.printStackTrace();
		}
	}
}
