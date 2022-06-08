public class ExponentsOperator extends Operator{

    

    @Override
    public int priority(){
        return 4;

    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        Operand temp;
        int val =(int)Math.pow(op1.getValue(),op2.getValue());
        temp = new Operand(val);


        return temp;
    }
    
}
