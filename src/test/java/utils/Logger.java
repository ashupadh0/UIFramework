package utils;

import org.apache.logging.log4j.LogManager;

public class Logger {

        public static org.apache.logging.log4j.Logger Log = LogManager.getLogger(Logger.class.getName());

        public static void startTestCase(String sTestCaseName) {
            Log.info("Started Test case");
        }
        public static void endTestCase(String sTestCaseName) {
            Log.info("Ended Test Case");
        }
        public static void info(String message) {
            Log.info(message);
        }
        public static void warn(String message) {
            Log.warn(message);
        }
    }

