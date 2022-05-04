package validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

import validation.annotation.CategoryNameValidation;

public class CategoryNameValidator implements ConstraintValidator<CategoryNameValidation, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(!StringUtils.hasText(value)) return true;
		
		return !"thai".equals(value);
	}

}
