import implementations.GithubRepository;
import org.junit.Test;

import static org.junit.Assert.*;

public class GitHubRepositorySupportTest {


    @Test
    public void githubRepositorySupportTest() {
        //Arrange
        String location = "https://github.com/ngspipes/tools";
        GithubRepository githubRepository = new GithubRepository();

        // Act
        boolean isSupported = githubRepository.load(location, null);

        //Assert
        assertTrue(isSupported);
    }

    @Test
    public void githubRepositorySupportWithBadLocationTest() {
        //Arrange
        String location = "https://github1.com/ngspipes/tools";
        GithubRepository githubRepository = new GithubRepository();

        // Act
        boolean isSupported = githubRepository.load(location, null);

        //Assert
        assertFalse(isSupported);
    }
}
