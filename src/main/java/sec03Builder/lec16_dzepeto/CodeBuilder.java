package sec03Builder.lec16_dzepeto;

import java.util.ArrayList;
import java.util.List;

class CodeBuilder {
    private String className;
    private List<Field> fields = new ArrayList<>();

    // Inner class to represent a field
     class Field {
        public String name, type;

        public Field(String name, String type) {
            this.name = name;
            this.type = type;
        }

        @Override
        public String toString() {
            return String.format("  public %s %s;", type, name);
        }
    }

    // Constructor accepting the class name
    public CodeBuilder(String className) {
        this.className = className;
    }

    // Method to add a field
    public CodeBuilder addField(String name, String type) {
        fields.add(new Field(name, type));
        return this; // Return 'this' for chaining
    }

    // Generate the string representation
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("public class ").append(className).append("\n{\n");
        for (Field field : fields) {
            sb.append(field).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}

class Demo {
    public static void main(String[] args) {
        CodeBuilder cb = new CodeBuilder("Person")
                .addField("name", "String")
                .addField("age", "int");
        System.out.println(cb);
    }
}
