public class DivisionOperator extends Operator{

    

    @Override
    public int priority(){
        return 3;

    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        
        Operand temp = new Operand(op1.getValue()/op2.getValue());
    
        


        return temp;
    }
    
}