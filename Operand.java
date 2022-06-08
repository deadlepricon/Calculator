public class Operand {

int valInt;

  public Operand( String token ) {
    valInt = Integer.parseInt(token);
  }

  public Operand( int value ) {
    valInt = value;

  }

  public int getValue() {
    return valInt;

  }

  public static boolean check( String token ) {
    if(token.matches("-?(0|[1-9]\\d*)"))
    return true;
    else 
    return false;

  }
}
