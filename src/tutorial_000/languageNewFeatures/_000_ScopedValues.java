package tutorial_000.languageNewFeatures;

import jdk.incubator.concurrent.ScopedValue;

public class _000_ScopedValues {

    private static final ScopedValue<String> USERNAME = ScopedValue.newInstance();

    public static void main(String[] args) {
        /*
         * Java 20 introduced a new feature (as incubator) called "Scoped Values".
         *
         * It allows to share immutable data within and between threads. Previously to java 20 we may used Thread Locals to
         * share data within a thread. These are mutable and require a complex data structure, which is not really in line with
         * virtual threads (preview feature since java 19) that are light and cheap to build. So, immutable Scoped Values are proposed
         * as a new way to share data between threads.
         *
         * Let see a basic example of how we may use those Scopes Values :
         */
        // bind a value to the scope
        ScopedValue.where(USERNAME, "my_name")
                // start a thread that could access this value
                .run(() -> System.out.println("User: " + USERNAME.get()));
        /*
         * We also may use call() with a Callable to return a value. At the end of the run() method call, the scoped value will
         * no longer have a value for the thread, which avoids any risk of memory leak.
         *
         * We won't see more as this is still in incubator state, and we'll wait it reach preview feature/release state in future
         * versions to dig deeper into this feature.
         */
    }

}
