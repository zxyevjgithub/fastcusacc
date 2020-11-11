package com.biz;

import org.python.core.PyFunction;
import org.python.util.PythonInterpreter;

import java.util.Properties;

public class PythonRunner {

    private static final PythonInterpreter intr = new PythonInterpreter();

    private static final String FUNC_TPL = String.join("\n", new String[]{
            "def func():",
            "    %s",
            "",
    });

    private final PyFunction func;

    public PythonRunner(String code) {
        // 渲染函数内容
        String[] lines = code.split("\n");
        for (int i = 1; i < lines.length; i++)
            lines[i] = "    " + lines[i];
        code = String.join("\n", lines);
        code = String.format(FUNC_TPL, code);

        // 编译并获取 PyFunction 对象
        intr.exec(code);
        func = (PyFunction) intr.get("funcname");
    }

    public Object run() {
        // 使用 PyFunction 对象的 __call__ 方法，调用指定的 Python 代码
        return func.__call__();
    }

    public static void main(String[] args) {

        Properties props = new Properties();
        props.put("python.home", "path to the Lib folder");
        props.put("python.console.encoding", "UTF-8");
        props.put("python.security.respectJavaAccessibility", "false");
        props.put("python.import.site", "false");
        Properties preprops = System.getProperties();
        PythonInterpreter.initialize(preprops, props, new String[0]);
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("days=('mod','Tue','Wed','Thu','Fri','Sat','Sun'); ");
        interpreter.exec("print days[1];");


    }
}
