package tutorial_000.languageNewFeatures;

public class _003_VirtualThreads {

    public static void main(String[] args) {
        /*
         * In java 20, virtual threads are still a preview feature. As a reminder, virtual threads are lightweight threads that do not
         * block operating system threads when they have to wait for locks, blocking data structures, or responses from external systems,
         * for example.
         *
         * Here, we will only note that with java 20 a few changes from the first preview that were not specific to virtual threads and
         * were already finalized in Java 19 were no longer explicitly listed in the current JEP :
         * - New methods in Thread: join(Duration), sleep(Duration), and threadId().
         * - New methods in Future: resultNow(), exceptionNow(), and state().
         * - ExecutorService extends the AutoCloseable interface.
         * - The decommissioning of numerous ThreadGroup methods.
         *
         * For more explanations about Virtual Threads themselves, we may refer to Java 19 tutorial.
         */
    }
}