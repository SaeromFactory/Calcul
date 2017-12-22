import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by high on 2017. 12. 22..
 */
/*
각각 add, subtract, multiply, division 메서드를 채워 넣어
main 함수에서 연산자 & a값, b값을 입력 받고 출력한다
사용할 수 있는 것은 밑의 plusOne과 numEquals 두개의 메서드만이다
if, for 등 예약어등은 기본적으로 사용할 수 있고
+,-,*,/ 와 같은 연산자는 사용할 수 없음
 */

public class Main {

    public Result solution(String operator, int a, int b) {
        if(operator.equals("+"))
            return new Result(add(a, b), Result.success);
        else if(operator.equals("-"))
            return new Result(subtract(a, b), Result.success);
        else if(operator.equals("/"))
            return new Result(division(a, b), Result.success);
        else if(operator.equals("*"))
            return new Result(multiply(a, b), Result.success);
        return new Result(0, Result.fail);
    }

    private int add(int a, int b) {
        return 0;
    }

    private int subtract(int a, int b) {
        return 0;
    }

    private int division(int a, int b) {
        return 0;
    }

    private int multiply(int a, int b) {
        return 0;
    }

    private int plusOne(int a) {
        return a++;
    }

    private boolean numEquals(int a, int b) {
        return (a == b);
    }

    public static void main(String args[]) {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder operator = new StringBuilder();
        final int operand[] = new int[2];

        while(true) {
            operator.setLength(0);
            try {
                operator.append(bufferedReader.readLine());
                operand[0] = Integer.parseInt(bufferedReader.readLine());
                operand[1] = Integer.parseInt(bufferedReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            } catch (Exception e2) {
                System.out.println("숫자를 입력 해주세요. 연산자 : " + operator + " a : " + operand[0] + " b : " + operand[1]);
                continue;
            }
            final Result result = new Main().solution(operator.toString(), operand[0], operand[1]);
            if(result.getMsg().equals(Result.fail))
                continue;

            System.out.println(result.toString());
            break;
        }
    }
}

class Result {
    public final static String success = "SUCCESS";
    public final static String fail = "fail";
    private int data;
    private String msg;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Result(int data, String msg) {
        this.data = data;
        this.msg = msg;
    }
    public Result(){}

    @Override
    public String toString() {
        return "Result{" +
                "결과는=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
