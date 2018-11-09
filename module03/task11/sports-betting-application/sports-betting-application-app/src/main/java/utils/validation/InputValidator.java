package utils.validation;

/**
 * Strategy pattern used.
 * @author  Valeriia Biruk
 * @version 1.0
 */
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
