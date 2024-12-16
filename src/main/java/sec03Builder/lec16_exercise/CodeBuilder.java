package sec03Builder.lec16_exercise;

// You are asked to implement the Builder design pattern for rendering simple chunks of code.
//
// Sample use of the builder you are asked to create:
//
// CodeBuilder cb = new CodeBuilder("Person").addField("name", "String").addField("age", "int");
// System.out.println(cb);
// The expected output of the above code is:
//
// public class Person
// {
//    public String name;
//    public int age;
// }
// Please observe the same placement of curly braces and use two-space indentation.

import java.util.ArrayList;
import java.util.List;

class CodeBuilder {
    private String className;
    private List<String> fields = new ArrayList<>();

    public CodeBuilder(String className) {
        this.className = className;
    }

    public CodeBuilder addField(String name, String type) {
        fields.add("  public " + type + " " + name + ";\n");
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("public class %s\n{\n", this.className));
        for (int i = 0; i < fields.size(); i++) {
            sb.append(fields.get(i));
        }
        sb.append("}");

        return sb.toString();
    }
}

//class CodeBuilder {
//  private String className;
//  private List<String> fields = new ArrayList<>();
//
//  public CodeBuilder(String className) {
//    this.className = className;
//  }
//
//  public CodeBuilder addField(String name, String type) {
//    fields.add("  public " + type + " " + name + ";");
//    return this;
//  }
//
//  @Override
//  public String toString() {
//    StringBuilder sb = new StringBuilder();
//    sb
//            .append(String.format("public class %s", className))
//            .append("\n{\n");
//
//    for (String f : fields) {
//      sb.append(f);
//      sb.append("\n");
//    }
//    sb.append("}");
//    return sb.toString();
//  }
//}


class Demo {
    public static void main(String[] args) {
        CodeBuilder cb = new CodeBuilder("Car").addField("brand", "String").addField("price", "int");
        System.out.println(cb);
    }
}

