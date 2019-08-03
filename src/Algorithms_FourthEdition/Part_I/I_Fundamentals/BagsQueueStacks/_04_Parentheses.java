package Algorithms_FourthEdition.Part_I.I_Fundamentals.BagsQueueStacks;

/*
 Write a stack client Parentheses that reads in a text stream from standard input
and uses a stack to determine whether its parentheses are properly balanced. For example,
your program should print true for [()]{}{[()()]()} and false for [(]).
* */

public class _04_Parentheses {

    private Stack<String> stack = new Stack<>();
    //   ([)]
    public boolean checkBracesLock(String data){
        String between = "";
        for (int i = 0; i < data.length();i++){
            char c = data.charAt(i);
            for (int k = 1; k < data.length();k++){
                char s = data.charAt(i);
               if (leftCircleType(c) && rightCircleType(s)){
                    for (int j = 0; j < between.length();j++){
                        char b = between.charAt(j);
                        for ( int l = 0; l < between.length(); l++){
                            char t = between.charAt(l);
                            if (leftCircleType(b) && rightCircleType(t) ){
                                return true;
                            } else if(leftCurlyType(b) && rightCurlyType(t) ){
                                return true;
                            } else if(leftSquareType(b) && rightSquareType(t) ){
                                return true;
                            }else {
                                return false;
                            }
                        }

                    }
                }else if (leftCurlyType(c) && rightCurlyType(s)){
                    for (int j = 0; j < between.length();j++){
                        char b = between.charAt(j);
                        for ( int l = 0; l < between.length(); l++){
                            char t = between.charAt(l);
                            if (leftCircleType(b) && rightCircleType(t) ){
                                return true;
                            } else if(leftCurlyType(b) && rightCurlyType(t) ){
                                return true;
                            } else if(leftSquareType(b) && rightSquareType(t) ){
                                return true;
                            }else {
                                return false;
                            }
                        }

                    }
                }else if (leftSquareType(c) && rightSquareType(s)){
                   for (int j = 0; j < between.length();j++){
                       char b = between.charAt(j);
                       for ( int l = 0; l < between.length(); l++){
                           char t = between.charAt(l);
                           if (leftCircleType(b) && rightCircleType(t) ){
                               return true;
                           } else if(leftCurlyType(b) && rightCurlyType(t) ){
                               return true;
                           } else if(leftSquareType(b) && rightSquareType(t) ){
                               return true;
                           }else {
                               return false;
                           }
                       }

                   }
               }

               else{
                 between = between + s;
               }
            }
            stack.push(between);
        }
        return true;
    }

    private boolean leftSquareType(char data){
        return data == '[';
    }

    private boolean leftCurlyType(char data){
        return data == '{';
    }

    private boolean leftCircleType(char data){
        return data == '(';
    }

    private boolean rightSquareType(char data){
        return data == ']';
    }

    private boolean rightCurlyType(char data){
        return data == '}';
    }

    private boolean rightCircleType(char data){
        return data == ')';
    }


    public static void main(String[] args) {
        _04_Parentheses p = new _04_Parentheses();
        boolean result = p.checkBracesLock("[(])");
        System.out.println(result);
    }

}
