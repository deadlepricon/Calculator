public class SubtractionOperator extends Operator{

    

    @Override
    public int priority(){
        return 2;

    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        Operand temp;
        int val =op1.getValue()-op2.getValue();
        temp = new Operand(val);


        return temp;
    }
    
}