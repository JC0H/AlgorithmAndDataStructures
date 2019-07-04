package BagsQueueStacks;

public class _09_RightParatheses {

    Stack<String> stack =  new Stack<>();

    public String addLeftParantheses(String data){
        int digits = 0;
        int arithmeticalOps = 0;
        for (int i = 0;i < data.length(); i++){
            char c = data.charAt(i);
            if (isDigit(c)){
                stack.push(Character.toString(c));
                digits++;
            }else if (isArithmeticalOperation(c)){
                stack.push(Character.toString(c));
                arithmeticalOps++;
            }else if (isRightBrace(c) && (digits == 2)){
                String secondNumber = stack.pop();
                String arithmOp = stack.pop();
                String firstNumber = stack.pop();
                String expression = "( " + firstNumber + " " + arithmOp + " " + secondNumber + " " + c;
                stack.push(expression);
                digits = 0;
                arithmeticalOps = 0;
            }
        }
        return stack.toString();
    }

    public boolean isDigit(char data){
        return Character.isDigit(data);
    }

    public boolean isArithmeticalOperation(char data) {
        if (data == '+')
            return true;
        else if (data == '-')
            return true;
        else if (data == '/')
            return true;
        else if (data == '*')
            return true;
        else
            return false;
    }

    public boolean isRightBrace(char data){
        return data == ')';
    }

    public boolean isSpace(char data){
        return data == ' ';
    }

}
