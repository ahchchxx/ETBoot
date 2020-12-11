package cn.exrick.xboot.modules.your;

import cn.hutool.script.ScriptUtil;
import javax.script.CompiledScript;

public class JsEvalTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        // sb.append("var a = 1;");
        // sb.append("var b = 2;");
        // sb.append("var result = a + b;");
        // sb.append("print(result);");

        sb.append("var ee = {'name': 'Tom', 'age': 1, 'birthday': '2020-12-12', 'salary': 10000};");
        sb.append("var er = {'name': 'HROne', 'type': 1};");
        // pre-define some functions
        sb.append("function max(val1, val2) {return Math.max(val1, val2)};");
        // ------------------------------- start to define a function
        sb.append("function fun() {");
        sb.append(" var result = '';// 定义为 null 时，返回值会报错 java.lang.NullPointerException\n");

        // test - 1.  class java.lang.Double
        // sb.append(" if(er.type == 1){");
        // sb.append("     result = ee.salary * 0.82225565; ");
        // sb.append("     result++\n");
        // sb.append(" }");
        // sb.append(" else{result = 1211;};");

        // test - 2.  class java.lang.Integer
        // sb.append(" er.type = 2\n");
        // sb.append(" result = ee.salary * er.type + 8;");

        // test - 3.  class java.lang.String
        // sb.append(" result = er.name + ', ' + ee.name;");

        // test - 4.  max library fun
        // sb.append(" result = Math.max(1, 2);");
        sb.append(" result = max(ee.salary, er.type);");

        // test - 5.
        // xxx

        sb.append(" return result;");
        sb.append("}");
        // ------------------------------- end of the definition
        sb.append("fun()");
        // sb.append("print(result);");

        try {
            CompiledScript compile = ScriptUtil.compile(sb.toString());
            Object ret = compile.eval();
            System.out.println(ret.getClass().toString());
            System.out.println(ret);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
