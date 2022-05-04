package validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import validation.CategoryNameValidator;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CategoryNameValidator.class)
public @interface CategoryNameValidation {
	String message() default "";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
