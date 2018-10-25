package sports.utils.validation;

public interface InputValidator {

   default boolean isValid(String data) {
       return true;
   }

    default String errorMessage() {
       return "Invalid Input";
    }

    default String message() {
       return "Enter String";
    }
}
