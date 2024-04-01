package tutorial_000.languageNewFeatures;

public class _002_PatternMatchingForSwitch {

    public static void main(String[] args) {
        /*
         * With java 20, Pattern Matching for switch are preview feature for the fourth time.
         *
         * As a reminder, we will note we may write a switch statement like this :
         */
        Object obj = "";

        switch (obj) {
            case String s when s.length() > 5 -> System.out.println(s.toUpperCase());
            case String s -> System.out.println(s.toLowerCase());
            case Integer i -> System.out.println(i * i);
            case Position(int x, int y) -> System.out.println(x + "/" + y);
            default -> {
            }
        }

        /*
         * With java 20, some changes were added to this feature. Now an exhaustive switch (a switch that includes all possible
         * values) throws a MatchException (rather than an IncompatibleClassChangeError) if it is determined at runtime that no
         * switch label matches.
         *
         * Using the records and method existing in this class, the following code will work properly :
         */
        var rectangle = new Rectangle(new Position(10, 10), new Position(50, 50));
        debug(rectangle);

        var circle = new Circle(new Position(30, 30), 10);
        debug(circle);
        /*
         * Now, if we uncomment the "Oval" record, but doesn't do it for the "Ovel" permission of "Shape" interface, then recompile
         * and execute our code, it will throw a "MatchException". This because debug() method has no label for the Oval class.
         *
         * The same can happen with an exhaustive switch expression over the values of an enum if we subsequently extend the enum.
         */
    }

    record Position(int x, int y) {}
    public sealed interface Shape permits Rectangle, Circle/*, Oval*/ {}
    public record Rectangle(Position topLeft, Position bottomRight) implements Shape {}
    public record Circle(Position center, int radius) implements Shape {}
    //public record Oval(Position center, int width, int height) implements Shape {}

    public static void debug(Shape shape) {
        switch (shape) {
            case Rectangle r -> System.out.println(
                    "Rectangle: top left = " + r.topLeft() + "; bottom right = " + r.bottomRight());

            case Circle c -> System.out.println(
                    "Circle: center = " + c.center() + "; radius = " + c.radius());
        }
    }
}
