package com.example.lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    GridLayout gridLayout;
    private final StringBuilder sb = new StringBuilder();//用于表达式的输入
    private String expression = "";//最终表达式的确定
    private String result = "";//计算结果
    private boolean isHasDot = false;//是否有小数点
    private final Stack<Boolean> dotStack = new Stack<>();
    //用栈存储每一个数字是否有小数点
    private boolean isZero = false;//是否是数字零
    private final Stack<Boolean> zeroStack = new Stack<>();
    private int leftNum = 0;//左括号数量
    private int rightNum = 0;//右括号数量
    private TextView edit_view;
    private TextView result_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_view = findViewById(R.id.edit_view);
        result_view = findViewById(R.id.result_view);
        Button button1 = findViewById(R.id.number1);
        button1.setOnClickListener(this);
        Button button2 = findViewById(R.id.number2);
        button2.setOnClickListener(this);
        Button button3 = findViewById(R.id.number3);
        button3.setOnClickListener(this);
        Button button4 = findViewById(R.id.number4);
        button4.setOnClickListener(this);
        Button button5 = findViewById(R.id.number5);
        button5.setOnClickListener(this);
        Button button6 = findViewById(R.id.number6);
        button6.setOnClickListener(this);
        Button button7 = findViewById(R.id.number7);
        button7.setOnClickListener(this);
        Button button8 = findViewById(R.id.number8);
        button8.setOnClickListener(this);
        Button button9 = findViewById(R.id.number9);
        button9.setOnClickListener(this);
        Button button0 = findViewById(R.id.number0);
        button0.setOnClickListener(this);
        Button buttonplus = findViewById(R.id.plus);
        buttonplus.setOnClickListener(this);
        Button buttonminus = findViewById(R.id.minus);
        buttonminus.setOnClickListener(this);
        Button buttonmult = findViewById(R.id.mult);
        buttonmult.setOnClickListener(this);
        Button buttondivide = findViewById(R.id.divide);
        buttondivide.setOnClickListener(this);
        Button buttondot = findViewById(R.id.dot);
        buttondot.setOnClickListener(this);
        Button buttonequals = findViewById(R.id.equals);
        buttonequals.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        result_view.setText("");
        switch (view.getId()) {
            case R.id.number1:
                if (isZero == true) {
                    sb.deleteCharAt(sb.length() - 1);
                    isZero = false;
                }
                sb.append('1');
                edit_view.setText(sb.toString());
                break;
            case R.id.number2:
                if (isZero == true) {
                    sb.deleteCharAt(sb.length() - 1);
                    isZero = false;
                }
                sb.append('2');
                edit_view.setText(sb.toString());
                break;
            case R.id.number3:
                if (isZero == true) {
                    sb.deleteCharAt(sb.length() - 1);
                    isZero = false;
                }
                sb.append('3');
                edit_view.setText(sb.toString());
                break;
            case R.id.number4:
                if (isZero == true) {
                    sb.deleteCharAt(sb.length() - 1);
                    isZero = false;
                }
                sb.append('4');
                edit_view.setText(sb.toString());
                break;
            case R.id.number5:
                if (isZero == true) {
                    sb.deleteCharAt(sb.length() - 1);
                    isZero = false;
                }
                sb.append('5');
                edit_view.setText(sb.toString());
                break;
            case R.id.number6:
                if (isZero == true) {
                    sb.deleteCharAt(sb.length() - 1);
                    isZero = false;
                }
                sb.append('6');
                edit_view.setText(sb.toString());
                break;
            case R.id.number7:
                if (isZero == true) {
                    sb.deleteCharAt(sb.length() - 1);
                    isZero = false;
                }
                sb.append('7');
                edit_view.setText(sb.toString());
                break;
            case R.id.number8:
                if (isZero == true) {
                    sb.deleteCharAt(sb.length() - 1);
                    isZero = false;
                }
                sb.append('8');
                edit_view.setText(sb.toString());
                break;
            case R.id.number9:
                if (isZero == true) {
                    sb.deleteCharAt(sb.length() - 1);
                    isZero = false;
                }
                sb.append('9');
                edit_view.setText(sb.toString());
                break;
            case R.id.number0:
                if (isZero == false) {
                    sb.append('0');
                    if (sb.length() == 1 ||
                            !('0' <= sb.charAt(sb.length() - 2) && sb.charAt(sb.length() - 2) <= '9')
                                    && sb.charAt(sb.length() - 2) != '.') {
                        isZero = true;
                    }
                }
                edit_view.setText(sb.toString());
                break;
            case R.id.dot:
                if (isHasDot == false) {
                    if (sb.length() == 0 ||
                            !('0' <= sb.charAt(sb.length() - 1) && sb.charAt(sb.length() - 1) <= '9')) {
                        sb.append("0.");
                    } else {
                        sb.append('.');
                    }
                    isHasDot = true;
                    isZero = false;
                }
                edit_view.setText(sb.toString());
                break;
            case R.id.plus:
                if (sb.length() != 0 &&
                        (sb.charAt(sb.length() - 1) == '+' || sb.charAt(sb.length() - 1) == '-' || sb.charAt(sb.length() - 1) == '*' || sb.charAt(sb.length() - 1) == '/')) {
                    sb.setCharAt(sb.length() - 1, '+');
                } else if (sb.length() != 0) {
                    sb.append('+');
                    zeroStack.push(isZero);
                    dotStack.push(isHasDot);
                    isZero = false;
                    isHasDot = false;
                }
                if (result.matches("[-]?\\d+[.]?\\d*") && sb.length() == 0) {
                    sb.append(result + "+");
                    isHasDot = result.matches("[-]?\\d*[.]\\d*");
                    isZero = "0".equals(result);
                    zeroStack.push(isZero);
                    dotStack.push(isHasDot);
                    isZero = false;
                    isHasDot = false;
                }
                edit_view.setText(sb.toString());
                break;
            case R.id.minus:
                if (sb.length() != 0 &&
                        (sb.charAt(sb.length() - 1) == '+' || sb.charAt(sb.length() - 1) == '-' || sb.charAt(sb.length() - 1) == '*' || sb.charAt(sb.length() - 1) == '/')) {
                    sb.append('(');
                    zeroStack.push(isZero);
                    dotStack.push(isHasDot);
                    leftNum++;
                }
                if (result.matches("[-]?\\d+[.]?\\d*") && sb.length() == 0) {
                    sb.append(result + "-");
                    isHasDot = result.matches("[-]?\\d*[.]\\d*");
                    isZero = "0".equals(result);
                    zeroStack.push(isZero);
                    dotStack.push(isHasDot);
                    isZero = false;
                    isHasDot = false;
                }
                sb.append('-');
                zeroStack.push(isZero);
                dotStack.push(isHasDot);
                isZero = false;
                isHasDot = false;
                edit_view.setText(sb.toString());
                break;
            case R.id.mult:
                if (sb.length() != 0 &&
                        (sb.charAt(sb.length() - 1) == '+' || sb.charAt(sb.length() - 1) == '-' || sb.charAt(sb.length() - 1) == '*' || sb.charAt(sb.length() - 1) == '/')) {
                    sb.setCharAt(sb.length() - 1, '*');
                } else if (sb.length() != 0) {
                    sb.append('*');
                    zeroStack.push(isZero);
                    dotStack.push(isHasDot);
                    isZero = false;
                    isHasDot = false;
                }
                if (result.matches("[-]?\\d+[.]?\\d*") && sb.length() == 0) {
                    sb.append(result + "*");
                    isHasDot = result.matches("[-]?\\d*[.]\\d*");
                    isZero = "0".equals(result);
                    zeroStack.push(isZero);
                    dotStack.push(isHasDot);
                    isZero = false;
                    isHasDot = false;
                }
                edit_view.setText(sb.toString());
                break;
            case R.id.divide:
                if (sb.length() != 0 &&
                        (sb.charAt(sb.length() - 1) == '+' || sb.charAt(sb.length() - 1) == '-' || sb.charAt(sb.length() - 1) == '*' || sb.charAt(sb.length() - 1) == '/')) {
                    sb.setCharAt(sb.length() - 1, '/');
                } else if (sb.length() != 0) {
                    sb.append('/');
                    zeroStack.push(isZero);
                    dotStack.push(isHasDot);
                    isZero = false;
                    isHasDot = false;
                }
                if (result.matches("[-]?\\d+[.]?\\d*") && sb.length() == 0) {
                    sb.append(result + "/");
                    isHasDot = result.matches("[-]?\\d*[.]\\d*");
                    isZero = "0".equals(result);
                    zeroStack.push(isZero);
                    dotStack.push(isHasDot);
                    isZero = false;
                    isHasDot = false;
                }
                edit_view.setText(sb.toString());
                break;
            case R.id.equals:
                if (sb.length() != 0) {
                    edit_view.setText(sb.toString());
                    isHasDot = false;
                    isZero = false;
                    zeroStack.clear();
                    dotStack.clear();
                    if (leftNum < rightNum) {
                        result = "出错";
                        sb.delete(0, sb.length());
                        result_view.setText(result);
                        leftNum = 0;
                        rightNum = 0;
                        break;
                    } else if (leftNum > rightNum) {
                        while (leftNum > rightNum) {
                            sb.append(')');
                            rightNum++;
                        }
                    }
                    if (sb.charAt(0) == '-') {
                        sb.insert(0, '0');
                    }
                    if (sb.charAt(sb.length() - 1) == '+' || sb.charAt(sb.length() - 1) == '-') {
                        sb.append('0');
                    }
                    if (sb.charAt(sb.length() - 1) == '*' || sb.charAt(sb.length() - 1) == '/') {
                        sb.append('1');
                    }
                    for (int i = 1; i < sb.length() - 1; i++) {
                        char ch = sb.charAt(i);
                        if (ch == '(' && (sb.charAt(i - 1) == '.' || '0' <= sb.charAt(i - 1) && sb.charAt(i - 1) <= '9')) {
                            sb.insert(i, '*');
                        }
                        if (ch == ')' && '0' <= sb.charAt(i + 1) && sb.charAt(i + 1) <= '9') {
                            sb.insert(i + 1, '*');
                        }
                    }
                    expression = sb.toString();
                    sb.delete(0, sb.length());
                    exchange(expression);
                    expression = "";
                    leftNum = 0;
                    rightNum = 0;
                }
                result_view.setText(result);
                break;
        }
    }
        public void exchange(String expression){
            Queue<Object> queue = new LinkedList<>();
            Stack<Character> stack = new Stack<>();
            int figureNum = 0;
            int operatorNum = 0;
            StringBuilder numSb = new StringBuilder();
            for (int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);
                if (ch == '.' || ('0' <= ch && ch <= '9')) {
                    numSb.append(ch);
                } else {
                    if (numSb.length() != 0) {
                        queue.offer(new BigDecimal(numSb.toString()));
                        figureNum++;
                        numSb.delete(0, numSb.length());
                    }
                    if (ch == '-' && expression.charAt(i - 1) == '(' &&
                            ('0' <= expression.charAt(i + 1) && expression.charAt(i + 1) <= '9')) {
                        numSb.append(ch);
                        continue;
                    }
                    if (ch == '(') {
                        stack.push(ch);
                    } else if ((ch == '+' || ch == '-') && !stack.isEmpty() && stack.peek() == '(') {
                        stack.push(ch);
                    } else if ((ch == '*' || ch == '/') && !stack.isEmpty() && !(stack.peek() == '*' || stack.peek() == '/')) {
                        stack.push(ch);
                    } else {
                        while (!stack.empty() && stack.peek() != '(') {
                            queue.offer(stack.pop());
                            operatorNum++;
                        }
                        if (!stack.isEmpty()) {
                            stack.pop();
                        }
                        if (ch != ')') {
                            stack.push(ch);
                        }
                    }
                }
            }
            if (numSb.length() != 0) {
                queue.offer(new BigDecimal(numSb.toString()));
                figureNum++;
            }
            while (!stack.empty()) {
                queue.offer(stack.pop());
                operatorNum++;
            }
            if (figureNum == operatorNum + 1) {
                calculate(queue);
            } else {
                result = "出错";
            }
        }

        public void calculate(Queue < Object > queue) {
            Stack<BigDecimal> stack = new Stack<>();
            while (!queue.isEmpty()) {
                Object obj = queue.poll();
                if (obj.getClass() == Character.class) {
                    char operator = (Character) obj;
                    BigDecimal num1 = (BigDecimal) stack.pop();
                    BigDecimal num2 = (BigDecimal) stack.pop();
                    BigDecimal subResult;
                    if (operator == '+') {
                        subResult = num2.add(num1);
                        stack.push(subResult);
                    } else if (operator == '-') {
                        subResult = num2.subtract(num1);
                        stack.push(subResult);
                    } else if (operator == '*') {
                        subResult = num2.multiply(num1);
                        stack.push(subResult);
                    } else {
                        if ("0".equals(num1.toString())) {
                            result = "不能除以零";
                            return;
                        } else if ("0".equals(num2.toString())) {
                            stack.push(new BigDecimal("0"));
                        } else {
                            subResult = num2.divide(num1, 20, BigDecimal.ROUND_HALF_UP);
                            stack.push(subResult);
                        }
                    }
                } else {
                    stack.push((BigDecimal) obj);
                }
            }
            result = stack.pop().toString();
            if (result.matches("[-]?\\d*[.]\\d*")) {
                int i = result.length() - 1;
                while (result.charAt(i) == '0') {
                    i--;
                }
                if (result.charAt(i) == '.') {
                    i--;
                }
                result = result.substring(0, i + 1);
            }
        }
    }