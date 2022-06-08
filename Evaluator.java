import java.util.*;

public class Evaluator {
  private Stack<Operand> operandStack;
  private Stack<Operator> operatorStack;

  private StringTokenizer tokenizer;
  private static final String DELIMITERS = "+-*^/() ";

  public Evaluator() {
    operandStack = new Stack<>();
    operatorStack = new Stack<>();
  }

  public int eval( String expression ) {
    String token;
    int flag=0;

    // The 3rd argument is true to indicate that the delimiters should be used
    // as tokens, too. But, we'll need to remember to filter out spaces.
    this.tokenizer = new StringTokenizer( expression, DELIMITERS, true );

    while ( this.tokenizer.hasMoreTokens() ) {
      // filter out spaces
      if ( !( token = this.tokenizer.nextToken() ).equals( " " )) {
        // check if token is an operand
        if ( Operand.check( token )) {
          operandStack.push( new Operand( token ));
        } else {
          if ( ! Operator.check( token )) {
            System.out.println( "*****invalid token******" );
            System.exit( 1 );
          }

          Operator newOperator = Operator.newOperator( token );

          if( operatorStack.isEmpty() /* || operatorStack.peek().priority() == 0*/){
           operatorStack.push( newOperator );
           continue;
        }
        //o is (
        if(newOperator.priority() == 0){
          operatorStack.push(newOperator);
          continue;

        }
        // 1 =)
        if(newOperator.priority() ==1){
          calc();
          continue;

        }
       

            while ( operatorStack.peek().priority() >= newOperator.priority()) {
            // note that when we eval the expression 1 - 2 we will
            // push the 1 then the 2 and then do the subtraction operation
            // This means that the first number to be popped is the
            // second operand, not the first operand - see the following code
            Operator oldOpr = operatorStack.pop();
            Operand op2 = operandStack.pop();
            Operand op1 = operandStack.pop();
            operandStack.push( oldOpr.execute( op1, op2 ) );
            if( operatorStack.isEmpty() ){
             operatorStack.push( newOperator );
             break;
            }
          }
          operatorStack.push(newOperator);
        }
          
      }
    }
  
    

    while(!operatorStack.isEmpty() && operandStack.size() != 1){
      Operator Opr = operatorStack.pop();
      Operand o2 = operandStack.pop();
      Operand o1 = operandStack.pop();
      operandStack.push( Opr.execute(o1, o2) );
      if(operatorStack.empty()){
        break;
      }
    }
  return operandStack.pop().getValue();
}
   


public void calc(){
  while(!(operatorStack.isEmpty()) ){
    if(operatorStack.peek().priority() == 0){
      operatorStack.pop();
      break;
    }
    Operator oldOpr = operatorStack.pop();
    Operand op2 = operandStack.pop();
    Operand op1 = operandStack.pop();
    operandStack.push(oldOpr.execute(op1, op2));
  }
  
}


}
