package tutorial_000.languageNewFeatures;

import jdk.incubator.concurrent.ScopedValue;

public class _001_RecordPatterns {



    public static void main(String[] args) {
        /*
         * With java 20, record patterns are still a preview feature. In this version, three changes has been done:
         * - Support for parameterized type inference for generic record patterns.
         * - Support for record patterns in for loops (enhanced for statements).
         * - Removed support for named record patterns.
         *
         * The support of parameterized type inference for generic record patterns allows to omit the parameterized type
         * in a record pattern if it can be inferred by the compiler :
         */
        parameterizedTypeInference(new Box<>("My box"));

        /*
         * The support of record patterns in for loops (enhanced for statements) allows direct access to the components
         * of a record inside the body of a for loop :
         */
        Point[] points = {};
        points[0] = new Point(1,2);
        points[1] = new Point(5,8);
        recordPatternInForLoop(points);

        /*
         * Finally concerning record patterns, before java 20 it was possible to name a record pattern to, in a way, do
         * pattern matching on the record and its components at the same time. This possibility has been removed and the
         * following would now generate an error at compile time :
         *
             // Named Record Pattern
             if(points[0] instanceof Point(int x, int y) p) {
                System.out.println("x=" + x + " y=" + y + "for the point " + p);
             }
         *
         * Of course, we will notice that other ways of writing this code still works :
         */
        // Pattern Matching for instanceof
        if (points[0] instanceof Point p) {
            System.out.println("object is a point, p.x = " + p.x() + ", p.y = " + p.y());
        }

        // Record Pattern
        if (points[0] instanceof Point(int x, int y)) {
            System.out.println("object is a point, x = " + x + ", y = " + y);
        }
    }

    record Box<T>(T t) {}
    static void parameterizedTypeInference(Box<String> bo) {
        if (bo instanceof Box(var s)) { // Inferred to be Box<String>(var s)
            System.out.println("String " + s);
        }

        switch (bo) {
            case Box(var s) -> System.out.println("It's a box " +s); // It also works with switch statement (Box<String> is inferred).
            default -> System.out.println("Not a box.");
        }
    }

    record Point(int x, int y) {}
    static void recordPatternInForLoop(Point[] pointArray) {
        // We  specify a record pattern in the for loop and then access x and y directly (just like with instanceof and switch).
        for (Point(var x, var y) : pointArray) {
            System.out.println("(" + x + ", " + y + ")");
        }
    }
}
