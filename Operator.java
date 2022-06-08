import java.util.HashMap;

public abstract class Operator {
  // The Operator class should contain an instance of a HashMap
  // This map will use keys as the tokens we're interested in,
  // and values will be instances of the Operators.

  // Example:
  // Where does this declaration go? What should its access level be?
  // Class or instance variable? Is this the right declaration?
  // HashMap operators = new HashMap();
  // operators.put( "+", new AdditionOperator() );
  // operators.put( "-", new SubtractionOperator() );

  static HashMap<String, Operator> operators = new HashMap<>();
  String temp;
  static{
    operators.put( "+", new AdditionOperator() );
    operators.put( "-", new SubtractionOperator() );
    operators.put( "*", new MultiplicationOperator() );
    operators.put( "/", new DivisionOperator() );
    operators.put( "^", new ExponentsOperator() );
    operators.put("(", new openParenthOperator());
    operators.put(")", new closeParenthOperator());
  }
  



public abstract int priority();
  public abstract Operand execute( Operand op1, Operand op2 );

  public static boolean check( String token ) {
    switch(token) {
      case "+":
        return true;
      case "-":
        return true;
      case "*":
        return true;
      case "/":
       return true;
      case "^":
       return true;
      case "(":
      return true;
      case ")":
      return true;
      default:
        return false;
    }

    

  }

  static public Operator newOperator(String opp){
    return operators.get(opp);
  }

   
}
