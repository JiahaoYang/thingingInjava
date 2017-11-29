package twenty;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface DBTable {
	String name() default ""; 
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Constraints {
	boolean primaryKey() default false;
	boolean allowNull() default false;
	boolean unique() default false; 
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface SQLString {
	int value() default 0;
	String name() default "";
	Constraints constraints() default @Constraints;
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface SQLInt {
	String name() default "";
	Constraints constraints() default @Constraints;
}

@DBTable(name = "test")
public class SqlAnnotation {
	@SQLString(20) String firstName;
	@SQLString(30) String lastName;
	@SQLString(value = 30, constraints = @Constraints(
			primaryKey = true))
	String handel;
	@SQLInt(name = "age")
	int age1;
}
