package sec03Builder.lec11_buildersinjava;

public class Demo {

    public static void main(String[] args) {

        String hello = "hello";
        System.out.println("<p>" + hello + "</p>");


        String [] words = {"hello", "world"};
//        System.out.println(
//                "<ul>\n" + "<li>" + words[0]
//                  ......
//        );

        // when you have multiple arguments, then its better to use builder instead of above approach
        StringBuilder sb = new StringBuilder();
        sb.append("<ul>\n");
        for (String word : words) {
            sb.append(String.format(" <li>%s</li>\n", word));
        }
        sb.append("</ul>");
        System.out.println(sb);

    }
}
