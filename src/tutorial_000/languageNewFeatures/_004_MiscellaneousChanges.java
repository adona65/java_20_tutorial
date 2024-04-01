package tutorial_000.languageNewFeatures;

public class _004_MiscellaneousChanges {

    public static void main(String[] args) {
        /*
         * URL and URI
         *
         * All constructors of the URL class have been deprecated, the URI class should be preferred over the URL class and, if necessary,
         * usage of URI.toURL() to construct a URL object from a URI.
         */

        /*
         * Float
         *
         * Methodes were added to Float :
         * - Float.float16ToFloat(short): Returns the float value closest to the numeric value of the argument, which is a binary16
         *   floating point value encoded in a short.
         * - Float.floatToFloat16(float): Returns the binary16 floating point value, encoded in the nearest short of the argument.
         */

        /*
         * Foreign Function & Memory API
         *
         * We won't dive deeply into this feature. We will just remind that this API allows access to native memory (i.e., memory outside
         * the Java heap) and to execute native code (e.g., from C libraries) from Java. With java 20, it is still a preview feature, and
         * some changes were made to it.
         *
         * We won't see code example here as Java developers rarely need access to native memory and code.
         */

        /*
         * Structured Concurrency
         *
         * Java 20 keep Structured Concurrency in incubator state for the second time. When a task consists of several
         * subtasks that can be processed in parallel, Structured Concurrency allows us to implement this in a
         * particularly readable and maintainable way.
         *
         * We won't see more of it now, and will just note to stay alert about it. We will review this feature in a future
         * version of java, waiting at least it reaches the preview feature state.
         */

        /*
         * Vector API
         *
         * The new Vector API is different from the java.util.Vector class. It is a new API for mathematical vector
         * computation and its mapping to modern SIMD (Single-Instruction-Multiple-Data) CPUs.
         *
         * The Vector API has been part of the JDK since Java 16 as an incubator and was further developed in Java 17, 18
         * and 19. Java 20 mark its fifth round in incubator state.
         */
    }
}
