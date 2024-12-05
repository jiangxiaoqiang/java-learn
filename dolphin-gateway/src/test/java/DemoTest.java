import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@ExtendWith({YourExtension.class})
public class DemoTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("this is setUpBeforeClass()...");
    }

    @BeforeEach
    public void setUp() throws Exception {
        System.out.println("this is setUp()...");
    }

    @Test
    void addition() {
        assertEquals(2, 1+1);
    }
}
