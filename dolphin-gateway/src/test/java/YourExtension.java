import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class YourExtension implements BeforeAllCallback, ExtensionContext.Store.CloseableResource {

    private static boolean started = false;

    @Override
    public void beforeAll(ExtensionContext context) {
        if (!started) {
            started = true;
        }
    }

    @Override
    public void close() {
        // Your "after all tests" logic goes here
    }
}