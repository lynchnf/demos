package norman.demo.java;

import norman.demo.common.DemoBean;
import norman.demo.common.DemoBeanType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    private static final Random RANDOM = new Random();
    private static final String[] FOO_BAR = {"foo", "bar", "baz", "qux"};

    public static void main(String[] args) {
        LOGGER.debug("Starting Application");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            boolean exit = false;
            while (!exit) {
                exit = processLine(reader);
            }
        } catch (IOException e) {
            LOGGER.error("Error reading input.", e);
        }
    }

    private static boolean processLine(BufferedReader reader) throws IOException {
        boolean exit = false;
        System.out.println("Enter the type of bean to build (static,parm) or exit:");
        try {
            String line = reader.readLine();
            if (line.trim().equalsIgnoreCase("exit")) {
                System.out.println("Exiting application.");
                exit = true;
            } else {
                DemoBeanType type = DemoBeanType.valueOf(line.trim().toUpperCase());
                DemoBean bean = getBean(type);
                System.out.println(bean.toString());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid entry.");
        }
        return exit;
    }

    private static DemoBean getBean(DemoBeanType type) {
        // If this is a bean of type parm, generate a random parameter.
        if (type == DemoBeanType.PARM) {
            int x = RANDOM.nextInt(FOO_BAR.length);
            int y = RANDOM.nextInt(FOO_BAR.length);
            String parm = FOO_BAR[x] + " " + FOO_BAR[y];
            return DemoBean.sleepAndGet(type, parm);
        } else {
            return DemoBean.sleepAndGet(type);
        }
    }
}
