import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import org.junit.*;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void getLinks() throws IOException {
        Path fileName = Path.of("test-file.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        System.out.println(links);
        assertEquals(List.of("https://something.com", "some-page.html"), links);
    }

    @Test
    public void getLinks2() throws IOException {
        Path fileName = Path.of("test-file-2.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        System.out.println(links);
        assertEquals(List.of("link.(com"), links);
    }

    @Test
    public void getLinks3() throws IOException {
        Path fileName = Path.of("test-file-3.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        System.out.println(links);
        assertEquals(List.of("link.com"), links);
    }

    @Test
    public void getLinks4() throws IOException {
        Path fileName = Path.of("test-file-4.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        System.out.println(links);
        assertEquals(List.of("link.com"), links);
    }

    @Test
    public void getLinksImage() throws IOException {
        Path fileName = Path.of("image-test.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        System.out.println(links);
        assertEquals(new ArrayList<>(List.of()), links);
    }

    // Lab Report 4 Tests

    @Test
    public void getLinks5() throws IOException {
        Path fileName = Path.of("test-snippet-1.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        System.out.println(links);
        assertEquals(List.of("`google.com", "google.com", "ucsd.edu"), links);
    }

    @Test
    public void getLinks6() throws IOException {
        Path fileName = Path.of("test-snippet-2.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        System.out.println(links);
        assertEquals(List.of("a.com", "a.com((", "example.com"), links);
    }

    @Test
    public void getLinks7() throws IOException {
        Path fileName = Path.of("test-snippet-3.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        System.out.println(links);
        assertEquals(List.of("https://ucsd-cse15l-w22.github.io/"), links);
    }
}