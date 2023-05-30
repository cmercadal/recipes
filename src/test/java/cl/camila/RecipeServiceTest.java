package cl.camila;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RecipeServiceTest {

    @Mock
    private HttpResponse httpResponse;

    @Test
    public void testHttpResponse() {
        // Create a mock StatusLine object
        StatusLine statusLineMock = mock(StatusLine.class);

        // Define the behavior of the mock StatusLine object
        when(statusLineMock.getStatusCode()).thenReturn(200);

        // Define the behavior of the mock HttpResponse object
        when(httpResponse.getStatusLine()).thenReturn(statusLineMock);

        // Perform assertions
        assertEquals(200, httpResponse.getStatusLine().getStatusCode());
    }

}
