import implementations.UriBasedRepository;
import org.junit.Test;
import utils.RepositoryException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UriBasedRepositorySupportTest {


    @Test
    public void uriBasedRepositorySupportTest() {
        //Arrange
        String location = "https://ngspipes-remote-repository.herokuapp.com";
        UriBasedRepository uriBasedRepository = new UriBasedRepository();

        // Act
        boolean isSupported = uriBasedRepository.load(location, null);

        //Assert
        assertTrue(isSupported);
    }

    @Test(expected = RepositoryException.class)
    public void uriBasedRepositorySupportWithBadLocationTest() {
        //Arrange
        String location = "https://github1.com/ngspipes/tools";
        UriBasedRepository uriBasedRepository = new UriBasedRepository();

        // Act
        boolean isSupported = uriBasedRepository.load(location, null);

        //Assert
        assertFalse(isSupported);
    }

    @Test(expected = RepositoryException.class)
    public void uriBasedRepositorySupportWithGithubLocationTest() {
        //Arrange
        String location = "https://github.com/ngspipes/tools";
        UriBasedRepository uriBasedRepository = new UriBasedRepository();

        // Act
        boolean isSupported = uriBasedRepository.load(location, null);

        //Assert
        assertFalse(isSupported);
    }
}
